package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class doctorCheckPatientInfoViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn<Patient,Integer> ageInPatientInfoTC;
    @javafx.fxml.FXML
    private TableColumn<Patient,String> nameInPatientInfoTC;
    @javafx.fxml.FXML
    private TableColumn<Patient,String> previousDiagnosesInPatientInfoTC;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private Label infoShowLabel;
    @javafx.fxml.FXML
    private TableColumn<Patient,String> genderInPatientInfoTC;
    @javafx.fxml.FXML
    private TableView<Patient> patientInfoTableView;

    @javafx.fxml.FXML
    public void initialize() {
        nameInPatientInfoTC.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("name"));

        ageInPatientInfoTC.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("age"));

        genderInPatientInfoTC.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("gender"));
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/doctorDashBoardView.fxml"));
            Scene updateRecoveryStatusViewscene = new Scene(fxmlLoader.load());
            Stage updateRecoveryStatusViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updateRecoveryStatusViewStage.setTitle("Doctor Dashboard");
            updateRecoveryStatusViewStage.setScene(updateRecoveryStatusViewscene);
            updateRecoveryStatusViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void SearchButtonOA(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(registrationIdTF.getText());

            PatientFile.loadPatients();

            patientInfoTableView.getItems().clear();

            for (Patient p : PatientFile.patientList) {

                if (p.getId() == id) {

                    patientInfoTableView.getItems().add(p);

                    notificationLabel.setText("Patient Found!");
                    return;
                }
            }

            notificationLabel.setText("Patient not found!");

        } catch (Exception e) {
            notificationLabel.setText("Enter valid ID!");
        }

    }

}