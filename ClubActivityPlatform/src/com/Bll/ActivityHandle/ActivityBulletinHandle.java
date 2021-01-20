package com.Bll.ActivityHandle;

import java.util.ArrayList;
import java.util.List;

import com.Dao.DaoFrame;
import com.Entity.Activestage;
//活动布告处理类
public class ActivityBulletinHandle {
	private List<Activestage> activestageHandles;//活动阶段
	private DaoFrame daoFrame=new DaoFrame();
	
	public ActivityBulletinHandle(){
		activestageHandles=new ArrayList<Activestage>();
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午01:26:29
	 *函数名：
	 *功能：通过活动Id查询出所有活动阶段存放到缓存
	 *参数：
	 *返回值：
	 */
	public ActivityBulletinHandle(int activityId){
		activestageHandles=daoFrame.QueryActivestageByActivityId(activityId);
	}
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午09:16:24
	 *函数名：createActivestage
	 *功能：创建活动阶段
	 *参数：@param activestage
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean createActivestage(Activestage activestage) {
		activestageHandles.add(activestage);
		boolean result=daoFrame.CreateActivestage(activestage);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午02:20:55
	 *函数名：getActivestage
	 *功能：获取活动阶段
	 *参数：@return 
	 *返回值：List<Activestage>
	 */
	public List<Activestage> getActivestage() {
		return activestageHandles;
	}
	
	
}
