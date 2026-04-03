package com.example.covidmanagementapp.Ashraf;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VaccinationHistoryAndCertificateViewController
{
    @javafx.fxml.FXML
    private TableColumn doseNumberTC;
    @javafx.fxml.FXML
    private TextField vaccinationIdTF;
    @javafx.fxml.FXML
    private Label certificateStatusLabel;
    @javafx.fxml.FXML
    private TableView vaccinationHistoryAndCertificateTV;
    @javafx.fxml.FXML
    private TableColumn vaccineNameTC;
    @javafx.fxml.FXML
    private TableColumn vaccinationDateTC;
    @javafx.fxml.FXML
    private TableColumn vaccinationCenterTC;
    @javafx.fxml.FXML
    private TableColumn staffIDTC;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void checkCertificateStatusButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchRecordButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
    }
}