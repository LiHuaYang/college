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
	 *作者：movie
	 *时间：2015-10-14下午01:05:59
	 *函数名：CreateComment
	 *功能：创建评论
	 *参数：@param comment
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-14下午01:06:23
	 *函数名：queryCommentsByNoticeId
	 *功能：根据公告ID查询该公告的评论
	 *参数：@param noticeid
	 *参数：@return 
	 *返回值：List<Comment>
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
	 *作者：movie
	 *时间：2015-10-14下午01:06:23
	 *函数名：queryCommentsByNoticeId
	 *功能：根据公告ID删除该公告的评论
	 *参数：@param noticeid
	 *参数：@return 
	 *返回值：List<Comment>
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
	 *作者：movie
	 *时间：2015-10-14下午01:27:25
	 *函数名：DeleteComment
	 *功能：通过评论Id删除评论
	 *参数：@param commentid
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-14下午02:20:05
	 *函数名：QueryCommentsByBelong
	 *功能：查询组织或社团最新公告
	 *参数：@param noticeBelongType
	 *参数：@param noticeBelongId
	 *返回值：List<Comment>
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
