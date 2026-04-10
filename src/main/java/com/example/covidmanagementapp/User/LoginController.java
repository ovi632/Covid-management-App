package com.example.covidmanagementapp.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginController
{
    @javafx.fxml.FXML
    private PasswordField enterIdTF;
    @javafx.fxml.FXML
    private Label createAccountLabel;
    @javafx.fxml.FXML
    private Label loginLabel;
    @javafx.fxml.FXML
    private PasswordField passInputTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createNewAccountButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loginButtonOA( String role ,ActionEvent actionEvent) {
        try {
            FXMLLoader loader = null;

            if (role.equals("Doctor")) {
                loader = new FXMLLoader(getClass().getResource("/com/example/covidmanagementapp/Ashraf/doctorDashBoardView.fxml"));
            }
            else if (role.equals("Patient")) {
                loader = new FXMLLoader(getClass().getResource("/com/example/covidmanagementapp/Ashraf/patientDashboardView.fxml"));
            }
            else if (role.equals("Pharmacy")) {
                loader = new FXMLLoader(getClass().getResource("/Pharmacy/PharmacyDashboard.fxml"));
            }
            else if (role.equals("Health Data Entry Operator")) {
                loader = new FXMLLoader(getClass().getResource("/Operator/OperatorDashboard.fxml"));
            }
            else if (role.equals("Lab Technician")) {
                loader = new FXMLLoader(getClass().getResource("/Lab/LabDashboard.fxml"));
            }
            else if (role.equals("Vaccination Staff")) {
                loader = new FXMLLoader(getClass().getResource("/Vaccination/VaccinationDashboard.fxml"));
            }
            else if (role.equals("Emergency Ambulance Staff")) {
                loader = new FXMLLoader(getClass().getResource("/Emergency/EmergencyDashboard.fxml"));
            }
            else if (role.equals("Nurse")) {
                loader = new FXMLLoader(getClass().getResource("/Nurse/NurseDashboard.fxml"));
            }

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle(role + " Dashboard");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
           //
        }
    }
}