package com.aop.salary_test_spring;

import java.lang.reflect.Proxy;

public class SalaryClientTest {

	public static void main(String[] args) {
		 Logger log = new Logger();
		 Privilege privilege = new Privilege();
		 privilege.setAccess("admin1");
		 Security security = new Security();
		 Object target = new SalaryManagerImpl();
		 SalaryInterceptor interceptor = new SalaryInterceptor(log, privilege, security, target);
		 
		 SalaryManager manager = (SalaryManager)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);
		 manager.showSalary();
	}

}
