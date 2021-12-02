package com.example.sportbox.controllers;

import com.example.sportbox.db.DatabaseHandler;
import com.example.sportbox.db.GroupDao;
import com.example.sportbox.db.StudentDao;
import com.example.sportbox.model.Group;
import com.example.sportbox.model.Student;
import com.example.sportbox.model.enums.Sex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class StudentCardController {

    private int id;

    @FXML
    private Button backButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button saveButton;

    @FXML
    public TextField lastnameTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField patronymicTextField;

    @FXML
    private TextField sexTextField;

    @FXML
    private TextField groupTextField;

    @FXML
    private TextField phoneTextField;

    StudentDao studentDao = new StudentDao();
    GroupDao groupDao = new GroupDao();

    @FXML
    public void initialize(Student student) {

        id = student.getStudentId();

        lastnameTextField.setText(student.getLastname());
        nameTextField.setText(student.getName());
        patronymicTextField.setText(student.getPatronymic());
        sexTextField.setText(String.valueOf(student.getSex().getLabel()));
        groupTextField.setText(student.getGroup().getName());
        phoneTextField.setText(String.valueOf(student.getPhone()));
    }

    public void backButtonAction(ActionEvent actionEvent) throws IOException {
        Parent studentParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_students.fxml"));
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

        lastnameTextField.setEditable(true);
        nameTextField.setEditable(true);
        patronymicTextField.setEditable(true);
        sexTextField.setEditable(true);
        groupTextField.setEditable(true);
        phoneTextField.setEditable(true);

        lastnameTextField.requestFocus();
    }

    public void saveButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Student updatedStudent = new Student();

        String lastname = lastnameTextField.getText();
        String name = nameTextField.getText();
        String patronymic = patronymicTextField.getText();
        Sex sex = Sex.getSexByLabel(sexTextField.getText());
        Group group = groupDao.getGroupByName(groupTextField.getText());
        Long phone = Long.parseLong(phoneTextField.getText());

        updatedStudent.setStudentId(id);
        updatedStudent.setLastname(lastname);
        updatedStudent.setName(name);
        updatedStudent.setPatronymic(patronymic);
        updatedStudent.setSex(sex);
        updatedStudent.setGroup(group);
        updatedStudent.setPhone(phone);

        studentDao.updateStudent(updatedStudent);
        initialize(updatedStudent);

        changeButton.setDisable(false);
        saveButton.setDisable(true);
        saveButton.setVisible(false);

        lastnameTextField.setEditable(false);
        nameTextField.setEditable(false);
        patronymicTextField.setEditable(false);
        sexTextField.setEditable(false);
        groupTextField.setEditable(false);
        phoneTextField.setEditable(false);
    }
}
