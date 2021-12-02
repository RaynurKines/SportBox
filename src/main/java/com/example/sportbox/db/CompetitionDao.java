package com.example.sportbox.db;

import com.example.sportbox.model.Competition;
import com.example.sportbox.model.Student;
import com.example.sportbox.model.enums.Sex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDao {

    DatabaseHandler dbHandler = new DatabaseHandler();
    EventDao eventDao = new EventDao();

    public List<Competition> getConnectionsByEventId(int event_Id) throws SQLException, ClassNotFoundException {
        List<Competition> list = new ArrayList<Competition>();
        String selectCompetitions = "SELECT * FROM sportbox.competition WHERE event_id=?";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(selectCompetitions);
        prSt.setInt(1, event_Id);
        ResultSet resultSet = prSt.executeQuery();
        while(resultSet.next()) {
            Competition competition = new Competition();
            competition.setCompetitionId(resultSet.getInt("competition_id"));
            competition.setName(resultSet.getString("name"));
            competition.setEvent(eventDao.getEventById(resultSet.getInt("event_id")));
            list.add(competition);
        }
        return list;
    }

    public void writeCompetitionsInDb(List<String> list, int event_id) throws SQLException, ClassNotFoundException {
        String createCompetition = "INSERT INTO competition (name, event_id) VALUES (?, ?)";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(createCompetition);

        for (String name: list) {
            prSt.setString(1, name);
            prSt.setInt(2, event_id);
            prSt.executeUpdate();
        }
    }

    public void setInPreparedStatement(Competition competition, PreparedStatement prSt) throws SQLException, ClassNotFoundException {
        prSt.setString(1, competition.getName());
        prSt.setInt(2, competition.getEvent().getEventId());
        prSt.executeUpdate();
    }
}
