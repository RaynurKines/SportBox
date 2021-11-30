package com.example.sportbox.controllers;

import com.example.sportbox.db.DatabaseHandler;
import com.example.sportbox.model.Event;
import com.example.sportbox.model.Group;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.ZoneId;

public class EventCardController {

    private int id;

    @FXML
    private Button backButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button saveButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField kindOfSportTextField;

    @FXML
    private TextField levelTextField;

    @FXML
    public void initialize(Event event) {
        id = event.getEventId();

        nameTextField.setText(event.getName());
        datePicker.setValue(event.getDate().toLocalDate());
        kindOfSportTextField.setText(event.getKindOfSport().getLabel());
        levelTextField.setText(event.getCompetitionLevel().getLabel());
    }

    public void backButtonAction(ActionEvent actionEvent) throws IOException {
        Parent studentParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_events.fxml"));
        Scene studentScene = new Scene(studentParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(studentScene);
        stage.show();
    }

    public void changeButtonAction(ActionEvent actionEvent) {
        changeButton.setDisable(true);
        saveButton.setDisable(false);
        saveButton.setVisible(true);

        nameTextField.setEditable(true);
        datePicker.setEditable(true);
        kindOfSportTextField.setEditable(true);
        levelTextField.setEditable(true);

        nameTextField.requestFocus();
    }

    public void saveButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Event updatedEvent = new Event();

        String name = nameTextField.getText();
        java.util.Date date = java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date sqlDate = new java.sql.Date(date.getTime());
        KindOfSport kindOfSport = KindOfSport.getKindOfSportByLabel(kindOfSportTextField.getText());
        CompetitionLevel level = CompetitionLevel.getCompetitionLevelByLabel(levelTextField.getText());

        updatedEvent.setEventId(id);
        updatedEvent.setName(name);
        updatedEvent.setDate(sqlDate);
        updatedEvent.setKindOfSport(kindOfSport);
        updatedEvent.setCompetitionLevel(level);

        dbHandler.updateEvent(updatedEvent);
        initialize(updatedEvent);

        changeButton.setDisable(false);
        saveButton.setDisable(true);
        saveButton.setVisible(false);

        nameTextField.setEditable(false);
        datePicker.setEditable(false);
        kindOfSportTextField.setEditable(false);
        levelTextField.setEditable(false);
    }
}
