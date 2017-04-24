package com.hedgo.dbtests.main;

import java.util.List;

import com.hedgo.dbtests.dao.UserDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hedgo.dbtests.model.Person;

public class SpringHibernateMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");

        UserDAO userDAO = context.getBean(UserDAO.class);

        userDAO.save(new Person("Polska", "Andrzej1"));
        userDAO.save(new Person("Polska", "Andrzej2"));
        userDAO.save(new Person("Polska", "Andrzej3"));

        List<Person> list = userDAO.list();

        for (Person p : list) {
            System.out.println("Person List::" + p);
        }

        context.close();

    }

}
