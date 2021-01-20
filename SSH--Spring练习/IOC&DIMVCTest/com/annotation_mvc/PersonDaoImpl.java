package com.annotation_mvc;

import org.springframework.stereotype.Component;

@Component("personDaoImpl_annotation")
public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson() {
		System.out.println("PersonDaoImpl save person");
	}

}
