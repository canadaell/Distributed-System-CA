package grpc.FarmService.Service;


import io.grpc.stub.StreamObserver;
import grpc.FarmService.Farm;
import grpc.FarmService.FarmRequest;
import grpc.FarmService.FarmResponse;
import grpc.FarmService.FarmServiceGrpc.FarmServiceImplBase;

public class FarmServiceImpl extends FarmServiceImplBase {

    @Override
    public void addFarm(FarmRequest request, StreamObserver<FarmResponse> responseObserver) {

        Farm farm = Farm.newBuilder()
                .setId(request.getId())
                .setName(request.getName())
                .setLocation(request.getLocation())
                .setOwnerId(request.getOwnerId())
                .build();


        FarmResponse response = FarmResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Farm added successfully")
                .setFarm(farm)
                .build();

        // 发送响应
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getFarmDetails(FarmRequest request, StreamObserver<FarmResponse> responseObserver) {


        Farm farm = Farm.newBuilder()
                .setId(request.getId())
                .setName(request.getName())
                .setLocation(request.getLocation())
                .setOwnerId(request.getOwnerId())
                .build();


        FarmResponse response = FarmResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Farm details retrieved successfully")
                .setFarm(farm)
                .build();


        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

