package grpc.IrrigationService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: Irrigation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IrrigationServiceGrpc {

  private IrrigationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.smartagri.irrigation.IrrigationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.IrrigationService.IrrigationRequest,
      grpc.IrrigationService.IrrigationResponse> getStartIrrigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartIrrigation",
      requestType = grpc.IrrigationService.IrrigationRequest.class,
      responseType = grpc.IrrigationService.IrrigationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.IrrigationService.IrrigationRequest,
      grpc.IrrigationService.IrrigationResponse> getStartIrrigationMethod() {
    io.grpc.MethodDescriptor<grpc.IrrigationService.IrrigationRequest, grpc.IrrigationService.IrrigationResponse> getStartIrrigationMethod;
    if ((getStartIrrigationMethod = IrrigationServiceGrpc.getStartIrrigationMethod) == null) {
      synchronized (IrrigationServiceGrpc.class) {
        if ((getStartIrrigationMethod = IrrigationServiceGrpc.getStartIrrigationMethod) == null) {
          IrrigationServiceGrpc.getStartIrrigationMethod = getStartIrrigationMethod =
              io.grpc.MethodDescriptor.<grpc.IrrigationService.IrrigationRequest, grpc.IrrigationService.IrrigationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartIrrigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.IrrigationService.IrrigationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.IrrigationService.IrrigationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IrrigationServiceMethodDescriptorSupplier("StartIrrigation"))
              .build();
        }
      }
    }
    return getStartIrrigationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.IrrigationService.IrrigationRequest,
      grpc.IrrigationService.IrrigationResponse> getStopIrrigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopIrrigation",
      requestType = grpc.IrrigationService.IrrigationRequest.class,
      responseType = grpc.IrrigationService.IrrigationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.IrrigationService.IrrigationRequest,
      grpc.IrrigationService.IrrigationResponse> getStopIrrigationMethod() {
    io.grpc.MethodDescriptor<grpc.IrrigationService.IrrigationRequest, grpc.IrrigationService.IrrigationResponse> getStopIrrigationMethod;
    if ((getStopIrrigationMethod = IrrigationServiceGrpc.getStopIrrigationMethod) == null) {
      synchronized (IrrigationServiceGrpc.class) {
        if ((getStopIrrigationMethod = IrrigationServiceGrpc.getStopIrrigationMethod) == null) {
          IrrigationServiceGrpc.getStopIrrigationMethod = getStopIrrigationMethod =
              io.grpc.MethodDescriptor.<grpc.IrrigationService.IrrigationRequest, grpc.IrrigationService.IrrigationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopIrrigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.IrrigationService.IrrigationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.IrrigationService.IrrigationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IrrigationServiceMethodDescriptorSupplier("StopIrrigation"))
              .build();
        }
      }
    }
    return getStopIrrigationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IrrigationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceStub>() {
        @java.lang.Override
        public IrrigationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IrrigationServiceStub(channel, callOptions);
        }
      };
    return IrrigationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IrrigationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceBlockingStub>() {
        @java.lang.Override
        public IrrigationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IrrigationServiceBlockingStub(channel, callOptions);
        }
      };
    return IrrigationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IrrigationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceFutureStub>() {
        @java.lang.Override
        public IrrigationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IrrigationServiceFutureStub(channel, callOptions);
        }
      };
    return IrrigationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void startIrrigation(grpc.IrrigationService.IrrigationRequest request,
        io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartIrrigationMethod(), responseObserver);
    }

    /**
     */
    default void stopIrrigation(grpc.IrrigationService.IrrigationRequest request,
        io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopIrrigationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IrrigationService.
   */
  public static abstract class IrrigationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return IrrigationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IrrigationService.
   */
  public static final class IrrigationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IrrigationServiceStub> {
    private IrrigationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IrrigationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IrrigationServiceStub(channel, callOptions);
    }

    /**
     */
    public void startIrrigation(grpc.IrrigationService.IrrigationRequest request,
        io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartIrrigationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopIrrigation(grpc.IrrigationService.IrrigationRequest request,
        io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopIrrigationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IrrigationService.
   */
  public static final class IrrigationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IrrigationServiceBlockingStub> {
    private IrrigationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IrrigationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IrrigationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.IrrigationService.IrrigationResponse startIrrigation(grpc.IrrigationService.IrrigationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartIrrigationMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.IrrigationService.IrrigationResponse stopIrrigation(grpc.IrrigationService.IrrigationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopIrrigationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service IrrigationService.
   */
  public static final class IrrigationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IrrigationServiceFutureStub> {
    private IrrigationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IrrigationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IrrigationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.IrrigationService.IrrigationResponse> startIrrigation(
        grpc.IrrigationService.IrrigationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartIrrigationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.IrrigationService.IrrigationResponse> stopIrrigation(
        grpc.IrrigationService.IrrigationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopIrrigationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_IRRIGATION = 0;
  private static final int METHODID_STOP_IRRIGATION = 1;

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
        case METHODID_START_IRRIGATION:
          serviceImpl.startIrrigation((grpc.IrrigationService.IrrigationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationResponse>) responseObserver);
          break;
        case METHODID_STOP_IRRIGATION:
          serviceImpl.stopIrrigation((grpc.IrrigationService.IrrigationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationResponse>) responseObserver);
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
          getStartIrrigationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.IrrigationService.IrrigationRequest,
              grpc.IrrigationService.IrrigationResponse>(
                service, METHODID_START_IRRIGATION)))
        .addMethod(
          getStopIrrigationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.IrrigationService.IrrigationRequest,
              grpc.IrrigationService.IrrigationResponse>(
                service, METHODID_STOP_IRRIGATION)))
        .build();
  }

  private static abstract class IrrigationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IrrigationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.IrrigationService.IrrigationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IrrigationService");
    }
  }

  private static final class IrrigationServiceFileDescriptorSupplier
      extends IrrigationServiceBaseDescriptorSupplier {
    IrrigationServiceFileDescriptorSupplier() {}
  }

  private static final class IrrigationServiceMethodDescriptorSupplier
      extends IrrigationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IrrigationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IrrigationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IrrigationServiceFileDescriptorSupplier())
              .addMethod(getStartIrrigationMethod())
              .addMethod(getStopIrrigationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
