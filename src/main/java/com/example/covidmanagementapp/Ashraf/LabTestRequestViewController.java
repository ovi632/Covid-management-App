package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LabTestRequestViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private DatePicker peferredTestDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> preferredTestSlotCB;
    @javafx.fxml.FXML
    private ComboBox <String>labLocationCB;
    @javafx.fxml.FXML
    private ComboBox<String> testTypeCB;

    @javafx.fxml.FXML
    public void initialize() {
        testTypeCB.getItems().addAll("PCR", "Antigen", "Blood Test");

        preferredTestSlotCB.getItems().addAll("10AM", "1PM", "4PM");

        labLocationCB.getItems().addAll("Dhaka Lab", "Gulshan Lab", "Dhanmondi Lab");
    }


    @javafx.fxml.FXML
    public void submitRequestButtonOA(ActionEvent actionEvent) {
        try {

            if (testTypeCB.getValue() == null ||
                    preferredTestSlotCB.getValue() == null ||
                    labLocationCB.getValue() == null ||
                    peferredTestDatePicker.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            java.time.LocalDate selectedDate = peferredTestDatePicker.getValue();
            java.time.LocalDate today = java.time.LocalDate.now();

            long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(today, selectedDate);

            if (daysBetween < 5) {
                notificationLabel.setText("Cannot book before 5 days!");
                return;
            }

            notificationLabel.setText("Lab Test Booked ");

            testTypeCB.setValue(null);
            preferredTestSlotCB.setValue(null);
            labLocationCB.setValue(null);
            peferredTestDatePicker.setValue(null);

        } catch (Exception e) {
            notificationLabel.setText("Error booking!");
        }
    }

    @javafx.fxml.FXML
    public void checkAvailabilityButtonOA(ActionEvent actionEvent) {
        try {

            if (peferredTestDatePicker.getValue() == null) {
                notificationLabel.setText("Select a date!");
                return;
            }

            java.time.LocalDate selectedDate = peferredTestDatePicker.getValue();
            java.time.LocalDate today = java.time.LocalDate.now();

            long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(today, selectedDate);

            if (daysBetween < 5) {
                notificationLabel.setText("No slot available! Try after 5 days.");
            } else {
                notificationLabel.setText("Slot Available ");
            }

        } catch (Exception e) {
            notificationLabel.setText("Error checking!");
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