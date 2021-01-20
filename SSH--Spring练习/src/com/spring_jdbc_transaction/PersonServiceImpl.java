package com.spring_jdbc_transaction;

import java.util.List;

public class PersonServiceImpl implements PersonService {
	
	private PersonDao dao ;
	
	PersonServiceImpl(PersonDao _dao) {
		this.dao = _dao;
	}
	
	
	/* (non-Javadoc)
	 * @see com.spring_jdbc_transaction.PersonService#getPersonList()
	 */
	public List<Person> getPersonList() {
		return this.dao.getPersons();
	}
	
	/* (non-Javadoc)
	 * @see com.spring_jdbc_transaction.PersonService#savePerson(com.spring_jdbc_transaction.Person)
	 */
	public void savePerson(Person person) {
		this.dao.savePerson();
	}
}
