package com.Bll;

import java.util.HashMap;
import java.util.List;

import com.Entity.Address;
import com.Entity.Room;
import com.Entity.RoomCommit;
import com.Entity.Transaction;
import com.Entity.User;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CBllImpl cBllImpl = new CBllImpl();

		// �½��û�
		// User user= new User("����","122","Ů","@","31");
		// boolean result=cBllImpl.CreateUser(user);
		// System.out.print(result);

		// ��email����
		// int userId=2;
		// String useremail="@";
		// String password="11";
		// boolean result=cBllImpl.UserLoginEmail(userId,useremail,password);
		// System.out.print(result);

		// �õ绰����
		// int userId=2;
		// String userphone="11";
		// String password="11";
		// boolean result=cBllImpl.UserLoginPhon(userId,userphone,password);
		// System.out.print(result);

		// ɾ���û�
		// int userid=2;
		// boolean result=cBllImpl.DeleteUser(userid);
		// System.out.print(result);

		// ����/�����û�
		// int userId=2;
		// int userState=1;
		// boolean result=cBllImpl.LockCheckUser(userId, userState);
		// System.out.print(result);

		// ��ѯ�û�������Ϣ
		// List<User> result=cBllImpl.QueryAllUser();
		// System.out.print(result);

		// �û������¼
		// List<User> result=cBllImpl.UserLoginEmail("11@", "11");
		// System.out.print(result);

		// ��ѯ��������
		// HashMap<String, Object> result=cBllImpl.QueryRoomDetail(1);
		// System.out.print(result);

		// ���ҷ������۱�(������Ų���)
		// HashMap<String, Object> result=cBllImpl.QueryRoomCommitUser(1);
		// System.out.print(result);

		// ������Ų��ҵ�������Ϣ���û���Ϣ
		// List<HashMap<String, Object>> result=cBllImpl.QueryRoomCommitUser(1);
		// System.out.print(result);

		// List<Room> result=cBllImpl.QueryRoomByAreaid(1);

		// Address result=cBllImpl.QueryAddressId("�㽭ʡ", "������", "ͯһ��");
		// System.out.print(result);
		// Address address=new Address(AddressProvince, AddressCity,
		// AddressVillage, RoomId, AddressPicture)
		// List<Room> result=cBllImpl.QueryRoomByArea(address);

		// ��ѯ���еĴ�
		// List<Address> result = cBllImpl.QueryAllAddress();
		// System.out.print(result);

		// �����û�ͷ��
		// boolean result=cBllImpl.ChangeUserPic(1,
		// "img/room-img/jiangdong (3).jpg");
		// System.out.print(result);

		// ͨ���������Ͳ��ҷ���
		// List<Room> result=cBllImpl.QueryRoomByRoomtype(1);
		// System.out.print(result);

		// ͨ���绰����������ѯ����������������û�����Ϣ
		// String userphon="1";
		// String userpassword="1";
		// List<HashMap<String, Object>> result=cBllImpl.QueryPhonuserother
		// (userphon,userpassword);
		// System.out.print(result.get(0).get("UserName"));

		// �½�����
		// Transaction transaction=new Transaction("����", 100, 1);
		// boolean result=cBllImpl.CreateTransaction(transaction);
		// System.out.print(result);

		// ��ѯ����
		// List<Transaction> result=cBllImpl.QueryTransaction();
		// System.out.print(result);

		// ���Ҷ�����Ϣ
//		int userid = 1;
//		List<HashMap<String, Object>> result = cBllImpl
//				.QueryOrderRommByUserId(userid);
//		System.err.println(result);
//		CBllImpl cBllImpl=new CBllImpl();
		
		//�½��û�
//		User user= new User("����","122","Ů","@","31");
//		boolean result=cBllImpl.CreateUser(user);
//		System.out.print(result);
		
		//��email����
//		int userId=2;
//		String useremail="@";
//		String password="11";
//		boolean result=cBllImpl.UserLoginEmail(userId,useremail,password);
//		System.out.print(result);
		
		
		//�õ绰����
//		int userId=2;
//		String userphone="11";
//		String password="11";
//		boolean result=cBllImpl.UserLoginPhon(userId,userphone,password);
//		System.out.print(result);
		
		
		//ɾ���û�
//		int userid=2;
//		boolean result=cBllImpl.DeleteUser(userid);
//		System.out.print(result);
		
		//����/�����û�
//		int userId=2;
//		int userState=1;
//		boolean result=cBllImpl.LockCheckUser(userId, userState);
//		System.out.print(result);
		
		//��ѯ�û�������Ϣ
//		List<User> result=cBllImpl.QueryAllUser();
//		System.out.print(result);
		
		//�û������¼
//		List<User> result=cBllImpl.UserLoginEmail("11@", "11");
//		System.out.print(result);
		
		//��ѯ��������
//		HashMap<String, Object> result=cBllImpl.QueryRoomDetail(1);
//		System.out.print(result);
		
		//���ҷ������۱�(������Ų���)
//		 HashMap<String, Object> result=cBllImpl.QueryRoomCommitUser(1);
//		 System.out.print(result);
		 
		//������Ų��ҵ�������Ϣ���û���Ϣ
//		List<HashMap<String, Object>> result=cBllImpl.QueryRoomCommitUser(1);
//	    System.out.print(result);
		
		//List<Room> result=cBllImpl.QueryRoomByAreaid(1);
		
//		 Address result=cBllImpl.QueryAddressId("�㽭ʡ", "������", "ͯһ��");
//		 System.out.print(result);
//		Address address=new Address(AddressProvince, AddressCity, AddressVillage, RoomId, AddressPicture)
//		List<Room> result=cBllImpl.QueryRoomByArea(address);
		
		//��ѯ���еĴ�
//		List<Address> result = cBllImpl.QueryAllAddress();
//		System.out.print(result);
		
		//�����û�ͷ��
//		boolean result=cBllImpl.ChangeUserPic(1, "img/room-img/jiangdong (3).jpg");
//		System.out.print(result);
		
		//ͨ���������Ͳ��ҷ���
//		List<Room> result=cBllImpl.QueryRoomByRoomtype(1);
//		System.out.print(result);
		
		//ͨ���绰����������ѯ����������������û�����Ϣ
//		String userphon="1";
//		String userpassword="1";
//		List<HashMap<String, Object>> result=cBllImpl.QueryPhonuserother (userphon,userpassword);
//		System.out.print(result.get(0).get("UserName"));
		
		//�½�����
//		Transaction transaction=new Transaction("����", 100, 1);
//		boolean result=cBllImpl.CreateTransaction(transaction);
//		System.out.print(result);
		
		//��ѯ����
//		List<Transaction> result=cBllImpl.QueryTransaction();
//		System.out.print(result);
		
//		���Ҷ�����Ϣ
//		int userid=1;
//		List<HashMap<String,Object>> result=cBllImpl.QueryOrderRommByUserId(userid);
//		System.err.println(result);
		
		//ͨ���û�id��ѯ���׼�¼
//		List<Transaction> result= cBllImpl.Querybyuserid(1);
//		System.out.print(result);
		
		//��������ѯ����
//		List<Room> result=cBllImpl.QueryRoomselectcondition("������","2015-02-13","2015-02-20",0,200);
//        System.out.print(result);
		
		
		//ͨ���û�id���ҳ��û�����֮���������Ϣ
//		int userid=1;
//		List<HashMap<String, Object>> result=cBllImpl.QueryUserExceptPasswordById(userid);
//		System.err.println(result);
		
		//�޸��û�������Ϣ
		int userid=1;
		String userName="��";
		String userSex="Ů��";
		String userBoth="05-22";
		String userPhone="1";
		String userMessage="����";
		String userEmail="1072211372@qq.com";
		String userIdNumber="330522";
		boolean result=cBllImpl.UpdateUserPart(userid, userName, userSex, userBoth, userPhone, userEmail, userIdNumber, userMessage);
		System.err.println(result);
//		List<Transaction> result= cBllImpl.Querybyuserid(1);
//		System.out.print(result);
	}

}
