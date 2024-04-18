package grpc.SensorService;

import io.grpc.stub.StreamObserver;
import grpc.SensorService.AddSensorResponse;

public class SensorServiceImpl extends SensorServiceGrpc.SensorServiceImplBase {
    @Override
    public void addSensor(AddSensorRequest request, StreamObserver<AddSensorResponse> responseObserver) {
        int sensorId = request.getSensorid();
        String sensorType = request.getSensortype();
        String location = request.getLocation();

        boolean success = true;
        String message = "Sensor added successfully, " + "sensor ID " + request.getSensorid() + ", sensor type: " + request.getSensortype() + ", location: " + request.getLocation();

        AddSensorResponse response = AddSensorResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void streamSensorData(SensorRequest request,
                                 StreamObserver<SensorResponse> responseObserver) {

    }

}
