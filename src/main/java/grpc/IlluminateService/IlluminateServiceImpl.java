package grpc.IlluminateService;

import io.grpc.stub.StreamObserver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class IlluminateServiceImpl extends IlluminateServiceGrpc.IlluminateServiceImplBase {

    private Map<Integer, Map<Integer, Integer>> dataMap = new HashMap<>();

    public IlluminateServiceImpl() {
        try (Reader reader = new FileReader("../files/illuminate.csv");
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
                int farmId = Integer.parseInt(csvRecord.get("farm_id"));
                int districtId = Integer.parseInt(csvRecord.get("district_id"));
                int duration = Integer.parseInt(csvRecord.get("duration"));

                if (!dataMap.containsKey(farmId)) {
                    dataMap.put(farmId, new HashMap<>());
                }
                dataMap.get(farmId).put(districtId, duration);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public StreamObserver<IlluminateRequest> illuminate(StreamObserver<IlluminateResponse> responseObserver) {
        return new StreamObserver<IlluminateRequest>() {
            @Override
            public void onNext(IlluminateRequest illuminateRequest) {
                int farmId = illuminateRequest.getFarmid();
                int districtId = illuminateRequest.getDistrictid();

                if (dataMap.containsKey(farmId) && dataMap.get(farmId).containsKey(districtId)) {
                    int duration = dataMap.get(farmId).get(districtId);

                    boolean success = true;
                    String message = "Processing request: " + farmId + ", " + districtId + ", " + duration;
                    IlluminateResponse response = IlluminateResponse.newBuilder()
                            .setSuccess(success)
                            .setMessage(message)
                            .build();
                    responseObserver.onNext(response);
                } else {
                    boolean success = false;
                    String message = "Invalid farm ID or district ID.";
                    IlluminateResponse response = IlluminateResponse.newBuilder()
                            .setSuccess(success)
                            .setMessage(message)
                            .build();
                    responseObserver.onNext(response);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                IlluminateResponse response = IlluminateResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage(throwable.getMessage())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                IlluminateResponse response = IlluminateResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Processing completed.")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}
