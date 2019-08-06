package org.jetbrains.kotlin.incremental.klib

import org.jetbrains.kotlin.build.GeneratedFile
import org.jetbrains.kotlin.cli.common.ExitCode
import org.jetbrains.kotlin.cli.common.arguments.K2JSCompilerArguments
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.cli.js.K2JSCompiler
import org.jetbrains.kotlin.config.IncrementalCompilation
import org.jetbrains.kotlin.config.Services
import org.jetbrains.kotlin.incremental.*
import org.jetbrains.kotlin.incremental.ChangesEither
import org.jetbrains.kotlin.incremental.components.ExpectActualTracker
import org.jetbrains.kotlin.incremental.components.LookupTracker
import org.jetbrains.kotlin.incremental.getClasspathChanges
import org.jetbrains.kotlin.incremental.js.IncrementalDataProvider
import org.jetbrains.kotlin.incremental.js.IncrementalDataProviderFromCache
import org.jetbrains.kotlin.incremental.js.IncrementalResultsConsumer
import org.jetbrains.kotlin.incremental.js.IncrementalResultsConsumerImpl
import org.jetbrains.kotlin.incremental.multiproject.ModulesApiHistory
import java.io.File

class IncrementalJsKlibCompilerRunner(
    workingDir: File,
    reporter: ICReporter,
    buildHistoryFile: File,
    private val modulesApiHistory: ModulesApiHistory
) : IncrementalCompilerRunner<K2JSCompilerArguments, IncrementalJsCachesManager>(
    workingDir,
    "caches-js-klib",
    reporter,
    buildHistoryFile = buildHistoryFile
) {
    override fun isICEnabled(): Boolean =
        IncrementalCompilation.isEnabledForJs()

    override fun createCacheManager(args: K2JSCompilerArguments): IncrementalJsCachesManager =
        IncrementalJsCachesManager(cacheDirectory, reporter)

    override fun destinationDir(args: K2JSCompilerArguments): File =
        File(args.outputFile).parentFile

    override fun calculateSourcesToCompile(
        caches: IncrementalJsCachesManager,
        changedFiles: ChangedFiles.Known,
        args: K2JSCompilerArguments
    ): CompilationMode {
        val lastBuildInfo = BuildInfo.read(lastBuildInfoFile)
            ?: return CompilationMode.Rebuild { "No information on previous build" }

        val dirtyFiles = DirtyFilesContainer(caches, reporter, kotlinSourceFilesExtensions)
        initDirtyFiles(dirtyFiles, changedFiles)

        val libs = (args.libraries ?: "").split(File.pathSeparator).map { File(it) }
        val classpathChanges =
            getClasspathChanges(libs, changedFiles, lastBuildInfo, modulesApiHistory, reporter)

        @Suppress("UNUSED_VARIABLE") // for sealed when
        val unused = when (classpathChanges) {
            is ChangesEither.Unknown -> return CompilationMode.Rebuild {
                // todo: we can recompile all files incrementally (not cleaning caches), so rebuild won't propagate
                "Could not get classpath's changes${classpathChanges.reason?.let { ": $it" }}"
            }
            is ChangesEither.Known -> {
                dirtyFiles.addByDirtySymbols(classpathChanges.lookupSymbols)
                dirtyFiles.addByDirtyClasses(classpathChanges.fqNames)
            }
        }


        val removedClassesChanges = getRemovedClassesChanges(caches, changedFiles)
        dirtyFiles.addByDirtySymbols(removedClassesChanges.dirtyLookupSymbols)
        dirtyFiles.addByDirtyClasses(removedClassesChanges.dirtyClassesFqNames)

        return CompilationMode.Incremental(dirtyFiles)
    }

    override fun makeServices(
        args: K2JSCompilerArguments,
        lookupTracker: LookupTracker,
        expectActualTracker: ExpectActualTracker,
        caches: IncrementalJsCachesManager,
        compilationMode: CompilationMode
    ): Services.Builder =
        super.makeServices(args, lookupTracker, expectActualTracker, caches, compilationMode).apply {
            register(
                IncrementalResultsConsumer::class.java,
                IncrementalResultsConsumerImpl()
            )

            if (compilationMode is CompilationMode.Incremental) {
                register(
                    IncrementalDataProvider::class.java,
                    IncrementalDataProviderFromCache(caches.platformCache)
                )
            }
        }

    override fun updateCaches(
        services: Services,
        caches: IncrementalJsCachesManager,
        generatedFiles: List<GeneratedFile>,
        changesCollector: ChangesCollector
    ) {
        val incrementalResults = services.get(IncrementalResultsConsumer::class.java) as IncrementalResultsConsumerImpl

        val jsCache = caches.platformCache
        jsCache.header = incrementalResults.headerMetadata

        jsCache.compareAndUpdate(incrementalResults, changesCollector)
        jsCache.clearCacheForRemovedClasses(changesCollector)
    }

    override fun runCompiler(
        sourcesToCompile: Set<File>,
        args: K2JSCompilerArguments,
        caches: IncrementalJsCachesManager,
        services: Services,
        messageCollector: MessageCollector
    ): ExitCode {
        val freeArgsBackup = args.freeArgs

        return try {
            args.freeArgs += sourcesToCompile.map { it.absolutePath }
            K2JSCompiler().exec(messageCollector, services, args)
        } finally {
            args.freeArgs = freeArgsBackup
        }
    }

    private val ChangedFiles.Known.allAsSequence: Sequence<File>
        get() = modified.asSequence() + removed.asSequence()
}