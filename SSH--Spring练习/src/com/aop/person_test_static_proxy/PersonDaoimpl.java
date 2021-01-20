package com.aop.person_test_static_proxy;

public class PersonDaoimpl implements PersonDao {

	@Override
	public void savePerson() {
		System.out.println("save person");
	}

	@Override
	public void deletePerson() {
		System.out.println("delete person");
	}

	@Override
	public void updatePerson() {
		System.out.println("update person");
	}

}
