package com.example.covidmanagementapp.User;

import com.example.covidmanagementapp.Ashraf.AppendableObjectOutputStream;
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
        userCB.getItems().addAll(
                "Doctor",
                "Patient",
                "Pharmacy",
                "Operator",
                "Lab Technician",
                "Vaccination Staff",
                "Emergency Staff",
                "Nurse"
        );
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


            for (var u : UserFile.userList) {
                if (u.getUserId() == id) {
                    notificationLabel.setText("User ID already exists!");
                    return;
                }
            }
            User newUser = new User(id, password, role);

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

            notificationLabel.setText("Account created successfully!");

        } catch (Exception e) {
            notificationLabel.setText("ID must be a number!");
        }

    }


    @javafx.fxml.FXML
    public void backToLoginButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/covidmanagementapp/Login.fxml"));

            Scene loginScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Covid Management App");
            stage.setScene(loginScene);
            stage.show();

        } catch (Exception e){
            //
        }
    }
}