package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class UpdateMedicineStockSceneController
{

    @javafx.fxml.FXML
    private Label updateMSnotificationLabel;
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private Label notificationLabel;

    @javafx.fxml.FXML
    public void initialize() {
        datePicker.setValue(LocalDate.now());
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
    public void saveButtonOA(ActionEvent actionEvent) {
        try {

            if (medicineNameTF.getText().trim().isEmpty() ||
                    quantityTF.getText().trim().isEmpty() ||
                    datePicker.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            String name = medicineNameTF.getText().trim();
            int qty = Integer.parseInt(quantityTF.getText().trim());
            String date = datePicker.getValue().toString();

            MedicineStock ms = new MedicineStock(name, qty, date);

            File file = new File("MedicineStock.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(ms);
            oos.close();

            notificationLabel.setText("Stock Updated!");

            medicineNameTF.clear();
            quantityTF.clear();
            datePicker.setValue(LocalDate.now());

        } catch (Exception e) {
            notificationLabel.setText("Error!");
        }
    }

}

