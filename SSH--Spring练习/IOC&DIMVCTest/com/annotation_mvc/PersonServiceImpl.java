package com.annotation_mvc;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


@Component("personServiceImpl_annotation")
public class PersonServiceImpl implements PersonService {
	
	@Resource(name="personDaoImpl_annotation")
	private PersonDao personDao ;
	
	@Override
	public void savePerson() {
		this.personDao.savePerson();
	}
}
