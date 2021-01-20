package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.Entity.Participants;
import com.Tool.HIbernateSessionFactory;


public class DaoParticipants {
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午08:42:43
	 *函数名：SaveParticipants
	 *功能：批量保存活动人员
	 *参数：@param participants
	 *返回值：boolean
	 */
	 public boolean SaveParticipants(List<Participants> participants){
		 boolean result=false;
		 try {
			Session session = HIbernateSessionFactory.beforeClass().openSession();
			session.beginTransaction();
			session.clear();
			String sql="insert into Participants(activityId,participantsId,participantsName) values";
			for (int i = 0; i < participants.size(); i++) {
				sql+="("+participants.get(i).getActivityId()+","+participants.get(i).getParticipantsId()+",'"+participants.get(i).getParticipantsName()+"'),";
			}
			sql=sql.substring(0, sql.length()-1); 
			SQLQuery sqlQuery=session.createSQLQuery(sql);
			sqlQuery.executeUpdate();
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
	  *时间：2015-10-14下午04:23:08
	  *函数名：QueryParticipantsByActivityId
	  *功能：根据活动ID查询活动参与人员
	  *参数：@param activityId
	  *返回值：List<Participants>
	  */
	 public List<Participants> QueryParticipantsByActivityId(int activityId){
		 List<Participants> participants=new ArrayList<Participants>();
		 try {
			 
			 Session session= HIbernateSessionFactory.beforeClass().getCurrentSession();
			 session.beginTransaction();
			 String hql="from Participants where activityId="+activityId;
			 Query query=session.createQuery(hql);query.setCacheable(false);
			 participants=query.list();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return participants;
	 }
	 
	
}
