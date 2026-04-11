package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class MedicineStockViewController
{
    @javafx.fxml.FXML
    private PieChart medicineStockPieChart;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene medicineAvailabilityViewScene = new Scene(fxmlLoader.load());
            Stage medicineAvailabilityViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            medicineAvailabilityViewStage.setTitle("Pharmacy Dashboard");
            medicineAvailabilityViewStage.setScene(medicineAvailabilityViewScene);
            medicineAvailabilityViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void viewMedicineStockPieChartButtonOA(ActionEvent actionEvent) {
    }
}