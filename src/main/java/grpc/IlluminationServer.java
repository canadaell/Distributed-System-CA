package grpc;

import grpc.IlluminateService.IlluminateServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class IlluminationServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerBuilder serverBuilder = ServerBuilder.forPort(9000);
        serverBuilder.addService(new IlluminateServiceImpl());

        Server server = serverBuilder.build();

        server.start();
        server.awaitTermination();
    }
}
