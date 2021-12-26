package com.example.sportbox.dao;

import com.example.sportbox.model.Group;
import com.example.sportbox.model.Result;
import com.example.sportbox.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GroupDao {

    public Group findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Group.class, id);
    }

    public Group findByName(String name) {
        return HibernateUtil.getSessionFactory().openSession().get(Group.class, name);
    }

    public void update(Group group){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(group);
        tx1.commit();
        session.close();
    }

    public void delete(Group group){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(group);
        tx1.commit();
        session.close();
    }

    public void save(Group group){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(group);
        tx1.commit();
        session.close();
    }

    public List<Group> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Group> groups = session.createQuery("From Group").list();
        tx1.commit();
        session.close();
        return groups;
    }


}
