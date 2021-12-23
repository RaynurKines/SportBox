package com.example.sportbox.controller;

import com.example.sportbox.model.Competition;
import com.example.sportbox.model.Event;
import com.example.sportbox.model.enums.CompetitionLevel;
import com.example.sportbox.model.enums.KindOfSport;
import com.example.sportbox.service.CompetitionService;
import com.example.sportbox.service.EventService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class EventCardController {

    private ObservableList<Competition> competitionsData = FXCollections.observableArrayList();

//    private int id;

    @FXML
    private TableView<Competition> tableCompetitions;

    @FXML
    private TableColumn<Competition, String> nameColumn;

    @FXML
    private Button backButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button createCompetitionsButton;

    @FXML
    private Button saveCompetitionsButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField kindOfSportTextField;

    @FXML
    private TextField levelTextField;

    EventService eventService;
    CompetitionService competitionService;
    Event event;

    @FXML
    public void initialize(Event event) throws SQLException, ClassNotFoundException {
        this.event = event;

        nameTextField.setText(event.getName());
        datePicker.setValue(event.getDate().toLocalDate());
        kindOfSportTextField.setText(event.getKindOfSport().getLabel());
        levelTextField.setText(event.getCompetitionLevel().getLabel());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Competition, String>("name"));
    }

    private void initData() throws SQLException, ClassNotFoundException {
        competitionsData.addAll(eventService.findCompetitions());
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
        Date sqlDate = new java.sql.Date(java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());

        event.setName(nameTextField.getText());
        event.setDate(sqlDate);
        event.setKindOfSport(KindOfSport.getKindOfSportByLabel(kindOfSportTextField.getText()));
        event.setCompetitionLevel(CompetitionLevel.getCompetitionLevelByLabel(levelTextField.getText()));

        eventService.updateEvent(event);
        initialize(event);

        changeButton.setDisable(false);
        saveButton.setDisable(true);
        saveButton.setVisible(false);

        nameTextField.setEditable(false);
        datePicker.setEditable(false);
        kindOfSportTextField.setEditable(false);
        levelTextField.setEditable(false);

        createCompetitionsButtonAction(new ActionEvent());
    }

    //убрать в add
    public void createCompetitionsButtonAction(ActionEvent actionEvent) {
        tableCompetitions.setEditable(true);
        createCompetitionsButton.setDisable(true);
        saveCompetitionsButton.setVisible(true);
        saveCompetitionsButton.setDisable(false);
    }

    public void saveCompetitionsButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        tableCompetitions.setEditable(false);
        List<Competition> list = tableCompetitions.getItems();
        List<String> names = new ArrayList<>();
        for (Competition comp : list) {
            names.add(comp.getName());
        }
//        competitionDao.writeCompetitionsInDb(names, id);

        tableCompetitions.setEditable(false);
        createCompetitionsButton.setDisable(false);
        saveCompetitionsButton.setVisible(false);
        saveCompetitionsButton.setDisable(true);
    }
}
