package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.User;
import com.example.covidmanagementapp.User.UserFile;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MyHealthProfileViewController
{
    @javafx.fxml.FXML
    private TableColumn<MyHealthProfile, String> DiagnosisTC;
    @javafx.fxml.FXML
    private TableColumn<MyHealthProfile, String> genderTC;
    @javafx.fxml.FXML
    private TableColumn<MyHealthProfile, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<MyHealthProfile, Integer> ageTC;
    @javafx.fxml.FXML
    private TableView<MyHealthProfile> myHealthProfileTV;
    @javafx.fxml.FXML
    private TableColumn<MyHealthProfile, String> covidStatusTC;
    @javafx.fxml.FXML
    private TableColumn<MyHealthProfile, String> lastStatusUpdateDateTC;

    @javafx.fxml.FXML
    public void initialize() {
        nameTC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        ageTC.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getAge()));
        genderTC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getGender()));
        DiagnosisTC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDiagnosis()));
        covidStatusTC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCovidStatus()));

        lastStatusUpdateDateTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getLastUpdate()));

        loadMyProfile();

    }

    private void loadMyProfile() {
        try {

            int patientId = UserFile.currentUser.getUserId();

            String name = "";
            int age = 25;           // 🔥 dummy
            String gender = "Male"; // 🔥 dummy

            UserFile.loadUsers();
            for (User u : UserFile.userList) {
                if (u.getUserId() == patientId) {
                    name = u.getName();
                    break;
                }
            }

            String diagnosis = "N/A";

            File dFile = new File("Diagnosis.bin");
            if (dFile.exists()) {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dFile));

                while (true) {
                    try {
                        Diagnosis d = (Diagnosis) ois.readObject();

                        if (d.getPatientId() == patientId) {
                            diagnosis = d.getDiagnosisDetails(); // change if needed
                        }

                    } catch (EOFException e) {
                        break;
                    }
                }
                ois.close();
            }

            String status = "Null";
            String lastDate = "N/A";

            File sFile = new File("Recovery.bin"); // your status file

            if (sFile.exists()) {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sFile));

                while (true) {
                    try {
                        RecoveryStatus r = (RecoveryStatus) ois.readObject();

                        if (r.getPatientId() == patientId) {
                            status = r.getStatus();
                            lastDate = r.getDate();
                        }

                    } catch (EOFException e) {
                        break;
                    }
                }
                ois.close();
            }

            myHealthProfileTV.getItems().clear();

            MyHealthProfile profile = new MyHealthProfile(
                    name, age, gender, diagnosis, status, lastDate
            );

            myHealthProfileTV.getItems().add(profile);

        } catch (Exception e) {
            System.out.println("Error loading profile");
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