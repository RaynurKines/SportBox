package com.example.sportbox.controllers;

import com.example.sportbox.db.DatabaseHandler;
import com.example.sportbox.db.EventDao;
import com.example.sportbox.model.Event;
import com.example.sportbox.model.enums.CompetitionLevel;
import com.example.sportbox.model.enums.KindOfSport;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class EventController {

    private ObservableList<Event> eventsData = FXCollections.observableArrayList();

    @FXML
    private Button backButton;

    @FXML
    private TableView<Event> tableEvents;

    @FXML
    private TableColumn<Event, String> nameColumn;

    @FXML
    private TableColumn<Event, Date> dateColumn;

    @FXML
    private TableColumn<Event, String> kindOfSportColumn;

    @FXML
    private TableColumn<Event, String> levelColumn;

    EventDao eventDao = new EventDao();

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        initData();

        nameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Event, Date>("date"));
        kindOfSportColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().getKindOfSport().getLabel()));
        levelColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().getCompetitionLevel().getLabel()));

        tableEvents.setItems(eventsData);
    }


    private void initData() throws SQLException, ClassNotFoundException {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        eventsData.addAll(eventDao.getEvents());
    }

    public void backButtonAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("home.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void viewingButtonAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();

        Event event = tableEvents.getSelectionModel().getSelectedItem();
        if (event == null)
            event = tableEvents.getItems().get(0);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("event_card.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
        EventCardController controller = loader.getController();
        controller.initialize(event);
    }

    public void deleteButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        DatabaseHandler databaseHandler = new DatabaseHandler();

        Event event = tableEvents.getSelectionModel().getSelectedItem();

        eventDao.deleteEvent(event);
        if(tableEvents.getItems().size()>1){
            tableEvents.getItems().clear();
            initialize();
        }
        else
            tableEvents.getItems().clear();
    }

    public void changeButtonAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();

        Event event = tableEvents.getSelectionModel().getSelectedItem();
        if(event == null)
            event = tableEvents.getItems().get(0);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("event_card.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
        EventCardController controller = loader.getController();
        controller.initialize(event);
        controller.changeButtonAction(new ActionEvent());
    }

    public void createButtonAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("add_event.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }


}
