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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-13����08:42:43
	 *��������SaveParticipants
	 *���ܣ�����������Ա
	 *������@param participants
	 *����ֵ��boolean
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
	  *���ߣ�movie
	  *ʱ�䣺2015-10-14����04:23:08
	  *��������QueryParticipantsByActivityId
	  *���ܣ����ݻID��ѯ�������Ա
	  *������@param activityId
	  *����ֵ��List<Participants>
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
