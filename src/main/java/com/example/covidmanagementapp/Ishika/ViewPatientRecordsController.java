package com.example.covidmanagementapp.Ishika;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ViewPatientRecordsController
{
    @javafx.fxml.FXML
    private TableColumn patientIDTC;
    @javafx.fxml.FXML
    private TableView viewPatientRecordsTV;
    @javafx.fxml.FXML
    private TableColumn nameTC;
    @javafx.fxml.FXML
    private TableColumn diagonalsSummaryTC;
    @javafx.fxml.FXML
    private TableColumn testResultsSummaryTC;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn covidStatusTC;
    @javafx.fxml.FXML
    private TextField patientSearchTF;
    @javafx.fxml.FXML
    private TableColumn vaccinationDetailsTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
    }
}