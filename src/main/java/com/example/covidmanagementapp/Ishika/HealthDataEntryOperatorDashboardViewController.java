package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HealthDataEntryOperatorDashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updatePatientRecordButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/updatePatientRecordView.fxml"));
            Scene updatePatientRecordViewScene = new Scene(fxmlLoader.load());
            Stage updatePatientRecordViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updatePatientRecordViewStage.setTitle("Update Patient Record Window");
            updatePatientRecordViewStage.setScene(updatePatientRecordViewScene);
            updatePatientRecordViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void patientDischargeManagerButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/patientDischargeManagerView.fxml"));
            Scene patientDischargeManagerViewScene = new Scene(fxmlLoader.load());
            Stage patientDischargeManagerViewStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            patientDischargeManagerViewStage.setTitle("Discharge Manager Window");
            patientDischargeManagerViewStage.setScene(patientDischargeManagerViewScene);
            patientDischargeManagerViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void vaccinationRecordEntryButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/vaccinationRecordEntry.fxml"));
            Scene vaccinationRecordEntryScene = new Scene(fxmlLoader.load());
            Stage vaccinationRecordEntryStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            vaccinationRecordEntryStage.setTitle("Vaccination Record Entry Window");
            vaccinationRecordEntryStage.setScene(vaccinationRecordEntryScene);
            vaccinationRecordEntryStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void viewPatientRecordsButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/viewPatientRecords.fxml"));
            Scene viewPatientRecordsScene = new Scene(fxmlLoader.load());
            Stage viewPatientRecordsStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            viewPatientRecordsStage.setTitle("View Patient Records Window");
            viewPatientRecordsStage.setScene(viewPatientRecordsScene);
            viewPatientRecordsStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void generateReportButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/generateDailyCovidReportView.fxml"));
            Scene generateDailyCovidReportViewScene = new Scene(fxmlLoader.load());
            Stage generateDailyCovidReportViewStage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            generateDailyCovidReportViewStage.setTitle("Generate Report Window");
            generateDailyCovidReportViewStage.setScene(generateDailyCovidReportViewScene);
            generateDailyCovidReportViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void addPatientDataButtoonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/addPatientDataView.fxml"));
            Scene addPatientDataViewScene = new Scene(fxmlLoader.load());
            Stage addPatientDataViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            addPatientDataViewStage.setTitle("Add Patient Data Window");
            addPatientDataViewStage.setScene(addPatientDataViewScene);
            addPatientDataViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void logoutButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateCovidStatusButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/updateCovidStatus.fxml"));
            Scene updateCovidStatusScene = new Scene(fxmlLoader.load());
            Stage updateCovidStatusStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            updateCovidStatusStage.setTitle("Update Covid Status Window");
            updateCovidStatusStage.setScene(updateCovidStatusScene);
            updateCovidStatusStage.show();
        }catch (Exception e){
            //
        }
    }
}