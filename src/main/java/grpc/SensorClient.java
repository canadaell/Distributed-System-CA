package grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import grpc.SensorService.*;
import java.util.Scanner;

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

    public void addSensorsFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of sensors to add:");
        int numSensors = scanner.nextInt();
        for (int i = 0; i < numSensors; i++) {
            System.out.println("Enter sensor ID for sensor " + (i + 1) + ":");
            int sensorId = scanner.nextInt();
            System.out.println("Enter sensor type for sensor " + (i + 1) + ":");
            String sensorType = scanner.next();
            System.out.println("Enter district ID for sensor " + (i + 1) + ":");
            int districtId = scanner.nextInt();
            addSensor(sensorId, sensorType, districtId);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        SensorClient client = new SensorClient("localhost", 9001);

        client.addSensorsFromUserInput();

        client.streamSensorData(true);
    }
}
