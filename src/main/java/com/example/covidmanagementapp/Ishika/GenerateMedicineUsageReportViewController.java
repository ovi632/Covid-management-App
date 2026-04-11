package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class GenerateMedicineUsageReportViewController
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
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene generateMedicineUsageReportView = new Scene(fxmlLoader.load());
            Stage generateMedicineUsageReportViewStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            generateMedicineUsageReportViewStage.setTitle("Pharmacy Dashboard");
            generateMedicineUsageReportViewStage.setScene(generateMedicineUsageReportView);
            generateMedicineUsageReportViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void generateReportOA(ActionEvent actionEvent) {
    }
}