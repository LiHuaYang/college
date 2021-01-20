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
		String AddressProvince = "浙江省";
		String AddressCity = "宁波市";
		String AddressVillage = "海曙区";
		String DetatilAddress = "宁波";
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
//		String address = "奉化市";
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
//		String  UserName = "金";
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
//		String RoomDetailAddress = "宁波";
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
//		String AddressCity = "宁波市";
//		String AddressProvince = "浙江省";
//		String AddressVillage = "江北区";
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
	    
	    
	   //查询所有房间
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
		
		
		//新建客户表
//      user.setUserIDNumber("1111");
//		daouser.CreateUser(user);
		
		
		// 查询客户表的所有信息
//		List<User> result= daouser.SearchtotalUser();
//		System.out.print(result);
		
		//查询单个用户信息
//		int userid=1;
//		User result= daouser.SearcheachUser(userid);
//		System.out.print(result);
		
		//修改用户信息（修改用户的状态）
//		user.setUserId(1);
//		user.setUserState(-1);
//		daouser.DisappearUser(user);		
//		System.out.print(user);
		
		
//		//新建充值记录表
//		RechargeRecord rechargeRecord=new RechargeRecord(200,0);
//		daorechargeRecord.CreateRecode(rechargeRecord);
//		System.out.println(rechargeRecord);
		
//		//查询充值记录
//		int UserId=0;
//		List<RechargeRecord> rechargeRecords=daorechargeRecord.SearchRecode(UserId);
//		System.out.print(rechargeRecords);
		
		//新建消费记录
//		ConsumptionRecord consumptionRecord=new ConsumptionRecord(100,"xxx",0);
//		daoconsumptionRecord.CreateConsumptionRecord(consumptionRecord);
//		System.out.print(consumptionRecord);
	    
	  //查询消费记录
//		int UserId=0;
//		List<ConsumptionRecord> consumptionRecord=daoconsumptionRecord.SearchConsumptionRecord(UserId);
//		System.out.print(consumptionRecord);
		
		//新建订单
//		OrderTable order=new OrderTable(2,2,"1-1","1-1",100,1,1,508);
//		daoOrder.CreateOrder(order);
//		System.out.print(order);
		
		//编辑订单
//		order.setOrderId(1);
//		order.setOrderState(-1);
//		daoOrder.QueryOrder(order);		
//		System.out.print(order);
	    
	    //通过订单号查找订单信息
//	    int orderid=1;
//	    OrderTable result= daoOrder.QueryDetailOrder(orderid);
//		System.out.print(result);
	    
	    //通过用户名查找订单信息
//	    int userid=1;
//	    List<OrderTable> order=daoOrder.QueryuserOrder(userid);
//	    System.out.print(order);
	    
	  //通过地区查找订单信息
//	    List<OrderTable> order=daoOrder.QueryareaOrder(2);
//	    System.out.print(order);
	    
//	    int userId=1;
//	    int userState=2;
//	    boolean result=daouser.changerUserState(userId, userState);
//	    System.out.print(result);
	    
	  //通过邮箱查询用户信息
	    //String useremail="@"; 
//	    List<User> result=daouser.Queryemailuser("11@");
//	    System.out.print(result);
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void  sessionTest() {
		// TODO Auto-generated method stub
		
		//Address address=new Address();
		
//		address.setAddressCity("宁波");
//		address.setAddressProvince("浙江");
//		address.setAddressVillage("风化");
//		
//		Session session=HibernateUtil.getSession();
//		Transaction tx=session.beginTransaction();
//		session.save(address);
//		tx.commit();
//		session.close();
//		

	}
}
