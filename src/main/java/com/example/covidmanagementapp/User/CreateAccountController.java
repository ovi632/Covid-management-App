package com.example.covidmanagementapp.User;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CreateAccountController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> userCB;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private TextField IDTF;

    @javafx.fxml.FXML
    public void initialize() {
        userCB.getItems().addAll("Doctor", "Patient", "Pharmacy", "Health Data Entry Operator", "Lab Technician", "Vaccination Staff", "Emergency Ambulance Staff", "Nurse");

        UserFile.loadUsers();
    }

    @javafx.fxml.FXML
    public void createProfileButtonOA(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(IDTF.getText());
            String name = nameTF.getText();
            String password = passwordPF.getText();
            String role = userCB.getValue();

            if (name.isEmpty() || password.isEmpty() || role == null) {
                notificationLabel.setText("Fill all fields!");
                return;
            }

            for (User u : UserFile.userList) {
                if (u.getUserId() == id) {
                    notificationLabel.setText("ID already exists!");
                    return;
                }
            }

            User newUser = new User(id, password, role, name);

            File f = new File("users.bin");
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(newUser);
            oos.close();

            UserFile.userList.add(newUser);

            notificationLabel.setText("Account Created!");

        } catch (Exception e) {
            notificationLabel.setText("Invalid Input!");
        }

    }

    @javafx.fxml.FXML
    public void backToLoginButtonOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/User/loginView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            //
        }
    }
}