package com.hedgo.dbtests.dao.impl;

import com.hedgo.dbtests.dao.UserDAO;
import com.hedgo.dbtests.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        //session.persist(p);
        session.save(p);
        tx.commit();
        session.close();
    }

    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();
        return userList;
    }

   /* public List<User> getByUsername() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from User as u where u.username= ? ").list();
        session.close();
        return userList;


        createQuery("from gcv.metier.User as u where u.username= ?")
    }
*/




}
