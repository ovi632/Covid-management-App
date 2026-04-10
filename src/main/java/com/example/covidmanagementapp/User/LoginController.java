package com.example.covidmanagementapp.User;

import com.example.covidmanagementapp.HelloApplication;
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
    public void loginButtonOA(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(enterIdTF.getText());
            String password = passInputTF.getText();

            UserFile.loadUsers();

            for (User u : UserFile.userList) {

                if (u.getUserId() == id && u.getPassword().equals(password)) {
                    UserFile.currentUser = u;

                    openDashboard(u.getRole(), actionEvent);
                    return;
                }
            }

            loginLabel.setText("Invalid ID or Password!");

        } catch (Exception e) {
            loginLabel.setText("Enter valid ID!");
        }
    }

    public void openDashboard(String role, ActionEvent actionEvent) {

        try {

            FXMLLoader fxmlLoader = null;

            if (role.equals("Doctor")) {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/doctorDashBoardView.fxml"));
            }
            else if (role.equals("Patient")) {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/patientDashboardView.fxml"));
            }
            else if (role.equals("Pharmacy")) {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            }
            else if (role.equals("Health Data Entry Operator")) {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/healthDataEntryOperatorDashboardView.fxml"));
            }
            else if (role.equals("Lab Technician")) {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Lab/LabDashboard.fxml"));
            }
            else if (role.equals("Vaccination Staff")) {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Vaccination/VaccinationDashboard.fxml"));
            }
            else if (role.equals("Emergency Ambulance Staff")) {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Emergency/EmergencyDashboard.fxml"));
            }
            else if (role.equals("Nurse")) {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Nurse/NurseDashboard.fxml"));
            }

            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle(role + " Dashboard");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
           //
        }
    }
    @javafx.fxml.FXML
    public void createNewAccountButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/User/createAccount.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
          //
        }
    }




}