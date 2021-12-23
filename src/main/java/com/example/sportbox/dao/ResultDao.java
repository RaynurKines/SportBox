package com.example.sportbox.dao;

import com.example.sportbox.model.Result;
import com.example.sportbox.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResultDao {

    public Result findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Result.class, id);
    }

    public void update(Result result){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(result);
        tx1.commit();
        session.close();
    }

    public void delete(Result result){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(result);
        tx1.commit();
        session.close();
    }

    public void save(Result result){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(result);
        tx1.commit();
        session.close();
    }

    public List<Result> findAll(){
        List<Result> results = (List<Result>)  HibernateUtil.getSessionFactory().openSession().createQuery("From Result").list();
        return results;
    }
}
