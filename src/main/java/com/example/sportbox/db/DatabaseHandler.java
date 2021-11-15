package com.example.sportbox.db;


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

    /*public List<Participant> getParticipants() throws SQLException, ClassNotFoundException {
        List<Participant> list = new ArrayList<Participant>();
        String selectStudents = "SELECT * FROM test.participant";
        PreparedStatement prSt = getDbConnection().prepareStatement(selectStudents);
        ResultSet resultSet = prSt.executeQuery();
        while(resultSet.next()) {

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String fio = resultSet.getString(3);
            String group = resultSet.getString(4);
            list.add(new Participant(id, name, fio, group));
        }
        return list;
    }*/
}
