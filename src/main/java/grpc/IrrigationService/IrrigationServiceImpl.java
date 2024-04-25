package grpc.IrrigationService;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.grpc.stub.StreamObserver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class IrrigationServiceImpl extends IrrigationServiceGrpc.IrrigationServiceImplBase {

    int totalVolume;

    private int processIrrigationRequest(int farmId, int districtId) {
        // Process the irrigation request and return the volume of water used
        return 100;
    }

    @Override
    public StreamObserver<IrrigationRequest> irrigation(StreamObserver<IrrigationResponse> responseObserver) {
        return new StreamObserver<IrrigationRequest>() {
            @Override
            public void onNext(IrrigationRequest irrigationRequest) {
                System.out.println("Received irrigation request");

                try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\15305\\Downloads\\distributed-system-CA\\files\\irrigation.csv"))) {
                    List<String[]> records = reader.readAll();

                    for (String[] record : records) {
                        int farmId = Integer.parseInt(record[0]);
                        int districtId = Integer.parseInt(record[1]);

                        int volume = processIrrigationRequest(farmId, districtId);
                        totalVolume += volume;

                        // Send the processing result to the client
                        IrrigationResponse irrigationResponse = IrrigationResponse.newBuilder()
                                .setSuccess(true)
                                .setVolume(volume)
                                .build();
                        responseObserver.onNext(irrigationResponse);
                    }
                } catch (IOException | CsvException e) {
                    System.err.println("Error reading CSV file: " + e.getMessage());
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
