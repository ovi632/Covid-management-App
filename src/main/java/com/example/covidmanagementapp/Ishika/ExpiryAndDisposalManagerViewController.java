package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ExpiryAndDisposalManagerViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField disposalReasonTF;
    @javafx.fxml.FXML
    private Button refreshButtonOA;
    @javafx.fxml.FXML
    private TableColumn expiryAndDMs_StatusTC;
    @javafx.fxml.FXML
    private TableColumn expiryAndDMS_expiryDateTC;
    @javafx.fxml.FXML
    private TableView expiryAndDMSTV;
    @javafx.fxml.FXML
    private TableColumn expiryAndDMS_MedicineNameTC;
    @javafx.fxml.FXML
    private TableColumn expiryAndDMS_BatchNumberTC;
    @javafx.fxml.FXML
    private Label expiryAndDisposalManagerLabel;
    @javafx.fxml.FXML
    private TableColumn expiryAndDMS_currentQuantityTC;
    @javafx.fxml.FXML
    private TextField disposalQuantityTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene updateMedicineStockScenescene = new Scene(fxmlLoader.load());
            Stage updateMedicineStockSceneStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updateMedicineStockSceneStage.setTitle("Pharmacy Dashboard");
            updateMedicineStockSceneStage.setScene(updateMedicineStockScenescene);
            updateMedicineStockSceneStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void confirmMedicineButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void disposeMedicineButtonOA(ActionEvent actionEvent) {
    }
}