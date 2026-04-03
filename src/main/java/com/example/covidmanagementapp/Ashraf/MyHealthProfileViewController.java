package com.example.covidmanagementapp.Ashraf;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MyHealthProfileViewController
{
    @javafx.fxml.FXML
    private TableColumn DiagnosisTC;
    @javafx.fxml.FXML
    private TableColumn genderTC;
    @javafx.fxml.FXML
    private TableColumn nameTC;
    @javafx.fxml.FXML
    private TableColumn ageTC;
    @javafx.fxml.FXML
    private TableView myHealthProfileTV;
    @javafx.fxml.FXML
    private TableColumn covidStatusTC;
    @javafx.fxml.FXML
    private TableColumn lastStatusUpdateDateTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
    }
}