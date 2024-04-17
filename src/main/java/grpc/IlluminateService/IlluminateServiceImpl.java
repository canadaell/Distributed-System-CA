package grpc.IlluminateService;

import io.grpc.stub.StreamObserver;

public class IlluminateServiceImpl extends IlluminateServiceGrpc.IlluminateServiceImplBase {

    @Override
    public StreamObserver<IlluminateRequest> illuminate(StreamObserver<IlluminateResponse> responseObserver) {
        return new StreamObserver<IlluminateRequest>() {
            @Override
            public void onNext(IlluminateRequest illuminateRequest) {
                boolean success = false;
                String message = "Processing request: " + illuminateRequest.getFarmid() + ", " + illuminateRequest.getDistrictid() + ", " + illuminateRequest.getDuration();
                IlluminateResponse response = IlluminateResponse.newBuilder()
                        .setSuccess(success)
                        .setMessage(message)
                        .build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable throwable) {
                IlluminateResponse response = IlluminateResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage(throwable.getMessage())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                IlluminateResponse response = IlluminateResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Processing completed.")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}
