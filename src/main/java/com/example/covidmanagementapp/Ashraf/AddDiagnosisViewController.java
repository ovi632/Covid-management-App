package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.User;
import com.example.covidmanagementapp.User.UserFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class AddDiagnosisViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField diagnosisDetailsTF;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private ComboBox<String> severityCB;
    @javafx.fxml.FXML
    private ComboBox<String> dosageCB;
    @javafx.fxml.FXML
    private DatePicker visitDatePicker;
    @javafx.fxml.FXML
    private Label infoShowLabel;
    @javafx.fxml.FXML
    private TextField symptomsTF;
    private String currentPatientName = "";
    private int currentPatientId = -1;

    @javafx.fxml.FXML
    public void initialize() {
        severityCB.getItems().addAll("Low", "Medium", "High");
        dosageCB.getItems().addAll("1", "2", "3");

        visitDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void saveDiagnosisButtonOA(ActionEvent actionEvent) {
        try {

            if (currentPatientId == -1) {
                notificationLabel.setText("Search patient first!");
                return;
            }

            if (symptomsTF.getText().trim().isEmpty() ||
                    diagnosisDetailsTF.getText().trim().isEmpty() ||
                    severityCB.getValue() == null ||
                    dosageCB.getValue() == null ||
                    visitDatePicker.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            String symptoms = symptomsTF.getText().trim();
            String details = diagnosisDetailsTF.getText().trim();
            String severity = severityCB.getValue();
            String dosage = dosageCB.getValue();
            String date = visitDatePicker.getValue().toString();

            int doctorId = UserFile.currentUser.getUserId();

            Diagnosis d = new Diagnosis(
                    currentPatientId,
                    currentPatientName,
                    doctorId,
                    symptoms,
                    details,
                    severity,
                    dosage,
                    date
            );

            File file = new File("Diagnosis.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(d);
            oos.close();

            // 🔥 READ LAST
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Diagnosis last = null;

            while (true) {
                try {
                    last = (Diagnosis) ois.readObject();
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            infoShowLabel.setText(
                    "Saved!\nName: " + last.getPatientName() +
                            "\nSeverity: " + last.getSeverity()
            );

            // 🧹 CLEAR
            registrationIdTF.clear();
            symptomsTF.clear();
            diagnosisDetailsTF.clear();

            severityCB.setValue(null);
            dosageCB.setValue(null);
            visitDatePicker.setValue(null);

            currentPatientId = -1;
            currentPatientName = "";

        } catch (Exception e) {
            notificationLabel.setText("Error saving!");
        }
    }

    @javafx.fxml.FXML
    public void SearchButtonOA(ActionEvent actionEvent) {
        try {
            String idText = registrationIdTF.getText().trim();

            if (idText.isEmpty()) {
                notificationLabel.setText("Enter ID first!");
                return;
            }

            int id = Integer.parseInt(idText);

            UserFile.loadUsers();

            for (User u : UserFile.userList) {

                if (u.getUserId() == id) {

                    currentPatientId = u.getUserId();
                    currentPatientName = u.getName();

                    infoShowLabel.setText(
                            "Name: " + u.getName() +
                                    "\nRole: " + u.getRole()
                    );

                    notificationLabel.setText("Patient Found!");
                    return;
                }
            }

            notificationLabel.setText("Patient not found!");
            currentPatientId = -1;

        } catch (Exception e) {
            notificationLabel.setText("Invalid ID!");
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
}