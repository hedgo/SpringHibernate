package com.hedgo.dbtests.dao;

import com.hedgo.dbtests.model.User;
import static org.junit.Assert.*;

public class UserDAOTest {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void testSave() throws Exception {
        System.out.println("testSave");

        for (int i = 0; i < 100; i++) {
            userDAO.save(new User("Name" + i, "Polska", 10 + i));
        }

        //userDAO.listAllNative().forEach((item)-> System.out.println(item));
        //userDAO.listAllNative().forEach(System.out::println);
        userDAO.listAllNative().stream()
                .filter(s->s.getAge()>1)
                .forEach(System.out::println);

        assertTrue(userDAO.listAllNative().size() == 100);
    }

    public void testRead() throws Exception {

    }

    public void testUpdate() throws Exception {

    }

    public void testDelete() throws Exception {

    }

    public void testListAll() throws Exception {

    }

    public void testCountAll() throws Exception {

    }

    public void testListAllNative() throws Exception {

    }

    public void initSession() throws Exception {
        userDAO.initSession();
        userDAO.deleteAll();
    }

    public void closeSession() throws Exception {
        userDAO.closeSession();
    }
}