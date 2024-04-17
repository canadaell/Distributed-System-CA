package grpc.IrrigationService;
import io.grpc.stub.StreamObserver;
import grpc.IrrigationService.IrrigationServiceGrpc;
import grpc.IrrigationService.IrrigationRequest;
import grpc.IrrigationService.IrrigationResponse;

public class IrrigationServiceImpl extends IrrigationServiceGrpc.IrrigationServiceImplBase {

    int totalVolume;
    @Override
    public StreamObserver<IrrigationRequest> irrigation(StreamObserver<IrrigationResponse> responseObserver) {
        return new StreamObserver<IrrigationRequest>() {
            @Override
            public void onNext(IrrigationRequest irrigationRequest) {
                System.out.println("Reveived irrigation request");
                System.out.println("Farm ID: " + irrigationRequest.getFarmid() + ", District ID: " + irrigationRequest.getDistrictid());
                int volume = processIrrigationRequest(irrigationRequest.getFarmid(), irrigationRequest.getDistrictid());
                totalVolume += 100;
            }

            @Override
            public void onError(Throwable throwable) {

                System.err.println("Err in client information streaming: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Irrigation completed");
                IrrigationResponse irrigationResponse = IrrigationResponse.newBuilder()
                        .setSuccess(true)
                        .setVolume(totalVolume)
                        .build();
                responseObserver.onNext(irrigationResponse);
                responseObserver.onCompleted();
            }
        };
    }
    private int processIrrigationRequest(int farmId, int districtId) {
        //irrigate 100 ml every time
        return 100;
    }

}
