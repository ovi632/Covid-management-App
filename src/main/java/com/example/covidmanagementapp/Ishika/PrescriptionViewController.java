package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
}