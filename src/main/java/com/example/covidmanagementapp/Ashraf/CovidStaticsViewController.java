package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.Ishika.DailyCovidReport;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CovidStaticsViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private PieChart covidStatisticsPieChart;
    @javafx.fxml.FXML
    private DatePicker fromDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker toDateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/doctorDashBoardView.fxml"));
            Scene updateRecoveryStatusViewscene = new Scene(fxmlLoader.load());
            Stage updateRecoveryStatusViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updateRecoveryStatusViewStage.setTitle("Doctor Dashboard");
            updateRecoveryStatusViewStage.setScene(updateRecoveryStatusViewscene);
            updateRecoveryStatusViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void generateStatisticsButtonOA(ActionEvent actionEvent) {
        try {

            if (fromDateDatePicker.getValue() == null || toDateDatePicker.getValue() == null) {
                notificationLabel.setText("Select date range!");
                return;
            }

            java.time.LocalDate fromDate = fromDateDatePicker.getValue();
            java.time.LocalDate toDate = toDateDatePicker.getValue();
            java.time.LocalDate today = java.time.LocalDate.now();

            long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(today, toDate);

            if (daysBetween < 5) {
                notificationLabel.setText("Select at least 5 days range!");
                return;
            }

            java.io.File file = new java.io.File("DailyCovidReport.bin");

            if (!file.exists()) {
                notificationLabel.setText("No data found!");
                return;
            }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            int child = 0;
            int teen = 0;
            int middle = 0;
            int newAffected = 0;
            int recovered = 0;

            while (true) {
                try {
                 DailyCovidReport r =
                            (DailyCovidReport) ois.readObject();

                    child += r.getChildAffected();
                    teen += r.getTeenAffected();
                    middle += r.getMiddleAgeAffected();
                    newAffected += r.getNewAffected();
                    recovered += r.getNewRecovered();

                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

            covidStatisticsPieChart.getData().clear();

            covidStatisticsPieChart.getData().add(new javafx.scene.chart.PieChart.Data("Child", child));
            covidStatisticsPieChart.getData().add(new javafx.scene.chart.PieChart.Data("Teen", teen));
            covidStatisticsPieChart.getData().add(new javafx.scene.chart.PieChart.Data("Middle Age", middle));
            covidStatisticsPieChart.getData().add(new javafx.scene.chart.PieChart.Data("New Cases", newAffected));
            covidStatisticsPieChart.getData().add(new javafx.scene.chart.PieChart.Data("Recovered", recovered));

            notificationLabel.setText("Chart Loaded!");

        } catch (Exception e) {
            notificationLabel.setText("Error loading data!");
        }
    }
}