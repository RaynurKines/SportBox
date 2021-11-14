package com.example.sportbox.model;

import java.util.List;

public class Competition {

    private int competitionId;
    private String name;
    private Event event;
    private List<Result> results;

    public Competition(int competitionId, String name, Event event, List<Result> results) {
        this.competitionId = competitionId;
        this.name = name;
        this.event = event;
        this.results = results;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
