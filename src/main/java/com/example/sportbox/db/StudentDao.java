package com.example.sportbox.db;

import com.example.sportbox.model.Student;
import com.example.sportbox.model.enums.Sex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    DatabaseHandler dbHandler = new DatabaseHandler();
    GroupDao groupDao = new GroupDao();
    public void updateStudent(Student student) throws SQLException, ClassNotFoundException {

        String updateStudent = "UPDATE student SET lastname=?, name=?, patronymic=?, sex=?, group_id=?, phone=? WHERE student_id=?";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(updateStudent);
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
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(deleteStudent);
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
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(createStudent);
        prSt.setString(1, student.getLastname());
        prSt.setString(2, student.getName());
        prSt.setString(3, student.getPatronymic());
        prSt.setString(4, student.getSex().getLabel());
        prSt.setInt(5, student.getGroup().getGroupId());
        prSt.setLong(6, student.getPhone());

        prSt.executeUpdate();
    }

    public List<Student> getStudents() throws SQLException, ClassNotFoundException {
        List<Student> list = new ArrayList<Student>();
        String selectStudents = "SELECT * FROM sportbox.student";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(selectStudents);
        ResultSet resultSet = prSt.executeQuery();
        while(resultSet.next()) {
            Student student = new Student();
            student.setStudentId(resultSet.getInt("student_id"));
            student.setLastname(resultSet.getString("lastname"));
            student.setName(resultSet.getString("name"));
            student.setPatronymic(resultSet.getString("patronymic"));
            student.setSex(Sex.getSexByLabel(resultSet.getString("sex")));
            student.setGroup(groupDao.getGroupById(resultSet.getInt("group_id")));
            student.setPhone(resultSet.getLong("phone"));
            list.add(student);
        }
        return list;
    }
}
