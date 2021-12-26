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

    @FXML
    private TextField addCompetitionTextField;

    EventService eventService = new EventService();
    CompetitionService competitionService = new CompetitionService();
    Event event;

    @FXML
    public void initialize(Event event) {
        this.event = event;
        initData();

        nameTextField.setText(event.getName());
        datePicker.setValue(event.getDate().toLocalDate());
        kindOfSportTextField.setText(event.getKindOfSport().getLabel());
        levelTextField.setText(event.getCompetitionLevel().getLabel());
        try {
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void initData() {
        competitionsData.addAll(competitionService.findCompetitionsByEventId(event));
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

        nameColumn.setEditable(true);

        nameTextField.requestFocus();
    }

    public void saveButtonAction(ActionEvent actionEvent) {
        Date sqlDate = new java.sql.Date(java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());

        event.setName(nameTextField.getText());
        event.setDate(sqlDate);
        event.setKindOfSport(KindOfSport.getKindOfSportByLabel(kindOfSportTextField.getText()));
        event.setCompetitionLevel(CompetitionLevel.getCompetitionLevelByLabel(levelTextField.getText()));

        for (Competition c : tableCompetitions.getItems()) {
            c.setName(nameColumn.getText());
            competitionService.updateCompetition(c);
        }

        eventService.updateEvent(event);
        initialize(event);

        changeButton.setDisable(false);
        saveButton.setDisable(true);
        saveButton.setVisible(false);

        nameTextField.setEditable(false);
        datePicker.setEditable(false);
        kindOfSportTextField.setEditable(false);
        levelTextField.setEditable(false);
    }

    public void addCompetitionButtonAction(ActionEvent actionEvent) {
        Competition competition = new Competition();
        competition.setEvent(event);
        competition.setName(addCompetitionTextField.getText());

        competitionService.saveCompetition(competition);

        if(tableCompetitions.getItems().size() > 1) {
            tableCompetitions.getItems().clear();
            initialize(event);
        }
    }
}
