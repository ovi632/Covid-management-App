package com.example.covidmanagementapp.Ishika;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VaccinationRecordEntryController
{
    @javafx.fxml.FXML
    private ComboBox doseNumberCB;
    @javafx.fxml.FXML
    private TextField batchNumberTF;
    @javafx.fxml.FXML
    private DatePicker vaccinationDateDP;
    @javafx.fxml.FXML
    private TextField registrationIDTF;
    @javafx.fxml.FXML
    private ComboBox vaccinationCenterCB;
    @javafx.fxml.FXML
    private TextField vaccineNameTF;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField observationNotesTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void verifyButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButtonOA(ActionEvent actionEvent) {
    }
}