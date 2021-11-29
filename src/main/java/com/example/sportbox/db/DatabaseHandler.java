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
            student.setGroup(getGroupById(resultSet.getInt("group_id")));
            student.setPhone(resultSet.getLong("phone"));
            list.add(student);
        }
        return list;
    }

    public Group getGroupById(int id) throws SQLException, ClassNotFoundException {
        String selectGroup = "SELECT * FROM sportbox.group where group_id=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(selectGroup);
        prSt.setInt(1, id);
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

    public Group getGroupByName(String name) throws SQLException, ClassNotFoundException {
        String selectGroup = "SELECT * FROM sportbox.group where name=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(selectGroup);
        prSt.setString(1, name);
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

    public void updateStudent(Student student) throws SQLException, ClassNotFoundException {

        String updateStudent = "UPDATE student SET lastname=?, name=?, patronymic=?, sex=?, group_id=?, phone=? WHERE student_id=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(updateStudent);
        prSt.setString(1, student.getLastname());
        prSt.setString(2, student.getName());
        prSt.setString(3, student.getPatronymic());
        prSt.setString(4, student.getSex().getLabel());
        prSt.setInt(5, student.getGroup().getGroupId());
        prSt.setLong(6, student.getPhone());
        prSt.setInt(7, student.getId());

        int rowsUpdated = prSt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing student was updated successfully!");
        }
        else
            System.out.println("BAD");
    }

    public void deleteStudent(Student student) throws SQLException, ClassNotFoundException {
        String updateStudent = "DELETE FROM student WHERE student_id=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(updateStudent);
        prSt.setInt(1, student.getId());

        int rowsUpdated = prSt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing student was updated successfully!");
        }
        else
            System.out.println("BAD");
    }

    public void createStudent(Student student) throws SQLException, ClassNotFoundException {
        String createStudent = "INSERT INTO student (lastname, name, patronymic, sex, group_id, phone) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(createStudent);
        prSt.setString(1, student.getLastname());
        prSt.setString(2, student.getName());
        prSt.setString(3, student.getPatronymic());
        prSt.setString(4, student.getSex().getLabel());
        prSt.setInt(5, student.getGroup().getGroupId());
        prSt.setLong(6, student.getPhone());

        prSt.executeUpdate();
    }
}
