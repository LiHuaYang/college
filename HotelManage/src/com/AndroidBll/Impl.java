package com.AndroidBll;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.Entity.Cleaner;
import com.Entity.CleaningRecord;
import com.Entity.OrderTable;
import com.Entity.Room;
import com.Entity.RoomCommit;
import com.Entity.RoomEquipment;
import com.Entity.User;
import com.Entity.UserCommit;

public class Impl implements IFrame{

	Frame frame=new Frame();
	
	public Room GetRoomDetail(int roomId) {
		
		Room room = frame.GetRoomDetail(roomId);
		return room;
	}

	public boolean CreateOrder(OrderTable oo) {
	
		boolean flag = frame.CreateOrder(oo);
		return flag;
	}
	
	public String TransDateStr(String str)
	{
		String[] str1=str.split("-");
		String startTimeNew="";
		for (int i = 0; i < str1.length; i++) {
			startTimeNew+=str1[i];
			if (i!=str1.length-1) {
				startTimeNew+="/";
			}
		}
		return startTimeNew;
	}

	
	// 传入时间和天数，返回和
	public String getCycleEndTime(String startTime, int planDays)
	{
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=sFormat.parse(startTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH,planDays);
		Date resultDate=calendar.getTime();
		String result=sFormat.format(resultDate);
		
		return result;
	}

	public List<HashMap<String, Object>> GetOrderAndRoomByOrderId(int id) {
		
		List<HashMap<String, Object>> order = frame.GetOrderAndRoomByOrderId(id);
		return order;
	}

	
	public List<Cleaner> CleanerLoginByPhone(String phone, String pwd) {
		
		List<Cleaner> cleaner = frame.CleanerLoginByPhone(phone, pwd);
		return cleaner;
	}

	public List<Room> GetRoomByRoomUsingState(int state) {
		
		List<Room> rooms = frame.GetRoomByRoomUsingState(state);
		return rooms;
	}
	
	public List<Room> GetRoomByAddressViilage(String address) {
		
		List<Room> rooms = frame.GetRoomByAddressViilage(address);
		return rooms;
	}

	public boolean CancelOrder(int orderid, int userid) {
		boolean flag = frame.CancelOrder(orderid, userid);
		return flag;
	}
	
	// ---------客户评价---------
	public boolean CreateRoomCommit(RoomCommit roomCommit){
		boolean result=frame.CreateRoomCommit(roomCommit);
		return result;
	}
	
	//用户注册
	public boolean CreateUser(User user) {
		boolean result=frame.CreateUser(user);
		return result;
	}

	public boolean FinishOrder(int orderid, int userid, int roomid) {
		boolean flag = frame.FinishOrder(orderid, userid, roomid);
		return flag;
	}

	public List<Room> PCleanerGetRoom(int cleanerid) {
		List<Room> rooms = frame.PCleanerGetRoom(cleanerid);
		
		return rooms;
	}

	public boolean CleanerCommitRoom(RoomCommit room) {
		boolean flag = frame.CleanerCommitRoom(room);
		return flag;
	}

	public boolean CleanerCleaningStart(CleaningRecord cr) {
		boolean flag = frame.CleanerCleaningStart(cr);
		return flag;
	}

	public List<CleaningRecord> CleanerQueryCleaningHistroy(int cleanerid) {
		
		List<CleaningRecord> cc = frame.CleanerQueryCleaningHistroy(cleanerid);
		return cc;
	}

	public RoomEquipment GetRoomEquipmentsList(int id) {
		
		RoomEquipment equipment = frame.GetRoomEquipmentsList(id);
		return equipment;
	}

	public boolean RenewOrder(int orderid, int daycount, int roomprice) {
		
		boolean flag = frame.RenewOrder(orderid, daycount, roomprice);
		return flag;
	}

	public OrderTable GetOrderByOrderId(int orderid) {
		
		OrderTable orderTables = frame.GetOrderByOrderId(orderid);
		return orderTables;
	}

	public boolean CleanerCommitUser(UserCommit uc) {
		
		boolean flag  = frame.CleanerCommitUser(uc);
		return flag;
	}
	
	
	public List<HashMap<String, Object>>GetRoomCommitDetail(int roomid) {
		
		List<HashMap<String, Object>> detaillist = null;
		detaillist = frame.GetRoomCommitDetail(roomid);
		return detaillist;
	}

	public List<HashMap<String, Object>> GetRoomList(String village) {
		
		List<HashMap<String, Object>> detaillist = null;
		detaillist = frame.GetRoomList(village);
		return detaillist;
	}

	public List<Room> GetEligibleRoom(int roomtype, String village) {
		
		List<Room> roomList = frame.GetEligibleRoom(roomtype, village);
		return roomList;
	}
}
