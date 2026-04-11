package com.example.covidmanagementapp.Ishika;
import com.example.covidmanagementapp.HelloApplication;
import com.example.covidmanagementapp.User.User;
import com.example.covidmanagementapp.User.UserFile;
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

public class DispenseMedicineViewController
{
    @javafx.fxml.FXML
    private TextField registerIdTF;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField medicineNameTF;
    @javafx.fxml.FXML
    private DatePicker entryDatePicker;
    @javafx.fxml.FXML
    private TextField quantityTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        try {

            String idText = registerIdTF.getText().trim();

            if (idText.isEmpty()) {
                notificationLabel.setText("Enter ID!");
                return;
            }

            int id = Integer.parseInt(idText);

            UserFile.loadUsers();

            for (User u : UserFile.userList) {

                if (u.getUserId() == id) {
                    notificationLabel.setText("Patient Found: " + u.getName());
                    return;
                }
            }

            notificationLabel.setText("Patient not found!");

        } catch (Exception e) {
            notificationLabel.setText("Invalid ID!");
        }
    }

    @javafx.fxml.FXML
    public void saveButtonOA(ActionEvent actionEvent) {
        try {

            if (registerIdTF.getText().trim().isEmpty() ||
                    medicineNameTF.getText().trim().isEmpty() ||
                    quantityTF.getText().trim().isEmpty() ||
                    entryDatePicker.getValue() == null) {

                notificationLabel.setText("Fill all fields!");
                return;
            }

            int id = Integer.parseInt(registerIdTF.getText().trim());
            int qty = Integer.parseInt(quantityTF.getText().trim());

            Dispense d = new Dispense(
                    id, medicineNameTF.getText().trim(), qty, entryDatePicker.getValue().toString()
            );

            File file = new File("Dispense.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new FileOutputStream(file, true)
                );
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(d);
            oos.close();

            notificationLabel.setText("Saved!");

            registerIdTF.clear();
            medicineNameTF.clear();
            quantityTF.clear();
            entryDatePicker.setValue(LocalDate.now());

        } catch (Exception e) {
            notificationLabel.setText("Error!");
        }
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/pharmacyDashboardView.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Pharmacy Dashboard");
            stage.show();
        } catch (Exception e) {
            //
        }

    }

}