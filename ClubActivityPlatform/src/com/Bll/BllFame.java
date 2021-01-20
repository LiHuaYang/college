package com.Bll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Bll.ActivityHandle.ActivityHandle;
import com.Bll.ActivityHandle.ActivityModel;
import com.Bll.ChatHandle.Chat;
import com.Bll.ChatHandle.ChatModel;
import com.Bll.FriendHandle.FriendModle;
import com.Bll.InformationHandle.InformationsModel;
import com.Bll.RegistrationHandle.Registration;
import com.Bll.RegistrationHandle.RegistrationModel;
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
import com.Entity.Friend;
import com.Entity.Mission;
import com.Entity.Notice;
import com.Entity.Organization;
import com.Entity.Participants;
import com.Entity.Plan;
import com.Entity.User;
import com.Tool.MyConstant.ActivityState;
import com.Tool.MyConstant.ActivityType;
import com.Tool.MyConstant.HotNum;

public class BllFame implements IBllFrame{
	private BllImpl bllImpl=new BllImpl();
	
	private static InformationsModel informationsModel=new InformationsModel();
	private static ActivityModel activityModel=new ActivityModel();
	private static  RegistrationModel registrationModel=new RegistrationModel();
	private static ChatModel chatModel=new ChatModel();
	private static FriendModle friendModle=new FriendModle();
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午03:38:03
	 *函数名：
	 *功能：创建活动模型
	 *参数：
	 *返回值：
	 */
	public void getDateActivityModel(){
		activityModel.getDateActivityModel();
		System.out.println(activityModel.getActivity());
		
	}

	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午03:04:19
	 *函数名：QueryHotActivity
	 *功能：查询热门活动
	 *参数：@return 
	 *返回值：List<Activity>
	 */
	public List<HashMap<String, Object>> QueryHotActivity(){
		List<Activity> hotActivities=new ArrayList<Activity>();
		List<Activity> activities = activityModel.getActivity();
		for (int i = 0; i < activities.size(); i++) {
			if (activities.get(i).getActivityType() >= ActivityState.GOING_STAGE&&activities.get(i).getActivityType()!=ActivityType.IN) {
				hotActivities.add(activities.get(i));
			}
		}
		if (hotActivities.size()<HotNum.HOTACTIVITYNUM) {
			hotActivities=bllImpl.QueryHotActivity();
		}
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < hotActivities.size(); i++) {
			HashMap<String, Object> map=new  HashMap<String, Object>();
			List<Activestage> activestages=bllImpl.QueryActivestageByActivityId(hotActivities.get(i).getActivityId());
			Activestage activestage=new Activestage();
			if (activestages.size()!=0) {
				activestage=activestages.get(0);
			}
			map.put("activity", hotActivities.get(i));
			map.put("activestageContent",activestage.getActivestageContent());
			map.put("activestagePic", activestage.getActivestagePic());
			maps.add(map);
		}
		return maps;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午05:03:24
	 *函数名：QueryActivestageByActivityId
	 *功能：根据活动ID查询活动布告阶段
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：List<Activestage>
	 */
	public List<Activestage> QueryActivestageByActivityId(int activityId){
		List<Activestage> activestages=new ArrayList<Activestage>();
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			activestages=activityHandle.getActivityBulletinHandle().getActivestage();
		}else {
			activestages=bllImpl.QueryActivestageByActivityId(activityId);
		}
		
		return activestages;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午06:38:27
	 *函数名：enterActivity
	 *功能：报名活动
	 *参数：@param participants
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean enterActivity(Participants participants){
		boolean result=false;
		int activityId=participants.getActivityId();
		
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
	
		if (activityHandle!=null) {
			result=activityHandle.enterActivity(participants);
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午06:43:37
	 *函数名：QueryActivityEnter
	 *功能：查看活动报名人员
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：List<Participants>
	 */
	public List<Participants> QueryActivityEnter(int activityId){
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		List<Participants> participants=activityHandle.getActivityPersonnelHandle().getEnterHandles();
		return participants;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午06:53:05
	 *函数名：ChecksActiyityMembers
	 *功能：审核活动参与人员
	 *参数：@param participants
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChecksActiyityMembers(List<Participants> participants){
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(participants.get(0).getActivityId());
		boolean result=activityHandle.examineParticipants(participants);
		return result;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午06:55:56
	 *函数名：SubmitActiyityMembers
	 *功能：提交人员审核结果
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SubmitActiyityMembers(int activityId){
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		boolean result= activityHandle.SumbitParticipants();
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午09:09:02
	 *函数名：createActivityBulletin
	 *功能：创建活动布告
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateActivityBulletin(int activityId){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			result=activityHandle.createActivityBulletin();
		}
		return result;
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午08:01:05
	 *函数名：CreateActivestage
	 *功能：创建活动布告阶段
	 *参数：@param activestage
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateActivestage(Activestage activestage){
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activestage.getActivityId());
		boolean result= activityHandle.createActivestage(activestage);
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午09:15:05
	 *函数名：QueryActivityBulletin
	 *功能：查询所有活动布告
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryActivityBulletin(){
		List<HashMap<String, Object>> activitybulletin=bllImpl.QueryActivityBulletin();
		return activitybulletin;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午09:15:05
	 *函数名：QueryActivityBulletin
	 *功能：搜索活动布告
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> SearchActivityBulletin(String activityName,String activitytime,String activityaddress){
		List<HashMap<String, Object>> activitybulletin=bllImpl.SearchActivityBulletin(activityName,activitytime,activityaddress);
		return activitybulletin;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午10:01:25
	 *函数名：QueryHotNotice
	 *功能：查询热门布告
	 *参数：@return 
	 *返回值：List<Notice>
	 */
	public  List<Notice> QueryHotNotice(){
		 List<Notice> notices=bllImpl.QueryHotNotice();
		 return notices;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午10:18:12
	 *函数名：QueryNoticeDetail
	 *功能：查询布告详情
	 *参数：@param noticeId
	 *参数：@return 
	 *返回值：HashMap<String,Object>
	 */
	public HashMap<String, Object> QueryNoticeDetail(int noticeId){
		HashMap<String, Object> hashMaps=bllImpl.QueryNoticeDetail(noticeId);
		return hashMaps;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午09:24:28
	 *函数名：CreateComment
	 *功能：创建评论
	 *参数：@param comment
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateComment(Comment comment){
		boolean result=bllImpl.CreateComment(comment);
		return result;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午09:50:26
	 *函数名：QueryAllComment
	 *功能：查询所有评论
	 *参数：@param noticeId
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryAllComment(int noticeId){
		List<HashMap<String, Object>> map=bllImpl.QueryAllComment(noticeId);
		return map;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午09:51:10
	 *函数名：DeleteComment
	 *功能：删除评论
	 *参数：@param commentId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteComment(int commentId){
		boolean result=bllImpl.DeleteComment(commentId);
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午09:55:44
	 *函数名：QueryAllNotice
	 *功能：查询所有公告
	 *参数：@return 
	 *返回值：List<Notice>
	 */
	public List<Notice> QueryAllNotice(){
		List<Notice> notices=bllImpl.QueryAllNotice();
		return notices;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午09:55:44
	 *函数名：SearchNotice
	 *功能：搜索公告
	 *参数：@return 
	 *返回值：List<Notice>
	 */
	public List<Notice> SearchNotice(String NoticeName,String starttime,String endtime,int noticetype){
		List<Notice> notices=bllImpl.SearchNotice(NoticeName,starttime,endtime ,noticetype);
		return notices;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午10:58:52
	 *函数名：QueryHotcorporation
	 *功能：查询热门社团
	 *参数：@return 
	 *返回值：List<Corporation>
	 */
	public List<Corporation> QueryHotcorporation(){
		List<Corporation> corporations=bllImpl.QueryHotCorporation();
		return corporations;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19上午11:02:38
	 *函数名：QueryCorporationDetailById
	 *功能：查询社团详情
	 *参数：@param corporationId
	 *参数：@return 
	 *返回值：Corporation
	 */
	public Corporation QueryCorporationDetailById(int corporationId){
		Corporation corporation=bllImpl.QueryCorporationDetailById(corporationId);
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
		List<Corporation> corporations=bllImpl.QueryAllCorporation();
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
		List<Corporation> corporations=bllImpl.SearchCorporation(corporationName);
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
	public Organization QueryOrganizationDetail(int organizationId){
		Organization organization=bllImpl.QueryOrganizationDetail(organizationId);
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
		 List<HashMap<String, Object>> maps=bllImpl.QueryOrganizationMember(organizationId);
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
		List<HashMap<String, Object>> maps=bllImpl.QueryOrganizationBulletin(organizationId);
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
	public List<Notice> QueryNoticeByBelong(int noticeBelongType,int noticeBelongId){
		List<Notice> notices=bllImpl.QueryNoticeByBelong(noticeBelongType,noticeBelongId);
		return notices;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午03:05:28
	 *函数名：QueryDepartmentsByorganizationId
	 *功能：查询组织部门
	 *参数：@param organizationId
	 *参数：@return 
	 *返回值：List<Department>
	 */
	public List<Department> QueryDepartmentsByorganizationId(int organizationId){
		List<Department> departments=bllImpl.QueryDepartmentsByorganizationId(organizationId);
		return departments;
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
		Department departments=bllImpl.QueryDepartmentDetail(departmentId);
		return departments;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午03:54:44
	 *函数名：createRegistration
	 *功能：提交加入部门或社团申请
	 *参数：@param userId
	 *参数：@param userName
	 *参数：@param belongType
	 *参数：@param belongId
	 *参数：@param registrationContent
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateRegistration(int userId,String userName, int belongType,int belongId,String registrationContent){
		boolean result=registrationModel.createRegistration(userId, userName, belongType, belongId, registrationContent);
		return result;
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
		List<HashMap<String, Object>> departments=bllImpl.QueryDepartmentMembers(departmentId);
		return departments;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午04:33:33
	 *函数名：ChangeGrade
	 *功能：改变职位
	 *参数：@param gradeId
	 *参数：@param userGrade
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChangeGrade(int gradeId,int userGrade,int gradeBelongType,int gradeBelongId){
		boolean result=bllImpl.ChangeGrade(gradeId,userGrade,gradeBelongType,gradeBelongId);
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午03:55:10
	 *函数名：QueryRegistrationByBelong
	 *功能：根据所属查看报名人员
	 *参数：@param belongType
	 *参数：@param belongId
	 *参数：@return 
	 *返回值：List<Registration>
	 */
	public List<Registration> QueryRegistrationByBelong(int belongType,int belongId){
		List<Registration> registrations=registrationModel.QueryRegistrationByBelong(belongType, belongId);
		return registrations;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午04:16:39
	 *函数名：QueryRegistrationByUser
	 *功能：根据用户ID查找他报名了哪些部门组织
	 *参数：@param userId
	 *参数：@return 
	 *返回值：List<Registration>
	 */
	public List<Registration> QueryRegistrationByUser(int userId){
		List<Registration> registrations=registrationModel.QueryRegistrationByUser(userId);
		return registrations;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午04:14:37
	 *函数名：RefuseRegistration
	 *功能：拒绝加入
	 *参数：@param belongType
	 *参数：@param belongId
	 *参数：@param userId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean RefuseRegistration(int belongType,int belongId,int userId){
		boolean result=registrationModel.RefuseRegistration(belongType, belongId, userId);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午07:08:47
	 *函数名：SubmitRegistration
	 *功能：批准申请人加入部门
	 *参数：@param belongType
	 *参数：@param belongId
	 *参数：@param userId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SubmitRegistration(int belongType,int belongId,int userId){
		boolean result=registrationModel.SubmitRegistration(belongType, belongId, userId);
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
		boolean result=bllImpl.DeleteGradeById(gradeid);
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午07:48:27
	 *函数名：CreatePlan
	 *功能：创建任务方案
	 *参数：@param plan
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreatePlan(Plan plan){
		int activityid=plan.getActivityId();
		boolean result=false;
		if (activityid!=0) {
			ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityid);
			result=activityHandle.CreatePlan(plan);
		}else {
			result=bllImpl.CreatePlan(plan);
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午07:48:27
	 *函数名：UpdatePlan
	 *功能：修改任务方案
	 *参数：@param plan
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdatePlan(Plan plan){
		int activityid=plan.getActivityId();
		boolean result=false;
		if (activityid!=0) {
			ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityid);
			result=activityHandle.UpdatePlan(plan);
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午03:53:11
	 *函数名：QueryPlanByPlanCreatorId
	 *功能：根据任务发起人ID查询任务方案
	 *参数：@param planCreatorId
	 *参数：@return 
	 *返回值： List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> QueryPlanByPlanCreatorId(int planCreatorId){
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < activityModel.getsize(); i++) {
			ActivityHandle activityHandle=activityModel.get(i);
			if (activityHandle.getPlanHandle().getPlanCreatorId()==planCreatorId&&activityHandle.getActivityState()<ActivityState.GOING_STAGE) {
				Plan plan=activityHandle.getPlan();
				List<Mission> missions=activityHandle.getPlanHandle().getmisMissions();
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("Plan", plan);
				map.put("Missions", missions);
				map.put("PlanChangeType", true);
				map.put("activityName", activityHandle.getSchemeHandle().getActivityName());
				map.put("activityBelongId", activityHandle.getActivityBelongId());
				maps.add(map);
			}
		}
		List<Plan> plans=bllImpl.QueryPlanByPlanCreatorId(planCreatorId);
		for (int i = 0; i < plans.size(); i++) {
			int planId=plans.get(i).getPlanId();
			List<Mission> missions=bllImpl.QueryMissionByPlanId(planId);
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("Plan", plans.get(i));
			map.put("Missions", missions);
			map.put("PlanChangeType", false);
			if (plans.get(i).getActivityId()==0) {
				map.put("activityName", "无");
			}else {
				Activity activity=bllImpl.QueryActivityDetail(plans.get(i).getActivityId());
				map.put("activityName",activity.getActivityName());
			}
			map.put("activityBelongId", 0);
			maps.add(map);
		}
		return maps;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-19下午07:56:04
	 *函数名：CreateMission
	 *功能：创建并发布子任务
	 *参数：@param mission
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateMission(List<Mission> mission){
		boolean result=false;
		int planId=mission.get(0).getPlanId();
		ActivityHandle activityHandle= activityModel.QueryActivityHandleByPlanId(planId);
		if (activityHandle!=null) {
			result=activityHandle.CreateActivityMission(mission);	
		}else {
			result=bllImpl.CreateMission(mission);
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午08:57:25
	 *函数名：ChangeActivityMission
	 *功能：修改子任务
	 *参数：@param mission
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChangeActivityMission(List<Mission> mission){
		boolean result=false;
		int planId=mission.get(0).getPlanId();
		ActivityHandle activityHandle= activityModel.QueryActivityHandleByPlanId(planId);
		if (activityHandle!=null) {
			result=activityHandle.CreateActivityMission(mission);	
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午09:12:18
	 *函数名：queryActivityByOrganizeId
	 *功能：查询组织活动
	 *参数：@param organizeId
	 *参数：@return 
	 *返回值：List<Activity>
	 */
	public List<Activity> QueryAllActivityByOrganizationId(int organizationId){
		List<Activity> activities=bllImpl.QueryAllActivityByOrganizationId(organizationId);
		return activities;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午09:21:05
	 *函数名：QueryActivityDetail
	 *功能：通过活动ID查询活动详情
	 *参数：@param activity
	 *参数：@return 
	 *返回值：Activity
	 */
	public Activity QueryActivityDetail(int activityId){
		Activity activity=null;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			activity=activityHandle.toActivity();
		}else {
			activity=bllImpl.QueryActivityDetail(activityId);
		}
		return activity;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午09:51:17
	 *函数名：QueryPlanByActivityId
	 *功能：根据活动ID查询活动任务方案
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：Plan
	 */
	public Plan QueryPlanByActivityId(int activityId){
		Plan plan=null;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			plan=activityHandle.getPlan();
		}else {
			plan=bllImpl.QueryPlanByActivityId(activityId);
		}
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
	public List<Mission> QueryMissionByPlanId(int PlanId){
		List<Mission> missions=null;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleByPlanId(PlanId);
		if (activityHandle!=null) {
			missions=activityHandle.getPlanHandle().getmisMissions();
		}else {
			missions=bllImpl.QueryMissionByPlanId(PlanId);
		}
		return missions;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午10:14:18
	 *函数名：QueryParticipantsByActivityId
	 *功能：根据活动Id查询活动参与人员
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：List<Participants>
	 */
	public List<Participants> QueryParticipantsByActivityId(int activityId){
		List<Participants> participants=null;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			participants=activityHandle.getActivityPersonnelHandle().getParticipantsHandles();
		}else {
			participants=bllImpl.QueryParticipantsByActivityId(activityId);
		}
		return participants;
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午10:32:30
	 *函数名：QueryEnterHandlesByActivityId
	 *功能：根据活动Id查询活动报名人员
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：List<Participants>
	 */
	public List<Participants> QueryEnterHandlesByActivityId(int activityId){
		List<Participants> participants=null;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			participants=activityHandle.getActivityPersonnelHandle().getEnterHandles();
			
		}
		return participants;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午10:50:58
	 *函数名：CreateActivity
	 *功能：创建活动意向
	 *参数：@param activity
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateActivity(Activity activity) {
		boolean result=activityModel.AddActivity(activity);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午01:45:11
	 *函数名：DeleteActivity
	 *功能：删除活动
	 *参数： activityId
	 *返回值：void
	 */
	public boolean DeleteActivity(int activityId){
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		boolean result=false;
		if (activityHandle!=null) {
			result=activityHandle.deleteActivity();
			activityModel.RemoveAvtivity(activityId);
		}
		return result;
		
	}
	
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午10:57:23
	 *函数名：SubmitScheme
	 *功能：提交策划方案
	 *参数：@param activityId
	 *参数：@param activityName
	 *参数：@param activityStartTime
	 *参数：@param activityEndTime
	 *参数：@param activityAddress
	 *参数：@param activityFileUrl
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SubmitScheme(int activityId,String activityName,String activityStartTime,String activityEndTime,String activityAddress,String activityFileUrl){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			result=activityHandle.SubmitScheme(activityName, activityStartTime, activityEndTime, activityAddress, activityFileUrl);
		}
		return result;
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午11:03:28
	 *函数名：ChangeScheme
	 *功能：修改策划
	 *参数：@param activityId
	 *参数：@param activityName
	 *参数：@param activityStartTime
	 *参数：@param activityEndTime
	 *参数：@param activityAddress
	 *参数：@param activityFileUrl
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChangeScheme(int activityId,String activityName,String activityStartTime,String activityEndTime,String activityAddress,String activityFileUrl){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			result=activityHandle.ChangeScheme(activityName, activityStartTime, activityEndTime, activityAddress, activityFileUrl);
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午11:07:11
	 *函数名：examineScheme
	 *功能：审核策划
	 *参数：@param activityId
	 *参数：@param examineType
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ExamineScheme(int activityId,int examineType){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			result=activityHandle.examineScheme(examineType);
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午11:16:29
	 *函数名：examinePlan
	 *功能：审核任务方案
	 *参数：@param planId
	 *参数：@param examineType
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ExaminePlan(int planId,int examineType){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleByPlanId(planId);
		if (activityHandle!=null) {
			result=activityHandle.examinePlan(examineType);
		}
		return result;
	}

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20上午11:52:29
	 *函数名：ChangeActivityToResult
	 *功能：进入活动总结
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChangeActivityToResult(int activityId){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			result=activityHandle.ToResult();
		}
		return result;
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
	public boolean SumbitActivityMissionResult(int planId,int missionId,String missionResult){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleByPlanId(planId);
	
		if (activityHandle!=null) {
			result=activityHandle.SumbitActivityMissionResult(missionId, missionResult);
		}else {
			result=bllImpl.SumbitMissionResult(missionId, missionResult);
		}
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18上午10:50:04
	 *函数名：SubmitActivityPlanResult
	 *功能：提交活动总结
	 *参数：@param missionResult
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SubmitActivityPlanResult(int activityId,String activityResult){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			result=activityHandle.SubmitActivityPlanResult(activityResult);
			activityModel.RemoveAvtivity(activityHandle.getActivityId());
		}
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午03:56:58
	 *函数名：changePlotterId
	 *功能：改变活动策划人
	 *参数：@param PlotterId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChangePlotterId(int activityId,int PlotterId){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			result=activityHandle.changePlotterId(PlotterId);
		}
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-20下午07:09:49
	 *函数名：changePlanerId
	 *功能：改变任务方案制定人
	 *参数：@param activityId
	 *参数：@param plannerId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean ChangePlanerId(int activityId,int plannerId){
		boolean result=false;
		ActivityHandle activityHandle=activityModel.QueryActivityHandleById(activityId);
		if (activityHandle!=null) {
			result=activityHandle.changePlanerId(plannerId);
		}
		return result;
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
		Economics economics=bllImpl.QueryEconomicsByBelong(economicsBelongType, economicsBelongId);
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
		boolean result=bllImpl.UpdateEconomicsSum(economicsId, economicsSum);
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
		List<Economicsrecord> economicsrecords=bllImpl.QueryEconomicsrecordsByEconomicsId(economicsId);
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
		boolean result=bllImpl.CreateEconomicscord(economicsrecord);
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
		List<Equipment> equipments=bllImpl.QueryEquipmentByBelong(equipmentBelongType, equipmentBelongId);
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
		Equipment equipment=bllImpl.QueryEquipmentById(equipmentId);
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
		boolean result=bllImpl.SaveEquipment(equipment);
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
		boolean result=bllImpl.UpdateEquipment(equipment);
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
		boolean result=bllImpl.DeleteEquipment(equipmentId);
	
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
		List<Equipmentrecord> equipmentrecords=bllImpl.QueryEquipmentrecordsByEquipmentId(equipmentId);
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
		boolean result=bllImpl.CreateEquipmentrecord(equipmentrecord);
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
		boolean result=bllImpl.SaveNotice(notice);
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
		boolean result=bllImpl.DeleteNotice(noticeId);
	
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-21上午11:07:39
	 *函数名：QueryPeopleChats
	 *功能：查询用户间的聊天
	 *参数：@param CreateId
	 *参数：@param ReciverId
	 *参数：@return 
	 *返回值：List<Chat>
	 */
	public List<Chat> QueryPeopleChats(int CreateId,int ReciverId){
		List<Chat> chats=chatModel.QueryPeopleChats(CreateId, ReciverId);
		return chats;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-21上午11:11:58
	 *函数名：QueryManyPeopleChats
	 *功能：查询群聊
	 *参数：@param ReciverId
	 *参数：@return 
	 *返回值：List<Chat>
	 */
	public List<Chat> QueryManyPeopleChats(int ReciverId){
		List<Chat> chats=chatModel.QueryManyPeopleChats(ReciverId);
	
		return chats;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-21下午02:45:55
	 *函数名：QueryPeopleNewChats
	 *功能：查询有无最新聊天消息，返回1,2,3,4的发送者Id
	 *参数：@param ReciverId
	 *参数：@return 
	 *返回值：String
	 */
	public String QueryPeopleNewChats(int ReciverId){
		String createrIds=chatModel.QueryPeopleNewChats(ReciverId);
		return createrIds;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-21下午02:52:16
	 *函数名：SendChat
	 *功能：发送聊天消息
	 *参数：@param chat
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendChat(Chat chat){
		boolean result=chatModel.SendChat(chat);
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
		 User user=bllImpl.QueryUserById(userId);
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
		 boolean result=bllImpl.UpdateUser(user);
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
		 HashMap<String, Object> hashMap=bllImpl.QueryUserPart(UserId);
		 return hashMap; 
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
		 boolean result=bllImpl.ChangeGradeDatum(gradeId, gradeContent, gradePic);
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
		 List<HashMap<String, Object>> friends=bllImpl.QueryFriendsByUserId(userId);
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
		List<User> users=bllImpl.SearchUser(userName);
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
		List<HashMap<String, Object>> missions = bllImpl.QueryMissionBymissionExecutorId(missionExecutorId);
		return missions;
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
		boolean result=bllImpl.UpdateDepartment(departmentId, departmentIntroduction, departmentPic);
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
		boolean result=bllImpl.UpdateOrganzation(organizationId, organizationIntroduction, organizationPic);
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
		Map<String, Object> result=bllImpl.Login(userroll,password);
		return result;
		
	};
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
		boolean result = bllImpl.DeleteFriend(userId,friendId);
		return result;
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
		List<HashMap<String, Object>> maps=bllImpl.QueryCorporationMembers(corporationId);
		return maps;
	}
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
		File file=bllImpl.queryFileByBelong(fileType, fileBelongId);
		return file;
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
		List<HashMap<String, Object>> maps=bllImpl.QueryActivityByUserparts(userId);
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
		List<HashMap<String, Object>> maps=bllImpl.queryAllUserName();
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
		 boolean result=bllImpl.DeletePlan(PlanId);
		 return result;
	 }
	 /**
		 * 
		 *作者：movie
		 *时间：2015-12-27下午04:13:45
		 *函数名：queryapplyfriend
		 *功能：查找用户的好友申请
		 *参数：@param userId
		 *参数：@return 
		 *返回值：List<Friend>
		 */
	public List<Friend> queryApplyFriend(int userId) {
		List<Friend> friends=friendModle.queryApplyFriend(userId);
		return friends;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-27下午04:16:07
	 *函数名：applyFriend
	 *功能：发起好友申请
	 *参数：@param friend
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean applyFriend(Friend friend){
		boolean result=friendModle.applyFriend(friend);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-27下午04:41:27
	 *函数名：tobeFriend
	 *功能：成为好友
	 *参数：@param userId
	 *参数：@param friendId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean tobeFriend(int userId,int friendId){
		boolean result=friendModle.tobeFriend(userId,friendId);
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-27下午04:54:18
	 *函数名：refuseTobeFriend
	 *功能：拒绝 成为好友
	 *参数：@param userId
	 *参数：@param friendId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean refuseTobeFriend(int userId,int friendId){
		boolean result=friendModle.refuseTobeFriend(userId, friendId);
		return result;
	}
}
