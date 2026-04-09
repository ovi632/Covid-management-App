package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VaccinationRecordEntryController
{
    @javafx.fxml.FXML
    private ComboBox doseNumberCB;
    @javafx.fxml.FXML
    private TextField batchNumberTF;
    @javafx.fxml.FXML
    private DatePicker vaccinationDateDP;
    @javafx.fxml.FXML
    private TextField registrationIDTF;
    @javafx.fxml.FXML
    private ComboBox vaccinationCenterCB;
    @javafx.fxml.FXML
    private TextField vaccineNameTF;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField observationNotesTF;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void verifyButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButtonOA(ActionEvent actionEvent) {
    }
}