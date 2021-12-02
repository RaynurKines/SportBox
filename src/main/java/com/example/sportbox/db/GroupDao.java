package com.example.sportbox.db;

import com.example.sportbox.model.Group;
import com.example.sportbox.model.Student;
import com.example.sportbox.model.enums.Faculty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao {

    DatabaseHandler dbHandler = new DatabaseHandler();
    public Group getGroupById(int id) throws SQLException, ClassNotFoundException {
        String selectGroup = "SELECT * FROM sportbox.group where group_id=?";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(selectGroup);
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
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(selectGroup);
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
}
