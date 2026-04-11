package com.example.covidmanagementapp.Kumkum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
public class LabResultEntryController {
    @FXML
    private Button statisticsBtn;
    @FXML
    private Button positiveCasesBtn;
    @FXML
    private Button inventoryBtn;
    @FXML
    private Label patientNameLabel;
    @FXML
    private ComboBox<String> resultComboBox;
    @FXML
    private Button assignedTestsBtn;
    @FXML
    private Button submitResultBtn;
    @FXML
    private TextField ctValueTextField;

    @FXML
    public void initialize() {

        resultComboBox.getItems().addAll("Positive", "Negative");


        patientNameLabel.setText("John Doe");
    }

    @FXML
    public void onSubmitResultClicked(ActionEvent actionEvent) {
        String ctValue = ctValueTextField.getText();
        String result = resultComboBox.getValue();

        if (ctValue.isEmpty() || result == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter the CT Value and select a Result.");
            alert.show();
        } else {

            System.out.println("Submitting Result for " + patientNameLabel.getText());
            System.out.println("CT Value: " + ctValue + " | Result: " + result);

            // Show success message
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setContentText("Result submitted successfully!");
            success.show();
        }
    }
}
