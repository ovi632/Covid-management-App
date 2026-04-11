package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class UpdateCovidCaseStatusViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn<CovidStatus,Integer> doctorID;
    @javafx.fxml.FXML
    private TextField doctorNotesTF;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private DatePicker statusUpdateDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CovidStatus,String>  UpdateDateTC;
    @javafx.fxml.FXML
    private Label infoShowLabel;
    @javafx.fxml.FXML
    private TableColumn<CovidStatus,String> previousStatusTC;
    @javafx.fxml.FXML
    private ComboBox<String> newCovidStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn<CovidStatus,String> updateStatusTC;
    @javafx.fxml.FXML
    private TableView<CovidStatus> updateCovidCaseTV;
    private int currentPatientId = -1;
    private String currentPatientName = "";
    private String previousStatus = "Null";

    @javafx.fxml.FXML
    public void initialize() {
        newCovidStatusComboBox.getItems().addAll("Positive", "Negative", "Recovered", "Critical");

        previousStatusTC.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("previousStatus"));

        updateStatusTC.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("newStatus"));

        UpdateDateTC.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("date"));

        doctorID.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("doctorId"));
    }

    @javafx.fxml.FXML
    public void loadStatusHistoryButtonOA(ActionEvent actionEvent) {
        try {

            File file = new File("CovidStatus.bin");

            if (!file.exists()) {
                notificationLabel.setText("No data!");
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            updateCovidCaseTV.getItems().clear();

            while (true) {
                try {
                    CovidStatus cs = (CovidStatus) ois.readObject();
                    updateCovidCaseTV.getItems().add(cs);
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            notificationLabel.setText("History Loaded!");

        } catch (Exception e) {
            notificationLabel.setText("Error loading!");
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

    @javafx.fxml.FXML
    public void SearchButtonOA(ActionEvent actionEvent) {
        try {
            String idText = registrationIdTF.getText().trim();

            if (idText.isEmpty()) {
                notificationLabel.setText("Enter ID!");
                return;
            }

            int id = Integer.parseInt(idText);

            com.example.covidmanagementapp.User.UserFile.loadUsers();

            for (com.example.covidmanagementapp.User.User u :
                    com.example.covidmanagementapp.User.UserFile.userList) {

                if (u.getUserId() == id) {

                    currentPatientId = id;
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

            if (newCovidStatusComboBox.getValue() == null ||
                    statusUpdateDateDatePicker.getValue() == null ||
                    doctorNotesTF.getText().trim().isEmpty()) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            String newStatus = newCovidStatusComboBox.getValue().toString();
            String date = statusUpdateDateDatePicker.getValue().toString();
            String notes = doctorNotesTF.getText().trim();

            int doctorId = com.example.covidmanagementapp.User.UserFile.currentUser.getUserId();

            CovidStatus cs = new CovidStatus(
                    currentPatientId,
                    previousStatus,
                    newStatus,
                    date,
                    notes,
                    doctorId
            );

            File file = new File("CovidStatus.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(cs);
            oos.close();

            notificationLabel.setText("Status Saved!");

            registrationIdTF.clear();
            doctorNotesTF.clear();
            newCovidStatusComboBox.setValue(null);
            statusUpdateDateDatePicker.setValue(null);
            infoShowLabel.setText("");

            currentPatientId = -1;

        } catch (Exception e) {
            notificationLabel.setText("Error saving!");
        }
    }
}