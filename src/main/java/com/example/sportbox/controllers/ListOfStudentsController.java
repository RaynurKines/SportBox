package com.example.sportbox.controllers;

import com.example.sportbox.model.Group;
import com.example.sportbox.model.Result;
import com.example.sportbox.model.Student;
import com.example.sportbox.model.enums.Faculty;
import com.example.sportbox.model.enums.Sex;
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

public class ListOfStudentsController {

    @FXML
    private Button backButton;

    private ObservableList<Student> studentsData = FXCollections.observableArrayList();

    @FXML
    private TableView<Student> tableStudents;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, Sex> sexColumn;

    @FXML
    private TableColumn<Student, Group> groupColumn;

    @FXML
    private TableColumn<Student, Long> phoneColumn;

    // инициализируем форму данными
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("Id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        sexColumn.setCellValueFactory(new PropertyValueFactory<Student, Sex>("sex"));
        groupColumn.setCellValueFactory(new PropertyValueFactory<Student, Group>("group"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Student, Long>("phone"));
        // заполняем таблицу данными
        tableStudents.setItems(studentsData);
    }

    // подготавливаем данные для таблицы
    private void initData() throws SQLException, ClassNotFoundException {

        studentsData.add(new Student(1, "Alex", Sex.female, null, null, 79543035983L));
        studentsData.add(new Student(2, "Bob", Sex.male, null, null, 79543035983L));
        studentsData.add(new Student(3, "Jack", Sex.male, null, null, 79543035983L));
        studentsData.add(new Student(4, "Mike", Sex.male, null, null, 79543035983L));
        studentsData.add(new Student(5, "Colin", Sex.male, null, null, 79543035983L));
        /*DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.getParticipants();

        participantsData.addAll(databaseHandler.getParticipants());*/
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
}
