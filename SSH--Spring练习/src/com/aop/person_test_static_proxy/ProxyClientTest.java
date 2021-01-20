package com.aop.person_test_static_proxy;

public class ProxyClientTest {

	public static void main(String[] args) {
		
		PersonDao personDao = new PersonDaoimpl();
		LoggingManager logger = new LoggingManager();
		PersonDaoProxy personProxy = new PersonDaoProxy(personDao, logger);

		personProxy.savePerson();
		personProxy.deletePerson();
		personProxy.updatePerson();
	}
}
