package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PharmacyDashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void pharmacyStaffViewPrescriptionButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/prescriptionView.fxml"));
            Scene prescriptionViewscene = new Scene(fxmlLoader.load());
            Stage prescriptionViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            prescriptionViewStage.setTitle("Prescription View Window ");
            prescriptionViewStage.setScene(prescriptionViewscene);
            prescriptionViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void pharmacyStaffDispenseMedicineButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/dispenseMedicineView.fxml"));
            Scene dispenseMedicineViewscene = new Scene(fxmlLoader.load());
            Stage dispenseMedicineViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            dispenseMedicineViewStage.setTitle("Dispense Medicine Window");
            dispenseMedicineViewStage.setScene(dispenseMedicineViewscene);
            dispenseMedicineViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void pharmacyStaffUpdateStockButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/updateMedicineStockScene.fxml"));
            Scene updateMedicineStockScenescene = new Scene(fxmlLoader.load());
            Stage updateMedicineStockSceneStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updateMedicineStockSceneStage.setTitle("Update Stock Window");
            updateMedicineStockSceneStage.setScene(updateMedicineStockScenescene);
            updateMedicineStockSceneStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void pharmacyStaffExpiry_DisposalManagerButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/expiryAndDisposalManagerView.fxml"));
            Scene expiryAndDisposalManagerView = new Scene(fxmlLoader.load());
            Stage expiryAndDisposalManagerViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            expiryAndDisposalManagerViewStage.setTitle("Expiry Disposal Manager Window");
            expiryAndDisposalManagerViewStage.setScene(expiryAndDisposalManagerView);
            expiryAndDisposalManagerViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void pharmacyStaffRequestSupplyButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/requestSupplyScene.fxml"));
            Scene requestSupplyScene = new Scene(fxmlLoader.load());
            Stage requestSupplySceneStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            requestSupplySceneStage.setTitle("Request Supply Window");
            requestSupplySceneStage.setScene(requestSupplyScene);
            requestSupplySceneStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void pharmacyStaffGenerateReportButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/generateMedicineUsageReportView.fxml"));
            Scene generateMedicineUsageReportView = new Scene(fxmlLoader.load());
            Stage generateMedicineUsageReportViewStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            generateMedicineUsageReportViewStage.setTitle("Generate Report Window");
            generateMedicineUsageReportViewStage.setScene(generateMedicineUsageReportView);
            generateMedicineUsageReportViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void pharmacyStaffCheckMedicineStockButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/medicineAvailabilityView.fxml"));
            Scene medicineAvailabilityViewScene = new Scene(fxmlLoader.load());
            Stage medicineAvailabilityViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            medicineAvailabilityViewStage.setTitle("Stock View Window");
            medicineAvailabilityViewStage.setScene(medicineAvailabilityViewScene);
            medicineAvailabilityViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void pharmacyStaffStockViewButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/medicineStockView.fxml"));
            Scene medicineStockViewScene = new Scene(fxmlLoader.load());
            Stage medicineStockViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            medicineStockViewStage.setTitle("Stock View Window");
            medicineStockViewStage.setScene(medicineStockViewScene);
            medicineStockViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void logOutButtonOA(ActionEvent actionEvent) {
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
}