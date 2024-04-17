package grpc.IrrigationService;
import io.grpc.stub.StreamObserver;

public class IrrigationServiceImpl extends IrrigationServiceGrpc.IrrigationServiceImplBase {

    int totalVolume;

    private int processIrrigationRequest(int farmId, int districtId) {
        // Process the irrigation request and return the volume of water used
        return 100;
    }

    @Override
    public StreamObserver<IrrigationRequest> irrigation(StreamObserver<IrrigationResponse> responseObserver) {
        return new StreamObserver<IrrigationRequest>() {
            @Override
            public void onNext(IrrigationRequest irrigationRequest) {
                System.out.println("Reveived irrigation request");
                String message = "Farm ID: " + irrigationRequest.getFarmid() + ", District ID: " + irrigationRequest.getDistrictid();
                int volume = processIrrigationRequest(irrigationRequest.getFarmid(), irrigationRequest.getDistrictid());
                totalVolume += volume;

                // Send the processing result to the client
                IrrigationResponse irrigationResponse = IrrigationResponse.newBuilder()
                        .setSuccess(true)
                        .setVolume(volume)
                        .build();
                responseObserver.onNext(irrigationResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Err in client information streaming: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Irrigation completed");

                // Send the final processing result to the client
                IrrigationResponse irrigationResponse = IrrigationResponse.newBuilder()
                        .setSuccess(true)
                        .setVolume(totalVolume)
                        .build();
                responseObserver.onNext(irrigationResponse);
                responseObserver.onCompleted();
            }
        };
    }
}
