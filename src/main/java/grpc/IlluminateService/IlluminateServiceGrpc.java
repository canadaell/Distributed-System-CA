package grpc.IlluminateService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: Illuminate.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IlluminateServiceGrpc {

  private IlluminateServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "IlluminateService.IlluminateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.IlluminateService.IlluminateRequest,
      grpc.IlluminateService.IlluminateResponse> getIlluminateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "illuminate",
      requestType = grpc.IlluminateService.IlluminateRequest.class,
      responseType = grpc.IlluminateService.IlluminateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.IlluminateService.IlluminateRequest,
      grpc.IlluminateService.IlluminateResponse> getIlluminateMethod() {
    io.grpc.MethodDescriptor<grpc.IlluminateService.IlluminateRequest, grpc.IlluminateService.IlluminateResponse> getIlluminateMethod;
    if ((getIlluminateMethod = IlluminateServiceGrpc.getIlluminateMethod) == null) {
      synchronized (IlluminateServiceGrpc.class) {
        if ((getIlluminateMethod = IlluminateServiceGrpc.getIlluminateMethod) == null) {
          IlluminateServiceGrpc.getIlluminateMethod = getIlluminateMethod =
              io.grpc.MethodDescriptor.<grpc.IlluminateService.IlluminateRequest, grpc.IlluminateService.IlluminateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "illuminate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.IlluminateService.IlluminateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.IlluminateService.IlluminateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IlluminateServiceMethodDescriptorSupplier("illuminate"))
              .build();
        }
      }
    }
    return getIlluminateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IlluminateServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IlluminateServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IlluminateServiceStub>() {
        @java.lang.Override
        public IlluminateServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IlluminateServiceStub(channel, callOptions);
        }
      };
    return IlluminateServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IlluminateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IlluminateServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IlluminateServiceBlockingStub>() {
        @java.lang.Override
        public IlluminateServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IlluminateServiceBlockingStub(channel, callOptions);
        }
      };
    return IlluminateServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IlluminateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IlluminateServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IlluminateServiceFutureStub>() {
        @java.lang.Override
        public IlluminateServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IlluminateServiceFutureStub(channel, callOptions);
        }
      };
    return IlluminateServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<grpc.IlluminateService.IlluminateRequest> illuminate(
        io.grpc.stub.StreamObserver<grpc.IlluminateService.IlluminateResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getIlluminateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IlluminateService.
   */
  public static abstract class IlluminateServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return IlluminateServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IlluminateService.
   */
  public static final class IlluminateServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IlluminateServiceStub> {
    private IlluminateServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IlluminateServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IlluminateServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.IlluminateService.IlluminateRequest> illuminate(
        io.grpc.stub.StreamObserver<grpc.IlluminateService.IlluminateResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getIlluminateMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IlluminateService.
   */
  public static final class IlluminateServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IlluminateServiceBlockingStub> {
    private IlluminateServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IlluminateServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IlluminateServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service IlluminateService.
   */
  public static final class IlluminateServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IlluminateServiceFutureStub> {
    private IlluminateServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IlluminateServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IlluminateServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ILLUMINATE = 0;

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
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ILLUMINATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.illuminate(
              (io.grpc.stub.StreamObserver<grpc.IlluminateService.IlluminateResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getIlluminateMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              grpc.IlluminateService.IlluminateRequest,
              grpc.IlluminateService.IlluminateResponse>(
                service, METHODID_ILLUMINATE)))
        .build();
  }

  private static abstract class IlluminateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IlluminateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.IlluminateService.IlluminateProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IlluminateService");
    }
  }

  private static final class IlluminateServiceFileDescriptorSupplier
      extends IlluminateServiceBaseDescriptorSupplier {
    IlluminateServiceFileDescriptorSupplier() {}
  }

  private static final class IlluminateServiceMethodDescriptorSupplier
      extends IlluminateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IlluminateServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IlluminateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IlluminateServiceFileDescriptorSupplier())
              .addMethod(getIlluminateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
