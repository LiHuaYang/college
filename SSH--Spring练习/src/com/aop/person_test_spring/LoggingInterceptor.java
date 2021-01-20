package com.aop.person_test_spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInterceptor implements InvocationHandler {
	private PersonDao personDao = null; // Ä¿±êÀà
	private LoggingManager logger = null;
	
	public LoggingInterceptor(PersonDao dao, LoggingManager logger) {
		this.personDao = dao;
		this.logger = logger;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		this.logger.startLog();
		method.invoke(this.personDao, args);
		this.logger.endLog();
		
		return null;
	}
	
	
}
