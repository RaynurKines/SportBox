module com.example.sportbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    requires java.persistence;
    requires org.hibernate.orm.core;


    opens com.example.sportbox to javafx.fxml;
    exports com.example.sportbox;
    exports com.example.sportbox.model;
    exports com.example.sportbox.controllers;
    opens com.example.sportbox.controllers to javafx.fxml;
}