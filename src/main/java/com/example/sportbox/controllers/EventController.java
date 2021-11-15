package com.example.sportbox.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EventController {

    @FXML
    private Button backButton;

    public void backButtonAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("home.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }


}
