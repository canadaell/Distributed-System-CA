package grpc;

import grpc.IlluminateService.IlluminateServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;


public class IlluminateServer {

    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(9002)
                .addService(new IlluminateServiceImpl())
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
        IlluminateServer server = new IlluminateServer();
        server.start();
        System.out.println("Illuminate server started on port 9002");
        server.blockUntilShutdown();
    }
}
