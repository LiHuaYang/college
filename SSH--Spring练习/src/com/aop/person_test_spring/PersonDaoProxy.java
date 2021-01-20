package com.aop.person_test_spring;

public class PersonDaoProxy implements PersonDao {

	private PersonDao personDao = null;
	private LoggingManager logger = null;
	
	public PersonDaoProxy(PersonDao dao, LoggingManager logger) {
		this.personDao = dao;
		this.logger = logger;
	}
	
	@Override
	public void savePerson() {
		this.logger.startLog();
		this.personDao.savePerson();
		this.logger.endLog();
	}

	@Override
	public void deletePerson() {
		this.logger.startLog();
		this.personDao.deletePerson();
		this.logger.endLog();
	}

	@Override
	public void updatePerson() {
		this.logger.startLog();
		this.personDao.updatePerson();
		this.logger.endLog();		
	}
	
	
}
