package com.aop.salary_test_spring;

public class SalaryManagerImpl implements SalaryManager {

	@Override
	public void showSalary() {
		System.out.println("查看工资");
	}
}
