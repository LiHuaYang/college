package com.Bll.ActivityHandle;

import java.util.ArrayList;
import java.util.List;

import com.Dao.DaoFrame;
import com.Entity.Activestage;
//����洦����
public class ActivityBulletinHandle {
	private List<Activestage> activestageHandles;//��׶�
	private DaoFrame daoFrame=new DaoFrame();
	
	public ActivityBulletinHandle(){
		activestageHandles=new ArrayList<Activestage>();
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����01:26:29
	 *��������
	 *���ܣ�ͨ���Id��ѯ�����л�׶δ�ŵ�����
	 *������
	 *����ֵ��
	 */
	public ActivityBulletinHandle(int activityId){
		activestageHandles=daoFrame.QueryActivestageByActivityId(activityId);
	}
	
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:16:24
	 *��������createActivestage
	 *���ܣ�������׶�
	 *������@param activestage
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean createActivestage(Activestage activestage) {
		activestageHandles.add(activestage);
		boolean result=daoFrame.CreateActivestage(activestage);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����02:20:55
	 *��������getActivestage
	 *���ܣ���ȡ��׶�
	 *������@return 
	 *����ֵ��List<Activestage>
	 */
	public List<Activestage> getActivestage() {
		return activestageHandles;
	}
	
	
}
