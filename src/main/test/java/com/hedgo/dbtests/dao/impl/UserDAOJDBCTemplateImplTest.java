package com.hedgo.dbtests.dao.impl;

import com.hedgo.dbtests.dao.UserDAOTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring4.xml")
public class UserDAOJDBCTemplateImplTest extends UserDAOTest {


    @Autowired
    private UserDAOJDBCTemplateImpl userDAOJDBCTemplate;

    @Before
    public void setUp() throws Exception {
        System.out.println("userDAOJDBCTemplate setUp");
        super.setUserDAO(userDAOJDBCTemplate);
        super.initSession();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("userDAOJDBCTemplate tearDown");
        super.closeSession();
    }

    @Test
    public void testSave() throws Exception {
        System.out.println("testSave");
        super.testSave();
    }

    @Test
    public void testListAll() throws Exception {

    }
}