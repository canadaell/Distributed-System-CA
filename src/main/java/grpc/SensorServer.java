package grpc;

import grpc.SensorService.SensorServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SensorServer {

    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(9001)
                .addService(new SensorServiceImpl())
                .build();
        server.start();
        System.out.println("Sensor server started on port 9001");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down sensor server");
            server.shutdown();
        }));
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SensorServer server = new SensorServer();
        server.start();
        server.blockUntilShutdown();
    }
}