package com.aop.person_test_dynamic_proxy;

import java.lang.reflect.Proxy;

public class ProxyClientTest {

	public static void main(String[] args) {
		PersonDao personDao = new PersonDaoimpl();
		LoggingManager logger = new LoggingManager();
		LoggingInterceptor logi = new LoggingInterceptor(personDao, logger);
		
		/**
		 * 1. 目标类实现的所有借口
		 * 2. 目标类的类加载器
		 * 3. 拦截器
		 */
		PersonDao dao = (PersonDao)Proxy.newProxyInstance(personDao.getClass().getClassLoader(), personDao.getClass().getInterfaces(), logi);
		
		dao.savePerson();
		dao.deletePerson();
		dao.updatePerson();		
	}
}
