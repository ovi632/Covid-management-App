package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPatientDataViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private TextField ageTF;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private TextField addressTF;
    @javafx.fxml.FXML
    private TextField patientNameTF;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backbuttonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/healthDataEntryOperatorDashboardView.fxml"));
            Scene addPatientDataViewScene = new Scene(fxmlLoader.load());
            Stage addPatientDataViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            addPatientDataViewStage.setTitle("");
            addPatientDataViewStage.setScene(addPatientDataViewScene);
            addPatientDataViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void saveButtonOA(ActionEvent actionEvent) {
    }
}