package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Comment;
import com.Tool.HIbernateSessionFactory;


public class DaoComment {
	

	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-14����01:05:59
	 *��������CreateComment
	 *���ܣ���������
	 *������@param comment
	 *����ֵ��boolean
	 */
	public boolean CreateComment(Comment comment) {
		boolean result = false;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(comment);
			
			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		List<Comment> comments=new ArrayList<Comment>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Comment where noticeId="+noticeid;
			Query query=session.createQuery(hql);query.setCacheable(false);
			comments=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String hql="delete Comment where noticeId="+noticeid;
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
		boolean result=false;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String hql="delete Comment where commentId="+commentid;
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.executeUpdate();
			session.beginTransaction().commit();
			session.close();
			result=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
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
		List<Comment> comments=new ArrayList<Comment>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from Comment where noticeBelongType="+noticeBelongType+" and noticeBelongId="+noticeBelongId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			comments=query.list();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return comments;
	}
}
