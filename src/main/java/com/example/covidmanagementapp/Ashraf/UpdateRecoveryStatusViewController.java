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
    private String currentPatientName = "";
    private int currentPatientId = -1;


    @javafx.fxml.FXML
    public void initialize() {
        newRecoveryStatusCB.getItems().addAll(
                "Recovered",
                "Under Treatment",
                "Critical",
                "Discharged"
        );

        statusUpdateDateDatePicker.setValue(LocalDate.now());
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
            registrationIdTF.clear();

        } catch (Exception e) {
            notificationLabel.setText("Invalid ID!");
        }
    }

    @javafx.fxml.FXML
    public void saveStatusButtonOA(ActionEvent actionEvent) {
        try {

            if (currentPatientId == -1) {
                notificationLabel.setText("Search patient first!");
                return;
            }

            if (newRecoveryStatusCB.getValue() == null ||
                    doctorNotes.getText().trim().isEmpty() ||
                    statusUpdateDateDatePicker.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            String status = newRecoveryStatusCB.getValue();
            String notes = doctorNotes.getText().trim();
            String date = statusUpdateDateDatePicker.getValue().toString();

            int doctorId = UserFile.currentUser.getUserId();

            RecoveryStatus rs = new RecoveryStatus(
                    currentPatientId,
                    currentPatientName,
                    status,
                    notes,
                    date,
                    doctorId
            );

            File file = new File("RecoveryStatus.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(rs);
            oos.close();
     ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            RecoveryStatus last = null;

            while (true) {
                try {
                    last = (RecoveryStatus) ois.readObject();
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();

            infoShowLabel.setText(
                    "Saved!\nName: " + last.getPatientName() +
                            "\nID: " + last.getPatientId() +
                            "\nStatus: " + last.getStatus()
            );

            registrationIdTF.clear();
            doctorNotes.clear();
            newRecoveryStatusCB.setValue(null);
            statusUpdateDateDatePicker.setValue(null);

            currentPatientId = -1;
            currentPatientName = "";

        } catch (Exception e) {
            notificationLabel.setText("Error saving!");
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