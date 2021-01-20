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
	 *作者：movie
	 *时间：2015-10-14下午02:03:13
	 *函数名：QueryGradeByOrganizationId
	 *功能：根据所属ID和所属类型查询所有成员
	 *参数：@param gradeBelongType
	 *参数：@param gradeBelongId 
	 *返回值：List<Grade>
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
	 *作者：movie
	 *时间：2015-10-14下午02:03:13
	 *函数名：QueryGradeByOrganizationId
	 *功能：根据所属ID和所属类型,和等级级别查询成员
	 *参数：@param gradeBelongType
	 *参数：@param gradeBelongId 
	 *返回值：List<Grade>
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
	 *作者：movie
	 *时间：2015-10-14下午02:44:47
	 *函数名：ChangeGrade
	 *功能：修改人员职位
	 *参数：@param grade
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-14下午02:44:47
	 *函数名：CreateGrade
	 *功能：加入成员
	 *参数：@param grade
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-14下午01:27:25
	 *函数名：DeleteGradeById
	 *功能：删除成员
	 *参数：@param gradeid
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-15上午11:06:19
	 *函数名：QueryGradeByUserId
	 *功能：根据用户Id查询用户等级列表
	 *参数：@param userId
	 *参数：@return 
	 *返回值：List<Grade>
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
