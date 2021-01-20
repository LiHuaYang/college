package cn.usgame.service;

import cn.usgame.service.impl.CompetitionServiceImpl;
import cn.usgame.service.impl.UserServiceImpl;

public class ServiceFactory {

	private ServiceFactory () {}
	
	private static ServiceFactory bll = new ServiceFactory();
	
	// 
	public static ServiceFactory getInstance () {
		return bll;
	}
	
	// 
	public CompetitionService getProgramManage () {
		return CompetitionServiceImpl.getInstance();
	}
	
	public UserService getUserManage () {
		return UserServiceImpl.getInstance();
	}
	
}
