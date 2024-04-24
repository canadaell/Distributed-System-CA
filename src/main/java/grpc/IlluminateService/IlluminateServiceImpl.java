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
        try (Reader reader = new FileReader("C:\\Users\\15305\\Downloads\\distributed-system-CA\\files\\illuminate.csv");
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
                int farmid = Integer.parseInt(csvRecord.get("farmid"));
                int districtid = Integer.parseInt(csvRecord.get("districtid"));
                int duration = Integer.parseInt(csvRecord.get("duration"));

                if (!dataMap.containsKey(farmid)) {
                    dataMap.put(farmid, new HashMap<>());
                }
                dataMap.get(farmid).put(districtid, duration);
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
                int farmid = illuminateRequest.getFarmid();
                int districtid = illuminateRequest.getDistrictid();

                if (dataMap.containsKey(farmid) && dataMap.get(farmid).containsKey(districtid)) {
                    int duration = dataMap.get(farmid).get(districtid);

                    boolean success = true;
                    String message = "Processing request: " + farmid + ", " + districtid + ", " + duration;
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
