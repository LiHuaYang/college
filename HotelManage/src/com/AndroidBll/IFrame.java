package com.AndroidBll;

import java.util.HashMap;
import java.util.List;
import com.Entity.Cleaner;
import com.Entity.CleaningRecord;
import com.Entity.OrderTable;
import com.Entity.Room;
import com.Entity.RoomCommit;
import com.Entity.RoomEquipment;
import com.Entity.User;
import com.Entity.UserCommit;

public interface IFrame {
	
	// 通过roomid来返回Room详情
	public Room GetRoomDetail(int room_id);
	
	// 创建新的房间
	public boolean CreateOrder(OrderTable oo);
	
	// 通过OrderId来返回Order
	public List<HashMap<String, Object>> GetOrderAndRoomByOrderId(int id);
	
	// 保洁员登陆
	public List<Cleaner> CleanerLoginByPhone(String phone, String pwd);
	
	// 通过房间的使用状态来查询房间，返回房间列表(用于保洁员显示列表)
	public List<Room> GetRoomByRoomUsingState(int state);
	
	// 通过村庄来查找房间
	public List<Room> GetRoomByAddressViilage(String address);
	
	// 用户取消订单
	public boolean CancelOrder(int orderid, int userid);
	
	// 用户结算订单
	public boolean FinishOrder(int orderid, int userid, int roomid);
	
	// 用户续订房间
	public boolean RenewOrder(int orderid, int daycount, int roomprice);
	
	// 保洁员获取自己所负责的房间（待打扫）
	public List<Room> PCleanerGetRoom(int cleanerid);
	
	// 保洁员评价所打扫的房间
	public boolean CleanerCommitRoom(RoomCommit roomcc);
	
	// 保洁员开始打扫房间--接受任务（同时将在CleaningRecord增加一条记录）
	public boolean CleanerCleaningStart(CleaningRecord cr);
	
	// 保洁员查看自己的打扫历史
	public List<CleaningRecord> CleanerQueryCleaningHistroy(int cleanerid);
	
	// 通过设备iD，查找设备列表
	public RoomEquipment GetRoomEquipmentsList(int id);
	
	public OrderTable GetOrderByOrderId(int orderid);
	
	// 保洁员评价用户
	public boolean CleanerCommitUser(UserCommit uc);
	
	// 用户查看房间评价
	public List<HashMap<String, Object>> GetRoomCommitDetail(int roomid);
	
	// 用户查看地区房间（剩余的）
	public List<HashMap<String, Object>> GetRoomList(String village);
	
	// 用户获取符合条件的房间
	public List<Room> GetEligibleRoom(int roomtype, String village);
	
	//客户评价
	public boolean CreateRoomCommit(RoomCommit roomCommit);
	
	//用户注册
	public boolean CreateUser(User user);
}
