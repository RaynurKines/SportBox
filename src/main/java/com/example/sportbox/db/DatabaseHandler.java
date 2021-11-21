package com.example.sportbox.db;


import com.example.sportbox.model.Group;
import com.example.sportbox.model.Student;
import com.example.sportbox.model.enums.Faculty;
import com.example.sportbox.model.enums.Sex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://localhost/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);

        return dbConnection;

    }

    public List<Student> getStudents() throws SQLException, ClassNotFoundException {
        List<Student> list = new ArrayList<Student>();
        String selectStudents = "SELECT * FROM sportbox.student";
        PreparedStatement prSt = getDbConnection().prepareStatement(selectStudents);
        ResultSet resultSet = prSt.executeQuery();
        while(resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("student_id"));
            student.setLastname(resultSet.getString("lastname"));
            student.setName(resultSet.getString("name"));
            student.setPatronymic(resultSet.getString("patronymic"));
            student.setSex(Sex.getSexByLabel(resultSet.getString("sex")));
            student.setGroup(getGroup(resultSet.getInt("group_id")));
            Long phone = resultSet.getLong("phone");
            list.add(student);
        }
        return list;
    }

    public Group getGroup(int id) throws SQLException, ClassNotFoundException {
        String selectGroup = String.format("SELECT * FROM sportbox.group where group_id = %id", id);
        PreparedStatement prSt = getDbConnection().prepareStatement(selectGroup);
        ResultSet resultSet = prSt.executeQuery();
        Group group = new Group();
        if (resultSet.next()) {
            group.setGroupId(resultSet.getInt("group_id"));
            group.setName(resultSet.getString("name"));
            group.setFaculty(Faculty.getFacultyByLabel(resultSet.getString("faculty")));
            group.setDateStart(resultSet.getDate("datestart"));
        }
        return group;
    }
}
