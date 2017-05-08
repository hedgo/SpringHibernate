package com.hedgo.dbtests.dao;

import com.hedgo.dbtests.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.Context;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring4.xml")
public class UserDAOTest {

    @Autowired
    @Qualifier("JDBCTemplate")
    UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        userDAO.initSession();
    }

    @After
    public void tearDown() throws Exception {
        userDAO.closeSession();
    }

    @Test
    public void testSave() throws Exception {
        System.out.println("testSave");

        for (int i = 0; i < 100; i++) {
            userDAO.save(new User("Name"+i, "Polska",10+i));
        }

        //userDAO.listAllNative().forEach((item)-> System.out.println(item));
        //userDAO.listAllNative().forEach(System.out::println);
        userDAO.listAllNative().stream()
                .filter(s->s.getAge()>1)
                .forEach(System.out::println);


        assertTrue(userDAO.listAllNative().size() == 103);
    }

    @Test
    public void testRead() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testListAll() throws Exception {

    }

    @Test
    public void testCountAll() throws Exception {

    }

    @Test
    public void testListAllNative() throws Exception {

    }

    @Test
    public void testInitSession() throws Exception {

    }

    @Test
    public void testCloseSession() throws Exception {

    }
}