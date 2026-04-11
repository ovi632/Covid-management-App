package com.example.covidmanagementapp.Ashraf;

import com.example.covidmanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class doctorCheckPatientInfoViewController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn ageInPatientInfoTC;
    @javafx.fxml.FXML
    private TableColumn nameInPatientInfoTC;
    @javafx.fxml.FXML
    private TableColumn previousDiagnosesInPatientInfoTC;
    @javafx.fxml.FXML
    private TableColumn labReportInPatientInfoTC;
    @javafx.fxml.FXML
    private TextField registrationIdTF;
    @javafx.fxml.FXML
    private TableColumn covidStatusInPatientInfoTC;
    @javafx.fxml.FXML
    private Label infoShowLabel;
    @javafx.fxml.FXML
    private TableColumn vaccinationStatusInPatientInfoTC;
    @javafx.fxml.FXML
    private TableColumn genderInPatientInfoTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/covidmanagementapp/Ashraf/doctorDashBoardView.fxml"));
            Scene updateRecoveryStatusViewscene = new Scene(fxmlLoader.load());
            Stage updateRecoveryStatusViewStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            updateRecoveryStatusViewStage.setTitle("Doctor Dashboard");
            updateRecoveryStatusViewStage.setScene(updateRecoveryStatusViewscene);
            updateRecoveryStatusViewStage.show();
        }catch (Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void SearchButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void patientInfoTableView(Event event) {
    }
}