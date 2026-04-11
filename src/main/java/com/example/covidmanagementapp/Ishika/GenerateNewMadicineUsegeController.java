package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.User;
import com.example.covidmanagementapp.User.UserFile;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class GenerateNewMadicineUsegeController
{
    @javafx.fxml.FXML
    private TableColumn<MedicineUsage, String>  generateMUR_TimesPerDayTC;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn<MedicineUsage, String>  generateMUR_DurationTC;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private TableView<MedicineUsage> generateMedicineUsageReportTV;
    @javafx.fxml.FXML
    private TableColumn<MedicineUsage, String>  generateMUR_PatientNameTC;
    @javafx.fxml.FXML
    private TableColumn<MedicineUsage, String>  generateMUR_TakenTimeTC;
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> timePerDayCB;
    @javafx.fxml.FXML
    private TableColumn<MedicineUsage, String>  generateMUR_DosageTC;
    @javafx.fxml.FXML
    private ComboBox<String> takenTimeCB;
    @javafx.fxml.FXML
    private TableColumn<MedicineUsage, String>  generateMUR_ReportDateTC;
    @javafx.fxml.FXML
    private TableColumn<MedicineUsage, String>  generateMUR_MedicineNameTC;
    @javafx.fxml.FXML
    private ComboBox<String> dosageCB;
    @javafx.fxml.FXML
    private TextField patientIdTF;
    @javafx.fxml.FXML
    private TextField DurationTF;

    @javafx.fxml.FXML
    public void initialize() {
        dosageCB.getItems().addAll("1 Tablet", "2 Tablets", "5 ml");
        timePerDayCB.getItems().addAll("1", "2", "3");
        takenTimeCB.getItems().addAll("Morning", "Afternoon", "Night");

        reportDatePicker.setValue(LocalDate.now());

        generateMUR_PatientNameTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getPatientName()));

        generateMUR_MedicineNameTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getMedicineName()));

        generateMUR_DosageTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getDosage()));

        generateMUR_TimesPerDayTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getTimesPerDay()));

        generateMUR_TakenTimeTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getTakenTime()));

        generateMUR_DurationTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getDuration()));

        generateMUR_ReportDateTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getReportDate()));
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        try {

            int id = Integer.parseInt(patientIdTF.getText().trim());

            UserFile.loadUsers();

            for (User u : UserFile.userList) {
                if (u.getUserId() == id) {
                    notificationLabel.setText("Patient: " + u.getName());
                    return;
                }
            }

            notificationLabel.setText("Not found!");

        } catch (Exception e) {
            notificationLabel.setText("Invalid ID!");
        }
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Pharmacy Dashboard");
            stage.show();
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void generateReportOA(ActionEvent actionEvent) {
        try {

            if (patientIdTF.getText().trim().isEmpty() ||
                    medicineNameTF.getText().trim().isEmpty() ||
                    dosageCB.getValue() == null ||
                    timePerDayCB.getValue() == null ||
                    takenTimeCB.getValue() == null ||
                    DurationTF.getText().trim().isEmpty() ||
                    reportDatePicker.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            int id = Integer.parseInt(patientIdTF.getText().trim());
            String name = "";

            for (User u : UserFile.userList) {
                if (u.getUserId() == id) {
                    name = u.getName();
                }
            }

            MedicineUsage mu = new MedicineUsage(
                    id,
                    name,
                    medicineNameTF.getText().trim(),
                    dosageCB.getValue().toString(),
                    timePerDayCB.getValue().toString(),
                    takenTimeCB.getValue().toString(),
                    DurationTF.getText().trim(),
                    reportDatePicker.getValue().toString()
            );

            File file = new File("MedicineUsage.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(mu);
            oos.close();

            generateMedicineUsageReportTV.getItems().add(mu);

            notificationLabel.setText("Report Generated!");

        } catch (Exception e) {
            notificationLabel.setText("Error!");
        }
    }
}