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

import java.io.*;

public class PatientDischargeManagerViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn<PatientDischarge,String> remarksTC;
    @javafx.fxml.FXML
    private ComboBox<String> dischargeStatusCB;
    @javafx.fxml.FXML
    private TextField registrationIDTF;
    @javafx.fxml.FXML
    private TableView<PatientDischarge>patientDischargeManagerViewTV;
    @javafx.fxml.FXML
    private TableColumn<PatientDischarge,String> wardTC;
    @javafx.fxml.FXML
    private TableColumn<PatientDischarge,String> dischargeDateTC;
    @javafx.fxml.FXML
    private TableColumn<PatientDischarge,String> statusTC;
    @javafx.fxml.FXML
    private TextField dischargeSummaryTF;
    @javafx.fxml.FXML
    private DatePicker dischargeDateDP;
    @javafx.fxml.FXML
    private ComboBox<String> wardCB;

    @javafx.fxml.FXML
    public void initialize() {
        dischargeStatusCB.getItems().addAll("Discharged", "Referred", "Under Observation");

        wardCB.getItems().addAll("Ward A", "Ward B", "Ward C");

        wardTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getWard()));

        statusTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getStatus()));

        remarksTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getRemarks()));

        dischargeDateTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getDate()));
    }

    @javafx.fxml.FXML
    public void verifyPatientButtonOA(ActionEvent actionEvent) {
        try {

            String idText = registrationIDTF.getText().trim();

            if (idText.isEmpty()) {
                notificationLabel.setText("Enter ID!");
                return;
            }

            int id = Integer.parseInt(idText);

            UserFile.loadUsers();

            for (User u : UserFile.userList) {

                if (u.getUserId() == id) {
                    notificationLabel.setText("Patient Found: " + u.getName());
                    return;
                }
            }

            notificationLabel.setText("Patient not found!");

        } catch (Exception e) {
            notificationLabel.setText("Invalid ID!");
        }
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/healthDataEntryOperatorDashboardView.fxml"));
            Scene updatePatientRecordViewScene = new Scene(fxmlLoader.load());
            Stage updatePatientRecordViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updatePatientRecordViewStage.setTitle("health DataEntry Operator DashboardView");
            updatePatientRecordViewStage.setScene(updatePatientRecordViewScene);
            updatePatientRecordViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void loadDischargeHistoryButtonOA(ActionEvent actionEvent) {
        try {

            if (registrationIDTF.getText().trim().isEmpty()) {
                notificationLabel.setText("Enter ID!");
                return;
            }

            int id = Integer.parseInt(registrationIDTF.getText().trim());

            File file = new File("PatientDischarge.bin");

            if (!file.exists()) {
                notificationLabel.setText("No data!");
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            patientDischargeManagerViewTV.getItems().clear();

            boolean found = false;

            while (true) {
                try {
                    PatientDischarge pd = (PatientDischarge) ois.readObject();

                    if (pd.getPatientId() == id) {
                        patientDischargeManagerViewTV.getItems().add(pd);
                        found = true;
                    }

                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            if (!found) {
                notificationLabel.setText("No records!");
            } else {
                notificationLabel.setText("Loaded!");
            }

        } catch (Exception e) {
            notificationLabel.setText("Error!");
        }

    }

    @javafx.fxml.FXML
    public void saveDischargeButtonOA(ActionEvent actionEvent) {
        try {

            if (registrationIDTF.getText().trim().isEmpty() ||
                    dischargeSummaryTF.getText().trim().isEmpty() ||
                    dischargeStatusCB.getValue() == null ||
                    wardCB.getValue() == null ||
                    dischargeDateDP.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            int id = Integer.parseInt(registrationIDTF.getText().trim());

            PatientDischarge pd = new PatientDischarge(
                    id,
                    wardCB.getValue(),
                    dischargeStatusCB.getValue(),
                    dischargeSummaryTF.getText().trim(),
                    dischargeDateDP.getValue().toString()
            );

            File file = new File("PatientDischarge.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(pd);
            oos.close();

            notificationLabel.setText("Saved!");

            registrationIDTF.clear();
            dischargeSummaryTF.clear();
            dischargeStatusCB.setValue(null);
            wardCB.setValue(null);
            dischargeDateDP.setValue(null);

        } catch (Exception e) {
            notificationLabel.setText("Error saving!");
        }

    }
}