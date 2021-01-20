package com.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Entity.OrderTable;
import com.Test.HibernateUtil;


public class CDaoOrder {

	
	//新建订单
	public boolean CreateOrder(OrderTable order){
		
		boolean result=false;
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			HibernateUtil.closeSession();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//编辑订单
	public boolean QueryOrder(OrderTable order){
		boolean result=false;
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			session.update(order);
			session.getTransaction().commit();
			HibernateUtil.closeSession();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//通过订单id修改订单状态
	public boolean changerorderState(int orderId,int orderState){
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			String hql="update OrderTable set OrderState = "+orderState+" where OrderId="+orderId;
			Query query=session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	//通过订单号查找订单信息
	public OrderTable QueryDetailOrder(int orderId){
	    OrderTable order=null;	
	
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			order=(OrderTable) session.get(OrderTable.class, orderId);
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	//通过用户id查找订单信息
	@SuppressWarnings("unchecked")
	public List<OrderTable> QueryuserOrder(int userId){
	    List<OrderTable> order=new ArrayList<OrderTable>();	
	
	    try {
			 Session session=HibernateUtil.getSession();
			 session.beginTransaction();
			 String hql="from OrderTable where userId="+userId;
			 Query query=session.createQuery(hql);
			 order=query.list();
			 HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	//通过地区查找订单信息
	@SuppressWarnings("unchecked")
	public List<OrderTable> QueryareaOrder(int Addressid){
	    List<OrderTable> order=new ArrayList<OrderTable>();	
	    
	    try {
			 Session session=HibernateUtil.getSession();
			 session.beginTransaction();
			 String hql="select * from OrderTable where RoomId in (select * from Room where Addressid = "+Addressid+")";
			 Query query=session.createSQLQuery(hql);
			 order=query.list();
			 HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	//通过入住的时间查找订单信息
	@SuppressWarnings("unchecked")
	public List<OrderTable> QuerytimeOrder(int OrderCheckinTime){
	    List<OrderTable> order=new ArrayList<OrderTable>();	
	
	    try {
			 Session session=HibernateUtil.getSession();
			 session.beginTransaction();
			 String hql="from OrderTable where OrderCheckinTime="+OrderCheckinTime;
			 Query query=session.createQuery(hql);
			 order=query.list();
			 HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	//通过房间查找订单信息
	@SuppressWarnings("unchecked")
	public List<OrderTable> QueryroomOrder(int RoomId){
	    List<OrderTable> order=new ArrayList<OrderTable>();	
	
	    try {
			 Session session=HibernateUtil.getSession();
			 session.beginTransaction();
			 String hql="from OrderTable where RoomId="+RoomId;
			 Query query=session.createQuery(hql);
			 order=query.list();
			 HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	//用户续房，通过OrderId,改变订单状态为5和入住天数
	public boolean changeOrderDayState(int OrderId,int OrderStayinDay,String OrderCheckOutTime,int OrderMoney){
		boolean result=false;
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			String hql="update OrderTable set OrderState = 5,OrderStayinDay="+OrderStayinDay+",OrderCheckoutTime='"+OrderCheckOutTime+"',OrderMoney="+OrderMoney+" where OrderId="+OrderId;
			Query query=session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
			result=true;
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	//通过OrderId改变房间状态
	public boolean changeOrderState(int OrederId,int OrderState){
		boolean result=false;
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			String hql="update OrderTable set OrderState ="+OrderState+" where OrderId="+OrederId;
			
			Query query=session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
			result=true;
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//查找所有订单
	public List<OrderTable> queryOrderTables(){
		List<OrderTable> orderTables = null;
		try {
			Session session= HibernateUtil.getSession();
			session.beginTransaction();
			orderTables = session.createQuery("from OrderTable").list();
			session.getTransaction().commit();
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderTables;
	}
	
	//通过页数查订单
	public List<OrderTable> queryOrderTablesByPage(int page){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql="from OrderTable order by OrderId asc";
		Query query=session.createQuery(sql);
		query.setFirstResult((page-1)*10);
		query.setMaxResults(10);
		List<OrderTable> findResult=query.list();
		session.getTransaction().commit();			
		session.close();
		return findResult;
	}

	//查看订单数
	public int getOrderNumber(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count=0;
		try {
			 count=((Long)session.createQuery("select count(OrderId) from OrderTable ").iterate().next()).intValue(); 
			 session.getTransaction().commit();			
			 session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return (Integer)count;
	}

	//用房间（多个房间）查看订单数
	public int queryOrderNumberByAddress(List<Integer> rooms){
		int count=0;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			for (Integer roomid : rooms) {
				String sql = "select count(OrderId) from OrderTable where RoomId = "+roomid+"";
				int num = ((Long) session.createQuery(sql).iterate().next()).intValue();
				count = count + num;
			}
			 session.getTransaction().commit();			
			 session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return (Integer)count;
	}
	//用房间（多个房间）获取多个订单信息
	public List<List<OrderTable>> queryOrderByAddress(List<Integer> rooms){
		List<List<OrderTable>> orders = new ArrayList<List<OrderTable>>();
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			for (Integer roomid : rooms) {
				List<OrderTable> orders2 = new ArrayList<OrderTable>();
				String sql = "from OrderTable where RoomId = "+roomid+"";
				Query query = session.createQuery(sql);
				orders2 = query.list();
				orders.add(orders2);
			}
			session.getTransaction().commit();			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return orders;
	}
	
	//根据入住时间和退房时间来订单信息
	public List<OrderTable> queryorderbytime(String OrderCheckinTime,String OrderCheckoutTime){
		List<OrderTable> order=new ArrayList<OrderTable>();	
		
	    try {
			 Session session=HibernateUtil.getSession();
			 session.beginTransaction();
			 String hql="from OrderTable where OrderCheckinTime!='"+OrderCheckinTime+"' and OrderCheckoutTime!='"+OrderCheckoutTime+"'";
			 Query query=session.createQuery(hql);
			 order=query.list();
			 HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
}
