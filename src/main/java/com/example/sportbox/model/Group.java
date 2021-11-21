package com.example.sportbox.model;

import com.example.sportbox.model.enums.Faculty;

import java.sql.Date;
import java.util.List;

public class Group {

    private int groupId;
    private String name;
    private Faculty faculty;
    private Date dateStart;
    private List<Student> students;

    public Group() {
    }

    public Group(int groupId, String name, Faculty faculty, Date dateStart) {
        this.groupId = groupId;
        this.name = name;
        this.faculty = faculty;
        this.dateStart = dateStart;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
}
