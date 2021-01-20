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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����03:54:44
	 *��������createRegistration
	 *���ܣ��ύ���벿�Ż���������
	 *������@param userId
	 *������@param userName
	 *������@param belongType
	 *������@param belongId
	 *������@param registrationContent
	 *������@return 
	 *����ֵ��boolean
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
			System.out.println("������Ŀ"+registrations.size());
		}
		return result;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����03:55:10
	 *��������QueryRegistrationByBelong
	 *���ܣ����������鿴������Ա
	 *������@param belongType
	 *������@param belongId
	 *������@return 
	 *����ֵ��List<Registration>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����04:16:39
	 *��������QueryRegistrationByUser
	 *���ܣ������û�ID��������������Щ������֯
	 *������@param userId
	 *������@return 
	 *����ֵ��List<Registration>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����04:11:29
	 *��������SubmitRegistration
	 *���ܣ����ͨ�����벿����֯
	 *������@param belongType
	 *������@param belongId
	 *������@param userId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����04:14:37
	 *��������RefuseRegistration
	 *���ܣ��ܾ�����
	 *������@param belongType
	 *������@param belongId
	 *������@param userId
	 *������@return 
	 *����ֵ��boolean
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
