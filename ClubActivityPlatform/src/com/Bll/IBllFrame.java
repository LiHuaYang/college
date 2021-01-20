package com.Bll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Bll.ChatHandle.Chat;
import com.Bll.RegistrationHandle.Registration;
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



public interface IBllFrame {
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����03:38:03
	 *��������
	 *���ܣ������ģ��
	 *������
	 *����ֵ��
	 */
	public void getDateActivityModel();
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����03:04:19
	 *��������QueryHotActivity
	 *���ܣ���ѯ���Ż
	 *������@return 
	 *����ֵ��List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> QueryHotActivity();
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����05:03:24
	 *��������QueryActivestageByActivityId
	 *���ܣ����ݻID��ѯ�����׶�
	 *������@param activityId
	 *������@return 
	 *����ֵ��List<Activestage>
	 */
	public List<Activestage> QueryActivestageByActivityId(int activityId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����06:38:27
	 *��������enterActivity
	 *���ܣ������
	 *������@param participants
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean enterActivity(Participants participants);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����06:43:37
	 *��������QueryActivityEnter
	 *���ܣ��鿴�������Ա
	 *������@param activityId
	 *������@return 
	 *����ֵ��List<Participants>
	 */
	public List<Participants> QueryActivityEnter(int activityId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����06:53:05
	 *��������ChecksActiyityMembers
	 *���ܣ���˻������Ա
	 *������@param participants
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ChecksActiyityMembers(List<Participants> participants);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����06:55:56
	 *��������SubmitActiyityMembers
	 *���ܣ��ύ��Ա��˽��
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SubmitActiyityMembers(int activityId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����07:55:41
	 *��������CreateActivityBulletin
	 *���ܣ����������
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateActivityBulletin(int activityId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����08:01:05
	 *��������CreateActivestage
	 *���ܣ����������׶�
	 *������@param activestage
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateActivestage(Activestage activestage);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:15:05
	 *��������QueryActivityBulletin
	 *���ܣ���ѯ���л����
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryActivityBulletin();
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:15:05
	 *��������QueryActivityBulletin
	 *���ܣ����������
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> SearchActivityBulletin(String activityName,String activitytime,String activityaddress);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:01:25
	 *��������QueryHotNotice
	 *���ܣ���ѯ���Ų���
	 *������@return 
	 *����ֵ��List<Notice>
	 */
	public List<Notice> QueryHotNotice();
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:18:12
	 *��������QueryNoticeDetail
	 *���ܣ���ѯ��������
	 *������@param noticeId
	 *������@return 
	 *����ֵ��HashMap<String,Object>
	 */
	public HashMap<String, Object> QueryNoticeDetail(int noticeId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����09:24:28
	 *��������CreateComment
	 *���ܣ���������
	 *������@param comment
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateComment(Comment comment);

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����09:50:26
	 *��������QueryAllComment
	 *���ܣ���ѯ��������
	 *������@param noticeId
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryAllComment(int noticeId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����09:51:10
	 *��������DeleteComment
	 *���ܣ�ɾ������
	 *������@param commentId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteComment(int commentId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����09:55:44
	 *��������QueryAllNotice
	 *���ܣ���ѯ���й���
	 *������@return 
	 *����ֵ��List<Notice>
	 */
	public List<Notice> QueryAllNotice();

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����09:55:44
	 *��������SearchNotice
	 *���ܣ���������
	 *������@return 
	 *����ֵ��List<Notice>
	 */
	public List<Notice> SearchNotice(String NoticeName,String starttime,String endtime,int noticetype);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����10:58:52
	 *��������QueryHotcorporation
	 *���ܣ���ѯ��������
	 *������@return 
	 *����ֵ��List<Corporation>
	 */
	public List<Corporation> QueryHotcorporation();
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����11:02:38
	 *��������QueryCorporationDetailById
	 *���ܣ���ѯ��������
	 *������@param corporationId
	 *������@return 
	 *����ֵ��Corporation
	 */
	public Corporation QueryCorporationDetailById(int corporationId);
	
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllCorporation
	  *���ܣ���ѯ��������
	  *������
	  *����ֵ��List<Corporation>
	  */
	public List<Corporation> QueryAllCorporation();
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����11:14:35
	 *��������SearchCorporation
	 *���ܣ���������
	 *������@param corporationName
	 *������@return 
	 *����ֵ��List<Corporation>
	 */
	public List<Corporation> SearchCorporation(String corporationName);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����02:05:12
	 *��������QueryOrganizationDetail
	 *���ܣ�������֯ID��ѯ��֯
	 *������@param organizationId
	 *������@return 
	 *����ֵ��Organization
	 */
	public Organization QueryOrganizationDetail(int organizationId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����12:06:33
	 *��������QueryOrganizationMember
	 *���ܣ���ѯ��֯��Ա
	 *������@param organizationId
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryOrganizationMember(int organizationId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����02:36:15
	 *��������QueryOrganizationBulletin
	 *���ܣ���ѯ��֯�����
	 *������@param organizationId
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryOrganizationBulletin(int organizationId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����02:59:03
	 *��������QueryNoticeByBelong
	 *���ܣ���ѯ����ͨ������
	 *������@param noticeBelongType
	 *������@param noticeBelongId
	 *������@return 
	 *����ֵ��List<Notice>
	 */
	public List<Notice> QueryNoticeByBelong(int noticeBelongType,int noticeBelongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����03:05:28
	 *��������queryDepartmentsByorganizationId
	 *���ܣ���ѯ��֯����
	 *������@param organizationId
	 *������@return 
	 *����ֵ��List<Department>
	 */
	public List<Department> QueryDepartmentsByorganizationId(int organizationId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����03:29:02
	 *��������queryDepartmentDetail
	 *���ܣ���ѯ��������
	 *������@param departmentId
	 *������@return 
	 *����ֵ��Department
	 */
	public Department QueryDepartmentDetail(int departmentId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����03:55:10
	 *��������QueryRegistrationByBelong
	 *���ܣ����������鿴������Ա
	 *������@param belongType
	 *������@param belongId
	 *������@return 
	 *����ֵ��List<Registration>
	 */
	public List<Registration> QueryRegistrationByBelong(int belongType,int belongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����04:16:39
	 *��������QueryRegistrationByUser
	 *���ܣ������û�ID��������������Щ������֯
	 *������@param userId
	 *������@return 
	 *����ֵ��List<Registration>
	 */
	public List<Registration> QueryRegistrationByUser(int userId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����04:14:37
	 *��������RefuseRegistration
	 *���ܣ��ܾ�����
	 *������@param belongType
	 *������@param belongId
	 *������@param userId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean RefuseRegistration(int belongType,int belongId,int userId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����03:54:44
	 *��������createRegistration
	 *���ܣ��ύ���벿�Ż���������
	 *������@param userId
	 *������@param userName
	 *������@param belongType
	 *������@param belongId
	 *������@param registrationContent
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateRegistration(int userId,String userName, int belongType,int belongId,String registrationContent);
	
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-19����03:23:07
	  *��������QueryDepartmentMembers
	  *���ܣ���ѯ���ų�Ա
	  *������@param departmentId
	  *������@return 
	  *����ֵ��List<HashMap<String,Object>>
	  */
	public List<HashMap<String, Object>> QueryDepartmentMembers(int departmentId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����04:33:33
	 *��������ChangeGrade
	 *���ܣ��ı�ְλ
	 *������@param gradeId
	 *������@param userGrade
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ChangeGrade(int gradeId,int userGrade,int gradeBelongType,int gradeBelongId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����07:08:47
	 *��������SubmitRegistration
	 *���ܣ���׼�����˼��벿��
	 *������@param belongType
	 *������@param belongId
	 *������@param userId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SubmitRegistration(int belongType,int belongId,int userId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����07:10:34
	 *��������DeleteGradeById
	 *���ܣ�ɾ����Ա
	 *������@param gradeid
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteGradeById(int gradeid);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����07:48:27
	 *��������CreatePlan
	 *���ܣ��������񷽰�
	 *������@param plan
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreatePlan(Plan plan);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����07:48:27
	 *��������UpdatePlan
	 *���ܣ��޸����񷽰�
	 *������@param plan
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdatePlan(Plan plan);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����07:56:04
	 *��������CreateMission
	 *���ܣ�����������������
	 *������@param mission
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateMission(List<Mission> mission);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����08:57:25
	 *��������ChangeActivityMission
	 *���ܣ��޸�������
	 *������@param mission
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ChangeActivityMission(List<Mission> mission);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����09:12:18
	 *��������queryActivityByOrganizeId
	 *���ܣ���ѯ��֯�
	 *������@param organizeId
	 *������@return 
	 *����ֵ��List<Activity>
	 */
	public List<Activity> QueryAllActivityByOrganizationId(int organizationId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����09:21:05
	 *��������QueryActivityDetail
	 *���ܣ�ͨ���ID��ѯ�����
	 *������@param activity
	 *������@return 
	 *����ֵ��Activity
	 */
	public Activity QueryActivityDetail(int activityId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����09:51:17
	 *��������QueryPlanByActivityId
	 *���ܣ����ݻID��ѯ����񷽰�
	 *������@param activityId
	 *������@return 
	 *����ֵ��Plan
	 */
	public Plan QueryPlanByActivityId(int activityId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����10:05:29
	 *��������QueryMissionByPlanId
	 *���ܣ��������񷽰�ID��ѯ������
	 *������@param PlanId
	 *������@return 
	 *����ֵ��List<Mission>
	 */
	public List<Mission> QueryMissionByPlanId(int PlanId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����10:14:18
	 *��������QueryParticipantsByActivityId
	 *���ܣ����ݻId��ѯ�������Ա
	 *������@param activityId
	 *������@return 
	 *����ֵ��List<Participants>
	 */
	public List<Participants> QueryParticipantsByActivityId(int activityId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����10:32:30
	 *��������QueryEnterHandlesByActivityId
	 *���ܣ����ݻId��ѯ�������Ա
	 *������@param activityId
	 *������@return 
	 *����ֵ��List<Participants>
	 */
	public List<Participants> QueryEnterHandlesByActivityId(int activityId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����10:50:58
	 *��������CreateActivity
	 *���ܣ����������
	 *������@param activity
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateActivity(Activity activity) ;
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����01:45:11
	 *��������deleteActivity
	 *���ܣ�ɾ���
	 *������ activityId
	 *����ֵ��void
	 */
	public boolean DeleteActivity(int activityId);
	
	
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����10:57:23
	 *��������SubmitScheme
	 *���ܣ��ύ�߻�����
	 *������@param activityId
	 *������@param activityName
	 *������@param activityStartTime
	 *������@param activityEndTime
	 *������@param activityAddress
	 *������@param activityFileUrl
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SubmitScheme(int activityId,String activityName,String activityStartTime,String activityEndTime,String activityAddress,String activityFileUrl);

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����11:03:28
	 *��������ChangeScheme
	 *���ܣ��޸Ĳ߻�
	 *������@param activityId
	 *������@param activityName
	 *������@param activityStartTime
	 *������@param activityEndTime
	 *������@param activityAddress
	 *������@param activityFileUrl
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ChangeScheme(int activityId,String activityName,String activityStartTime,String activityEndTime,String activityAddress,String activityFileUrl);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����11:07:11
	 *��������examineScheme
	 *���ܣ���˲߻�
	 *������@param activityId
	 *������@param examineType
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ExamineScheme(int activityId,int examineType);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����11:16:29
	 *��������examinePlan
	 *���ܣ�������񷽰�
	 *������@param planId
	 *������@param examineType
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ExaminePlan(int planId,int examineType);

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����11:52:29
	 *��������ChangeActivityToResult
	 *���ܣ������ܽ�
	 *������@param activityId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ChangeActivityToResult(int activityId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����04:59:38
	 *��������SumbitActivityMissionResult
	 *���ܣ��ύ�����ܽ�
	 *������@param planId
	 *������@param missionId
	 *������@param missionResult
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SumbitActivityMissionResult(int planId,int missionId,String missionResult);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:50:04
	 *��������SubmitActivityPlanResult
	 *���ܣ��ύ��ܽ�
	 *������@param missionResult
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SubmitActivityPlanResult(int activityId,String activityResult);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-17����03:56:58
	 *��������changePlotterId
	 *���ܣ��ı��߻���
	 *������@param PlotterId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ChangePlotterId(int activityId,int PlotterId);
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����07:09:49
	 *��������changePlanerId
	 *���ܣ��ı����񷽰��ƶ���
	 *������@param activityId
	 *������@param plannerId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ChangePlanerId(int activityId,int plannerId);
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
	 *��������UpdateEquipment
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
	 *���ܣ���������ɾ�����ļ����ļ�¼
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
	 *ʱ�䣺2015-10-21����11:07:39
	 *��������QueryPeopleChats
	 *���ܣ���ѯ�û��������
	 *������@param CreateId
	 *������@param ReciverId
	 *������@return 
	 *����ֵ��List<Chat>
	 */
	public List<Chat> QueryPeopleChats(int CreateId,int ReciverId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-21����11:11:58
	 *��������QueryManyPeopleChats
	 *���ܣ���ѯȺ��
	 *������@param ReciverId
	 *������@return 
	 *����ֵ��List<Chat>
	 */
	public List<Chat> QueryManyPeopleChats(int ReciverId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-21����02:45:55
	 *��������QueryPeopleNewChats
	 *���ܣ���ѯ��������������Ϣ������1,2,3,4�ķ�����Id
	 *������@param ReciverId
	 *������@return 
	 *����ֵ��String
	 */
	public String QueryPeopleNewChats(int ReciverId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-21����02:52:16
	 *��������SendChat
	 *���ܣ�����������Ϣ
	 *������@param chat
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean SendChat(Chat chat);
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
	  *���ܣ��޸��û�����
	  *������@param user
	  *������@return 
	  *����ֵ��boolean
	  */
	 public boolean UpdateUser(User user);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-21����03:50:13
	  *��������QueryUserPart
	  *���ܣ���ѯ�û��μӵĲ��ţ������û�ְλ
	  *������@param UserId
	  *������@return 
	  *����ֵ��List<HashMap<String,Object>>
	  */
	 public HashMap<String,Object> QueryUserPart(int UserId);
	 
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
	 public boolean ChangeGradeDatum(int gradeId,String gradeContent,String gradePic);
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-15����11:14:58
	  *��������queryFriendsByUserId
	  *���ܣ������û�ID��ѯ���û�����
	  *������@param userId
	  *������@return 
	  *����ֵ��List<Friend>
	  */
	 public List<HashMap<String, Object>> QueryFriendsByUserId(int userId);
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
	  *ʱ�䣺2015-10-22����03:27:49
	  *��������QueryMissionBymissionExecutorId
	  *���ܣ������û���ѯ���յ���������
	  *������@param missionExecutorId
	  *������@return 
	  *����ֵ��List<Mission>
	  */
	public List<HashMap<String, Object>> QueryMissionBymissionExecutorId(int missionExecutorId);
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
	 *ʱ�䣺2015-11-24����01:12:03
	 *��������Login
	 *���ܣ���¼
	 *������@param userroll
	 *������@return 
	 *����ֵ��int
	 */
	public Map<String, Object> Login(String userroll,String password);
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
	  *ʱ�䣺2015-10-19����03:23:07
	  *��������QueryCorporationMembers
	  *���ܣ���ѯ���ų�Ա
	  *������@param corporationId
	  *������@return 
	  *����ֵ��List<HashMap<String,Object>>
	  */
	public List<HashMap<String, Object>> QueryCorporationMembers(int corporationId);
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
	 *ʱ�䣺2015-10-14����03:53:11
	 *��������QueryPlanByPlanCreatorId
	 *���ܣ�������������ID��ѯ���񷽰�
	 *������@param planCreatorId
	 *������@return 
	 *����ֵ�� List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> QueryPlanByPlanCreatorId(int planCreatorId);
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
		 *ʱ�䣺2015-12-27����04:13:45
		 *��������queryapplyfriend
		 *���ܣ������û��ĺ�������
		 *������@param userId
		 *������@return 
		 *����ֵ��List<Friend>
		 */
	public List<Friend> queryApplyFriend(int userId) ;
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-27����04:16:07
	 *��������applyFriend
	 *���ܣ������������
	 *������@param friend
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean applyFriend(Friend friend);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-27����04:41:27
	 *��������tobeFriend
	 *���ܣ���Ϊ����
	 *������@param userId
	 *������@param friendId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean tobeFriend(int userId,int friendId);
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-27����04:54:18
	 *��������refuseTobeFriend
	 *���ܣ��ܾ� ��Ϊ����
	 *������@param userId
	 *������@param friendId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean refuseTobeFriend(int userId,int friendId);
}
