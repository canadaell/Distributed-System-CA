
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {

    private GUI client;

    @FXML
    private TextField sensorIdField;
    @FXML
    private TextField sensorTypeField;
    @FXML
    private TextField districtIdField;
    @FXML
    private Button addSensorButton;
    @FXML
    private Button streamDataButton;
    @FXML
    private Button illuminateButton;
    @FXML
    private Button irrigationButton;
    @FXML
    private TextArea outputArea;

    public void setClient(GUI client) {
        this.client = client;
    }

    @FXML
    public void addSensor() {
        int sensorId = Integer.parseInt(sensorIdField.getText());
        String sensorType = sensorTypeField.getText();
        int districtId = Integer.parseInt(districtIdField.getText());
        client.addSensor(sensorId, sensorType, districtId);
    }

    @FXML
    public void streamData() {
        client.streamSensorData(true, outputArea);
    }

    @FXML
    public void illuminate() {

    }

    @FXML
    public void irrigation() {

    }

    @FXML
    public void initialize() {
        addSensorButton.setOnAction(event -> addSensor());
        streamDataButton.setOnAction(event -> streamData());
        illuminateButton.setOnAction(event -> illuminate());
        irrigationButton.setOnAction(event -> irrigation());
    }
}
