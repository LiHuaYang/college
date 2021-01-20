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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����07:19:53
	 *��������QueryActivestageByActivityId
	 *���ܣ����ݻId��ѯ��׶�
	 *������@param activityid
	 *����ֵ��List<Activestage>
	 */
	public List<Activestage> QueryActivestageByActivityId(int activityid);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����08:58:28
	 *��������CreateActivestage
	 *���ܣ�������׶�
	 *������@param activestage
	 *����ֵ��boolean
	 */
	public boolean CreateActivestage(Activestage activestage);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:26:48
	 *��������CreateActivity
	 *���ܣ������
	 *������@param activity
	 *����ֵ��int
	 */
	public int CreateActivity(Activity activity);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:32:50
	 *��������UpdateActivity
	 *���ܣ����»
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateActivity(Activity activity);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����01:43:23
	 *��������DeleteActivity
	 *���ܣ�ɾ���
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteActivity(int activityId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:09:39
	 *��������CreateScheme
	 *���ܣ��������²߻�
	 *������@param activityId
	 *������@param activityName
	 *������@param activityStartTime
	 *������@param activityEndTime
	 *������@param activityAddress
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateScheme(int activityId,String activityName,String activityStartTime,String activityEndTime,String activityAddress);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:13:11
	 *��������UpdateSctivityState
	 *���ܣ����»״̬
	 *������@param activityId
	 *������@param activityState
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateActivityState(int activityId,int activityState);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:13:11
	 *��������UpdatePlotter
	 *���ܣ��޸Ļ�߻���
	 *������@param activityId
	 *������@param plotterId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdatePlotter(int activityId,int plotterId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:13:11
	 *��������UpdatePlanner
	 *���ܣ��޸����񷽰��ƶ���
	 *������@param activityId
	 *������@param plotterId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdatePlanner(int activityId,int plannerId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:13:11
	 *��������SubmitActivityResult
	 *���ܣ��ύ��ܽ�
	 *������@param activityId
	 *������@param activityResult
	 *����ֵ��boolean
	 */
	public boolean SubmitActivityResult(int activityId,String activityResult);
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryHotActivity
	  *���ܣ���ѯ���еĻ
	  *������
	  *����ֵ��List<Activity>
	  */
	public List<Activity> QueryHotActivity();
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllActivityBulletin
	  *���ܣ���ѯ���л����
	  *������
	  *����ֵ��List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>> QueryAllActivityBulletin();
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������SearchActivitBulletin
	  *���ܣ����������
	  *������
	  *����ֵ��List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>>SearchActivityBulletin(String activityname,String activityaddress);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryActivityBulletinByOrganizationId
	  *���ܣ���ѯ��֯�����
	  *������
	  *����ֵ��List<Activity>
	  */
	public List<HashMap<String, Object>> QueryActivityBulletinByOrganizationId(int organizationid);
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryActivityByOrganizationId
	  *���ܣ���ѯ��֯���л
	  *������
	  *����ֵ��List<Activity>
	  */
	public List<Activity> QueryAllActivityByOrganizationId(int organizationid);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:42:02
	 *��������QueryActivityById
	 *���ܣ����ݻID��ѯ�
	 *������@param activityId
	 *������@return 
	 *����ֵ��Activity
	 */
	public Activity QueryActivityById(int activityId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:05:59
	 *��������CreateComment
	 *���ܣ���������
	 *������@param comment
	 *����ֵ��boolean
	 */
	public boolean CreateComment(Comment comment);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:06:23
	 *��������queryCommentsByNoticeId
	 *���ܣ����ݹ���ID��ѯ�ù��������
	 *������@param noticeid
	 *������@return 
	 *����ֵ��List<Comment>
	 */
	public List<Comment> queryCommentsByNoticeId(int noticeid);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:06:23
	 *��������queryCommentsByNoticeId
	 *���ܣ����ݹ���IDɾ���ù��������
	 *������@param noticeid
	 *������@return 
	 *����ֵ��List<Comment>
	 */
	public boolean DeleteCommentsByNoticeId(int noticeid);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:27:25
	 *��������DeleteComment
	 *���ܣ�ͨ������Idɾ������
	 *������@param commentid
	 *����ֵ��boolean
	 */
	public boolean DeleteCommentById(int commentid);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:20:05
	 *��������QueryCommentsByBelong
	 *���ܣ���ѯ��֯���������¹���
	 *������@param noticeBelongType
	 *������@param noticeBelongId
	 *����ֵ��List<Comment>
	 */
	public List<Comment> QueryCommentsByBelong(int noticeBelongType,int noticeBelongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����12:48:34
	 *��������QueryCorporationById
	 *���ܣ�����ID��ѯ��������
	 *������@param Corporationid
	 *����ֵ��Organization
	 */
	public Corporation QueryCorporationById(int corporationid);
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryHotCorporation
	  *���ܣ���ѯ��������
	  *������
	  *����ֵ��List<Corporation>
	  */
	public List<Corporation> QueryHotCorporation();
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllCorporation
	  *���ܣ���ѯ��������
	  *������
	  *����ֵ��List<Corporation>
	  */
	public List<Corporation>  QueryAllCorporation();
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������SearchCorporation
	  *���ܣ���������
	  *������
	  *����ֵ��List<Corporation>
	  */
	public List<Corporation> SearchCorporation(String corporationname);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:48:04
	 *��������QueryDepartmentById
	 *���ܣ�����ID��ѯ��������
	 *������@param departmentid
	 *����ֵ��Department
	 */
	public Department QueryDepartmentById(int departmentid);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:27:08
	 *��������queryDepartmentsByorganizationId
	 *���ܣ�������֯ID��ѯ�����б�
	 *������@param organizationId 
	 *����ֵ��List<Department>
	 */
	public List<Department> queryDepartmentsByorganizationId(int organizationId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����11:20:09
	 *��������UpdateDepartment
	 *���ܣ��޸Ĳ�����Ϣ
	 *������@param department
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateDepartment(int departmentId,String departmentIntroduction,String departmentPic);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:32:22
	 *��������QueryEconomicsByBelong
	 *���ܣ������������ͺ�����Id��ѯ�ʽ�����
	 *������@param economicsBelongType
	 *������@param economicsBelongId
	 *������@return 
	 *����ֵ��Economics
	 */
	public Economics QueryEconomicsByBelong(int economicsBelongType,int economicsBelongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:59:32
	 *��������UpdateEconomicsSum
	 *���ܣ������ʽ�����
	 *������@param economicsId
	 *������@param economicsSum
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateEconomicsSum(int economicsId,float economicsSum);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:37:57
	 *��������QueryEconomicsrecordsByEconomicsId
	 *���ܣ������ʽ�ID��ѯ�ʽ��¼
	 *������@param economicsId
	 *������@return 
	 *����ֵ��List<Economicsrecord>
	 */
	public List<Economicsrecord> QueryEconomicsrecordsByEconomicsId(int economicsId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:57:17
	 *��������CreateEconomicscord
	 *���ܣ������ʽ��¼
	 *������@param economicsrecord
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateEconomicscord(Economicsrecord economicsrecord);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:32:22
	 *��������QueryEquipmentByBelong
	 *���ܣ������������ͺ�����Id��ѯ�����б�
	 *������@param equipmentBelongType
	 *������@param equipmentBelongId
	 *������@return 
	 *����ֵ��Equipment
	 */
	public List<Equipment> QueryEquipmentByBelong(int equipmentBelongType,int equipmentBelongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:19:55
	 *��������QueryEquipmentById
	 *���ܣ���������Id��ѯ��������
	 *������@param equipmentId
	 *������@return 
	 *����ֵ��Equipment
	 */
	public Equipment QueryEquipmentById(int equipmentId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:23:12
	 *��������SaveEquipment
	 *���ܣ��½�����
	 *������@param equipment
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SaveEquipment(Equipment equipment);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:23:12
	 *��������SaveEquipment
	 *���ܣ��޸�����
	 *������@param equipment
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateEquipment(Equipment equipment);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:28:13
	 *��������DeleteEquipment
	 *���ܣ���������ɾ������
	 *������@param equipmentId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteEquipment(int equipmentId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����09:37:57
	 *��������QueryEquipmentrecordsByEquipmentId
	 *���ܣ���������ID��ѯ���ļ�¼
	 *������@param equipmentId
	 *������@return 
	 *����ֵ��List<Economicsrecord>
	 */
	public List<Equipmentrecord> QueryEquipmentrecordsByEquipmentId(int equipmentId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:32:19
	 *��������DeleteEquipmentrecordByEquipmentId
	 *���ܣ���������IDɾ�����ļ�¼
	 *������@param equipmentId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteEquipmentrecordByEquipmentId(int equipmentId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:35:24
	 *��������CreateEquipmentrecord
	 *���ܣ��������ļ�¼
	 *������@param equipmentrecord
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateEquipmentrecord(Equipmentrecord equipmentrecord);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:42:27
	 *��������CreateFile
	 *���ܣ������ĵ�
	 *������@param file
	 *������@return 
	 *����ֵ��boolean
	 */
	public int CreateFile(File file);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:46:39
	 *��������DeleteFile
	 *���ܣ�ɾ���ĵ�
	 *������@param fileId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteFile(int fileId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����11:14:58
	 *��������queryFriendsByUserId
	 *���ܣ������û�ID��ѯ����
	 *������@param userId
	 *������@return 
	 *����ֵ��List<Friend>
	 */
	public List<HashMap<String, Object>> queryFriendsByUserId(int userId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����01:02:40
	 *��������DeleteFriend
	 *���ܣ�ɾ������
	 *������@param friendRelationId
	 *������@return 
	 *����ֵ��boolean
	 */	
	public boolean DeleteFriend(int userId,int friendId);

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:03:13
	 *��������QueryGradeByOrganizationId
	 *���ܣ���������ID���������Ͳ�ѯ���г�Ա
	 *������@param gradeBelongType
	 *������@param gradeBelongId 
	 *����ֵ��List<Grade>
	 */
	public List<Grade> QueryGradeByBelong(int gradeBelongType,int gradeBelongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:03:13
	 *��������QueryGradeByOrganizationId
	 *���ܣ���������ID����������,�͵ȼ������ѯ��Ա
	 *������@param gradeBelongType
	 *������@param gradeBelongId 
	 *����ֵ��List<Grade>
	 */
	public List<Grade> QueryGradeByGrade(int gradeBelongType,int gradeBelongId,int userGrade);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:44:47
	 *��������ChangeGrade
	 *���ܣ��޸���Աְλ
	 *������@param grade
	 *����ֵ��boolean
	 */
	public boolean ChangeGrade(int gradeId,int userGrade,int gradeBelongType,int gradeBelongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:44:47
	 *��������CreateGrade
	 *���ܣ������Ա
	 *������@param grade
	 *����ֵ��boolean
	 */
	public boolean CreateGrade(Grade grade);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:27:25
	 *��������DeleteGradeById
	 *���ܣ�ɾ����Ա
	 *������@param gradeid
	 *����ֵ��boolean
	 */
	public boolean DeleteGradeById(int gradeid);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����11:06:19
	 *��������QueryGradeByUserId
	 *���ܣ������û�Id��ѯ�û��ȼ��б�
	 *������@param userId
	 *������@return 
	 *����ֵ��List<Grade>
	 */
	public List<Grade> QueryGradeByUserId(int userId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:24:20
	 *��������CreateMission
	 *���ܣ���������������
	 *������@param missions
	 *����ֵ��boolean
	 */
	public boolean CreateMission(List<Mission> missions);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����06:21:35
	 *��������DeleteMissionByPlanId
	 *���ܣ��������񷽰�idɾ��������
	 *������@param PlanId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteMissionByPlanId(int PlanId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����06:21:35
	 *��������DeleteMission
	 *���ܣ���������idɾ��������
	 *������@param missionid
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteMission(int missionid);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:53:11
	 *��������queryMissionsByPlanId
	 *���ܣ��������񷽰�ID��ѯ�������б�
	 *������@param planId 
	 *����ֵ��Plan
	 */
	public List<Mission> queryMissionsByPlanId(int planId);
	/**���ߣ�movie
	 *ʱ�䣺2015-10-14����01:48:04
	 *��������QueryMissionById
	 *���ܣ�����ID����������
	 *������@param missionId
	 *����ֵ��Mission
	 */
	public Mission QueryMissionById(int missionId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����06:42:29
	 *��������SubmitMissionResult
	 *���ܣ��ύ�����ܽ�
	 *������@param missionId
	 *������@param missionResult
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SubmitMissionResult(int missionId,String missionResult);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryHotNotice
	  *���ܣ���ѯ���Ź���
	  *������
	  *����ֵ��List<Notice>
	  */
	public List<Notice> QueryHotNotice(int noticeBelongType,int noticeBelongId);
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllNotice
	  *���ܣ���ѯ���л
	  *������
	  *����ֵ��List<Notice>
	  */
	public List<Notice> QueryAllNotice();
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����09:30:14
	 *��������QueryNoticeDetailById
	 *���ܣ�����ID��ȡ��������
	 *������@param noticeid
	 *����ֵ��Notice
	 */
	public Notice QueryNoticeDetailById(int noticeid);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:40:33
	 *��������SearchNotice
	 *���ܣ����ݹ�������������
	 *������@param noticetitle
	 *����ֵ��List<Notice>
	 */
	public List<Notice> SearchNotice(String noticetitle);
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryNoticeByBelong
	  *���ܣ�����������ѯ���� noticeBelongId
	  *������noticeBelongType 
	  *����ֵ��List<Notice>
	  */
	public List<Notice> QueryNoticeByBelong(int noticeBelongType,int noticeBelongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:45:11
	 *��������SaveNotice
	 *���ܣ���������
	 *������@param notice
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SaveNotice(Notice notice);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:45:11
	 *��������DeleteNotice
	 *���ܣ�ɾ������
	 *������@param noticeId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteNotice(int noticeId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����12:48:34
	 *��������QueryOrganizationById
	 *���ܣ�����ID��ѯ��֯
	 *������@param organizationid
	 *����ֵ��Organization
	 */
	public Organization QueryOrganizationById(int organizationid);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����11:20:09
	 *��������UpdateOrganzation
	 *���ܣ��޸���֯����
	 *������@param organization
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateOrganzation(int organizationId,String organizationIntroduction,String organizationPic);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����08:42:43
	 *��������SaveParticipants
	 *���ܣ�����������Ա
	 *������@param participants
	 *����ֵ��boolean
	 */
	 public boolean SaveParticipants(List<Participants> participants);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����04:23:08
	  *��������QueryParticipantsByActivityId
	  *���ܣ����ݻID��ѯ�������Ա
	  *������@param activityId
	  *����ֵ��List<Participants>
	  */
	 public List<Participants> QueryParticipantsByActivityId(int activityId);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����03:53:11
	  *��������QueryPlanByActivityId
	  *���ܣ����ݻID��ѯ���񷽰�
	  *������@param activityId
	  *������@return 
	  *����ֵ��Plan
	  */
	 public Plan QueryPlanByActivityId(int activityId);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����03:53:11
	  *��������QueryPlanByPlanCreatorId
	  *���ܣ�������������ID��ѯ���񷽰�
	  *������@param activityId
	  *������@return 
	  *����ֵ��Plan
	  */
	 public List<Plan> QueryPlanByPlanCreatorId(int planCreatorId);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����06:08:11
	  *��������CreatePlan
	  *���ܣ��½����񷽰�
	  *������@param plan
	  *������@return 
	  *����ֵ��int
	  */
	 public int CreatePlan(Plan plan);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����06:17:37
	  *��������DeletePlan
	  *���ܣ�ɾ�����񷽰�
	  *������@param PlanId
	  *������@return 
	  *����ֵ��boolean
	  */
	 public boolean DeletePlan(int PlanId);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����01:16:32
	  *��������QueryUserById
	  *���ܣ������û�ID��ѯ�û�����
	  *������@param userId
	  *����ֵ��User
	  */
	 public User QueryUserById(int userId);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-15����11:01:10
	  *��������UpdateUser
	  *���ܣ��޸�����
	  *������@param user
	  *������@return 
	  *����ֵ��boolean
	  */
	 public boolean UpdateUser(User user);

	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-22����01:42:55
	  *��������changeGradeDatum
	  *���ܣ��޸�ְλ����
	  *������@param gradeId
	  *������@param gradeContent
	  *������@param gradePic
	  *������@return 
	  *����ֵ��boolean
	  */
	public boolean changeGradeDatum(int gradeId,String gradeContent,String gradePic);
	
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-22����02:40:58
	  *��������SearchUser
	  *���ܣ������û�
	  *������@param userName
	  *������@return 
	  *����ֵ��List<User>
	  */
	 public List<User> SearchUser(String userName);
	 /**
		 * 
		 *���ߣ�movie
		 *ʱ�䣺2015-11-24����01:12:03
		 *��������QueryUserByUserRoll
		 *���ܣ�����ѧ�Ų����û�
		 *������@param userroll
		 *������@return 
		 *����ֵ��User
		 */
		public User QueryUserByUserRoll(String userroll);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-22����03:27:49
	  *��������QueryMissionBymissionExecutorId
	  *���ܣ������û���ѯ���յ���������
	  *������@param missionExecutorId
	  *������@return 
	  *����ֵ��List<Mission>
	  */
	public List<Mission> QueryMissionBymissionExecutorId(int missionExecutorId) ;
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����02:32:45
	 *��������queryFileByBelong
	 *���ܣ������ļ����ͺ�������ѯ�ļ�
	 *������@param fileType
	 *������@param fileBelongId
	 *������@return 
	 *����ֵ��File
	 */
	public File queryFileByBelong(int fileType,int fileBelongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����03:29:59
	 *��������QueryActivityNotFinished
	 *���ܣ���ѯδ���Ļ
	 *������@return 
	 *����ֵ��List<Activity>
	 */
	public List<Activity> QueryActivityNotFinished();
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-16����08:33:14
	 *��������QueryPlanById
	 *���ܣ�����ID��ѯ���񷽰�
	 *������@param planId
	 *������@return 
	 *����ֵ��Plan
	 */
	public Plan QueryPlanById(int planId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-21����11:16:01
	 *��������QueryActivityByUserparts
	 *���ܣ���ѯ�û��μӵ����л
	 *������@param userId
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryActivityByUserparts(int userId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-24����03:56:15
	 *��������queryAllUserName
	 *���ܣ���ѯ�����û�����
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> queryAllUserName();
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-27����04:29:17
	 *��������CreateFriend
	 *���ܣ���Ӻ���
	 *������@param friend
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateFriend(Friend friend);
}
