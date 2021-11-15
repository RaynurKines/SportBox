package com.example.sportbox.model;

import com.example.sportbox.model.enums.Sex;

import java.util.List;

public class Student {

    private int Id;
    private String name;
    private Sex sex;
    private Group group;
    private List<Result> results;
    private long phone;

    public Student(int Id, String name, Sex sex, Group group, List<Result> results, long phone) {
        this.Id = Id;
        this.name = name;
        this.sex = sex;
        this.group = group;
        this.results = results;
        this.phone = phone;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
