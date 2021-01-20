package com.aop.salary_test_dynamic_proxy;

public class SalaryManagerImpl implements SalaryManager {

	@Override
	public void showSalary() {
		System.out.println("查看工资");
	}
}
