package com.annotation_mvc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {
	
	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonAction action = (PersonAction) context.getBean("personAction_annotation");
		action.savePerson();
	}
}
