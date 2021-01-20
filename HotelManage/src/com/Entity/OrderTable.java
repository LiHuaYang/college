package com.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderTable {
	private	int	OrderId	;//	订单号
	private	int	OrderStayinDay	;//	入住天数
	private	int	OrderStayinPeopleNumber	;//	入住人数
	private	String	OrderCheckinTime	;//	入住时间
	private	String	OrderTime	;//	下单时间
	private	String	OrderCheckoutTime	;//	退房时间
	private	int	OrderMoney	;//	付款金额
	private	int	OrderState	;//	订单状态
	private	int	UserId	;//	客户号
	private	int	RoomId	;//	房间号
	private String OrderUsername;  //住客姓名
	private String OrderUserphon; //住客电话
	private String OrderUserIDnumber; //住客身份证号

	
	public OrderTable(){};
	// public OrderTable(,OrderCheckoutTime, money,state,user_id,room_id);
	public OrderTable(int OrderStayinDay,int	OrderStayinPeopleNumber	,String	OrderCheckinTime, String OrderCheckOuttime, int OrderState, int OrderMoney, int	UserId,	int	RoomId){
		this.OrderStayinDay=OrderStayinDay;
		this.OrderStayinPeopleNumber=OrderStayinPeopleNumber;
		this.OrderCheckinTime=OrderCheckinTime;
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.OrderTime=s.format( new Date());
		this.OrderMoney=OrderMoney;

		this.OrderState=OrderState;
		this.UserId=UserId;
		this.RoomId=RoomId;
	}

	public OrderTable(String OrderUserphon,int OrderStayinDay,int	OrderStayinPeopleNumber	,String	OrderCheckinTime,int OrderMoney,int	OrderState,int	UserId,	int	RoomId){
		this.OrderStayinDay=OrderStayinDay;
		this.OrderStayinPeopleNumber=OrderStayinPeopleNumber;
		this.OrderCheckinTime=OrderCheckinTime;
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.OrderTime=s.format( new Date());
		this.OrderMoney=OrderMoney;

		this.OrderState=OrderState;
		this.UserId=UserId;
		this.RoomId=RoomId;
	}
	
	public OrderTable(String OrderUserIDnumber,String OrderUserphon,String OrderUsername,int OrderStayinDay,int	OrderStayinPeopleNumber	,String	OrderCheckinTime,String OrderCheckoutTime,int  OrderMoney,int	OrderState,int	UserId,	int	RoomId){
		this.OrderStayinDay=OrderStayinDay;
		this.OrderStayinPeopleNumber=OrderStayinPeopleNumber;
		this.OrderCheckinTime=OrderCheckinTime;
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.OrderTime=s.format( new Date());
		
		this.OrderCheckoutTime = OrderCheckoutTime;
		this.OrderMoney=OrderMoney;
		this.OrderState=OrderState;
		this.UserId=UserId;
		this.RoomId=RoomId;
		this.OrderUsername=OrderUsername;
		this.OrderUserphon=OrderUserphon;
		this.OrderUserIDnumber=OrderUserIDnumber;
	}
	
	
	public OrderTable(int orderId, int orderStayinDay,
			int orderStayinPeopleNumber, String orderCheckinTime,
			String orderTime, String orderCheckoutTime, int orderMoney,
			int orderState, int userId, int roomId, String orderUsername,
			String orderUserphon, String orderUserIDnumber) {
		super();
		OrderId = orderId;
		OrderStayinDay = orderStayinDay;
		OrderStayinPeopleNumber = orderStayinPeopleNumber;
		OrderCheckinTime = orderCheckinTime;
		OrderTime = orderTime;
		OrderCheckoutTime = orderCheckoutTime;
		OrderMoney = orderMoney;
		OrderState = orderState;
		UserId = userId;
		RoomId = roomId;
		OrderUsername = orderUsername;
		OrderUserphon = orderUserphon;
		OrderUserIDnumber = orderUserIDnumber;
	}
	public HashMap<String, Object> toHashMap(){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("OrderId", this.OrderId);
		map.put("OrderStayinDay", this.OrderStayinDay);
		map.put("OrderStayinPeopleNumber", this.OrderStayinPeopleNumber);
		map.put("OrderCheckinTime", this.OrderCheckinTime);
		map.put("OrderTime", this.OrderTime);
		map.put("OrderCheckoutTime", this.OrderCheckoutTime);
		map.put("OrderMoney", this.OrderMoney);
		map.put("OrderState", this.OrderState);
		map.put("UserId", this.UserId);
		map.put("RoomId", this.RoomId);
		map.put("OrderUsername", this.OrderUsername);
		return map;
	}

	
	@Id
	@GeneratedValue
	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public int getOrderStayinDay() {
		return OrderStayinDay;
	}

	public void setOrderStayinDay(int orderStayinDay) {
		OrderStayinDay = orderStayinDay;
	}

	public int getOrderStayinPeopleNumber() {
		return OrderStayinPeopleNumber;
	}

	public void setOrderStayinPeopleNumber(int orderStayinPeopleNumber) {
		OrderStayinPeopleNumber = orderStayinPeopleNumber;
	}

	public String getOrderCheckinTime() {
		return OrderCheckinTime;
	}

	public void setOrderCheckinTime(String orderCheckinTime) {
		OrderCheckinTime = orderCheckinTime;
	}

	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}

	public String getOrderCheckoutTime() {
		return OrderCheckoutTime;
	}

	public void setOrderCheckoutTime(String orderCheckoutTime) {
		OrderCheckoutTime = orderCheckoutTime;
	}

	public int getOrderMoney() {
		return OrderMoney;
	}

	public void setOrderMoney(int orderMoney) {
		OrderMoney = orderMoney;
	}

	public int getOrderState() {
		return OrderState;
	}

	public void setOrderState(int orderState) {
		OrderState = orderState;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getRoomId() {
		return RoomId;
	}

	public void setRoomId(int roomId) {
		RoomId = roomId;
	}
	

	public String getOrderUsername() {
		return OrderUsername;
	}

	public void setOrderUsername(String orderUsername) {
		OrderUsername = orderUsername;
	}

	public String getOrderUserphon() {
		return OrderUserphon;
	}

	public void setOrderUserphon(String orderUserphon) {
		OrderUserphon = orderUserphon;
	}

	public String getOrderUserIDnumber() {
		return OrderUserIDnumber;
	}

	public void setOrderUserIDnumber(String orderUserIDnumber) {
		OrderUserIDnumber = orderUserIDnumber;
	}

	@Override
	public String toString() {
		return "OrderTable [OrderCheckinTime=" + OrderCheckinTime
				+ ", OrderCheckoutTime=" + OrderCheckoutTime + ", OrderId="
				+ OrderId + ", OrderMoney=" + OrderMoney + ", OrderState="
				+ OrderState + ", OrderStayinDay=" + OrderStayinDay
				+ ", OrderStayinPeopleNumber=" + OrderStayinPeopleNumber
				+ ", OrderTime=" + OrderTime + ", OrderUserIDnumber="
				+ OrderUserIDnumber + ", OrderUsername=" + OrderUsername
				+ ", OrderUserphon=" + OrderUserphon + ", RoomId=" + RoomId
				+ ", UserId=" + UserId + "]";
	}
	
	
}
