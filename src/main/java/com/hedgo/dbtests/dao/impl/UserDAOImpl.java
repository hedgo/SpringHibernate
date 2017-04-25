package com.hedgo.dbtests.dao.impl;

import com.hedgo.dbtests.dao.UserDAO;
import com.hedgo.dbtests.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    Session session;
    @Autowired
    private SessionFactory sessionFactory;

    public void initSession() {
        session = sessionFactory.openSession();
    }

    public void closeSession() {
        session.close();
    }

    public void save(User user) {
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
    }

    public List<User> listAll() {
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    public User read(int id) {
        Query query = session.createQuery("from User where id= :id");
        query.setLong("id", id);
        return (User) query.uniqueResult();
    }

    public void update(int id, User user) {
        Query query = session.createQuery("update User set name= :name where id= :id");
        query.setParameter("name", user.getName());
        query.setLong("id", id);
        int result = query.executeUpdate();
        System.out.println("!!!!result=" + result);
    }

    public void delete(int id) {
        Query query = session.createQuery("delete from User where id= :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    public Long countAll() {
        Query query = session.createQuery("select count(*) from User");
        return (Long) query.uniqueResult();
    }

    //Wiecej przykaldow mozna znalesc na stronie:
    //http://www.journaldev.com/2954/hibernate-query-language-hql-example-tutorial
    //Generalnie nie uzywaj HQL, tylko zwyklych zapytan.. Zobacz jak w ksiazce o springu mozna to zrobic lepiej np. przez Spring Data JPAA

}
