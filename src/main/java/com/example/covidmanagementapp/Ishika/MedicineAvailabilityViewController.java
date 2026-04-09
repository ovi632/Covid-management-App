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

public class MedicineAvailabilityViewController
{
    @javafx.fxml.FXML
    private TableView medicineAvailabilityTableView;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private TableColumn medicineAvailabilityAvailableQuantityTC;
    @javafx.fxml.FXML
    private TableColumn medicineAvailabilityStatusTC;
    @javafx.fxml.FXML
    private TableColumn medicineAvailabilityMedicineNameTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene medicineAvailabilityViewScene = new Scene(fxmlLoader.load());
            Stage medicineAvailabilityViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            medicineAvailabilityViewStage.setTitle("Pharmacy Dashboard");
            medicineAvailabilityViewStage.setScene(medicineAvailabilityViewScene);
            medicineAvailabilityViewStage.show();
        }catch (Exception e){
            //
        }

    }

    @javafx.fxml.FXML
    public void checkAvailabilityButtonOA(ActionEvent actionEvent) {
    }
}