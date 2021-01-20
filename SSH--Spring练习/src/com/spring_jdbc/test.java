package com.spring_jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class test {
	
	@Test
	public void test1() {
		String configLocation = "applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

		PersoDao dao = (PersoDao)context.getBean("person_dao");
		dao.updatePerson();
		
		JdbcTemplate jdbc ;
	}
	
	@Test
	public void test2() {
		String configLocation = "applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

		PersoDao2 dao = (PersoDao2)context.getBean("person_dao2");
		dao.updatePerson();
	}
	
	@Test
	public void test3() {
		String configLocation = "applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

		PersoDao3 dao = (PersoDao3)context.getBean("person_dao3");
		dao.updatePerson();
	}
	
	@Test
	public void test4() {
		String configLocation = "applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

		PersoDao4 dao = (PersoDao4)context.getBean("person_dao4");
		dao.updatePerson();
	}
	
	@Test
	public void test5() {
		String configLocation = "applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		PersoDao4 dao = (PersoDao4)context.getBean("person_dao4");
		System.out.println(dao.query().getName());
	}
}
