// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: User.proto

package grpc.UserService;

public interface LoginResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.smartagri.user.LoginResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool success = 1;</code>
   * @return The success.
   */
  boolean getSuccess();

  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>string token = 3;</code>
   * @return The token.
   */
  java.lang.String getToken();
  /**
   * <code>string token = 3;</code>
   * @return The bytes for token.
   */
  com.google.protobuf.ByteString
      getTokenBytes();
}