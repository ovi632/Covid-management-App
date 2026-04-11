package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VaccinationRecordEntryController
{
    @javafx.fxml.FXML
    private ComboBox<String> doseNumberCB;
    @javafx.fxml.FXML
    private TextField batchNumberTF;
    @javafx.fxml.FXML
    private DatePicker vaccinationDateDP;
    @javafx.fxml.FXML
    private TextField registrationIDTF;
    @javafx.fxml.FXML
    private ComboBox<String> vaccinationCenterCB;
    @javafx.fxml.FXML
    private TextField vaccineNameTF;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField observationNotesTF;
    private int currentPatientId = -1;
    private String currentPatientName = "";

    @javafx.fxml.FXML
    public void initialize() {
        doseNumberCB.getItems().addAll("1st Dose", "2nd Dose", "Booster");
        vaccinationCenterCB.getItems().addAll("Dhaka Center", "Gulshan Center", "Dhanmondi Center");
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/healthDataEntryOperatorDashboardView.fxml"));
            Scene updatePatientRecordViewScene = new Scene(fxmlLoader.load());
            Stage updatePatientRecordViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updatePatientRecordViewStage.setTitle(" Pharmacy Dashboard");
            updatePatientRecordViewStage.setScene(updatePatientRecordViewScene);
            updatePatientRecordViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void verifyButtonOA(ActionEvent actionEvent) {
        try {

            String idText = registrationIDTF.getText().trim();

            if (idText.isEmpty()) {
                errorLabel.setText("Enter ID!");
                return;
            }

            int id = Integer.parseInt(idText);

            com.example.covidmanagementapp.User.UserFile.loadUsers();

            for (com.example.covidmanagementapp.User.User u :
                    com.example.covidmanagementapp.User.UserFile.userList) {

                if (u.getUserId() == id) {

                    currentPatientId = id;
                    currentPatientName = u.getName();

                    errorLabel.setText("Verified: " + currentPatientName);
                    return;
                }
            }

            errorLabel.setText("Patient not found!");

        } catch (Exception e) {
            errorLabel.setText("Invalid ID!");
        }
    }

    @javafx.fxml.FXML
    public void saveButtonOA(ActionEvent actionEvent) {
        try {

            if (currentPatientId == -1) {
                errorLabel.setText("Verify patient first!");
                return;
            }

            if (doseNumberCB.getValue() == null ||
                    vaccinationCenterCB.getValue() == null ||
                    vaccineNameTF.getText().trim().isEmpty() ||
                    batchNumberTF.getText().trim().isEmpty() ||
                    vaccinationDateDP.getValue() == null) {

                errorLabel.setText("Fill all fields!");
                return;
            }

            VaccinationRecord record = new VaccinationRecord(
                    currentPatientId,
                    currentPatientName,
                    doseNumberCB.getValue().toString(),
                    vaccineNameTF.getText().trim(),
                    batchNumberTF.getText().trim(),
                    vaccinationCenterCB.getValue().toString(),
                    vaccinationDateDP.getValue().toString(),
                    observationNotesTF.getText().trim()
            );

            java.io.File file = new java.io.File("VaccinationRecord.bin");
            java.io.ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new java.io.FileOutputStream(file, true)
                );
            } else {
                oos = new java.io.ObjectOutputStream(
                        new java.io.FileOutputStream(file)
                );
            }

            oos.writeObject(record);
            oos.close();

            errorLabel.setText("Saved for " + currentPatientName);

            registrationIDTF.clear();
            vaccineNameTF.clear();
            batchNumberTF.clear();
            observationNotesTF.clear();
            doseNumberCB.setValue(null);
            vaccinationCenterCB.setValue(null);
            vaccinationDateDP.setValue(null);

            currentPatientId = -1;
            currentPatientName = "";

        } catch (Exception e) {
            errorLabel.setText("Error saving!");
        }
    }
}