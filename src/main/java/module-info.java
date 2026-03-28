module com.example.covidmanagementapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.covidmanagementapp to javafx.fxml;
    exports com.example.covidmanagementapp;
}