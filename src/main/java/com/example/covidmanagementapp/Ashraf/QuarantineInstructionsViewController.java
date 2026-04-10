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

public class QuarantineInstructionsViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> quarantineTypeCB;
    @javafx.fxml.FXML
    private TextField instructionDetailsTF;
    @javafx.fxml.FXML
    private DatePicker endDateDP;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private Label infoShowLabel;
    @javafx.fxml.FXML
    private ComboBox<String> allowedActivitiesCB;
    @javafx.fxml.FXML
    private DatePicker startDateDP;

    private String currentPatientName = "";
    private int currentPatientId = -1;


    @javafx.fxml.FXML
    public void initialize() {
        quarantineTypeCB.getItems().addAll("Home Quarantine", "Hospital Isolation", "ICU Isolation");
        allowedActivitiesCB.getItems().addAll("Rest Only", "Light Movement", "Essential Movement");
        startDateDP.setValue(LocalDate.now());
        endDateDP.setValue(LocalDate.now());
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

                    notificationLabel.setText(
                            "Name: " + u.getName() +
                                    "\nRole: " + u.getRole()
                    );

                    notificationLabel.setText(currentPatientName);
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
    public void saveInstructionsButtonOA(ActionEvent actionEvent) {
        try {

            if (currentPatientId == -1) {
                notificationLabel.setText("Search patient first!");
                return;
            }


            if (quarantineTypeCB.getValue() == null ||
                    allowedActivitiesCB.getValue() == null ||
                    instructionDetailsTF.getText().trim().isEmpty() ||
                    startDateDP.getValue() == null ||
                    endDateDP.getValue() == null) {

                infoShowLabel.setText("Fill all fields!");
                return;
            }


            if (endDateDP.getValue().isBefore(startDateDP.getValue())) {
                infoShowLabel.setText("End date must be after start date!");
                return;
            }

            String type = quarantineTypeCB.getValue();
            String activity = allowedActivitiesCB.getValue();
            String instructions = instructionDetailsTF.getText().trim();
            String startDate = startDateDP.getValue().toString();
            String endDate = endDateDP.getValue().toString();

            int doctorId = UserFile.currentUser.getUserId();


            Quarantine q = new Quarantine(
                    currentPatientId,
                    currentPatientName,
                    type,
                    activity,
                    instructions,
                    startDate,
                    endDate,
                    doctorId
            );

            File file = new File("Quarantine.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(new FileOutputStream(file, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(q);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Quarantine last = null;

            while (true) {
                try {
                    last = (Quarantine) ois.readObject();
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            infoShowLabel.setText(
                    "Saved!\nName: " + last.getPatientName() +
                            "\nID: " + last.getPatientId() +
                            "\nType: " + last.getType()
            );

            registrationIdTF.clear();
            instructionDetailsTF.clear();
            notificationLabel.setText("");

            quarantineTypeCB.setValue(null);
            allowedActivitiesCB.setValue(null);

            startDateDP.setValue(null);
            endDateDP.setValue(null);
            currentPatientId = -1;
            currentPatientName = "";

        } catch (Exception e) {
            notificationLabel.setText("Error saving data!");
        }
    }

}