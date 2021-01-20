package com.aop.person_test_dynamic_proxy;

import java.lang.reflect.Proxy;

public class ProxyClientTest {

	public static void main(String[] args) {
		PersonDao personDao = new PersonDaoimpl();
		LoggingManager logger = new LoggingManager();
		LoggingInterceptor logi = new LoggingInterceptor(personDao, logger);
		
		/**
		 * 1. Ŀ����ʵ�ֵ����н��
		 * 2. Ŀ������������
		 * 3. ������
		 */
		PersonDao dao = (PersonDao)Proxy.newProxyInstance(personDao.getClass().getClassLoader(), personDao.getClass().getInterfaces(), logi);
		
		dao.savePerson();
		dao.deletePerson();
		dao.updatePerson();		
	}
}
