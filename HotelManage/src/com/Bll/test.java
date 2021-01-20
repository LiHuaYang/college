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

		// 新建用户
		// User user= new User("丽丽","122","女","@","31");
		// boolean result=cBllImpl.CreateUser(user);
		// System.out.print(result);

		// 用email登入
		// int userId=2;
		// String useremail="@";
		// String password="11";
		// boolean result=cBllImpl.UserLoginEmail(userId,useremail,password);
		// System.out.print(result);

		// 用电话登入
		// int userId=2;
		// String userphone="11";
		// String password="11";
		// boolean result=cBllImpl.UserLoginPhon(userId,userphone,password);
		// System.out.print(result);

		// 删除用户
		// int userid=2;
		// boolean result=cBllImpl.DeleteUser(userid);
		// System.out.print(result);

		// 锁定/激活用户
		// int userId=2;
		// int userState=1;
		// boolean result=cBllImpl.LockCheckUser(userId, userState);
		// System.out.print(result);

		// 查询用户所有信息
		// List<User> result=cBllImpl.QueryAllUser();
		// System.out.print(result);

		// 用户邮箱登录
		// List<User> result=cBllImpl.UserLoginEmail("11@", "11");
		// System.out.print(result);

		// 查询房间详情
		// HashMap<String, Object> result=cBllImpl.QueryRoomDetail(1);
		// System.out.print(result);

		// 查找房间评价表(按房间号查找)
		// HashMap<String, Object> result=cBllImpl.QueryRoomCommitUser(1);
		// System.out.print(result);

		// 按房间号查找到评论信息和用户信息
		// List<HashMap<String, Object>> result=cBllImpl.QueryRoomCommitUser(1);
		// System.out.print(result);

		// List<Room> result=cBllImpl.QueryRoomByAreaid(1);

		// Address result=cBllImpl.QueryAddressId("浙江省", "宁波市", "童一村");
		// System.out.print(result);
		// Address address=new Address(AddressProvince, AddressCity,
		// AddressVillage, RoomId, AddressPicture)
		// List<Room> result=cBllImpl.QueryRoomByArea(address);

		// 查询所有的村
		// List<Address> result = cBllImpl.QueryAllAddress();
		// System.out.print(result);

		// 更改用户头像
		// boolean result=cBllImpl.ChangeUserPic(1,
		// "img/room-img/jiangdong (3).jpg");
		// System.out.print(result);

		// 通过房间类型查找房间
		// List<Room> result=cBllImpl.QueryRoomByRoomtype(1);
		// System.out.print(result);

		// 通过电话号码和密码查询出密码以外的所有用户的信息
		// String userphon="1";
		// String userpassword="1";
		// List<HashMap<String, Object>> result=cBllImpl.QueryPhonuserother
		// (userphon,userpassword);
		// System.out.print(result.get(0).get("UserName"));

		// 新建交易
		// Transaction transaction=new Transaction("哈哈", 100, 1);
		// boolean result=cBllImpl.CreateTransaction(transaction);
		// System.out.print(result);

		// 查询交易
		// List<Transaction> result=cBllImpl.QueryTransaction();
		// System.out.print(result);

		// 查找订单信息
//		int userid = 1;
//		List<HashMap<String, Object>> result = cBllImpl
//				.QueryOrderRommByUserId(userid);
//		System.err.println(result);
//		CBllImpl cBllImpl=new CBllImpl();
		
		//新建用户
//		User user= new User("丽丽","122","女","@","31");
//		boolean result=cBllImpl.CreateUser(user);
//		System.out.print(result);
		
		//用email登入
//		int userId=2;
//		String useremail="@";
//		String password="11";
//		boolean result=cBllImpl.UserLoginEmail(userId,useremail,password);
//		System.out.print(result);
		
		
		//用电话登入
//		int userId=2;
//		String userphone="11";
//		String password="11";
//		boolean result=cBllImpl.UserLoginPhon(userId,userphone,password);
//		System.out.print(result);
		
		
		//删除用户
//		int userid=2;
//		boolean result=cBllImpl.DeleteUser(userid);
//		System.out.print(result);
		
		//锁定/激活用户
//		int userId=2;
//		int userState=1;
//		boolean result=cBllImpl.LockCheckUser(userId, userState);
//		System.out.print(result);
		
		//查询用户所有信息
//		List<User> result=cBllImpl.QueryAllUser();
//		System.out.print(result);
		
		//用户邮箱登录
//		List<User> result=cBllImpl.UserLoginEmail("11@", "11");
//		System.out.print(result);
		
		//查询房间详情
//		HashMap<String, Object> result=cBllImpl.QueryRoomDetail(1);
//		System.out.print(result);
		
		//查找房间评价表(按房间号查找)
//		 HashMap<String, Object> result=cBllImpl.QueryRoomCommitUser(1);
//		 System.out.print(result);
		 
		//按房间号查找到评论信息和用户信息
//		List<HashMap<String, Object>> result=cBllImpl.QueryRoomCommitUser(1);
//	    System.out.print(result);
		
		//List<Room> result=cBllImpl.QueryRoomByAreaid(1);
		
//		 Address result=cBllImpl.QueryAddressId("浙江省", "宁波市", "童一村");
//		 System.out.print(result);
//		Address address=new Address(AddressProvince, AddressCity, AddressVillage, RoomId, AddressPicture)
//		List<Room> result=cBllImpl.QueryRoomByArea(address);
		
		//查询所有的村
//		List<Address> result = cBllImpl.QueryAllAddress();
//		System.out.print(result);
		
		//更改用户头像
//		boolean result=cBllImpl.ChangeUserPic(1, "img/room-img/jiangdong (3).jpg");
//		System.out.print(result);
		
		//通过房间类型查找房间
//		List<Room> result=cBllImpl.QueryRoomByRoomtype(1);
//		System.out.print(result);
		
		//通过电话号码和密码查询出密码以外的所有用户的信息
//		String userphon="1";
//		String userpassword="1";
//		List<HashMap<String, Object>> result=cBllImpl.QueryPhonuserother (userphon,userpassword);
//		System.out.print(result.get(0).get("UserName"));
		
		//新建交易
//		Transaction transaction=new Transaction("哈哈", 100, 1);
//		boolean result=cBllImpl.CreateTransaction(transaction);
//		System.out.print(result);
		
		//查询交易
//		List<Transaction> result=cBllImpl.QueryTransaction();
//		System.out.print(result);
		
//		查找订单信息
//		int userid=1;
//		List<HashMap<String,Object>> result=cBllImpl.QueryOrderRommByUserId(userid);
//		System.err.println(result);
		
		//通过用户id查询交易记录
//		List<Transaction> result= cBllImpl.Querybyuserid(1);
//		System.out.print(result);
		
		//多条件查询房间
//		List<Room> result=cBllImpl.QueryRoomselectcondition("海曙区","2015-02-13","2015-02-20",0,200);
//        System.out.print(result);
		
		
		//通过用户id查找除用户密码之外的所有信息
//		int userid=1;
//		List<HashMap<String, Object>> result=cBllImpl.QueryUserExceptPasswordById(userid);
//		System.err.println(result);
		
		//修改用户部分信息
		int userid=1;
		String userName="金";
		String userSex="女性";
		String userBoth="05-22";
		String userPhone="1";
		String userMessage="我是";
		String userEmail="1072211372@qq.com";
		String userIdNumber="330522";
		boolean result=cBllImpl.UpdateUserPart(userid, userName, userSex, userBoth, userPhone, userEmail, userIdNumber, userMessage);
		System.err.println(result);
//		List<Transaction> result= cBllImpl.Querybyuserid(1);
//		System.out.print(result);
	}

}
