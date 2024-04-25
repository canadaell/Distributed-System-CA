package grpc;

import grpc.SensorService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SensorClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9001)
                .usePlaintext()
                .build();

        SensorServiceGrpc.SensorServiceStub asyncStub = SensorServiceGrpc.newStub(channel);

        // Add sensor
        AddSensorRequest addSensorRequest = AddSensorRequest.newBuilder()
                .setSensorid(1)
                .setSensortype("Temperature")
                .setDistrictid(1)
                .build();

        CountDownLatch addSensorLatch = new CountDownLatch(1);
        StreamObserver<AddSensorResponse> addSensorResponseObserver = new StreamObserver<AddSensorResponse>() {
            @Override
            public void onNext(AddSensorResponse value) {
                System.out.println("Received add sensor response: " + value);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error adding sensor: " + t.getMessage());
                addSensorLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Add sensor completed");
                addSensorLatch.countDown();
            }
        };

        asyncStub.addSensor(addSensorRequest, addSensorResponseObserver);
        addSensorLatch.await(1, TimeUnit.SECONDS);

        // Stream sensor data
        SensorRequest sensorRequest = SensorRequest.newBuilder()
                .setFarmid(1)
                .setSensorid(1)
                .build();

        CountDownLatch streamSensorLatch = new CountDownLatch(1);
        StreamObserver<SensorResponse> sensorResponseObserver = new StreamObserver<SensorResponse>() {
            @Override
            public void onNext(SensorResponse value) {
                System.out.println("Received sensor response: " + value);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error streaming sensor data: " + t.getMessage());
                streamSensorLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream sensor data completed");
                streamSensorLatch.countDown();
            }
        };

        asyncStub.streamSensorData(sensorRequest, sensorResponseObserver);
        streamSensorLatch.await(1, TimeUnit.SECONDS);

        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
}