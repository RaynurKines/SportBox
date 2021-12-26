package com.example.sportbox.controller;

import com.example.sportbox.model.Group;
import com.example.sportbox.model.enums.Faculty;
import com.example.sportbox.service.GroupService;
import javafx.beans.property.SimpleStringProperty;
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
import java.time.ZoneId;

public class ListOfGroupsController {

    private ObservableList<Group> groupsData = FXCollections.observableArrayList();

    @FXML
    private Button createButton;

    @FXML
    private Button saveButton;

    @FXML
    private TableView<Group> tableGroups;

    @FXML
    private TableColumn<Group, String> nameColumn;

    @FXML
    private TableColumn<Group, String> facultyColumn;

    @FXML
    private TableColumn<Group, Date> dateStartColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField facultyTextField;

    @FXML
    private DatePicker datePicker;

    GroupService groupService = new GroupService();
    private Group changedGroup = new Group();

    @FXML
    private void initialize() {
        initData();

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        facultyColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFaculty().getLabel()));
        dateStartColumn.setCellValueFactory(new PropertyValueFactory<>("dateStart"));

        tableGroups.setItems(groupsData);
    }

    private void initData() {
        groupsData.addAll(groupService.findAllGroups());
    }

    public void createButtonAction(ActionEvent actionEvent) {
        java.util.Date date = java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

        Group group = new Group();
        group.setName(nameTextField.getText());
        group.setFaculty(Faculty.getFacultyByLabel(facultyTextField.getText()));
        group.setDateStart(new java.sql.Date(date.getTime()));

        groupService.saveGroup(group);
        initialize();
        if(tableGroups.getItems().size()>1){
            tableGroups.getItems().clear();
            initialize();
        }
        else
            tableGroups.getItems().clear();
    }

    public void changeButtonAction(ActionEvent actionEvent) {
        if(tableGroups.getItems().size() > 0) {
            changedGroup = tableGroups.getSelectionModel().getSelectedItem();
            if (changedGroup == null)
                changedGroup = tableGroups.getItems().get(0);
        }
        nameTextField.setText(changedGroup.getName());
        facultyTextField.setText(changedGroup.getFaculty().getLabel());
        datePicker.setValue(changedGroup.getDateStart().toLocalDate());

        saveButton.setVisible(true);
        saveButton.setDisable(false);
    }

    public void saveButtonAction(ActionEvent actionEvent) {
        java.util.Date date = java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        changedGroup.setName(nameTextField.getText());
        changedGroup.setFaculty(Faculty.getFacultyByLabel(facultyTextField.getText()));
        changedGroup.setDateStart(new java.sql.Date(date.getTime()));

        groupService.updateGroup(changedGroup);
        if(tableGroups.getItems().size()>0){
            tableGroups.getItems().clear();
            initialize();
        }
    }

    public void deleteButtonAction(ActionEvent actionEvent) {
        groupService.deleteGroup(tableGroups.getSelectionModel().getSelectedItem());
        if(tableGroups.getItems().size()>1){
            tableGroups.getItems().clear();
            initialize();
        }
        else
            tableGroups.getItems().clear();
    }

    public void showEventsMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_events.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) createButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void showStudentsMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_students.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) createButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void showGroupsMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_groups.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) createButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void createEventMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("add_event.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) createButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void createStudentMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("add_student.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) createButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }
}
