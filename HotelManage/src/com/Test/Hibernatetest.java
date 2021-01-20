package com.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;

import com.Bll.CBllFrame;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Dao.CDaoFrameImpl;
import com.Dao.CDaoOrder;
import com.Dao.CDaoRoom;
import com.Dao.IDaoFrame;
import com.Entity.Address;
import com.Entity.Cleaner;
import com.Entity.OrderTable;
import com.Entity.Room;
import com.Entity.User;


public class Hibernatetest {
	public static void main(String[] args) {
		ICBllFrame icBllFrame = new CBllImpl();
		IDaoFrame iDaoFrame = new CDaoFrameImpl();
		String AddressProvince = "�㽭ʡ";
		String AddressCity = "������";
		String AddressVillage = "������";
		String DetatilAddress = "����";
		Address  address = iDaoFrame.queryAddress(AddressProvince, AddressCity, AddressVillage);
//		int page = 1;
//		int number = icBllFrame.getOrderNumberByAddress(AddressProvince, AddressCity, AddressVillage, DetatilAddress);
//		System.out.println(number);
//		List<OrderTable> orders = icBllFrame.getOrdersByAddress(AddressProvince, AddressCity, AddressVillage, DetatilAddress, page);
//		for (OrderTable orderTable : orders) {
//			System.out.println(orderTable);
//		}
		//sessionTest();
		//sessionuser();
		//User user=new User();
//		Room room = new Room();
//		CDaoUser daouser=new CDaoUser();
//		IDaoFrame iDaoFrame = new CDaoFrameImpl();
//		CDaoRoom cDaoRoom = new CDaoRoom();
//		CDaoOrder cDaoOrder = new CDaoOrder();
//		int addressid = 3 ;
//		String RoomDetailAddress = "";
//		List<Integer> rooms = cDaoRoom.queryRoomByAddressWithoutPage(addressid, RoomDetailAddress);
//		List<List<OrderTable>> orders = cDaoOrder.queryOrderByAddress(rooms);
//		for (List<OrderTable> list : orders) {
//			for (OrderTable orderTable : list) {
//				System.out.println(orderTable);
//			}
//		}
		//		for (Integer room : rooms) {
//			System.out.println(room);
//		}
//		CDaoOrder cDaoOrder = new CDaoOrder();
//		String address = "���";
//		List<Room> rooms = iDaoFrame.queryRoomByAddressViilage(address);
//		List<List<OrderTable>> orders = cDaoOrder.queryOrderByAddress(rooms);
//		for (List<OrderTable> list : orders) {
////			System.out.println(list.size());
//			for (OrderTable orderTable : list) {
//				System.out.println(orderTable);
//			}
//		}
		
		
//		int count = cDaoOrder.queryOrderNumberByAddress(rooms);
//		System.out.println(count);
//		ICBllFrame icBllFrame = new CBllImpl();
//		CBllFrame cBllFrame = new CBllFrame();
//		String  UserName = "��";
//		int page = 1;
//		List<User> user = icBllFrame.getUserByName(UserName, page);
//		List<User> user = cBllFrame.getUserByName(UserName, page);
//		for (User user2 : user) {
//			System.out.println(user2);
//		}
//		int count = iDaoFrame.queryUserNumberByName(UserName);
//		List<User> users = iDaoFrame.queryUserByName(UserName, page);
//		for (User user2 : users) {
//			System.out.println(user2);
//		}
//		System.out.println(count);
//		int addressid = 2;
//		String RoomDetailAddress = "����";
//		int page = 1;
//		int i = iDaoFrame.GetRoomNumberByAddress(addressid, RoomDetailAddress);
//		LinkedMap maps = iDaoFrame.QueryRoomByAddress(addressid, RoomDetailAddress, page);
//		Iterator ite=maps.entrySet().iterator();
//		while(ite.hasNext()){
//			Map.Entry entry=(Map.Entry)ite.next();
//			Object value=entry.getValue();
//			LinkedMap map=(LinkedMap)value;
//			Room room = (Room) map.get("Room");
//			Address address = (Address) map.get("Address");
//			System.out.println(room);
//			System.out.println(address);
//		}
		
		//		System.out.println(i);
		
//		ICBllFrame icBllFrame = new CBllImpl();
		
//		List<Cleaner> cleaners = iDaoFrame.QueryAllCleaner();
//		System.out.println(cleaners);
//		String AddressCity = "������";
//		String AddressProvince = "�㽭ʡ";
//		String AddressVillage = "������";
//		Address address = icBllFrame.QueryAddressId(AddressProvince, AddressCity, AddressVillage);
//		List<Room> rooms = icBllFrame.QueryRoomByArea(address);
//		System.out.println(address);
//		for (Room room : rooms) {
//			System.out.println(room);
//			System.out.println("====");
//		}
		
//	    CDaoRechargeRecord daorechargeRecord=new CDaoRechargeRecord();
	    
//	    CDaoConsumptionRecord daoconsumptionRecord=new CDaoConsumptionRecord();
	    
	    //OrderTable order=new OrderTable();
//	    CDaoOrder daoOrder=new CDaoOrder();
	    
	    
	   //��ѯ���з���
//	    List<Room> rooms = iDaoFrame.QueryRooms();
//	    for (Room room : rooms) {
//			System.out.println(room.getRoomId());
//		}
		
		
//		HashMap maps = icBllFrame.QueryAllRooms();
//		System.out.println(maps.size());
//		for(int i = 1;i<=maps.size();i++){
//			HashMap map = (HashMap) maps.get(i);
//			Room room = (Room) map.get("Room");
//			System.out.println(room.getRoomId());
//		}
		
		
		//�½��ͻ���
//      user.setUserIDNumber("1111");
//		daouser.CreateUser(user);
		
		
		// ��ѯ�ͻ����������Ϣ
//		List<User> result= daouser.SearchtotalUser();
//		System.out.print(result);
		
		//��ѯ�����û���Ϣ
//		int userid=1;
//		User result= daouser.SearcheachUser(userid);
//		System.out.print(result);
		
		//�޸��û���Ϣ���޸��û���״̬��
//		user.setUserId(1);
//		user.setUserState(-1);
//		daouser.DisappearUser(user);		
//		System.out.print(user);
		
		
//		//�½���ֵ��¼��
//		RechargeRecord rechargeRecord=new RechargeRecord(200,0);
//		daorechargeRecord.CreateRecode(rechargeRecord);
//		System.out.println(rechargeRecord);
		
//		//��ѯ��ֵ��¼
//		int UserId=0;
//		List<RechargeRecord> rechargeRecords=daorechargeRecord.SearchRecode(UserId);
//		System.out.print(rechargeRecords);
		
		//�½����Ѽ�¼
//		ConsumptionRecord consumptionRecord=new ConsumptionRecord(100,"xxx",0);
//		daoconsumptionRecord.CreateConsumptionRecord(consumptionRecord);
//		System.out.print(consumptionRecord);
	    
	  //��ѯ���Ѽ�¼
//		int UserId=0;
//		List<ConsumptionRecord> consumptionRecord=daoconsumptionRecord.SearchConsumptionRecord(UserId);
//		System.out.print(consumptionRecord);
		
		//�½�����
//		OrderTable order=new OrderTable(2,2,"1-1","1-1",100,1,1,508);
//		daoOrder.CreateOrder(order);
//		System.out.print(order);
		
		//�༭����
//		order.setOrderId(1);
//		order.setOrderState(-1);
//		daoOrder.QueryOrder(order);		
//		System.out.print(order);
	    
	    //ͨ�������Ų��Ҷ�����Ϣ
//	    int orderid=1;
//	    OrderTable result= daoOrder.QueryDetailOrder(orderid);
//		System.out.print(result);
	    
	    //ͨ���û������Ҷ�����Ϣ
//	    int userid=1;
//	    List<OrderTable> order=daoOrder.QueryuserOrder(userid);
//	    System.out.print(order);
	    
	  //ͨ���������Ҷ�����Ϣ
//	    List<OrderTable> order=daoOrder.QueryareaOrder(2);
//	    System.out.print(order);
	    
//	    int userId=1;
//	    int userState=2;
//	    boolean result=daouser.changerUserState(userId, userState);
//	    System.out.print(result);
	    
	  //ͨ�������ѯ�û���Ϣ
	    //String useremail="@"; 
//	    List<User> result=daouser.Queryemailuser("11@");
//	    System.out.print(result);
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void  sessionTest() {
		// TODO Auto-generated method stub
		
		//Address address=new Address();
		
//		address.setAddressCity("����");
//		address.setAddressProvince("�㽭");
//		address.setAddressVillage("�绯");
//		
//		Session session=HibernateUtil.getSession();
//		Transaction tx=session.beginTransaction();
//		session.save(address);
//		tx.commit();
//		session.close();
//		

	}
}
