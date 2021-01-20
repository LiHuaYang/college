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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryHotNotice
	  *���ܣ���ѯ���Ź���
	  *������
	  *����ֵ��List<Notice>
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryAllNotice
	  *���ܣ���ѯ���й���
	  *������
	  *����ֵ��List<Notice>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����09:30:14
	 *��������QueryNoticeDetailById
	 *���ܣ�����ID��ȡ��������
	 *������@param noticeid
	 *����ֵ��Notice
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:40:33
	 *��������SearchNotice
	 *���ܣ����ݹ�������������
	 *������@param noticetitle
	 *����ֵ��List<Notice>
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-13����07:09:32
	  *��������QueryNoticeByBelong
	  *���ܣ�����������ѯ���� noticeBelongId
	  *������noticeBelongType 
	  *����ֵ��List<Notice>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:45:11
	 *��������SaveNotice
	 *���ܣ���������
	 *������@param notice
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-15����10:45:11
	 *��������DeleteNotice
	 *���ܣ�ɾ������
	 *������@param noticeId
	 *������@return 
	 *����ֵ��boolean
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
