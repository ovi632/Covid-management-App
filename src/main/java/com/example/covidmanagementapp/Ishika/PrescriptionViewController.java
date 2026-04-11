package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.Ashraf.Prescription;
import com.example.covidmanagementapp.HelloApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PrescriptionViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private TableView<Prescription> prescriptopnTableView;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> dosageInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> medicineInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> doctorNameInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> instructionInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> durationInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> dateInPrescriptionTC;

    @javafx.fxml.FXML
    public void initialize() {

        medicineInPrescriptionTC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getMedicineName()));
        dosageInPrescriptionTC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDosage()));
        durationInPrescriptionTC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDuration()));
        dateInPrescriptionTC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDate()));
        instructionInPrescriptionTC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getInstructions()));
        doctorNameInPrescriptionTC.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getDoctorId())));
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        try {

            String idText = registrationIdTF.getText().trim();

            if (idText.isEmpty()) {
                notificationLabel.setText("Enter ID!");
                return;
            }

            int id = Integer.parseInt(idText);

            File file = new File("Prescription.bin");

            if (!file.exists()) {
                notificationLabel.setText("No data found!");
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            prescriptopnTableView.getItems().clear();

            boolean found = false;

            while (true) {
                try {

                    Prescription p = (Prescription) ois.readObject();

                    if (p.getPatientId() == id) {
                        prescriptopnTableView.getItems().add(p);
                        found = true;
                    }

                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            if (!found) {
                notificationLabel.setText("No prescription found!");
            } else {
                notificationLabel.setText("Loaded!");
            }

            registrationIdTF.clear();

        } catch (Exception e) {
            notificationLabel.setText("Invalid ID!");
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene updateMedicineStockScenescene = new Scene(fxmlLoader.load());
            Stage updateMedicineStockSceneStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updateMedicineStockSceneStage.setTitle("Pharmacy Dashboard");
            updateMedicineStockSceneStage.setScene(updateMedicineStockScenescene);
            updateMedicineStockSceneStage.show();
        }catch (Exception e){
            //
        }
    }
}