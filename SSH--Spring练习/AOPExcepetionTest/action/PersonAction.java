package action;

import service.PersonService;

public class PersonAction {

	private PersonService service ;

	public PersonService getService() {
		return service;
	}

	public void setService(PersonService service) {
		this.service = service;
	}

	
	public void savePerson() throws Exception {
		this.service.savePerson();
	}
}
