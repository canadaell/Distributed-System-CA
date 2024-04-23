package grpc.SensorService;


import grpc.IrrigationService.IrrigationRequest;
import grpc.IrrigationService.IrrigationResponse;
import grpc.IrrigationService.IrrigationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class IrrigationClient {
    private static final Logger logger = Logger.getLogger(IrrigationClient.class.getName());

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("irrigation", 9003)
                .usePlaintext()
                .build();

        IrrigationServiceGrpc.IrrigationServiceStub asyncStub = IrrigationServiceGrpc.newStub(channel);

        IrrigationRequest irrigationRequest = IrrigationRequest.newBuilder()
                .build();

        StreamObserver<IrrigationResponse> responseObserver = new StreamObserver<IrrigationResponse>() {
            @Override
            public void onNext(IrrigationResponse irrigationResponse) {
                logger.info("Received response: " + irrigationResponse.getSuccess() + ", " + irrigationResponse.getVolume());
            }

            @Override
            public void onError(Throwable throwable) {
                logger.severe("Error receiving response: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("All responses received.");
            }
        };

        StreamObserver<IrrigationRequest> requestObserver = asyncStub.irrigation(responseObserver);

        requestObserver.onNext(irrigationRequest);
        requestObserver.onCompleted();


    }
}
