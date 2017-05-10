package com.hedgo.dbtests.dao.impl;

import com.hedgo.dbtests.dao.UserDAOTest;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring4.xml")
public class UserDAOHibernateImplTest extends UserDAOTest {

    @Autowired
    private UserDAOHibernateImpl userDAOHibernate;

    @Before
    public void setUp() throws Exception {
        System.out.println("userDAOHibernate setUp");
        super.setUserDAO(userDAOHibernate);
        super.initSession();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("userDAOHibernate tearDown");
        super.closeSession();
    }

    @Test
    public void testSave() throws Exception {
        super.testSave();
    }

    @Test
    public void testListAll() throws Exception {

    }

}