import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import grpc.SensorService.*;
import grpc.IlluminateService.*;
import grpc.IrrigationService.*;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GUI extends Application {

    private SensorServiceGrpc.SensorServiceBlockingStub blockingStub;
    private IlluminateServiceGrpc.IlluminateServiceStub asyncStub;

    private IrrigationServiceGrpc.IrrigationServiceStub irrigationStub;

    private int totalVolume;

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();
        controller.setClient(this);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9001)
                .usePlaintext()
                .build();
        blockingStub = SensorServiceGrpc.newBlockingStub(channel);

        ManagedChannel illuminateChannel = ManagedChannelBuilder.forAddress("localhost", 9002)
                .usePlaintext()
                .build();
        asyncStub = IlluminateServiceGrpc.newStub(illuminateChannel);

        ManagedChannel irrigationChannel = ManagedChannelBuilder.forAddress("localhost", 9003)
                .usePlaintext()
                .build();
        irrigationStub = IrrigationServiceGrpc.newStub(irrigationChannel);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Sensor Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = SensorServiceGrpc.newBlockingStub(channel);
    }

    public void addSensor(int sensorId, String sensorType, int districtId) {
        AddSensorRequest request = AddSensorRequest.newBuilder()
                .setSensorid(sensorId)
                .setSensortype(sensorType)
                .setDistrictid(districtId)
                .build();
        AddSensorResponse response = blockingStub.addSensor(request);
        System.out.println("Add sensor response: " + response.getSuccess() + ", " + response.getMessage());
    }

    public void streamSensorData(boolean start, TextArea outputArea) {
        SensorRequest request = SensorRequest.newBuilder()
                .setStart(start)
                .build();
        new Thread(() -> {
            blockingStub.streamSensorData(request).forEachRemaining(response -> {
                String output = "Received sensor data: " + response.getFarmid() + ", " + response.getSensorid() + ", " + response.getDistrictid() +
                        ", " + response.getTempreture() + ", " + response.getHumidity() + ", " + response.getIllumination() + "\n";
                System.out.print(output);
                Platform.runLater(() -> outputArea.appendText(output));
            });
        }).start();
    }
    public void irrigation(Reader csvReader, TextArea outputArea) {
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<IrrigationResponse> responseObserver = new StreamObserver<IrrigationResponse>() {

            @Override
            public void onNext(IrrigationResponse value) {
                totalVolume += value.getVolume();
                String output = "Received irrigation response: success=" + value.getSuccess() + "\n";
                System.out.print(output);
                Platform.runLater(() -> outputArea.appendText(output));
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in client information streaming: ");
                t.printStackTrace();
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Irrigation completed. TotalVolume: " + totalVolume);
                latch.countDown();
            }
        };

        StreamObserver<IrrigationRequest> requestObserver = irrigationStub.irrigation(responseObserver);

        try (CSVParser csvParser = new CSVParser(csvReader, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
                int farmId = Integer.parseInt(csvRecord.get(0));
                int districtId = Integer.parseInt(csvRecord.get(1));
                int volume = 100;

                IrrigationRequest irrigationRequest = IrrigationRequest.newBuilder()
                        .setFarmid(farmId)
                        .setDistrictid(districtId)
                        .setVolume(volume)
                        .build();
                requestObserver.onNext(irrigationRequest);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: ");
            e.printStackTrace();
        }

        requestObserver.onCompleted();

        try {
            latch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Error waiting for server response: ");
            e.printStackTrace();
        }
    }


    public void illuminate(TextArea outputArea) {
        new Thread(() -> {
            CountDownLatch latch = new CountDownLatch(1);

            StreamObserver<IlluminateResponse> responseObserver = new StreamObserver<IlluminateResponse>() {
                @Override
                public void onNext(IlluminateResponse value) {
                    String output = "Received response: " + value.getSuccess() + ", " + value.getMessage() + "\n";
                    System.out.print(output);
                    Platform.runLater(() -> outputArea.appendText(output));
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

            StreamObserver<IlluminateRequest> requestObserver = asyncStub.illuminate(responseObserver);

            String[] headers = {"farmid", "districtid", "duration"};
            CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(headers).withSkipHeaderRecord();

            try (Reader reader = new FileReader("C:\\Users\\15305\\Downloads\\distributed-system-CA\\files\\illuminate1.csv");
                 CSVParser csvParser = new CSVParser(reader, csvFormat)) {

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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
