package grpc;

import grpc.IlluminateService.IlluminateRequest;
import grpc.IlluminateService.IlluminateServiceGrpc;
import grpc.IrrigationService.IrrigationServiceGrpc;
import grpc.SensorService.SensorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();

        IlluminateServiceGrpc.IlluminateServiceBlockingStub illuminate = IlluminateServiceGrpc.newBlockingStub(managedChannel);

        IlluminateRequest.Builder builder1 = IlluminateRequest.newBuilder();

    }
}
