package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DoctorDashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void patientInfoButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/doctorCheckPatientInfoView.fxml"));
            Scene doctorCheckPatientInfoViewscene = new Scene(fxmlLoader.load());
            Stage doctorCheckPatientInfoViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            doctorCheckPatientInfoViewStage.setTitle("Patient Information View");
            doctorCheckPatientInfoViewStage.setScene(doctorCheckPatientInfoViewscene);
            doctorCheckPatientInfoViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void digitalPrescriptionButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/digitalPrescription.fxml"));
            Scene digitalPrescriptionViewscene = new Scene(fxmlLoader.load());
            Stage digitalPrescriptionStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            digitalPrescriptionStage.setTitle("Digital Prescription View");
            digitalPrescriptionStage.setScene(digitalPrescriptionViewscene);
            digitalPrescriptionStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void updateCovidCaseStatusButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/updateCovidCaseStatusView.fxml"));
            Scene updateCovidCaseStatusViewscene = new Scene(fxmlLoader.load());
            Stage updateCovidCaseStatusViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updateCovidCaseStatusViewStage.setTitle("Covid Management App");
            updateCovidCaseStatusViewStage.setScene(updateCovidCaseStatusViewscene);
            updateCovidCaseStatusViewStage.show();
        }catch (Exception e){
            //
        }

    }

    @javafx.fxml.FXML
    public void covidStatisticsButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/covidStaticsView.fxml"));
            Scene covidStaticsViewscene = new Scene(fxmlLoader.load());
            Stage covidStaticsViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            covidStaticsViewStage.setTitle("Covid Management App");
            covidStaticsViewStage.setScene(covidStaticsViewscene);
            covidStaticsViewStage.show();
        }catch (Exception e){
            //
        }

    }

    @javafx.fxml.FXML
    public void quarantineInstructionsButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/quarantineInstructionsView.fxml"));
            Scene covidStaticsViewscene = new Scene(fxmlLoader.load());
            Stage covidStaticsViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            covidStaticsViewStage.setTitle("Covid Management App");
            covidStaticsViewStage.setScene(covidStaticsViewscene);
            covidStaticsViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void updateRecoveryStatusButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/updateRecoveryStatusView.fxml"));
            Scene updateRecoveryStatusViewscene = new Scene(fxmlLoader.load());
            Stage updateRecoveryStatusViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updateRecoveryStatusViewStage.setTitle("Covid Management App");
            updateRecoveryStatusViewStage.setScene(updateRecoveryStatusViewscene);
            updateRecoveryStatusViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void folloupButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/followUpManagerView.fxml"));
            Scene followUpManagerViewscene = new Scene(fxmlLoader.load());
            Stage followUpManagerViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            followUpManagerViewStage.setTitle("Covid Management App");
            followUpManagerViewStage.setScene(followUpManagerViewscene);
            followUpManagerViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void logOutButtonOA(ActionEvent actionEvent) {

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/User/loginView.fxml"));
            Scene updateRecoveryStatusViewscene = new Scene(fxmlLoader.load());
            Stage updateRecoveryStatusViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updateRecoveryStatusViewStage.setTitle("Covid Management App");
            updateRecoveryStatusViewStage.setScene(updateRecoveryStatusViewscene);
            updateRecoveryStatusViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void addDiagnosisButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/addDiagnosisView.fxml"));
            Scene followUpManagerViewscene = new Scene(fxmlLoader.load());
            Stage followUpManagerViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            followUpManagerViewStage.setTitle("Covid Management App");
            followUpManagerViewStage.setScene(followUpManagerViewscene);
            followUpManagerViewStage.show();
        }catch (Exception e){
            //
        }
    }
}