package com.Bll.ActivityHandle;

import com.Dao.DaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.Activity;
import com.Entity.File;
import com.Tool.MyConstant.FileType;

//��߻�������
public class SchemeHandle {
	
	private String activityName;//�����
	private int plotterId;//	��߻���Id
	private String activityAddress;//��ص�
	private String activityStartTime;//���ʼʱ��
	private String activityEndTime;//�����ʱ��
	private String activityFileUrl;//�߻��ĵ�·��
	private int activityFileId;//�ĵ�Id
	
	
	private IDaoFrame daoFrame=new DaoFrame();
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����02:52:55
	 *��������
	 *���ܣ������ݿ��л�ȡ�߻�
	 *������
	 *����ֵ��
	 */
	public SchemeHandle(Activity activity){
		this.activityName=activity.getActivityName();
		this.plotterId=activity.getPlotterId();
		this.activityAddress=activity.getActivityAddress();
		this.activityStartTime=activity.getActivityStartTime();
		this.activityEndTime=activity.getActivityEndTime();
		File file=daoFrame.queryFileByBelong(FileType.SCHEME, activity.getActivityId());
		this.activityFileUrl=file.getFileUrl();
		this.activityFileId=file.getFileId();
		
	}
	
	public SchemeHandle(int plotterId) {
		this.plotterId=plotterId;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����05:08:34
	 *��������changePlotterId
	 *���ܣ��޸Ļ�߻���
	
	 *������@param plotterId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean changePlotterId(int plotterId) {
		this.plotterId=plotterId;
		return true;
	}
/**
 * 
 *���ߣ�movie
 *ʱ�䣺2015-10-17����03:40:01
 *��������SubmitScheme
 *���ܣ��ύ��߻�
 *������@param activityName
 *������@param activityStartTime
 *������@param activityEndTime
 *������@param activityAddress
 *������@param activityFileUrl
 *������@return 
 *����ֵ��boolean
 */
	public boolean SubmitScheme( String activityName,String activityStartTime, String activityEndTime,String activityAddress,String activityFileUrl) {
		this.activityName=activityName;
		this.activityEndTime=activityEndTime;
		this.activityStartTime=activityStartTime;
		this.activityAddress=activityAddress;
		this.activityFileUrl=activityFileUrl;
		return true;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����08:23:48
	 *��������saveScheme
	 *���ܣ����ͨ������߻�
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean saveScheme(int activityId){
		boolean result=daoFrame.CreateScheme(activityId, activityName, activityStartTime, activityEndTime, activityAddress);
		File file=ToSchemeFile(activityId);
		this.activityFileId=daoFrame.CreateFile(file);
		return result;
	}

	
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����01:52:04
	 *��������deleteScheme
	 *���ܣ�ɾ����߻�
	 *������ 
	 *����ֵ��void
	 */
	public boolean deleteScheme(){
		this.activityName=null;
		this.activityEndTime=null;
		this.activityStartTime=null;
		this.activityAddress=null;
		this.activityFileUrl=null;
		this.activityFileId=0;
		daoFrame.DeleteFile(this.activityFileId);
		return true;
		
	}

	
	public File ToSchemeFile(int activityId){
		File file=new File(this.activityFileId,FileType.SCHEME, activityId, this.activityFileUrl);
		return file;
	}
	public String getActivityName() {
		return activityName;
	}

	public int getPlotterId() {
		return plotterId;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public String getActivityStartTime() {
		return activityStartTime;
	}

	public String getActivityEndTime() {
		return activityEndTime;
	}

	public String getActivityFileUrl() {
		return activityFileUrl;
	}

	
	
	
	


	
}
