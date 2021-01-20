package com.ningbobw.dao;

// DepartmentDao ddao = DaoFactory.getInstance().createDao("cn.itcast.dao.impl.DepartmentDaoImpl",DepartmentDao.class);

public class DaoFactory {

	private DaoFactory(){}
	
	private static final DaoFactory instance = new DaoFactory();
	
	public static DaoFactory getInstance(){
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T create(String className,Class<T> clazz){
		try{
			return (T)Class.forName(className).newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
