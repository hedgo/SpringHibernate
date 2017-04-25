package com.hedgo.dbtests.main;

import java.util.List;
import com.hedgo.dbtests.dao.UserDAO;
import com.hedgo.dbtests.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
        UserDAO userDAO = context.getBean(UserDAO.class);
        fillUsersToDB(userDAO);
        showAllUsers(userDAO);
        context.close();
    }

    private static void fillUsersToDB(UserDAO userDAO) {
        userDAO.save(new User("Polska", "Andrzej2"));
        userDAO.save(new User("Polska", "Andrzej3"));
        userDAO.save(new User("Polska", "Andrzej1"));
    }

    private static void showAllUsers(UserDAO userDAO) {
        List<User> list = userDAO.list();
        for (User p : list) {
            System.out.println("User List::" + p);
        }
    }

}
