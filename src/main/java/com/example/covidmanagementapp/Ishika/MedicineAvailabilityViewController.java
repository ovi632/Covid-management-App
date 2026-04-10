package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MedicineAvailabilityViewController {

    @javafx.fxml.FXML
    private TableView<Medicine> medicineAvailabilityTableView;

    @javafx.fxml.FXML
    private TableColumn<Medicine, String> medicineAvailabilityMedicineNameTC;

    @javafx.fxml.FXML
    private TableColumn<Medicine, Integer> medicineAvailabilityAvailableQuantityTC;

    @javafx.fxml.FXML
    private TableColumn<Medicine, String> medicineAvailabilityStatusTC;

    @javafx.fxml.FXML
    private TextField medicineNameTF;

    @javafx.fxml.FXML
    private Label notificationLabel;

    private ArrayList<Medicine> medicineList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        // Bind columns
        medicineAvailabilityMedicineNameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        medicineAvailabilityAvailableQuantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        medicineAvailabilityStatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Default data
        medicineList.add(new Medicine("Paracetamol", 50));
        medicineList.add(new Medicine("Napa", 10));
        medicineList.add(new Medicine("Ace", 0));
        medicineList.add(new Medicine("Vitamin C", 25));

        // Show all medicines initially
        showTable(medicineList);
    }

    public void showTable(ArrayList<Medicine> list) {
        ObservableList<Medicine> data = FXCollections.observableArrayList(list);
        medicineAvailabilityTableView.setItems(data);
    }

    @javafx.fxml.FXML
    public void checkAvailabilityButtonOA(ActionEvent actionEvent) {

        String searchName = medicineNameTF.getText().trim();

        ArrayList<Medicine> filteredList = new ArrayList<>();

        for (Medicine m : medicineList) {
            if (m.getName().equalsIgnoreCase(searchName)) {
                filteredList.add(m);
            }
        }

        if (filteredList.isEmpty()) {
            notificationLabel.setText("Medicine not found!");
            medicineAvailabilityTableView.getItems().clear();
        } else {
            notificationLabel.setText("Result found");
            showTable(filteredList);
        }
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Pharmacy Dashboard");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}