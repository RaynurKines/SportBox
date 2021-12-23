package com.example.sportbox.dao;

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
        session.update(student);
        tx1.commit();
        session.close();
    }

    public List<Student> findAll(){
        List<Student> students = (List<Student>)  HibernateUtil.getSessionFactory().openSession().createQuery("From Student").list();
        return students;
    }

    public Result findResultById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Result.class, id);
    }
}
