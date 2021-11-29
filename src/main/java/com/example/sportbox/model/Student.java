package com.example.sportbox.model;

import com.example.sportbox.model.enums.Sex;

import java.util.List;

public class Student {

    private int Id;
    private String name;
    private String lastname;
    private String patronymic;
    private Sex sex;
    private Group group;
    private List<Result> results;
    private long phone;

    public Student() {
    }

    public Student(String lastname, String name, String patronymic, Sex sex, Group group, long phone) {
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.group = group;
        this.phone = phone;
    }

    public Student(int id, String lastname, String name, String patronymic, Sex sex, Group group, long phone) {
        Id = id;
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.group = group;
        this.phone = phone;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
