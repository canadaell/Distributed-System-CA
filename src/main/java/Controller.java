
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class Controller {

    @FXML
    public TextField nameTextField;

    @FXML
    public Button submitButton;

    @FXML
    void submitButtonClickOnAction(ActionEvent event) {
        System.out.println("SubmitButtonClickOnAction clicked");
        String name = nameTextField.getText();
        System.out.println("nameTextField: " + name);
    }
}