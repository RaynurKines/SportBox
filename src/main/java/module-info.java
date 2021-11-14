module com.example.sportbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sportbox to javafx.fxml;
    exports com.example.sportbox;
}