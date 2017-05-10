package com.hedgo.dbtests;

import com.hedgo.dbtests.dao.impl.UserDAOHibernateImplTest;
import com.hedgo.dbtests.dao.impl.UserDAOJDBCTemplateImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UserDAOHibernateImplTest.class, UserDAOJDBCTemplateImplTest.class})
public class TestAll {
        }
