package com.Dao;

import java.util.HashMap;
import java.util.List;

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
import com.Entity.Grade;
import com.Entity.Mission;
import com.Entity.Notice;
import com.Entity.Organization;
import com.Entity.Participants;
import com.Entity.Plan;
import com.Entity.User;

public interface IDaoFrame {
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午07:19:53
	 *函数名：QueryActivestageByActivityId
	 *功能：根据活动Id查询活动阶段
	 *参数：@param activityid
	 *返回值：List<Activestage>
	 */
	public List<Activestage> QueryActivestageByActivityId(int activityid);
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午08:58:28
	 *函数名：CreateActivestage
	 *功能：创建活动阶段
	 *参数：@param activestage
	 *返回值：boolean
	 */
	public boolean CreateActivestage(Activestage activestage);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午04:26:48
	 *函数名：CreateActivity
	 *功能：创建活动
	 *参数：@param activity
	 *返回值：int
	 */
	public int CreateActivity(Activity activity);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午04:32:50
	 *函数名：UpdateActivity
	 *功能：更新活动
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateActivity(Activity activity);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午01:43:23
	 *函数名：DeleteActivity
	 *功能：删除活动
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteActivity(int activityId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午05:09:39
	 *函数名：CreateScheme
	 *功能：创建更新策划
	 *参数：@param activityId
	 *参数：@param activityName
	 *参数：@param activityStartTime
	 *参数：@param activityEndTime
	 *参数：@param activityAddress
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateScheme(int activityId,String activityName,String activityStartTime,String activityEndTime,String activityAddress);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午05:13:11
	 *函数名：UpdateSctivityState
	 *功能：跟新活动状态
	 *参数：@param activityId
	 *参数：@param activityState
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdateActivityState(int activityId,int activityState);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午05:13:11
	 *函数名：UpdatePlotter
	 *功能：修改活动策划人
	 *参数：@param activityId
	 *参数：@param plotterId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdatePlotter(int activityId,int plotterId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午05:13:11
	 *函数名：UpdatePlanner
	 *功能：修改任务方案制定人
	 *参数：@param activityId
	 *参数：@param plotterId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean UpdatePlanner(int activityId,int plannerId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午05:13:11
	 *函数名：SubmitActivityResult
	 *功能：提交活动总结
	 *参数：@param activityId
	 *参数：@param activityResult
	 *返回值：boolean
	 */
	public boolean SubmitActivityResult(int activityId,String activityResult);
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryHotActivity
	  *功能：查询进行的活动
	  *参数：
	  *返回值：List<Activity>
	  */
	public List<Activity> QueryHotActivity();
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryAllActivityBulletin
	  *功能：查询所有活动布告
	  *参数：
	  *返回值：List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>> QueryAllActivityBulletin();
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：SearchActivitBulletin
	  *功能：搜索活动布告
	  *参数：
	  *返回值：List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>>SearchActivityBulletin(String activityname,String activityaddress);
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryActivityBulletinByOrganizationId
	  *功能：查询组织活动布告
	  *参数：
	  *返回值：List<Activity>
	  */
	public List<HashMap<String, Object>> QueryActivityBulletinByOrganizationId(int organizationid);
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryActivityByOrganizationId
	  *功能：查询组织所有活动
	  *参数：
	  *返回值：List<Activity>
	  */
	public List<Activity> QueryAllActivityByOrganizationId(int organizationid);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午03:42:02
	 *函数名：QueryActivityById
	 *功能：根据活动ID查询活动
	 *参数：@param activityId
	 *参数：@return 
	 *返回值：Activity
	 */
	public Activity QueryActivityById(int activityId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午01:05:59
	 *函数名：CreateComment
	 *功能：创建评论
	 *参数：@param comment
	 *返回值：boolean
	 */
	public boolean CreateComment(Comment comment);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午01:06:23
	 *函数名：queryCommentsByNoticeId
	 *功能：根据公告ID查询该公告的评论
	 *参数：@param noticeid
	 *参数：@return 
	 *返回值：List<Comment>
	 */
	public List<Comment> queryCommentsByNoticeId(int noticeid);
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午01:06:23
	 *函数名：queryCommentsByNoticeId
	 *功能：根据公告ID删除该公告的评论
	 *参数：@param noticeid
	 *参数：@return 
	 *返回值：List<Comment>
	 */
	public boolean DeleteCommentsByNoticeId(int noticeid);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午01:27:25
	 *函数名：DeleteComment
	 *功能：通过评论Id删除评论
	 *参数：@param commentid
	 *返回值：boolean
	 */
	public boolean DeleteCommentById(int commentid);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午02:20:05
	 *函数名：QueryCommentsByBelong
	 *功能：查询组织或社团最新公告
	 *参数：@param noticeBelongType
	 *参数：@param noticeBelongId
	 *返回值：List<Comment>
	 */
	public List<Comment> QueryCommentsByBelong(int noticeBelongType,int noticeBelongId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午12:48:34
	 *函数名：QueryCorporationById
	 *功能：根据ID查询社团详情
	 *参数：@param Corporationid
	 *返回值：Organization
	 */
	public Corporation QueryCorporationById(int corporationid);
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryHotCorporation
	  *功能：查询热门社团
	  *参数：
	  *返回值：List<Corporation>
	  */
	public List<Corporation> QueryHotCorporation();
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryAllCorporation
	  *功能：查询所有社团
	  *参数：
	  *返回值：List<Corporation>
	  */
	public List<Corporation>  QueryAllCorporation();
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：SearchCorporation
	  *功能：搜索社团
	  *参数：
	  *返回值：List<Corporation>
	  */
	public List<Corporation> SearchCorporation(String corporationname);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午01:48:04
	 *函数名：QueryDepartmentById
	 *功能：根据ID查询部门详情
	 *参数：@param departmentid
	 *返回值：Department
	 */
	public Department QueryDepartmentById(int departmentid);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午02:27:08
	 *函数名：queryDepartmentsByorganizationId
	 *功能：根据组织ID查询部门列表
	 *参数：@param organizationId 
	 *返回值：List<Department>
	 */
	public List<Department> queryDepartmentsByorganizationId(int organizationId);
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
	public boolean UpdateDepartment(int departmentId,String departmentIntroduction,String departmentPic);
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
	public Economics QueryEconomicsByBelong(int economicsBelongType,int economicsBelongId);
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
	public boolean UpdateEconomicsSum(int economicsId,float economicsSum);
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
	public List<Economicsrecord> QueryEconomicsrecordsByEconomicsId(int economicsId);
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
	public boolean CreateEconomicscord(Economicsrecord economicsrecord);
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
	public List<Equipment> QueryEquipmentByBelong(int equipmentBelongType,int equipmentBelongId);
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
	public Equipment QueryEquipmentById(int equipmentId);
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
	public boolean SaveEquipment(Equipment equipment);
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
	public boolean UpdateEquipment(Equipment equipment);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午10:28:13
	 *函数名：DeleteEquipment
	 *功能：根据主键删除器材
	 *参数：@param equipmentId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteEquipment(int equipmentId);
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
	public List<Equipmentrecord> QueryEquipmentrecordsByEquipmentId(int equipmentId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午10:32:19
	 *函数名：DeleteEquipmentrecordByEquipmentId
	 *功能：根据器材ID删除器材记录
	 *参数：@param equipmentId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteEquipmentrecordByEquipmentId(int equipmentId);
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
	public boolean CreateEquipmentrecord(Equipmentrecord equipmentrecord);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午04:42:27
	 *函数名：CreateFile
	 *功能：创建文档
	 *参数：@param file
	 *参数：@return 
	 *返回值：boolean
	 */
	public int CreateFile(File file);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午04:46:39
	 *函数名：DeleteFile
	 *功能：删除文档
	 *参数：@param fileId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteFile(int fileId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午11:14:58
	 *函数名：queryFriendsByUserId
	 *功能：根据用户ID查询好友
	 *参数：@param userId
	 *参数：@return 
	 *返回值：List<Friend>
	 */
	public List<HashMap<String, Object>> queryFriendsByUserId(int userId);
	
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
	public boolean DeleteFriend(int userId,int friendId);

	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午02:03:13
	 *函数名：QueryGradeByOrganizationId
	 *功能：根据所属ID和所属类型查询所有成员
	 *参数：@param gradeBelongType
	 *参数：@param gradeBelongId 
	 *返回值：List<Grade>
	 */
	public List<Grade> QueryGradeByBelong(int gradeBelongType,int gradeBelongId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午02:03:13
	 *函数名：QueryGradeByOrganizationId
	 *功能：根据所属ID和所属类型,和等级级别查询成员
	 *参数：@param gradeBelongType
	 *参数：@param gradeBelongId 
	 *返回值：List<Grade>
	 */
	public List<Grade> QueryGradeByGrade(int gradeBelongType,int gradeBelongId,int userGrade);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午02:44:47
	 *函数名：ChangeGrade
	 *功能：修改人员职位
	 *参数：@param grade
	 *返回值：boolean
	 */
	public boolean ChangeGrade(int gradeId,int userGrade,int gradeBelongType,int gradeBelongId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午02:44:47
	 *函数名：CreateGrade
	 *功能：加入成员
	 *参数：@param grade
	 *返回值：boolean
	 */
	public boolean CreateGrade(Grade grade);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午01:27:25
	 *函数名：DeleteGradeById
	 *功能：删除成员
	 *参数：@param gradeid
	 *返回值：boolean
	 */
	public boolean DeleteGradeById(int gradeid);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-15上午11:06:19
	 *函数名：QueryGradeByUserId
	 *功能：根据用户Id查询用户等级列表
	 *参数：@param userId
	 *参数：@return 
	 *返回值：List<Grade>
	 */
	public List<Grade> QueryGradeByUserId(int userId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午03:24:20
	 *函数名：CreateMission
	 *功能：批量增加子任务
	 *参数：@param missions
	 *返回值：boolean
	 */
	public boolean CreateMission(List<Mission> missions);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午06:21:35
	 *函数名：DeleteMissionByPlanId
	 *功能：根据任务方案id删除子任务
	 *参数：@param PlanId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteMissionByPlanId(int PlanId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午06:21:35
	 *函数名：DeleteMission
	 *功能：根据主键id删除子任务
	 *参数：@param missionid
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteMission(int missionid);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午03:53:11
	 *函数名：queryMissionsByPlanId
	 *功能：根据任务方案ID查询子任务列表
	 *参数：@param planId 
	 *返回值：Plan
	 */
	public List<Mission> queryMissionsByPlanId(int planId);
	/**作者：movie
	 *时间：2015-10-14下午01:48:04
	 *函数名：QueryMissionById
	 *功能：根据ID子任务详情
	 *参数：@param missionId
	 *返回值：Mission
	 */
	public Mission QueryMissionById(int missionId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午06:42:29
	 *函数名：SubmitMissionResult
	 *功能：提交任务总结
	 *参数：@param missionId
	 *参数：@param missionResult
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SubmitMissionResult(int missionId,String missionResult);
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryHotNotice
	  *功能：查询热门公告
	  *参数：
	  *返回值：List<Notice>
	  */
	public List<Notice> QueryHotNotice(int noticeBelongType,int noticeBelongId);
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryAllNotice
	  *功能：查询所有活动
	  *参数：
	  *返回值：List<Notice>
	  */
	public List<Notice> QueryAllNotice();
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午09:30:14
	 *函数名：QueryNoticeDetailById
	 *功能：根据ID获取公告详情
	 *参数：@param noticeid
	 *返回值：Notice
	 */
	public Notice QueryNoticeDetailById(int noticeid);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午01:40:33
	 *函数名：SearchNotice
	 *功能：根据公告名搜索公告
	 *参数：@param noticetitle
	 *返回值：List<Notice>
	 */
	public List<Notice> SearchNotice(String noticetitle);
	/**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryNoticeByBelong
	  *功能：根据所属查询公告 noticeBelongId
	  *参数：noticeBelongType 
	  *返回值：List<Notice>
	  */
	public List<Notice> QueryNoticeByBelong(int noticeBelongType,int noticeBelongId);
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
	public boolean SaveNotice(Notice notice);
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
	public boolean DeleteNotice(int noticeId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午12:48:34
	 *函数名：QueryOrganizationById
	 *功能：根据ID查询组织
	 *参数：@param organizationid
	 *返回值：Organization
	 */
	public Organization QueryOrganizationById(int organizationid);
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
	public boolean UpdateOrganzation(int organizationId,String organizationIntroduction,String organizationPic);
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午08:42:43
	 *函数名：SaveParticipants
	 *功能：批量保存活动人员
	 *参数：@param participants
	 *返回值：boolean
	 */
	 public boolean SaveParticipants(List<Participants> participants);
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-14下午04:23:08
	  *函数名：QueryParticipantsByActivityId
	  *功能：根据活动ID查询活动参与人员
	  *参数：@param activityId
	  *返回值：List<Participants>
	  */
	 public List<Participants> QueryParticipantsByActivityId(int activityId);
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-14下午03:53:11
	  *函数名：QueryPlanByActivityId
	  *功能：根据活动ID查询任务方案
	  *参数：@param activityId
	  *参数：@return 
	  *返回值：Plan
	  */
	 public Plan QueryPlanByActivityId(int activityId);
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
	 public List<Plan> QueryPlanByPlanCreatorId(int planCreatorId);
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-14下午06:08:11
	  *函数名：CreatePlan
	  *功能：新建任务方案
	  *参数：@param plan
	  *参数：@return 
	  *返回值：int
	  */
	 public int CreatePlan(Plan plan);
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
	 public boolean DeletePlan(int PlanId);
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-14下午01:16:32
	  *函数名：QueryUserById
	  *功能：根据用户ID查询用户详情
	  *参数：@param userId
	  *返回值：User
	  */
	 public User QueryUserById(int userId);
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-15上午11:01:10
	  *函数名：UpdateUser
	  *功能：修改资料
	  *参数：@param user
	  *参数：@return 
	  *返回值：boolean
	  */
	 public boolean UpdateUser(User user);

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
	public boolean changeGradeDatum(int gradeId,String gradeContent,String gradePic);
	
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
	 public List<User> SearchUser(String userName);
	 /**
		 * 
		 *作者：movie
		 *时间：2015-11-24下午01:12:03
		 *函数名：QueryUserByUserRoll
		 *功能：根据学号查找用户
		 *参数：@param userroll
		 *参数：@return 
		 *返回值：User
		 */
		public User QueryUserByUserRoll(String userroll);
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
	public List<Mission> QueryMissionBymissionExecutorId(int missionExecutorId) ;
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
	public File queryFileByBelong(int fileType,int fileBelongId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-14下午03:29:59
	 *函数名：QueryActivityNotFinished
	 *功能：查询未完结的活动
	 *参数：@return 
	 *返回值：List<Activity>
	 */
	public List<Activity> QueryActivityNotFinished();
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-16下午08:33:14
	 *函数名：QueryPlanById
	 *功能：根据ID查询任务方案
	 *参数：@param planId
	 *参数：@return 
	 *返回值：Plan
	 */
	public Plan QueryPlanById(int planId);
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
	public List<HashMap<String, Object>> QueryActivityByUserparts(int userId);
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-24下午03:56:15
	 *函数名：queryAllUserName
	 *功能：查询所有用户名称
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> queryAllUserName();
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-27下午04:29:17
	 *函数名：CreateFriend
	 *功能：添加好友
	 *参数：@param friend
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean CreateFriend(Friend friend);
}
