package com.example.covidmanagementapp.Kumkum;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LabChecklistController {
    @FXML
    private CheckBox maskCb;
    @FXML
    private CheckBox sanitizeCb;
    @FXML
    private CheckBox eyeCb;
    @FXML
    private CheckBox gloveCb;
    @FXML
    private CheckBox ppeCb;
    @FXML
    private Button btnStartCollection;
    @FXML
    private Label patientNameLabel;
    @FXML
    private Label testStatus;
    @FXML
    private Label testResult;

    @FXML
    public void initialize() {

        patientNameLabel.setText("john Doe");
        testStatus.setText("Pending");
        testResult.setText("Negative");
    }

    @FXML
    public void onStartClicked(ActionEvent actionEvent) {
        btnStartCollection.setDisable(true);
        if (maskCb.isSelected() && sanitizeCb.isSelected() && eyeCb.isSelected() &&
                gloveCb.isSelected() && ppeCb.isSelected()) {

            System.out.println("Safety protocols confirmed. Starting collection...");


            try {
                // 1. Load the new FXML file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/covidmanagementapp/Kumkum/LabResultEntry.fxml"));
                Parent root = loader.load();

                // 2. Get the current window (Stage) using the button
                Stage stage = (Stage) btnStartCollection.getScene().getWindow();

                // 3. Switch the scene
                stage.setScene(new Scene(root));
                stage.setTitle("Result Entry");
                stage.show();

            } catch (IOException e) {
                System.out.println("Error: Could not find LabResultEntry.fxml!");
                e.printStackTrace();
            }

        } else {
            btnStartCollection.setDisable(false);
            System.out.println("Warning: You must complete the safety checklist first!");
        }
    }
}
