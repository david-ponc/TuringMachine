package davidponce.controllers;

import davidponce.utils.ConfigurationRules;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class AppController {
    @FXML
    private Button loadConfigFileBtn;
    @FXML
    private Button runMachineBtn;
    @FXML
    private TextField inputStringField;

    public void loadConfigurationRules(MouseEvent mouseEvent) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );
        File file = chooser.showOpenDialog(loadConfigFileBtn.getScene().getWindow());
        ConfigurationRules.setConfigurationRules(file);
    }

    public void runMachineProcess(MouseEvent mouseEvent) {

    }
}
