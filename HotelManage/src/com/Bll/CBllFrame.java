package com.Bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.collections.map.LinkedMap;
import com.Dao.CDaoFrameImpl;
import com.Dao.IDaoFrame;
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

public class CBllFrame {

	IDaoFrame iDaoFrame = new CDaoFrameImpl();

	// private static List<OrderTable> ordOrderlist=new ArrayList<OrderTable>();
	// --------------------�������-------------------

	/**
	 * ��ţ�Room:1 ���ܣ��������� ������Room room,RoomEquipment,Address
	 * ��̬������RoomUsingState=1 ����ֵ:boolean
	 */
	public boolean CreateRoom(Room room, RoomEquipment roomEquipment,
			int AddressId) {
		// ��������...�������룺Room���� ��ͬʱ������RoomUsingState���ó�ʼֵΪ2��RoomLockState���ó�ʼֵΪ0
		room.setRoomUsingState(2);
		room.setRoomLockState(0);
		room.setAddressId(AddressId);
		boolean roomCreate = iDaoFrame.CreateRoom(room);
		// ���������豸
		boolean roomEqment = iDaoFrame.CreateRoomEquipment(roomEquipment);
		return roomCreate && roomEqment;
	}

	/**
	 * ��ţ�Room:2 ���ܣ���ѯ�������� ������int roomId ����ֵ:Room
	 */
	public HashMap<String, Object> QueryRoomDetail(int roomid) {
		// ͨ��Id���ҷ���
		HashMap<String, Object> map = new HashMap<String, Object>();
		Room room = iDaoFrame.QueryRoomDetail(roomid);
		RoomEquipment roomEquipment = iDaoFrame.QueryRoomEquipment(room
				.getRoomEquipmentId());
		Address address = iDaoFrame.QuerySingelAddress(room.getAddressId());
		map.put("Room", room);
		map.put("RoomEquipment", roomEquipment);
		map.put("Address", address);
		return map;
	}

	/**
	 * ��ţ�Room:3 ���ܣ�ͨ��������ѯ���� ������Address address ����ֵ:Room
	 */
	public List<Room> QueryRoomByArea(Address address) {
		// ͨ��Addressid���ҷ���
		List<Room> rooms = iDaoFrame.QueryRoomByArea(address.getAddressId());
		return rooms;
	}

	/**
	 * ��ţ�Room:3 ���ܣ�ͨ������id��ѯ���� ������Address address ����ֵ:Room
	 */
	public List<Room> QueryRoomByAreaid(int addressId) {
		// ͨ��Addressid���ҷ���
		List<Room> rooms = new ArrayList<Room>();
		rooms = iDaoFrame.QueryRoomByArea(addressId);
		return rooms;
	}

	/**
	 * ��ţ�Room:4 ���ܣ���ѯ����������Ϣ+����Ӧ������Ϣ+�����豸��Ϣ ������int orderId ����ֵ:HashMap
	 */
	public HashMap<String, Object> QueryOrder(int orderId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		OrderTable orderTable = iDaoFrame.QueryDetailOrder(orderId);
		Room room = iDaoFrame.QueryRoomDetail(orderTable.getRoomId());
		RoomEquipment roomEquipment = iDaoFrame.QueryRoomEquipment(room
				.getRoomEquipmentId());
		map.put("orderTable", orderTable);
		map.put("room", room);
		map.put("roomEquipment", roomEquipment);
		return map;
	}

	/**
	 * ��ţ�Room:5 ���ܣ�������״̬��ѯ���з��� ������int RoomUsingState ����ֵ:List<Room>
	 */
	public List<Room> QueryRoomByUsingState(int roomUsingState) {
		List<Room> rooms = new ArrayList<Room>();
		rooms = iDaoFrame.QueryRoomByUsingState(roomUsingState);
		@SuppressWarnings("unused")
		Date date = new Date();
		return rooms;
	}

	/**
	 * ��ţ�Room��6 ���ܣ�����סʱ���ѯ����//δʵ�� ����:string ����ֵ��List<Room>
	 */

	/**
	 * ��ţ�Room��7 ���ܣ��޸ķ��䷿������ ����:Room room,RoomE ����ֵ��boolean
	 */
	boolean UptateRoom(Room room, RoomEquipment roomEquipment, Address address) {
		boolean roomup = iDaoFrame.UpdateRoom(room);
		boolean roomequp = iDaoFrame.UpdateRoomEquipment(roomEquipment);
		boolean addressup = iDaoFrame.UpdateAddress(address);
		return roomup && roomequp && addressup;
	}

	/**
	 * ��ţ�Room:8 ���ܣ���ѯ��Ҫ�����ķ��� ������RoomLockState ����ֵ��List<Room>
	 */
	public List<Room> QueryRoomNeedLocking() {
		List<Room> roomsget = iDaoFrame.QueryRoomByLockingState(2);
		return roomsget;
	}

	/**
	 * ��ţ�Room��9 ���ܣ�������������� ������RoomId��Lock/UNLOCK ����ֵ��boolean
	 */
	public boolean LockCheckRoom(int roomId, int CheckRoom) {
		Room room = iDaoFrame.QueryRoomDetail(roomId);
		room.setRoomLockState(CheckRoom);
		if (iDaoFrame.UpdateRoom(room)) {
			return true;
		}
		return false;
	}

	/**
	 * ��ţ�Room��10 ���ܣ���ѯ���з��� �������� ����ֵ��List<Room>
	 */
	public HashMap QueryAllRooms() {
		List<Room> rooms = iDaoFrame.QueryRooms();
		HashMap maps = new HashMap();
		System.out.println(rooms);
		int key = 1;
		for (Room room : rooms) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			Address address = iDaoFrame.QuerySingelAddress(room.getAddressId());
			RoomEquipment roomEquipment = iDaoFrame.QueryRoomEquipment(room
					.getRoomEquipmentId());
			map.put("Room", room);
			map.put("Address", address);
			map.put("RoomEquipment", roomEquipment);
			maps.put(key, map);
			key++;
		}
		return maps;
	}

	/**
	 * Room:11��ɾ������ ����:ɾ������ ������int RoomId ����ֵ��boolean
	 */
	public boolean DeleteRoom(int RoomId) {
		boolean isdel = iDaoFrame.DeleteRoom(RoomId);
		return isdel;
	}

	// 12�޸ķ���ʹ��״̬
	public boolean UsingCheckRoom(int roomid, int usingCheckRoom) {
		boolean bischeck = iDaoFrame.UsingCheckRoom(roomid, usingCheckRoom);
		return bischeck;
	}

	/**
	 * Address��1 ���ܣ���������address �������� ����ֵ��List<address>
	 */
	public List<Address> QueryAllAddress() {
		List<Address> addresses = iDaoFrame.QueryAllAddress();
		return addresses;
	}

	/**
	 * ��ţ�Address��2 ���ܣ�����addressid ������Addressprovience������3�� ����ֵ��int addressid
	 */
	public Address QueryAddressId(String AddressProvince, String AddressCity,
			String AddressVillage) {
		Address address = iDaoFrame.queryAddress(AddressProvince, AddressCity,
				AddressVillage);
		return address;
	}

	public LinkedMap GetPageRoomInfo(int page) {
		LinkedMap findResult = iDaoFrame.GetRoomInfoByPage(page);
		return findResult;
	}

	public int GetRoomNumber() {
		int number = iDaoFrame.GetRoomNumberNoDel();
		return number;
	}

	// �������з���
	public List<Room> QueryAllRoom() {
		List<Room> rooms = iDaoFrame.QueryAllRoom();
		return rooms;
	}

	// ͨ���������Ͳ��ҷ���
	public List<Room> QueryRoomByRoomtype(int roomtype) {
		List<Room> rooms = iDaoFrame.QueryRoomByRoomtype(roomtype);
		return rooms;
	}

	// --------------14.ͨ����������ϸ��ַ��Ϣ��ѯ����-----------
	public LinkedMap GetRoomByAddress(int addressid, String RoomDetailAddress,
			int page) {
		LinkedMap findResult = iDaoFrame.QueryRoomByAddress(addressid,
				RoomDetailAddress, page);
		return findResult;
	}

	// ---------------15.ͨ����������ϸ��ַ��Ϣ��ѯ��������------------
	public int GetRoomNumberByAddress(int AddressId, String RoomDetailAddress) {
		int roomnumber = iDaoFrame.GetRoomNumberByAddress(AddressId,
				RoomDetailAddress);
		return roomnumber;
	}
	
	// ---------------16.ͨ������ID���ط�����Ϣ------------
	public Room GetARoomById(int roomid) {
		Room room = iDaoFrame.QueryRoomDetail(roomid);
		return room;
	}
	// -----------------------------��������-----------------------
	// ��ѯ���з�������
	public List<RoomCommit> getAllRoomCommits() {
		List<RoomCommit> roomCommits = iDaoFrame.QueryAllRoomCommits();
		return roomCommits;
	}

	// ��ѯ������������
	public RoomCommit getRoomCommit(int roomCommitId) {
		RoomCommit roomCommit = iDaoFrame.QuerySingelRoomCommit(roomCommitId);
		return roomCommit;
	}

	public List<Room> GetRoomByAddressViilage(String address) {
		List<Room> rooms = iDaoFrame.queryRoomByAddressViilage(address);
		return rooms;
	}

	// ͨ��ҳ�����ҷ�������
	public List<RoomCommit> getRoomCommintByPage(int page) {
		List<RoomCommit> findResult = iDaoFrame.getRoomCommintByPage(page);

		return findResult;
	}

	// �鿴����������
	public int getRoomCommunitNumber() {
		int count = iDaoFrame.getRoomCommunitNumber();
		return count;
	}
	
	
	//2016-01-09 ��������ѯ����
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice){
		List<Room> result=iDaoFrame.QueryRoomselectcondition(village, indata, outdata, minprice, maxprice);
		return result;
	}

	/**
	 **************���û��йز���**************
	 */
	// �û�ע��
	public boolean CreateUser(User user) {
		boolean result = iDaoFrame.CreateUser(user);
		return result;
	}

	// ��ѯ�ͻ���������Ϣ
	public List<User> QueryAllUser() {
		List<User> result = iDaoFrame.SearchtotalUser();
		return result;
	}

	// ��ѯ�����û���Ϣ��QuerySingelUser
	public User QuerySingelUser(int userId) {
		User result = iDaoFrame.SearcheachUser(userId);
		return result;
	}
	
	//ͨ���û�id���ҳ��û�����֮���������Ϣ
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid){
		List<HashMap<String, Object>> result=iDaoFrame.QueryUserExceptPasswordById(userid);
		return result;
	}

	// ʹ�������¼��ǰ�����������䲻���ظ���
	// public List<User> UserLoginEmail(String useremail,String password){
	// List<User> result=null;
	// List <User> emailLogin=iDaoFrame.Queryemailuser(useremail);
	// //�ж�ǰ�˴���������������Ƿ���ȷ
	// for(int i=0;i<emailLogin.size();i++){
	// //��password���бȽ�
	// if(emailLogin.get(i).getUserPassword().equals(password)){
	// System.out.print("��¼�ɹ���");
	// result=emailLogin;
	// }
	// else{
	// System.out.print("��������������Ŷ��");
	// }
	// }
	// return result;
	// }

	// ʹ�������¼��ǰ�����������䲻���ظ���
	public int UserLoginEmail(String useremail, String userpassword) {
		int result = iDaoFrame.Queryemailuser(useremail, userpassword);
		return result;
	}

	// ʹ�õ绰�����¼��ǰ���������绰���벻���ظ���ȣ�
	public int UserLoginPhon(String userphon, String userpassword) {
		int result = iDaoFrame.Queryphonuser(userphon, userpassword);
		return result;
	}

	// ɾ�����û�
	public boolean DeleteUser(int userId) {
		int userState = -1;
		boolean result = false;
		result = iDaoFrame.changerUserState(userId, userState);
		return result;
	}

	// ������������û�
	public boolean LockCheckUser(int userId, int userState) {
		boolean resulte = iDaoFrame.changerUserState(userId, userState);
		return resulte;
	}

	// �����û�����
	public boolean ResetUserPassword(int userId, int password) {
		boolean resulte = iDaoFrame.changerUserPassword(userId, password);
		return resulte;
	}

	//�޸Ĳ����û���Ϣ
	public boolean UpdateUserPart(int userId,String userName,String userSex,String userBoth,String userPhone,String userEmail,String userIdNumber,String userMessage){
		boolean result = iDaoFrame.ChangeUserPart(userId, userName, userSex, userBoth, userPhone, userEmail, userIdNumber, userMessage);
		return result;
	}
	
	// �޸��û���Ϣ��ͨ���û�id�����û���Ϣ�������޸�
	public boolean UpdateUser(int userId, User user) {
		user.setUserId(userId);
		boolean result = iDaoFrame.DisappearUser(user);
		return result;
	}

	// �����û�ͷ��
	public boolean ChangeUserPic(int userId, String userPicture) {
		boolean result = iDaoFrame.ChangeUserPic(userId, userPicture);
		return result;

	}

	// �鿴��ҳ�Ŀͻ�
	public List<User> GetUserByPage(int page) {
		List<User> findResult = iDaoFrame.getUserByPage(page);
		return findResult;
	}

	// �鿴�ͻ�����
	public int getUserNumber() {
		int findResult = iDaoFrame.getUserNumber();
		return findResult;
	}

	public List<User> getUserByName(String UserName, int page) {
		List<User> users = iDaoFrame.queryUserByName(UserName, page);
		return users;
	}

	public int getUserNumberByName(String UserName) {
		int count = iDaoFrame.queryUserNumberByName(UserName);
		return count;
	}

	// ͨ���绰����������ѯ����������������û�����Ϣ
	public List<HashMap<String, Object>> QueryPhonuserother(String userphon,
			String userpassword) {
		List<HashMap<String, Object>> result = iDaoFrame.QueryPhonuserother(
				userphon, userpassword);
		return result;
	}

	// /**
	// **************���û���ֵ�йز���**************
	// * */
	// //�û���ֵ
	// public boolean UserRecharge(RechargeRecord rechargeRecord){
	// boolean result=iDaoFrame.CreateRecode(rechargeRecord);
	// return result;
	// }
	//
	// //��ѯ��ֵ��¼
	// public List<RechargeRecord> QueryRechargeRecord(int UserId){
	// List<RechargeRecord> result=iDaoFrame.SearchRecode(UserId);
	// return result;
	// }
	// //��ѯ���г�ֵ��¼
	// public List<RechargeRecord> querRechargeRecords(){
	// List<RechargeRecord> result=iDaoFrame.queryRechargeRecords();
	// return result;
	// }
	//	
	// //ͨ��ҳ�����ҳ�ֵ��¼
	// public List<RechargeRecord> getRecordRecordByPage(int page) {
	//	
	// List<RechargeRecord> findReuslt=iDaoFrame.getRecordRecordByPage(page);
	//		
	// return findReuslt;
	// }
	// //�鿴��ֵ��¼����
	// public int getRechargeRecordNumber() {
	// int count = iDaoFrame.getRechargeRecordNumber();
	// return count;
	// }
	// //ͨ��ҳ���������Ѽ�¼
	// public List<ConsumptionRecord> getConsumptionRecordPage(int page) {
	// List<ConsumptionRecord>
	// findResult=iDaoFrame.getConsumptionRecordPage(page);
	//		
	// return findResult;
	// }
	//	
	// //�鿴���Ѽ�¼��
	// public int getConsumptionRecordNumber() {
	// int count =iDaoFrame.getConsumptionRecordNumber();
	// return count;
	// }
	// /**
	// **************���û������йز���**************
	// * */
	//
	// //�û�����
	// public boolean UserConsumption(ConsumptionRecord consumptionRecord){
	// boolean result=iDaoFrame.CreateConsumptionRecord(consumptionRecord);
	// return result;
	// }
	//
	// //��ѯ���Ѽ�¼
	// public List<ConsumptionRecord> QueryUserConsumpionRecord(int UserId){
	// List<ConsumptionRecord> result=iDaoFrame.SearchConsumptionRecord(UserId);
	// return result;
	// }
	// //��ѯ�������Ѽ�¼
	// public List<ConsumptionRecord> getAllUserConsumpionRecords(){
	// List<ConsumptionRecord> result=iDaoFrame.queryAllConsumptionRecords();
	// return result;
	// }

	// ----------------------����--------------------
	/**
	 * ��ţ�OrderTable:0 ���ܣ��½����� ������Order ����ֵ��boolean
	 */
	public boolean CreateOrder(OrderTable order) {
		if (iDaoFrame.CreateOrder(order)) {
			return true;
		}
		return false;
	}

	/**
	 * ��ţ�OrderTable��1 ���ܣ�ɾ������ ������int OrderId ����ֵ��boolean
	 */
	public boolean DeleteOrder(int orderId) {
		int orderState = -1;
		boolean resulte = iDaoFrame.changerUserState(orderId, orderState);
		return resulte;
	}

	// �ı䶩��״̬
	public boolean ChangeOrderState(int orderId, int orderState) {
		boolean resulte = iDaoFrame.changerorderState(orderId, orderState);
		return resulte;
	}

	// ͨ�������Ų��Ҷ���
	public OrderTable QueryOrderById(int orderId) {
		OrderTable order = iDaoFrame.QueryDetailOrder(orderId);
		return order;
	}

	// ͨ���û������Ҷ�����Ϣ
	public List<OrderTable> QueryOrderByUsername(int userId) {
		List<OrderTable> order = iDaoFrame.QueryuserOrder(userId);
		return order;
	}

	// ͨ����ס��ʱ����Ҷ�����Ϣ
	public List<OrderTable> QueryOrderByCheckinTime(int OrderCheckinTime) {
		List<OrderTable> order = iDaoFrame.QuerytimeOrder(OrderCheckinTime);
		return order;
	}

	// ͨ��������Ҷ�����Ϣ
	public List<OrderTable> QueryOrderByRoom(int RoomId) {
		List<OrderTable> order = iDaoFrame.QueryroomOrder(RoomId);
		return order;
	}

	// �޸Ķ���
	public boolean UpdateOrder(OrderTable order) {
		boolean result = iDaoFrame.QueryOrder(order);
		return result;

	}

	// �û�����,�ı䶩��״̬Ϊ5����ס����Ҫ��������������
	public boolean UserContinuedRoom(int orderId, int increaseDay,
			String OrderCheckOutTime, int OrderMoney) {
		int OrderStayinDay;
		OrderStayinDay = iDaoFrame.QueryDetailOrder(orderId)
				.getOrderStayinDay()
				+ increaseDay;// ��ס����=ԭ������+��������
		boolean result = iDaoFrame.changeOrderDayState(orderId, OrderStayinDay,
				OrderCheckOutTime, OrderMoney);
		return result;
	}

	// ��ѯ���ж���
	public List<OrderTable> QueryAllOrders() {
		List<OrderTable> orders = iDaoFrame.queryOrderTables();
		return orders;
	}

	// ͨ���û��Ų��Ҷ����ͷ���
	public List<HashMap<String, Object>> QueryOrderRommByUserId(int userid) {
		List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
		List<OrderTable> order = iDaoFrame.QueryuserOrder(userid);
		for (int i = 0; i < order.size(); i++) {
			Room room = iDaoFrame.QueryRoomDetail(order.get(i).getRoomId());
			HashMap<String, Object> map = order.get(i).toHashMap();
			map.put("room", room);
			maps.add(map);
		}
		return maps;
	}

	// ͨ��ҳ���鶩��
	public List<OrderTable> queryOrderTablesByPage(int page) {
		List<OrderTable> findResult = iDaoFrame.queryOrderTablesByPage(page);
		return findResult;
	}

	// �鿴������
	public int getOrderNumber() {
		int count = iDaoFrame.getOrderNumber();
		return count;
	}

	public List<OrderTable> getOrdersByAddress(int AddressId,
			String DetatilAddress, int page) {
		List<OrderTable> orders = null;
		return null;
	}

	// �鿴����������addressid/detailaddress/ page���Ķ�����
	public int getOrderNumberByAddress(String AddressProvince,
			String AddressCity, String AddressVillage, String DetatilAddress) {
		Address address = iDaoFrame.queryAddress(AddressProvince, AddressCity,
				AddressVillage);
		int AddressId = address.getAddressId();
		List<Integer> rooms = iDaoFrame.queryRoomByAddressWithoutPage(
				AddressId, DetatilAddress);
		int count = 0;
		count = iDaoFrame.queryOrderNumberByAddress(rooms);
		return count;
	}

	// �鿴���������Ķ���
	public List<OrderTable> getOrdersByAddress(String AddressProvince,
			String AddressCity, String AddressVillage, String DetatilAddress,
			int page) {
		List<OrderTable> orders = new ArrayList<OrderTable>();
		System.out.println(AddressProvince + " " + AddressCity + " "
				+ AddressVillage);
		Address address = iDaoFrame.queryAddress(AddressProvince, AddressCity,
				AddressVillage);
		int AddressId = address.getAddressId();
		List<Integer> rooms = iDaoFrame.queryRoomByAddressWithoutPage(
				AddressId, DetatilAddress);
		List<List<OrderTable>> orders2 = iDaoFrame.queryOrderByAddress(rooms);
		for (List<OrderTable> list : orders2) {
			for (OrderTable orderTable : list) {
				orders.add(orderTable);
			}
		}
		List<OrderTable> orders3 = new ArrayList<OrderTable>();
		if (orders.size() < page * 10) {
			for (int i = (page - 1) * 10; i < orders.size(); i++) {
				orders3.add(orders.get(i));
			}
		} else {
			for (int i = (page - 1) * 10; i < page * 10; i++) {
				orders3.add(orders.get(i));
			}
		}
		return orders3;
	}

	// -----------------------���Ա----------------------
	// ��ţ�cleaner��
	// ���Ա��ע�����Cleanr cleaner,
	// ����ֵboolean
	public boolean CleanerRegister(Cleaner cleaner) {
		// ע�����Ա��
		boolean cleanerCreate = iDaoFrame.CleanerRegister(cleaner);
		return cleanerCreate;
	}

	// ��ţ�cleaner��2
	// id��ѯ���Ա��
	// ����int CleanerId
	// ����ֵ��cleaner
	public Cleaner QuerySingelCleaner(int CleanerId) {
		// ͨ��Id�������Ա
		Cleaner cleaner = iDaoFrame.QuerySingelCleaner(CleanerId);
		return cleaner;
	}

	// ��ţ�cleaner��3
	// ��ѯ���Աȫ�����Ա������
	// ����ֵ��cleaners
	public List<Cleaner> QueryAllCleaner() {
		// ��ѯȫ�����Ա����
		List<Cleaner> cleaners = new ArrayList<Cleaner>();
		cleaners = iDaoFrame.QueryAllCleaner();
		return cleaners;
	}

	// ��ţ�cleaner��3
	// �޸ı���Ա״̬
	// ����ֵ��boolean
	public boolean UpdateCleanerState(int CleanerId, int CleanerState) {
		boolean bupdate = iDaoFrame.UpdateCleanerState(CleanerId, CleanerState);
		return bupdate;
	}

	public List<Cleaner> QueryCleanerByPhone(String phoneInfo) {
		List<Cleaner> cleaners = new ArrayList<Cleaner>();
		cleaners = iDaoFrame.QueryCleanerByPhone(phoneInfo);
		return cleaners;
	}

	public boolean CleanerLogin(String phongInfo, String passWord) {
		List<Cleaner> cleaners = new ArrayList<Cleaner>();

		cleaners = iDaoFrame.QueryCleanerByPhone(phongInfo);

		boolean bisLigin = false;
		if (passWord.equals((cleaners.get(0)).getCleanerPassWord())) {
			bisLigin = true;
		}
		return bisLigin;
	}

	// ͨ��ҳ��������๤
	public List<Cleaner> getCleanerByPage(int page) {
		List<Cleaner> findResult = iDaoFrame.getCleanerByPage(page);
		return findResult;
	}

	// �鿴��๤����
	public int getCleannerNumber() {
		int count = iDaoFrame.getCleannerNumber();
		return count;
	}

	// �������Ա��Ϣ
	public boolean changeCleaner(Cleaner cleaner) {
		boolean bupdate = iDaoFrame.UptateCleaner(cleaner);
		return bupdate;
	}

	// -------------------���Ա�����û�-----------------------
	/**
	 * ��ţ�usercommit��1 �ͻ��������۲���UserCommit usercommit, ������UserCommit usercommit
	 * ����ֵboolean
	 */
	public boolean UserCommentRoom(UserCommit usercommit) {
		// ��ӿͻ�����
		boolean usercommitroom = iDaoFrame.UserCommentRoom(usercommit);
		return usercommitroom;
	}

	/**
	 * ��ţ�usercommit��2 id��ѯĳ�ͻ�ȫ������ ����int userid ����ֵ��List<UserCommit>
	 */
	public List<UserCommit> QueryUserCommits(int userid) {
		// ͨ��userid����ĳ�û�ȫ������
		List<UserCommit> usercommits = new ArrayList<UserCommit>();
		usercommits = iDaoFrame.QueryUserCommits(userid);
		return usercommits;
	}

	/**
	 * ��ţ�usercommit��3 ��ѯȫ������ ������NULL ����ֵ��List<UserCommit>
	 */
	public List<UserCommit> QueryAllCommit() {
		// ��ѯȫ������
		List<UserCommit> usercommits = new ArrayList<UserCommit>();
		usercommits = iDaoFrame.QueryAllCommit();
		return usercommits;
	}

	public List<UserCommit> QueryUserCommintByPage(int page) {
		List<UserCommit> findResult = iDaoFrame.QueryUserCommintByPage(page);

		return findResult;
	}

	public int GetUserCommintNumber() {
		int count = iDaoFrame.GetUserCommintNumber();
		return count;
	}

	/**
	 * ��ţ�usercommit��5 ��Id��ѯ�����û����� ������UserCommitId ����ֵ��UserCommit
	 */
	public UserCommit GetSingelUserCommit(int UserCommitId) {
		UserCommit userCommit = iDaoFrame.queryUserCommitById(UserCommitId);
		return userCommit;
	}

	// -------------------����Ա���������Ա����¼����ల�ŵĲ���-----------------------

	/**
	 * ����Ա�������鿴���б���Ա�������ʷ��¼
	 * 
	 * @author ariclee @time 2015-11-13
	 */
	public List<CleaningRecord> QueryCleaningRecordSystem() {
		List<CleaningRecord> CleaningRecordBulletin = new ArrayList<CleaningRecord>();

		CleaningRecordBulletin = iDaoFrame.queryAllCleaningRecord();

		return CleaningRecordBulletin;
	}

	/**
	 * ����Ա�������鿴���б���Ա�Ĺ�������
	 */

	public List<CleanerWorkArrange> QueryCleanerWorkArrangeSystem() {
		List<CleanerWorkArrange> CleanerWorkArrangeBulletin = new ArrayList<CleanerWorkArrange>();
		CleanerWorkArrangeBulletin = iDaoFrame.queryAllCleanerWorkArrange();
		return CleanerWorkArrangeBulletin;
	}

	// �鿴������������Ŀ
	public int getCleanerWorkNumber() {
		int getnum = iDaoFrame.getCleanerWorkNumber();
		return getnum;
	}

	// ͨ��ҳ����ҹ�������
	public List<CleanerWorkArrange> getCleanerWorkBypage(int page) {
		List<CleanerWorkArrange> cleanerWorkArranges = iDaoFrame
				.queryPageCleanerWorkArranges(page);
		return cleanerWorkArranges;
	}

	// ͨ��ҳ����������¼
	public List<CleaningRecord> getCleanRecordPage(int page) {
		List<CleaningRecord> findResult = iDaoFrame.getCleanRecordPage(page);

		return findResult;
	}

	// �鿴����¼��
	public int getCleanRecordNumber() {
		int count = iDaoFrame.getCleannerNumber();

		return count;
	}

	// -------------------���Ա���Լ�����¼����ల�ŵĲ���-----------------------

	/**
	 * ����Ա�ֻ��˲������鿴�Լ��������ʷ��¼
	 * 
	 * @author ariclee @time 2015-11-13
	 */
	public List<CleaningRecord> QueryCleaningRecordUser(Cleaner cc) {
		List<CleaningRecord> CleaningRecordBulletin = new ArrayList<CleaningRecord>();

		CleaningRecordBulletin = iDaoFrame.queryCleaningRecordByCleaningId(cc
				.getCleanerId());

		return CleaningRecordBulletin;
	}

	/**
	 * ����Ա�������鿴�Լ��Ĺ�������
	 */
	public List<CleanerWorkArrange> QueryCleanerWorkArrangeUser(Cleaner cc) {

		List<CleanerWorkArrange> CleanerWorkArrangeBulletin = new ArrayList<CleanerWorkArrange>();

		CleanerWorkArrangeBulletin = iDaoFrame
				.queryCleanerWorkArrangeByCleanerId(cc.getCleanerId());

		return CleanerWorkArrangeBulletin;
	}

	/**
	 * ����һ������Ա�����ʷ
	 * 
	 * @author ariclee @time 2015-11-14
	 */
	public boolean AddCleaningRecord(CleaningRecord cd) {
		boolean flag = iDaoFrame.addCleaningRecord(cd);

		return flag;
	}

	/**
	 * ����һ������Ա��ల�ż�¼
	 * 
	 * @author ariclee @time 2015-11-14
	 */
	public boolean AddCleanerWorkArrange(CleanerWorkArrange cwa) {
		boolean flag = iDaoFrame.addCleanerWorkArrange(cwa);

		return flag;
	}

	/**
	 * �޸�һ������Ա��ల�ż�¼
	 * 
	 * @author ariclee @time 2015-11-14
	 */
	public boolean ModifyCleanerWorkArrange(CleanerWorkArrange cc) {

		boolean flag = iDaoFrame.modifyCleaningCleanerWorkArrange(cc);
		return flag;
	}

	public List<Address> GetAllAddress() {
		List<Address> adresss = iDaoFrame.QueryAllAddress();

		return adresss;
	}

	/**
	 * ---------------------����Ա-------------------------
	 */
	/**
	 * ��ţ�Manager:1 ���ܣ���ӹ���Ա ������Manager manager ����ֵ��boolean
	 */
	public boolean AddManager(Manager manager) {
		boolean baddman = iDaoFrame.AddManager(manager);
		return baddman;
	}

	/**
	 * ��ţ�Manager:2 ���ܣ���ѯ����Ա���ʺš����룩 ������String ManagerAccount,String
	 * ManagerPassword ����ֵ��Manager
	 */
	public Manager QueryManagerByMessage(String ManagerAccount,
			String ManagerPassword) {
		Manager manager = iDaoFrame.QueryManagerByMessage(ManagerAccount,
				ManagerPassword);
		return manager;
	}

	/**
	 * ��ţ�Manager:3 ���ܣ���ѯ����Ա��id�� ������int ManagerId ����ֵ��Manager
	 */
	public Manager QueryManagerById(int ManagerId) {
		Manager manager = iDaoFrame.QuerManagerById(ManagerId);
		return manager;
	}

	/**
	 * ��ţ�Manager:4 ���ܣ����¹���Ա ������Manager ����ֵ��boolean
	 */
	public boolean UpdateManager(Manager manager) {
		boolean bdel = iDaoFrame.UpdateManager(manager);
		return bdel;
	}

	/**
	 * ��ţ�Manager:5 ���ܣ�ɾ������Ա ������Manager ����ֵ��boolean
	 */
	public boolean DeleteManager(Manager manager) {
		boolean bdel = iDaoFrame.DeleteManager(manager);
		return bdel;
	}

	// public List<HashMap<String, Object>> QueryAllComment(int noticeId) {
	// List<HashMap<String, Object>> maps=new
	// ArrayList<HashMap<String,Object>>();
	// List<Comment> comments=daoFrame.queryCommentsByNoticeId(noticeId);
	// for (int i = 0; i < comments.size(); i++) {
	// User user=daoFrame.QueryUserById(comments.get(i).getUserId());
	// HashMap<String, Object> map=comments.get(i).toHashMap();
	// map.put("userName", user.getUserName());
	// map.put("userPic", user.getUserPic());
	// maps.add(map);
	// }
	// return maps;
	// }

	/**
	 * ---------------------�û����۷���-------------------------
	 */
	// ������Ų��ҵ�������Ϣ���û���Ϣ
	public List<HashMap<String, Object>> QueryRoomCommitUser(int roomId) {
		List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
		List<RoomCommit> roomcommits = iDaoFrame.QueryRoomCommitByRoom(roomId);

		for (int i = 0; i < roomcommits.size(); i++) {
			User user = iDaoFrame
					.SearcheachUser(roomcommits.get(i).getUserId());
			HashMap<String, Object> map = roomcommits.get(i).toHashMap();
			map.put("user", user);
			maps.add(map);
		}
		return maps;
	}

	// ---------1.�½���������---------
	public boolean CreateRoomCommit(RoomCommit roomCommit) {
		boolean result = iDaoFrame.CreateRoomCommit(roomCommit);
		return result;
	}

	/**
	 * ---------------------�û����۷���-------------------------
	 */

	// �½�����
	public boolean CreateTransaction(Transaction transaction) {
		boolean result = iDaoFrame.CreateTransaction(transaction);
		return result;
	}

	// ��ѯ����
	public List<Transaction> QueryTransaction() {
		List<Transaction> result = iDaoFrame.QueryTransaction();
		return result;
	}
	
	//ͨ���û�id��ѯ���׼�¼
	public List<Transaction> Querybyuserid(int userid) {
		List<Transaction> result=iDaoFrame.Querybyuserid(userid);
		return result;
	}
	
	
	/*public List<OrderTable> CBllOrderAdvance(String OrderUserIDnumber,String OrderUserphon,String OrderUsername,int OrderStayinDay,int	OrderStayinPeopleNumber	,String	OrderCheckinTime,String OrderCheckoutTime,int  OrderMoney,int	OrderState,int	UserId,	int	RoomId){
		OrderTable order=new OrderTable(OrderUserphon, OrderStayinDay, OrderStayinPeopleNumber, OrderCheckinTime, OrderMoney, OrderState, UserId, RoomId);
		ordOrderlist.add(order);
		return ordOrderlist;
	}
	public class MyListener implements ServletContextListener {

	/*
	 * public List<OrderTable> CBllOrderAdvance(String OrderUserIDnumber,String
	 * OrderUserphon,String OrderUsername,int OrderStayinDay,int
	 * OrderStayinPeopleNumber ,String OrderCheckinTime,String
	 * OrderCheckoutTime,int OrderMoney,int OrderState,int UserId, int RoomId){
	 * OrderTable order=new OrderTable(OrderUserphon, OrderStayinDay,
	 * OrderStayinPeopleNumber, OrderCheckinTime, OrderMoney, OrderState,
	 * UserId, RoomId); ordOrderlist.add(order); return ordOrderlist; } public
	 * class MyListener implements ServletContextListener {
	 * 
	 * public void contextDestroyed(ServletContextEvent sce) { // 
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * public void contextInitialized(ServletContextEvent sce) { // 
	 * Auto-generated method stub
	 * 
	 * } }
	 */
}
