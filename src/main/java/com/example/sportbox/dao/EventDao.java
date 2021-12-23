package com.example.sportbox.dao;

import com.example.sportbox.model.*;
import com.example.sportbox.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EventDao {

    public Event findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Event.class, id);
    }

    public void update(Event event){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(event);
        tx1.commit();
        session.close();
    }

    public void delete(Event event){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(event);
        tx1.commit();
        session.close();
    }

    public void save(Event event){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(event);
        tx1.commit();
        session.close();
    }

    public List<Event> findAll(){
        List<Event> events = (List<Event>)  HibernateUtil.getSessionFactory().openSession().createQuery("From Event").list();
        return events;
    }

    public Competition findCompetitionById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Competition.class, id);
    }

    public List<Competition> findCompetitionsByEventId() {
        List<Competition> competitions = (List<Competition>)  HibernateUtil.getSessionFactory().openSession().createQuery("From Competitions").list();
        return competitions;
    }
}
