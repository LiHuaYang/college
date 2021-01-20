package com.Bll.InformationHandle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.Tool.MyConstant.INFORMATIONCONTENT;

public class InformationsModel {
	List<Information> informations=new ArrayList<Information>();
	private final ReadWriteLock lock=new ReentrantReadWriteLock();
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午08:38:28
	 *函数名：QueryUserInformations
	 *功能：用户查询自己的消息
	 *参数：@param userId
	 *参数：@return 
	 *返回值：List<Information>
	 */
	public List<Information> QueryUserInformations(int userId){
		lock.readLock().lock();
		try {
			List<Information> userInformations=new ArrayList<Information>();
			for (int i = informations.size()-1; i >=0 ; i++) {
				if (informations.get(i).getReceiverId()==userId) {
					userInformations.add(informations.get(i));
				}
			}
			return informations;
		} 
		finally{
			lock.readLock().unlock();
		
		}
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17上午10:23:50
	 *函数名：DeleteOldInformations
	 *功能：定时删除
	 *参数：@return
	 *参数：@throws ParseException 
	 *返回值：boolean
	 */
	public boolean DeleteOldInformations() throws ParseException{
		lock.writeLock().lock();
		try {
			int max=0;//记录删除标记
			for (int i = 0; i < informations.size(); i++) {
				String InformationSendDate=informations.get(i).getSendDate();
				Date nowdate=new Date();
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date SendDate=simpleDateFormat.parse(InformationSendDate);
			
				if (getIntervalDays(SendDate, nowdate)<7) {
					max=i;
					break;
				}
			}
			informations.subList(0, max).clear();
			return true;
		}
		finally{
			lock.writeLock().unlock();
		}
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17上午10:18:09
	 *函数名：getIntervalDays
	 *功能：求2时间之间的天数
	 *参数：@param startday
	 *参数：@param endday
	 *参数：@return 
	 *返回值：int
	 */
	private int getIntervalDays(Date startday,Date endday){        
        if(startday.after(endday)){
            Date cal=startday;
            startday=endday;
            endday=cal;
        }        
        long sl=startday.getTime();
        long el=endday.getTime();       
        long ei=el-sl;           
        return (int)(ei/(1000*60*60*24));
    }
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午06:43:26
	 *函数名：SendJoinPartSuccess
	 *功能：加入部门成功
	 *参数：@param ReceiverId
	 *参数：@param departmentName
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendJoinPartSuccess(int ReceiverId,String departmentName){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.JOINPARTSUCCESS.replace("?", departmentName);
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
	}
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午06:43:26
	 *函数名：SendJoinPartFail
	 *功能：加入部门失败
	 *参数：@param ReceiverId
	 *参数：@param departmentName
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendJoinPartFail(int ReceiverId,String departmentName){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.JOINPARTFAIL.replace("?", departmentName);
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午06:50:24
	 *函数名：SendMakeFriendSuccess
	 *功能：添加好友成功
	 *参数：@param ReceiverId
	 *参数：@param username
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendMakeFriendSuccess(int ReceiverId,String username){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.FRIENDSUCCESS.replace("?", username);
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午06:50:24
	 *函数名：SendMakeFriendFail
	 *功能：添加好友失败
	 *参数：@param ReceiverId
	 *参数：@param username
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendMakeFriendFail(int ReceiverId,String username){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.FRIENDFAIL.replace("?", username);
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午07:05:08
	 *函数名：SendSelectActivityPlanCreator
	 *功能：选择活动任务方案制定人，发送消息
	 *参数：@param ReceiverId
	 *参数：@param origanzationName
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendSelectActivityPlanCreator(int ReceiverId,String origanzationName,int activityId){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.SELECTACTIVITYPLANCREATOR.replace("?", origanzationName).replace("@", activityId+"");
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午07:07:04
	 *函数名：SelectActivityPlotter
	 *功能：选择活动策划人，发送消息
	 *参数：@param ReceiverId
	 *参数：@param origanzationName
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendSelectActivityPlotter(int ReceiverId,String origanzationName,int activityId){
		lock.writeLock().lock();
		try {

			String InformationContent=INFORMATIONCONTENT.SELECTACTIVITYPLOTTER.replace("?", origanzationName).replace("@", activityId+"");
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午07:09:49
	 *函数名：CreateScheme
	 *功能：创建活动策划后发消息给主席
	 *参数：@param ReceiverId
	 *参数：@param origanzationName
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendCreateScheme(int ReceiverId,String origanzationName,int activityId){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.CREATESCHEME.replace("?", origanzationName).replace("@", activityId+"");
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
	
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午07:22:14
	 *函数名：SendSchemeSuccess
	 *功能：审核策划通过
	 *参数：@param ReceiverId
	 *参数：@param origanzationName
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendSchemeSuccess(int ReceiverId,String origanzationName,int activityId){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.SCHEMESUCCESS.replace("?", origanzationName).replace("@", activityId+"");
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午07:23:45
	 *函数名：SendSchemeFail
	 *功能：策划不通过
	 *参数：@param ReceiverId
	 *参数：@param origanzationName
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendSchemeFail(int ReceiverId,String origanzationName,int activityId){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.SCHEMEFAIL.replace("?", origanzationName).replace("@", activityId+"");
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午07:26:08
	 *函数名：SendCreatePlan
	 *功能：创建任务方案后发送消息给主席
	 *参数：@param ReceiverId
	 *参数：@param origanzationName
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendCreatePlan(int ReceiverId,String origanzationName,int activityId){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.CREATEPLAN.replace("?", origanzationName).replace("@", activityId+"");
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
	
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午07:31:20
	 *函数名：SendPlanSuccess
	 *功能：任务方案通过
	 *参数：@param ReceiverId
	 *参数：@param origanzationName
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendPlanSuccess(int ReceiverId,String origanzationName,int activityId){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.PLANSUCCESS.replace("?", origanzationName).replace("@", activityId+"");
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午07:31:37
	 *函数名：SendPlanFail
	 *功能：任务方案不通过
	 *参数：@param ReceiverId
	 *参数：@param origanzationName
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendPlanFail(int ReceiverId,String origanzationName,int activityId){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.PLANEFAIL.replace("?", origanzationName).replace("@", activityId+"");
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午08:08:45
	 *函数名：SendPartActivitySuccess
	 *功能：审核通过加入活动
	 *参数：@param ReceiverId
	 *参数：@param activityName
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendPartActivitySuccess(int ReceiverId,String activityName){
		lock.writeLock().lock();
		try {

			String InformationContent=INFORMATIONCONTENT.PARTCATIVITYSUCCESS.replace("?", activityName);
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午08:16:03
	 *函数名：SendActivityMessage
	 *功能：发送活动消息
	 *参数：@param ReceiverId
	 *参数：@param message
	 *参数：@param activityName
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendActivityMessage(int ReceiverId,String message,String activityName){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.ACTIVITYMESSAGE.replace("?", message).replace("@", activityName);
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午08:19:24
	 *函数名：SendActivityResult
	 *功能：提醒发布活动总结
	 *参数：@param ReceiverId
	 *参数：@param activityName
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendActivityResult(int ReceiverId,String activityName){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.ACTIVITYRESULT.replace("?", activityName);
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午08:21:24
	 *函数名：SendApplyCorporation
	 *功能：申请创建社团
	 *参数：@param ReceiverId
	 *参数：@param origanzationName
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendApplyCorporation(int ReceiverId,String origanzationName){
		lock.writeLock().lock();
		try {

			String InformationContent=INFORMATIONCONTENT.APPLYCORPORATION.replace("?", origanzationName);
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-16下午08:23:33
	 *函数名：SendApplyCorporationSuccess
	 *功能：申请创建社团成功
	 *参数：@param ReceiverId
	 *参数：@param corporationName
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendApplyCorporationSuccess(int ReceiverId,String corporationName){
		lock.writeLock().lock();
		try {
			String InformationContent=INFORMATIONCONTENT.APPLYCORPORATIONSUCCESS.replace("?", corporationName);
			Information information=new Information(ReceiverId, InformationContent);
			boolean result=false;
			try {
				informations.add(information);
				result=true;
			} catch (Exception e) {
				e.printStackTrace();		}
			return result;
		}
		finally{
			lock.writeLock().unlock();
		}
		
		
		
		
	}
}
