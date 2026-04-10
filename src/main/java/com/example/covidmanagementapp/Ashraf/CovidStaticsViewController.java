package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CovidStaticsViewController {

    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private DatePicker fromDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker toDateDatePicker;
    @javafx.fxml.FXML
    private PieChart covidStatisticsPieChart;

    @javafx.fxml.FXML
    public void initialize() {

        // Optional: set default dates
        fromDateDatePicker.setValue(java.time.LocalDate.now().minusDays(7));
        toDateDatePicker.setValue(java.time.LocalDate.now());
    }

    @javafx.fxml.FXML
    public void generateStatisticsButtonOA(ActionEvent actionEvent) {

        try {

            if (fromDateDatePicker.getValue() == null || toDateDatePicker.getValue() == null) {
                notificationLabel.setText("Select date range!");
                return;
            }

            int positive = 50;
            int recovered = 30;
            int negative = 20;

            ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
                    new PieChart.Data("Positive Cases", positive),
                    new PieChart.Data("Recovered Cases", recovered),
                    new PieChart.Data("Negative Cases", negative)
            );

            covidStatisticsPieChart.setData(data);

            notificationLabel.setText("Statistics Generated!");

        } catch (Exception e) {
            notificationLabel.setText("Error generating data!");
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/doctorDashBoardView.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Doctor Dashboard");
            stage.show();

        } catch (Exception e) {
            //
        }
    }
}