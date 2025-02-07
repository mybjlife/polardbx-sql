// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DumperServer.proto

package com.alibaba.polardbx.rpc.cdc;

public interface DumpRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dumper.DumpRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string fileName = 1;</code>
   * @return The fileName.
   */
  java.lang.String getFileName();
  /**
   * <code>string fileName = 1;</code>
   * @return The bytes for fileName.
   */
  com.google.protobuf.ByteString
      getFileNameBytes();

  /**
   * <code>int64 position = 2;</code>
   * @return The position.
   */
  long getPosition();

  /**
   * <code>.dumper.EventSplitMode splitMode = 3;</code>
   * @return The enum numeric value on the wire for splitMode.
   */
  int getSplitModeValue();
  /**
   * <code>.dumper.EventSplitMode splitMode = 3;</code>
   * @return The splitMode.
   */
  com.alibaba.polardbx.rpc.cdc.EventSplitMode getSplitMode();

  /**
   * <code>bool registered = 4;</code>
   * @return The registered.
   */
  boolean getRegistered();

  /**
   * <code>string ext = 5;</code>
   * @return The ext.
   */
  java.lang.String getExt();
  /**
   * <code>string ext = 5;</code>
   * @return The bytes for ext.
   */
  com.google.protobuf.ByteString
      getExtBytes();

  /**
   * <code>string streamName = 6;</code>
   * @return The streamName.
   */
  java.lang.String getStreamName();
  /**
   * <code>string streamName = 6;</code>
   * @return The bytes for streamName.
   */
  com.google.protobuf.ByteString
      getStreamNameBytes();
}
