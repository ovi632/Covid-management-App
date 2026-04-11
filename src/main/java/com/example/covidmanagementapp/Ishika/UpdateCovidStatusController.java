package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateCovidStatusController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField operatorNotesTF;
    @javafx.fxml.FXML
    private TextField patientIDTF;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private ComboBox covidStatusCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/healthDataEntryOperatorDashboardView.fxml"));
            Scene updateCovidStatusScene = new Scene(fxmlLoader.load());
            Stage updateCovidStatusStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            updateCovidStatusStage.setTitle("Health Data Entry Operator Dashboard");
            updateCovidStatusStage.setScene(updateCovidStatusScene);
            updateCovidStatusStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void loadPatientButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateButtonOA(ActionEvent actionEvent) {
    }
}