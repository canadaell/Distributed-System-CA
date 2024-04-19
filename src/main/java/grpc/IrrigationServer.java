package grpc;

import grpc.IrrigationService.IrrigationServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class IrrigationServer {

    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(9003)
                .addService(new IrrigationServiceImpl())
                .build();
        server.start();
    }

    public void stop() throws InterruptedException {
        server.shutdown().awaitTermination();
    }

    public void blockUntilShutdown() throws InterruptedException {
        server.awaitTermination();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        IrrigationServer server = new IrrigationServer();
        server.start();
        System.out.println("Irrigation server started on port 9003");
        server.blockUntilShutdown();
    }
}