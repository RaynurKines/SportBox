package com.example.sportbox.service;

import com.example.sportbox.dao.CompetitionDao;
import com.example.sportbox.dao.EventDao;
import com.example.sportbox.model.Competition;
import com.example.sportbox.model.Event;

import java.util.List;

public class CompetitionService {
    private CompetitionDao competitionDao = new CompetitionDao();

    public CompetitionService() {
    }

    public Competition findCompetition(int id) {
        return competitionDao.findById(id);
    }

    public void saveCompetition(Competition competition) {
        competitionDao.save(competition);
    }

    public void deleteCompetition(Competition competition) {
        competitionDao.delete(competition);
    }

    public void updateCompetition(Competition competition) {
        competitionDao.update(competition);
    }

    public List<Competition> findAllCompetitions() {
        return competitionDao.findAll();
    }

    public List<Competition> findCompetitionsByEventId(Event event) {
        return competitionDao.findCompetitionsByEventId(event);
    }
}
