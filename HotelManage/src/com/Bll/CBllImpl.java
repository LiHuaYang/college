package com.Bll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.collections.map.LinkedMap;
import com.Entity.Address;
import com.Entity.Cleaner;
import com.Entity.CleanerWorkArrange;
import com.Entity.CleaningRecord;
import com.Entity.Manager;
import com.Entity.OrderTable;
import com.Entity.Room;
import com.Entity.RoomCommit;
import com.Entity.RoomEquipment;
import com.Entity.Transaction;
import com.Entity.User;
import com.Entity.UserCommit;

public class CBllImpl implements ICBllFrame {
	CBllFrame cBllFrame = new CBllFrame();

	// -----------------------�������----------------------------
	/**
	 * ��ţ�Room:1 ���ܣ��������� ������Room room,RoomEquipment,Address
	 * ��̬������RoomUsingState=1 ����ֵ:boolean
	 */
	public boolean CreateRoom(Room room, RoomEquipment roomEquipment,
			Address address) {
		if (cBllFrame.CreateRoom(room, roomEquipment, address.getAddressId())) {
			return true;
		}
		return false;
	}

	/**
	 * ��ţ�Room��9 ���ܣ�������������� ������RoomId��Lock/UNLOCK ����ֵ��boolean
	 */
	public boolean LockCheckRoom(int roomId, int CheckRoom) {
		if (cBllFrame.LockCheckRoom(roomId, CheckRoom)) {
			return true;
		}
		return false;
	}

	/**
	 * ��ţ�Room:4 ���ܣ���ѯ����������Ϣ+����Ӧ������Ϣ+�����豸��Ϣ ������int orderId ����ֵ:HashMap
	 */
	public HashMap<String, Object> QueryOrder(int orderId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map = cBllFrame.QueryOrder(orderId);
		return map;
	}

	/**
	 * ��ţ�Room:3 ���ܣ�ͨ��������ѯ���� ������Address address ����ֵ:Room
	 */
	public List<Room> QueryRoomByArea(Address address) {
		List<Room> rooms = new ArrayList<Room>();
		try {
			rooms = cBllFrame.QueryRoomByArea(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	/**
	 * ��ţ�Room:3 ���ܣ�ͨ������id��ѯ���� ������Address address ����ֵ:Room
	 */
	public List<Room> QueryRoomByAreaid(int addressId) {
		List<Room> room = cBllFrame.QueryRoomByAreaid(addressId);
		return room;
	}

	/**
	 * ��ţ�Room:5 ���ܣ�������״̬��ѯ���з��� ������int RoomUsingState ����ֵ:List<Room>
	 */
	public List<Room> QueryRoomByUsingState(int roomUsingState) {
		List<Room> rooms = new ArrayList<Room>();
		try {
			rooms = cBllFrame.QueryRoomByUsingState(roomUsingState);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	/**
	 * ��ţ�Room:2 ���ܣ���ѯ�������� ������int roomId ����ֵ:Room
	 */
	public HashMap<String, Object> QueryRoomDetail(int roomid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			map = cBllFrame.QueryRoomDetail(roomid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * ��ţ�Room:8 ���ܣ���ѯ��Ҫ�����ķ��� ������RoomLockState ����ֵ��List<Room>
	 */
	public List<Room> QueryRoomNeedLocking() {
		List<Room> rooms = new ArrayList<Room>();
		try {
			rooms = cBllFrame.QueryRoomNeedLocking();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	/**
	 * ��ţ�Room��7 ���ܣ��޸ķ��䷿������ ����:Room room,RoomE ����ֵ��boolean
	 */
	public boolean UptateRoom(Room room, RoomEquipment roomEquipment,
			Address address) {
		if (cBllFrame.UptateRoom(room, roomEquipment, address)) {
			return true;
		}
		return false;
	}

	/**
	 * Address��1 ���ܣ���������address �������� ����ֵ��List<address>
	 */
	public List<Address> QueryAllAddress() {
		List<Address> addresses = cBllFrame.QueryAllAddress();
		return addresses;
	}

	public LinkedMap GetPageRoomInfo(int page) {
		LinkedMap findResult = cBllFrame.GetPageRoomInfo(page);
		return findResult;
	}

	public int GetRoomNumber() {
		int number = cBllFrame.GetRoomNumber();
		return number;
	}

	// �������з���
	public List<Room> QueryAllRoom() {
		List<Room> rooms = cBllFrame.QueryAllRoom();
		return rooms;
	}

	// ͨ���������Ͳ��ҷ���
	public List<Room> QueryRoomByRoomtype(int roomtype) {
		List<Room> rooms = cBllFrame.QueryRoomByRoomtype(roomtype);
		return rooms;
	}
	
	//2016-01-09 ��������ѯ����
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice){
		List<Room> result=cBllFrame.QueryRoomselectcondition(village, indata, outdata, minprice, maxprice);
		return result;
	}
	
	// ------------------�û�����--------------------
	/**
	 * ��ţ�User:0 ���ܣ��½��û� ����:User user ����ֵ��boolean
	 */
	public boolean CreateUser(User user) {
		boolean result = cBllFrame.CreateUser(user);
		return result;
	}

	/**
	 * ��ţ�User:7 ���ܣ�ɾ���û� ����:User user ����ֵ��boolean
	 */
	public boolean DeleteUser(int userId) {
		if (cBllFrame.DeleteUser(userId)) {
			return true;
		}
		return false;
	}

	/**
	 * ���:User:24 ���ܣ�����/�����û� ���룺int userId��int userState ����ֵ��boolean
	 */
	public boolean LockCheckUser(int userId, int userState) {
		if (cBllFrame.LockCheckUser(userId, userState)) {
			return true;
		}
		return false;
	}

	/**
	 * ��ţ�User:8 ���ܣ���ѯ�����û���Ϣ ����:Null ����ֵ��List<User>
	 */
	public List<User> QueryAllUser() {
		List<User> users = new ArrayList<User>();
		try {
			users = cBllFrame.QueryAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * ��ţ�User:10 ���ܣ���ѯ�����û���Ϣ ����:int userId ����ֵ��User
	 */
	public User QuerySingelUser(int userId) {
		User user = new User();
		try {
			user = cBllFrame.QuerySingelUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// ͨ���û�id���ҳ��û�����֮���������Ϣ
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid) {
		List<HashMap<String, Object>> result = cBllFrame
				.QueryUserExceptPasswordById(userid);
		return result;
	}

	/**
	 * ��ţ�User:23 ���ܣ������û����� ����:User user ����ֵ��boolean
	 */
	public boolean ResetUserPassword(int userId, int password) {
		if (cBllFrame.ResetUserPassword(userId, password)) {
			return true;
		}
		return false;
	}

	/**
	 * <<<<<<< .mine ��ţ�User:12 ����:�޸��û���Ϣ ����:int userId��,User user ����ֵ��boolean
	 * ======= ��ţ�User:12 ����:�޸��û���Ϣ ����:int userId,User user ����ֵ��boolean >>>>>>>
	 * .r374
	 */

	// �޸Ĳ���
	public boolean UpdateUserPart(int userId, String userName, String userSex,
			String userBoth, String userPhone, String userEmail,
			String userIdNumber, String userMessage) {
		boolean result = cBllFrame.UpdateUserPart(userId, userName, userSex,
				userBoth, userPhone, userEmail, userIdNumber, userMessage);
		return result;
	}

	// �޸�ȫ��
	public boolean UpdateUser(int userId, User user) {
		boolean result = cBllFrame.UpdateUser(userId, user);
		return result;
	}

	// �����û�ͷ��
	public boolean ChangeUserPic(int userId, String userPicture) {
		boolean result = cBllFrame.ChangeUserPic(userId, userPicture);
		return result;
	}

	/**
	 * ��ţ�User:1 ���ܣ��û������¼ ����:int userId, String useremail, String password
	 * ����ֵ��boolean
	 */
	// ʹ�������¼��ǰ�����������䲻���ظ���
	public int UserLoginEmail(String useremail, String userpassword) {
		int result = cBllFrame.UserLoginEmail(useremail, userpassword);
		return result;
	}

	/**
	 * ��ţ�User:1 ���ܣ��û��ֻ��ŵ�¼ ����:int userId, String userphone, String password
	 * ����ֵ��boolean
	 */
	// ʹ�õ绰�����¼��ǰ���������绰���벻���ظ���ȣ�
	public int UserLoginPhon(String userphon, String userpassword) {
		int result = cBllFrame.UserLoginPhon(userphon, userpassword);
		return result;
	}

	// /**
	// * ��ţ�User:13
	// * ���ܣ��û���ֵ
	// * ����:RechargeRecord rechargeRecord
	// * ����ֵ��boolean
	// */
	// public boolean UserRecharge(RechargeRecord rechargeRecord) {
	// if(cBllFrame.UserRecharge(rechargeRecord)){
	// return true;
	// }
	// return false;
	// }
	// /**
	// * ��ţ�User:14
	// * ���ܣ���ѯ��ֵ��¼
	// * ����:int UserId
	// * ����ֵ��List<RechargeRecord>
	// */
	// public List<RechargeRecord> QueryRechargeRecord(int UserId) {
	// List<RechargeRecord> rechargeRecords = new ArrayList<RechargeRecord>();
	// try {
	// rechargeRecords = cBllFrame.QueryRechargeRecord(UserId);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return rechargeRecords;
	// }
	// /**
	// * ��ţ�User:17
	// * ���ܣ��û�����
	// * ����:ConsumptionRecord consumptionRecord
	// * ����ֵ��boolean
	// */
	// public boolean UserConsumption(ConsumptionRecord consumptionRecord) {
	// if(cBllFrame.UserConsumption(consumptionRecord)){
	// return true;
	// }
	// return false;
	// }
	// /**
	// * ��ţ�User:18
	// * ���ܣ���ѯ���Ѽ�¼
	// * ����:int UserId
	// * ����ֵ��List<ConsumptionRecord>
	// */
	// public List<ConsumptionRecord> QueryUserConsumpionRecord(int UserId) {
	// List<ConsumptionRecord> consumptionRecords = new
	// ArrayList<ConsumptionRecord>();
	// try {
	// consumptionRecords = cBllFrame.QueryUserConsumpionRecord(UserId);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return consumptionRecords;
	// }
	/**
	 * ��ţ�User:19 ���ܣ��鿴��ҳ�Ŀͻ� ����:int page ����ֵ��List<User>
	 */
	public List<User> GetUserByPage(int page) {
		List<User> findResult = cBllFrame.GetUserByPage(page);
		return findResult;
	}

	/**
	 * ��ţ�User:20 ���ܣ��鿴�ͻ����� ����: ����ֵ��int
	 */
	public int getUserNumber() {
		int findResult = cBllFrame.getUserNumber();
		return findResult;
	}

	// //ͨ��ҳ�����ҳ�ֵ��¼
	// public List<RechargeRecord> getRecordRecordByPage(int page) {
	// List<RechargeRecord> findResult=cBllFrame.getRecordRecordByPage(page);
	//		
	// return findResult;
	// }
	// //�鿴��ֵ��¼����
	// public int getRechargeRecordNumber() {
	// int count = cBllFrame.getRechargeRecordNumber();
	//		
	// return count;
	// }
	//	
	// //ͨ��ҳ���������Ѽ�¼
	// public List<ConsumptionRecord> getConsumptionRecordPage(int page) {
	// List<ConsumptionRecord>
	// findResult=cBllFrame.getConsumptionRecordPage(page);
	//		
	// return findResult;
	// }
	//	
	// //�鿴���Ѽ�¼��
	// public int getConsumptionRecordNumber() {
	// int count =cBllFrame.getConsumptionRecordNumber();
	// return count;
	// }
	//	
	// ͨ���绰����������ѯ����������������û�����Ϣ
	public List<HashMap<String, Object>> QueryPhonuserother(String userphon,
			String userpassword) {
		List<HashMap<String, Object>> result = cBllFrame.QueryPhonuserother(
				userphon, userpassword);
		return result;
	}

	// --------------------����---------------------

	/**
	 * ��ţ�OrderTable:0 ���ܣ��½����� ������Order ����ֵ��boolean
	 */
	public boolean CreateOrder(OrderTable order) {
		boolean result = cBllFrame.CreateOrder(order);
		return result;
	}

	/**
	 * ��ţ�OrderTable��1 ���ܣ�ɾ������ ������int OrderId ����ֵ��boolean
	 */
	public boolean DeleteOrder(int orderId) {
		boolean result = cBllFrame.DeleteOrder(orderId);
		return result;
	}

	// �ı䶩��״̬
	public boolean ChangeOrderState(int orderId, int orderState) {
		boolean resulte = cBllFrame.ChangeOrderState(orderId, orderState);
		return resulte;
	}

	// ͨ�������Ų��Ҷ���
	public OrderTable QueryOrderById(int orderId) {
		OrderTable order = cBllFrame.QueryOrderById(orderId);
		return order;
	}

	// ͨ���û������Ҷ�����Ϣ
	public List<OrderTable> QueryOrderByUsername(int userId) {
		List<OrderTable> order = cBllFrame.QueryOrderByUsername(userId);
		return order;
	}

	// ͨ����ס��ʱ����Ҷ�����Ϣ
	public List<OrderTable> QueryOrderByCheckinTime(int OrderCheckinTime) {
		List<OrderTable> order = cBllFrame
				.QueryOrderByCheckinTime(OrderCheckinTime);
		return order;
	}

	// ͨ��������Ҷ�����Ϣ
	public List<OrderTable> QueryOrderByRoom(int RoomId) {
		List<OrderTable> order = cBllFrame.QueryOrderByRoom(RoomId);
		return order;
	}

	// �޸Ķ���
	public boolean UpdateOrder(OrderTable order) {
		boolean result = cBllFrame.UpdateOrder(order);
		return result;
	}

	// �û�����,�ı䶩��״̬Ϊ5����ס����Ҫ��������������
	public boolean UserContinuedRoom(int orderId, int increaseDay,
			String OrderCheckOutTime, int OrderMoney) {
		boolean result = cBllFrame.UserContinuedRoom(orderId, increaseDay,
				OrderCheckOutTime, OrderMoney);
		return result;
	}

	// ͨ��ҳ���鶩��
	public List<OrderTable> queryOrderTablesByPage(int page) {
		List<OrderTable> findResult = cBllFrame.queryOrderTablesByPage(page);
		return findResult;
	}

	// �鿴������
	public int getOrderNumber() {
		int count = cBllFrame.getOrderNumber();
		return count;
	}

	// -------------------���Ա�����û�-----------------------
	public List<UserCommit> QueryAllCommit() {
		List<UserCommit> userCommits = null;
		try {
			userCommits = cBllFrame.QueryAllCommit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCommits;
	}

	// --------------------��Id��ѯ�û�-------------------------
	public List<UserCommit> QueryUserCommits(int userid) {
		List<UserCommit> userCommits = null;
		try {
			userCommits = cBllFrame.QueryUserCommits(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCommits;
	}

	public boolean UserCommentRoom(UserCommit usercommit) {
		if (cBllFrame.UserCommentRoom(usercommit)) {
			return true;
		}
		return false;
	}

	// -------------------���Ա���Լ�����¼����ల�ŵĲ���-----------------------

	// ����Ա�鿴�Լ������ʷ
	public List<CleaningRecord> QueryCleaningRecordUser(Cleaner cc) {
		List<CleaningRecord> cleaningRecords = new ArrayList<CleaningRecord>();

		try {
			cleaningRecords = QueryCleaningRecordUser(cc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleaningRecords;
	}

	// ����Ա�鿴�Լ���ల��
	public List<CleanerWorkArrange> QueryCleanerWorkArrangeUser(Cleaner cc) {
		List<CleanerWorkArrange> cleanerWorkArranges = new ArrayList<CleanerWorkArrange>();

		try {
			cleanerWorkArranges = cBllFrame.QueryCleanerWorkArrangeUser(cc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleanerWorkArranges;
	}

	// -------------------����Ա���������Ա����¼����ల�ŵĲ���-----------------------

	// ϵͳ�鿴���б���Ա�����ʷ
	public List<CleaningRecord> QueryCleaningRecordSystem() {
		List<CleaningRecord> cleaningRecords = new ArrayList<CleaningRecord>();

		try {
			cleaningRecords = cBllFrame.QueryCleaningRecordSystem();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleaningRecords;
	}

	// ϵͳ�鿴���б���Ա��������
	public List<CleanerWorkArrange> QueryCleanerWorkArrangeSystem() {
		List<CleanerWorkArrange> cleanerWorkArranges = new ArrayList<CleanerWorkArrange>();

		try {
			cleanerWorkArranges = cBllFrame.QueryCleanerWorkArrangeSystem();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleanerWorkArranges;
	}

	public Address QueryAddressId(String AddressProvince, String AddressCity,
			String AddressVillage) {
		Address address = cBllFrame.QueryAddressId(AddressProvince,
				AddressCity, AddressVillage);
		return address;
	}

	// ����һ������Ա��ల�ż�¼
	public boolean AddCleanerWorkArrange(CleanerWorkArrange cwa) {
		boolean flag = cBllFrame.AddCleanerWorkArrange(cwa);
		return flag;
	}

	// ����һ������Ա�����ʷ
	public boolean AddCleaningRecord(CleaningRecord cc) {
		boolean flag = cBllFrame.AddCleaningRecord(cc);
		return flag;
	}

	// �޸Ĺ������ż�¼
	public boolean ModifyCleanerWorkArrange(CleanerWorkArrange cc) {

		boolean flag = cBllFrame.ModifyCleanerWorkArrange(cc);

		return flag;
	}

	// ��ţ�cleaner��1
	// ���Ա��ע�����Cleanr cleaner,s
	// ����ֵboolean
	public boolean CleanerRegister(Cleaner cleaner) {
		boolean bcleregister = cBllFrame.CleanerRegister(cleaner);
		return bcleregister;
	}

	// ��ţ�cleaner��2
	// id��ѯ���Ա��
	// ����int CleanerId
	// ����ֵ��cleaner
	public List<Cleaner> QueryAllCleaner() {
		List<Cleaner> cleaners = new ArrayList<Cleaner>();
		cleaners = cBllFrame.QueryAllCleaner();
		return cleaners;
	}

	// ��ţ�cleaner��3
	// ��ѯ���Աȫ�����Ա������
	// ����ֵ��cleaners
	public Cleaner QuerySingelCleaner(int CleanerId) {
		Cleaner cleaner = cBllFrame.QuerySingelCleaner(CleanerId);
		return cleaner;
	}

	// ͨ��ҳ��������๤
	public List<Cleaner> getCleanerByPage(int page) {
		List<Cleaner> findResult = cBllFrame.getCleanerByPage(page);
		return findResult;
	}

	// �鿴��๤����
	public int getCleannerNumber() {
		int count = cBllFrame.getCleannerNumber();
		return count;
	}

	// ��ѯ����Ա����¼��
	public Manager QueryManagerByMessage(String ManagerAccount,
			String ManagerPassword) {
		Manager manager = cBllFrame.QueryManagerByMessage(ManagerAccount,
				ManagerPassword);
		return manager;
	}

	public List<Address> QueryAllAddress(String AddressProvince,
			String AddressCity, String AddressVillage) {
		List<Address> addresses = cBllFrame.QueryAllAddress();
		return addresses;
	}

	public HashMap QueryAllRooms() {
		HashMap roomsInfo = cBllFrame.QueryAllRooms();
		return roomsInfo;
	}

	public List<OrderTable> QueryAllOrders() {
		List<OrderTable> orders = cBllFrame.QueryAllOrders();
		return orders;
	}

	public List<RoomCommit> getAllRoomCommits() {
		List<RoomCommit> roomCommits = cBllFrame.getAllRoomCommits();
		return roomCommits;
	}

	public List<Address> GetAllAddress() {
		List<Address> address = new ArrayList<Address>();
		address = cBllFrame.GetAllAddress();
		return address;
	}

	// public List<ConsumptionRecord> getAllUserConsumpionRecords() {
	// List<ConsumptionRecord> consumptionRecords =
	// cBllFrame.getAllUserConsumpionRecords();
	// return consumptionRecords;
	// }

	public List<Room> GetRoomByRoomCleaningState() {
		// TODO Auto-generated method stub
		return null;
	}

	// public List<RechargeRecord> getAllRechargeRecords() {
	// List<RechargeRecord> rechargeRecords = cBllFrame.querRechargeRecords();
	// return rechargeRecords;
	// }

	public RoomCommit getRoomCommit(int roomCommitId) {
		RoomCommit roomCommit = cBllFrame.getRoomCommit(roomCommitId);
		return roomCommit;
	}

	public List<Room> QueryRooms() {
		// List<Room> rooms = cBllFrame.QueryRooms();
		return null;
	}

	public List<Room> GetRoomByAddressViilage(String address) {
		List<Room> rooms = cBllFrame.GetRoomByAddressViilage(address);
		return rooms;
	}

	public boolean DeleteRoom(int RoomId) {
		boolean isdel = cBllFrame.DeleteRoom(RoomId);
		return isdel;
	}

	// ������Ų��ҵ�������Ϣ���û���Ϣ
	public List<HashMap<String, Object>> QueryRoomCommitUser(int roomId) {
		List<HashMap<String, Object>> result = cBllFrame
				.QueryRoomCommitUser(roomId);
		return result;
	}

	public boolean UpdateCleanerState(int CleanerId, int CleanerState) {
		boolean bupdate = cBllFrame.UpdateCleanerState(CleanerId, CleanerState);
		return bupdate;
	}

	public boolean UsingCheckRoom(int roomid, int usingCheckRoom) {
		boolean bisusingc = UsingCheckRoom(roomid, usingCheckRoom);
		return bisusingc;
	}

	// ���û������Ҷ����ͷ���
	public List<HashMap<String, Object>> QueryOrderRommByUserId(int userid) {
		List<HashMap<String, Object>> result = cBllFrame
				.QueryOrderRommByUserId(userid);
		return result;
	}

	// ---------1.�½���������---------
	public boolean CreateRoomCommit(RoomCommit roomCommit) {
		boolean result = cBllFrame.CreateRoomCommit(roomCommit);
		return result;
	}

	public List<UserCommit> QueryUserCommintByPage(int page) {
		List<UserCommit> findResult = cBllFrame.QueryUserCommintByPage(page);

		return findResult;
	}

	public int GetUserCommintNumber() {
		int count = cBllFrame.GetUserCommintNumber();
		return count;
	}

	// ͨ��ҳ�����ҷ�������
	public List<RoomCommit> getRoomCommintByPage(int page) {
		List<RoomCommit> findResult = cBllFrame.getRoomCommintByPage(page);
		return findResult;
	}

	// �鿴����������
	public int getRoomCommunitNumber() {
		int count = cBllFrame.getRoomCommunitNumber();
		return count;
	}

	// ͨ��ҳ����������¼
	public List<CleaningRecord> getCleanRecordPage(int page) {
		List<CleaningRecord> findResult = cBllFrame.getCleanRecordPage(page);

		return findResult;
	}

	// �鿴����¼��
	public int getCleanRecordNumber() {
		int count = cBllFrame.getCleannerNumber();

		return count;
	}

	public boolean changeCleaner(Cleaner cleaner) {
		boolean bchange = cBllFrame.changeCleaner(cleaner);
		return bchange;
	}

	public UserCommit GetSingelUserCommit(int UserCommitId) {
		UserCommit userCommit = cBllFrame.GetSingelUserCommit(UserCommitId);
		return userCommit;
	}

	public List<CleanerWorkArrange> getCleanerWorkBypage(int page) {
		List<CleanerWorkArrange> cleanerWorkArranges = cBllFrame
				.getCleanerWorkBypage(page);
		return cleanerWorkArranges;
	}

	public int getCleanerWorkNumber() {
		int getcl = cBllFrame.getCleanerWorkNumber();
		return getcl;
	}

	public LinkedMap GetRoomByAddress(int addressid, String RoomDetailAddress,
			int page) {
		LinkedMap linkedMap = cBllFrame.GetRoomByAddress(addressid,
				RoomDetailAddress, page);
		return linkedMap;
	}

	public int GetRoomNumberByAddress(int AddressId, String RoomDetailAddress) {
		int roomnumber = cBllFrame.GetRoomNumberByAddress(AddressId,
				RoomDetailAddress);
		return roomnumber;
	}

	public List<User> getUserByName(String UserName, int page) {
		List<User> users = cBllFrame.getUserByName(UserName, page);
		return users;
	}

	public int getUserNumberByName(String UserName) {
		int count = cBllFrame.getUserNumberByName(UserName);
		return count;
	}

	public int getOrderNumberByAddress(String AddressProvince,
			String AddressCity, String AddressVillage, String DetatilAddress) {
		int num = cBllFrame.getOrderNumberByAddress(AddressProvince,
				AddressCity, AddressVillage, DetatilAddress);
		return num;
	}

	public List<OrderTable> getOrdersByAddress(String AddressProvince,
			String AddressCity, String AddressVillage, String DetatilAddress,
			int page) {
		List<OrderTable> orders = cBllFrame.getOrdersByAddress(AddressProvince,
				AddressCity, AddressVillage, DetatilAddress, page);
		return orders;
	}

	/**
	 * ---------------------���׼�¼-------------------------
	 */

	// �½�����
	public boolean CreateTransaction(Transaction transaction) {
		boolean result = cBllFrame.CreateTransaction(transaction);
		return result;
	}

	// ��ѯ����
	public List<Transaction> QueryTransaction() {
		List<Transaction> result = cBllFrame.QueryTransaction();
		return result;
	}

	//ͨ���û�id��ѯ���׼�¼
	public List<Transaction> Querybyuserid(int userid) {
		List<Transaction> result=cBllFrame.Querybyuserid(userid);
		return result;
	}

	public Room GetARoomById(int roomid) {
		Room room = cBllFrame.GetARoomById(roomid);

		return room;
	}
}
