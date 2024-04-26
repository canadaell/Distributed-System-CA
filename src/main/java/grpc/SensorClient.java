package grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import grpc.SensorService.*;
public class SensorClient {

    private final SensorServiceGrpc.SensorServiceBlockingStub blockingStub;

    public SensorClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = SensorServiceGrpc.newBlockingStub(channel);
    }

    public void addSensor(int sensorId, String sensorType, int districtId) {
        AddSensorRequest request = AddSensorRequest.newBuilder()
                .setSensorid(sensorId)
                .setSensortype(sensorType)
                .setDistrictid(districtId)
                .build();
        AddSensorResponse response = blockingStub.addSensor(request);
        System.out.println("Add sensor response: " + response.getSuccess() + ", " + response.getMessage());
    }

    public void streamSensorData(boolean start) {
        SensorRequest request = SensorRequest.newBuilder()
                .setStart(start)
                .build();
        blockingStub.streamSensorData(request).forEachRemaining(response -> {
            System.out.println("Received sensor data: " + response.getFarmid() + ", " + response.getSensorid() + ", " + response.getDistrictid() +
                    ", " + response.getTempreture() + ", " + response.getHumidity() + ", " + response.getIllumination());
        });
    }

    public static void main(String[] args) {
        SensorClient client = new SensorClient("localhost", 9001);

        // Add a new sensor
        client.addSensor(123, "temperature", 456);

        // Stream sensor data
        client.streamSensorData(true);
    }
}