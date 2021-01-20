package serviceImpl;

import dao.PersonDao;
import service.PersonService;


public class PersonServiceImpl implements PersonService {

	private PersonDao personDao; 

	public PersonDao getPersonDao() {
		return personDao;
	}
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	@Override
	public void savePerson() throws Exception {
		this.personDao.savePerson();
		throw new RuntimeException("service save Exception");
	}
}
