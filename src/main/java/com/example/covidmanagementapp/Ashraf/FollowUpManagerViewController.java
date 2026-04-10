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

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FollowUpManagerViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private TextField followUpTimeTF;
    @javafx.fxml.FXML
    private Label infoShowLabel;
    @javafx.fxml.FXML
    private TextField followUpNoteTF;
    @javafx.fxml.FXML
    private DatePicker followUpDatePicker;
    private String currentPatientName = "";
    private int currentPatientId = -1;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void saveFollowUpButtonOA(ActionEvent actionEvent) {
        try {

            if (currentPatientId == -1) {
                notificationLabel.setText("Search patient first!");
                return;
            }

            if (followUpDatePicker.getValue() == null ||
                    followUpTimeTF.getText().trim().isEmpty() ||
                    followUpNoteTF.getText().trim().isEmpty()) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            String date = followUpDatePicker.getValue().toString();
            String time = followUpTimeTF.getText().trim();
            String note = followUpNoteTF.getText().trim();

            int doctorId = UserFile.currentUser.getUserId();

            FollowUp f = new FollowUp(
                    currentPatientId,
                    currentPatientName,
                    doctorId,
                    date,
                    time,
                    note
            );

            File file = new File("FollowUp.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(f);
            oos.close();
            infoShowLabel.setText(
                    "Saved!\nName: " + currentPatientName +
                            "\nID: " + currentPatientId +
                            "\nFollow-up Date: " + date
            );

            registrationIdTF.clear();
            followUpTimeTF.clear();
            followUpNoteTF.clear();
            followUpDatePicker.setValue(null);

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
    public void backToDashboard(ActionEvent actionEvent) {
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