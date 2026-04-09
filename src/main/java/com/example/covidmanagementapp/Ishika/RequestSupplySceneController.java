package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RequestSupplySceneController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private TextField requiredQuantityTF;
    @javafx.fxml.FXML
    private Label medicineSupplyRequestLabel;
    @javafx.fxml.FXML
    private TextField requestReasonTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene requestSupplyScene = new Scene(fxmlLoader.load());
            Stage requestSupplySceneStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            requestSupplySceneStage.setTitle("Pharmacy Dashboard");
            requestSupplySceneStage.setScene(requestSupplyScene);
            requestSupplySceneStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void submitRequestButtonOA(ActionEvent actionEvent) {
    }
}