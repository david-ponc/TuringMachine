package davidponce.controllers;

import davidponce.objects.TuringMachine;
import davidponce.utils.ConfigurationRules;
import davidponce.utils.InputEvaluation;
import davidponce.utils.ResultsDesk;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AppController {
    @FXML
    private VBox stepsContainer;
    @FXML
    private HBox tapeContainer;
    @FXML
    private Button loadConfigFileBtn;
    @FXML
    private Button runMachineBtn;
    @FXML
    private TextField inputStringField;
    @FXML
    private Label inputResultLabel;
    private final TuringMachine turingMachine;

    public AppController() {
        this.turingMachine = new TuringMachine();
    }

    public void loadConfigurationRules(MouseEvent mouseEvent) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );
        File file = chooser.showOpenDialog(loadConfigFileBtn.getScene().getWindow());
        ConfigurationRules.setConfigurationRules(file, this.turingMachine);
    }

    public void runMachineProcess(MouseEvent mouseEvent) {
        InputEvaluation inputEvaluation = new InputEvaluation(this);
        if(!inputStringField.getText().equals("")) {
            clear();
            ArrayList<String> symbols = new ArrayList<>(Arrays.asList(inputStringField.getText().split("")));
            Map<String, Object> result = inputEvaluation.evaluate(turingMachine, symbols);
            ResultsDesk.showStepsList(
                    (List<String>)result.get("steps"),
                    this
            );
            ResultsDesk.showStatesTape(
                    (List<List<String>>)result.get("tapeStates"),
                    (List<Integer>)result.get("pointerPositions") ,
                    this
            );
            validationNotify((Boolean)result.get("inputResult"));
        }else {
            System.out.println("Cadena de entrada no válida");
        }
    }

    public void addStep(String step) {
        Label label = new Label(step);
        label.getStyleClass().add("step-item");
        stepsContainer.getChildren().add(label);
    }

    public void updateStateTape(List<String> tape, Integer pointerPosition) {
        tapeContainer.getChildren().clear();
        AtomicInteger index = new AtomicInteger();
        tape.forEach(symbol -> {
            Label label = new Label(symbol);
            if (index.get() != pointerPosition)
                label.getStyleClass().add("tape__item");
            else
                label.getStyleClass().add("tape__item-selected");
            tapeContainer.getChildren().add(label);
            index.getAndIncrement();
        });
    }

    public void validationNotify(Boolean inputResult) {
        if(inputResult) {
            inputResultLabel.setTextFill(Paint.valueOf("10CFA7"));
            inputResultLabel.setText("CADENA VÁLIDA");
        }else {
            inputResultLabel.setTextFill(Paint.valueOf("CF1064"));
            inputResultLabel.setText("CADENA INVÁLIDA");
        }
    }

    public void clear() {
        stepsContainer.getChildren().clear();
        tapeContainer.getChildren().clear();
    }
}
