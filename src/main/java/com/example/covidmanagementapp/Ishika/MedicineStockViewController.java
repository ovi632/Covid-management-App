package com.example.covidmanagementapp.Ishika;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MedicineStockViewController
{
    @javafx.fxml.FXML
    private TableColumn medicineNameTC;
    @javafx.fxml.FXML
    private Button backButtonOA;
    @javafx.fxml.FXML
    private TableColumn stockAlertTC;
    @javafx.fxml.FXML
    private TextField maximumRangeTF;
    @javafx.fxml.FXML
    private TableView medicineStockViewTV;
    @javafx.fxml.FXML
    private TextField minimumRangeTF;
    @javafx.fxml.FXML
    private TableColumn quantityTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
    }
}