package com.factory;

import com.nbut.bll.ProgramManage;
import com.nbut.bll.UserManage;
import com.nbut.bll.impl.ProgramManageImpl;
import com.nbut.bll.impl.UserManageImpl;

public class BllFactory {

	private BllFactory () {}
	
	private static BllFactory bll = new BllFactory();
	
	// 
	public static BllFactory getInstance () {
		return bll;
	}
	
	/**
	 * 函数名称：getProgramManage
	 * 功能描述：返回问题业务控制对象
	 * 参数说明：
	 * 返回值：ProgramManage
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月27日上午8:30:26
	 */
	public ProgramManage getProgramManage () {
		// 
		return ProgramManageImpl.getInstance();
	}
	/**
	 * 函数名称：getUserManage
	 * 功能描述：返回用户业务控制对象
	 * 参数说明：
	 * 返回值：UserManage
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月27日上午8:30:30
	 */
	public UserManage getUserManage () {
		// 
		return UserManageImpl.getInstance();
	}
}
