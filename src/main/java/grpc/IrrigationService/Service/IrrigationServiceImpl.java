package grpc.IrrigationService.Service;

import io.grpc.stub.StreamObserver;
import grpc.IrrigationService.IrrigationRequest;
import grpc.IrrigationService.IrrigationResponse;

import grpc.IrrigationService.IrrigationServiceGrpc.IrrigationServiceImplBase;
public class IrrigationServiceImpl extends IrrigationServiceImplBase {

    @Override
    public void startIrrigation(IrrigationRequest request, StreamObserver<IrrigationResponse> responseObserver) {

        boolean success = true;
        String message = "Irrigation started successfully.";

        IrrigationResponse response = IrrigationResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void stopIrrigation(IrrigationRequest request, StreamObserver<IrrigationResponse> responseObserver) {
        // 实现停止灌溉逻辑
        // ...

        boolean success = true;
        String message = "Irrigation stopped successfully.";

        IrrigationResponse response = IrrigationResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
