package grpc.SensorService.Service;

import com.google.protobuf.Timestamp;
import grpc.SensorService.SensorRequest;
import grpc.SensorService.SensorResponse;
import grpc.SensorService.SensorData;
import grpc.SensorService.SensorServiceGrpc.SensorServiceImplBase;
import io.grpc.stub.StreamObserver;

public class SensorServiceImpl extends SensorServiceImplBase{

    @Override
    public void addSensor(SensorRequest request, StreamObserver<SensorResponse> responseObserver) {

        boolean success = true;
        String message = "Sensor added successfully.";

        SensorResponse response = SensorResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getSensorData(SensorRequest request, StreamObserver<SensorResponse> responseObserver) {

        boolean success = true;
        String message = "Sensor data retrieved successfully.";

        SensorData sensorData1 = SensorData.newBuilder()
                .setId("sensor1")
                .setName("Temperature Sensor")
                .setType("Temperature")
                .setUnit("Celsius")
                .setFarmId("farm1")
                .setValue("25.0")
                .setTimestamp(Timestamp.newBuilder().setSeconds(1633022420).build())
                .build();

        SensorData sensorData2 = SensorData.newBuilder()
                .setId("sensor2")
                .setName("Humidity Sensor")
                .setType("Humidity")
                .setUnit("%")
                .setFarmId("farm1")
                .setValue("60.0")
                .setTimestamp(Timestamp.newBuilder().setSeconds(1633022420).build())
                .build();

        SensorResponse response = SensorResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .addData(sensorData1)
                .addData(sensorData2)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
