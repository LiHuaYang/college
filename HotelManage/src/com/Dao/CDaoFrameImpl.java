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

public class CDaoFrameImpl implements IDaoFrame {
	private CDaoAddress cDaoAddress = new CDaoAddress();
	private CDaoRoom cDaoRoom = new CDaoRoom();
	private CDaoRoomCommit cDaoRoomCommit = new CDaoRoomCommit();
	private CDaoRoomEquipment cDaoRoomEquipment = new CDaoRoomEquipment();
	private CDaoCleaner cDaoCleaner = new CDaoCleaner();
	private CDaoUserCommit cDaoUserCommit = new CDaoUserCommit();
	private CDaoCleaningRecord cDaoCleaningRecord = new CDaoCleaningRecord();
	private CDaoCleanerWorkArrange cDaoCleanerWorkArrange = new CDaoCleanerWorkArrange();
	private CDaoOrder cDaoOrder = new CDaoOrder();
	// private CDaoConsumptionRecord cDaoConsumptionRecord = new
	// CDaoConsumptionRecord();
	// private CDaoRechargeRecord cDaoRechargeRecord = new CDaoRechargeRecord();
	private CDaoUser cDaoUser = new CDaoUser();
	private CDaoManager cDaoManager = new CDaoManager();
	private CDaoTransaction cDaoTransaction = new CDaoTransaction();

	public boolean CreateAddress(Address address) {
		if (cDaoAddress.CreateAddress(address)) {
			return true;
		}
		return false;
	}

	public boolean CreateRoom(Room room) {
		if (cDaoRoom.CreateRoom(room)) {
			return true;
		}
		return false;
	}

	public boolean CreateRoomCommit(RoomCommit roomCommit) {
		if (cDaoRoomCommit.CreateRoomCommit(roomCommit)) {
			return true;
		}
		return false;
	}

	public boolean CreateRoomEquipment(RoomEquipment roomEquipment) {
		if (cDaoRoomEquipment.CreateRoomEquipment(roomEquipment)) {
			return true;
		}
		return false;
	}

	public boolean DeleteAddress(int addressid) {
		if (cDaoAddress.DeleteAddress(addressid)) {
			return true;
		}
		return false;
	}

	public boolean DeleteRoom(int roomid) {
		if (cDaoRoom.DeleteRoom(roomid)) {
			return true;
		}
		return false;
	}

	public boolean LockCheckRoom(int roomid, int roomLockState) {
		if (cDaoRoom.LockCheckRoom(roomid, roomLockState)) {
			return true;
		}
		return false;
	}

	public List<Address> QueryAllAddress() {
		List<Address> addresses = null;
		try {
			addresses = cDaoAddress.QueryAllAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addresses;
	}

	public List<Room> QueryRoomByArea(int addressid) {
		List<Room> rooms = null;
		try {
			rooms = cDaoRoom.QueryRoomByArea(addressid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public List<Room> QueryRoomByLockingState(int lockState) {
		List<Room> rooms = null;
		try {
			rooms = cDaoRoom.QueryRoomByLockingState(lockState);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public List<Room> QueryRoomByUsingState(int usingState) {
		List<Room> rooms = null;
		try {
			rooms = cDaoRoom.QueryRoomByUsingState(usingState);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public List<RoomCommit> QueryRoomCommitByRoom(int roomId) {
		List<RoomCommit> roomCommits = null;
		try {
			roomCommits = cDaoRoomCommit.QueryRoomCommitByRoom(roomId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomCommits;
	}

	public List<RoomCommit> QueryRoomCommitByUser(int userId) {
		List<RoomCommit> roomCommits = null;
		try {
			roomCommits = cDaoRoomCommit.QueryRoomCommitByUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomCommits;
	}

	public Room QueryRoomDetail(int roomid) {
		Room room = null;
		try {
			room = cDaoRoom.QueryRoomDetail(roomid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return room;
	}

	public RoomEquipment QueryRoomEquipment(int roomEquipmentId) {
		RoomEquipment roomEquipment = null;
		try {
			roomEquipment = cDaoRoomEquipment
					.QueryRoomEquipment(roomEquipmentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomEquipment;
	}

	public Address QuerySingelAddress(int AddressId) {
		Address address = null;
		try {
			address = cDaoAddress.QuerySingelAddress(AddressId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}

	// update
	public boolean UpdateAddress(Address address) {
		if (cDaoAddress.UpdateAddress(address)) {
			return true;
		}
		return false;
	}

	public boolean UpdateRoom(Room room) {
		if (cDaoRoom.UpdateRoom(room)) {
			return true;
		}
		return false;
	}

	public boolean UpdateRoomCommit(RoomCommit roomCommit) {
		if (cDaoRoomCommit.UpdateRoomCommit(roomCommit)) {
			return true;
		}
		return false;
	}

	public boolean UpdateRoomEquipment(RoomEquipment roomEquipment) {
		if (cDaoRoomEquipment.UpdateRoomEquipment(roomEquipment)) {
			return true;
		}
		return false;
	}

	public RoomCommit QuerySingelRoomCommit(int roomId) {
		RoomCommit roomCommit = null;
		try {
			roomCommit = cDaoRoomCommit.QuerySingelRoomCommit(roomId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomCommit;
	}

	public boolean CleanerRegister(Cleaner cleaner) {
		if (cDaoCleaner.CleanerRegister(cleaner)) {
			return true;
		}
		return false;
	}

	public List<Cleaner> QueryAllCleaner() {
		List<Cleaner> cleaners = null;
		try {
			cleaners = cDaoCleaner.QueryAllCleaner();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleaners;
	}

	public List<UserCommit> QueryAllCommit() {
		List<UserCommit> userCommits = null;
		try {
			userCommits = cDaoUserCommit.QueryAllCommit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCommits;
	}

	public Cleaner QuerySingelCleaner(int CleanerId) {
		Cleaner cleaner = null;
		try {
			cleaner = cDaoCleaner.QuerySingelCleaner(CleanerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleaner;
	}

	public List<UserCommit> QueryUserCommits(int userid) {
		List<UserCommit> userCommits = null;
		try {
			userCommits = cDaoUserCommit.QueryUserCommits(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCommits;
	}

	public boolean UserCommentRoom(UserCommit usercommit) {
		if (cDaoUserCommit.UserCommentRoom(usercommit)) {
			return true;
		}
		return false;
	}

	public boolean addCleanerWorkArrange(CleanerWorkArrange cr) {
		if (cDaoCleanerWorkArrange.addCleanerWorkArrange(cr)) {
			return true;
		}
		return false;
	}

	public boolean addCleaningRecord(CleaningRecord cr) {
		if (cDaoCleaningRecord.addCleaningRecord(cr)) {
			return true;
		}
		return false;
	}

	public boolean modifyCleaningCleanerWorkArrange(CleanerWorkArrange cr) {
		if (cDaoCleanerWorkArrange.modifyCleaningCleanerWorkArrange(cr)) {
			return true;
		}
		return false;
	}

	public boolean modifyCleaningRecord(CleaningRecord cr) {
		if (cDaoCleaningRecord.modifyCleaningRecord(cr)) {
			return true;
		}
		return false;
	}

	public List<CleanerWorkArrange> queryAllCleanerWorkArrange() {
		List<CleanerWorkArrange> CleanerWorkArranges = null;
		try {
			CleanerWorkArranges = cDaoCleanerWorkArrange
					.queryAllCleanerWorkArrange();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CleanerWorkArranges;
	}

	public List<CleanerWorkArrange> queryCleanerWorkArrangeByCleanerId(
			int cleaner_id) {
		List<CleanerWorkArrange> CleanerWorkArranges = null;
		try {
			CleanerWorkArranges = cDaoCleanerWorkArrange
					.queryCleanerWorkArrangeByCleanerId(cleaner_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CleanerWorkArranges;
	}

	public List<CleanerWorkArrange> queryCleanerWorkArrangeByWorkId(int workId) {
		List<CleanerWorkArrange> CleanerWorkArranges = null;
		try {
			CleanerWorkArranges = cDaoCleanerWorkArrange
					.queryCleanerWorkArrangeByWorkId(workId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CleanerWorkArranges;
	}

	public List<CleaningRecord> queryAllCleaningRecord() {
		List<CleaningRecord> CleaningRecords = null;
		try {
			CleaningRecords = cDaoCleaningRecord.queryAllCleaningRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CleaningRecords;
	}

	public List<CleaningRecord> queryCleaningRecordByCleanerId(int cleanerId) {
		List<CleaningRecord> CleaningRecords = null;
		try {
			CleaningRecords = cDaoCleaningRecord
					.queryCleaningRecordByCleanerId(cleanerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CleaningRecords;
	}

	public List<CleaningRecord> queryCleaningRecordByCleaningId(int cleaningId) {
		List<CleaningRecord> CleaningRecords = null;
		try {
			CleaningRecords = cDaoCleaningRecord
					.queryCleaningRecordByCleaningId(cleaningId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CleaningRecords;
	}

	public List<CleaningRecord> queryCleaningRecordByRoomId(int roomId) {
		List<CleaningRecord> CleaningRecords = null;
		try {
			CleaningRecords = cDaoCleaningRecord
					.queryCleaningRecordByRoomId(roomId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CleaningRecords;
	}

	// 新建订单
	public boolean CreateOrder(OrderTable order) {
		if (cDaoOrder.CreateOrder(order)) {
			return true;
		}
		return false;
	}

	// 通过订单号查找订单信息
	public OrderTable QueryDetailOrder(int orderId) {
		OrderTable order = null;
		try {
			order = cDaoOrder.QueryDetailOrder(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	// 编辑订单
	public boolean QueryOrder(OrderTable order) {
		if (cDaoOrder.QueryOrder(order)) {
			return true;
		}
		return false;
	}

	// 通过订单id修改订单状态
	public boolean changerorderState(int orderId, int orderState) {
		boolean result = cDaoOrder.changerorderState(orderId, orderState);
		return result;
	}

	// 通过地区查找订单信息
	public List<OrderTable> QueryareaOrder(int Addressid) {
		List<OrderTable> orders = null;
		try {
			orders = cDaoOrder.QueryareaOrder(Addressid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	// 通过房间查找订单信息
	public List<OrderTable> QueryroomOrder(int RoomId) {
		List<OrderTable> orders = null;
		try {
			orders = cDaoOrder.QueryroomOrder(RoomId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	// 通过入住的时间查找订单信息
	public List<OrderTable> QuerytimeOrder(int OrderCheckinTime) {
		List<OrderTable> orders = null;
		try {
			orders = cDaoOrder.QuerytimeOrder(OrderCheckinTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	// 通过用户名查找订单信息
	public List<OrderTable> QueryuserOrder(int userId) {
		List<OrderTable> orders = null;
		try {
			orders = cDaoOrder.QueryuserOrder(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	// //新建消费记录
	// public boolean CreateConsumptionRecord(ConsumptionRecord
	// consumptionRecord) {
	// if(cDaoConsumptionRecord.CreateConsumptionRecord(consumptionRecord)){
	// return true;
	// }
	// return false;
	// }

	// //新建充值记录表
	// public boolean CreateRecode(RechargeRecord rechargeRecord) {
	// if(cDaoRechargeRecord.CreateRecode(rechargeRecord)){
	// return true;
	// }
	// return false;
	// }
	//
	// //查询消费记录
	// public List<ConsumptionRecord> SearchConsumptionRecord(int UserId) {
	// List<ConsumptionRecord> consumptionRecords = null;
	// try {
	// consumptionRecords=cDaoConsumptionRecord.SearchConsumptionRecord(UserId);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return consumptionRecords;
	// }
	//
	// //查询充值记录
	// public List<RechargeRecord> SearchRecode(int UserId) {
	// List<RechargeRecord> rechargeRecords = null;
	// try {
	// rechargeRecords=cDaoRechargeRecord.SearchRecode(UserId);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return rechargeRecords;
	// }

	// 新建客户
	public boolean CreateUser(User user) {
		if (cDaoUser.CreateUser(user)) {
			return true;
		}
		return false;
	}

	// 编辑客户
	public boolean DisappearUser(User user) {
		if (cDaoUser.DisappearUser(user)) {
			return true;
		}
		return false;
	}

	// 查询单个用户信息
	public User SearcheachUser(int userId) {
		User user = null;
		try {
			user = cDaoUser.SearcheachUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//通过用户id查找除用户密码之外的所有信息
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid){
		List<HashMap<String, Object>> result=cDaoUser.QueryUserExceptPasswordById(userid);
		return result;
	}

	//查询所有用户
	public List<User> SearchtotalUser() {
		List<User> users = null;
		try {
			users = cDaoUser.SearchtotalUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public boolean changerUserState(int userId, int userState) {
		if (cDaoUser.changerUserState(userId, userState)) {
			return true;
		}
		return false;
	}

	public boolean changerUserPassword(int userId, int password) {
		if (cDaoUser.changerUserPassword(userId, password)) {
			return true;
		}
		return false;
	}

	public boolean changeOrderDayState(int orderId, int orderStayinDay,
			String orderCheckoutTime, int orderMoney) {
		if (cDaoOrder.changeOrderDayState(orderId, orderStayinDay,
				orderCheckoutTime, orderMoney)) {
			return true;
		}
		return false;
	}

	public List<UserCommit> QueryUserCommitsByRoomid(int roomid) {
		@SuppressWarnings("unused")
		List<RoomCommit> userCommits = null;
		try {
			userCommits = cDaoRoomCommit.QueryRoomCommitByRoom(roomid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Address queryAddress(String AddressProvince, String AddressCity,
			String AddressVillage) {
		Address address = cDaoAddress.queryAddress(AddressProvince,
				AddressCity, AddressVillage);
		return address;
	}

	// //通过邮箱查询用户信息
	// public List<User> Queryemailuser(String useremail) {
	// List<User> result=cDaoUser.Queryemailuser(useremail);
	// return result;
	//		
	// }

	// 通过邮箱和密码查询用户id
	public int Queryemailuser(String useremail, String userpassword) {
		int result = cDaoUser.Queryemailuser(useremail, userpassword);
		return result;
	}

	// 通过电话号码和密码查询用户id
	public int Queryphonuser(String userphon, String userpassword) {
		int result = cDaoUser.Queryphonuser(userphon, userpassword);
		return result;

	}

	/**
	 * --------------------管理员-----------------------
	 */
	public boolean AddManager(Manager manager) {
		boolean bman = cDaoManager.AddManager(manager);
		return bman;
	}

	public Manager QuerManagerById(int ManagerId) {
		Manager manager = cDaoManager.QuerManagerById(ManagerId);
		return manager;
	}

	public Manager QueryManagerByMessage(String ManagerAccount,
			String ManagerPassword) {
		Manager manager = cDaoManager.QueryManagerByMessage(ManagerAccount,
				ManagerPassword);
		return manager;
	}

	public boolean UpdateManager(Manager manager) {
		boolean uman = cDaoManager.UpdateManager(manager);
		return uman;
	}

	public boolean DeleteManager(Manager manager) {
		boolean del = cDaoManager.DeleteManager(manager);
		return del;
	}

	public List<Room> QueryRooms() {
		List<Room> rooms = cDaoRoom.QueryRooms();
		return rooms;
	}

	public List<OrderTable> queryOrderTables() {
		List<OrderTable> orderTables = cDaoOrder.queryOrderTables();
		return orderTables;
	}

	public List<RoomCommit> QueryAllRoomCommits() {
		List<RoomCommit> roomCommits = cDaoRoomCommit.QueryAllRoomCommits();
		return roomCommits;
	}

	// 查询所有充值记录
	// public List<RechargeRecord> queryRechargeRecords() {
	// List<RechargeRecord> rechargeRecords =
	// cDaoRechargeRecord.queryRechargeRecords();
	// return rechargeRecords;
	// }

	// 查询所有消费记录
	// public List<ConsumptionRecord> queryAllConsumptionRecords() {
	// List<ConsumptionRecord> consumptionRecords =
	// cDaoConsumptionRecord.queryAllConsumptionRecords();
	// return consumptionRecords;
	// }

	public List<Cleaner> QueryCleanerByPhone(String phoneInfo) {

		List<Cleaner> cleaner = cDaoCleaner.QueryCleanerByPhone(phoneInfo);

		return cleaner;
	}

	public List<Room> QueryRoomByRoomCleaningState() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Room> queryRoomByAddressViilage(String address) {
		List<Room> rooms = cDaoRoom.queryRoomByAddressViilage(address);
		return rooms;
	}

	// 通过OrderId改变房间状态
	public boolean changeOrderState(int OrederId, int OrderState) {
		boolean result = cDaoOrder.changeOrderState(OrederId, OrderState);
		return result;
	}

	public boolean UpdateCleanerState(int CleanerId, int CleanerState) {
		boolean bupdate = cDaoCleaner.UpdateCleanerState(CleanerId,
				CleanerState);
		return bupdate;
	}

	public boolean UsingCheckRoom(int roomid, int usingCheckRoom) {
		boolean busingcheck = cDaoRoom.UsingCheckRoom(roomid, usingCheckRoom);
		return busingcheck;
	}

	public List<Room> GetCleanerChargeRoomByCleanerID(int cleanerid) {
		List<Room> rooms = cDaoRoom.GetCleanerChargeRoomByCleanerID(cleanerid);
		return rooms;
	}

	public LinkedMap GetRoomInfoByPage(int page) {
		LinkedMap findReuslt = cDaoRoom.GetRoomInfoByPage(page);
		return findReuslt;
	}

	public int GetRoomNumberNoDel() {
		// TODO Auto-generated method stub
		int result = cDaoRoom.GetRoomNumberNoDel();
		return result;
	}

	public List<User> getUserByPage(int page) {
		List<User> findResult = cDaoUser.getUserByPage(page);
		return findResult;
	}

	public int getUserNumber() {
		int findResult = cDaoUser.getUserNumber();
		return findResult;
	}

	public List<OrderTable> queryOrderTablesByPage(int page) {
		List<OrderTable> findResult = cDaoOrder.queryOrderTablesByPage(page);

		return findResult;
	}

	public int getOrderNumber() {
		int findResult = cDaoOrder.getOrderNumber();
		return findResult;
	}

	public List<Cleaner> getCleanerByPage(int page) {
		List<Cleaner> findResult = cDaoCleaner.getCleanerByPage(page);
		return findResult;
	}

	public int getCleannerNumber() {
		int count = cDaoCleaner.getCleannerNumber();
		return count;
	}

	public List<UserCommit> QueryUserCommintByPage(int page) {
		List<UserCommit> findReuslt = cDaoUserCommit
				.QueryUserCommintByPage(page);
		return findReuslt;
	}

	public int GetUserCommintNumber() {
		int count = cDaoUserCommit.GetUserCommintNumber();
		return count;
	}

	// 通过页数查找房间评价
	public List<RoomCommit> getRoomCommintByPage(int page) {
		List<RoomCommit> findResult = cDaoRoomCommit.getRoomCommintByPage(page);
		return findResult;
	}

	// 查看房间评价数
	public int getRoomCommunitNumber() {
		int count = cDaoRoomCommit.getRoomCommunitNumber();
		return count;
	}

	// 通过页数查找清洁记录
	public List<CleaningRecord> getCleanRecordPage(int page) {
		List<CleaningRecord> findResult = cDaoCleaningRecord
				.getCleanRecordPage(page);
		return findResult;
	}

	// 查看清洁记录数
	public int getCleanRecordNumber() {
		int count = cDaoCleaningRecord.getCleanRecordNumber();
		return count;
	}

	// //通过页数查找充值记录
	// public List<RechargeRecord> getRecordRecordByPage(int page){
	// List<RechargeRecord>
	// findResult=cDaoRechargeRecord.getRecordRecordByPage(page);
	// return findResult;
	// }
	// 查看充值记录个数
	// public int getRechargeRecordNumber(){
	// int count =cDaoRechargeRecord.getRechargeRecordNumber();
	// return count;
	// }
	// 通过页数查找消费记录
	// public List<ConsumptionRecord> getConsumptionRecordPage(int page){
	// List<ConsumptionRecord>
	// findReulst=cDaoConsumptionRecord.getConsumptionRecordPage(page);
	// return findReulst;
	// }
	// 查看消费记录数
	// public int getConsumptionRecordNumber(){
	// int count =cDaoConsumptionRecord.getConsumptionRecordNumber();
	// return count;
	// }

	public boolean UptateCleaner(Cleaner cleaner) {
		boolean bupdated = cDaoCleaner.UptateCleanerById(cleaner);
		return bupdated;
	}

	public UserCommit queryUserCommitById(int UserCommitId) {
		UserCommit userCommit = cDaoUserCommit
				.queryUserCommitById(UserCommitId);
		return userCommit;
	}

	public int getCleanerWorkNumber() {
		int get = cDaoCleanerWorkArrange.getCleanerWorkNumber();
		return get;
	}

	public List<CleanerWorkArrange> queryPageCleanerWorkArranges(int page) {
		List<CleanerWorkArrange> cleanerWorkArranges = cDaoCleanerWorkArrange
				.queryPageCleanerWorkArranges(page);
		return cleanerWorkArranges;
	}

	public int GetRoomNumberByAddress(int AddressId, String RoomDetailAddress) {
		int RoomNumber = cDaoRoom.GetRoomNumberByAddress(AddressId,
				RoomDetailAddress);
		return RoomNumber;
	}

	public LinkedMap QueryRoomByAddress(int addressid,
			String RoomDetailAddress, int page) {
		LinkedMap findresult = cDaoRoom.QueryRoomByAddress(addressid,
				RoomDetailAddress, page);
		return findresult;
	}

	public List<User> queryUserByName(String UserName, int page) {
		List<User> users = cDaoUser.queryUserByName(UserName, page);
		return users;
	}

	public int queryUserNumberByName(String UserName) {
		int number = cDaoUser.queryUserNumberByName(UserName);
		return number;
	}

	public List<List<OrderTable>> queryOrderByAddress(List<Integer> rooms) {
		List<List<OrderTable>> orders = cDaoOrder.queryOrderByAddress(rooms);
		return orders;
	}

	public int queryOrderNumberByAddress(List<Integer> rooms) {
		int count = cDaoOrder.queryOrderNumberByAddress(rooms);
		return count;
	}

	public List<Integer> queryRoomByAddressWithoutPage(int addressid,
			String RoomDetailAddress) {
		List<Integer> number_countaner = cDaoRoom
				.queryRoomByAddressWithoutPage(addressid, RoomDetailAddress);
		return number_countaner;
	}

	public List<Room> GetLeftRoomInfoByAddress(String village) {
		List<Room> rooms = cDaoRoom.GetLeftRoomInfoByAddress(village);
		return rooms;
	}

	// 根据id更改用户的图片
	public boolean ChangeUserPic(int userId, String userPicture) {
		boolean result = cDaoUser.ChangeUserPic(userId, userPicture);
		return result;
	}
	//修改用户部分信息
	public boolean ChangeUserPart(int userId,String userName,String userSex,String userBoth,String userPhone,String userEmail,String userIdNumber,String userMessage){
		boolean result=cDaoUser.ChangeUserPart(userId, userName, userSex, userBoth, userPhone, userEmail, userIdNumber, userMessage);
		return result;
	}
	
	//查找所有房间
	public List<Room> QueryAllRoom(){
		List<Room> rooms = null;
		try {
			rooms = cDaoRoom.QueryAllRoom();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	// 通过房间类型查找房间
	public List<Room> QueryRoomByRoomtype(int roomtype) {
		List<Room> rooms = null;
		try {
			rooms = cDaoRoom.QueryRoomByRoomtype(roomtype);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	// 通过电话号码和密码查询出密码以外的所有用户的信息
	public List<HashMap<String, Object>> QueryPhonuserother(String userphon,
			String userpassword) {
		List<HashMap<String, Object>> result = cDaoUser.QueryPhonuserother(
				userphon, userpassword);
		return result;
	}
	
	//根据入住时间和退房时间来订单信息
	public List<OrderTable> queryorderbytime(String OrderCheckinTime,String OrderCheckoutTime){
		List<OrderTable> result=cDaoOrder.queryorderbytime(OrderCheckinTime, OrderCheckoutTime);
		return result;
	}
	
	
	/**
	* -------------------------房间------------------------	
	*/
	
	//2016-01-09 多条件查询房间
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice){
		List<Room> result= cDaoRoom.QueryRoomselectcondition(village, indata, outdata, minprice, maxprice);
		return result;
	}
	
/**
* -------------------------交易记录------------------------	
*/
	//新建交易
	public boolean CreateTransaction(Transaction transaction) {
		boolean result = cDaoTransaction.CreateTransaction(transaction);
		return result;
	}

	// 查询交易
	public List<Transaction> QueryTransaction() {
		List<Transaction> result = cDaoTransaction.QueryTransaction();
		return result;
	}

	// 通过用户id查询交易记录
	public List<Transaction> Querybyuserid(int userid) {
		List<Transaction> result = cDaoTransaction.Querybyuserid(userid);
		return result;
	}
	
	// 通过模糊地址来查询具体的地址
	public Address queryAddressByAddressVillage(String addressVillage) {
		Address address = cDaoAddress
				.queryAddressByAddressVillage(addressVillage);
		return address;
	}

}
