package com.spring_jdbc_transaction;

import java.util.List;

public interface PersonDao {

	void savePerson();

	List<Person> getPersons();

}