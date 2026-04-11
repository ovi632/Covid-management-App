package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.UserFile;
import javafx.beans.property.SimpleObjectProperty;
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

public class LabTestResultsViewController
{
    @javafx.fxml.FXML
    private TableColumn<LabTest, Integer> labTechnicianIdTC;
    @javafx.fxml.FXML
    private TableColumn<LabTest, String> sampleDateTC;
    @javafx.fxml.FXML
    private TableView<LabTest> labTestResultsTV;
    @javafx.fxml.FXML
    private TableColumn<LabTest, String> resultStatusTC;
    @javafx.fxml.FXML
    private TableColumn<LabTest, String> testNameTC;
    @javafx.fxml.FXML
    private TableColumn<LabTest, Integer> reportCodeTC;
    @javafx.fxml.FXML
    private TextField enterUserIdTF;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {

        testNameTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getTestType()));

        sampleDateTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getDate()));

        reportCodeTC.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getPatientId()));

        resultStatusTC.setCellValueFactory(c ->
                new SimpleStringProperty("Not Ready"));

        labTechnicianIdTC.setCellValueFactory(c ->
                new SimpleObjectProperty<>(2430783));

    }

    @javafx.fxml.FXML
    public void findResultButtonOA(ActionEvent actionEvent) {
        try {

            int id = UserFile.currentUser.getUserId();

            File file = new File("LabTest.bin");

            if (!file.exists()) {
                errorLabel.setText("No data found!");
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            labTestResultsTV.getItems().clear();

            boolean found = false;

            while (true) {
                try {

                    LabTest test = (LabTest) ois.readObject();

                    if (test.getPatientId() == id) {

                        labTestResultsTV.getItems().add(test);
                        found = true;
                    }

                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            if (!found) {
                errorLabel.setText("No records found!");
            } else {
                errorLabel.setText("Result loaded!");
            }

        } catch (Exception e) {
            errorLabel.setText("Error loading data!");
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