package com.AndroidTool;

public class OperationCode {

	// 操作码
	public static final class Operation {

		public static final String OPERATION = "operation"; // 操作码
		public static final int LOGIN = 1; // 登录
		public static final int QUIT = 0; // 退出
		public static final String SIGN = "sign"; // 标志
		public static final String TYPE = "type"; // User类型(0.删除、1.员工、2.主管、3.经理)
		public static final String TRUE = "true"; // 真值
		public static final String FALSE = "false"; // 假值
		public static final String LIST = "list"; // 列表
		// 主管管理
		public static final int ENTER_CHARGE_EXPENSES = 2; // 主管进入报销单管理
		public static final int ENTER_CHARGE_LEAVES = 3; // 主管进入请假条管理
		public static final int SEND_CHARGE_EXPENSE_CHECK = 4; // 主管审核报销单
		public static final int SEND_CHARGE_LEAVE_CHECK = 5; // 主管审核报销单
		// 经理管理
		public static final int MANAGER_USERS = 6; // 进入用户管理
		public static final int ENTER_MANAGER_EXPENSES = 7; // 经理进入报销单管理
		public static final int ENTER_MANAGER_LEAVES = 8; // 经理进入请假条管理
		public static final int SEND_MANAGER_EXPENSE_CHECK = 9; // 经理审批报销单
		public static final int SEND_MANAGER_LEAVE_CHECK = 10; // 经理审批请假条
		// 用户
		public static final int ENTER_USER_EXPENSES = 11; // 进入用户报销单编辑界面
		public static final int ENTER_USER_LEAVES = 12; // 进入用户请假条编辑界面
		public static final int SEND_LEAVE = 13; // 提交请假条
		public static final int SEND_EXPENSE = 14; // 提交报销单
		public static final int ENTER_LIST = 15; // 进入列表
	}

	// 用户字段
	public static final class User {
		public static final String UserList = "UserList";
		public static final String UserId = "UserId";
		public static final String UserName = "UserName";
		public static final String UserPhone = "UserPhone";
		public static final String UserDepartment = "UserDepartment";
		public static final String UserType = "UserType";
		public static final String UserPassword = "UserPassword";
		public static final String UserEmail = "UserEmail";
		public static final String UserPicture = "UserPicture";
	}

	public static final class Address {
		public static final String AddressList = "AddressList";
		public static final String AddressVillage = "AddressVillage";
		// AddressProvince
		// AddressCity
		// AddressPicture
		// AddressVillage
		// AddressId
		// RoomId

	}

	public static final class Order {
		public static final String OrderList = "OrderList";
		public static final String OrderCheckinTime = "OrderCheckinTime";
		public static final String OrderCheckoutTime = "OrderCheckoutTime";

		// 订单号 OrderId int
		// 入住天数 OrderStayinDay int
		// 入住人数 OrderStayinPeopleNumber int
		// 入住时间 OrderCheckinTime varchar
		// 下单时间 OrderTime varchar
		// 退房时间 OrderCheckoutTime varchar
		// 付款金额 OrderMoney int
		// 订单状态 OrderState int
		// 客户号 UserId int
		// 房间号 RoomId int

	}

	public static final class Room {
		public static final String RoomList = "RoomList";
		public static final String RoomId = "RoomId";
		public static final String RoomCommit = "RoomCommit";
		public static final String RoomType = "RoomType";
		// 房间号 RoomId
		// 房间 RoomNumber
		// 单间房间价格 RoomUnitPrice
		// 房间使用状态 RoomUsingState
		// 房间锁状态 RoomLockState
		// 房间经度 RoomLongitude
		// 房间纬度 RoomLatitude
		// 房间描述 RoomMassage
		// 房间详细地址 RoomDetailAddress
		// 房间密码 RoomPassword
		// 地区号 AddressId
		// 房间设备Id RoomEquipmentId
		// 房间图片 RoomPicture
	}

	public static final class RoomCommit {
		public static final String RoomId = "RoomId";
		public static final String RoomCommitContent = "RoomCommitContent";
		public static final String RoomCommitRank = "RoomCommitRank";
		public static final String UserId = "UserId";
	}
}
