package com.example.sportbox.dao;

import com.example.sportbox.model.Competition;
import com.example.sportbox.model.Event;
import com.example.sportbox.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompetitionDao {

    public Competition findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Competition.class, id);
    }

    public void update(Competition competition){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(competition);
        tx1.commit();
        session.close();
    }

    public void delete(Competition competition){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(competition);
        tx1.commit();
        session.close();
    }

    public void save(Competition competition){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(competition);
        tx1.commit();
        session.close();
    }

    public List<Competition> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Competition> competitions = session.createQuery("From Competition").list();
        tx1.commit();
        session.close();
        return competitions;
    }

    public List<Competition> findCompetitionsByEventId(Event event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Competition> competitions = session.createSQLQuery("SELECT name FROM Competitions WHERE event_id = " + event.getEventId()).list();
        tx1.commit();
        session.close();
        return competitions;
    }
}
