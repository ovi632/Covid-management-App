module com.example.covidmanagementapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.covidmanagementapp to javafx.fxml;
    opens com.example.covidmanagementapp.Ashraf to javafx.fxml;
    opens com.example.covidmanagementapp.Ishika to javafx.fxml;
    opens com.example.covidmanagementapp.Anamika to javafx.fxml;
    opens com.example.covidmanagementapp.Kumkum to javafx.fxml;

    exports com.example.covidmanagementapp;
}