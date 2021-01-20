package com.Bll.RegistrationHandle;

import java.util.ArrayList;
import java.util.List;

import com.Dao.DaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.Grade;

public class RegistrationModel {
	private  List<Registration> registrations=new ArrayList<Registration>();
	private IDaoFrame daoFrame=new DaoFrame();
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午03:54:44
	 *函数名：createRegistration
	 *功能：提交加入部门或社团申请
	 *参数：@param userId
	 *参数：@param userName
	 *参数：@param belongType
	 *参数：@param belongId
	 *参数：@param registrationContent
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean createRegistration(int userId,String userName, int belongType,int belongId,String registrationContent){
		boolean result=true;
		for (int i = 0; i < registrations.size(); i++) {
			if (userId==registrations.get(i).getUserId()&&belongType==registrations.get(i).getBelongType()&&belongId==registrations.get(i).getBelongId()) {
				result=false;
				break;
			}
		}
		if (result!=false) {
			Registration registration=new Registration(userId, userName, belongType, belongId, registrationContent);
			result=registrations.add(registration);
			System.out.println("申请条目"+registrations.size());
		}
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午03:55:10
	 *函数名：QueryRegistrationByBelong
	 *功能：根据所属查看报名人员
	 *参数：@param belongType
	 *参数：@param belongId
	 *参数：@return 
	 *返回值：List<Registration>
	 */
	public List<Registration> QueryRegistrationByBelong(int belongType,int belongId){
		List<Registration> newList=new ArrayList<Registration>();
		for (int i = 0; i < registrations.size(); i++) {
			if (registrations.get(i).getBelongId()==belongId&&registrations.get(i).getBelongType()==belongType) {
				newList.add(registrations.get(i));
			}
		}
		return newList;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午04:16:39
	 *函数名：QueryRegistrationByUser
	 *功能：根据用户ID查找他报名了哪些部门组织
	 *参数：@param userId
	 *参数：@return 
	 *返回值：List<Registration>
	 */
	public List<Registration> QueryRegistrationByUser(int userId){
		List<Registration> newList=new ArrayList<Registration>();
		for (int i = 0; i < registrations.size(); i++) {
			if (registrations.get(i).getUserId()==userId) {
				newList.add(registrations.get(i));
			}
		}
		return newList;
	}
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午04:11:29
	 *函数名：SubmitRegistration
	 *功能：审核通过加入部门组织
	 *参数：@param belongType
	 *参数：@param belongId
	 *参数：@param userId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SubmitRegistration(int belongType,int belongId,int userId){
		Grade grade=new Grade(userId, belongType, belongId);
		boolean result=daoFrame.CreateGrade(grade);
		for (int i = 0; i < registrations.size(); i++) {
			if (registrations.get(i).getBelongId()==belongId&&registrations.get(i).getBelongType()==belongType&&userId==registrations.get(i).getUserId()) {
				registrations.remove(i);
			}
		}
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午04:14:37
	 *函数名：RefuseRegistration
	 *功能：拒绝加入
	 *参数：@param belongType
	 *参数：@param belongId
	 *参数：@param userId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean RefuseRegistration(int belongType,int belongId,int userId){
		for (int i = 0; i < registrations.size(); i++) {
			if (registrations.get(i).getBelongId()==belongId&&registrations.get(i).getBelongType()==belongType&&userId==registrations.get(i).getUserId()) {
				registrations.remove(i);
			}
		}
		return true;
	}
}
