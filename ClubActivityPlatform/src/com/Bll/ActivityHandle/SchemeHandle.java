package com.Bll.ActivityHandle;

import com.Dao.DaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.Activity;
import com.Entity.File;
import com.Tool.MyConstant.FileType;

//活动策划处理类
public class SchemeHandle {
	
	private String activityName;//活动标题
	private int plotterId;//	活动策划人Id
	private String activityAddress;//活动地点
	private String activityStartTime;//活动开始时间
	private String activityEndTime;//活动结束时间
	private String activityFileUrl;//策划文档路径
	private int activityFileId;//文档Id
	
	
	private IDaoFrame daoFrame=new DaoFrame();
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午02:52:55
	 *函数名：
	 *功能：从数据库中获取策划
	 *参数：
	 *返回值：
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
	 *作者：movie
	 *时间：2015-10-17下午05:08:34
	 *函数名：changePlotterId
	 *功能：修改活动策划人
	
	 *参数：@param plotterId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean changePlotterId(int plotterId) {
		this.plotterId=plotterId;
		return true;
	}
/**
 * 
 *作者：movie
 *时间：2015-10-17下午03:40:01
 *函数名：SubmitScheme
 *功能：提交活动策划
 *参数：@param activityName
 *参数：@param activityStartTime
 *参数：@param activityEndTime
 *参数：@param activityAddress
 *参数：@param activityFileUrl
 *参数：@return 
 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-17下午08:23:48
	 *函数名：saveScheme
	 *功能：审核通过保存策划
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean saveScheme(int activityId){
		boolean result=daoFrame.CreateScheme(activityId, activityName, activityStartTime, activityEndTime, activityAddress);
		File file=ToSchemeFile(activityId);
		this.activityFileId=daoFrame.CreateFile(file);
		return result;
	}

	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午01:52:04
	 *函数名：deleteScheme
	 *功能：删除活动策划
	 *参数： 
	 *返回值：void
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
