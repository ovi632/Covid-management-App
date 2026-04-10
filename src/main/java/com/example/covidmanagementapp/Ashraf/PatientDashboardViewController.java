package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PatientDashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void vaccinationAppoinmentButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/vaccinationAppointmentView.fxml"));
            Scene vaccinationAppointmentViewscene = new Scene(fxmlLoader.load());
            Stage vaccinationAppointmentViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            vaccinationAppointmentViewStage.setTitle("vaccination Appointment View");
            vaccinationAppointmentViewStage.setScene(vaccinationAppointmentViewscene);
            vaccinationAppointmentViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void laboratoryTestAppoinmentButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/labTestRequestView.fxml"));
            Scene labTestRequestViewscene = new Scene(fxmlLoader.load());
            Stage labTestRequestViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            labTestRequestViewStage.setTitle("Covid Management App");
            labTestRequestViewStage.setScene(labTestRequestViewscene);
            labTestRequestViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void doctorAppoinmentButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/doctorAppointmentView.fxml"));
            Scene labTestRequestViewscene = new Scene(fxmlLoader.load());
            Stage labTestRequestViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            labTestRequestViewStage.setTitle("doctor Appointment View");
            labTestRequestViewStage.setScene(labTestRequestViewscene);
            labTestRequestViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void viewLabTestResultsButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/labTestResultsView.fxml"));
            Scene labTestResultsViewscene = new Scene(fxmlLoader.load());
            Stage labTestResultsViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            labTestResultsViewStage.setTitle("labTest Results View");
            labTestResultsViewStage.setScene(labTestResultsViewscene);
            labTestResultsViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void diagnisis_PrescriptionsButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/diagnosisAndPrescriptionsView.fxml"));
            Scene diagnosisAndPrescriptionsViewscene = new Scene(fxmlLoader.load());
            Stage diagnosisAndPrescriptionsViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            diagnosisAndPrescriptionsViewStage.setTitle("diagnosis And Prescriptions View");
            diagnosisAndPrescriptionsViewStage.setScene(diagnosisAndPrescriptionsViewscene);
            diagnosisAndPrescriptionsViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void myHealthProfileButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/myHealthProfileView.fxml"));
            Scene myHealthProfileViewscene = new Scene(fxmlLoader.load());
            Stage myHealthProfileViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            myHealthProfileViewStage.setTitle("myHealth Profile View");
            myHealthProfileViewStage.setScene(myHealthProfileViewscene);
            myHealthProfileViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void emergencyAmbulanceButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/emergencyAmbulanceRequestView.fxml"));
            Scene emergencyAmbulanceRequestViewscene = new Scene(fxmlLoader.load());
            Stage emergencyAmbulanceRequestViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            emergencyAmbulanceRequestViewStage.setTitle("emergency AmbulanceRequest View");
            emergencyAmbulanceRequestViewStage.setScene(emergencyAmbulanceRequestViewscene);
            emergencyAmbulanceRequestViewStage.show();
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
    public void vaccinationHistoryAndCerticate(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/vaccinationHistoryAndCertificateView.fxml"));
            Scene vaccinationHistoryAndCertificateViewscene = new Scene(fxmlLoader.load());
            Stage vaccinationHistoryAndCertificateViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            vaccinationHistoryAndCertificateViewStage.setTitle("Covid Management App");
            vaccinationHistoryAndCertificateViewStage.setScene(vaccinationHistoryAndCertificateViewscene);
            vaccinationHistoryAndCertificateViewStage.show();
        }catch (Exception e){
            //
        }
    }
}