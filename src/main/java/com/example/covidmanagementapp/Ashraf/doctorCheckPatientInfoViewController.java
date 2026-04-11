package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.User;
import com.example.covidmanagementapp.User.UserFile;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

public class doctorCheckPatientInfoViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn<Patient,Integer> ageInPatientInfoTC;
    @javafx.fxml.FXML
    private TableColumn<Patient,String> nameInPatientInfoTC;
    @javafx.fxml.FXML
    private TableColumn<Patient,String> previousDiagnosesInPatientInfoTC;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private Label infoShowLabel;
    @javafx.fxml.FXML
    private TableColumn<Patient,String> genderInPatientInfoTC;
    @javafx.fxml.FXML
    private TableView<Patient> patientInfoTableView;

    @javafx.fxml.FXML
    public void initialize() {
        nameInPatientInfoTC.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));

        ageInPatientInfoTC.setCellValueFactory(c ->
                new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getAge()));

        genderInPatientInfoTC.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getGender()));

        previousDiagnosesInPatientInfoTC.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getDisease()));

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

            UserFile.loadUsers();

            for (User u : UserFile.userList) {

                if (u.getUserId() == id) {

                    String name = u.getName();


                    int age = 25;
                    String gender = "Male";

                    String disease = "No Diagnosis Found";

                    File file = new File("Diagnosis.bin");

                    if (file.exists()) {

                        ObjectInputStream ois =
                                new ObjectInputStream(new FileInputStream(file));

                        while (true) {
                            try {
                                Diagnosis d = (Diagnosis) ois.readObject();

                                if (d.getPatientId() == id) {
                                    disease = d.getDiagnosisDetails();
                                }

                            } catch (EOFException e) {
                                break;
                            }
                        }

                        ois.close();
                    }

                    patientInfoTableView.getItems().clear();

                    Patient p = new Patient(id, name, age, gender, disease);
                    patientInfoTableView.getItems().add(p);

                    notificationLabel.setText("Patient Loaded!");
                    registrationIdTF.clear();
                    return;
                }
            }

            notificationLabel.setText("Patient not found!");

        } catch (Exception e) {
            notificationLabel.setText("Invalid ID!");
        }


    }


}