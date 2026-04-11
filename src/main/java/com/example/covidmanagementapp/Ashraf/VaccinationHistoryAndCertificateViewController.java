package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class VaccinationHistoryAndCertificateViewController
{
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> doseNumberTC;
    @javafx.fxml.FXML
    private TextField vaccinationIdTF;
    @javafx.fxml.FXML
    private Label certificateStatusLabel;
    @javafx.fxml.FXML
    private TableView<Vaccination> vaccinationHistoryAndCertificateTV;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> vaccineNameTC;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> vaccinationDateTC;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> vaccinationCenterTC;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, Integer> staffIDTC;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
        doseNumberTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getDoseNumber()));

        vaccineNameTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getVaccineType()));

        vaccinationDateTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getDate()));

        vaccinationCenterTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getCenter()));

        // 🔥 FIXED VALUE
        staffIDTC.setCellValueFactory(c ->
                new SimpleObjectProperty<>(2430783));
    }

    @javafx.fxml.FXML
    public void checkCertificateStatusButtonOA(ActionEvent actionEvent) {
        if (vaccinationHistoryAndCertificateTV.getItems().isEmpty()) {
            certificateStatusLabel.setText("No record found!");
        } else {
            certificateStatusLabel.setText("Certificate: Not Ready");
        }
    }

    @javafx.fxml.FXML
    public void searchRecordButtonOA(ActionEvent actionEvent) {
        try {

            String idText = vaccinationIdTF.getText().trim();

            if (idText.isEmpty()) {
                errorLabel.setText("Enter ID!");
                return;
            }

            int id = Integer.parseInt(idText);

            File file = new File("Vaccination.bin");

            if (!file.exists()) {
                errorLabel.setText("No data found!");
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            vaccinationHistoryAndCertificateTV.getItems().clear();

            boolean found = false;

            while (true) {
                try {

                    Vaccination v = (Vaccination) ois.readObject();

                    if (v.getPatientId() == id) {

                        vaccinationHistoryAndCertificateTV.getItems().add(v);
                        found = true;
                    }

                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            if (!found) {
                errorLabel.setText("No records found!");
                certificateStatusLabel.setText("");
            } else {
                errorLabel.setText("Data loaded!");
                certificateStatusLabel.setText("Certificate: Not Ready");
            }

            vaccinationIdTF.clear();

        } catch (Exception e) {
            errorLabel.setText("Invalid ID!");
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