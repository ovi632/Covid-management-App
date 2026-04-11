package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.UserFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class VaccinationAppointmentViewController
{
    @javafx.fxml.FXML
    private ComboBox<String>  doseNumberCB;
    @javafx.fxml.FXML
    private DatePicker preferredVaccinationDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String>  vaccineTypeCB;
    @javafx.fxml.FXML
    private ComboBox<String>  vaccinationCenterCB;

    @javafx.fxml.FXML
    public void initialize() {
        doseNumberCB.getItems().addAll("1st Dose", "2nd Dose", "Booster");

        vaccineTypeCB.getItems().addAll("Pfizer", "Moderna", "Sinopharm");

        vaccinationCenterCB.getItems().addAll(
                "Dhaka Medical",
                "Square Hospital",
                "Popular Diagnostic"
        );

        preferredVaccinationDatePicker.setValue(LocalDate.now());
    }


    @javafx.fxml.FXML
    public void submitAppointmentButtonOA(ActionEvent actionEvent) {
        try {

            if (doseNumberCB.getValue() == null ||
                    vaccineTypeCB.getValue() == null ||
                    vaccinationCenterCB.getValue() == null ||
                    preferredVaccinationDatePicker.getValue() == null) {

                System.out.println("Fill all fields!");
                return;
            }

            int patientId = UserFile.currentUser.getUserId();

            Vaccination v = new Vaccination(
                    patientId,
                    doseNumberCB.getValue(),
                    vaccineTypeCB.getValue(),
                    vaccinationCenterCB.getValue(),
                    preferredVaccinationDatePicker.getValue().toString()
            );

            File file = new File("Vaccination.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(v);
            oos.close();

            System.out.println("Vaccination Saved ");

            // 🧹 CLEAR
            doseNumberCB.setValue(null);
            vaccineTypeCB.setValue(null);
            vaccinationCenterCB.setValue(null);
            preferredVaccinationDatePicker.setValue(null);

        } catch (Exception e) {
            System.out.println("Error saving!");
        }
    }

    @javafx.fxml.FXML
    public void checkEligibilityButtonOA(ActionEvent actionEvent) {
        if (doseNumberCB.getValue() == null) {
            System.out.println("Select dose first!");
            return;
        }

        String dose = doseNumberCB.getValue();

        if (dose.equals("1st Dose")) {
            System.out.println("Eligible ");
        } else {
            System.out.println("Make sure previous dose completed!");
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