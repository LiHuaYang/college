package com.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.User;
import com.Test.HibernateUtil;

public class CDaoUser {
	// 新建客户
	public boolean CreateUser(User user) {
		boolean result = false;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			HibernateUtil.closeSession();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询客户表的所有信息
	@SuppressWarnings("unchecked")
	public List<User> SearchtotalUser() {
		List<User> user = new ArrayList<User>();
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql = "from User";
			Query query = session.createQuery(hql);
			user = query.list();
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// 查询单个用户信息
	public User SearcheachUser(int userId) {
		User user = null;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			user = (User) session.get(User.class, userId);
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// 修改用户信息
	public boolean DisappearUser(User user) {
		boolean result = false;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
			HibernateUtil.closeSession();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 根据id更改用户的图片
	public boolean ChangeUserPic(int userId, String userPicture) {
		boolean result = false;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			User user = (User) session.load(User.class, userId);
			user.setUserPicture(userPicture);
			session.update(user);
			session.getTransaction().commit();
			HibernateUtil.closeSession();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//修改用户部分信息
	public boolean ChangeUserPart(int userId,String userName,String userSex,String userBoth,String userPhone,String userEmail,String userIdNumber,String userMessage){
		boolean result=false;		
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			User user=(User)session.load(User.class, userId);  
			user.setUserName(userName);
			user.setUserSex(userSex);
			user.setUserBoth(userBoth);
			user.setUserPhone(userPhone);
			user.setUserEmail(userEmail);
			user.setUserIDNumber(userIdNumber);
			user.setUserMessage(userMessage); 
			session.update(user);
			session.getTransaction().commit();
			HibernateUtil.closeSession();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

	// 通过邮箱和密码查询用户id
	public int Queryemailuser(String useremail, String userpassword) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int result = 0;
		try {
			String hql = "select UserId from User where UserEmail='"
					+ useremail + "' and UserPassword='" + userpassword + "'";
			Query query = session.createSQLQuery(hql);
			session.getTransaction().commit();
			int userid = (Integer) query.list().get(0);
			HibernateUtil.closeSession();
			result = userid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// //通过电话号码查询用户信息
	// public List<User> Queryphonuser(String userphon){
	// List<User> order=new ArrayList<User>();
	//	
	// try {
	// Session session=HibernateUtil.getSession();
	// session.beginTransaction();
	// String hql="from User where UserPhone= '"+userphon+"'";
	// Query query=session.createQuery(hql);
	// order=query.list();
	// HibernateUtil.closeSession();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//		
	// return order;
	// }

	// 通过电话号码和密码查询用户id
	public int Queryphonuser(String userphon, String userpassword) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int result = 0;
		try {
			String hql = "select UserId from User where UserPhone='" + userphon
					+ "' and UserPassword='" + userpassword + "'";
			Query query = session.createSQLQuery(hql);
			session.getTransaction().commit();
			int userid = (Integer) query.list().get(0);
			HibernateUtil.closeSession();
			result = userid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 通过电话号码和密码查询出密码以外的所有用户的信息
	public List<HashMap<String, Object>> QueryPhonuserother(String userphon,
			String userpassword) {
		List<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql = "select UserId,UserName,UserSex,UserPhone,UserEmail,UserBoth,UserIDNumber,UserVIP,UserState,UserBalance,UserPicture,UserMessage from User where UserPhone='"
					+ userphon + "' and UserPassword='" + userpassword + "'";
			Query query = session.createSQLQuery(hql);
			List<Object[]> objects = query.list();
			for (Object[] object : objects) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				int UserId = Integer.parseInt(String.valueOf(object[0]));
				String UserName = (String) object[1];
				String UserSex = (String) object[2];
				String UserPhone = (String) object[3];
				String UserEmail = (String) object[4];
				String UserBoth = (String) object[5];
				String UserIDNumber = (String) object[6];
				int UserVIP = Integer.parseInt(String.valueOf(object[7]));
				int UserState = Integer.parseInt(String.valueOf(object[8]));
				int UserBalance = Integer.parseInt(String.valueOf(object[9]));
				String UserPicture = (String) object[10];
				String UserMessage = (String) object[11];
				map.put("UserId", UserId);
				map.put("UserName", UserName);
				map.put("UserSex", UserSex);
				map.put("UserPhone", UserPhone);
				map.put("UserEmail", UserEmail);
				map.put("UserBoth", UserBoth);
				map.put("UserIDNumber", UserIDNumber);
				map.put("UserVIP", UserVIP);
				map.put("UserState", UserState);
				map.put("UserBalance", UserBalance);
				map.put("UserPicture", UserPicture);
				map.put("UserMessage", UserMessage);
				userList.add(map);
			}
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	//通过用户id查找除用户密码之外的所有信息
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid){
		List<HashMap<String, Object>> userList=new ArrayList<HashMap<String,Object>>();
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql="select UserId,UserName,UserSex,UserPhone,UserEmail,UserBoth,UserIDNumber,UserVIP,UserState,UserBalance,UserPicture,UserMessage from User where UserId='"+userid+"' ";
			Query query=session.createSQLQuery(hql);
			List<Object[]> objects=query.list();
			for(Object[] object : objects){
				HashMap<String, Object> map=new HashMap<String, Object>();
				int UserId=Integer.parseInt(String.valueOf(object[0]));
				String UserName = (String)object[1];
				String UserSex = (String)object[2];
				String UserPhone = (String)object[3];
				String UserEmail = (String)object[4];
				String UserBoth = (String)object[5];
				String UserIDNumber = (String)object[6];
				int UserVIP=Integer.parseInt(String.valueOf(object[7]));
				int UserState=Integer.parseInt(String.valueOf(object[8]));
				int UserBalance=Integer.parseInt(String.valueOf(object[9]));
				String UserPicture = (String)object[10];
				String UserMessage = (String)object[11];
				map.put("UserId", UserId);
				map.put("UserName", UserName);
				map.put("UserSex", UserSex);
				map.put("UserPhone", UserPhone);
				map.put("UserEmail", UserEmail);
				map.put("UserBoth", UserBoth);
				map.put("UserIDNumber", UserIDNumber);
				map.put("UserVIP", UserVIP);
				map.put("UserState", UserState);
				map.put("UserBalance", UserBalance);
				map.put("UserPicture", UserPicture);
				map.put("UserMessage", UserMessage);
				userList.add(map);
			}
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return userList;
	}
	
	
//	public List<HashMap<String, Object>> QueryActivityBulletinByOrganizationId(int organizationid){
//		List<HashMap<String, Object>> activitybulletin=new ArrayList<HashMap<String,Object>>();
//		try {
//			Session session= HibernateSessionFactory.getSession();
//			session.beginTransaction();
//			String sql="select   activity.activityId,activity.activityName,activestage.activestagePic from activity,activestage where activestage.activestageId=(select min(activestage.activestageId) from activestage where  activity.activityId=activestage.activityId and activityType="+ActivityType.out+" and activityState >="+ActivityState.GOING_STAGE+" and organizationId="+organizationid+" )";
//			
//			Query query=session.createSQLQuery(sql);
//			List<Object[]> objects=query.list();
//			for(Object[] object : objects){    
//				HashMap<String, Object> map=new HashMap<String, Object>();
//				int activityId = Integer.parseInt(String.valueOf(object[0]));
//				String activityName = (String)object[1];    
//				String activestagePic= (String)object[2];  
//	            map.put("activityId", activityId);
//	            map.put("activityName", activityName);
//	            map.put("activestagePic", activestagePic);
//	            activitybulletin.add(map);
//	        }    
//			HibernateSessionFactory.closeSession();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
//		return activitybulletin;
//	}

	// public List<HashMap<String, Object>>
	// QueryActivityBulletinByOrganizationId(int organizationid){
	// List<HashMap<String, Object>> activitybulletin=new
	// ArrayList<HashMap<String,Object>>();
	// try {
	// Session session= HibernateSessionFactory.getSession();
	// session.beginTransaction();
	// String
	// sql="select   activity.activityId,activity.activityName,activestage.activestagePic from activity,activestage where activestage.activestageId=(select min(activestage.activestageId) from activestage where  activity.activityId=activestage.activityId and activityType="+ActivityType.out+" and activityState >="+ActivityState.GOING_STAGE+" and organizationId="+organizationid+" )";
	//			
	// Query query=session.createSQLQuery(sql);
	// List<Object[]> objects=query.list();
	// for(Object[] object : objects){
	// HashMap<String, Object> map=new HashMap<String, Object>();
	// int activityId = Integer.parseInt(String.valueOf(object[0]));
	// String activityName = (String)object[1];
	// String activestagePic= (String)object[2];
	// map.put("activityId", activityId);
	// map.put("activityName", activityName);
	// map.put("activestagePic", activestagePic);
	// activitybulletin.add(map);
	// }
	// HibernateSessionFactory.closeSession();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return activitybulletin;
	// }

	// /*只查询实体类中password及email属性*/
	// public void query_for_list(){
	// Session session = HibernateSessionFactory.getSession();
	// /*id=2存在2条数据，查询报错：
	// * org.hibernate.HibernateException:
	// * More than one row with the given identifier was found: 2, for class:
	// cn.com.songjy.sh.domain.User
	// User user = (User) session.load(User.class, 2);
	// System.out.println(user.getEmail());
	// */
	// Query query =
	// session.createQuery("SELECT u.password,u.email FROM User u WHERE u.id=2");
	// List list = query.list();
	// Object[] obj = null;
	// for(int i=0; i<list.size(); i++){
	// obj = (Object[]) list.get(i);
	// for(Object o : obj){
	// System.out.println(o);
	// }
	// }
	// HibernateSessionFactory.closeSession(session);
	// }

	// 根据用户id修改用户状态
	public boolean changerUserState(int userId, int userState) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql = "update User set UserState = " + userState
					+ " where UserId=" + userId;
			Query query = session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 根据用户id修改用户密码
	public boolean changerUserPassword(int userId, int password) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql = "update User set UserPassword = " + password
					+ " where UserId=" + userId;
			Query query = session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 通过页数查找客户
	public List<User> getUserByPage(int page) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from User order by UserId asc";
		Query query = session.createQuery(sql);
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List<User> findResult = query.list();
		session.getTransaction().commit();
		session.close();
		return findResult;
	}

	// 查看客户数
	public int getUserNumber() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count = 0;
		try {
			count = ((Long) session.createQuery(
					"select count(UserId) from User ").iterate().next())
					.intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) count;
	}

	// 按名字模糊查找客户的数量
	public int queryUserNumberByName(String UserName) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count = 0;
		try {
			count = ((Long) session.createQuery(
					"select count(UserId) from User where UserName like '%"
							+ UserName + "%'").iterate().next()).intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) count;
	}

	// 按客户名、页数模糊查找
	public List<User> queryUserByName(String UserName, int page) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from User where UserName like '%" + UserName + "%'";
		Query query = session.createQuery(sql);
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List<User> findResult = query.list();
		session.getTransaction().commit();
		session.close();
		return findResult;
	}
}
