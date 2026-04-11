package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.Ashraf.Patient;
import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.User;
import com.example.covidmanagementapp.User.UserFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewPatientRecordsController
{
    @javafx.fxml.FXML
    private TableColumn<Patient,Integer> patientIDTC;
    @javafx.fxml.FXML
    private TableView<Patient> viewPatientRecordsTV;
    @javafx.fxml.FXML
    private TableColumn<Patient,String>  nameTC;
    @javafx.fxml.FXML
    private TableColumn<Patient,String>  diagonalsSummaryTC;
    @javafx.fxml.FXML
    private TableColumn<Patient,String>  testResultsSummaryTC;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn <Patient,String> covidStatusTC;
    @javafx.fxml.FXML
    private TextField patientSearchTF;
    @javafx.fxml.FXML
    private TableColumn<Patient,String>  vaccinationDetailsTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        try {

            String text = patientSearchTF.getText().trim();

            if (text.isEmpty()) {
                errorLabel.setText("Enter ID!");
                return;
            }

            int id = Integer.parseInt(text);

            UserFile.loadUsers();

            viewPatientRecordsTV.getItems().clear();

            boolean found = false;

            for (User u : UserFile.userList) {

                if (u.getUserId() == id) {
                    viewPatientRecordsTV.getItems().add(u);
                    found = true;
                }
            }

            if (!found) {
                errorLabel.setText("Patient not found!");
            } else {
                errorLabel.setText("Loaded!");
            }

            patientSearchTF.clear();

        } catch (Exception e) {
            errorLabel.setText("Invalid ID!");
        }
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/healthDataEntryOperatorDashboardView.fxml"));
            Scene updatePatientRecordViewScene = new Scene(fxmlLoader.load());
            Stage updatePatientRecordViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updatePatientRecordViewStage.setTitle(" Health Data Entry Operator Dashboard");
            updatePatientRecordViewStage.setScene(updatePatientRecordViewScene);
            updatePatientRecordViewStage.show();
        }catch (Exception e){
            //
        }
    }
}