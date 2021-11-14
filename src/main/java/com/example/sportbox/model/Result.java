package com.example.sportbox.model;

import com.example.sportbox.model.enums.Place;

public class Result {

    private int resultId;
    private Student student;
    private Place place;
    private Competition competition;

    public Result(int resultId, Student student, Place place, Competition competition) {
        this.resultId = resultId;
        this.student = student;
        this.place = place;
        this.competition = competition;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
