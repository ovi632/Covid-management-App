package com.example.covidmanagementapp.Ashraf;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DiagnosisAndPrescriptionsViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableColumn diagnosisSummaryTC;
    @javafx.fxml.FXML
    private TableColumn durationTC;
    @javafx.fxml.FXML
    private TableColumn prescribedMedicineTC;
    @javafx.fxml.FXML
    private TableColumn DateTC;
    @javafx.fxml.FXML
    private TableColumn dosageTC;
    @javafx.fxml.FXML
    private TableView diagnosisAndPrescriptionsTV;
    @javafx.fxml.FXML
    private TableColumn symptomsSummaryTC;
    @javafx.fxml.FXML
    private TableColumn doctorIdTC;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
    }
}