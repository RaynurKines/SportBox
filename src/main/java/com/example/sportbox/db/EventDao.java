package com.example.sportbox.db;

import com.example.sportbox.model.Event;
import com.example.sportbox.model.Group;
import com.example.sportbox.model.enums.CompetitionLevel;
import com.example.sportbox.model.enums.Faculty;
import com.example.sportbox.model.enums.KindOfSport;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDao {

    DatabaseHandler dbHandler = new DatabaseHandler();
    public void deleteEvent(Event event) throws SQLException, ClassNotFoundException {
        String deleteEvent = "DELETE FROM event WHERE event_id=?";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(deleteEvent);
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
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(createEvent);
        prSt.setString(1, event.getName());
        prSt.setDate(2, (Date) event.getDate());
        prSt.setString(3, event.getKindOfSport().getLabel());
        prSt.setString(4, event.getCompetitionLevel().getLabel());

        prSt.executeUpdate();
    }

    public void updateEvent(Event event) throws SQLException, ClassNotFoundException {

        String updatedEvent = "UPDATE event SET name=?, date=?, kindofsport=?, level=? WHERE event_id=?";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(updatedEvent);
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

    public List<Event> getEvents() throws SQLException, ClassNotFoundException {
        List<Event> list = new ArrayList<Event>();
        String selectEvents = "SELECT * FROM sportbox.event";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(selectEvents);
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

    public Event getEventById(int event_id) throws SQLException, ClassNotFoundException {
        String selectEvent = "SELECT * FROM sportbox.event where event_id=?";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(selectEvent);
        prSt.setInt(1, event_id);
        ResultSet resultSet = prSt.executeQuery();
        Event event = new Event();
        if (resultSet.next()) {
            event.setEventId(resultSet.getInt("event_id"));
            event.setName(resultSet.getString("name"));
            event.setDate(resultSet.getDate("date"));
            event.setKindOfSport(KindOfSport.getKindOfSportByLabel(resultSet.getString("kindofsport")));
            event.setCompetitionLevel(CompetitionLevel.getCompetitionLevelByLabel(resultSet.getString("level")));
        }
        return event;
    }
}
