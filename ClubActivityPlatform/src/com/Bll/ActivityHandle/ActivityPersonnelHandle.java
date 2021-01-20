package com.Bll.ActivityHandle;

import java.util.ArrayList;
import java.util.List;

import com.Dao.DaoFrame;
import com.Entity.Participants;
//�������Ա������
public class ActivityPersonnelHandle {
	private List<Participants> enterHandles;//������Ա�б�
	private List<Participants> participantsHandles;//ȷ��������Ա�б�
	private boolean enterType;
	private DaoFrame daoFrame=new DaoFrame();
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����01:44:16
	 *��������
	 *���ܣ������ݿ��л�ȡ�μӻ��Ա
	 *������
	 *����ֵ��
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����02:22:23
	 *��������enterHandles
	 *���ܣ���ȡ������Ա�б�
	 *������@return 
	 *����ֵ��List<Participants>
	 */
	public List<Participants> getEnterHandles(){
		return enterHandles;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����02:23:05
	 *��������participantsHandles
	 *���ܣ���ȡ������Ա�б�
	 *������@return 
	 *����ֵ��List<Participants>
	 */
	public List<Participants> getParticipantsHandles(){
		return participantsHandles;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:25:58
	 *��������enterActivity
	 *���ܣ������μӻ
	 *������@param participants
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:57:39
	 *��������examineParticipants
	 *���ܣ������Ա
	 *������@param participants
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean examineParticipants(List<Participants> participants) {
		boolean result=participantsHandles.addAll(participants);
		participantsHandles.removeAll(participants);
		return result;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:08:17
	 *��������SaveParticipants
	 *���ܣ��ύ��Ա���
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
