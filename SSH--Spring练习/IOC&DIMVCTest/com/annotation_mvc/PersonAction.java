package com.annotation_mvc;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("personAction_annotation")
public class PersonAction {
	
	@Resource(name="personServiceImpl_annotation")
	private PersonService personService;
	
	
	public void savePerson() {
		this.personService.savePerson();
	}
}
