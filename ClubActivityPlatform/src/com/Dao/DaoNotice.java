package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Notice;
import com.Tool.HIbernateSessionFactory;
import com.Tool.MyConstant.BelongType;
import com.Tool.MyConstant.HotNum;

public class DaoNotice {

	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryHotNotice
	  *功能：查询热门公告
	  *参数：
	  *返回值：List<Notice>
	  */
	public List<Notice> QueryHotNotice(int noticeBelongType,int noticeBelongId){
		List<Notice> notices=new ArrayList<Notice>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Notice where noticeBelongType="+noticeBelongType;
			if (noticeBelongType!=BelongType.COROORATION) {
				hql+="and noticeBelongId="+noticeBelongId;
			}
			hql+= " order by noticeStartTime desc";
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.setFirstResult(0);
			query.setMaxResults(HotNum.HOTNOTICE);
			notices=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return notices;
	}
	
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryAllNotice
	  *功能：查询所有公告
	  *参数：
	  *返回值：List<Notice>
	  */
	public List<Notice> QueryAllNotice(){
		List<Notice> notices=new ArrayList<Notice>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Notice order by noticeStartTime desc";
			Query query=session.createQuery(hql);query.setCacheable(false);
			notices=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return notices;
	}
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午09:30:14
	 *函数名：QueryNoticeDetailById
	 *功能：根据ID获取公告详情
	 *参数：@param noticeid
	 *返回值：Notice
	 */
	public Notice QueryNoticeDetailById(int noticeid){
		Notice notice =null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			notice= (Notice) session.get(Notice.class, noticeid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return notice;
		
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-14下午01:40:33
	 *函数名：SearchNotice
	 *功能：根据公告名搜索公告
	 *参数：@param noticetitle
	 *返回值：List<Notice>
	 */
	public List<Notice> SearchNotice(String noticetitle){
		List<Notice> notices=new ArrayList<Notice>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Notice where noticeTitle like'%"+noticetitle+"%' order by noticeStartTime desc";
			Query query=session.createQuery(hql);query.setCacheable(false);
			notices=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notices;
	}
	 /**
	  * 
	  *作者：movie
	  *时间：2015-10-13下午07:09:32
	  *函数名：QueryNoticeByBelong
	  *功能：根据所属查询公告 noticeBelongId
	  *参数：noticeBelongType 
	  *返回值：List<Notice>
	  */
	public List<Notice> QueryNoticeByBelong(int noticeBelongType,int noticeBelongId){
		List<Notice> notices=new ArrayList<Notice>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Notice where noticeBelongType="+noticeBelongType+" and noticeBelongId="+noticeBelongId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			notices=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return notices;
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
		boolean result=false;
		try {
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(notice);
			session.getTransaction().commit();
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
	 *时间：2015-10-15上午10:45:11
	 *函数名：DeleteNotice
	 *功能：删除公告
	 *参数：@param noticeId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean DeleteNotice(int noticeId){
		boolean result=false;
		try {
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String hql="delete Notice where noticeId="+noticeId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
