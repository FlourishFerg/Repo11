module com.example.repo11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.repo11 to javafx.fxml;
    exports com.example.repo11;
}