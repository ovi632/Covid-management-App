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
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class DoctorAppointmentViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> appoinmentTypeCB;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private ComboBox <String>doctorListCB;
    @javafx.fxml.FXML
    private DatePicker appoitmentDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> timeSlotCB;

    @javafx.fxml.FXML
    public void initialize() {
        doctorListCB.getItems().addAll("Ashraf", "Ishika", "Anamika", "Kumkum");

        appoinmentTypeCB.getItems().addAll("Online", "Offline");

        timeSlotCB.getItems().addAll("10:00 AM", "12:00 PM", "3:00 PM", "6:00 PM");
    }

    @javafx.fxml.FXML
    public void submitAppoinmentButtonOA(ActionEvent actionEvent) {
        try {
            if (doctorListCB.getValue() == null ||
                    appoinmentTypeCB.getValue() == null ||
                    timeSlotCB.getValue() == null ||
                    appoitmentDatePicker.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }
            String doctor = doctorListCB.getValue();
            String type = appoinmentTypeCB.getValue();
            String time = timeSlotCB.getValue();
            String date = appoitmentDatePicker.getValue().toString();

            int patientId = UserFile.currentUser.getUserId();
            String patientName = UserFile.currentUser.getName();

            Appointment a = new Appointment(
                    patientId,
                    patientName,
                    doctor,
                    type,
                    date,
                    time
            );

            File file = new File("Appointment.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(a);
            oos.close();

            notificationLabel.setText("Appointment booked!");

            doctorListCB.setValue(null);
            appoinmentTypeCB.setValue(null);
            timeSlotCB.setValue(null);
            appoitmentDatePicker.setValue(null);

        } catch (Exception e) {
            notificationLabel.setText("Error saving!");
        }
    }


    @javafx.fxml.FXML
    public void checkAvailabityButtonOA(ActionEvent actionEvent) {
        try {

            if (doctorListCB.getValue() == null) {
                notificationLabel.setText("Select a doctor!");
                return;
            }

            String selectedDoctor = doctorListCB.getValue();

            UserFile.loadUsers();

            for (User u : UserFile.userList) {
                if (u.getName().equalsIgnoreCase(selectedDoctor)
                        && u.getRole().equalsIgnoreCase("Doctor")) {

                    notificationLabel.setText("Available ");
                    return;
                }
            }

            notificationLabel.setText("Not Available ");

        } catch (Exception e) {
            notificationLabel.setText("Error!");
        }
    }
    @javafx.fxml.FXML
    public void backToDeshboardButtonOA(ActionEvent actionEvent) {
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