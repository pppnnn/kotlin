// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: compiler/ir/serialization.common/src/KotlinIr.proto

package org.jetbrains.kotlin.backend.common.serialization.proto;

/**
 * Protobuf type {@code org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable}
 */
public final class IrTypeTable extends
    org.jetbrains.kotlin.protobuf.GeneratedMessageLite implements
    // @@protoc_insertion_point(message_implements:org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable)
    IrTypeTableOrBuilder {
  // Use IrTypeTable.newBuilder() to construct.
  private IrTypeTable(org.jetbrains.kotlin.protobuf.GeneratedMessageLite.Builder builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private IrTypeTable(boolean noInit) { this.unknownFields = org.jetbrains.kotlin.protobuf.ByteString.EMPTY;}

  private static final IrTypeTable defaultInstance;
  public static IrTypeTable getDefaultInstance() {
    return defaultInstance;
  }

  public IrTypeTable getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final org.jetbrains.kotlin.protobuf.ByteString unknownFields;
  private IrTypeTable(
      org.jetbrains.kotlin.protobuf.CodedInputStream input,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    org.jetbrains.kotlin.protobuf.ByteString.Output unknownFieldsOutput =
        org.jetbrains.kotlin.protobuf.ByteString.newOutput();
    org.jetbrains.kotlin.protobuf.CodedOutputStream unknownFieldsCodedOutput =
        org.jetbrains.kotlin.protobuf.CodedOutputStream.newInstance(
            unknownFieldsOutput);
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFieldsCodedOutput,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              types_ = new java.util.ArrayList<org.jetbrains.kotlin.backend.common.serialization.proto.IrType>();
              mutable_bitField0_ |= 0x00000001;
            }
            types_.add(input.readMessage(org.jetbrains.kotlin.backend.common.serialization.proto.IrType.PARSER, extensionRegistry));
            break;
          }
        }
      }
    } catch (org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        types_ = java.util.Collections.unmodifiableList(types_);
      }
      try {
        unknownFieldsCodedOutput.flush();
      } catch (java.io.IOException e) {
      // Should not happen
      } finally {
        unknownFields = unknownFieldsOutput.toByteString();
      }
      makeExtensionsImmutable();
    }
  }
  public static org.jetbrains.kotlin.protobuf.Parser<IrTypeTable> PARSER =
      new org.jetbrains.kotlin.protobuf.AbstractParser<IrTypeTable>() {
    public IrTypeTable parsePartialFrom(
        org.jetbrains.kotlin.protobuf.CodedInputStream input,
        org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
        throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
      return new IrTypeTable(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public org.jetbrains.kotlin.protobuf.Parser<IrTypeTable> getParserForType() {
    return PARSER;
  }

  public static final int TYPES_FIELD_NUMBER = 1;
  private java.util.List<org.jetbrains.kotlin.backend.common.serialization.proto.IrType> types_;
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
   */
  public java.util.List<org.jetbrains.kotlin.backend.common.serialization.proto.IrType> getTypesList() {
    return types_;
  }
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
   */
  public java.util.List<? extends org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeOrBuilder> 
      getTypesOrBuilderList() {
    return types_;
  }
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
   */
  public int getTypesCount() {
    return types_.size();
  }
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
   */
  public org.jetbrains.kotlin.backend.common.serialization.proto.IrType getTypes(int index) {
    return types_.get(index);
  }
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
   */
  public org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeOrBuilder getTypesOrBuilder(
      int index) {
    return types_.get(index);
  }

  private void initFields() {
    types_ = java.util.Collections.emptyList();
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    for (int i = 0; i < getTypesCount(); i++) {
      if (!getTypes(i).isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(org.jetbrains.kotlin.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    for (int i = 0; i < types_.size(); i++) {
      output.writeMessage(1, types_.get(i));
    }
    output.writeRawBytes(unknownFields);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < types_.size(); i++) {
      size += org.jetbrains.kotlin.protobuf.CodedOutputStream
        .computeMessageSize(1, types_.get(i));
    }
    size += unknownFields.size();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseFrom(
      org.jetbrains.kotlin.protobuf.ByteString data)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseFrom(
      org.jetbrains.kotlin.protobuf.ByteString data,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseFrom(byte[] data)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseFrom(
      byte[] data,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseFrom(
      java.io.InputStream input,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseDelimitedFrom(
      java.io.InputStream input,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseFrom(
      org.jetbrains.kotlin.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parseFrom(
      org.jetbrains.kotlin.protobuf.CodedInputStream input,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  /**
   * Protobuf type {@code org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable}
   */
  public static final class Builder extends
      org.jetbrains.kotlin.protobuf.GeneratedMessageLite.Builder<
        org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable, Builder>
      implements
      // @@protoc_insertion_point(builder_implements:org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable)
      org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTableOrBuilder {
    // Construct using org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      types_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable getDefaultInstanceForType() {
      return org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable.getDefaultInstance();
    }

    public org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable build() {
      org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable buildPartial() {
      org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable result = new org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        types_ = java.util.Collections.unmodifiableList(types_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.types_ = types_;
      return result;
    }

    public Builder mergeFrom(org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable other) {
      if (other == org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable.getDefaultInstance()) return this;
      if (!other.types_.isEmpty()) {
        if (types_.isEmpty()) {
          types_ = other.types_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureTypesIsMutable();
          types_.addAll(other.types_);
        }
        
      }
      setUnknownFields(
          getUnknownFields().concat(other.unknownFields));
      return this;
    }

    public final boolean isInitialized() {
      for (int i = 0; i < getTypesCount(); i++) {
        if (!getTypes(i).isInitialized()) {
          
          return false;
        }
      }
      return true;
    }

    public Builder mergeFrom(
        org.jetbrains.kotlin.protobuf.CodedInputStream input,
        org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<org.jetbrains.kotlin.backend.common.serialization.proto.IrType> types_ =
      java.util.Collections.emptyList();
    private void ensureTypesIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        types_ = new java.util.ArrayList<org.jetbrains.kotlin.backend.common.serialization.proto.IrType>(types_);
        bitField0_ |= 0x00000001;
       }
    }

    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public java.util.List<org.jetbrains.kotlin.backend.common.serialization.proto.IrType> getTypesList() {
      return java.util.Collections.unmodifiableList(types_);
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public int getTypesCount() {
      return types_.size();
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public org.jetbrains.kotlin.backend.common.serialization.proto.IrType getTypes(int index) {
      return types_.get(index);
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public Builder setTypes(
        int index, org.jetbrains.kotlin.backend.common.serialization.proto.IrType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureTypesIsMutable();
      types_.set(index, value);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public Builder setTypes(
        int index, org.jetbrains.kotlin.backend.common.serialization.proto.IrType.Builder builderForValue) {
      ensureTypesIsMutable();
      types_.set(index, builderForValue.build());

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public Builder addTypes(org.jetbrains.kotlin.backend.common.serialization.proto.IrType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureTypesIsMutable();
      types_.add(value);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public Builder addTypes(
        int index, org.jetbrains.kotlin.backend.common.serialization.proto.IrType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureTypesIsMutable();
      types_.add(index, value);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public Builder addTypes(
        org.jetbrains.kotlin.backend.common.serialization.proto.IrType.Builder builderForValue) {
      ensureTypesIsMutable();
      types_.add(builderForValue.build());

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public Builder addTypes(
        int index, org.jetbrains.kotlin.backend.common.serialization.proto.IrType.Builder builderForValue) {
      ensureTypesIsMutable();
      types_.add(index, builderForValue.build());

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public Builder addAllTypes(
        java.lang.Iterable<? extends org.jetbrains.kotlin.backend.common.serialization.proto.IrType> values) {
      ensureTypesIsMutable();
      org.jetbrains.kotlin.protobuf.AbstractMessageLite.Builder.addAll(
          values, types_);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public Builder clearTypes() {
      types_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrType types = 1;</code>
     */
    public Builder removeTypes(int index) {
      ensureTypesIsMutable();
      types_.remove(index);

      return this;
    }

    // @@protoc_insertion_point(builder_scope:org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable)
  }

  static {
    defaultInstance = new IrTypeTable(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:org.jetbrains.kotlin.backend.common.serialization.proto.IrTypeTable)
}