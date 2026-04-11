package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdatePatientRecordViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField ageButtonOA;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private TextField addressTF;
    @javafx.fxml.FXML
    private TextField patientNameTF;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private TextField patientIDTF;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private ComboBox<String> covidStatusCB;

    @javafx.fxml.FXML
    public void initialize() {
        covidStatusCB.getItems().addAll("Positive", "Negative", "Recovered", "Critical");
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        try {

            String idText = patientIDTF.getText().trim();

            if (idText.isEmpty()) {
                errorLabel.setText("Enter ID!");
                return;
            }

            int id = Integer.parseInt(idText);

            com.example.covidmanagementapp.User.UserFile.loadUsers();

            for (com.example.covidmanagementapp.User.User u : com.example.covidmanagementapp.User.UserFile.userList) {

                if (u.getUserId() == id) {

                    patientNameTF.setText(u.getName());
                    errorLabel.setText("Patient Found");
                    return;
                }
            }

            errorLabel.setText("Patient not found!");

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
            updatePatientRecordViewStage.setTitle("health DataEntry Operator DashboardView");
            updatePatientRecordViewStage.setScene(updatePatientRecordViewScene);
            updatePatientRecordViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {
        patientIDTF.clear();
        patientNameTF.clear();
        ageButtonOA.clear();
        addressTF.clear();
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
        covidStatusCB.setValue(null);
        errorLabel.setText("");
        notificationLabel.setText("");
    }

    @javafx.fxml.FXML
    public void updateButtonOA(ActionEvent actionEvent) {
        try {

            String idText = patientIDTF.getText().trim();
            String name = patientNameTF.getText().trim();
            String ageText = ageButtonOA.getText().trim();
            String address = addressTF.getText().trim();

            if (idText.isEmpty() || name.isEmpty() || ageText.isEmpty() || address.isEmpty() || covidStatusCB.getValue() == null) {
                errorLabel.setText("Fill all fields!");
                return;
            }

            int id = Integer.parseInt(idText);
            int age = Integer.parseInt(ageText);

            String gender = maleRadioButton.isSelected() ? "Male" : "Female";

            UpdatedPatientRecord record = new UpdatedPatientRecord(
                    id,
                    name,
                    age,
                    gender,
                    address,
                    covidStatusCB.getValue().toString()
            );

            java.io.File file = new java.io.File("UpdatedPatientRecord.bin");
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

            notificationLabel.setText("Updated: " + name + " (ID: " + id + ")");

        } catch (Exception e) {
            errorLabel.setText("Error saving!");
        }
    }
}