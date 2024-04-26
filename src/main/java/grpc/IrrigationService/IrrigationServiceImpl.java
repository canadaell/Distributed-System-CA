package grpc.IrrigationService;

import io.grpc.stub.StreamObserver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class IrrigationServiceImpl extends IrrigationServiceGrpc.IrrigationServiceImplBase {

    private final Map<String, Integer> irrigationData;

    public IrrigationServiceImpl() throws IOException {
        irrigationData = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\15305\\Downloads\\distributed-system-CA\\files\\irrigation1.csv"))) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord record : csvParser) {
                String key = record.get(0) + "," + record.get(1);
                int volume = 100;
                irrigationData.put(key, volume);
            }
        }
    }

    @Override
    public StreamObserver<IrrigationRequest> irrigation(StreamObserver<IrrigationResponse> responseObserver) {
        return new StreamObserver<IrrigationRequest>() {
            int totalVolume = 0;

            @Override
            public void onNext(IrrigationRequest irrigationRequest) {
                System.out.println("Received irrigation request");
                String key = irrigationRequest.getFarmid() + "," + irrigationRequest.getDistrictid();
                Integer volume = irrigationData.get(key);

                if (volume != null) {
                    totalVolume += volume;

                    IrrigationResponse irrigationResponse = IrrigationResponse.newBuilder()
                            .setSuccess(true)
                            .setVolume(volume)
                            .build();
                    responseObserver.onNext(irrigationResponse);
                } else {
                    System.err.println("Error: No data found for farmId=" + irrigationRequest.getFarmid() + " and districtId=" + irrigationRequest.getDistrictid());
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error in client information streaming: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Irrigation completed");

                // Send the final processing result to the client
                IrrigationResponse irrigationResponse = IrrigationResponse.newBuilder()
                        .setSuccess(true)
                        .setVolume(totalVolume)
                        .build();
                responseObserver.onNext(irrigationResponse);
                responseObserver.onCompleted();
            }
        };
    }
}