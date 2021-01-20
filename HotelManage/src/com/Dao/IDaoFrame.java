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
	 * ----------------------地区-------------------------
	 */
	// 新建地区
	public boolean CreateAddress(Address address);

	// 删除地区(按地区号删除)//该功能可以删除
	public boolean DeleteAddress(int addressid);

	// 查找所有地区
	public List<Address> QueryAllAddress();

	// 查询单个地区(通过AddressId查找)
	public Address QuerySingelAddress(int AddressId);

	// 修改地区
	public boolean UpdateAddress(Address address);

	// 通过3个信息找地址全部信息
	public Address queryAddress(String AddressProvince, String AddressCity,
			String AddressVillage);
	
	// 村庄的模糊地址来查询具体的地址
	public Address queryAddressByAddressVillage(String addressVillage);
	/**
	 * ----------------------房间-----------------------
	 */
	public boolean CreateRoom(Room room);// 新建房间

	public Room QueryRoomDetail(int roomid);// 查询房间信息

	public List<Room> QueryRoomByArea(int addressid);// 通过地区查找房间

	public List<Room> QueryRoomByUsingState(int usingState);// 通过房间使用状态查找房间

	public boolean UpdateRoom(Room room); // 更新房间信息

	public boolean LockCheckRoom(int roomid, int roomLockState);// 房间锁状态更新（上锁、解锁、删除）

	public List<Room> QueryRoomByLockingState(int lockState);// 通过房间锁状态查询房间

	public boolean DeleteRoom(int roomid);

	// 增加通过RoomCleaningState来筛选出待打扫房间
	public List<Room> QueryRoomByRoomCleaningState();

	public List<Room> QueryRooms();

	// 修改房间使用状态
	public boolean UsingCheckRoom(int roomid, int usingCheckRoom);

	public List<Room> queryRoomByAddressViilage(String address);

	public List<Room> GetCleanerChargeRoomByCleanerID(int cleanerid);

	public LinkedMap GetRoomInfoByPage(int page);

	public int GetRoomNumberNoDel();
	
	//2016-01-09 多条件查询房间
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice);

	// --------------14.通过地区和详细地址信息查询房间-----------
	public LinkedMap QueryRoomByAddress(int addressid,
			String RoomDetailAddress, int page);

	// ---------------15.通过地区和详细地址信息查询房间数量------------
	public int GetRoomNumberByAddress(int AddressId, String RoomDetailAddress);

	// ---------------16.用地址查询房间id（多个id放list里）信息-------------------------
	public List<Integer> queryRoomByAddressWithoutPage(int addressid,
			String RoomDetailAddress);

	// ---------------17.查询某地区剩余房间信息-------------------------
	public List<Room> GetLeftRoomInfoByAddress(String address);

	// 通过房间类型查找房间
	public List<Room> QueryRoomByRoomtype(int roomtype);
	
	//根据入住时间和退房时间来订单信息
	public List<OrderTable> queryorderbytime(String OrderCheckinTime,String OrderCheckoutTime);
	/**
	 * ---------------------房间设备----------------------
	 */
	public RoomEquipment QueryRoomEquipment(int roomEquipmentId);// 查询房间设备

	public boolean CreateRoomEquipment(RoomEquipment roomEquipment);// 新建房间设备

	public boolean UpdateRoomEquipment(RoomEquipment roomEquipment);// 更新房间设备

	/**
	 * ---------------------房间评论----------------------
	 */
	public boolean CreateRoomCommit(RoomCommit roomCommit);// 新建房间评论

	public boolean UpdateRoomCommit(RoomCommit roomCommit);// 更新房间评论

	public List<RoomCommit> QueryRoomCommitByUser(int userId);// 通过用户查找房间评论

	public List<RoomCommit> QueryRoomCommitByRoom(int roomId);// 通过房间查找房间评论

	public RoomCommit QuerySingelRoomCommit(int roomId);// 查找单条评论

	public List<UserCommit> QueryUserCommitsByRoomid(int roomid);// 通过房间Id查找房间评论

	public List<RoomCommit> QueryAllRoomCommits();// 查询所有房间评价

	// 通过页数查找房间评价
	public List<RoomCommit> getRoomCommintByPage(int page);

	// 查看房间评价数
	public int getRoomCommunitNumber();

	// 查找所有房间
	public List<Room> QueryAllRoom();

	/**
	 * ---------------------清洁员信息----------------------
	 */
	public boolean CleanerRegister(Cleaner cleaner);// 注册清洁员工

	public Cleaner QuerySingelCleaner(int CleanerId);// 查询某清洁员工信息

	public List<Cleaner> QueryAllCleaner();// 查询全部清洁员工

	// 修改保洁员状态
	public boolean UpdateCleanerState(int CleanerId, int CleanerState);

	// 查询保洁员信息通过手机号码
	public List<Cleaner> QueryCleanerByPhone(String phoneInfo);

	// 通过页数查找清洁工
	public List<Cleaner> getCleanerByPage(int page);

	// 查看清洁工数量
	public int getCleannerNumber();

	// 修改清洁员信息
	public boolean UptateCleaner(Cleaner cleaner);

	/**
	 * ---------------------用户评价----------------------
	 */
	public boolean UserCommentRoom(UserCommit usercommit);// 增加客户评价

	// 通过usercommitId查看单个评价
	public UserCommit queryUserCommitById(int UserCommitId);

	public List<UserCommit> QueryUserCommits(int userid);// 查询某客户的评论

	public List<UserCommit> QueryAllCommit();// 查询全部评价

	// 通过页数查找客户评论
	public List<UserCommit> QueryUserCommintByPage(int page);

	public int GetUserCommintNumber();

	/**
	 * ---------------------清洁记录-----------------------
	 */

	public boolean addCleaningRecord(CleaningRecord cr);

	public List<CleaningRecord> queryCleaningRecordByCleaningId(int cleaning_id);

	public List<CleaningRecord> queryCleaningRecordByRoomId(int room_id);

	public List<CleaningRecord> queryCleaningRecordByCleanerId(int cleaner_id);

	public boolean modifyCleaningRecord(CleaningRecord cr);

	public List<CleaningRecord> queryAllCleaningRecord();

	// 通过页数查找清洁记录
	public List<CleaningRecord> getCleanRecordPage(int page);

	// 查看清洁记录数
	public int getCleanRecordNumber();

	/**
	 * -----------------------清洁工工作安排-----------------
	 */
	public boolean addCleanerWorkArrange(CleanerWorkArrange cr);

	public List<CleanerWorkArrange> queryCleanerWorkArrangeByWorkId(int work_id);

	public List<CleanerWorkArrange> queryCleanerWorkArrangeByCleanerId(
			int cleaner_id);

	public boolean modifyCleaningCleanerWorkArrange(CleanerWorkArrange cr);

	public List<CleanerWorkArrange> queryAllCleanerWorkArrange();

	// 查看清洁工作安排表总数
	public int getCleanerWorkNumber();

	// 通过页数查找工作安排
	public List<CleanerWorkArrange> queryPageCleanerWorkArranges(int page);

	/**
	 * ---------------------------用户-----------------------
	 */
	// 新建客户
	public boolean CreateUser(User user);

	// 查询客户表的所有信息
	public List<User> SearchtotalUser();

	// 查询单个用户信息
	public User SearcheachUser(int userId);

	// 修改用户信息
	public boolean DisappearUser(User user);
	
	//修改用户部分信息
	public boolean ChangeUserPart(int userId,String userName,String userSex,String userBoth,String userPhone,String userEmail,String userIdNumber,String userMessage);
	
//	//通过邮箱查询用户信息
//	public List<User> Queryemailuser(String useremail);
	

	// //通过邮箱查询用户信息
	// public List<User> Queryemailuser(String useremail);

	// 根据id更改用户的图片
	public boolean ChangeUserPic(int userId, String userPicture);

	// 通过邮箱和密码查询用户id
	public int Queryemailuser(String useremail, String userpassword);

	// 通过电话号码和密码查询用户id
	public int Queryphonuser(String userphon, String userpassword);

	// 根据用户id修改用户状态
	public boolean changerUserState(int userId, int userState);

	// 根据用户id修改用户密码
	public boolean changerUserPassword(int userId, int password);

	// 通过页数查找客户
	public List<User> getUserByPage(int page);

	// 查看客户数
	public int getUserNumber();

	// 按名字模糊查找客户的数量
	public int queryUserNumberByName(String UserName);

	//通过用户id查找除用户密码之外的所有信息
	public List<HashMap<String, Object>> QueryUserExceptPasswordById(int userid);
/**
* ---------------------------订单------------------------	
*/
	//新建订单

	// 按客户名、页数模糊查找
	public List<User> queryUserByName(String UserName, int page);

	// 通过电话号码和密码查询出密码以外的所有用户的信息
	public List<HashMap<String, Object>> QueryPhonuserother(String userphon,
			String userpassword);

	// 新建订单
	public boolean CreateOrder(OrderTable order);

	// 编辑订单
	public boolean QueryOrder(OrderTable order);

	// 通过订单id修改订单状态
	public boolean changerorderState(int orderId, int orderState);

	// 通过订单号查找订单信息
	public OrderTable QueryDetailOrder(int orderId);

	// 通过用户名查找订单信息
	public List<OrderTable> QueryuserOrder(int userId);

	// 通过地区查找订单信息
	public List<OrderTable> QueryareaOrder(int Addressid);

	// 通过入住的时间查找订单信息
	public List<OrderTable> QuerytimeOrder(int OrderCheckinTime);

	// 通过房间查找订单信息
	public List<OrderTable> QueryroomOrder(int RoomId);

	// 修改订单状态和入住天数，退房时间，总共花的钱
	public boolean changeOrderDayState(int orderId, int orderStayinDay,
			String orderCheckoutTime, int orderMoney);

	// 通过OrderId改变房间状态
	public boolean changeOrderState(int OrederId, int OrderState);

	// 查找所有订单
	public List<OrderTable> queryOrderTables();

	// 通过页数查订单
	public List<OrderTable> queryOrderTablesByPage(int page);

	// 查看订单数
	public int getOrderNumber();

	// 用房间（多个房间）查看订单数
	public int queryOrderNumberByAddress(List<Integer> rooms);

	// 用房间（多个房间）获取多个订单信息
	public List<List<OrderTable>> queryOrderByAddress(List<Integer> rooms);

	/**
	 * ------------------------充值记录--------------------
	 */
	// //新建充值记录表
	// public boolean CreateRecode(RechargeRecord rechargeRecord);
	//	
	// //查询充值记录
	// public List<RechargeRecord> SearchRecode(int UserId);
	//	
	// //查询所有充值记录
	// public List<RechargeRecord> queryRechargeRecords();
	// //通过页数查找充值记录
	// public List<RechargeRecord> getRecordRecordByPage(int page);
	// //查看充值记录个数
	// public int getRechargeRecordNumber();
	//	

	/**
	 * ------------------------消费记录---------------------
	 */
	// //新建消费记录
	// public boolean CreateConsumptionRecord(ConsumptionRecord
	// consumptionRecord);
	//	
	// //查询消费记录
	// public List<ConsumptionRecord> SearchConsumptionRecord(int UserId);
	//	
	// //查询所有消费记录
	// public List<ConsumptionRecord> queryAllConsumptionRecords();
	//	
	// //通过页数查找消费记录
	// public List<ConsumptionRecord> getConsumptionRecordPage(int page);
	//	
	// //查看消费记录数
	// public int getConsumptionRecordNumber();

	/**
	 * -------------------------管理员------------------------
	 */
	// 增加管理员
	public boolean AddManager(Manager manager);

	// 通过帐号密码查找管理员
	public Manager QueryManagerByMessage(String ManagerAccount,
			String ManagerPassword);

	// 通过管理员id查找管理员
	public Manager QuerManagerById(int ManagerId);

	// 修改管理员信息
	public boolean UpdateManager(Manager manager);

	// 删除管理员
	public boolean DeleteManager(Manager manager);

	/**
	 * -------------------------交易记录------------------------
	 */

	// 新建交易
	public boolean CreateTransaction(Transaction transaction);

	// 查询交易
	public List<Transaction> QueryTransaction();
	
	//通过用户id查询交易记录
	public List<Transaction> Querybyuserid(int userid);
}
