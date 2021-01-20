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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����04:31:41
	 *��������QueryHotActivity
	 *���ܣ���ѯ���Ż
	 *������ 
	 *����ֵ��void
	 */
	public List<Activity> QueryHotActivity() {
		List<Activity> activities=daoFrame.QueryHotActivity();
		return activities;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����05:02:46
	 *��������QueryActivestageByActivityId
	 *���ܣ���ѯ�����׶�
	 *������@param activityId
	 *������@return 
	 *����ֵ��List<Activestage>
	 */
	public List<Activestage> QueryActivestageByActivityId(int activityId) {
		List<Activestage> activestages=daoFrame.QueryActivestageByActivityId(activityId);
		return activestages;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:13:54
	 *��������QueryActivityBulletin
	 *���ܣ���ѯ���л����
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryActivityBulletin() {
		List<HashMap<String, Object>> activitybulletin=daoFrame.QueryAllActivityBulletin();
		return activitybulletin;
	}

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����09:36:08
	 *��������SearchActivityBulletin
	 *���ܣ����������
	 *������@param activityName
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:01:05
	 *��������QueryHotNotice
	 *���ܣ���ѯ���Ų���
	 *������@return 
	 *����ֵ��List<Notice>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-18����10:17:29
	 *��������QueryNoticeDetail
	 *���ܣ���ѯ��������
	 *������@param noticeId
	 *������@return 
	 *����ֵ��HashMap<String,Object>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����09:23:41
	 *��������CreateComment
	 *���ܣ���������
	 *������@param comment
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateComment(Comment comment) {
		boolean result=daoFrame.CreateComment(comment);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����09:49:31
	 *��������QueryAllComment
	 *���ܣ���ѯ�ù������������
	 *������@param noticeId
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����09:52:48
	 *��������DeleteComment
	 *���ܣ�ɾ������
	 *������@param commentId
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean DeleteComment(int commentId) {
		boolean result=daoFrame.DeleteCommentById(commentId);
		return result;
	}

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����09:56:11
	 *��������QueryAllNotice
	 *���ܣ���ѯ���й���
	 *������@return 
	 *����ֵ��List<Notice>
	 */
	public List<Notice> QueryAllNotice() {
		List<Notice> notices=daoFrame.QueryAllNotice();
		return notices;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����10:52:33
	 *��������SeacherNotice
	 *���ܣ���������
	 *������@param noticeName
	 *������@return 
	 *����ֵ��List<Notice>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����11:00:01
	 *��������QueryHotCorporation
	 *���ܣ���ѯ��������
	 *������@return 
	 *����ֵ��List<Corporation>
	 */
	public List<Corporation> QueryHotCorporation() {
		List<Corporation> corporations=daoFrame.QueryHotCorporation();
		return corporations;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����11:04:27
	 *��������QueryCorporationDetailById
	 *���ܣ���ѯ��������
	 *������@param corporationId
	 *������@return 
	 *����ֵ��Corporation
	 */
	public Corporation QueryCorporationDetailById(int corporationId) {
		Corporation corporation=daoFrame.QueryCorporationById(corporationId);
		return corporation;
	}
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllCorporation
	  *���ܣ���ѯ��������
	  *������
	  *����ֵ��List<Corporation>
	  */
	public List<Corporation> QueryAllCorporation(){
		List<Corporation> corporations=daoFrame.QueryAllCorporation();
		return corporations;
		
	}
	
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
	public List<Corporation> SearchCorporation(String corporationName){
		List<Corporation> corporations=daoFrame.SearchCorporation(corporationName);
		return corporations;
	}
	
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
	public Organization QueryOrganizationDetail(int organizationId) {
		Organization organization=daoFrame.QueryOrganizationById(organizationId);
		return organization;
	}
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����02:36:15
	 *��������QueryOrganizationBulletin
	 *���ܣ���ѯ��֯�����
	 *������@param organizationId
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> QueryOrganizationBulletin(int organizationId){
		
		List<HashMap<String, Object>> maps=daoFrame.QueryActivityBulletinByOrganizationId(organizationId);
		return maps;
	}
	
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
	public List<Notice> QueryNoticeByBelong(int noticeBelongType,
			int noticeBelongId) {
		List<Notice> notices=daoFrame.QueryNoticeByBelong(noticeBelongType, noticeBelongId);
		return	notices;
	}
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
	public List<Department> QueryDepartmentsByorganizationId(int organizationId){
		List<Department> departments=daoFrame.queryDepartmentsByorganizationId(organizationId);
		return departments;
	}
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-19����03:23:07
	  *��������QueryCorporationMembers
	  *���ܣ���ѯ���ų�Ա
	  *������@param corporationId
	  *������@return 
	  *����ֵ��List<HashMap<String,Object>>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����03:29:02
	 *��������queryDepartmentDetail
	 *���ܣ���ѯ��������
	 *������@param departmentId
	 *������@return 
	 *����ֵ��Department
	 */
	public Department QueryDepartmentDetail(int departmentId){
		Department departments=daoFrame.QueryDepartmentById(departmentId);
		return departments;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����04:33:19
	 *��������ChangeGrade
	 *���ܣ��޸ĵȼ�
	 *������@param gradeId
	 *������@param userGrade
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean ChangeGrade(int gradeId, int userGrade,int gradeBelongType,int gradeBelongId) {
		boolean result=daoFrame.ChangeGrade(gradeId, userGrade,gradeBelongType,gradeBelongId);
		return result;
	}
	
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
	public boolean DeleteGradeById(int gradeid){
		boolean result=daoFrame.DeleteGradeById(gradeid);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����07:48:59
	 *��������CreatePlan
	 *���ܣ��������񷽰�
	 *������@param plan
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:53:11
	 *��������QueryPlanByPlanCreatorId
	 *���ܣ�������������ID��ѯ���񷽰�
	 *������@param activityId
	 *������@return 
	 *����ֵ��Plan
	 */
	public List<Plan> QueryPlanByPlanCreatorId(int planCreatorId){
		
		List<Plan> plans=daoFrame.QueryPlanByPlanCreatorId(planCreatorId);
		return plans;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-19����07:56:04
	 *��������CreateMission
	 *���ܣ��������ύ������
	 *������@param mission
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateMission(List<Mission> mission){
		boolean result=daoFrame.CreateMission(mission);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����09:14:15
	 *��������queryActivityByOrganizeId
	 *���ܣ���ѯ��֯�
	 *������@param organizationId
	 *������@return 
	 *����ֵ��List<Activity>
	 */
	public List<Activity> QueryAllActivityByOrganizationId(int organizationId) {
		List<Activity> activities=daoFrame.QueryAllActivityByOrganizationId(organizationId);
		return activities;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����09:32:56
	 *��������QueryActivityDetail
	 *���ܣ���ѯ�����
	 *������@param activityId
	 *������@return 
	 *����ֵ��Activity
	 */
	public Activity QueryActivityDetail(int activityId) {

		Activity activity=daoFrame.QueryActivityById(activityId);
		
		return activity;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����09:55:42
	 *��������QueryPlanByActivityId
	 *���ܣ���ѯ���񷽰�ͨ���ID
	 *������@param activityId
	 *������@return 
	 *����ֵ��Plan
	 */
	public Plan QueryPlanByActivityId(int activityId) {
		Plan plan=daoFrame.QueryPlanByActivityId(activityId);
		return plan;
	}

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
	public List<Mission> QueryMissionByPlanId(int planId) {
		List<Mission> missions=daoFrame.queryMissionsByPlanId(planId);
		return missions;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-20����10:14:48
	 *��������QueryParticipantsByActivityId
	 *���ܣ����ݻId��ѯ�������Ա
	 *������@param activityId
	 *������@return 
	 *����ֵ��List<Participants>
	 */
	public List<Participants> QueryParticipantsByActivityId(int activityId) {
		List<Participants> participants=daoFrame.QueryParticipantsByActivityId(activityId);
		return participants;
	}
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
	public Economics QueryEconomicsByBelong(int economicsBelongType,int economicsBelongId){
		Economics economics=daoFrame.QueryEconomicsByBelong(economicsBelongType, economicsBelongId);
		return economics;
	}
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
	public boolean UpdateEconomicsSum(int economicsId,float economicsSum){
		boolean result=daoFrame.UpdateEconomicsSum(economicsId, economicsSum);
		return result;
	}
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
	public List<Economicsrecord> QueryEconomicsrecordsByEconomicsId(int economicsId){
		List<Economicsrecord> economicsrecords=daoFrame.QueryEconomicsrecordsByEconomicsId(economicsId);
		return economicsrecords;
	}
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
	public boolean CreateEconomicscord(Economicsrecord economicsrecord){
		boolean result=daoFrame.CreateEconomicscord(economicsrecord);
		return result;
	}
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
	public List<Equipment> QueryEquipmentByBelong(int equipmentBelongType,int equipmentBelongId){
		List<Equipment> equipments=daoFrame.QueryEquipmentByBelong(equipmentBelongType, equipmentBelongId);
		return equipments;
	}
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
	public Equipment QueryEquipmentById(int equipmentId){
		Equipment equipment=daoFrame.QueryEquipmentById(equipmentId);
		return equipment;
	}
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
	public boolean SaveEquipment(Equipment equipment){
		boolean result=daoFrame.SaveEquipment(equipment);
		return result;
	}
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
	public boolean UpdateEquipment(Equipment equipment){
		boolean result=daoFrame.UpdateEquipment(equipment);
		return result;
	}
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
	public boolean DeleteEquipment(int equipmentId){
		boolean result=daoFrame.DeleteEquipment(equipmentId);
		daoFrame.DeleteEquipmentrecordByEquipmentId(equipmentId);
		return result;
	}
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
	public List<Equipmentrecord> QueryEquipmentrecordsByEquipmentId(int equipmentId){
		List<Equipmentrecord> equipmentrecords=daoFrame.QueryEquipmentrecordsByEquipmentId(equipmentId);
		return equipmentrecords;
	}
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
	public boolean CreateEquipmentrecord(Equipmentrecord equipmentrecord){
		boolean result=daoFrame.CreateEquipmentrecord(equipmentrecord);
		return result;
	}
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
	public boolean SaveNotice(Notice notice){
		boolean result=daoFrame.SaveNotice(notice);
		return result;
	}
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
	public boolean DeleteNotice(int noticeId){
		boolean result=daoFrame.DeleteNotice(noticeId);
		daoFrame.DeleteNotice(noticeId);
		return result;
	}
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����01:16:32
	  *��������QueryUserById
	  *���ܣ������û�ID��ѯ�û�����
	  *������@param userId
	  *����ֵ��User
	  */
	 public User QueryUserById(int userId){
		 User user=daoFrame.QueryUserById(userId);
		 return user;
	 }
	 
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
	 public boolean UpdateUser(User user){
		 boolean result=daoFrame.UpdateUser(user);
		 return result;
	 }
	 
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-21����03:50:13
	  *��������QueryUserPart
	  *���ܣ���ѯ�û��μӵĲ��ź����ţ������û�ְλ
	  *������@param UserId
	  *������@return 
	  *����ֵ��List<HashMap<String,Object>>
	  */
	 public HashMap<String,Object> QueryUserPart(int UserId){
		 HashMap<String, Object> UserPart=new HashMap<String, Object>();
		 List<HashMap<String,Object>> organmaps=new ArrayList<HashMap<String,Object>>();
		 List<HashMap<String,Object>> departmaps=new ArrayList<HashMap<String,Object>>();
		 List<HashMap<String,Object>> corpormaps=new ArrayList<HashMap<String,Object>>();
		 List<Grade> grades=daoFrame.QueryGradeByUserId(UserId);
		 for (int i = 0; i < grades.size(); i++) {
			 //��֯
			if (grades.get(i).getGradeBelongType()==BelongType.ORGANIZATION) {
				Organization organization=daoFrame.QueryOrganizationById(grades.get(i).getGradeBelongId());
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("organizationId", organization.getOrganizationId());
				map.put("organizationName", organization.getOrganizationName());
				map.put("organizationPic", organization.getOrganizationPic());
				map.put("grade", grades.get(i));
				organmaps.add(map);
			}
			//����
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
			//����
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
	 public boolean ChangeGradeDatum(int gradeId,String gradeContent,String gradePic){
		 boolean result=daoFrame.changeGradeDatum(gradeId, gradeContent, gradePic);
		 return result;
	 }
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
	 public List<HashMap<String, Object>> QueryFriendsByUserId(int userId){
		 List<HashMap<String, Object>> friends=daoFrame.queryFriendsByUserId(userId);
		 return friends;
	 }
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
	 public List<User> SearchUser(String userName){
		List<User> users=daoFrame.SearchUser(userName);
		for (int i = 0; i < users.size(); i++) {
			users.get(i).setUserPassword("");
	
		}
		return users;
	 }
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����11:20:09
	 *��������UpdateDepartment
	 *���ܣ��޸Ĳ�����Ϣ
	 *������@param department
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateDepartment(int departmentId,String departmentIntroduction,String departmentPic){
		boolean result=daoFrame.UpdateDepartment(departmentId, departmentIntroduction, departmentPic);
		return result;
	}
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
	public boolean UpdateOrganzation(int organizationId,String organizationIntroduction,String organizationPic){
		boolean result=daoFrame.UpdateOrganzation(organizationId, organizationIntroduction, organizationPic);
		return result;
	}
	
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
	public boolean DeleteFriend(int userId,int friendId){
		boolean result = daoFrame.DeleteFriend(userId,friendId);
		return result;
	}
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
	public Map<String, Object> Login(String userroll,String password){
		Map<String, Object> map=new HashMap<String, Object>();
		int result=0;//���û�
		System.out.println(password);
		
		User user=daoFrame.QueryUserByUserRoll(userroll);
		System.out.println(user.getUserPassword());
		if (user.getUserId()==0) {
			result=0;
		}else if (user.getUserPassword().equals(password)) {
			result=user.getUserId();
			map.put("User", user);
		}else {
			result=-1;//�������
		}
		map.put("result", result);
	
		return map;
	
		
	};
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
	public File queryFileByBelong(int fileType,int fileBelongId){
		File file=daoFrame.queryFileByBelong(fileType, fileBelongId);
		return file;
	}
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
	public boolean SumbitMissionResult(int missionId,String missionResult){
		boolean result=daoFrame.SubmitMissionResult(missionId, missionResult);
		return result;
	
	}
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
	public List<HashMap<String, Object>> QueryActivityByUserparts(int userId){
		List<HashMap<String, Object>> maps=daoFrame.QueryActivityByUserparts(userId);
		return maps;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-24����03:56:15
	 *��������queryAllUserName
	 *���ܣ���ѯ�����û�����
	 *������@return 
	 *����ֵ��List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> queryAllUserName(){
		List<HashMap<String, Object>> maps=daoFrame.queryAllUserName();
		return maps;
	}
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
	 public boolean DeletePlan(int PlanId){
		 boolean result=daoFrame.DeletePlan(PlanId);
		 return result;
	 }
}	
