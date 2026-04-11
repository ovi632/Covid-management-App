package com.example.covidmanagementapp.Ishika;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GenerateDailyCovidReportViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField childAffectedTF;
    @javafx.fxml.FXML
    private TextField newRecoveryTF;
    @javafx.fxml.FXML
    private TextField middleAgeAffectedTF;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField newAffectedTF;
    @javafx.fxml.FXML
    private TextField teenAgeAffectedTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ishika/healthDataEntryOperatorDashboardView.fxml"));
            Scene updatePatientRecordViewScene = new Scene(fxmlLoader.load());
            Stage updatePatientRecordViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updatePatientRecordViewStage.setTitle("health DataEntry Operator DashboardView");
            updatePatientRecordViewStage.setScene(updatePatientRecordViewScene);
            updatePatientRecordViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void saveButtonOA(ActionEvent actionEvent) {
        try {

            if (childAffectedTF.getText().trim().isEmpty() ||
                    teenAgeAffectedTF.getText().trim().isEmpty() ||
                    middleAgeAffectedTF.getText().trim().isEmpty() ||
                    newAffectedTF.getText().trim().isEmpty() ||
                    newRecoveryTF.getText().trim().isEmpty()) {

                errorLabel.setText("Fill all fields!");
                return;
            }

            int child = Integer.parseInt(childAffectedTF.getText().trim());
            int teen = Integer.parseInt(teenAgeAffectedTF.getText().trim());
            int middle = Integer.parseInt(middleAgeAffectedTF.getText().trim());
            int newAffected = Integer.parseInt(newAffectedTF.getText().trim());
            int recovered = Integer.parseInt(newRecoveryTF.getText().trim());

            DailyCovidReport report = new DailyCovidReport(child, teen, middle, newAffected, recovered);

            java.io.File file = new java.io.File("DailyCovidReport.bin");
            java.io.ObjectOutputStream oos;

            if (file.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(
                        new java.io.FileOutputStream(file, true)
                );
            } else {
                oos = new java.io.ObjectOutputStream(
                        new java.io.FileOutputStream(file)
                );
            }

            oos.writeObject(report);
            oos.close();

            notificationLabel.setText("Report Saved!");

            childAffectedTF.clear();
            teenAgeAffectedTF.clear();
            middleAgeAffectedTF.clear();
            newAffectedTF.clear();
            newRecoveryTF.clear();

        } catch (Exception e) {
            errorLabel.setText("Invalid input!");
        }
    }
}