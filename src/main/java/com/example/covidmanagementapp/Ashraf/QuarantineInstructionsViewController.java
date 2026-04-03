package com.example.covidmanagementapp.Ashraf;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class QuarantineInstructionsViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private ComboBox quarantineTypeCB;
    @javafx.fxml.FXML
    private TextField instructionDetailsTF;
    @javafx.fxml.FXML
    private DatePicker endDateDP;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private Label infoShowLabel;
    @javafx.fxml.FXML
    private ComboBox allowedActivitiesCB;
    @javafx.fxml.FXML
    private DatePicker startDateDP;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SearchButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveInstructionsButtonOA(ActionEvent actionEvent) {
    }
}