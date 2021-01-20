package com.hibernate_base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;



public class test {


	@Test
	public void test1() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.buildSessionFactory();
	}
	
	@Test
	public void test2() {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session ss = sessionFactory.openSession();
		
		Transaction tran = ss.beginTransaction();
		tran.begin();
		
		Person pp = new Person();
		pp.setName("xiaoming2");
		
		ss.save(pp);
		
		tran.commit();
		ss.close();
		sessionFactory.close();
	}
	@Test
	public void test3() {
		Configuration configuration = new Configuration();
		//'hibernate.dialect' must be set when no Connection available error
		configuration.configure(); 
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		List<Person> persons = session.createQuery("from Person").list();
		
		for (Person person : persons) {
			System.out.println(person.getName());
		}
		session.close();
	}
	
	@Test
	public void test4() {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// 需要默认的构造函数
		Person person = (Person)session.get(Person.class, 1L);
		System.out.println(person.getName());
		session.close();
	}
	
	@Test
	public void test5() {
		Configuration config = new Configuration();
		config.configure();
		Session session = config.buildSessionFactory().openSession();
		
		// 开启事务
		Transaction transation = session.beginTransaction();
		transation.begin();
		// 1. 先从数据库中拿出
//		Person person = (Person)session.get(Person.class, 1L);
		// 2. 删除对象
//		session.delete(person);
	
		// 1. 创建一个新对象
		Person per = new Person();
		// 2. 给标识赋值
		per.setPid(2L);
		session.delete(per);
		
		transation.commit();
		session.close();
	}

	
	
	
	
	
	
	
}
