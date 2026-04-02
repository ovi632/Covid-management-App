package com.example.covidmanagementapp.Ishika;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GenerateMedicineUsageReportSceneController
{
    @javafx.fxml.FXML
    private Label medicineUsageReportLabel;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn generateMUR_TimesPerDayTC;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn generateMUR_MealInstructionTC;
    @javafx.fxml.FXML
    private TableColumn generateMUR_DurationTC;
    @javafx.fxml.FXML
    private TableView generateMedicineUsageReportTV;
    @javafx.fxml.FXML
    private TableColumn generateMUR_PatientNameTC;
    @javafx.fxml.FXML
    private TableColumn generateMUR_TakenTimeTC;
    @javafx.fxml.FXML
    private TableColumn generateMUR_DispenseQuantityTC;
    @javafx.fxml.FXML
    private TableColumn generateMUR_DosageTC;
    @javafx.fxml.FXML
    private TableColumn generateMUR_ReportDateTC;
    @javafx.fxml.FXML
    private TableColumn generateMUR_MedicineNameTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReportOA(ActionEvent actionEvent) {
    }
}