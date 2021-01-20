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
	 *作者：movie
	 *时间：2015-10-14下午01:16:32
	 *函数名：QueryUserById
	 *功能：根据用户ID查询用户详情
	 *参数：@param userId
	 *返回值：User
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
	 *作者：movie
	 *时间：2015-10-15上午11:01:10
	 *函数名：UpdateUser
	 *功能：修改资料
	 *参数：@param user
	 *参数：@return 
	 *返回值：boolean
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
	 *作者：movie
	 *时间：2015-10-22下午02:40:58
	 *函数名：SearchUser
	 *功能：搜索用户
	 *参数：@param userName
	 *参数：@return 
	 *返回值：List<User>
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
	 *作者：movie
	 *时间：2015-11-24下午01:12:03
	 *函数名：QueryUserByUserRoll
	 *功能：根据学号查找用户
	 *参数：@param userroll
	 *参数：@return 
	 *返回值：User
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
	 *作者：movie
	 *时间：2015-12-24下午03:56:15
	 *函数名：queryAllUserName
	 *功能：查询所有用户名称
	 *参数：@return 
	 *返回值：List<HashMap<String,Object>>
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
