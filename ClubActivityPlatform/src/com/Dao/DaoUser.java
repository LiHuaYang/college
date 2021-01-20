package com.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.User;
import com.Tool.HIbernateSessionFactory;

public class DaoUser {
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
		User user=null;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
		
			session.beginTransaction();
			user=(User) session.get(User.class, userId);
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
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
	public boolean UpdateUser(User user){
		boolean result=false;
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			
			session.beginTransaction();
			session.clear();
			session.update(user);
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
	 *ʱ�䣺2015-10-22����02:40:58
	 *��������SearchUser
	 *���ܣ������û�
	 *������@param userName
	 *������@return 
	 *����ֵ��List<User>
	 */
	public List<User> SearchUser(String userName){
		List<User> users=new ArrayList<User>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String hql="from User where userName like '%"+userName+"%'";
			Query query=session.createQuery(hql);
	
			users=query.list();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			User user=new User();
			try {
				
				Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
				
				session.beginTransaction();
				String hql="from User where UserRoll="+userroll;
				Query query=session.createQuery(hql);
				query.setCacheable(false);

				List<User> users=query.list();
				if (users.size()>0) {
					user=users.get(0);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
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
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		try {
			
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			
			session.beginTransaction();
			String hql="from User";
			Query query=session.createQuery(hql);
			query.setCacheable(false);
			List<User> users=query.list();	
			for (int i = 0; i < users.size(); i++) {
				HashMap< String, Object> map=new HashMap<String, Object>();
				map.put("userId", users.get(i).getUserId());
				map.put("userName", users.get(i).getUserName());
				map.put("userPic", users.get(i).getUserPic());
				maps.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
		
	}
}
