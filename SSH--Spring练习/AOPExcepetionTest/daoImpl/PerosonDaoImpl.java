package daoImpl;

import dao.PersonDao;

public class PerosonDaoImpl implements PersonDao {

	@Override
	public void savePerson() throws Exception{
		System.out.println("dao save person");
		
		 throw new RuntimeException("dao save Exception");
	}

}