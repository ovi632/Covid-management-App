package com.example.covidmanagementapp.Ishika;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class GenerateDailyCovidReportViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private Button backButtonOA;
    @javafx.fxml.FXML
    private TableColumn totalVaccinationsTC;
    @javafx.fxml.FXML
    private TableColumn generateDateTC;
    @javafx.fxml.FXML
    private DatePicker toDateDP;
    @javafx.fxml.FXML
    private TableColumn totalPatientsTC;
    @javafx.fxml.FXML
    private DatePicker fromDateDP;
    @javafx.fxml.FXML
    private TableColumn totalCovidCasesTC;
    @javafx.fxml.FXML
    private TableView generateDailyCovidReportViewTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generateReportButtonOA(ActionEvent actionEvent) {
    }
}