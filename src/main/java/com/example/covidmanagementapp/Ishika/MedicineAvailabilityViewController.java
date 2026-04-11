package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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
    private TableView<Medicine>  medicineAvailabilityTableView;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private TableColumn<Medicine, Integer> medicineAvailabilityAvailableQuantityTC;
    @javafx.fxml.FXML
    private TableColumn<Medicine, String> medicineAvailabilityStatusTC;
    @javafx.fxml.FXML
    private TableColumn<Medicine, String> medicineAvailabilityMedicineNameTC;

    @javafx.fxml.FXML
    public void initialize() {
        medicineAvailabilityMedicineNameTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getName()));

        medicineAvailabilityAvailableQuantityTC.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getQuantity()));

        medicineAvailabilityStatusTC.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getStatus()));
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
    public void checkAvailabilityButtonOA(ActionEvent actionEvent) {
        medicineAvailabilityTableView.getItems().clear();

        String name = medicineNameTF.getText().trim().toLowerCase();

        Medicine m1 = new Medicine("Paracetamol", 50, "Available");
        Medicine m2 = new Medicine("Napa", 0, "Out of Stock");
        Medicine m3 = new Medicine("Antibiotic", 20, "Limited");

        if (name.isEmpty()) {
            notificationLabel.setText("Enter medicine name!");
            return;
        }

        boolean found = false;

        for (Medicine m : new Medicine[]{m1, m2, m3}) {

            if (m.getName().toLowerCase().contains(name)) {
                medicineAvailabilityTableView.getItems().add(m);
                found = true;
            }
        }

        if (!found) {
            notificationLabel.setText("Not found!");
        } else {
            notificationLabel.setText("Result loaded!");
        }

        medicineNameTF.clear();
    }
}