package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DispenseMedicineViewController
{
    @javafx.fxml.FXML
    private Button searchButtonOA;
    @javafx.fxml.FXML
    private TableColumn dispenseMedicine_MedicineNameTC;
    @javafx.fxml.FXML
    private TableColumn dispenseMedicineDurationTC;
    @javafx.fxml.FXML
    private TableColumn dispenseMedicineInstructionTC;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private TableView dispenseMedicineTableView;
    @javafx.fxml.FXML
    private TextField patientNameTF;
    @javafx.fxml.FXML
    private TableColumn dispenseMedicineDosageTC;
    @javafx.fxml.FXML
    private TableColumn dispenseMedicineDoctorTC;
    @javafx.fxml.FXML
    private TableColumn dispenseMedicineDateTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene pharmacyDashboardViewScene = new Scene(fxmlLoader.load());
            Stage medicineStockViewSceneStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            medicineStockViewSceneStage.setTitle("Pharmacy Dashboard Window");
            medicineStockViewSceneStage.setScene(pharmacyDashboardViewScene);
            medicineStockViewSceneStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void dispenseButtonOA(ActionEvent actionEvent) {
    }
}