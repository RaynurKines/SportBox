package com.example.sportbox.service;

import com.example.sportbox.dao.StudentDao;
import com.example.sportbox.model.Result;
import com.example.sportbox.model.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public StudentService() {
    }

    public Student findStudent(int id) {
        return studentDao.findById(id);
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    public Result findResultById(int id) {
        return studentDao.findResultById(id);
    }
}
