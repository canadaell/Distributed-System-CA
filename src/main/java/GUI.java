import grpc.SensorClient;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

//    private TextArea messageArea;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create UI components
//        messageArea = new TextArea();
//        messageArea.setEditable(false);
//
//        Button button = new Button("Call Sensor Service");
//        button.setOnAction(e -> {
//            // Call SensorService and display the response
//            SensorClient sensorClient = new SensorClient("localhost", 9001);
//            sensorClient.addSensor(123, "temperature", 456);
//            sensorClient.streamSensorData(true);
//            messageArea.setText("Calling SensorService...\n");
//        });
//
//        VBox leftBox = new VBox();
//        leftBox.getChildren().addAll(new Label("Sensor Service"), button);
//
//        VBox centerBox = new VBox();
//        centerBox.getChildren().add(new Label("Service 2"));
//
//        VBox rightBox = new VBox();
//        rightBox.getChildren().add(new Label("Service 3"));
//
//        HBox mainBox = new HBox(leftBox, centerBox, rightBox);
//
//        BorderPane root = new BorderPane();
//        root.setTop(new Label("Smart Farm GUI"));
//        root.setCenter(mainBox);
//        root.setBottom(messageArea);
//
//        Scene scene = new Scene(root, 800, 600);
//
//        primaryStage.setTitle("GUI Client");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
}
