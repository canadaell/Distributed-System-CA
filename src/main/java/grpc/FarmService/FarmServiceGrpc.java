package grpc.FarmService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: Farm.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FarmServiceGrpc {

  private FarmServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.smartagri.farm.FarmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.FarmService.FarmRequest,
      grpc.FarmService.FarmResponse> getAddFarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddFarm",
      requestType = grpc.FarmService.FarmRequest.class,
      responseType = grpc.FarmService.FarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.FarmService.FarmRequest,
      grpc.FarmService.FarmResponse> getAddFarmMethod() {
    io.grpc.MethodDescriptor<grpc.FarmService.FarmRequest, grpc.FarmService.FarmResponse> getAddFarmMethod;
    if ((getAddFarmMethod = FarmServiceGrpc.getAddFarmMethod) == null) {
      synchronized (FarmServiceGrpc.class) {
        if ((getAddFarmMethod = FarmServiceGrpc.getAddFarmMethod) == null) {
          FarmServiceGrpc.getAddFarmMethod = getAddFarmMethod =
              io.grpc.MethodDescriptor.<grpc.FarmService.FarmRequest, grpc.FarmService.FarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddFarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.FarmService.FarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.FarmService.FarmResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FarmServiceMethodDescriptorSupplier("AddFarm"))
              .build();
        }
      }
    }
    return getAddFarmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.FarmService.FarmRequest,
      grpc.FarmService.FarmResponse> getGetFarmDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFarmDetails",
      requestType = grpc.FarmService.FarmRequest.class,
      responseType = grpc.FarmService.FarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.FarmService.FarmRequest,
      grpc.FarmService.FarmResponse> getGetFarmDetailsMethod() {
    io.grpc.MethodDescriptor<grpc.FarmService.FarmRequest, grpc.FarmService.FarmResponse> getGetFarmDetailsMethod;
    if ((getGetFarmDetailsMethod = FarmServiceGrpc.getGetFarmDetailsMethod) == null) {
      synchronized (FarmServiceGrpc.class) {
        if ((getGetFarmDetailsMethod = FarmServiceGrpc.getGetFarmDetailsMethod) == null) {
          FarmServiceGrpc.getGetFarmDetailsMethod = getGetFarmDetailsMethod =
              io.grpc.MethodDescriptor.<grpc.FarmService.FarmRequest, grpc.FarmService.FarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFarmDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.FarmService.FarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.FarmService.FarmResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FarmServiceMethodDescriptorSupplier("GetFarmDetails"))
              .build();
        }
      }
    }
    return getGetFarmDetailsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FarmServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FarmServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FarmServiceStub>() {
        @java.lang.Override
        public FarmServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FarmServiceStub(channel, callOptions);
        }
      };
    return FarmServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FarmServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FarmServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FarmServiceBlockingStub>() {
        @java.lang.Override
        public FarmServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FarmServiceBlockingStub(channel, callOptions);
        }
      };
    return FarmServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FarmServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FarmServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FarmServiceFutureStub>() {
        @java.lang.Override
        public FarmServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FarmServiceFutureStub(channel, callOptions);
        }
      };
    return FarmServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addFarm(grpc.FarmService.FarmRequest request,
        io.grpc.stub.StreamObserver<grpc.FarmService.FarmResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddFarmMethod(), responseObserver);
    }

    /**
     */
    default void getFarmDetails(grpc.FarmService.FarmRequest request,
        io.grpc.stub.StreamObserver<grpc.FarmService.FarmResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFarmDetailsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FarmService.
   */
  public static abstract class FarmServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FarmServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FarmService.
   */
  public static final class FarmServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FarmServiceStub> {
    private FarmServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FarmServiceStub(channel, callOptions);
    }

    /**
     */
    public void addFarm(grpc.FarmService.FarmRequest request,
        io.grpc.stub.StreamObserver<grpc.FarmService.FarmResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddFarmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFarmDetails(grpc.FarmService.FarmRequest request,
        io.grpc.stub.StreamObserver<grpc.FarmService.FarmResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFarmDetailsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FarmService.
   */
  public static final class FarmServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FarmServiceBlockingStub> {
    private FarmServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FarmServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.FarmService.FarmResponse addFarm(grpc.FarmService.FarmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddFarmMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.FarmService.FarmResponse getFarmDetails(grpc.FarmService.FarmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFarmDetailsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FarmService.
   */
  public static final class FarmServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FarmServiceFutureStub> {
    private FarmServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FarmServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.FarmService.FarmResponse> addFarm(
        grpc.FarmService.FarmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddFarmMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.FarmService.FarmResponse> getFarmDetails(
        grpc.FarmService.FarmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFarmDetailsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_FARM = 0;
  private static final int METHODID_GET_FARM_DETAILS = 1;

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
        case METHODID_ADD_FARM:
          serviceImpl.addFarm((grpc.FarmService.FarmRequest) request,
              (io.grpc.stub.StreamObserver<grpc.FarmService.FarmResponse>) responseObserver);
          break;
        case METHODID_GET_FARM_DETAILS:
          serviceImpl.getFarmDetails((grpc.FarmService.FarmRequest) request,
              (io.grpc.stub.StreamObserver<grpc.FarmService.FarmResponse>) responseObserver);
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
          getAddFarmMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.FarmService.FarmRequest,
              grpc.FarmService.FarmResponse>(
                service, METHODID_ADD_FARM)))
        .addMethod(
          getGetFarmDetailsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.FarmService.FarmRequest,
              grpc.FarmService.FarmResponse>(
                service, METHODID_GET_FARM_DETAILS)))
        .build();
  }

  private static abstract class FarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FarmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.FarmService.FarmProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FarmService");
    }
  }

  private static final class FarmServiceFileDescriptorSupplier
      extends FarmServiceBaseDescriptorSupplier {
    FarmServiceFileDescriptorSupplier() {}
  }

  private static final class FarmServiceMethodDescriptorSupplier
      extends FarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FarmServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FarmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FarmServiceFileDescriptorSupplier())
              .addMethod(getAddFarmMethod())
              .addMethod(getGetFarmDetailsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
