package com.hedgo.dbtests.main;

import java.util.List;
import java.util.logging.Level;

import com.hedgo.dbtests.dao.UserDAO;
import com.hedgo.dbtests.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
        UserDAO userDAO = (UserDAO) context.getBean("Hibernate");
        userDAO.initSession();
        fillUsersToDB(userDAO);
/*        userDAO.update(2, new User("XXX", "XXX", 111));
        showAllUsers(userDAO);
        System.out.println("read===============" + userDAO.read(2));
        userDAO.delete(4);
        userDAO.delete(5);
        userDAO.delete(6);
        System.out.println("countAll=========="+userDAO.countAll());
        User user =userDAO.read(1);
        user.setAge(1000);
        userDAO.save(user);*/


        showAllUsers(userDAO);



        //System.out.println("!!!!" + userDAO.read(2));


        System.out.println("read===============" + userDAO.read(2));

        userDAO.closeSession();
        context.close();
    }

    private static void fillUsersToDB(UserDAO userDAO) {
        userDAO.save(new User("Andrzej2", "Polska",15));
        userDAO.save(new User("Andrzej2", "Polska",15));
        userDAO.save(new User("Andrzej2", "Polska",15));
    //    userDAO.save(new User(-1,"Andrzej2", "Polska",25));
     //   userDAO.save(new User(-1,"Andrzej3", "Polska",35));
    }

    private static void showAllUsers(UserDAO userDAO) {
        List<User> list = userDAO.listAll();
        for (User p : list) {
            System.out.println("User List::" + p);
        }
    }

}
