package com.example.sportbox.controllers;

import com.example.sportbox.db.DatabaseHandler;
import com.example.sportbox.db.EventDao;
import com.example.sportbox.model.Event;
import com.example.sportbox.model.Student;
import com.example.sportbox.model.enums.CompetitionLevel;
import com.example.sportbox.model.enums.KindOfSport;
import com.example.sportbox.model.enums.Sex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class AddEvent {

    @FXML
    private Button backButton;

    @FXML
    private Button saveButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField levelTextField;

    @FXML
    private TextField kindOfSportTextField;

    EventDao eventDao = new EventDao();

    public void backButtonAction(ActionEvent actionEvent) throws IOException {
        Parent eventParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_events.fxml"));
        Scene eventScene = new Scene(eventParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(eventScene);
        stage.show();
    }

    public void saveButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException, ParseException {
        java.util.Date date = java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Event event = new Event(
                nameTextField.getText(),
                sqlDate,
                KindOfSport.getKindOfSportByLabel(kindOfSportTextField.getText()),
                CompetitionLevel.getCompetitionLevelByLabel(levelTextField.getText())
        );

        eventDao.createEvent(event);

        Parent eventParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_events.fxml"));
        Scene eventScene = new Scene(eventParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(eventScene);
        stage.show();
    }

    public void nameEnterAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            datePicker.requestFocus();
        }
    }

    public void dateEnterAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            kindOfSportTextField.requestFocus();
        }
    }

    public void kindOfSportEnterAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            levelTextField.requestFocus();
        }
    }

    public void levelEnterAction(KeyEvent keyEvent) throws SQLException, IOException, ParseException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            saveButtonAction(new ActionEvent());
        }
    }
}
