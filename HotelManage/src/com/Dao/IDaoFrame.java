package com.Dao;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.collections.map.LinkedMap;
import com.Entity.Address;
import com.Entity.Cleaner;
import com.Entity.CleanerWorkArrange;
import com.Entity.CleaningRecord;
import com.Entity.ConsumptionRecord;
import com.Entity.Manager;
import com.Entity.OrderTable;
import com.Entity.RechargeRecord;
import com.Entity.Room;
import com.Entity.RoomCommit;
import com.Entity.RoomEquipment;
import com.Entity.Transaction;
import com.Entity.User;
import com.Entity.UserCommit;

public interface IDaoFrame {

	/**
	 * ----------------------����-------------------------
	 */
	// �½�����
	public boolean CreateAddress(Address address);

	// ɾ������(��������ɾ��)//�ù��ܿ���ɾ��
	public boolean DeleteAddress(int addressid);

	// �������е���
	public List<Address> QueryAllAddress();

	// ��ѯ��������(ͨ��AddressId����)
	public Address QuerySingelAddress(int AddressId);

	// �޸ĵ���
	public boolean UpdateAddress(Address address);

	// ͨ��3����Ϣ�ҵ�ַȫ����Ϣ
	public Address queryAddress(String AddressProvince, String AddressCity,
			String AddressVillage);
	
	// ��ׯ��ģ����ַ����ѯ����ĵ�ַ
	public Address queryAddressByAddressVillage(String addressVillage);
	/**
	 * ----------------------����-----------------------
	 */
	public boolean CreateRoom(Room room);// �½�����

	public Room QueryRoomDetail(int roomid);// ��ѯ������Ϣ

	public List<Room> QueryRoomByArea(int addressid);// ͨ���������ҷ���

	public List<Room> QueryRoomByUsingState(int usingState);// ͨ������ʹ��״̬���ҷ���

	public boolean UpdateRoom(Room room); // ���·�����Ϣ

	public boolean LockCheckRoom(int roomid, int roomLockState);// ������״̬���£�������������ɾ����

	public List<Room> QueryRoomByLockingState(int lockState);// ͨ��������״̬��ѯ����

	public boolean DeleteRoom(int roomid);

	// ����ͨ��RoomCleaningState��ɸѡ������ɨ����
	public List<Room> QueryRoomByRoomCleaningState();

	public List<Room> QueryRooms();

	// �޸ķ���ʹ��״̬
	public boolean UsingCheckRoom(int roomid, int usingCheckRoom);

	public List<Room> queryRoomByAddressViilage(String address);

	public List<Room> GetCleanerChargeRoomByCleanerID(int cleanerid);

	public LinkedMap GetRoomInfoByPage(int page);

	public int GetRoomNumberNoDel();
	
	//2016-01-09 ��������ѯ����
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice);

	// --------------14.ͨ����������ϸ��ַ��Ϣ��ѯ����-----------
	public LinkedMap QueryRoomByAddress(int addressid,
			String RoomDetailAddress, int page);

	// ---------------15.ͨ����������ϸ��ַ��Ϣ��ѯ��������------------
	public int GetRoomNumberByAddress(int AddressId, String RoomDetailAddress);

	// ---------------16.�õ�ַ��ѯ����id�����id��list���Ϣ-------------------------
	public List<Integer> queryRoomByAddressWithoutPage(int addressid,
			String RoomDetailAddress);

	// ---------------17.��ѯĳ����ʣ�෿����Ϣ-------------------------
	public List<Room> GetLeftRoomInfoByAddress(String address);

	// ͨ���������Ͳ��ҷ���
	public List<Room> QueryRoomByRoomtype(int roomtype);
	
	//������סʱ����˷�ʱ����������Ϣ
	public List<OrderTable> queryorderbytime(String OrderCheckinTime,String OrderCheckoutTime);
	/**
	 * ---------------------�����豸----------------------
	 */
	public RoomEquipment QueryRoomEquipment(int roomEquipmentId);// ��ѯ�����豸

	public boolean CreateRoomEquipment(RoomEquipment roomEquipment);// �½������豸

	public boolean UpdateRoomEquipment(RoomEquipment roomEquipment);// ���·����豸

	/**
	 * ---------------------��������----------------------
	 */
	public boolean CreateRoomCommit(RoomCommit roomCommit);// �½���������

	public boolean UpdateRoomCommit(RoomCommit roomCommit);// ���·�������

	public List<RoomCommit> QueryRoomCommitByUser(int userId);// ͨ���û����ҷ�������

	public List<RoomCommit> QueryRoomCommitByRoom(int roomId);// ͨ��������ҷ�������

	public RoomCommit QuerySingelRoomCommit(int roomId);// ���ҵ�������

	public List<UserCommit> QueryUserCommitsByRoomid(int roomid);// ͨ������Id���ҷ�������

	public List<RoomCommit> QueryAllRoomCommits();// ��ѯ���з�������

	// ͨ��ҳ�����ҷ�������
	public List<RoomCommit> getRoomCommintByPage(int page);

	// �鿴����������
	public int getRoomCommunitNumber();

	// �������з���
	public List<Room> QueryAllRoom();

	/**
	 * ---------------------���Ա��Ϣ----------------------
	 */
	public boolean CleanerRegister(Cleaner cleaner);// ע�����Ա��

	public Cleaner QuerySingelCleaner(int CleanerId);// ��ѯĳ���Ա����Ϣ

	public List<Cleaner> QueryAllCleaner();// ��ѯȫ�����Ա��

	// �޸ı���Ա״̬
	public boolean UpdateCleanerState(int CleanerId, int CleanerState);

	// ��ѯ����Ա��Ϣͨ���ֻ�����
	public List<Cleaner> QueryCleanerByPhone(String phoneInfo);

	// ͨ��ҳ��������๤
	public List<Cleaner> getCleanerByPage(int page);

	// �鿴��๤����
	public int getCleannerNumber();

	// �޸����Ա��Ϣ
	public boolean UptateCleaner(Cleaner cleaner);

	/**
	 * ---------------------�û�����----------------------
	 */
	public boolean UserCommentRoom(UserCommit usercommit);// ���ӿͻ�����

	// ͨ��usercommitId�鿴��������
	public UserCommit queryUserCommitById(int UserCommitId);

	public List<UserCommit> QueryUserCommits(int userid);// ��ѯĳ�ͻ�������

	public List<UserCommit> QueryAllCommit();// ��ѯȫ������

	// ͨ��ҳ�����ҿͻ�����
	public List<UserCommit> QueryUserCommintByPage(int page);

	public int GetUserCommintNumber();

	/**
	 * ---------------------����¼-----------------------
	 */

	public boolean addCleaningRecord(CleaningRecord cr);

	public List<CleaningRecord> queryCleaningRecordByCleaningId(int cleaning_id);

	public List<CleaningRecord> queryCleaningRecordByRoomId(int room_id);

	public List<CleaningRecord> queryCleaningRecordByCleanerId(int cleaner_id);

	public boolean modifyCleaningRecord(CleaningRecord cr);

	public List<CleaningRecord> queryAllCleaningRecord();

	// ͨ��ҳ����������¼
	public List<CleaningRecord> getCleanRecordPage(int page);

	// �鿴����¼��
	public int getCleanRecordNumber();

	/**
	 * -----------------------��๤��������-----------------
	 */
	public boolean addCleanerWorkArrange(CleanerWorkArrange cr);

	public List<CleanerWorkArrange> queryCleanerWorkArrangeByWorkId(int work_id);

	public List<CleanerWorkArrange> queryCleanerWorkArrangeByCleanerId(
			int cleaner_id);

	public boolean modifyCleaningCleanerWorkArrange(CleanerWorkArrange cr);

	public List<CleanerWorkArrange> queryAllCleanerWorkArrange();

	// �鿴��๤�����ű�����
	public int getCleanerWorkNumber();

	// ͨ��ҳ�����ҹ�������
	public List<CleanerWorkArrange> queryPageCleanerWorkArranges(int page);

	/**
	 * ---------------------------�û�-----------------------
	 */
	// �½��ͻ�
	public boolean CreateUser(User user);

	// ��ѯ�ͻ����������Ϣ
	public List<User> SearchtotalUser();

	// ��ѯ�����û���Ϣ
	public User SearcheachUser(int userId);

	// �޸��û���Ϣ
	public boolean DisappearUser(User user);
	
	//�޸��û�������Ϣ
	public boolean ChangeUserPart(int userId,String userName,String userSex,String userBoth,String userPhone,String userEmail,String userIdNumber,String userMessage);
	
//	//ͨ�������ѯ�û���Ϣ
//	public List<User> Queryemailuser(String useremail);
	

	// //ͨ�������ѯ�û���Ϣ
	// public List<User> Queryemailuser(String useremail);

	// ����id�����û���ͼƬ
	public boolean ChangeUserPic(int userId, String userPicture);

	// ͨ������������ѯ�û�id
	public int Queryemailuser(String useremail, String userpassword);

	// ͨ���绰����������ѯ�û�id
	public int Queryphonuser(String userphon, String userpassword);

	// �����û�id�޸��û�״̬
	public boolean changerUserState(int userId, int userState);

	// �����û�id�޸��û�����
	public boolean changerUserPassword(int userId, int password);

	// ͨ��ҳ�����ҿͻ�
	public List<User> getUserByPage(int page);

	// �鿴�ͻ���
	public int getUserNumber();

	// ������ģ�����ҿͻ�������
	public int queryUserNumberByName(String UserName);

	//ͨ���û�id���ҳ��û�����֮���������Ϣ
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid);
/**
* ---------------------------����------------------------	
*/
	//�½�����

	// ���ͻ�����ҳ��ģ������
	public List<User> queryUserByName(String UserName, int page);

	// ͨ���绰����������ѯ����������������û�����Ϣ
	public List<HashMap<String, Object>> QueryPhonuserother(String userphon,
			String userpassword);

	// �½�����
	public boolean CreateOrder(OrderTable order);

	// �༭����
	public boolean QueryOrder(OrderTable order);

	// ͨ������id�޸Ķ���״̬
	public boolean changerorderState(int orderId, int orderState);

	// ͨ�������Ų��Ҷ�����Ϣ
	public OrderTable QueryDetailOrder(int orderId);

	// ͨ���û������Ҷ�����Ϣ
	public List<OrderTable> QueryuserOrder(int userId);

	// ͨ���������Ҷ�����Ϣ
	public List<OrderTable> QueryareaOrder(int Addressid);

	// ͨ����ס��ʱ����Ҷ�����Ϣ
	public List<OrderTable> QuerytimeOrder(int OrderCheckinTime);

	// ͨ��������Ҷ�����Ϣ
	public List<OrderTable> QueryroomOrder(int RoomId);

	// �޸Ķ���״̬����ס�������˷�ʱ�䣬�ܹ�����Ǯ
	public boolean changeOrderDayState(int orderId, int orderStayinDay,
			String orderCheckoutTime, int orderMoney);

	// ͨ��OrderId�ı䷿��״̬
	public boolean changeOrderState(int OrederId, int OrderState);

	// �������ж���
	public List<OrderTable> queryOrderTables();

	// ͨ��ҳ���鶩��
	public List<OrderTable> queryOrderTablesByPage(int page);

	// �鿴������
	public int getOrderNumber();

	// �÷��䣨������䣩�鿴������
	public int queryOrderNumberByAddress(List<Integer> rooms);

	// �÷��䣨������䣩��ȡ���������Ϣ
	public List<List<OrderTable>> queryOrderByAddress(List<Integer> rooms);

	/**
	 * ------------------------��ֵ��¼--------------------
	 */
	// //�½���ֵ��¼��
	// public boolean CreateRecode(RechargeRecord rechargeRecord);
	//	
	// //��ѯ��ֵ��¼
	// public List<RechargeRecord> SearchRecode(int UserId);
	//	
	// //��ѯ���г�ֵ��¼
	// public List<RechargeRecord> queryRechargeRecords();
	// //ͨ��ҳ�����ҳ�ֵ��¼
	// public List<RechargeRecord> getRecordRecordByPage(int page);
	// //�鿴��ֵ��¼����
	// public int getRechargeRecordNumber();
	//	

	/**
	 * ------------------------���Ѽ�¼---------------------
	 */
	// //�½����Ѽ�¼
	// public boolean CreateConsumptionRecord(ConsumptionRecord
	// consumptionRecord);
	//	
	// //��ѯ���Ѽ�¼
	// public List<ConsumptionRecord> SearchConsumptionRecord(int UserId);
	//	
	// //��ѯ�������Ѽ�¼
	// public List<ConsumptionRecord> queryAllConsumptionRecords();
	//	
	// //ͨ��ҳ���������Ѽ�¼
	// public List<ConsumptionRecord> getConsumptionRecordPage(int page);
	//	
	// //�鿴���Ѽ�¼��
	// public int getConsumptionRecordNumber();

	/**
	 * -------------------------����Ա------------------------
	 */
	// ���ӹ���Ա
	public boolean AddManager(Manager manager);

	// ͨ���ʺ�������ҹ���Ա
	public Manager QueryManagerByMessage(String ManagerAccount,
			String ManagerPassword);

	// ͨ������Աid���ҹ���Ա
	public Manager QuerManagerById(int ManagerId);

	// �޸Ĺ���Ա��Ϣ
	public boolean UpdateManager(Manager manager);

	// ɾ������Ա
	public boolean DeleteManager(Manager manager);

	/**
	 * -------------------------���׼�¼------------------------
	 */

	// �½�����
	public boolean CreateTransaction(Transaction transaction);

	// ��ѯ����
	public List<Transaction> QueryTransaction();
	
	//ͨ���û�id��ѯ���׼�¼
	public List<Transaction> Querybyuserid(int userid);
}
