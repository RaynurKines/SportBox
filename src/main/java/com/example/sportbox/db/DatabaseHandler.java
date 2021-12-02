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

}
