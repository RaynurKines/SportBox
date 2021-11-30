package com.example.sportbox.db;


import com.example.sportbox.model.Event;
import com.example.sportbox.model.Group;
import com.example.sportbox.model.Student;
import com.example.sportbox.model.enums.CompetitionLevel;
import com.example.sportbox.model.enums.Faculty;
import com.example.sportbox.model.enums.KindOfSport;
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
            student.setStudentId(resultSet.getInt("student_id"));
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

    public List<Event> getEvents() throws SQLException, ClassNotFoundException {
        List<Event> list = new ArrayList<Event>();
        String selectEvents = "SELECT * FROM sportbox.event";
        PreparedStatement prSt = getDbConnection().prepareStatement(selectEvents);
        ResultSet resultSet = prSt.executeQuery();
        while(resultSet.next()) {
            Event event = new Event();
            event.setEventId(resultSet.getInt("event_id"));
            event.setName(resultSet.getString("name"));
            event.setDate(resultSet.getDate("date"));
            event.setKindOfSport(KindOfSport.getKindOfSportByLabel(resultSet.getString("kindofsport")));
            event.setCompetitionLevel(CompetitionLevel.getCompetitionLevelByLabel(resultSet.getString("level")));
            list.add(event);
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
        prSt.setInt(7, student.getStudentId());

        int rowsUpdated = prSt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing student was updated successfully!");
        }
        else
            System.out.println("BAD");
    }

    public void deleteStudent(Student student) throws SQLException, ClassNotFoundException {
        String deleteStudent = "DELETE FROM student WHERE student_id=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(deleteStudent);
        prSt.setInt(1, student.getStudentId());

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

    public void deleteEvent(Event event) throws SQLException, ClassNotFoundException {
        String deleteEvent = "DELETE FROM event WHERE event_id=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(deleteEvent);
        prSt.setInt(1, event.getEventId());

        int rowsUpdated = prSt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing event was updated successfully!");
        }
        else
            System.out.println("BAD");
    }

    public void createEvent(Event event) throws SQLException, ClassNotFoundException {
        String createEvent = "INSERT INTO event (name, date, kindofsport, level) VALUES (?, ?, ?, ?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(createEvent);
        prSt.setString(1, event.getName());
        prSt.setDate(2, (Date) event.getDate());
        prSt.setString(3, event.getKindOfSport().getLabel());
        prSt.setString(4, event.getCompetitionLevel().getLabel());

        prSt.executeUpdate();
    }

    public void updateEvent(Event event) throws SQLException, ClassNotFoundException {

        String updatedEvent = "UPDATE event SET name=?, date=?, kindofsport=?, level=? WHERE event_id=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(updatedEvent);
        prSt.setString(1, event.getName());
        prSt.setDate(2, event.getDate());
        prSt.setString(3, event.getKindOfSport().getLabel());
        prSt.setString(4, event.getCompetitionLevel().getLabel());
        prSt.setInt(5, event.getEventId());

        int rowsUpdated = prSt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing student was updated successfully!");
        }
        else
            System.out.println("BAD");
    }
}
