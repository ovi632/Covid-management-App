package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPatientDataViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private TextField ageTF;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private TextField addressTF;
    @javafx.fxml.FXML
    private TextField patientNameTF;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backbuttonOA(ActionEvent actionEvent) {
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
    public void saveButtonOA(ActionEvent actionEvent) {
        try {

            String name = patientNameTF.getText().trim();
            String ageText = ageTF.getText().trim();
            String phone = phoneNumberTF.getText().trim();
            String address = addressTF.getText().trim();

            if (name.isEmpty() || ageText.isEmpty() ||
                    phone.isEmpty() || address.isEmpty()) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            if (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected()) {
                notificationLabel.setText("Select gender!");
                return;
            }

            int age = Integer.parseInt(ageText);

            String gender = maleRadioButton.isSelected() ? "Male" : "Female";

            PatientData p = new PatientData(name, age, gender, phone, address);

            java.io.File file = new java.io.File("PatientData.bin");
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

            oos.writeObject(p);
            oos.close();

            notificationLabel.setText("Patient Data Saved!");

            patientNameTF.clear();
            ageTF.clear();
            phoneNumberTF.clear();
            addressTF.clear();
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);

        } catch (Exception e) {
            notificationLabel.setText("Error saving data!");
        }
    }
}