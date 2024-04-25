package grpc;
import com.google.protobuf.InvalidProtocolBufferException;
import grpc.IrrigationService.IrrigationRequest;
import grpc.IrrigationService.IrrigationResponse;
import grpc.IrrigationService.IrrigationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IrrigationClient {

    private static final Logger logger = Logger.getLogger(IrrigationClient.class.getName());

    private final ManagedChannel channel;
    private final IrrigationServiceGrpc.IrrigationServiceStub asyncStub;

    private int totalVolume;

    public IrrigationClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        asyncStub = IrrigationServiceGrpc.newStub(channel);
    }

    public void irrigate(Reader csvReader) throws InvalidProtocolBufferException {
        CountDownLatch latch = new CountDownLatch(1);
        totalVolume = 0;
        StreamObserver<IrrigationResponse> responseObserver = new StreamObserver<IrrigationResponse>() {

            @Override
            public void onNext(IrrigationResponse value) {
                totalVolume += value.getVolume();
                logger.info("Received irrigation response: success=" + value.getSuccess() + ", volume=" + value.getVolume() + ", totalVolume=" + totalVolume);
            }

            @Override
            public void onError(Throwable t) {
                logger.log(Level.WARNING, "Error in client information streaming: ", t);
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                logger.info("Irrigation completed. TotalVolume: " + totalVolume);
                latch.countDown();
            }
        };

        StreamObserver<IrrigationRequest> requestObserver = asyncStub.irrigation(responseObserver);

        try (CSVParser csvParser = new CSVParser(csvReader, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
                int farmId = Integer.parseInt(csvRecord.get(0));
                int districtId = Integer.parseInt(csvRecord.get(1));

                IrrigationRequest irrigationRequest = IrrigationRequest.newBuilder()
                        .setFarmid(farmId)
                        .setDistrictid(districtId)
                        .build();
                requestObserver.onNext(irrigationRequest);
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error reading CSV file: ", e);
        }

        requestObserver.onCompleted();

        try {
            latch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Error waiting for server response: ", e);
        }
    }

    public static void main(String[] args) {
        String csvData = "1,2\n3,4\n5,6";
        Reader csvReader = new StringReader(csvData);

        IrrigationClient client = new IrrigationClient("localhost", 9003);

        try {
            client.irrigate(csvReader);
        } catch (InvalidProtocolBufferException e) {
            logger.log(Level.WARNING, "Error in client irrigation: ", e);
        } finally {
            client.shutdown();
        }
    }

    private void shutdown() {
        if (channel != null) {
            try {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Error waiting for channel termination: ", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
