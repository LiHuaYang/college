package com.Bll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Dao.DaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.Activestage;
import com.Entity.Activity;
import com.Entity.Comment;
import com.Entity.Corporation;
import com.Entity.Department;
import com.Entity.Economics;
import com.Entity.Economicsrecord;
import com.Entity.Equipment;
import com.Entity.Equipmentrecord;
import com.Entity.File;
import com.Entity.Grade;
import com.Entity.Mission;
import com.Entity.Notice;
import com.Entity.Organization;
import com.Entity.Participants;
import com.Entity.Plan;
import com.Entity.User;
import com.Tool.DateProcess;
import com.Tool.MyConstant.BelongType;
import com.Tool.MyConstant.GradeType;
import com.Tool.MyConstant.OrganizeType;


public class BllImpl {
	private IDaoFrame daoFrame=new DaoFrame();
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午04:31:41
	 *函数名：QueryHotActivity
	 *功能：查询热门活动
	 *参数： 
	 *返回值：void
	 */
	public List<Activity> QueryHotActivity() {
		List<Activity> activities=daoFrame.QueryHotActivity();
		return activities;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午05:02:46
	 *函数名：QueryActivestageByActivityId
	 *功能：查询活动布告阶段
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：List<Activestage>
	 */
	public List<Activestage> QueryActivestageByActivityId(int activityId) {
		List<Activestage> activestages=daoFrame.QueryActivestageByActivityId(activityId);
		return activestages;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午09:13:54
	 *函数名：QueryActivityBulletin
	 *功能：查询所有活动布告
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryActivityBulletin() {
		List<HashMap<String, Object>> activitybulletin=daoFrame.QueryAllActivityBulletin();
		return activitybulletin;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午09:36:08
	 *函数名：SearchActivityBulletin
	 *功能：搜索活动布告
	 *参数：@param activityName
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> SearchActivityBulletin(String activityName,String activitytime,String activityaddress) {
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		List<HashMap<String, Object>> activitybulletin=daoFrame.SearchActivityBulletin(activityName,activityaddress);
		System.out.println(activitytime.length());
		if (activitytime.length()==0) {
			maps=activitybulletin;
		}
		else {
			int time = DateProcess.getintDate(activitytime);
			for (int i = 0; i < activitybulletin.size(); i++) {
				int starttime = DateProcess.getintDate(activitybulletin.get(i).get("activityStartTime").toString());
				int endtime = DateProcess.getintDate(activitybulletin.get(i).get("activityEndTime").toString());
				if (starttime <= time && endtime >= time) {
					
					maps.add(activitybulletin.get(i));
				}
			}
		}
		return maps;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午10:01:05
	 *函数名：QueryHotNotice
	 *功能：查询热门布告
	 *参数：@return 
	 *返回值：List<Notice>
	 */
	public List<Notice> QueryHotNotice() {
		List<Notice> notices=new ArrayList<Notice>();
		List<Notice> studentunionNotices=daoFrame.QueryHotNotice(BelongType.ORGANIZATION,OrganizeType.STUDENTUNION);
		List<Notice> federationNotices=daoFrame.QueryHotNotice(BelongType.ORGANIZATION,OrganizeType.FEDERATION);
		List<Notice> youthNotices=daoFrame.QueryHotNotice(BelongType.ORGANIZATION,OrganizeType.YOUTH);
		List<Notice> corpoorationNotices=daoFrame.QueryHotNotice(BelongType.COROORATION,0);
		notices.addAll(federationNotices);
		notices.addAll(studentunionNotices);
		notices.addAll(youthNotices);
		notices.addAll(corpoorationNotices);
		return notices;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午10:17:29
	 *函数名：QueryNoticeDetail
	 *功能：查询布告详情
	 *参数：@param noticeId
	 *参数：@return 
	 *返回值：HashMap<String,Object>
	 */
	public HashMap<String, Object> QueryNoticeDetail(int noticeId) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		Notice notices=daoFrame.QueryNoticeDetailById( noticeId);
		int belongtype=notices.getNoticeBelongType();
		int belongid=notices.getNoticeBelongId();
		String noticeReleaseName=null;
		String noticeReleasePic=null;
		if (belongtype==BelongType.ORGANIZATION) {
			Organization organization=daoFrame.QueryOrganizationById(belongid);
			noticeReleaseName=organization.getOrganizationName();
			noticeReleasePic=organization.getOrganizationPic();
		}else {
			Corporation corporation=daoFrame.QueryCorporationById(belongid);
			noticeReleaseName=corporation.getCorporationName();
			noticeReleasePic=corporation.getCorporationPic();
		}
		map.put("notice", notices);
		map.put("noticeReleaseName", noticeReleaseName);
		map.put("noticeReleasePic", noticeReleasePic);
		return map;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午09:23:41
	 *函数名：CreateComment
	 *功能：创建评论
	 *参数：@param comment
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateComment(Comment comment) {
		boolean result=daoFrame.CreateComment(comment);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午09:49:31
	 *函数名：QueryAllComment
	 *功能：查询该公告的所有评论
	 *参数：@param noticeId
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryAllComment(int noticeId) {
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		List<Comment> comments=daoFrame.queryCommentsByNoticeId(noticeId);
		for (int i = 0; i < comments.size(); i++) {
			User user=daoFrame.QueryUserById(comments.get(i).getUserId());
			HashMap<String, Object> map=comments.get(i).toHashMap();
			map.put("userName", user.getUserName());
			map.put("userPic", user.getUserPic());
			maps.add(map);
		}
		return maps;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午09:52:48
	 *函数名：DeleteComment
	 *功能：删除评论
	 *参数：@param commentId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteComment(int commentId) {
		boolean result=daoFrame.DeleteCommentById(commentId);
		return result;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午09:56:11
	 *函数名：QueryAllNotice
	 *功能：查询所有公告
	 *参数：@return 
	 *返回值：List<Notice>
	 */
	public List<Notice> QueryAllNotice() {
		List<Notice> notices=daoFrame.QueryAllNotice();
		return notices;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午10:52:33
	 *函数名：SeacherNotice
	 *功能：搜索公告
	 *参数：@param noticeName
	 *参数：@return 
	 *返回值：List<Notice>
	 */
	public List<Notice> SearchNotice(String noticeName,String starttime,String endtime ,int noticetype) {
		List<Notice> notices=daoFrame.SearchNotice(noticeName);
		List<Notice> newNotices=new ArrayList<Notice>();
		int istarttime=DateProcess.getintDate(starttime);
		int iendtime=DateProcess.getintDate(endtime);
		for (int i = 0; i < notices.size(); i++) {
			String time=notices.get(i).getNoticeStartTime();
			int noticetime=DateProcess.getintDate(time);
			if (noticetime>=istarttime&&noticetime<=iendtime){
				if (noticetype==0) {
					newNotices.add(notices.get(i));
				}else if (noticetype==4&&notices.get(i).getNoticeBelongType()==BelongType.COROORATION) {
					newNotices.add(notices.get(i));
				}
				else if (noticetype==notices.get(i).getNoticeBelongId()&&notices.get(i).getNoticeBelongType()==BelongType.ORGANIZATION) {
					newNotices.add(notices.get(i));
				}
				
			}
		}
		return newNotices;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午11:00:01
	 *函数名：QueryHotCorporation
	 *功能：查询热门社团
	 *参数：@return 
	 *返回值：List<Corporation>
	 */
	public List<Corporation> QueryHotCorporation() {
		List<Corporation> corporations=daoFrame.QueryHotCorporation();
		return corporations;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午11:04:27
	 *函数名：QueryCorporationDetailById
	 *功能：查询社团详情
	 *参数：@param corporationId
	 *参数：@return 
	 *返回值：Corporation
	 */
	public Corporation QueryCorporationDetailById(int corporationId) {
		Corporation corporation=daoFrame.QueryCorporationById(corporationId);
		return corporation;
	}
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryAllCorporation
	  *功能：查询所有社团
	  *参数：
	  *返回值：List<Corporation>
	  */
	public List<Corporation> QueryAllCorporation(){
		List<Corporation> corporations=daoFrame.QueryAllCorporation();
		return corporations;
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午11:14:35
	 *函数名：SearchCorporation
	 *功能：搜素社团
	 *参数：@param corporationName
	 *参数：@return 
	 *返回值：List<Corporation>
	 */
	public List<Corporation> SearchCorporation(String corporationName){
		List<Corporation> corporations=daoFrame.SearchCorporation(corporationName);
		return corporations;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午02:05:12
	 *函数名：QueryOrganizationDetail
	 *功能：根据组织ID查询组织
	 *参数：@param organizationId
	 *参数：@return 
	 *返回值：Organization
	 */
	public Organization QueryOrganizationDetail(int organizationId) {
		Organization organization=daoFrame.QueryOrganizationById(organizationId);
		return organization;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午12:06:33
	 *函数名：QueryOrganizationMember
	 *功能：查询组织成员
	 *参数：@param organizationId
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryOrganizationMember(int organizationId){
		List<HashMap<String , Object>> maps=new ArrayList<HashMap<String,Object>>();
		
		List<Department> departments=daoFrame.queryDepartmentsByorganizationId(organizationId);
		List<Grade> organizegrades=daoFrame.QueryGradeByBelong(BelongType.ORGANIZATION, organizationId);
		
		for (int i = 0; i < departments.size(); i++) {
			Grade departmentgrades=null;
			List<Grade> grades=daoFrame.QueryGradeByGrade(BelongType.DEPARTMENT, departments.get(i).getDepartmentId(), GradeType.MINISTER);
			if (grades.size()>0) {
				departmentgrades=grades.get(0);
				organizegrades.add(departmentgrades);
			}
		}
		for (int i = 0; i < organizegrades.size(); i++) {
			HashMap<String, Object> map=organizegrades.get(i).toHashMap();
			String name=daoFrame.QueryUserById(organizegrades.get(i).getUserId()).getUserName();
			map.put("userName", name);
			if (organizegrades.get(i).getGradeBelongType()==0) {
				for (int j = 0; j < departments.size(); j++) {
					if (departments.get(j).getDepartmentId()==organizegrades.get(i).getGradeBelongId()) {
						map.put("departmentName", departments.get(j).getDepartmentName());
					}
				}
			}
			maps.add(map);
			
		}
		
		
		return maps;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午02:36:15
	 *函数名：QueryOrganizationBulletin
	 *功能：查询组织活动布告
	 *参数：@param organizationId
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryOrganizationBulletin(int organizationId){
		
		List<HashMap<String, Object>> maps=daoFrame.QueryActivityBulletinByOrganizationId(organizationId);
		return maps;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午02:59:03
	 *函数名：QueryNoticeByBelong
	 *功能：查询公告通过所属
	 *参数：@param noticeBelongType
	 *参数：@param noticeBelongId
	 *参数：@return 
	 *返回值：List<Notice>
	 */
	public List<Notice> QueryNoticeByBelong(int noticeBelongType,
			int noticeBelongId) {
		List<Notice> notices=daoFrame.QueryNoticeByBelong(noticeBelongType, noticeBelongId);
		return	notices;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午03:05:28
	 *函数名：queryDepartmentsByorganizationId
	 *功能：查询组织部门
	 *参数：@param organizationId
	 *参数：@return 
	 *返回值：List<Department>
	 */
	public List<Department> QueryDepartmentsByorganizationId(int organizationId){
		List<Department> departments=daoFrame.queryDepartmentsByorganizationId(organizationId);
		return departments;
	}
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-19下午03:23:07
	  *函数名：QueryDepartmentMembers
	  *功能：查询部门成员
	  *参数：@param departmentId
	  *参数：@return 
	  *返回值：List<HashMap<String,Object>>
	  */
	public List<HashMap<String, Object>> QueryDepartmentMembers(int departmentId){
		List<Grade> grades=daoFrame.QueryGradeByBelong(BelongType.DEPARTMENT, departmentId);
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < grades.size(); i++) {
			HashMap<String, Object> map=grades.get(i).toHashMap();
			int userId=grades.get(i).getUserId();
			User user=daoFrame.QueryUserById(userId);
			String userName=user.getUserName();
			map.put("userName", userName);
			maps.add(map);
		}
		return maps;
	}
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-19下午03:23:07
	  *函数名：QueryCorporationMembers
	  *功能：查询社团成员
	  *参数：@param corporationId
	  *参数：@return 
	  *返回值：List<HashMap<String,Object>>
	  */
	public List<HashMap<String, Object>> QueryCorporationMembers(int corporationId){
		List<Grade> grades=daoFrame.QueryGradeByBelong(BelongType.COROORATION, corporationId);
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < grades.size(); i++) {
			HashMap<String, Object> map=grades.get(i).toHashMap();
			int userId=grades.get(i).getUserId();
			User user=daoFrame.QueryUserById(userId);
			String userName=user.getUserName();
			map.put("userName", userName);
			maps.add(map);
		}
		return maps;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午03:29:02
	 *函数名：queryDepartmentDetail
	 *功能：查询部门详情
	 *参数：@param departmentId
	 *参数：@return 
	 *返回值：Department
	 */
	public Department QueryDepartmentDetail(int departmentId){
		Department departments=daoFrame.QueryDepartmentById(departmentId);
		return departments;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午04:33:19
	 *函数名：ChangeGrade
	 *功能：修改等级
	 *参数：@param gradeId
	 *参数：@param userGrade
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChangeGrade(int gradeId, int userGrade,int gradeBelongType,int gradeBelongId) {
		boolean result=daoFrame.ChangeGrade(gradeId, userGrade,gradeBelongType,gradeBelongId);
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午07:10:34
	 *函数名：DeleteGradeById
	 *功能：删除成员
	 *参数：@param gradeid
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteGradeById(int gradeid){
		boolean result=daoFrame.DeleteGradeById(gradeid);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午07:48:59
	 *函数名：CreatePlan
	 *功能：创建任务方案
	 *参数：@param plan
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreatePlan(Plan plan) {
		boolean result=false;
		int planid=daoFrame.CreatePlan(plan);
		if (planid!=0) {
			result=true;
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午03:53:11
	 *函数名：QueryPlanByPlanCreatorId
	 *功能：根据任务发起人ID查询任务方案
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：Plan
	 */
	public List<Plan> QueryPlanByPlanCreatorId(int planCreatorId){
		
		List<Plan> plans=daoFrame.QueryPlanByPlanCreatorId(planCreatorId);
		return plans;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午07:56:04
	 *函数名：CreateMission
	 *功能：创建并提交子任务
	 *参数：@param mission
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateMission(List<Mission> mission){
		boolean result=daoFrame.CreateMission(mission);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午09:14:15
	 *函数名：queryActivityByOrganizeId
	 *功能：查询组织活动
	 *参数：@param organizationId
	 *参数：@return 
	 *返回值：List<Activity>
	 */
	public List<Activity> QueryAllActivityByOrganizationId(int organizationId) {
		List<Activity> activities=daoFrame.QueryAllActivityByOrganizationId(organizationId);
		return activities;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午09:32:56
	 *函数名：QueryActivityDetail
	 *功能：查询活动详情
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：Activity
	 */
	public Activity QueryActivityDetail(int activityId) {

		Activity activity=daoFrame.QueryActivityById(activityId);
		
		return activity;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午09:55:42
	 *函数名：QueryPlanByActivityId
	 *功能：查询任务方案通过活动ID
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：Plan
	 */
	public Plan QueryPlanByActivityId(int activityId) {
		Plan plan=daoFrame.QueryPlanByActivityId(activityId);
		return plan;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午10:05:29
	 *函数名：QueryMissionByPlanId
	 *功能：根据任务方案ID查询子任务
	 *参数：@param PlanId
	 *参数：@return 
	 *返回值：List<Mission>
	 */
	public List<Mission> QueryMissionByPlanId(int planId) {
		List<Mission> missions=daoFrame.queryMissionsByPlanId(planId);
		return missions;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午10:14:48
	 *函数名：QueryParticipantsByActivityId
	 *功能：根据活动Id查询活动参与人员
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：List<Participants>
	 */
	public List<Participants> QueryParticipantsByActivityId(int activityId) {
		List<Participants> participants=daoFrame.QueryParticipantsByActivityId(activityId);
		return participants;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午09:32:22
	 *函数名：QueryEconomicsByBelong
	 *功能：根据所属类型和所属Id查询资金总量
	 *参数：@param economicsBelongType
	 *参数：@param economicsBelongId
	 *参数：@return 
	 *返回值：Economics
	 */
	public Economics QueryEconomicsByBelong(int economicsBelongType,int economicsBelongId){
		Economics economics=daoFrame.QueryEconomicsByBelong(economicsBelongType, economicsBelongId);
		return economics;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午09:59:32
	 *函数名：UpdateEconomicsSum
	 *功能：更新资金总数
	 *参数：@param economicsId
	 *参数：@param economicsSum
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateEconomicsSum(int economicsId,float economicsSum){
		boolean result=daoFrame.UpdateEconomicsSum(economicsId, economicsSum);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午09:37:57
	 *函数名：QueryEconomicsrecordsByEconomicsId
	 *功能：根据资金ID查询资金记录
	 *参数：@param economicsId
	 *参数：@return 
	 *返回值：List<Economicsrecord>
	 */
	public List<Economicsrecord> QueryEconomicsrecordsByEconomicsId(int economicsId){
		List<Economicsrecord> economicsrecords=daoFrame.QueryEconomicsrecordsByEconomicsId(economicsId);
		return economicsrecords;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午09:57:17
	 *函数名：CreateEconomicscord
	 *功能：创建资金记录
	 *参数：@param economicsrecord
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateEconomicscord(Economicsrecord economicsrecord){
		boolean result=daoFrame.CreateEconomicscord(economicsrecord);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午09:32:22
	 *函数名：QueryEquipmentByBelong
	 *功能：根据所属类型和所属Id查询器材列表
	 *参数：@param equipmentBelongType
	 *参数：@param equipmentBelongId
	 *参数：@return 
	 *返回值：Equipment
	 */
	public List<Equipment> QueryEquipmentByBelong(int equipmentBelongType,int equipmentBelongId){
		List<Equipment> equipments=daoFrame.QueryEquipmentByBelong(equipmentBelongType, equipmentBelongId);
		return equipments;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午10:19:55
	 *函数名：QueryEquipmentById
	 *功能：根据器材Id查询器材详情
	 *参数：@param equipmentId
	 *参数：@return 
	 *返回值：Equipment
	 */
	public Equipment QueryEquipmentById(int equipmentId){
		Equipment equipment=daoFrame.QueryEquipmentById(equipmentId);
		return equipment;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午10:23:12
	 *函数名：SaveEquipment
	 *功能：新建器材
	 *参数：@param equipment
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SaveEquipment(Equipment equipment){
		boolean result=daoFrame.SaveEquipment(equipment);
		return result;
	}
	/**    
	 * 
	 *作者：movie
	 *时间：2015-10-15上午10:23:12
	 *函数名：SaveEquipment
	 *功能：修改器材
	 *参数：@param equipment
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateEquipment(Equipment equipment){
		boolean result=daoFrame.UpdateEquipment(equipment);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午10:28:13
	 *函数名：DeleteEquipment
	 *功能：根据主键删除器材及器材记录
	 *参数：@param equipmentId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteEquipment(int equipmentId){
		boolean result=daoFrame.DeleteEquipment(equipmentId);
		daoFrame.DeleteEquipmentrecordByEquipmentId(equipmentId);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午09:37:57
	 *函数名：QueryEquipmentrecordsByEquipmentId
	 *功能：根据器材ID查询器材记录
	 *参数：@param equipmentId
	 *参数：@return 
	 *返回值：List<Economicsrecord>
	 */
	public List<Equipmentrecord> QueryEquipmentrecordsByEquipmentId(int equipmentId){
		List<Equipmentrecord> equipmentrecords=daoFrame.QueryEquipmentrecordsByEquipmentId(equipmentId);
		return equipmentrecords;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午10:35:24
	 *函数名：CreateEquipmentrecord
	 *功能：创建器材记录
	 *参数：@param equipmentrecord
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateEquipmentrecord(Equipmentrecord equipmentrecord){
		boolean result=daoFrame.CreateEquipmentrecord(equipmentrecord);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午10:45:11
	 *函数名：SaveNotice
	 *功能：发布公告
	 *参数：@param notice
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SaveNotice(Notice notice){
		boolean result=daoFrame.SaveNotice(notice);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午10:45:11
	 *函数名：DeleteNotice
	 *功能：删除公告
	 *参数：@param noticeId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteNotice(int noticeId){
		boolean result=daoFrame.DeleteNotice(noticeId);
		daoFrame.DeleteNotice(noticeId);
		return result;
	}
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-14下午01:16:32
	  *函数名：QueryUserById
	  *功能：根据用户ID查询用户详情
	  *参数：@param userId
	  *返回值：User
	  */
	 public User QueryUserById(int userId){
		 User user=daoFrame.QueryUserById(userId);
		 return user;
	 }
	 
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-15上午11:01:10
	  *函数名：UpdateUser
	  *功能：修改用户资料
	  *参数：@param user
	  *参数：@return 
	  *返回值：boolean
	  */
	 public boolean UpdateUser(User user){
		 boolean result=daoFrame.UpdateUser(user);
		 return result;
	 }
	 
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-21下午03:50:13
	  *函数名：QueryUserPart
	  *功能：查询用户参加的部门和社团，包括用户职位
	  *参数：@param UserId
	  *参数：@return 
	  *返回值：List<HashMap<String,Object>>
	  */
	 public HashMap<String,Object> QueryUserPart(int UserId){
		 HashMap<String, Object> UserPart=new HashMap<String, Object>();
		 List<HashMap<String,Object>> organmaps=new ArrayList<HashMap<String,Object>>();
		 List<HashMap<String,Object>> departmaps=new ArrayList<HashMap<String,Object>>();
		 List<HashMap<String,Object>> corpormaps=new ArrayList<HashMap<String,Object>>();
		 List<Grade> grades=daoFrame.QueryGradeByUserId(UserId);
		 for (int i = 0; i < grades.size(); i++) {
			 //组织
			if (grades.get(i).getGradeBelongType()==BelongType.ORGANIZATION) {
				Organization organization=daoFrame.QueryOrganizationById(grades.get(i).getGradeBelongId());
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("organizationId", organization.getOrganizationId());
				map.put("organizationName", organization.getOrganizationName());
				map.put("organizationPic", organization.getOrganizationPic());
				map.put("grade", grades.get(i));
				organmaps.add(map);
			}
			//部门
			else if (grades.get(i).getGradeBelongType()==BelongType.DEPARTMENT) {
				Department department=daoFrame.QueryDepartmentById(grades.get(i).getGradeBelongId());
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("departmentId", department.getDepartmentId());
				Organization organzition=daoFrame.QueryOrganizationById(department.getDepartmentBelongId());
				String organzitionName=organzition.getOrganizationName();
				map.put("departmentName",organzitionName+department.getDepartmentName());
				map.put("departmentPic", department.getDepartmentPic());
				map.put("grade", grades.get(i));
				departmaps.add(map);
			
			}
			//社团
			else if (grades.get(i).getGradeBelongType()==BelongType.COROORATION) {
				Corporation corporation=daoFrame.QueryCorporationById(grades.get(i).getGradeBelongId());
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("corporationId", corporation.getCorporationBelongId());
				map.put("corporationName", corporation.getCorporationName());
				map.put("corporationPic", corporation.getCorporationPic());
				map.put("grade", grades.get(i));
				corpormaps.add(map);
			}
			
		}
		 UserPart.put("Organization", organmaps);
		 UserPart.put("Department", departmaps);
		 UserPart.put("Corporation", corpormaps);
		 return UserPart;
	 }
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-22下午01:42:55
	  *函数名：changeGradeDatum
	  *功能：修改职位资料
	  *参数：@param gradeId
	  *参数：@param gradeContent
	  *参数：@param gradePic
	  *参数：@return 
	  *返回值：boolean
	  */
	 public boolean ChangeGradeDatum(int gradeId,String gradeContent,String gradePic){
		 boolean result=daoFrame.changeGradeDatum(gradeId, gradeContent, gradePic);
		 return result;
	 }
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-15上午11:14:58
	  *函数名：queryFriendsByUserId
	  *功能：根据用户ID查询该用户好友
	  *参数：@param userId
	  *参数：@return 
	  *返回值：List<Friend>
	  */
	 public List<HashMap<String, Object>> QueryFriendsByUserId(int userId){
		 List<HashMap<String, Object>> friends=daoFrame.queryFriendsByUserId(userId);
		 return friends;
	 }
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-22下午02:40:58
	  *函数名：SearchUser
	  *功能：搜索用户
	  *参数：@param userName
	  *参数：@return 
	  *返回值：List<User>
	  */
	 public List<User> SearchUser(String userName){
		List<User> users=daoFrame.SearchUser(userName);
		for (int i = 0; i < users.size(); i++) {
			users.get(i).setUserPassword("");
	
		}
		return users;
	 }
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-22下午03:27:49
	  *函数名：QueryMissionBymissionExecutorId
	  *功能：根据用户查询他收到的子任务
	  *参数：@param missionExecutorId
	  *参数：@return 
	  *返回值：List<Mission>
	  */
	public List<HashMap<String, Object>> QueryMissionBymissionExecutorId(int missionExecutorId) {
		List<Mission> missions = daoFrame.QueryMissionBymissionExecutorId(missionExecutorId);
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < missions.size(); i++) {
			HashMap<String, Object> map=missions.get(i).toHashMap();
			int missionPromoterId=missions.get(i).getMissionExecutorId();
			User user=daoFrame.QueryUserById(missionPromoterId);
			String userName=user.getUserName();
			int planId=missions.get(i).getPlanId();
			Plan plan=daoFrame.QueryPlanById(planId);
			String planName=plan.getPlanName();
			map.put("userName", userName);
			map.put("planName", planName);
			maps.add(map);
		}
	
		return maps;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午11:20:09
	 *函数名：UpdateDepartment
	 *功能：修改部门信息
	 *参数：@param department
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateDepartment(int departmentId,String departmentIntroduction,String departmentPic){
		boolean result=daoFrame.UpdateDepartment(departmentId, departmentIntroduction, departmentPic);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午11:20:09
	 *函数名：UpdateOrganzation
	 *功能：修改组织资料
	 *参数：@param organization
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateOrganzation(int organizationId,String organizationIntroduction,String organizationPic){
		boolean result=daoFrame.UpdateOrganzation(organizationId, organizationIntroduction, organizationPic);
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15下午01:02:40
	 *函数名：DeleteFriend
	 *功能：删除好友
	 *参数：@param friendRelationId
	 *参数：@return 
	 *返回值：boolean
	 */	
	public boolean DeleteFriend(int userId,int friendId){
		boolean result = daoFrame.DeleteFriend(userId,friendId);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-11-24下午01:12:03
	 *函数名：Login
	 *功能：登录
	 *参数：@param userroll
	 *参数：@return 
	 *返回值：int
	 */
	public Map<String, Object> Login(String userroll,String password){
		Map<String, Object> map=new HashMap<String, Object>();
		int result=0;//无用户
		System.out.println(password);
		
		User user=daoFrame.QueryUserByUserRoll(userroll);
		System.out.println(user.getUserPassword());
		if (user.getUserId()==0) {
			result=0;
		}else if (user.getUserPassword().equals(password)) {
			result=user.getUserId();
			map.put("User", user);
		}else {
			result=-1;//密码错误
		}
		map.put("result", result);
	
		return map;
	
		
	};
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午02:32:45
	 *函数名：queryFileByBelong
	 *功能：根据文件类型和所属查询文件
	 *参数：@param fileType
	 *参数：@param fileBelongId
	 *参数：@return 
	 *返回值：File
	 */
	public File queryFileByBelong(int fileType,int fileBelongId){
		File file=daoFrame.queryFileByBelong(fileType, fileBelongId);
		return file;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20下午04:59:38
	 *函数名：SumbitActivityMissionResult
	 *功能：提交任务总结
	 *参数：@param planId
	 *参数：@param missionId
	 *参数：@param missionResult
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SumbitMissionResult(int missionId,String missionResult){
		boolean result=daoFrame.SubmitMissionResult(missionId, missionResult);
		return result;
	
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-21上午11:16:01
	 *函数名：QueryActivityByUserparts
	 *功能：查询用户参加的所有活动
	 *参数：@param userId
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryActivityByUserparts(int userId){
		List<HashMap<String, Object>> maps=daoFrame.QueryActivityByUserparts(userId);
		return maps;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-24下午03:56:15
	 *函数名：queryAllUserName
	 *功能：查询所有用户名称
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> queryAllUserName(){
		List<HashMap<String, Object>> maps=daoFrame.queryAllUserName();
		return maps;
	}
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-14下午06:17:37
	  *函数名：DeletePlan
	  *功能：删除任务方案
	  *参数：@param PlanId
	  *参数：@return 
	  *返回值：boolean
	  */
	 public boolean DeletePlan(int PlanId){
		 boolean result=daoFrame.DeletePlan(PlanId);
		 return result;
	 }
}	
