package com.example.sportbox.dao;

import com.example.sportbox.model.Group;
import com.example.sportbox.model.Result;
import com.example.sportbox.model.Student;
import com.example.sportbox.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    public Student findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Student.class, id);
    }

    public void update(Student student){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }

    public void delete(Student student){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }

    public void save(Student student){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    public List<Student> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Student> students = session.createQuery("From Student").list();
        tx1.commit();
        session.close();
        return students;
    }

    public Result findResultById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Result.class, id);
    }
}
