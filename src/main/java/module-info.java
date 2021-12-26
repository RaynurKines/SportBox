module com.example.sportbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;


    opens com.example.sportbox to javafx.fxml;
    exports com.example.sportbox;
    exports com.example.sportbox.model;
    opens com.example.sportbox.model to org.hibernate.orm.core;
    exports com.example.sportbox.controller;
    opens com.example.sportbox.controller to javafx.fxml;
}