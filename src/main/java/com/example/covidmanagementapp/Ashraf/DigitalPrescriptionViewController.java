package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.User;
import com.example.covidmanagementapp.User.UserFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class DigitalPrescriptionViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField durationTF;
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private DatePicker prescribedDateDatePicker;
    @javafx.fxml.FXML
    private TextField dosageTF;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private TextField additionalInstructionsTF;
    @javafx.fxml.FXML
    private Label infoShowLabel;

    private String currentPatientName = "";
    private int currentPatientId = -1;

    @javafx.fxml.FXML
    public void initialize() {
        prescribedDateDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void SavePrescriptionButtonOA(ActionEvent actionEvent) {
        try {


            if (currentPatientId == -1) {
                notificationLabel.setText("Search patient first!");
                return;
            }


            if (medicineNameTF.getText().trim().isEmpty() ||
                    dosageTF.getText().trim().isEmpty() ||
                    durationTF.getText().trim().isEmpty() ||
                    additionalInstructionsTF.getText().trim().isEmpty() ||
                    prescribedDateDatePicker.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            // 📥 GET DATA
            String medicine = medicineNameTF.getText().trim();
            String dosage = dosageTF.getText().trim();
            String duration = durationTF.getText().trim();
            String instructions = additionalInstructionsTF.getText().trim();
            String date = prescribedDateDatePicker.getValue().toString();

            int doctorId = UserFile.currentUser.getUserId();

            // 🧱 CREATE OBJECT
            Prescription p = new Prescription(
                    currentPatientId,
                    currentPatientName,
                    doctorId,
                    medicine,
                    dosage,
                    duration,
                    instructions,
                    date
            );

            // 💾 SAVE FILE
            File file = new File("Prescription.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(p);
            oos.close();

            // 📖 READ LAST
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Prescription last = null;

            while (true) {
                try {
                    last = (Prescription) ois.readObject();
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            infoShowLabel.setText(
                    "Saved!\nName: " + last.getPatientName() +
                            "\nMedicine: " + last.getMedicineName() +
                            "\nDate: " + last.getDate()
            );

            // 🧹 CLEAR
            registrationIdTF.clear();
            medicineNameTF.clear();
            dosageTF.clear();
            durationTF.clear();
            additionalInstructionsTF.clear();

            prescribedDateDatePicker.setValue(null);

            currentPatientId = -1;
            currentPatientName = "";

        } catch (Exception e) {
            notificationLabel.setText("Error saving!");
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/doctorDashBoardView.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Doctor Dashboard");
            stage.show();

        } catch (Exception e) {
            //
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

                    currentPatientName = u.getName();
                    currentPatientId = u.getUserId();

                    infoShowLabel.setText(
                            "Name: " + u.getName() +
                                    "\nRole: " + u.getRole()
                    );

                    notificationLabel.setText("Patient Found!" + currentPatientName);
                    return;
                }
            }

            notificationLabel.setText("Patient not found!");
            currentPatientId = -1;
            currentPatientName = "";

        } catch (Exception e) {
            notificationLabel.setText("Invalid ID!");
        }
    }
}