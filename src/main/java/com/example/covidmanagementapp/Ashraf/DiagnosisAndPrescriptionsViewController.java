package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.UserFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class DiagnosisAndPrescriptionsViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> diagnosisSummaryTC;
    @javafx.fxml.FXML
    private TableColumn <Prescription, String>durationTC;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> prescribedMedicineTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> DateTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> dosageTC;
    @javafx.fxml.FXML
    private TableView<Prescription> diagnosisAndPrescriptionsTV;
    @javafx.fxml.FXML
    private TableColumn<Prescription, Integer> doctorIdTC;

    @javafx.fxml.FXML
    public void initialize() {
        prescribedMedicineTC.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        dosageTC.setCellValueFactory(new PropertyValueFactory<>("dosage"));
        durationTC.setCellValueFactory(new PropertyValueFactory<>("duration"));
        DateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        doctorIdTC.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        try {

            int patientId = UserFile.currentUser.getUserId();

            if (fromDatePicker.getValue() == null || toDatePicker.getValue() == null) {
                notificationLabel.setText("Select date range!");
                return;
            }

             LocalDate fromDate = fromDatePicker.getValue();
             LocalDate toDate = toDatePicker.getValue();

            File file = new File("Prescription.bin");

            if (!file.exists()) {
                notificationLabel.setText("No prescription data found!");
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            diagnosisAndPrescriptionsTV.getItems().clear();

            boolean found = false;

            while (true) {
                try {
                    Prescription p = (Prescription) ois.readObject();

                    if (p.getPatientId() == patientId) {

                        java.time.LocalDate recordDate = java.time.LocalDate.parse(p.getDate());

                        if ((recordDate.isEqual(fromDate) || recordDate.isAfter(fromDate)) &&
                                (recordDate.isEqual(toDate) || recordDate.isBefore(toDate))) {

                            diagnosisAndPrescriptionsTV.getItems().add(p);
                            found = true;
                        }
                    }

                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            if (!found) {
                notificationLabel.setText("No records found in this date range!");
            } else {
                notificationLabel.setText("Data loaded!");
            }

        } catch (Exception e) {
            notificationLabel.setText("Error loading data!");
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/patientDashboardView.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Patient Dashboard");
            stage.show();

        } catch (Exception e) {
            //
        }
    }
}