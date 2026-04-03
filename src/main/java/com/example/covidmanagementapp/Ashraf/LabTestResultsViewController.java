package com.example.covidmanagementapp.Ashraf;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LabTestResultsViewController
{
    @javafx.fxml.FXML
    private TableColumn labTechnicianIdTC;
    @javafx.fxml.FXML
    private TableColumn sampleDateTC;
    @javafx.fxml.FXML
    private TableView labTestResultsTV;
    @javafx.fxml.FXML
    private TextField enterTestReportIdTF;
    @javafx.fxml.FXML
    private TableColumn testNameTC;
    @javafx.fxml.FXML
    private TableColumn reportCodeTC;
    @javafx.fxml.FXML
    private TableColumn resultStatusTC;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void findResultButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
    }
}