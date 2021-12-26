package com.example.sportbox.service;

import com.example.sportbox.dao.EventDao;
import com.example.sportbox.dao.StudentDao;
import com.example.sportbox.model.Competition;
import com.example.sportbox.model.Event;
import com.example.sportbox.model.Result;
import com.example.sportbox.model.Student;

import java.util.List;

public class EventService {
    private EventDao eventDao = new EventDao();

    public EventService() {
    }

    public Event findEvent(int id) {
        return eventDao.findById(id);
    }

    public void saveEvent(Event event) {
        eventDao.save(event);
    }

    public void deleteEvent(Event event) {
        eventDao.delete(event);
    }

    public void updateEvent(Event event) {
        eventDao.update(event);
    }

    public List<Event> findAllEvents() {
        return eventDao.findAll();
    }
}
