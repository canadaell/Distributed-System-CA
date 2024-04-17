package grpc.SensorService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: Sensor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SensorServiceGrpc {

  private SensorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.smartagri.sensor.SensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.SensorService.SensorRequest,
      grpc.SensorService.SensorResponse> getStreamSensorDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamSensorData",
      requestType = grpc.SensorService.SensorRequest.class,
      responseType = grpc.SensorService.SensorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.SensorService.SensorRequest,
      grpc.SensorService.SensorResponse> getStreamSensorDataMethod() {
    io.grpc.MethodDescriptor<grpc.SensorService.SensorRequest, grpc.SensorService.SensorResponse> getStreamSensorDataMethod;
    if ((getStreamSensorDataMethod = SensorServiceGrpc.getStreamSensorDataMethod) == null) {
      synchronized (SensorServiceGrpc.class) {
        if ((getStreamSensorDataMethod = SensorServiceGrpc.getStreamSensorDataMethod) == null) {
          SensorServiceGrpc.getStreamSensorDataMethod = getStreamSensorDataMethod =
              io.grpc.MethodDescriptor.<grpc.SensorService.SensorRequest, grpc.SensorService.SensorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamSensorData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SensorService.SensorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SensorService.SensorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SensorServiceMethodDescriptorSupplier("StreamSensorData"))
              .build();
        }
      }
    }
    return getStreamSensorDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.SensorService.SensorRequest,
      grpc.SensorService.SensorResponse> getGetSensorDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSensorData",
      requestType = grpc.SensorService.SensorRequest.class,
      responseType = grpc.SensorService.SensorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.SensorService.SensorRequest,
      grpc.SensorService.SensorResponse> getGetSensorDataMethod() {
    io.grpc.MethodDescriptor<grpc.SensorService.SensorRequest, grpc.SensorService.SensorResponse> getGetSensorDataMethod;
    if ((getGetSensorDataMethod = SensorServiceGrpc.getGetSensorDataMethod) == null) {
      synchronized (SensorServiceGrpc.class) {
        if ((getGetSensorDataMethod = SensorServiceGrpc.getGetSensorDataMethod) == null) {
          SensorServiceGrpc.getGetSensorDataMethod = getGetSensorDataMethod =
              io.grpc.MethodDescriptor.<grpc.SensorService.SensorRequest, grpc.SensorService.SensorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSensorData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SensorService.SensorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SensorService.SensorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SensorServiceMethodDescriptorSupplier("getSensorData"))
              .build();
        }
      }
    }
    return getGetSensorDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SensorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorServiceStub>() {
        @java.lang.Override
        public SensorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorServiceStub(channel, callOptions);
        }
      };
    return SensorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorServiceBlockingStub>() {
        @java.lang.Override
        public SensorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorServiceBlockingStub(channel, callOptions);
        }
      };
    return SensorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorServiceFutureStub>() {
        @java.lang.Override
        public SensorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorServiceFutureStub(channel, callOptions);
        }
      };
    return SensorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void streamSensorData(grpc.SensorService.SensorRequest request,
        io.grpc.stub.StreamObserver<grpc.SensorService.SensorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamSensorDataMethod(), responseObserver);
    }

    /**
     */
    default void getSensorData(grpc.SensorService.SensorRequest request,
        io.grpc.stub.StreamObserver<grpc.SensorService.SensorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSensorDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SensorService.
   */
  public static abstract class SensorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SensorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SensorService.
   */
  public static final class SensorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SensorServiceStub> {
    private SensorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorServiceStub(channel, callOptions);
    }

    /**
     */
    public void streamSensorData(grpc.SensorService.SensorRequest request,
        io.grpc.stub.StreamObserver<grpc.SensorService.SensorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamSensorDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSensorData(grpc.SensorService.SensorRequest request,
        io.grpc.stub.StreamObserver<grpc.SensorService.SensorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSensorDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SensorService.
   */
  public static final class SensorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SensorServiceBlockingStub> {
    private SensorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.SensorService.SensorResponse> streamSensorData(
        grpc.SensorService.SensorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamSensorDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.SensorService.SensorResponse getSensorData(grpc.SensorService.SensorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSensorDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SensorService.
   */
  public static final class SensorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SensorServiceFutureStub> {
    private SensorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.SensorService.SensorResponse> getSensorData(
        grpc.SensorService.SensorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSensorDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_SENSOR_DATA = 0;
  private static final int METHODID_GET_SENSOR_DATA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_SENSOR_DATA:
          serviceImpl.streamSensorData((grpc.SensorService.SensorRequest) request,
              (io.grpc.stub.StreamObserver<grpc.SensorService.SensorResponse>) responseObserver);
          break;
        case METHODID_GET_SENSOR_DATA:
          serviceImpl.getSensorData((grpc.SensorService.SensorRequest) request,
              (io.grpc.stub.StreamObserver<grpc.SensorService.SensorResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStreamSensorDataMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              grpc.SensorService.SensorRequest,
              grpc.SensorService.SensorResponse>(
                service, METHODID_STREAM_SENSOR_DATA)))
        .addMethod(
          getGetSensorDataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.SensorService.SensorRequest,
              grpc.SensorService.SensorResponse>(
                service, METHODID_GET_SENSOR_DATA)))
        .build();
  }

  private static abstract class SensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.SensorService.SensorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SensorService");
    }
  }

  private static final class SensorServiceFileDescriptorSupplier
      extends SensorServiceBaseDescriptorSupplier {
    SensorServiceFileDescriptorSupplier() {}
  }

  private static final class SensorServiceMethodDescriptorSupplier
      extends SensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SensorServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SensorServiceFileDescriptorSupplier())
              .addMethod(getStreamSensorDataMethod())
              .addMethod(getGetSensorDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
