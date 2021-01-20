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
	// --------------------房间相关-------------------

	/**
	 * 序号：Room:1 功能：创建房间 参数：Room room,RoomEquipment,Address
	 * 静态参数：RoomUsingState=1 返回值:boolean
	 */
	public boolean CreateRoom(Room room, RoomEquipment roomEquipment,
			int AddressId) {
		// 创建房间...参数传入：Room对象 ，同时将房间RoomUsingState设置初始值为2，RoomLockState设置初始值为0
		room.setRoomUsingState(2);
		room.setRoomLockState(0);
		room.setAddressId(AddressId);
		boolean roomCreate = iDaoFrame.CreateRoom(room);
		// 创建房间设备
		boolean roomEqment = iDaoFrame.CreateRoomEquipment(roomEquipment);
		return roomCreate && roomEqment;
	}

	/**
	 * 序号：Room:2 功能：查询房间详情 参数：int roomId 返回值:Room
	 */
	public HashMap<String, Object> QueryRoomDetail(int roomid) {
		// 通过Id查找房间
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
	 * 序号：Room:3 功能：通过地区查询房间 参数：Address address 返回值:Room
	 */
	public List<Room> QueryRoomByArea(Address address) {
		// 通过Addressid查找房间
		List<Room> rooms = iDaoFrame.QueryRoomByArea(address.getAddressId());
		return rooms;
	}

	/**
	 * 序号：Room:3 功能：通过地区id查询房间 参数：Address address 返回值:Room
	 */
	public List<Room> QueryRoomByAreaid(int addressId) {
		// 通过Addressid查找房间
		List<Room> rooms = new ArrayList<Room>();
		rooms = iDaoFrame.QueryRoomByArea(addressId);
		return rooms;
	}

	/**
	 * 序号：Room:4 功能：查询单条订单信息+所对应房间信息+房间设备信息 参数：int orderId 返回值:HashMap
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
	 * 序号：Room:5 功能：按房间状态查询所有房间 参数：int RoomUsingState 返回值:List<Room>
	 */
	public List<Room> QueryRoomByUsingState(int roomUsingState) {
		List<Room> rooms = new ArrayList<Room>();
		rooms = iDaoFrame.QueryRoomByUsingState(roomUsingState);
		@SuppressWarnings("unused")
		Date date = new Date();
		return rooms;
	}

	/**
	 * 序号：Room：6 功能：按入住时间查询房间//未实现 参数:string 返回值：List<Room>
	 */

	/**
	 * 序号：Room：7 功能：修改房间房间属性 参数:Room room,RoomE 返回值：boolean
	 */
	boolean UptateRoom(Room room, RoomEquipment roomEquipment, Address address) {
		boolean roomup = iDaoFrame.UpdateRoom(room);
		boolean roomequp = iDaoFrame.UpdateRoomEquipment(roomEquipment);
		boolean addressup = iDaoFrame.UpdateAddress(address);
		return roomup && roomequp && addressup;
	}

	/**
	 * 序号：Room:8 功能：查询需要锁定的房间 参数：RoomLockState 返回值：List<Room>
	 */
	public List<Room> QueryRoomNeedLocking() {
		List<Room> roomsget = iDaoFrame.QueryRoomByLockingState(2);
		return roomsget;
	}

	/**
	 * 序号：Room：9 功能：激活或锁定房间 参数：RoomId、Lock/UNLOCK 返回值：boolean
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
	 * 序号：Room：10 功能：查询所有房间 参数：无 返回值：List<Room>
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
	 * Room:11、删除房间 功能:删除房间 参数：int RoomId 返回值：boolean
	 */
	public boolean DeleteRoom(int RoomId) {
		boolean isdel = iDaoFrame.DeleteRoom(RoomId);
		return isdel;
	}

	// 12修改房间使用状态
	public boolean UsingCheckRoom(int roomid, int usingCheckRoom) {
		boolean bischeck = iDaoFrame.UsingCheckRoom(roomid, usingCheckRoom);
		return bischeck;
	}

	/**
	 * Address：1 功能：查找所有address 参数：无 返回值：List<address>
	 */
	public List<Address> QueryAllAddress() {
		List<Address> addresses = iDaoFrame.QueryAllAddress();
		return addresses;
	}

	/**
	 * 序号：Address：2 功能：查找addressid 参数：Addressprovience、、、3个 返回值：int addressid
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

	// 查找所有房间
	public List<Room> QueryAllRoom() {
		List<Room> rooms = iDaoFrame.QueryAllRoom();
		return rooms;
	}

	// 通过房间类型查找房间
	public List<Room> QueryRoomByRoomtype(int roomtype) {
		List<Room> rooms = iDaoFrame.QueryRoomByRoomtype(roomtype);
		return rooms;
	}

	// --------------14.通过地区和详细地址信息查询房间-----------
	public LinkedMap GetRoomByAddress(int addressid, String RoomDetailAddress,
			int page) {
		LinkedMap findResult = iDaoFrame.QueryRoomByAddress(addressid,
				RoomDetailAddress, page);
		return findResult;
	}

	// ---------------15.通过地区和详细地址信息查询房间数量------------
	public int GetRoomNumberByAddress(int AddressId, String RoomDetailAddress) {
		int roomnumber = iDaoFrame.GetRoomNumberByAddress(AddressId,
				RoomDetailAddress);
		return roomnumber;
	}
	
	// ---------------16.通过房间ID返回房间信息------------
	public Room GetARoomById(int roomid) {
		Room room = iDaoFrame.QueryRoomDetail(roomid);
		return room;
	}
	// -----------------------------房间评价-----------------------
	// 查询所有房间评价
	public List<RoomCommit> getAllRoomCommits() {
		List<RoomCommit> roomCommits = iDaoFrame.QueryAllRoomCommits();
		return roomCommits;
	}

	// 查询单条房间评价
	public RoomCommit getRoomCommit(int roomCommitId) {
		RoomCommit roomCommit = iDaoFrame.QuerySingelRoomCommit(roomCommitId);
		return roomCommit;
	}

	public List<Room> GetRoomByAddressViilage(String address) {
		List<Room> rooms = iDaoFrame.queryRoomByAddressViilage(address);
		return rooms;
	}

	// 通过页数查找房间评价
	public List<RoomCommit> getRoomCommintByPage(int page) {
		List<RoomCommit> findResult = iDaoFrame.getRoomCommintByPage(page);

		return findResult;
	}

	// 查看房间评价数
	public int getRoomCommunitNumber() {
		int count = iDaoFrame.getRoomCommunitNumber();
		return count;
	}
	
	
	//2016-01-09 多条件查询房间
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice){
		List<Room> result=iDaoFrame.QueryRoomselectcondition(village, indata, outdata, minprice, maxprice);
		return result;
	}

	/**
	 **************与用户有关操作**************
	 */
	// 用户注册
	public boolean CreateUser(User user) {
		boolean result = iDaoFrame.CreateUser(user);
		return result;
	}

	// 查询客户的所有信息
	public List<User> QueryAllUser() {
		List<User> result = iDaoFrame.SearchtotalUser();
		return result;
	}

	// 查询单个用户信息：QuerySingelUser
	public User QuerySingelUser(int userId) {
		User result = iDaoFrame.SearcheachUser(userId);
		return result;
	}
	
	//通过用户id查找除用户密码之外的所有信息
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid){
		List<HashMap<String, Object>> result=iDaoFrame.QueryUserExceptPasswordById(userid);
		return result;
	}

	// 使用邮箱登录（前提条件，邮箱不可重复）
	// public List<User> UserLoginEmail(String useremail,String password){
	// List<User> result=null;
	// List <User> emailLogin=iDaoFrame.Queryemailuser(useremail);
	// //判断前端传来的邮箱和密码是否正确
	// for(int i=0;i<emailLogin.size();i++){
	// //对password进行比较
	// if(emailLogin.get(i).getUserPassword().equals(password)){
	// System.out.print("登录成功！");
	// result=emailLogin;
	// }
	// else{
	// System.out.print("密码或者邮箱错误哦！");
	// }
	// }
	// return result;
	// }

	// 使用邮箱登录（前提条件，邮箱不可重复）
	public int UserLoginEmail(String useremail, String userpassword) {
		int result = iDaoFrame.Queryemailuser(useremail, userpassword);
		return result;
	}

	// 使用电话号码登录（前提条件，电话号码不可重复相等）
	public int UserLoginPhon(String userphon, String userpassword) {
		int result = iDaoFrame.Queryphonuser(userphon, userpassword);
		return result;
	}

	// 删除此用户
	public boolean DeleteUser(int userId) {
		int userState = -1;
		boolean result = false;
		result = iDaoFrame.changerUserState(userId, userState);
		return result;
	}

	// 激活或者锁定用户
	public boolean LockCheckUser(int userId, int userState) {
		boolean resulte = iDaoFrame.changerUserState(userId, userState);
		return resulte;
	}

	// 重置用户密码
	public boolean ResetUserPassword(int userId, int password) {
		boolean resulte = iDaoFrame.changerUserPassword(userId, password);
		return resulte;
	}

	//修改部分用户信息
	public boolean UpdateUserPart(int userId,String userName,String userSex,String userBoth,String userPhone,String userEmail,String userIdNumber,String userMessage){
		boolean result = iDaoFrame.ChangeUserPart(userId, userName, userSex, userBoth, userPhone, userEmail, userIdNumber, userMessage);
		return result;
	}
	
	// 修改用户信息，通过用户id查找用户信息并进行修改
	public boolean UpdateUser(int userId, User user) {
		user.setUserId(userId);
		boolean result = iDaoFrame.DisappearUser(user);
		return result;
	}

	// 更改用户头像
	public boolean ChangeUserPic(int userId, String userPicture) {
		boolean result = iDaoFrame.ChangeUserPic(userId, userPicture);
		return result;

	}

	// 查看该页的客户
	public List<User> GetUserByPage(int page) {
		List<User> findResult = iDaoFrame.getUserByPage(page);
		return findResult;
	}

	// 查看客户数量
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

	// 通过电话号码和密码查询出密码以外的所有用户的信息
	public List<HashMap<String, Object>> QueryPhonuserother(String userphon,
			String userpassword) {
		List<HashMap<String, Object>> result = iDaoFrame.QueryPhonuserother(
				userphon, userpassword);
		return result;
	}

	// /**
	// **************与用户充值有关操作**************
	// * */
	// //用户充值
	// public boolean UserRecharge(RechargeRecord rechargeRecord){
	// boolean result=iDaoFrame.CreateRecode(rechargeRecord);
	// return result;
	// }
	//
	// //查询充值记录
	// public List<RechargeRecord> QueryRechargeRecord(int UserId){
	// List<RechargeRecord> result=iDaoFrame.SearchRecode(UserId);
	// return result;
	// }
	// //查询所有充值记录
	// public List<RechargeRecord> querRechargeRecords(){
	// List<RechargeRecord> result=iDaoFrame.queryRechargeRecords();
	// return result;
	// }
	//	
	// //通过页数查找充值记录
	// public List<RechargeRecord> getRecordRecordByPage(int page) {
	//	
	// List<RechargeRecord> findReuslt=iDaoFrame.getRecordRecordByPage(page);
	//		
	// return findReuslt;
	// }
	// //查看充值记录个数
	// public int getRechargeRecordNumber() {
	// int count = iDaoFrame.getRechargeRecordNumber();
	// return count;
	// }
	// //通过页数查找消费记录
	// public List<ConsumptionRecord> getConsumptionRecordPage(int page) {
	// List<ConsumptionRecord>
	// findResult=iDaoFrame.getConsumptionRecordPage(page);
	//		
	// return findResult;
	// }
	//	
	// //查看消费记录数
	// public int getConsumptionRecordNumber() {
	// int count =iDaoFrame.getConsumptionRecordNumber();
	// return count;
	// }
	// /**
	// **************与用户消费有关操作**************
	// * */
	//
	// //用户消费
	// public boolean UserConsumption(ConsumptionRecord consumptionRecord){
	// boolean result=iDaoFrame.CreateConsumptionRecord(consumptionRecord);
	// return result;
	// }
	//
	// //查询消费记录
	// public List<ConsumptionRecord> QueryUserConsumpionRecord(int UserId){
	// List<ConsumptionRecord> result=iDaoFrame.SearchConsumptionRecord(UserId);
	// return result;
	// }
	// //查询所有消费记录
	// public List<ConsumptionRecord> getAllUserConsumpionRecords(){
	// List<ConsumptionRecord> result=iDaoFrame.queryAllConsumptionRecords();
	// return result;
	// }

	// ----------------------订单--------------------
	/**
	 * 序号：OrderTable:0 功能：新建订单 参数：Order 返回值：boolean
	 */
	public boolean CreateOrder(OrderTable order) {
		if (iDaoFrame.CreateOrder(order)) {
			return true;
		}
		return false;
	}

	/**
	 * 序号：OrderTable：1 功能：删除订单 参数：int OrderId 返回值：boolean
	 */
	public boolean DeleteOrder(int orderId) {
		int orderState = -1;
		boolean resulte = iDaoFrame.changerUserState(orderId, orderState);
		return resulte;
	}

	// 改变订单状态
	public boolean ChangeOrderState(int orderId, int orderState) {
		boolean resulte = iDaoFrame.changerorderState(orderId, orderState);
		return resulte;
	}

	// 通过订单号查找订单
	public OrderTable QueryOrderById(int orderId) {
		OrderTable order = iDaoFrame.QueryDetailOrder(orderId);
		return order;
	}

	// 通过用户名查找订单信息
	public List<OrderTable> QueryOrderByUsername(int userId) {
		List<OrderTable> order = iDaoFrame.QueryuserOrder(userId);
		return order;
	}

	// 通过入住的时间查找订单信息
	public List<OrderTable> QueryOrderByCheckinTime(int OrderCheckinTime) {
		List<OrderTable> order = iDaoFrame.QuerytimeOrder(OrderCheckinTime);
		return order;
	}

	// 通过房间查找订单信息
	public List<OrderTable> QueryOrderByRoom(int RoomId) {
		List<OrderTable> order = iDaoFrame.QueryroomOrder(RoomId);
		return order;
	}

	// 修改订单
	public boolean UpdateOrder(OrderTable order) {
		boolean result = iDaoFrame.QueryOrder(order);
		return result;

	}

	// 用户续房,改变订单状态为5和入住天数要加上续房的天数
	public boolean UserContinuedRoom(int orderId, int increaseDay,
			String OrderCheckOutTime, int OrderMoney) {
		int OrderStayinDay;
		OrderStayinDay = iDaoFrame.QueryDetailOrder(orderId)
				.getOrderStayinDay()
				+ increaseDay;// 入住天数=原来天数+续房天数
		boolean result = iDaoFrame.changeOrderDayState(orderId, OrderStayinDay,
				OrderCheckOutTime, OrderMoney);
		return result;
	}

	// 查询所有订单
	public List<OrderTable> QueryAllOrders() {
		List<OrderTable> orders = iDaoFrame.queryOrderTables();
		return orders;
	}

	// 通过用户号查找订单和房间
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

	// 通过页数查订单
	public List<OrderTable> queryOrderTablesByPage(int page) {
		List<OrderTable> findResult = iDaoFrame.queryOrderTablesByPage(page);
		return findResult;
	}

	// 查看订单数
	public int getOrderNumber() {
		int count = iDaoFrame.getOrderNumber();
		return count;
	}

	public List<OrderTable> getOrdersByAddress(int AddressId,
			String DetatilAddress, int page) {
		List<OrderTable> orders = null;
		return null;
	}

	// 查看符合条件（addressid/detailaddress/ page）的订单数
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

	// 查看符合条件的订单
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

	// -----------------------清洁员----------------------
	// 序号：cleaner：
	// 清洁员工注册参数Cleanr cleaner,
	// 返回值boolean
	public boolean CleanerRegister(Cleaner cleaner) {
		// 注册清洁员工
		boolean cleanerCreate = iDaoFrame.CleanerRegister(cleaner);
		return cleanerCreate;
	}

	// 序号：cleaner：2
	// id查询清洁员，
	// 参数int CleanerId
	// 返回值：cleaner
	public Cleaner QuerySingelCleaner(int CleanerId) {
		// 通过Id查找清洁员
		Cleaner cleaner = iDaoFrame.QuerySingelCleaner(CleanerId);
		return cleaner;
	}

	// 序号：cleaner：3
	// 查询清洁员全部清洁员名单，
	// 返回值：cleaners
	public List<Cleaner> QueryAllCleaner() {
		// 查询全部清洁员名单
		List<Cleaner> cleaners = new ArrayList<Cleaner>();
		cleaners = iDaoFrame.QueryAllCleaner();
		return cleaners;
	}

	// 序号：cleaner：3
	// 修改保洁员状态
	// 返回值：boolean
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

	// 通过页数查找清洁工
	public List<Cleaner> getCleanerByPage(int page) {
		List<Cleaner> findResult = iDaoFrame.getCleanerByPage(page);
		return findResult;
	}

	// 查看清洁工数量
	public int getCleannerNumber() {
		int count = iDaoFrame.getCleannerNumber();
		return count;
	}

	// 更新清洁员信息
	public boolean changeCleaner(Cleaner cleaner) {
		boolean bupdate = iDaoFrame.UptateCleaner(cleaner);
		return bupdate;
	}

	// -------------------清洁员评论用户-----------------------
	/**
	 * 序号：usercommit：1 客户增加评价参数UserCommit usercommit, 参数：UserCommit usercommit
	 * 返回值boolean
	 */
	public boolean UserCommentRoom(UserCommit usercommit) {
		// 添加客户评价
		boolean usercommitroom = iDaoFrame.UserCommentRoom(usercommit);
		return usercommitroom;
	}

	/**
	 * 序号：usercommit：2 id查询某客户全部评价 参数int userid 返回值：List<UserCommit>
	 */
	public List<UserCommit> QueryUserCommits(int userid) {
		// 通过userid查找某用户全部评价
		List<UserCommit> usercommits = new ArrayList<UserCommit>();
		usercommits = iDaoFrame.QueryUserCommits(userid);
		return usercommits;
	}

	/**
	 * 序号：usercommit：3 查询全部评价 参数：NULL 返回值：List<UserCommit>
	 */
	public List<UserCommit> QueryAllCommit() {
		// 查询全部评价
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
	 * 序号：usercommit：5 用Id查询单条用户评价 参数：UserCommitId 返回值：UserCommit
	 */
	public UserCommit GetSingelUserCommit(int UserCommitId) {
		UserCommit userCommit = iDaoFrame.queryUserCommitById(UserCommitId);
		return userCommit;
	}

	// -------------------管理员对所有清洁员清洁记录和清洁安排的操作-----------------------

	/**
	 * 管理员操作：查看所有保洁员的清洁历史记录
	 * 
	 * @author ariclee @time 2015-11-13
	 */
	public List<CleaningRecord> QueryCleaningRecordSystem() {
		List<CleaningRecord> CleaningRecordBulletin = new ArrayList<CleaningRecord>();

		CleaningRecordBulletin = iDaoFrame.queryAllCleaningRecord();

		return CleaningRecordBulletin;
	}

	/**
	 * 管理员操作：查看所有保洁员的工作安排
	 */

	public List<CleanerWorkArrange> QueryCleanerWorkArrangeSystem() {
		List<CleanerWorkArrange> CleanerWorkArrangeBulletin = new ArrayList<CleanerWorkArrange>();
		CleanerWorkArrangeBulletin = iDaoFrame.queryAllCleanerWorkArrange();
		return CleanerWorkArrangeBulletin;
	}

	// 查看工作安排总数目
	public int getCleanerWorkNumber() {
		int getnum = iDaoFrame.getCleanerWorkNumber();
		return getnum;
	}

	// 通过页码查找工作安排
	public List<CleanerWorkArrange> getCleanerWorkBypage(int page) {
		List<CleanerWorkArrange> cleanerWorkArranges = iDaoFrame
				.queryPageCleanerWorkArranges(page);
		return cleanerWorkArranges;
	}

	// 通过页数查找清洁记录
	public List<CleaningRecord> getCleanRecordPage(int page) {
		List<CleaningRecord> findResult = iDaoFrame.getCleanRecordPage(page);

		return findResult;
	}

	// 查看清洁记录数
	public int getCleanRecordNumber() {
		int count = iDaoFrame.getCleannerNumber();

		return count;
	}

	// -------------------清洁员对自己清洁记录和清洁安排的操作-----------------------

	/**
	 * 保洁员手机端操作：查看自己的清洁历史记录
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
	 * 保洁员操作：查看自己的工作安排
	 */
	public List<CleanerWorkArrange> QueryCleanerWorkArrangeUser(Cleaner cc) {

		List<CleanerWorkArrange> CleanerWorkArrangeBulletin = new ArrayList<CleanerWorkArrange>();

		CleanerWorkArrangeBulletin = iDaoFrame
				.queryCleanerWorkArrangeByCleanerId(cc.getCleanerId());

		return CleanerWorkArrangeBulletin;
	}

	/**
	 * 新增一条保洁员清洁历史
	 * 
	 * @author ariclee @time 2015-11-14
	 */
	public boolean AddCleaningRecord(CleaningRecord cd) {
		boolean flag = iDaoFrame.addCleaningRecord(cd);

		return flag;
	}

	/**
	 * 新增一条保洁员清洁安排记录
	 * 
	 * @author ariclee @time 2015-11-14
	 */
	public boolean AddCleanerWorkArrange(CleanerWorkArrange cwa) {
		boolean flag = iDaoFrame.addCleanerWorkArrange(cwa);

		return flag;
	}

	/**
	 * 修改一条保洁员清洁安排记录
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
	 * ---------------------管理员-------------------------
	 */
	/**
	 * 序号：Manager:1 功能：添加管理员 参数：Manager manager 返回值：boolean
	 */
	public boolean AddManager(Manager manager) {
		boolean baddman = iDaoFrame.AddManager(manager);
		return baddman;
	}

	/**
	 * 序号：Manager:2 功能：查询管理员（帐号、密码） 参数：String ManagerAccount,String
	 * ManagerPassword 返回值：Manager
	 */
	public Manager QueryManagerByMessage(String ManagerAccount,
			String ManagerPassword) {
		Manager manager = iDaoFrame.QueryManagerByMessage(ManagerAccount,
				ManagerPassword);
		return manager;
	}

	/**
	 * 序号：Manager:3 功能：查询管理员（id） 参数：int ManagerId 返回值：Manager
	 */
	public Manager QueryManagerById(int ManagerId) {
		Manager manager = iDaoFrame.QuerManagerById(ManagerId);
		return manager;
	}

	/**
	 * 序号：Manager:4 功能：更新管理员 参数：Manager 返回值：boolean
	 */
	public boolean UpdateManager(Manager manager) {
		boolean bdel = iDaoFrame.UpdateManager(manager);
		return bdel;
	}

	/**
	 * 序号：Manager:5 功能：删除管理员 参数：Manager 返回值：boolean
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
	 * ---------------------用户评论房间-------------------------
	 */
	// 按房间号查找到评论信息和用户信息
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

	// ---------1.新建房间评价---------
	public boolean CreateRoomCommit(RoomCommit roomCommit) {
		boolean result = iDaoFrame.CreateRoomCommit(roomCommit);
		return result;
	}

	/**
	 * ---------------------用户评论房间-------------------------
	 */

	// 新建交易
	public boolean CreateTransaction(Transaction transaction) {
		boolean result = iDaoFrame.CreateTransaction(transaction);
		return result;
	}

	// 查询交易
	public List<Transaction> QueryTransaction() {
		List<Transaction> result = iDaoFrame.QueryTransaction();
		return result;
	}
	
	//通过用户id查询交易记录
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
