package com.AndroidTool;

public class OperationCode {

	// ������
	public static final class Operation {

		public static final String OPERATION = "operation"; // ������
		public static final int LOGIN = 1; // ��¼
		public static final int QUIT = 0; // �˳�
		public static final String SIGN = "sign"; // ��־
		public static final String TYPE = "type"; // User����(0.ɾ����1.Ա����2.���ܡ�3.����)
		public static final String TRUE = "true"; // ��ֵ
		public static final String FALSE = "false"; // ��ֵ
		public static final String LIST = "list"; // �б�
		// ���ܹ���
		public static final int ENTER_CHARGE_EXPENSES = 2; // ���ܽ��뱨��������
		public static final int ENTER_CHARGE_LEAVES = 3; // ���ܽ������������
		public static final int SEND_CHARGE_EXPENSE_CHECK = 4; // ������˱�����
		public static final int SEND_CHARGE_LEAVE_CHECK = 5; // ������˱�����
		// �������
		public static final int MANAGER_USERS = 6; // �����û�����
		public static final int ENTER_MANAGER_EXPENSES = 7; // ������뱨��������
		public static final int ENTER_MANAGER_LEAVES = 8; // ����������������
		public static final int SEND_MANAGER_EXPENSE_CHECK = 9; // ��������������
		public static final int SEND_MANAGER_LEAVE_CHECK = 10; // �������������
		// �û�
		public static final int ENTER_USER_EXPENSES = 11; // �����û��������༭����
		public static final int ENTER_USER_LEAVES = 12; // �����û�������༭����
		public static final int SEND_LEAVE = 13; // �ύ�����
		public static final int SEND_EXPENSE = 14; // �ύ������
		public static final int ENTER_LIST = 15; // �����б�
	}

	// �û��ֶ�
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

		// ������ OrderId int
		// ��ס���� OrderStayinDay int
		// ��ס���� OrderStayinPeopleNumber int
		// ��סʱ�� OrderCheckinTime varchar
		// �µ�ʱ�� OrderTime varchar
		// �˷�ʱ�� OrderCheckoutTime varchar
		// ������ OrderMoney int
		// ����״̬ OrderState int
		// �ͻ��� UserId int
		// ����� RoomId int

	}

	public static final class Room {
		public static final String RoomList = "RoomList";
		public static final String RoomId = "RoomId";
		public static final String RoomCommit = "RoomCommit";
		public static final String RoomType = "RoomType";
		// ����� RoomId
		// ���� RoomNumber
		// ���䷿��۸� RoomUnitPrice
		// ����ʹ��״̬ RoomUsingState
		// ������״̬ RoomLockState
		// ���侭�� RoomLongitude
		// ����γ�� RoomLatitude
		// �������� RoomMassage
		// ������ϸ��ַ RoomDetailAddress
		// �������� RoomPassword
		// ������ AddressId
		// �����豸Id RoomEquipmentId
		// ����ͼƬ RoomPicture
	}

	public static final class RoomCommit {
		public static final String RoomId = "RoomId";
		public static final String RoomCommitContent = "RoomCommitContent";
		public static final String RoomCommitRank = "RoomCommitRank";
		public static final String UserId = "UserId";
	}
}
