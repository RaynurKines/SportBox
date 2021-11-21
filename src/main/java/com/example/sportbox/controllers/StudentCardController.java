package com.example.sportbox.controllers;

import com.example.sportbox.model.Group;
import com.example.sportbox.model.Student;
import com.example.sportbox.model.enums.Sex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class StudentCardController {

    Student student = new Student();

    @FXML
    private Button backButton;

    @FXML
    public Text lastnameText;

    @FXML
    private Text nameText;

    @FXML
    private Text patronymicText;

    @FXML
    private Text sexText;

    @FXML
    private Text groupText;

    @FXML
    private Text phoneText;


    @FXML
    public void initialize(Student student) {
        lastnameText.setText(student.getLastname());
        nameText.setText(student.getName());
        patronymicText.setText(student.getPatronymic());
        sexText.setText(String.valueOf(student.getSex()));
        groupText.setText(student.getGroup().getName());
        phoneText.setText(String.valueOf(student.getPhone()));
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
}
