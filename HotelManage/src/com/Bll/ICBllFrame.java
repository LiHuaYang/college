package com.Bll;

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

public interface ICBllFrame {
	// ---------------------�������---------------------

	public List<Room> GetRoomByRoomCleaningState();

	/*
	 * ��ţ�Room:1 ���ܣ��������� ������Room room,RoomEquipment,Address
	 * ��̬������RoomUsingState=1 ����ֵ:boolean
	 */
	public boolean CreateRoom(Room room, RoomEquipment roomEquipment,
			Address address);
	/**
	 * ��ţ�Room:2 ���ܣ���ѯ�������� ������int roomId ����ֵ:Room
	 */
	public HashMap<String, Object> QueryRoomDetail(int roomid);

	/**
	 * ��ţ�Room:3 ���ܣ�ͨ��������ѯ���� ������Address address ����ֵ:Room
	 */
	public List<Room> QueryRoomByArea(Address address);

	/**
	 * ��ţ�Room:3 ���ܣ�ͨ������id��ѯ���� ������Address address ����ֵ:Room
	 */
	public List<Room> QueryRoomByAreaid(int addressId);

	/**
	 * ��ţ�Room:4 ���ܣ���ѯ����������Ϣ+����Ӧ������Ϣ+�����豸��Ϣ ������int orderId ����ֵ:HashMap
	 */
	public HashMap<String, Object> QueryOrder(int orderId);

	/**
	 * ��ţ�Room:5 ���ܣ�������״̬��ѯ���з��� ������int RoomUsingState ����ֵ:List<Room>
	 */
	public List<Room> QueryRoomByUsingState(int roomUsingState);

	/**
	 * ��ţ�Room��7 ���ܣ��޸ķ��䷿������ ����:Room room,RoomEquipment,Address ����ֵ��boolean
	 */
	public boolean UptateRoom(Room room, RoomEquipment roomEquipment,
			Address address);

	/**
	 * ��ţ�Room:8 ���ܣ���ѯ��Ҫ�����ķ��� ������RoomLockState ����ֵ��List<Room>
	 */
	public List<Room> QueryRoomNeedLocking();

	/**
	 * ��ţ�Room��9 ���ܣ�������������� ������RoomId��Lock/UNLOCK ����ֵ��boolean
	 */
	public boolean LockCheckRoom(int roomId, int CheckRoom);

	/**
	 * ��ţ�Room��10 ���ܣ�����addressid ������String AddressProvince,String
	 * AddressCity,String AddressVillage ����ֵ��int addressid
	 */
	public Address QueryAddressId(String AddressProvince, String AddressCity,
			String AddressVillage);

	// TDOD: List<Room> QueryRooms(); NOT YET
	public List<Room> QueryRooms();

	public List<Room> GetRoomByAddressViilage(String address);

	/**
	 * Room:11��ɾ������ ����:ɾ������ ������int RoomId ����ֵ��boolean
	 */
	public boolean DeleteRoom(int RoomId);

	/**
	 * Room:12���޸ķ���ʹ��״̬
	 * 
	 * @param roomid
	 * @param usingCheckRoom
	 * @return
	 */
	public boolean UsingCheckRoom(int roomid, int usingCheckRoom);

	public LinkedMap GetPageRoomInfo(int page);

	public int GetRoomNumber();

	// �������з���
	public List<Room> QueryAllRoom();

	// ͨ���������Ͳ��ҷ���
	public List<Room> QueryRoomByRoomtype(int roomtype);

	// --------------14.ͨ����������ϸ��ַ��Ϣ��ѯ����-----------
	public LinkedMap GetRoomByAddress(int addressid, String RoomDetailAddress,
			int page);

	// ---------------15.ͨ����������ϸ��ַ��Ϣ��ѯ��������------------
	public int GetRoomNumberByAddress(int AddressId, String RoomDetailAddress);
	
	// ---------------16.ͨ������ID���ط�����Ϣ------------
	public Room GetARoomById(int roomid);
	
	//2016-01-09 ��������ѯ����
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice);
	

	// ------------------------�������۲���--------------------
	public List<RoomCommit> getAllRoomCommits();// ��ѯ���з�������

	public RoomCommit getRoomCommit(int roomCommitId);// ��ѯ������������

	// ͨ��ҳ�����ҷ�������
	public List<RoomCommit> getRoomCommintByPage(int page);

	// �鿴����������
	public int getRoomCommunitNumber();

	// ------------------------��ַ����--------------------
	public HashMap QueryAllRooms();

	/**
	 * Address��1 ���ܣ���������address �������� ����ֵ��List<address>
	 */
	public List<Address> QueryAllAddress();

	// ----------------------���û��йز���------------------
	// �û�ע��
	public boolean CreateUser(User user);

	// ��ѯ�ͻ���������Ϣ
	public List<User> QueryAllUser();

	// ��ѯ�����û���Ϣ
	public User QuerySingelUser(int userId);

	// ʹ�������¼��ǰ�����������䲻���ظ���
	public int UserLoginEmail(String useremail, String userpassword);

	// ʹ�õ绰�����¼��ǰ���������绰���벻���ظ���ȣ�
	public int UserLoginPhon(String userphon, String userpassword);

	// ɾ�����û�
	public boolean DeleteUser(int userId);

	// ������������û�
	public boolean LockCheckUser(int userId, int userState);

	// �����û�����
	public boolean ResetUserPassword(int userId, int password);

	// �޸��û���Ϣ��ͨ���û�id�����û���Ϣ�������޸�
	public boolean UpdateUser(int userId, User user);
	
	//�޸Ĳ����û���Ϣ
	public boolean UpdateUserPart(int userId,String userName,String userSex,String userBoth,String userPhone,String userEmail,String userIdNumber,String userMessage);

	// �����û�ͷ��
	public boolean ChangeUserPic(int userId, String userPicture);

	// �鿴��ҳ�Ŀͻ�
	public List<User> GetUserByPage(int page);

	// �鿴�ͻ�����
	public int getUserNumber();

	// ����ģ������User
	public List<User> getUserByName(String UserName, int page);

	// ����ģ������User��
	public int getUserNumberByName(String UserName);
	
	//ͨ���绰����������ѯ����������������û�����Ϣ
	public List<HashMap<String, Object>> QueryPhonuserother (String userphon,String userpassword);
	
	//ͨ���û�id���ҳ��û�����֮���������Ϣ
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid);
	
	

	// //-----------------------���û���ֵ�йز���------------------
	//	
	// //�û���ֵ
	// public boolean UserRecharge(RechargeRecord rechargeRecord);
	//	
	// //��ѯ��ֵ��¼
	// public List<RechargeRecord> QueryRechargeRecord(int UserId);
	//	
	// //�û�����
	// public boolean UserConsumption(ConsumptionRecord consumptionRecord);
	//	
	// //��ѯ���Ѽ�¼
	// public List<ConsumptionRecord> QueryUserConsumpionRecord(int UserId);
	//	
	// //��ѯ�������Ѽ�¼
	// public List<ConsumptionRecord> getAllUserConsumpionRecords();
	//	
	// //��ѯ���г�ֵ��¼
	// public List<RechargeRecord> getAllRechargeRecords();
	// //ͨ��ҳ�����ҳ�ֵ��¼
	// public List<RechargeRecord> getRecordRecordByPage(int page);
	// //�鿴��ֵ��¼����
	// public int getRechargeRecordNumber();
	//	
	// //ͨ��ҳ���������Ѽ�¼
	// public List<ConsumptionRecord> getConsumptionRecordPage(int page);
	//	
	// //�鿴���Ѽ�¼��
	// public int getConsumptionRecordNumber();
	// ---------------------------����--------------------------

	// �½�����
	public boolean CreateOrder(OrderTable order);

	// ɾ������
	public boolean DeleteOrder(int orderId);

	// �ı䶩��״̬
	public boolean ChangeOrderState(int orderId, int orderState);

	// ͨ�������Ų��Ҷ���
	public OrderTable QueryOrderById(int orderId);

	// ͨ���û������Ҷ�����Ϣ
	public List<OrderTable> QueryOrderByUsername(int userId);

	// ͨ����ס��ʱ����Ҷ�����Ϣ
	public List<OrderTable> QueryOrderByCheckinTime(int OrderCheckinTime);

	// ͨ��������Ҷ�����Ϣ
	public List<OrderTable> QueryOrderByRoom(int RoomId);

	// �޸Ķ���
	public boolean UpdateOrder(OrderTable order);

	// �û�����,�ı䶩��״̬Ϊ5����ס����Ҫ��������������
	public boolean UserContinuedRoom(int orderId, int increaseDay,
			String OrderCheckOutTime, int OrderMoney);

	// ��ѯ���ж���
	public List<OrderTable> QueryAllOrders();

	// ���û��Ų��Ҷ����ͷ���
	public List<HashMap<String, Object>> QueryOrderRommByUserId(int userid);

	// ͨ��ҳ���鶩��
	public List<OrderTable> queryOrderTablesByPage(int page);

	// �鿴������
	public int getOrderNumber();

	// �鿴����������addressid/detailaddress/ page���Ķ�����
	public int getOrderNumberByAddress(String AddressProvince,
			String AddressCity, String AddressVillage, String DetatilAddress);

	// �鿴���������Ķ���
	public List<OrderTable> getOrdersByAddress(String AddressProvince,
			String AddressCity, String AddressVillage, String DetatilAddress,
			int page);

	// -----------------------���Ա----------------------
	// ��ţ�cleaner��
	// ���Ա��ע�����Cleanr cleaner,
	// ����ֵboolean
	public boolean CleanerRegister(Cleaner cleaner);

	// ��ţ�cleaner��2
	// id��ѯ���Ա��
	// ����int CleanerId
	// ����ֵ��cleaner
	public Cleaner QuerySingelCleaner(int CleanerId);

	// ��ţ�cleaner��3
	// ��ѯ���Աȫ�����Ա������
	// ����ֵ��cleaners
	public List<Cleaner> QueryAllCleaner();

	// ��ţ�cleaner��4
	// �޸ı���Ա״̬
	// ����ֵ��boolean
	public boolean UpdateCleanerState(int CleanerId, int CleanerState);

	// ͨ��ҳ��������๤
	public List<Cleaner> getCleanerByPage(int page);

	// �鿴��๤����
	public int getCleannerNumber();

	// �޸����Ա��Ϣ
	public boolean changeCleaner(Cleaner cleaner);

	// -------------------���Ա�����û�-----------------------
	/**
	 * ��ţ�usercommit��1 �ͻ��������۲��� ������UserCommit usercommit ����ֵboolean
	 */
	public boolean UserCommentRoom(UserCommit usercommit);

	/**
	 * ��ţ�usercommit��2 id��ѯĳ�ͻ�ȫ������ ����int userid ����ֵ��List<UserCommit>
	 */
	public List<UserCommit> QueryUserCommits(int userid);

	/**
	 * ��ţ�usercommit��3 ��ѯȫ������ ������NULL ����ֵ��List<UserCommit>
	 */
	public List<UserCommit> QueryAllCommit();

	public List<UserCommit> QueryUserCommintByPage(int page);

	public int GetUserCommintNumber();

	/**
	 * ��ţ�usercommit��5 ��Id��ѯ�����û����� ������UserCommitId ����ֵ��UserCommit
	 */
	public UserCommit GetSingelUserCommit(int UserCommitId);

	// -------------------���Ա���Լ�����¼����ల�ŵĲ���-----------------------

	// ����Ա�鿴�Լ������ʷ
	public List<CleaningRecord> QueryCleaningRecordUser(Cleaner cc);

	// ����Ա�鿴�Լ���ల��
	public List<CleanerWorkArrange> QueryCleanerWorkArrangeUser(Cleaner cc);

	// -------------------����Ա���������Ա����¼����ల�ŵĲ���-----------------------

	// ϵͳ�鿴���б���Ա�����ʷ
	public List<CleaningRecord> QueryCleaningRecordSystem();

	// ϵͳ�鿴���б���Ա��������
	public List<CleanerWorkArrange> QueryCleanerWorkArrangeSystem();

	// ����һ������Ա�����ʷ
	public boolean AddCleaningRecord(CleaningRecord cc);

	// ����һ������Ա��ల�ż�¼
	public boolean AddCleanerWorkArrange(CleanerWorkArrange cc);

	// �޸Ĺ������ż�¼
	public boolean ModifyCleanerWorkArrange(CleanerWorkArrange cc);

	// �鿴������������Ŀ
	public int getCleanerWorkNumber();

	// ͨ��ҳ����ҹ�������
	public List<CleanerWorkArrange> getCleanerWorkBypage(int page);

	// ��ѯ���е���
	public List<Address> GetAllAddress();

	public Manager QueryManagerByMessage(String managerAccount,
			String managerPassword);

	// ������Ų��ҵ�������Ϣ���û���Ϣ
	public List<HashMap<String, Object>> QueryRoomCommitUser(int roomId);

	// ---------1.�½���������---------
	public boolean CreateRoomCommit(RoomCommit roomCommit);

	// ͨ��ҳ����������¼
	public List<CleaningRecord> getCleanRecordPage(int page);

	// �鿴����¼��
	public int getCleanRecordNumber();

	// ɾ������Ա�������Ϣ
	// public boolean DeleteCleaner();

	/**
	 * ---------------------�û����۷���-------------------------
	 */

	// �½�����
	public boolean CreateTransaction(Transaction transaction);

	// ��ѯ����
	public List<Transaction> QueryTransaction();

	// ͨ���û�id��ѯ���׼�¼
	public List<Transaction> Querybyuserid(int userid);
}
