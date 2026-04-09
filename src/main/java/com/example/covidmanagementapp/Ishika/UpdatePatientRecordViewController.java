package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdatePatientRecordViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField ageButtonOA;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private TextField addressTF;
    @javafx.fxml.FXML
    private TextField patientNameTF;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private TextField patientIDTF;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/healthDataEntryOperatorDashboardView.fxml"));
            Scene updatePatientRecordViewScene = new Scene(fxmlLoader.load());
            Stage updatePatientRecordViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updatePatientRecordViewStage.setTitle(" Pharmacy Dashboard");
            updatePatientRecordViewStage.setScene(updatePatientRecordViewScene);
            updatePatientRecordViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateButtonOA(ActionEvent actionEvent) {
    }
}