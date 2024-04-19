package grpc;

import grpc.IlluminateService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.CountDownLatch;

public class IlluminateClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("illuminate", 9002)
                .usePlaintext()
                .build();

        IlluminateServiceGrpc.IlluminateServiceBlockingStub stub = IlluminateServiceGrpc.newBlockingStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<IlluminateResponse> responseObserver = new StreamObserver<IlluminateResponse>() {
            @Override
            public void onNext(IlluminateResponse value) {
                System.out.println("Received response: " + value.getSuccess() + ", " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        };

        StreamObserver<IlluminateRequest> requestObserver = stub.

        try (Reader reader = new FileReader("../files/illuminate.csv");
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
                int farmId = Integer.parseInt(csvRecord.get("farmid"));
                int districtId = Integer.parseInt(csvRecord.get("districtid"));
                int duration = Integer.parseInt(csvRecord.get("duration"));
                IlluminateRequest request = IlluminateRequest.newBuilder()
                        .setFarmid(farmId)
                        .setDistrictid(districtId)
                        .setDuration(duration)
                        .build();
                requestObserver.onNext(request);
            }

            requestObserver.onCompleted();

            latch.await();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
