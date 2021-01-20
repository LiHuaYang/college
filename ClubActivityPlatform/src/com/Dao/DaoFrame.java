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



public class DaoFrame implements IDaoFrame{
	private DaoActivity daoActivity=new DaoActivity();
	private DaoActivestage daoActivestage=new DaoActivestage();
	private DaoComment daoComment=new DaoComment();
	private DaoCorporation daoCorporation=new DaoCorporation();
	private DaoDepartment daoDepartment=new DaoDepartment();
	private DaoEconomics daoEconomics=new DaoEconomics();
	private DaoEconomicscord daoEconomicscord=new DaoEconomicscord();
	private DaoEquipment daoEquipment=new DaoEquipment();
	private DaoEquipmentrecord daoEquipmentrecord=new DaoEquipmentrecord();
	private DaoFile daoFile=new DaoFile();
	private DaoFriend daoFriend=new DaoFriend();
	private DaoGrade daoGrade=new DaoGrade();
	private DaoMission daoMission=new DaoMission();
	private DaoNotice daoNotice=new DaoNotice();
	private DaoOrganzation daoOrganzation=new DaoOrganzation();
	private DaoParticipants daoParticipants=new DaoParticipants();
	private DaoPlan daoPlan=new DaoPlan();
	private DaoUser daoUser=new DaoUser();
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����07:19:53
	 *��������QueryActivestageByActivityId
	 *���ܣ����ݻId��ѯ��׶�
	 *������@param activityid
	 *����ֵ��List<Activestage>
	 */
	public List<Activestage> QueryActivestageByActivityId(int activityid){
		List<Activestage> activestages=daoActivestage.QueryActivestageByActivityId(activityid);
		return activestages;
	}
	
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����08:58:28
	 *��������CreateActivestage
	 *���ܣ�������׶�
	 *������@param activestage
	 *����ֵ��boolean
	 */
	public boolean CreateActivestage(Activestage activestage){
		boolean result=daoActivestage.CreateActivestage(activestage);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:26:48
	 *��������CreateActivity
	 *���ܣ������
	 *������@param activity
	 *����ֵ��int
	 */
	public int CreateActivity(Activity activity){
		int result=daoActivity.CreateActivity(activity);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����04:32:50
	 *��������UpdateActivity
	 *���ܣ����»
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateActivity(Activity activity){
		boolean result=daoActivity.UpdateActivity(activity);
		return result;
	}
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
	public boolean DeleteActivity(int activityId){
		boolean result=daoActivity.DeleteActivity(activityId);
		return result;
	}
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
	public boolean CreateScheme(int activityId,String activityName,String activityStartTime,String activityEndTime,String activityAddress){
		boolean result=daoActivity.CreateScheme(activityId, activityName, activityStartTime, activityEndTime, activityAddress);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����05:13:11
	 *��������UpdateActivityState
	 *���ܣ����»״̬
	 *������@param activityId
	 *������@param activityState
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean UpdateActivityState(int activityId,int activityState){
		boolean result=daoActivity.UpdateActivityState(activityId, activityState);
		return result;
	}
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
	public boolean UpdatePlotter(int activityId,int plotterId){
		boolean result=daoActivity.UpdatePlotter(activityId, plotterId);
		return result;
	}
	
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
	public boolean UpdatePlanner(int activityId,int plannerId){
		boolean result=daoActivity.UpdatePlanner(activityId, plannerId);
		return result;
	}
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
	public boolean SubmitActivityResult(int activityId,String activityResult){
		boolean result=daoActivity.SubmitActivityResult(activityId, activityResult);
		return result;
	}
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryHotActivity
	  *���ܣ���ѯ���еĻ
	  *������
	  *����ֵ��List<Activity>
	  */
	public List<Activity> QueryHotActivity(){
		List<Activity> activities=daoActivity.QueryHotActivity();
		return activities;
	}
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllActivityBulletin
	  *���ܣ���ѯ���л����
	  *������
	  *����ֵ��List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>> QueryAllActivityBulletin(){
		List<HashMap<String, Object>> activityBulletin=daoActivity.QueryAllActivityBulletin();
		return activityBulletin;
	}
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������SearchActivityBulletin
	  *���ܣ����������
	  *������
	  *����ֵ��List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>> SearchActivityBulletin(String activityname,String activityaddress){
		List<HashMap<String, Object>> activityBulletin=daoActivity.SearchActivityBulletin(activityname,activityaddress);
		return activityBulletin;
	}
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryActivityBulletinByOrganizationId
	  *���ܣ���ѯ��֯�����
	  *������
	  *����ֵ��List<HashMap<String, Object>>
	  */
	public List<HashMap<String, Object>> QueryActivityBulletinByOrganizationId(int organizationid){
		List<HashMap<String, Object>> activities=daoActivity.QueryActivityBulletinByOrganizationId(organizationid);
		return activities;
	}
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryActivityByOrganizationId
	  *���ܣ���ѯ��֯���л
	  *������
	  *����ֵ��List<Activity>
	  */
	public List<Activity> QueryAllActivityByOrganizationId(int organizationid){
		List<Activity> activities=daoActivity.QueryAllActivityByOrganizationId(organizationid);
		return activities;
	}
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
	public Activity QueryActivityById(int activityId){
		Activity activity=daoActivity.QueryActivityById(activityId);
		return activity;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:05:59
	 *��������CreateComment
	 *���ܣ���������
	 *������@param comment
	 *����ֵ��boolean
	 */
	public boolean CreateComment(Comment comment){
		boolean result=daoComment.CreateComment(comment);
		return result;
	}
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
	public List<Comment> queryCommentsByNoticeId(int noticeid){
		List<Comment> comments=daoComment.queryCommentsByNoticeId(noticeid);
		return comments;
	}
	
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
	public boolean DeleteCommentsByNoticeId(int noticeid){
		boolean result=daoComment.DeleteCommentsByNoticeId(noticeid);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:27:25
	 *��������DeleteComment
	 *���ܣ�ͨ������Idɾ������
	 *������@param commentid
	 *����ֵ��boolean
	 */
	public boolean DeleteCommentById(int commentid){
		boolean result=daoComment.DeleteCommentById(commentid);
		return result;
	}
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
	public List<Comment> QueryCommentsByBelong(int noticeBelongType,int noticeBelongId){
		List<Comment> comments=daoComment.QueryCommentsByBelong(noticeBelongType,noticeBelongId);
		return comments;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����12:48:34
	 *��������QueryCorporationById
	 *���ܣ�����ID��ѯ��������
	 *������@param Corporationid
	 *����ֵ��Organization
	 */
	public Corporation QueryCorporationById(int corporationid){
		Corporation corporation=daoCorporation.QueryCorporationById(corporationid);
		return corporation;
	}
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryHotCorporation
	  *���ܣ���ѯ��������
	  *������
	  *����ֵ��List<Corporation>
	  */
	public List<Corporation> QueryHotCorporation(){
		List<Corporation> corporations=daoCorporation.QueryHotCorporation();
		return corporations;
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
	public List<Corporation>  QueryAllCorporation(){
		List<Corporation> corporations=daoCorporation.QueryAllCorporation();
		return corporations;
	}
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������SearchCorporation
	  *���ܣ���������
	  *������
	  *����ֵ��List<Corporation>
	  */
	public List<Corporation> SearchCorporation(String corporationname){
		List<Corporation> corporations=daoCorporation.SearchCorporation(corporationname);
		return corporations;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:48:04
	 *��������QueryDepartmentById
	 *���ܣ�����ID��ѯ��������
	 *������@param departmentid
	 *����ֵ��Department
	 */
	public Department QueryDepartmentById(int departmentid){
		Department department=daoDepartment.QueryDepartmentById(departmentid);
		return department;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:27:08
	 *��������queryDepartmentsByorganizationId
	 *���ܣ�������֯ID��ѯ�����б�
	 *������@param organizationId 
	 *����ֵ��List<Department>
	 */
	public List<Department> queryDepartmentsByorganizationId(int organizationId){
		List<Department> departments=daoDepartment.queryDepartmentsByorganizationId(organizationId);
		return departments;
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
		boolean result=daoDepartment.UpdateDepartment( departmentId,departmentIntroduction, departmentPic);
		return result;
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
		Economics economics=daoEconomics.QueryEconomicsByBelong(economicsBelongType, economicsBelongId);
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
		boolean result=daoEconomics.UpdateEconomicsSum(economicsId, economicsSum);
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
		List<Economicsrecord> economicsrecords=daoEconomicscord.QueryEconomicsrecordsByEconomicsId(economicsId);
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
		boolean result=daoEconomicscord.CreateEconomicscord(economicsrecord);
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
		List<Equipment> equipments=daoEquipment.QueryEquipmentByBelong(equipmentBelongType, equipmentBelongId);
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
		Equipment equipment=daoEquipment.QueryEquipmentById(equipmentId);
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
		boolean result=daoEquipment.SaveEquipment(equipment);
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
		boolean result=daoEquipment.UpdateEquipment(equipment);
		return result;
	}
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
	public boolean DeleteEquipment(int equipmentId){
		boolean result=daoEquipment.DeleteEquipment(equipmentId);
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
		List<Equipmentrecord> equipmentrecords=daoEquipmentrecord.QueryEquipmentrecordsByEquipmentId(equipmentId);
		return equipmentrecords;
	}
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
	public boolean DeleteEquipmentrecordByEquipmentId(int equipmentId){
		boolean result=daoEquipmentrecord.DeleteEquipmentrecordByEquipmentId(equipmentId);
		return result;
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
		boolean result=daoEquipmentrecord.CreateEquipmentrecord(equipmentrecord);
		return result;
	}
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
	public int CreateFile(File file){
		int fileId=daoFile.CreateFile(file);
		return fileId;
	}
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
	public boolean DeleteFile(int fileId){
		boolean result=daoFile.DeleteFile(fileId);
		return result;
	}
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
	public List<HashMap<String, Object>> queryFriendsByUserId(int userId){
		List<HashMap<String, Object>> friends=daoFriend.queryFriendsByUserId(userId);
		return friends;
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
		boolean result = daoFriend.DeleteFriend(userId,friendId);
		return result;
	}
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
	public boolean CreateFriend(Friend friend){
		boolean result = daoFriend.CreateFriend(friend);
		return result;
		
	}
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
	public List<Grade> QueryGradeByBelong(int gradeBelongType,int gradeBelongId){
		List<Grade> grades=daoGrade.QueryGradeByBelong(gradeBelongType, gradeBelongId);
		return grades;
	}
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
	public List<Grade> QueryGradeByGrade(int gradeBelongType,int gradeBelongId,int userGrade){
		List<Grade> grades=daoGrade.QueryGradeByGrade(gradeBelongType, gradeBelongId,userGrade);
		return grades;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:44:47
	 *��������ChangeGrade
	 *���ܣ��޸���Աְλ
	 *������@param grade
	 *����ֵ��boolean
	 */
	public boolean ChangeGrade(int gradeId,int userGrade,int gradeBelongType,int gradeBelongId){
		boolean result=daoGrade.ChangeGrade(gradeId,userGrade,gradeBelongType, gradeBelongId);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����02:44:47
	 *��������CreateGrade
	 *���ܣ������Ա
	 *������@param grade
	 *����ֵ��boolean
	 */
	public boolean CreateGrade(Grade grade){
		boolean result=daoGrade.CreateGrade(grade);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:27:25
	 *��������DeleteGradeById
	 *���ܣ�ɾ����Ա
	 *������@param gradeid
	 *����ֵ��boolean
	 */
	public boolean DeleteGradeById(int gradeid){
		boolean result=daoGrade.DeleteGradeById(gradeid);
		return result;
	}
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
	public List<Grade> QueryGradeByUserId(int userId){
		List<Grade> grades=daoGrade.QueryGradeByUserId(userId);
		return grades;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:24:20
	 *��������CreateMission
	 *���ܣ���������������
	 *������@param missions
	 *����ֵ��boolean
	 */
	public boolean CreateMission(List<Mission> missions){
		boolean result=daoMission.CreateMission(missions);
		return result;
	}
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
	public boolean DeleteMissionByPlanId(int PlanId){
		boolean result=daoMission.DeleteMissionByPlanId(PlanId);
		return result;
	}
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
	public boolean DeleteMission(int missionid){
		boolean result=daoMission.DeleteMission(missionid);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����03:53:11
	 *��������queryMissionsByPlanId
	 *���ܣ��������񷽰�ID��ѯ�������б�
	 *������@param planId 
	 *����ֵ��Plan
	 */
	public List<Mission> queryMissionsByPlanId(int planId){
		List<Mission> missions=daoMission.queryMissionsByPlanId(planId);
		return missions;
	}
	/**���ߣ�movie
	 *ʱ�䣺2015-10-14����01:48:04
	 *��������QueryMissionById
	 *���ܣ�����ID����������
	 *������@param missionId
	 *����ֵ��Mission
	 */
	public Mission QueryMissionById(int missionId){
		Mission mission=daoMission.QueryMissionById(missionId);
		return mission;
	}
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
	public boolean SubmitMissionResult(int missionId,String missionResult){
		boolean result= daoMission.SubmitMissionResult(missionId, missionResult);
		return result;
	}
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryHotNotice
	  *���ܣ���ѯ���Ź���
	  *������
	  *����ֵ��List<Notice>
	  */
	public List<Notice> QueryHotNotice(int noticeBelongType,int noticeBelongId){
		List<Notice> notices=daoNotice.QueryHotNotice(noticeBelongType, noticeBelongId);
		return notices;
	}
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllNotice
	  *���ܣ���ѯ���л
	  *������
	  *����ֵ��List<Notice>
	  */
	public List<Notice> QueryAllNotice(){
		List<Notice> notices=daoNotice.QueryAllNotice();
		return notices;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����09:30:14
	 *��������QueryNoticeDetailById
	 *���ܣ�����ID��ȡ��������
	 *������@param noticeid
	 *����ֵ��Notice
	 */
	public Notice QueryNoticeDetailById(int noticeid){
		Notice notice=daoNotice.QueryNoticeDetailById(noticeid);
		return notice;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:40:33
	 *��������SearchNotice
	 *���ܣ����ݹ�������������
	 *������@param noticetitle
	 *����ֵ��List<Notice>
	 */
	public List<Notice> SearchNotice(String noticetitle){
		List<Notice> notices=daoNotice.SearchNotice(noticetitle);
		return notices;
	}
	/**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryNoticeByBelong
	  *���ܣ�����������ѯ���� noticeBelongId
	  *������noticeBelongType 
	  *����ֵ��List<Notice>
	  */
	public List<Notice> QueryNoticeByBelong(int noticeBelongType,int noticeBelongId){
		List<Notice> notices=daoNotice.QueryNoticeByBelong(noticeBelongType,noticeBelongId);
		return notices;
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
		boolean result=daoNotice.SaveNotice(notice);
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
		boolean result=daoNotice.DeleteNotice(noticeId);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����12:48:34
	 *��������QueryOrganizationById
	 *���ܣ�����ID��ѯ��֯
	 *������@param organizationid
	 *����ֵ��Organization
	 */
	public Organization QueryOrganizationById(int organizationid){
		Organization organization=daoOrganzation.QueryOrganizationById(organizationid);
		return organization;
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
		boolean result=daoOrganzation.UpdateOrganzation(organizationId, organizationIntroduction, organizationPic);
		return result;
	}
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����08:42:43
	 *��������SaveParticipants
	 *���ܣ�����������Ա
	 *������@param participants
	 *����ֵ��boolean
	 */
	 public boolean SaveParticipants(List<Participants> participants){
		 boolean result=daoParticipants.SaveParticipants(participants);
			return result; 
	 }
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����04:23:08
	  *��������QueryParticipantsByActivityId
	  *���ܣ����ݻID��ѯ�������Ա
	  *������@param activityId
	  *����ֵ��List<Participants>
	  */
	 public List<Participants> QueryParticipantsByActivityId(int activityId){
		 List<Participants> participants=daoParticipants.QueryParticipantsByActivityId(activityId);
		 return participants;
	 }
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
	 public Plan QueryPlanByActivityId(int activityId){
		 Plan plan =daoPlan.QueryPlanByActivityId(activityId);
		 return plan;
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
		 List<Plan> plan=daoPlan.QueryPlanByPlanCreatorId(planCreatorId);
		 return plan;
	 }
	 /**
	  * 
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����06:08:11
	  *��������CreatePlan
	  *���ܣ��½����񷽰�
	  *������@param plan
	  *������@return 
	  *����ֵ��boolean
	  */
	 public int CreatePlan(Plan plan){
		 int planId=daoPlan.CreatePlan(plan);
		 return planId;
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
		 boolean result=daoPlan.DeletePlan(PlanId);
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
		 User user=daoUser.QueryUserById(userId);
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
		 boolean result=daoUser.UpdateUser(user);
		 return result;
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
	 public boolean changeGradeDatum(int gradeId,String gradeContent,String gradePic){
		 boolean result=daoGrade.changeGradeDatum(gradeId, gradeContent, gradePic);
		 return result;
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
		List<User> users=daoUser.SearchUser(userName);
		return users;
	 }

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
		public User QueryUserByUserRoll(String userroll){
			User user=daoUser.QueryUserByUserRoll(userroll);
			return user;
			
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
	public List<Mission> QueryMissionBymissionExecutorId(int missionExecutorId) {
		List<Mission> missions = daoMission.QueryMissionBymissionExecutorId(missionExecutorId);
		return missions;
	}
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
		File file=daoFile.queryFileByBelong(fileType, fileBelongId);
		return file;
	}

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-12-14����03:29:59
	 *��������QueryActivityNotFinished
	 *���ܣ���ѯδ���Ļ
	 *������@return 
	 *����ֵ��List<Activity>
	 */
	public List<Activity> QueryActivityNotFinished(){
		List<Activity> activities=daoActivity.QueryActivityNotFinished();
		return activities;
 	}
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
	public Plan QueryPlanById(int planId){
		Plan plan=daoPlan.QueryPlanById(planId);
		return plan;
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
		List<HashMap<String, Object>> maps=daoActivity.QueryActivityByUserparts(userId);
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
		List<HashMap<String, Object>> maps=daoUser.queryAllUserName();
		return maps;
	}
}
