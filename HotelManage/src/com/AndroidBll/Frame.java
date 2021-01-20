package com.AndroidBll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.mapping.Map;

import com.AndroidTool.OperationCode;
import com.Dao.CDaoFrameImpl;
import com.Dao.IDaoFrame;
import com.Entity.Cleaner;
import com.Entity.CleaningRecord;
import com.Entity.OrderTable;
import com.Entity.Room;
import com.Entity.RoomCommit;
import com.Entity.RoomEquipment;
import com.Entity.User;
import com.Entity.UserCommit;

public class Frame {
	IDaoFrame iDaoFrame = new CDaoFrameImpl();
	public Room GetRoomDetail(int roomId)
	{
		Room room = iDaoFrame.QueryRoomDetail(roomId);
		return room;
	}
	public boolean CreateOrder(OrderTable oo)
	{
		boolean flag = false;
		flag = iDaoFrame.CreateOrder(oo);
		return flag;
	}
	
	public 	List<HashMap<String, Object>> GetOrderAndRoomByOrderId(int id)
	{
		List<OrderTable> order = iDaoFrame.QueryuserOrder(id);
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < order.size(); i++) {
			Room room=iDaoFrame.QueryRoomDetail(order.get(i).getRoomId());
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("order", order.get(i));
			map.put("room", room);
			maps.add(map);
		}
		return maps;
	}

	public 	List<HashMap<String, Object>> GetRoomCommitDetail(int roomid)
	{
		List<RoomCommit> commits = iDaoFrame.QueryRoomCommitByRoom(roomid);
		List<HashMap<String, Object>> maps=new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < commits.size(); i++) {
			User user = iDaoFrame.SearcheachUser(commits.get(i).getUserId());
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put(OperationCode.RoomCommit.RoomCommitContent, commits.get(i).getRoomCommitContent());
			map.put(OperationCode.RoomCommit.RoomCommitRank, commits.get(i).getRoomCommitRank());
			map.put(OperationCode.User.UserName, user.getUserName());
			map.put(OperationCode.User.UserPicture, user.getUserPicture());
			maps.add(map);
		}
		return maps;
	}
	
	
	public List<Cleaner> CleanerLoginByPhone(String phone, String pwd) {
		List<Cleaner> result = null;
		List<Cleaner> cleaner = iDaoFrame.QueryCleanerByPhone(phone);
		for(int i=0; i<cleaner.size(); i++){
			if(cleaner.get(i).getCleanerPassWord().equals(pwd)){
				System.out.print("��¼�ɹ���");
				result = cleaner;
			}
			else{
				System.out.print("��������������Ŷ��");
			}
		}
		return result;
	}
	
	public List<Room> GetRoomByRoomUsingState(int state)
	{
		List<Room> rooms = iDaoFrame.QueryRoomByUsingState(state);
		return rooms;
	}
	
	public List<Room> GetRoomByAddressViilage(String address)
	{
		List<Room> rooms = iDaoFrame.queryRoomByAddressViilage(address);
		return rooms;
	}

	public boolean CancelOrder( int orderid, int userid) {
		// ����orderid��orderȡ��state
		boolean flag = iDaoFrame.changeOrderState(orderid, -1);
		return flag;
	}
	/**
	 * FinishOrder
	 * �������û����㶩��
	 * ���ܣ�
	 * 	1. �޸Ķ���״̬Ϊ����
	 *  2. �޸ķ���״̬Ϊ��
	 * @param orderid
	 * @param userid
	 * @param roomid
	 * @return
	 */
	public boolean FinishOrder(int orderid, int userid, int roomid)
	{
		boolean flag = false;
		// ����orderid��orderstate--����
		boolean flag1 = iDaoFrame.changeOrderState(orderid, 1);
		// ����roomid��roomUsingState--�շ���
		boolean flag2 = iDaoFrame.UsingCheckRoom(roomid, 2);
		flag = flag1&flag2;
		return flag;
	}
	
	/**
	 * RenewOrder
	 * ������
	 * @param orderid
	 * @param daycount
	 * @param roomprice
	 * @return
	 */
	public boolean RenewOrder(int orderid, int daycount, int roomprice)
	{
		// Order oo = new Order();
		OrderTable oo = iDaoFrame.QueryDetailOrder(orderid);
		String checkouttime = oo.getOrderCheckoutTime();
		// TODO:new Impl().getCycleEndTime(checkintime, daycount);
		String orderCheckoutTime = new Impl().getCycleEndTime(checkouttime, daycount);
		// �޸Ķ������˷���
		oo.setOrderCheckoutTime(orderCheckoutTime);
		// �޸Ķ�����״̬--5 ������
		oo.setOrderState(5);
		
		// TODO:�û������޸Ľ��
		int orderMoney = oo.getOrderMoney() + daycount*roomprice;
		oo.setOrderMoney(orderMoney);
		
		// �޸��û���ס����
		int afterOrderRenewDay = oo.getOrderStayinDay() + daycount;
		oo.setOrderStayinDay(afterOrderRenewDay);
		boolean flag = iDaoFrame.QueryOrder(oo);
		return flag;
	}
	
	public List<Room> PCleanerGetRoom(int cleanerid)
	{
		List<Room> rooms = iDaoFrame.GetCleanerChargeRoomByCleanerID(cleanerid);
		return rooms; 
	}
	
	public boolean CleanerCommitRoom(RoomCommit room)
	{
		boolean rooms = iDaoFrame.CreateRoomCommit(room);
		return rooms; 
	}
	
	public boolean CleanerCleaningStart(CleaningRecord cr)
	{
		boolean flag = iDaoFrame.addCleaningRecord(cr);
		return flag;
	}
	
	public List<CleaningRecord> CleanerQueryCleaningHistroy(int cleanerid)
	{
		List<CleaningRecord> cc = iDaoFrame.queryCleaningRecordByCleanerId(cleanerid);
		return cc;
	}
	
	public RoomEquipment GetRoomEquipmentsList(int id)
	{
		RoomEquipment equipment =iDaoFrame.QueryRoomEquipment(id);
		return equipment;
	}
	
	public OrderTable GetOrderByOrderId(int orderid)
	{
		OrderTable orderTables = iDaoFrame.QueryDetailOrder(orderid);
		return orderTables;
	}
	
	public boolean CleanerCommitUser(UserCommit uc) {
		
		boolean flag = iDaoFrame.UserCommentRoom(uc);
		return flag;
	}
	
	public List<HashMap<String, Object>> GetRoomList(String village) {
		
		List<HashMap<String, Object>> adressRoomList = new ArrayList<HashMap<String, Object>>();		
		// ��ѯĳ������������
		List<Room> adressRoomCountList = iDaoFrame.queryRoomByAddressViilage(village);
		int RoomCount = adressRoomCountList.size();
		// ��ѯĳ����ʣ�෿������
		List<Room> adressRoomCountLeft = iDaoFrame.GetLeftRoomInfoByAddress(village);
		int LeftRoomCount = adressRoomCountLeft.size();
		// ��ѯʣ�෿�����Ϣ
		HashMap<String, Object> adressRoom = new HashMap<String, Object>();
		adressRoom.put("AllRoomCount", RoomCount);
		adressRoom.put("LeftRoomCount", LeftRoomCount);		
		adressRoom.put(OperationCode.Room.RoomList, adressRoomCountLeft);
		
		adressRoomList.add(adressRoom);
		return adressRoomList;
	}
	
	public List<Room> GetEligibleRoom(int roomtype, String village) {
		// ͨ����ׯ��Ϣ��ȡ�����б�
		List<Room> roomList = iDaoFrame.queryRoomByAddressViilage(village);
		System.out.println(roomList);
		System.out.println(roomList.size());
		Iterator <Room> it = roomList.iterator(); 
//		while(it.hasNext())  
//		{  
//		    if(it.next().getRoomType() != roomtype)  
//		    {  
//		        it.remove();  
//		    }  
//		} 
		// ɸѡ�����������ķ����б�
		for (int i=0; i < roomList.size(); i++) {
			if(roomList.get(i).getRoomType() != roomtype) {
				roomList.remove(i);
				i = i-1;
			}
		}
		return roomList;
	}
	
	// ---------�ͻ�����---------
	public boolean CreateRoomCommit(RoomCommit roomCommit){
		boolean result=iDaoFrame.CreateRoomCommit(roomCommit);
		return result;
	}
	
	//�û�ע��
	public boolean CreateUser(User user){
		boolean result=iDaoFrame.CreateUser(user);
		return result;
	}
}
