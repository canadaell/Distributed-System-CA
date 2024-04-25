package grpc;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import grpc.IrrigationService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class IrrigationClient {

    private final ManagedChannel channel;
    private final IrrigationServiceGrpc.IrrigationServiceStub asyncStub;
    private int totalVolume;

    public IrrigationClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        asyncStub = IrrigationServiceGrpc.newStub(channel);
    }

    public void irrigate() {
        totalVolume = 0;
        StreamObserver<IrrigationRequest> requestObserver = asyncStub.irrigation(new StreamObserver<IrrigationResponse>() {
            @Override
            public void onNext(IrrigationResponse value) {
                System.out.println("Received irrigation response: " + value);
                totalVolume += value.getVolume();
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in client information streaming: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Irrigation completed. Total volume: " + totalVolume);
            }
        });

        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\15305\\Downloads\\distributed-system-CA\\files\\irrigation1.csv"))) {
            reader.readNext();
            List<String[]> records = reader.readAll();

            for (String[] record : records) {
                int farmId = Integer.parseInt(record[0]);
                int districtId = Integer.parseInt(record[1]);

                IrrigationRequest irrigationRequest = IrrigationRequest.newBuilder()
                        .setFarmid(farmId)
                        .setDistrictid(districtId)
                        .build();
                requestObserver.onNext(irrigationRequest);
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        requestObserver.onCompleted();
    }

    public static void main(String[] args) throws InterruptedException {
        IrrigationClient client = new IrrigationClient("localhost", 9003);
        client.irrigate();
    }
}
