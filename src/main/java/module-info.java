module com.example.sportbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sportbox to javafx.fxml;
    exports com.example.sportbox;
}