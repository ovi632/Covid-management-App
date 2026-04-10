package com.example.covidmanagementapp.Ashraf;
import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.UserFile;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UpdateCovidCaseStatusViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn<Patient,Integer> doctorID;
    @javafx.fxml.FXML
    private TextField doctorNotesTF;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private DatePicker statusUpdateDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Patient, String> UpdateDateTC;
    @javafx.fxml.FXML
    private Label infoShowLabel;
    @javafx.fxml.FXML
    private TableColumn<Patient,String> previousStatusTC;
    @javafx.fxml.FXML
    private ComboBox<String> newCovidStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn<Patient,String> updateStatusTC;
    @javafx.fxml.FXML
    private TableView<Patient> updateCovidCaseTV;

    @javafx.fxml.FXML
    public void initialize() {
        // ComboBox
        newCovidStatusComboBox.getItems().addAll("Positive", "Negative", "Recovered");

        // Table columns (from Patient class)
        previousStatusTC.setCellValueFactory(new PropertyValueFactory<>("disease"));

        updateStatusTC.setCellValueFactory(new PropertyValueFactory<>("disease"));
        UpdateDateTC.setCellValueFactory(cellData -> new SimpleStringProperty(java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        doctorID.setCellValueFactory(cellData -> new SimpleObjectProperty<>(UserFile.currentUser.getUserId()));
    }

    @javafx.fxml.FXML
    public void loadStatusHistoryButtonOA(ActionEvent actionEvent) {

        try {
            int id = Integer.parseInt(registrationIdTF.getText());

            PatientFile.loadPatients();

            updateCovidCaseTV.getItems().clear();

            for (Patient p : PatientFile.patientList) {

                if (p.getId() == id) {

                    updateCovidCaseTV.getItems().add(p);
                }
            }

            notificationLabel.setText("Status loaded!");

        } catch (Exception e) {
            notificationLabel.setText("Enter valid ID!");
        }

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

            for (Patient p : PatientFile.patientList) {

                if (p.getId() == id) {

                    infoShowLabel.setText(
                            "Name: " + p.getName() +
                                    "\nCurrent Status: " + p.getDisease()
                    );

                    notificationLabel.setText("Patient Found!");
                    return;
                }
            }

            notificationLabel.setText("Patient not found!");

        } catch (Exception e) {
            notificationLabel.setText("Enter valid ID!");
        }


    }

    @javafx.fxml.FXML
    public void saveStatusButtonOA(ActionEvent actionEvent) {
        try {

            int id = Integer.parseInt(registrationIdTF.getText());

            String newStatus = newCovidStatusComboBox.getValue();

            if (newStatus == null) {
                notificationLabel.setText("Select a status!");
                return;
            }
            int doctorId = UserFile.currentUser.getUserId();

            PatientFile.loadPatients();

            boolean found = false;

            for (Patient p : PatientFile.patientList) {

                if (p.getId() == id) {

                    p.setDisease(newStatus);

                    found = true;
                    break;
                }
            }

            if (!found) {
                notificationLabel.setText("Patient not found!");
                return;
            }

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("Patient.bin")
            );

            for (Patient p : PatientFile.patientList) {
                oos.writeObject(p);
            }

            oos.close();

            notificationLabel.setText("Updated by Doctor ID: " + doctorId);

            updateCovidCaseTV.getItems().clear();

            for (Patient p : PatientFile.patientList) {
                if (p.getId() == id) {
                    updateCovidCaseTV.getItems().add(p);
                }
            }

        } catch (Exception e) {
            notificationLabel.setText("Error! Check input.");
        }
    }
}