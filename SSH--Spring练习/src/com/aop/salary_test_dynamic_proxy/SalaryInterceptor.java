package com.aop.salary_test_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class SalaryInterceptor implements InvocationHandler {

	private Logger log;
	private Privilege privilege;
	private Security security;
	private Object target;
	
	
	public SalaryInterceptor(Logger log, Privilege privilege, Security security, Object target) {
		this.log = log;
		this.privilege = privilege;
		this.security = security;
		this.target = target;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.security.security();
		this.log.startLog();
		
		if (this.privilege.getAccess().equals("admin")) {
			method.invoke(target, args);
		} else {
			System.out.println("没有权限查看");
		}
		
		return null;
	}

}
