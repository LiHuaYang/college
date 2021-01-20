package com.Bll.ActivityHandle;

import java.util.ArrayList;
import java.util.List;

import com.Dao.DaoFrame;
import com.Entity.Participants;
//活动参与人员处理类
public class ActivityPersonnelHandle {
	private List<Participants> enterHandles;//报名人员列表
	private List<Participants> participantsHandles;//确定参与人员列表
	private boolean enterType;
	private DaoFrame daoFrame=new DaoFrame();
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午01:44:16
	 *函数名：
	 *功能：从数据库中获取参加活动人员
	 *参数：
	 *返回值：
	 */
	public ActivityPersonnelHandle(int activityId){
		enterHandles=new ArrayList<Participants>();
		participantsHandles=daoFrame.QueryParticipantsByActivityId(activityId);
		if (participantsHandles.size()==0) {
			enterType=true;
		}
		else {
			enterType=false;
		}
	}
	
	public ActivityPersonnelHandle(){
		enterHandles=new ArrayList<Participants>();
		participantsHandles=new ArrayList<Participants>();
		enterType=true;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午02:22:23
	 *函数名：enterHandles
	 *功能：获取报名人员列表
	 *参数：@return 
	 *返回值：List<Participants>
	 */
	public List<Participants> getEnterHandles(){
		return enterHandles;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午02:23:05
	 *函数名：participantsHandles
	 *功能：获取参与人员列表
	 *参数：@return 
	 *返回值：List<Participants>
	 */
	public List<Participants> getParticipantsHandles(){
		return participantsHandles;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午09:25:58
	 *函数名：enterActivity
	 *功能：报名参加活动
	 *参数：@param participants
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean enterActivity(Participants participants) {
		
		boolean result=true;
		for (int i = 0; i < enterHandles.size(); i++) {
			if (enterHandles.get(i).getParticipantsId()==participants.getParticipantsId()) {
				result=false;
				break;
			}
		}
		if (result) {
			enterHandles.add(participants);
		}
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午09:57:39
	 *函数名：examineParticipants
	 *功能：审核人员
	 *参数：@param participants
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean examineParticipants(List<Participants> participants) {
		boolean result=participantsHandles.addAll(participants);
		participantsHandles.removeAll(participants);
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午10:08:17
	 *函数名：SaveParticipants
	 *功能：提交人员审核
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SaveParticipants(int activityId) {
		this.enterType=false;
		boolean result=daoFrame.SaveParticipants(participantsHandles);
		if (result) {
			this.participantsHandles=daoFrame.QueryParticipantsByActivityId(activityId);
		}
		enterHandles.clear();
		return result;
	}

	public boolean getEnterType() {
		return enterType;
	}


	
	
	
	
	
}
