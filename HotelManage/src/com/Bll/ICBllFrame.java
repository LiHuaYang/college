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
	// ---------------------房间操作---------------------

	public List<Room> GetRoomByRoomCleaningState();

	/*
	 * 序号：Room:1 功能：创建房间 参数：Room room,RoomEquipment,Address
	 * 静态参数：RoomUsingState=1 返回值:boolean
	 */
	public boolean CreateRoom(Room room, RoomEquipment roomEquipment,
			Address address);
	/**
	 * 序号：Room:2 功能：查询房间详情 参数：int roomId 返回值:Room
	 */
	public HashMap<String, Object> QueryRoomDetail(int roomid);

	/**
	 * 序号：Room:3 功能：通过地区查询房间 参数：Address address 返回值:Room
	 */
	public List<Room> QueryRoomByArea(Address address);

	/**
	 * 序号：Room:3 功能：通过地区id查询房间 参数：Address address 返回值:Room
	 */
	public List<Room> QueryRoomByAreaid(int addressId);

	/**
	 * 序号：Room:4 功能：查询单条订单信息+所对应房间信息+房间设备信息 参数：int orderId 返回值:HashMap
	 */
	public HashMap<String, Object> QueryOrder(int orderId);

	/**
	 * 序号：Room:5 功能：按房间状态查询所有房间 参数：int RoomUsingState 返回值:List<Room>
	 */
	public List<Room> QueryRoomByUsingState(int roomUsingState);

	/**
	 * 序号：Room：7 功能：修改房间房间属性 参数:Room room,RoomEquipment,Address 返回值：boolean
	 */
	public boolean UptateRoom(Room room, RoomEquipment roomEquipment,
			Address address);

	/**
	 * 序号：Room:8 功能：查询需要锁定的房间 参数：RoomLockState 返回值：List<Room>
	 */
	public List<Room> QueryRoomNeedLocking();

	/**
	 * 序号：Room：9 功能：激活或锁定房间 参数：RoomId、Lock/UNLOCK 返回值：boolean
	 */
	public boolean LockCheckRoom(int roomId, int CheckRoom);

	/**
	 * 序号：Room：10 功能：查找addressid 参数：String AddressProvince,String
	 * AddressCity,String AddressVillage 返回值：int addressid
	 */
	public Address QueryAddressId(String AddressProvince, String AddressCity,
			String AddressVillage);

	// TDOD: List<Room> QueryRooms(); NOT YET
	public List<Room> QueryRooms();

	public List<Room> GetRoomByAddressViilage(String address);

	/**
	 * Room:11、删除房间 功能:删除房间 参数：int RoomId 返回值：boolean
	 */
	public boolean DeleteRoom(int RoomId);

	/**
	 * Room:12、修改房间使用状态
	 * 
	 * @param roomid
	 * @param usingCheckRoom
	 * @return
	 */
	public boolean UsingCheckRoom(int roomid, int usingCheckRoom);

	public LinkedMap GetPageRoomInfo(int page);

	public int GetRoomNumber();

	// 查找所有房间
	public List<Room> QueryAllRoom();

	// 通过房间类型查找房间
	public List<Room> QueryRoomByRoomtype(int roomtype);

	// --------------14.通过地区和详细地址信息查询房间-----------
	public LinkedMap GetRoomByAddress(int addressid, String RoomDetailAddress,
			int page);

	// ---------------15.通过地区和详细地址信息查询房间数量------------
	public int GetRoomNumberByAddress(int AddressId, String RoomDetailAddress);
	
	// ---------------16.通过房间ID返回房间信息------------
	public Room GetARoomById(int roomid);
	
	//2016-01-09 多条件查询房间
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice);
	

	// ------------------------房间评价部分--------------------
	public List<RoomCommit> getAllRoomCommits();// 查询所有房间评价

	public RoomCommit getRoomCommit(int roomCommitId);// 查询单条房间评价

	// 通过页数查找房间评价
	public List<RoomCommit> getRoomCommintByPage(int page);

	// 查看房间评价数
	public int getRoomCommunitNumber();

	// ------------------------地址部分--------------------
	public HashMap QueryAllRooms();

	/**
	 * Address：1 功能：查找所有address 参数：无 返回值：List<address>
	 */
	public List<Address> QueryAllAddress();

	// ----------------------与用户有关操作------------------
	// 用户注册
	public boolean CreateUser(User user);

	// 查询客户的所有信息
	public List<User> QueryAllUser();

	// 查询单个用户信息
	public User QuerySingelUser(int userId);

	// 使用邮箱登录（前提条件，邮箱不可重复）
	public int UserLoginEmail(String useremail, String userpassword);

	// 使用电话号码登录（前提条件，电话号码不可重复相等）
	public int UserLoginPhon(String userphon, String userpassword);

	// 删除此用户
	public boolean DeleteUser(int userId);

	// 激活或者锁定用户
	public boolean LockCheckUser(int userId, int userState);

	// 重置用户密码
	public boolean ResetUserPassword(int userId, int password);

	// 修改用户信息，通过用户id查找用户信息并进行修改
	public boolean UpdateUser(int userId, User user);
	
	//修改部分用户信息
	public boolean UpdateUserPart(int userId,String userName,String userSex,String userBoth,String userPhone,String userEmail,String userIdNumber,String userMessage);

	// 更改用户头像
	public boolean ChangeUserPic(int userId, String userPicture);

	// 查看该页的客户
	public List<User> GetUserByPage(int page);

	// 查看客户数量
	public int getUserNumber();

	// 名字模糊搜索User
	public List<User> getUserByName(String UserName, int page);

	// 名字模糊搜索User数
	public int getUserNumberByName(String UserName);
	
	//通过电话号码和密码查询出密码以外的所有用户的信息
	public List<HashMap<String, Object>> QueryPhonuserother (String userphon,String userpassword);
	
	//通过用户id查找除用户密码之外的所有信息
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid);
	
	

	// //-----------------------与用户充值有关操作------------------
	//	
	// //用户充值
	// public boolean UserRecharge(RechargeRecord rechargeRecord);
	//	
	// //查询充值记录
	// public List<RechargeRecord> QueryRechargeRecord(int UserId);
	//	
	// //用户消费
	// public boolean UserConsumption(ConsumptionRecord consumptionRecord);
	//	
	// //查询消费记录
	// public List<ConsumptionRecord> QueryUserConsumpionRecord(int UserId);
	//	
	// //查询所有消费记录
	// public List<ConsumptionRecord> getAllUserConsumpionRecords();
	//	
	// //查询所有充值记录
	// public List<RechargeRecord> getAllRechargeRecords();
	// //通过页数查找充值记录
	// public List<RechargeRecord> getRecordRecordByPage(int page);
	// //查看充值记录个数
	// public int getRechargeRecordNumber();
	//	
	// //通过页数查找消费记录
	// public List<ConsumptionRecord> getConsumptionRecordPage(int page);
	//	
	// //查看消费记录数
	// public int getConsumptionRecordNumber();
	// ---------------------------订单--------------------------

	// 新建订单
	public boolean CreateOrder(OrderTable order);

	// 删除订单
	public boolean DeleteOrder(int orderId);

	// 改变订单状态
	public boolean ChangeOrderState(int orderId, int orderState);

	// 通过订单号查找订单
	public OrderTable QueryOrderById(int orderId);

	// 通过用户名查找订单信息
	public List<OrderTable> QueryOrderByUsername(int userId);

	// 通过入住的时间查找订单信息
	public List<OrderTable> QueryOrderByCheckinTime(int OrderCheckinTime);

	// 通过房间查找订单信息
	public List<OrderTable> QueryOrderByRoom(int RoomId);

	// 修改订单
	public boolean UpdateOrder(OrderTable order);

	// 用户续房,改变订单状态为5和入住天数要加上续房的天数
	public boolean UserContinuedRoom(int orderId, int increaseDay,
			String OrderCheckOutTime, int OrderMoney);

	// 查询所有订单
	public List<OrderTable> QueryAllOrders();

	// 按用户号查找订单和房间
	public List<HashMap<String, Object>> QueryOrderRommByUserId(int userid);

	// 通过页数查订单
	public List<OrderTable> queryOrderTablesByPage(int page);

	// 查看订单数
	public int getOrderNumber();

	// 查看符合条件（addressid/detailaddress/ page）的订单数
	public int getOrderNumberByAddress(String AddressProvince,
			String AddressCity, String AddressVillage, String DetatilAddress);

	// 查看符合条件的订单
	public List<OrderTable> getOrdersByAddress(String AddressProvince,
			String AddressCity, String AddressVillage, String DetatilAddress,
			int page);

	// -----------------------清洁员----------------------
	// 序号：cleaner：
	// 清洁员工注册参数Cleanr cleaner,
	// 返回值boolean
	public boolean CleanerRegister(Cleaner cleaner);

	// 序号：cleaner：2
	// id查询清洁员，
	// 参数int CleanerId
	// 返回值：cleaner
	public Cleaner QuerySingelCleaner(int CleanerId);

	// 序号：cleaner：3
	// 查询清洁员全部清洁员名单，
	// 返回值：cleaners
	public List<Cleaner> QueryAllCleaner();

	// 序号：cleaner：4
	// 修改保洁员状态
	// 返回值：boolean
	public boolean UpdateCleanerState(int CleanerId, int CleanerState);

	// 通过页数查找清洁工
	public List<Cleaner> getCleanerByPage(int page);

	// 查看清洁工数量
	public int getCleannerNumber();

	// 修改清洁员信息
	public boolean changeCleaner(Cleaner cleaner);

	// -------------------清洁员评论用户-----------------------
	/**
	 * 序号：usercommit：1 客户增加评价参数 参数：UserCommit usercommit 返回值boolean
	 */
	public boolean UserCommentRoom(UserCommit usercommit);

	/**
	 * 序号：usercommit：2 id查询某客户全部评价 参数int userid 返回值：List<UserCommit>
	 */
	public List<UserCommit> QueryUserCommits(int userid);

	/**
	 * 序号：usercommit：3 查询全部评价 参数：NULL 返回值：List<UserCommit>
	 */
	public List<UserCommit> QueryAllCommit();

	public List<UserCommit> QueryUserCommintByPage(int page);

	public int GetUserCommintNumber();

	/**
	 * 序号：usercommit：5 用Id查询单条用户评价 参数：UserCommitId 返回值：UserCommit
	 */
	public UserCommit GetSingelUserCommit(int UserCommitId);

	// -------------------清洁员对自己清洁记录和清洁安排的操作-----------------------

	// 保洁员查看自己清洁历史
	public List<CleaningRecord> QueryCleaningRecordUser(Cleaner cc);

	// 保洁员查看自己清洁安排
	public List<CleanerWorkArrange> QueryCleanerWorkArrangeUser(Cleaner cc);

	// -------------------管理员对所有清洁员清洁记录和清洁安排的操作-----------------------

	// 系统查看所有保洁员清洁历史
	public List<CleaningRecord> QueryCleaningRecordSystem();

	// 系统查看所有保洁员工作安排
	public List<CleanerWorkArrange> QueryCleanerWorkArrangeSystem();

	// 新增一条保洁员清洁历史
	public boolean AddCleaningRecord(CleaningRecord cc);

	// 新增一条保洁员清洁安排记录
	public boolean AddCleanerWorkArrange(CleanerWorkArrange cc);

	// 修改工作安排记录
	public boolean ModifyCleanerWorkArrange(CleanerWorkArrange cc);

	// 查看工作安排总数目
	public int getCleanerWorkNumber();

	// 通过页码查找工作安排
	public List<CleanerWorkArrange> getCleanerWorkBypage(int page);

	// 查询所有地区
	public List<Address> GetAllAddress();

	public Manager QueryManagerByMessage(String managerAccount,
			String managerPassword);

	// 按房间号查找到评论信息和用户信息
	public List<HashMap<String, Object>> QueryRoomCommitUser(int roomId);

	// ---------1.新建房间评价---------
	public boolean CreateRoomCommit(RoomCommit roomCommit);

	// 通过页数查找清洁记录
	public List<CleaningRecord> getCleanRecordPage(int page);

	// 查看清洁记录数
	public int getCleanRecordNumber();

	// 删除保洁员的相关信息
	// public boolean DeleteCleaner();

	/**
	 * ---------------------用户评论房间-------------------------
	 */

	// 新建交易
	public boolean CreateTransaction(Transaction transaction);

	// 查询交易
	public List<Transaction> QueryTransaction();

	// 通过用户id查询交易记录
	public List<Transaction> Querybyuserid(int userid);
}
