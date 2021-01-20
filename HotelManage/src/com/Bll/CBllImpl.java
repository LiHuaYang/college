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

	// -----------------------房间操作----------------------------
	/**
	 * 序号：Room:1 功能：创建房间 参数：Room room,RoomEquipment,Address
	 * 静态参数：RoomUsingState=1 返回值:boolean
	 */
	public boolean CreateRoom(Room room, RoomEquipment roomEquipment,
			Address address) {
		if (cBllFrame.CreateRoom(room, roomEquipment, address.getAddressId())) {
			return true;
		}
		return false;
	}

	/**
	 * 序号：Room：9 功能：激活或锁定房间 参数：RoomId、Lock/UNLOCK 返回值：boolean
	 */
	public boolean LockCheckRoom(int roomId, int CheckRoom) {
		if (cBllFrame.LockCheckRoom(roomId, CheckRoom)) {
			return true;
		}
		return false;
	}

	/**
	 * 序号：Room:4 功能：查询单条订单信息+所对应房间信息+房间设备信息 参数：int orderId 返回值:HashMap
	 */
	public HashMap<String, Object> QueryOrder(int orderId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map = cBllFrame.QueryOrder(orderId);
		return map;
	}

	/**
	 * 序号：Room:3 功能：通过地区查询房间 参数：Address address 返回值:Room
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
	 * 序号：Room:3 功能：通过地区id查询房间 参数：Address address 返回值:Room
	 */
	public List<Room> QueryRoomByAreaid(int addressId) {
		List<Room> room = cBllFrame.QueryRoomByAreaid(addressId);
		return room;
	}

	/**
	 * 序号：Room:5 功能：按房间状态查询所有房间 参数：int RoomUsingState 返回值:List<Room>
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
	 * 序号：Room:2 功能：查询房间详情 参数：int roomId 返回值:Room
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
	 * 序号：Room:8 功能：查询需要锁定的房间 参数：RoomLockState 返回值：List<Room>
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
	 * 序号：Room：7 功能：修改房间房间属性 参数:Room room,RoomE 返回值：boolean
	 */
	public boolean UptateRoom(Room room, RoomEquipment roomEquipment,
			Address address) {
		if (cBllFrame.UptateRoom(room, roomEquipment, address)) {
			return true;
		}
		return false;
	}

	/**
	 * Address：1 功能：查找所有address 参数：无 返回值：List<address>
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

	// 查找所有房间
	public List<Room> QueryAllRoom() {
		List<Room> rooms = cBllFrame.QueryAllRoom();
		return rooms;
	}

	// 通过房间类型查找房间
	public List<Room> QueryRoomByRoomtype(int roomtype) {
		List<Room> rooms = cBllFrame.QueryRoomByRoomtype(roomtype);
		return rooms;
	}
	
	//2016-01-09 多条件查询房间
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice){
		List<Room> result=cBllFrame.QueryRoomselectcondition(village, indata, outdata, minprice, maxprice);
		return result;
	}
	
	// ------------------用户操作--------------------
	/**
	 * 序号：User:0 功能：新建用户 参数:User user 返回值：boolean
	 */
	public boolean CreateUser(User user) {
		boolean result = cBllFrame.CreateUser(user);
		return result;
	}

	/**
	 * 序号：User:7 功能：删除用户 参数:User user 返回值：boolean
	 */
	public boolean DeleteUser(int userId) {
		if (cBllFrame.DeleteUser(userId)) {
			return true;
		}
		return false;
	}

	/**
	 * 序号:User:24 功能：锁定/激活用户 输入：int userId、int userState 返回值：boolean
	 */
	public boolean LockCheckUser(int userId, int userState) {
		if (cBllFrame.LockCheckUser(userId, userState)) {
			return true;
		}
		return false;
	}

	/**
	 * 序号：User:8 功能：查询所有用户信息 参数:Null 返回值：List<User>
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
	 * 序号：User:10 功能：查询单个用户信息 参数:int userId 返回值：User
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

	// 通过用户id查找除用户密码之外的所有信息
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid) {
		List<HashMap<String, Object>> result = cBllFrame
				.QueryUserExceptPasswordById(userid);
		return result;
	}

	/**
	 * 序号：User:23 功能：重置用户密码 参数:User user 返回值：boolean
	 */
	public boolean ResetUserPassword(int userId, int password) {
		if (cBllFrame.ResetUserPassword(userId, password)) {
			return true;
		}
		return false;
	}

	/**
	 * <<<<<<< .mine 序号：User:12 功能:修改用户信息 参数:int userId等,User user 返回值：boolean
	 * ======= 序号：User:12 功能:修改用户信息 参数:int userId,User user 返回值：boolean >>>>>>>
	 * .r374
	 */

	// 修改部分
	public boolean UpdateUserPart(int userId, String userName, String userSex,
			String userBoth, String userPhone, String userEmail,
			String userIdNumber, String userMessage) {
		boolean result = cBllFrame.UpdateUserPart(userId, userName, userSex,
				userBoth, userPhone, userEmail, userIdNumber, userMessage);
		return result;
	}

	// 修改全部
	public boolean UpdateUser(int userId, User user) {
		boolean result = cBllFrame.UpdateUser(userId, user);
		return result;
	}

	// 更改用户头像
	public boolean ChangeUserPic(int userId, String userPicture) {
		boolean result = cBllFrame.ChangeUserPic(userId, userPicture);
		return result;
	}

	/**
	 * 序号：User:1 功能：用户邮箱登录 参数:int userId, String useremail, String password
	 * 返回值：boolean
	 */
	// 使用邮箱登录（前提条件，邮箱不可重复）
	public int UserLoginEmail(String useremail, String userpassword) {
		int result = cBllFrame.UserLoginEmail(useremail, userpassword);
		return result;
	}

	/**
	 * 序号：User:1 功能：用户手机号登录 参数:int userId, String userphone, String password
	 * 返回值：boolean
	 */
	// 使用电话号码登录（前提条件，电话号码不可重复相等）
	public int UserLoginPhon(String userphon, String userpassword) {
		int result = cBllFrame.UserLoginPhon(userphon, userpassword);
		return result;
	}

	// /**
	// * 序号：User:13
	// * 功能：用户充值
	// * 参数:RechargeRecord rechargeRecord
	// * 返回值：boolean
	// */
	// public boolean UserRecharge(RechargeRecord rechargeRecord) {
	// if(cBllFrame.UserRecharge(rechargeRecord)){
	// return true;
	// }
	// return false;
	// }
	// /**
	// * 序号：User:14
	// * 功能：查询充值记录
	// * 参数:int UserId
	// * 返回值：List<RechargeRecord>
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
	// * 序号：User:17
	// * 功能：用户消费
	// * 参数:ConsumptionRecord consumptionRecord
	// * 返回值：boolean
	// */
	// public boolean UserConsumption(ConsumptionRecord consumptionRecord) {
	// if(cBllFrame.UserConsumption(consumptionRecord)){
	// return true;
	// }
	// return false;
	// }
	// /**
	// * 序号：User:18
	// * 功能：查询消费记录
	// * 参数:int UserId
	// * 返回值：List<ConsumptionRecord>
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
	 * 序号：User:19 功能：查看该页的客户 参数:int page 返回值：List<User>
	 */
	public List<User> GetUserByPage(int page) {
		List<User> findResult = cBllFrame.GetUserByPage(page);
		return findResult;
	}

	/**
	 * 序号：User:20 功能：查看客户数量 参数: 返回值：int
	 */
	public int getUserNumber() {
		int findResult = cBllFrame.getUserNumber();
		return findResult;
	}

	// //通过页数查找充值记录
	// public List<RechargeRecord> getRecordRecordByPage(int page) {
	// List<RechargeRecord> findResult=cBllFrame.getRecordRecordByPage(page);
	//		
	// return findResult;
	// }
	// //查看充值记录个数
	// public int getRechargeRecordNumber() {
	// int count = cBllFrame.getRechargeRecordNumber();
	//		
	// return count;
	// }
	//	
	// //通过页数查找消费记录
	// public List<ConsumptionRecord> getConsumptionRecordPage(int page) {
	// List<ConsumptionRecord>
	// findResult=cBllFrame.getConsumptionRecordPage(page);
	//		
	// return findResult;
	// }
	//	
	// //查看消费记录数
	// public int getConsumptionRecordNumber() {
	// int count =cBllFrame.getConsumptionRecordNumber();
	// return count;
	// }
	//	
	// 通过电话号码和密码查询出密码以外的所有用户的信息
	public List<HashMap<String, Object>> QueryPhonuserother(String userphon,
			String userpassword) {
		List<HashMap<String, Object>> result = cBllFrame.QueryPhonuserother(
				userphon, userpassword);
		return result;
	}

	// --------------------订单---------------------

	/**
	 * 序号：OrderTable:0 功能：新建订单 参数：Order 返回值：boolean
	 */
	public boolean CreateOrder(OrderTable order) {
		boolean result = cBllFrame.CreateOrder(order);
		return result;
	}

	/**
	 * 序号：OrderTable：1 功能：删除订单 参数：int OrderId 返回值：boolean
	 */
	public boolean DeleteOrder(int orderId) {
		boolean result = cBllFrame.DeleteOrder(orderId);
		return result;
	}

	// 改变订单状态
	public boolean ChangeOrderState(int orderId, int orderState) {
		boolean resulte = cBllFrame.ChangeOrderState(orderId, orderState);
		return resulte;
	}

	// 通过订单号查找订单
	public OrderTable QueryOrderById(int orderId) {
		OrderTable order = cBllFrame.QueryOrderById(orderId);
		return order;
	}

	// 通过用户名查找订单信息
	public List<OrderTable> QueryOrderByUsername(int userId) {
		List<OrderTable> order = cBllFrame.QueryOrderByUsername(userId);
		return order;
	}

	// 通过入住的时间查找订单信息
	public List<OrderTable> QueryOrderByCheckinTime(int OrderCheckinTime) {
		List<OrderTable> order = cBllFrame
				.QueryOrderByCheckinTime(OrderCheckinTime);
		return order;
	}

	// 通过房间查找订单信息
	public List<OrderTable> QueryOrderByRoom(int RoomId) {
		List<OrderTable> order = cBllFrame.QueryOrderByRoom(RoomId);
		return order;
	}

	// 修改订单
	public boolean UpdateOrder(OrderTable order) {
		boolean result = cBllFrame.UpdateOrder(order);
		return result;
	}

	// 用户续房,改变订单状态为5和入住天数要加上续房的天数
	public boolean UserContinuedRoom(int orderId, int increaseDay,
			String OrderCheckOutTime, int OrderMoney) {
		boolean result = cBllFrame.UserContinuedRoom(orderId, increaseDay,
				OrderCheckOutTime, OrderMoney);
		return result;
	}

	// 通过页数查订单
	public List<OrderTable> queryOrderTablesByPage(int page) {
		List<OrderTable> findResult = cBllFrame.queryOrderTablesByPage(page);
		return findResult;
	}

	// 查看订单数
	public int getOrderNumber() {
		int count = cBllFrame.getOrderNumber();
		return count;
	}

	// -------------------清洁员评论用户-----------------------
	public List<UserCommit> QueryAllCommit() {
		List<UserCommit> userCommits = null;
		try {
			userCommits = cBllFrame.QueryAllCommit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCommits;
	}

	// --------------------用Id查询用户-------------------------
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

	// -------------------清洁员对自己清洁记录和清洁安排的操作-----------------------

	// 保洁员查看自己清洁历史
	public List<CleaningRecord> QueryCleaningRecordUser(Cleaner cc) {
		List<CleaningRecord> cleaningRecords = new ArrayList<CleaningRecord>();

		try {
			cleaningRecords = QueryCleaningRecordUser(cc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleaningRecords;
	}

	// 保洁员查看自己清洁安排
	public List<CleanerWorkArrange> QueryCleanerWorkArrangeUser(Cleaner cc) {
		List<CleanerWorkArrange> cleanerWorkArranges = new ArrayList<CleanerWorkArrange>();

		try {
			cleanerWorkArranges = cBllFrame.QueryCleanerWorkArrangeUser(cc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleanerWorkArranges;
	}

	// -------------------管理员对所有清洁员清洁记录和清洁安排的操作-----------------------

	// 系统查看所有保洁员清洁历史
	public List<CleaningRecord> QueryCleaningRecordSystem() {
		List<CleaningRecord> cleaningRecords = new ArrayList<CleaningRecord>();

		try {
			cleaningRecords = cBllFrame.QueryCleaningRecordSystem();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleaningRecords;
	}

	// 系统查看所有保洁员工作安排
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

	// 新增一条保洁员清洁安排记录
	public boolean AddCleanerWorkArrange(CleanerWorkArrange cwa) {
		boolean flag = cBllFrame.AddCleanerWorkArrange(cwa);
		return flag;
	}

	// 新增一条保洁员清洁历史
	public boolean AddCleaningRecord(CleaningRecord cc) {
		boolean flag = cBllFrame.AddCleaningRecord(cc);
		return flag;
	}

	// 修改工作安排记录
	public boolean ModifyCleanerWorkArrange(CleanerWorkArrange cc) {

		boolean flag = cBllFrame.ModifyCleanerWorkArrange(cc);

		return flag;
	}

	// 序号：cleaner：1
	// 清洁员工注册参数Cleanr cleaner,s
	// 返回值boolean
	public boolean CleanerRegister(Cleaner cleaner) {
		boolean bcleregister = cBllFrame.CleanerRegister(cleaner);
		return bcleregister;
	}

	// 序号：cleaner：2
	// id查询清洁员，
	// 参数int CleanerId
	// 返回值：cleaner
	public List<Cleaner> QueryAllCleaner() {
		List<Cleaner> cleaners = new ArrayList<Cleaner>();
		cleaners = cBllFrame.QueryAllCleaner();
		return cleaners;
	}

	// 序号：cleaner：3
	// 查询清洁员全部清洁员名单，
	// 返回值：cleaners
	public Cleaner QuerySingelCleaner(int CleanerId) {
		Cleaner cleaner = cBllFrame.QuerySingelCleaner(CleanerId);
		return cleaner;
	}

	// 通过页数查找清洁工
	public List<Cleaner> getCleanerByPage(int page) {
		List<Cleaner> findResult = cBllFrame.getCleanerByPage(page);
		return findResult;
	}

	// 查看清洁工数量
	public int getCleannerNumber() {
		int count = cBllFrame.getCleannerNumber();
		return count;
	}

	// 查询管理员（登录）
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

	// 按房间号查找到评论信息和用户信息
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

	// 按用户名查找订单和房间
	public List<HashMap<String, Object>> QueryOrderRommByUserId(int userid) {
		List<HashMap<String, Object>> result = cBllFrame
				.QueryOrderRommByUserId(userid);
		return result;
	}

	// ---------1.新建房间评价---------
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

	// 通过页数查找房间评价
	public List<RoomCommit> getRoomCommintByPage(int page) {
		List<RoomCommit> findResult = cBllFrame.getRoomCommintByPage(page);
		return findResult;
	}

	// 查看房间评价数
	public int getRoomCommunitNumber() {
		int count = cBllFrame.getRoomCommunitNumber();
		return count;
	}

	// 通过页数查找清洁记录
	public List<CleaningRecord> getCleanRecordPage(int page) {
		List<CleaningRecord> findResult = cBllFrame.getCleanRecordPage(page);

		return findResult;
	}

	// 查看清洁记录数
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
	 * ---------------------交易记录-------------------------
	 */

	// 新建交易
	public boolean CreateTransaction(Transaction transaction) {
		boolean result = cBllFrame.CreateTransaction(transaction);
		return result;
	}

	// 查询交易
	public List<Transaction> QueryTransaction() {
		List<Transaction> result = cBllFrame.QueryTransaction();
		return result;
	}

	//通过用户id查询交易记录
	public List<Transaction> Querybyuserid(int userid) {
		List<Transaction> result=cBllFrame.Querybyuserid(userid);
		return result;
	}

	public Room GetARoomById(int roomid) {
		Room room = cBllFrame.GetARoomById(roomid);

		return room;
	}
}
