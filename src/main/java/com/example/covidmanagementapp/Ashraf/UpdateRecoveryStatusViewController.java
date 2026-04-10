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

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class UpdateRecoveryStatusViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> newRecoveryStatusCB;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private DatePicker statusUpdateDateDatePicker;
    @javafx.fxml.FXML
    private TextField doctorNotes;
    @javafx.fxml.FXML
    private Label infoShowLabel;

    @javafx.fxml.FXML
    public void initialize() {

        newRecoveryStatusCB.getItems().addAll("Recovered", "Not Recovered", "Under Treatment");

        statusUpdateDateDatePicker.setValue(LocalDate.now());
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
            int id = Integer.parseInt(registrationIdTF.getText());

            UserFile.loadUsers();

            for (User u : UserFile.userList) {

                if (u.getUserId() == id && u.getRole().equals("Patient")) {

                    infoShowLabel.setText(
                            "Name: " + u.getName() +
                                    "\nRole: " + u.getRole()
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

            int patientId = Integer.parseInt(registrationIdTF.getText());
            int doctorId = UserFile.currentUser.getUserId();

            String status = newRecoveryStatusCB.getValue();
            String notes = doctorNotes.getText();

            if (status == null) {
                notificationLabel.setText("Select recovery status!");
                return;
            }

            if (statusUpdateDateDatePicker.getValue() == null) {
                notificationLabel.setText("Select date!");
                return;
            }

            String date = statusUpdateDateDatePicker.getValue().toString();

            // 🔥 SAVE DATA
            String fullData = "PatientID: " + patientId +
                    ", RecoveryStatus: " + status +
                    ", Notes: " + notes +
                    ", Date: " + date +
                    ", DoctorID: " + doctorId;

            ObjectOutputStream oos;
            File file = new File("RecoveryStatus.bin");

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(
                        new FileOutputStream(file)
                );
            }

            oos.writeObject(fullData);
            oos.close();

            notificationLabel.setText("Recovery Status Saved!");

        } catch (Exception e) {
            notificationLabel.setText("Error! Check input.");
        }
    }
}