// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Irrigation.proto

package grpc.IrrigationService;

public final class IrrigationProto {
  private IrrigationProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_smartagri_Irrigation_IrrigationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_smartagri_Irrigation_IrrigationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_smartagri_Irrigation_IrrigationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_smartagri_Irrigation_IrrigationResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020Irrigation.proto\022\030com.smartagri.Irriga" +
      "tion\"5\n\021IrrigationRequest\022\020\n\010district\030\001 " +
      "\001(\t\022\016\n\006farmid\030\002 \001(\t\"G\n\022IrrigationRespons" +
      "e\022\017\n\007success\030\001 \001(\010\022\016\n\006volume\030\002 \001(\t\022\020\n\010hu" +
      "midity\030\003 \001(\0012w\n\nEnviroment\022i\n\nIrrigation" +
      "\022+.com.smartagri.Irrigation.IrrigationRe" +
      "quest\032,.com.smartagri.Irrigation.Irrigat" +
      "ionResponse(\001B+\n\026grpc.IrrigationServiceB" +
      "\017IrrigationProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_smartagri_Irrigation_IrrigationRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_smartagri_Irrigation_IrrigationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_smartagri_Irrigation_IrrigationRequest_descriptor,
        new java.lang.String[] { "District", "Farmid", });
    internal_static_com_smartagri_Irrigation_IrrigationResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_smartagri_Irrigation_IrrigationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_smartagri_Irrigation_IrrigationResponse_descriptor,
        new java.lang.String[] { "Success", "Volume", "Humidity", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
