package com.document;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {

	@Test
	public void test1() {
		Document _doc = new Pdf(); // 等号的右边还是具体的类型，是不完全面向对象编程
		DocumentManager manager = new DocumentManager(_doc);
		manager.read();
		manager.write();
	}
	
	@Test
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DocumentManager manager = (DocumentManager)context.getBean("docManager");
		manager.read();
		manager.write();
	}
	
}
