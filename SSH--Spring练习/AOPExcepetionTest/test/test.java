package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import action.PersonAction;

public class test {

	
	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonAction action = (PersonAction) context.getBean("person_action");
		
		try {
			action.savePerson();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
