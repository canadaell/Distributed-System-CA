import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import grpc.SensorService.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GUI extends Application {

    private SensorServiceGrpc.SensorServiceBlockingStub blockingStub;

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();
        controller.setClient(this);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9001)
                .usePlaintext()
                .build();
        blockingStub = SensorServiceGrpc.newBlockingStub(channel);

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



    public static void main(String[] args) {
        launch(args);
    }
}
