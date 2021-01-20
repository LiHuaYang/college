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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����08:38:28
	 *��������QueryUserInformations
	 *���ܣ��û���ѯ�Լ�����Ϣ
	 *������@param userId
	 *������@return 
	 *����ֵ��List<Information>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����10:23:50
	 *��������DeleteOldInformations
	 *���ܣ���ʱɾ��
	 *������@return
	 *������@throws ParseException 
	 *����ֵ��boolean
	 */
	public boolean DeleteOldInformations() throws ParseException{
		lock.writeLock().lock();
		try {
			int max=0;//��¼ɾ�����
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����10:18:09
	 *��������getIntervalDays
	 *���ܣ���2ʱ��֮�������
	 *������@param startday
	 *������@param endday
	 *������@return 
	 *����ֵ��int
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����06:43:26
	 *��������SendJoinPartSuccess
	 *���ܣ����벿�ųɹ�
	 *������@param ReceiverId
	 *������@param departmentName
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����06:43:26
	 *��������SendJoinPartFail
	 *���ܣ����벿��ʧ��
	 *������@param ReceiverId
	 *������@param departmentName
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����06:50:24
	 *��������SendMakeFriendSuccess
	 *���ܣ���Ӻ��ѳɹ�
	 *������@param ReceiverId
	 *������@param username
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����06:50:24
	 *��������SendMakeFriendFail
	 *���ܣ���Ӻ���ʧ��
	 *������@param ReceiverId
	 *������@param username
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����07:05:08
	 *��������SendSelectActivityPlanCreator
	 *���ܣ�ѡ�����񷽰��ƶ��ˣ�������Ϣ
	 *������@param ReceiverId
	 *������@param origanzationName
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����07:07:04
	 *��������SelectActivityPlotter
	 *���ܣ�ѡ���߻��ˣ�������Ϣ
	 *������@param ReceiverId
	 *������@param origanzationName
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����07:09:49
	 *��������CreateScheme
	 *���ܣ�������߻�����Ϣ����ϯ
	 *������@param ReceiverId
	 *������@param origanzationName
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����07:22:14
	 *��������SendSchemeSuccess
	 *���ܣ���˲߻�ͨ��
	 *������@param ReceiverId
	 *������@param origanzationName
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����07:23:45
	 *��������SendSchemeFail
	 *���ܣ��߻���ͨ��
	 *������@param ReceiverId
	 *������@param origanzationName
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����07:26:08
	 *��������SendCreatePlan
	 *���ܣ��������񷽰�������Ϣ����ϯ
	 *������@param ReceiverId
	 *������@param origanzationName
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����07:31:20
	 *��������SendPlanSuccess
	 *���ܣ����񷽰�ͨ��
	 *������@param ReceiverId
	 *������@param origanzationName
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����07:31:37
	 *��������SendPlanFail
	 *���ܣ����񷽰���ͨ��
	 *������@param ReceiverId
	 *������@param origanzationName
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����08:08:45
	 *��������SendPartActivitySuccess
	 *���ܣ����ͨ������
	 *������@param ReceiverId
	 *������@param activityName
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����08:16:03
	 *��������SendActivityMessage
	 *���ܣ����ͻ��Ϣ
	 *������@param ReceiverId
	 *������@param message
	 *������@param activityName
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����08:19:24
	 *��������SendActivityResult
	 *���ܣ����ѷ�����ܽ�
	 *������@param ReceiverId
	 *������@param activityName
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����08:21:24
	 *��������SendApplyCorporation
	 *���ܣ����봴������
	 *������@param ReceiverId
	 *������@param origanzationName
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-16����08:23:33
	 *��������SendApplyCorporationSuccess
	 *���ܣ����봴�����ųɹ�
	 *������@param ReceiverId
	 *������@param corporationName
	 *������@return 
	 *����ֵ��boolean
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
