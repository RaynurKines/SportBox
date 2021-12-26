package com.example.sportbox.controller;

import com.example.sportbox.utils.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;



public class HomeController {

    @FXML
    private Button eventButton;

    @FXML
    private Button studentButton;

    @FXML
    public void eventButtonAction(ActionEvent actionEvent) throws IOException {
        Parent eventParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_events.fxml"));
        Scene eventScene = new Scene(eventParent);
        Stage thisStage = (Stage) eventButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(eventScene);
        stage.show();
    }

    public void studentButtonAction(ActionEvent actionEvent) throws IOException {
        Parent studentParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_students.fxml"));
        Scene studentScene = new Scene(studentParent);
        Stage thisStage = (Stage) studentButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(studentScene);
        stage.show();
    }

    public void showEventsMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_events.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) eventButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void showStudentsMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_students.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) eventButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void showGroupsMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_groups.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) eventButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void createEventMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("add_event.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) eventButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void createStudentMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("add_student.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) eventButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }
}
