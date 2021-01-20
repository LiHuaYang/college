package com.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.Friend;
import com.Tool.HIbernateSessionFactory;

public class DaoFriend {
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
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		List<Friend> friends=null;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			session.beginTransaction();
			String sql="Select User.userId,User.userName,User.userPic,Friend.friendRelationId  from User,Friend where User.userId=Friend.friendId and Friend.userId="+userId;
			Query query=session.createSQLQuery(sql);
			List<Object[]> objects=query.list();
			for(Object[] object : objects){    
				HashMap<String, Object> map=new HashMap<String, Object>();
				int friendId = Integer.parseInt(String.valueOf(object[0]));
				String friendName = (String)object[1];    
				String friendPic= (String)object[2];  
				int friendRelationId=Integer.parseInt(String.valueOf(object[3]));
	            map.put("friendId", friendId);
	            map.put("friendName", friendName);
	            map.put("friendPic", friendPic);
	            map.put("friendRelationId", friendRelationId);
	            maps.add(map);
	        }    
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
		
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
		boolean result=false;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String hql="delete Friend where userId="+userId+" and friendId="+friendId;
			Query query=session.createQuery(hql);query.setCacheable(false);
			query.executeUpdate();
			String hql2="delete Friend where userId="+friendId+" and friendId="+userId;
			query=session.createQuery(hql2);query.setCacheable(false);
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
	 *ʱ�䣺2015-12-27����04:29:17
	 *��������CreateFriend
	 *���ܣ���Ӻ���
	 *������@param friend
	 *������@return 
	 *����ֵ��boolean
	 */
	public boolean CreateFriend(Friend friend){
		Friend friend2=new Friend();
		friend2.setFriendId(friend.getUserId());
		friend2.setUserId(friend.getFriendId());
		boolean result=false;
		try {
		
			Session session= HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			session.save(friend);
			session.save(friend2);
			session.getTransaction().commit();
			session.close();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
