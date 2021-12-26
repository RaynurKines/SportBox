package com.example.sportbox.controller;

import com.example.sportbox.model.Student;
import com.example.sportbox.service.StudentService;
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
    private TableColumn<Student, String> lastnameColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> patronymicColumn;

    @FXML
    private TableColumn<Student, String> sexColumn;

    @FXML
    private TableColumn<Student, String> groupColumn;

    @FXML
    private TableColumn<Student, Long> phoneColumn;

    StudentService studentService = new StudentService();

    // инициализируем форму данными
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("studentId"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("patronymic"));
        sexColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().getSex().getLabel()));
        groupColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().getGroup().getName()));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Student, Long>("phone"));
        // заполняем таблицу данными
        tableStudents.setItems(studentsData);
    }

    // подготавливаем данные для таблицы
    private void initData() throws SQLException, ClassNotFoundException {
        if (studentService.findAllStudents() != null)
            studentsData.addAll(studentService.findAllStudents());
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

    public void viewingButtonAction(ActionEvent actionEvent) throws IOException {

        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();

        Student student = tableStudents.getSelectionModel().getSelectedItem();
        if (student == null)
            student = tableStudents.getItems().get(0);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("student_card.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
        StudentCardController controller = loader.getController();
        controller.initialize(student);
    }

    public void deleteButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Student student = tableStudents.getSelectionModel().getSelectedItem();
        studentService.deleteStudent(student);
        initialize();
    }

    public void changeButtonAction(ActionEvent actionEvent) throws IOException {

        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();

        Student student = tableStudents.getSelectionModel().getSelectedItem();
        if (student == null)
            student = tableStudents.getItems().get(0);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("student_card.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
        StudentCardController controller = loader.getController();
        controller.initialize(student);
        controller.changeButtonAction(new ActionEvent());
    }

    public void createButtonAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("add_student.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void showEventsMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_events.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void showStudentsMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_students.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void showGroupsMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_groups.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void createEventMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("add_event.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    public void createStudentMenuAction(ActionEvent actionEvent) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getClassLoader().getResource("add_student.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(homeScene);
        stage.show();
    }
}
