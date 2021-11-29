package com.example.sportbox.controllers;

import com.example.sportbox.db.DatabaseHandler;
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

public class AddStudent {

    @FXML
    private Button backButton;


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

    DatabaseHandler dbHandler = new DatabaseHandler();

    public void backButtonAction(ActionEvent actionEvent) throws IOException {
        Parent studentParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_students.fxml"));
        Scene studentScene = new Scene(studentParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(studentScene);
        stage.show();
    }

    public void saveButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {

        Student student = new Student(
                lastnameTextField.getText(),
                nameTextField.getText(),
                patronymicTextField.getText(),
                Sex.getSexByLabel(sexTextField.getText()),
                dbHandler.getGroupByName(groupTextField.getText()),
                Long.parseLong(phoneTextField.getText())
        );

        dbHandler.createStudent(student);

        Parent studentParent = FXMLLoader.load(getClass().getClassLoader().getResource("list_of_students.fxml"));
        Scene studentScene = new Scene(studentParent);
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.hide();
        Stage stage = new Stage();
        stage.setScene(studentScene);
        stage.show();
    }
}
