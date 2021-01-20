package com.spring_jdbc_transaction;

import java.util.List;

public interface PersonService {

	List<Person> getPersonList();

	void savePerson(Person person);

}