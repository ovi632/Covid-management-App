package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.UserFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class EmergencyAmbulanceRequestViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField currentLocationTF;
    @javafx.fxml.FXML
    private ComboBox<String> emergencyTypeCB;
    @javafx.fxml.FXML
    private TextField emergencyDescriptionTF;

    @javafx.fxml.FXML
    public void initialize() {
        emergencyTypeCB.getItems().addAll("Accident", "Breathing Problem", "Covid Emergency", "Heart Attack");

    }

    @javafx.fxml.FXML
    public void sendEmergencyRequestButtonOA(ActionEvent actionEvent) {
        try {

            if (currentLocationTF.getText().trim().isEmpty() ||
                    emergencyDescriptionTF.getText().trim().isEmpty() ||
                    emergencyTypeCB.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            String location = currentLocationTF.getText().trim();
            String type = emergencyTypeCB.getValue();
            String description = emergencyDescriptionTF.getText().trim();

            int patientId = UserFile.currentUser.getUserId();
            String patientName = UserFile.currentUser.getName();

            EmergencyRequest er = new EmergencyRequest(
                    patientId,
                    patientName,
                    location,
                    type,
                    description
            );

            File file = new File("Emergency.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(er);
            oos.close();

            notificationLabel.setText("Emergency Request Sent!");

            currentLocationTF.clear();
            emergencyDescriptionTF.clear();
            emergencyTypeCB.setValue(null);

        } catch (Exception e) {
            notificationLabel.setText("Error sending request!");
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