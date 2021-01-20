package com.spring_jdbc_transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class test {
	
	@Test
	public void test1() {
		String configLocation = "applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

		PersonDao dao = (PersonDao)context.getBean("person_dao");
		System.out.println(dao.getPersons());
	}
	@Test
	public void test2() {
		String configLocation = "applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		PersonService ser = (PersonService)context.getBean("person_service");
		System.out.println(ser.getPersonList());
	}
	@Test
	public void test3() {
//		String configLocation = "applicationContext.xml";
//		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
//		int i = 0;
//		String name = "";
//		System.out.println(context.getClass().getName());
//		System.out.println(context.getClass().getPackage());
//		System.out.println(name.getClass().getName());
		
		System.out.println(DataSourceTransactionManager.class.getName());
	}
	@Test
	public void test4() {
		String configLocation = "applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		PersonService service = (PersonService)context.getBean("person_service");
		service.savePerson(null);
	}
	
}
