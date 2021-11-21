package com.example.sportbox.db;


import com.example.sportbox.model.Group;
import com.example.sportbox.model.Student;
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

    /*public List<Student> getStudents() throws SQLException, ClassNotFoundException {
        List<Student> list = new ArrayList<Student>();
        String selectStudents = "SELECT * FROM test.participant";
        PreparedStatement prSt = getDbConnection().prepareStatement(selectStudents);
        ResultSet resultSet = prSt.executeQuery();
        while(resultSet.next()) {

            int id = resultSet.getInt(1);
            String lastname = resultSet.getString(2);
            String name = resultSet.getString(3);
            String patronymic = resultSet.getString(4);
            Sex sex = resultSet.getString(5);
            Group group = resultSet.getString(6);
            list.add(new Student(id, lastname, name, patronymic, sex, group, results, phone));
        }
        return list;
    }*/
}
