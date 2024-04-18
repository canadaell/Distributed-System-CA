package grpc.SensorService;

import io.grpc.stub.StreamObserver;
import grpc.SensorService.AddSensorResponse;

import java.util.concurrent.ThreadLocalRandom;

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
    public void streamSensorData(SensorRequest request, StreamObserver<SensorResponse> responseObserver) {
        int farmId = request.getFarmid();
        int sensorId = request.getSensorid();

        Runnable streamingTask = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {

                    double temperature = ThreadLocalRandom.current().nextDouble(15.0, 35.0);
                    double humidity = ThreadLocalRandom.current().nextDouble(40.0, 80.0);
                    double illumination = ThreadLocalRandom.current().nextDouble(0.0, 1000.0);

                    SensorResponse response = SensorResponse.newBuilder()
                            .setTempreture(temperature)
                            .setHumidity(humidity)
                            .setDistrict("District " + farmId)
                            .setIllumination(illumination)
                            .build();

                    responseObserver.onNext(response);
                    Thread.sleep(5000); // Stream every 5 seconds
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                responseObserver.onCompleted();
            }
        };

        new Thread(streamingTask).start();
    }

}


