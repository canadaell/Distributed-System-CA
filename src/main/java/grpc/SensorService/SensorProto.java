// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Sensor.proto

package grpc.SensorService;

public final class SensorProto {
  private SensorProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_smartagri_sensor_SensorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_smartagri_sensor_SensorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_smartagri_sensor_SensorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_smartagri_sensor_SensorResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Sensor.proto\022\024com.smartagri.sensor\032\037go" +
      "ogle/protobuf/timestamp.proto\"1\n\rSensorR" +
      "equest\022\016\n\006farmid\030\001 \001(\t\022\020\n\010sensorid\030\002 \001(\t" +
      "\"^\n\016SensorResponse\022\022\n\ntempreture\030\001 \001(\001\022\020" +
      "\n\010humidity\030\002 \001(\001\022\020\n\010district\030\003 \001(\t\022\024\n\014il" +
      "lumination\030\004 \001(\0012\314\001\n\rSensorService\022_\n\020St" +
      "reamSensorData\022#.com.smartagri.sensor.Se" +
      "nsorRequest\032$.com.smartagri.sensor.Senso" +
      "rResponse0\001\022Z\n\rgetSensorData\022#.com.smart" +
      "agri.sensor.SensorRequest\032$.com.smartagr" +
      "i.sensor.SensorResponseB#\n\022grpc.SensorSe" +
      "rviceB\013SensorProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_com_smartagri_sensor_SensorRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_smartagri_sensor_SensorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_smartagri_sensor_SensorRequest_descriptor,
        new java.lang.String[] { "Farmid", "Sensorid", });
    internal_static_com_smartagri_sensor_SensorResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_smartagri_sensor_SensorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_smartagri_sensor_SensorResponse_descriptor,
        new java.lang.String[] { "Tempreture", "Humidity", "District", "Illumination", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
