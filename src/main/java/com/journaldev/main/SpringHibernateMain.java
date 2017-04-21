package com.journaldev.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.dao.PersonDAO;
import com.journaldev.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);

		personDAO.save(new Person("Polska","Andrzej1"));
		personDAO.save(new Person("Polska","Andrzej2"));
		personDAO.save(new Person("Polska","Andrzej3"));

		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		
		context.close();
		
	}

}
