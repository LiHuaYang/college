package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Grade;
import com.Tool.HIbernateSessionFactory;

public class DaoGrade {

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
		List<Grade> grades=new ArrayList<Grade>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Grade where gradeBelongType="+gradeBelongType+" and gradeBelongId="+gradeBelongId+"order by userGrade desc";
			Query query=session.createQuery(hql);query.setCacheable(false);
			grades=query.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		List<Grade> grades=new ArrayList<Grade>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Grade where gradeBelongType="+gradeBelongType+" and gradeBelongId="+gradeBelongId+" and userGrade="+userGrade;
			Query query=session.createQuery(hql);query.setCacheable(false);
			grades=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Grade grade= (Grade) session.load(Grade.class, gradeId);
			grade.setUserGrade(userGrade);
			grade.setGradeBelongId(gradeBelongId);
			grade.setGradeBelongType(gradeBelongType);
			result=true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		boolean result=false;
		try {
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(grade);
			session.getTransaction().commit();
			result=true;
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String hql="delete Grade where gradeId="+gradeid;
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.executeUpdate();
			session.beginTransaction().commit();
			session.close();
			result=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		List<Grade> grades=new ArrayList<Grade>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Grade where userId="+userId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			grades=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grades;
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
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			Grade grade=(Grade) session.load(Grade.class, gradeId);
			grade.setGradeContent(gradeContent);
			grade.setGradePic(gradePic);
			session.getTransaction().commit();
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
