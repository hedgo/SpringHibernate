package com.hedgo.dbtests.dao;

import java.util.List;

import com.hedgo.dbtests.model.Person;

public interface UserDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
