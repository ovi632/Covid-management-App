package com.example.covidmanagementapp.Ishika;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrescriptionViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private TableView prescriptopnTableView;
    @javafx.fxml.FXML
    private TableColumn dosageInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn medicineInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn doctorNameInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn instructionInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn durationInPrescriptionTC;
    @javafx.fxml.FXML
    private TableColumn dateInPrescriptionTC;

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