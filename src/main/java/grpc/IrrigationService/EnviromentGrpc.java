package grpc.IrrigationService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: Irrigation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EnviromentGrpc {

  private EnviromentGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.smartagri.Irrigation.Enviroment";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.IrrigationService.IrrigationRequest,
      grpc.IrrigationService.IrrigationResponse> getIrrigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Irrigation",
      requestType = grpc.IrrigationService.IrrigationRequest.class,
      responseType = grpc.IrrigationService.IrrigationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.IrrigationService.IrrigationRequest,
      grpc.IrrigationService.IrrigationResponse> getIrrigationMethod() {
    io.grpc.MethodDescriptor<grpc.IrrigationService.IrrigationRequest, grpc.IrrigationService.IrrigationResponse> getIrrigationMethod;
    if ((getIrrigationMethod = EnviromentGrpc.getIrrigationMethod) == null) {
      synchronized (EnviromentGrpc.class) {
        if ((getIrrigationMethod = EnviromentGrpc.getIrrigationMethod) == null) {
          EnviromentGrpc.getIrrigationMethod = getIrrigationMethod =
              io.grpc.MethodDescriptor.<grpc.IrrigationService.IrrigationRequest, grpc.IrrigationService.IrrigationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Irrigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.IrrigationService.IrrigationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.IrrigationService.IrrigationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnviromentMethodDescriptorSupplier("Irrigation"))
              .build();
        }
      }
    }
    return getIrrigationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnviromentStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnviromentStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnviromentStub>() {
        @java.lang.Override
        public EnviromentStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnviromentStub(channel, callOptions);
        }
      };
    return EnviromentStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnviromentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnviromentBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnviromentBlockingStub>() {
        @java.lang.Override
        public EnviromentBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnviromentBlockingStub(channel, callOptions);
        }
      };
    return EnviromentBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnviromentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnviromentFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnviromentFutureStub>() {
        @java.lang.Override
        public EnviromentFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnviromentFutureStub(channel, callOptions);
        }
      };
    return EnviromentFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationRequest> irrigation(
        io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getIrrigationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Enviroment.
   */
  public static abstract class EnviromentImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EnviromentGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Enviroment.
   */
  public static final class EnviromentStub
      extends io.grpc.stub.AbstractAsyncStub<EnviromentStub> {
    private EnviromentStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnviromentStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnviromentStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationRequest> irrigation(
        io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getIrrigationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Enviroment.
   */
  public static final class EnviromentBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EnviromentBlockingStub> {
    private EnviromentBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnviromentBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnviromentBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Enviroment.
   */
  public static final class EnviromentFutureStub
      extends io.grpc.stub.AbstractFutureStub<EnviromentFutureStub> {
    private EnviromentFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnviromentFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnviromentFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_IRRIGATION = 0;

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
        case METHODID_IRRIGATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.irrigation(
              (io.grpc.stub.StreamObserver<grpc.IrrigationService.IrrigationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getIrrigationMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              grpc.IrrigationService.IrrigationRequest,
              grpc.IrrigationService.IrrigationResponse>(
                service, METHODID_IRRIGATION)))
        .build();
  }

  private static abstract class EnviromentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnviromentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.IrrigationService.IrrigationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Enviroment");
    }
  }

  private static final class EnviromentFileDescriptorSupplier
      extends EnviromentBaseDescriptorSupplier {
    EnviromentFileDescriptorSupplier() {}
  }

  private static final class EnviromentMethodDescriptorSupplier
      extends EnviromentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EnviromentMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EnviromentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnviromentFileDescriptorSupplier())
              .addMethod(getIrrigationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
