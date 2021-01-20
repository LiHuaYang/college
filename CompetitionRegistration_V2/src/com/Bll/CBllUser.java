package com.Bll;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.Dao.CDaoFrame;
import com.Dao.IDaoFrame;
import com.EntityAndroid.SearchScord;
import com.EntityAndroid.UserBaseInfo;
import com.EntityAndroid.UserFavoriteCompetition;
import com.EntityAndroid.UserFavoriteGoods;
import com.EntityAndroid.UserFavoriteNews;
import com.EntityAndroid.UserInfobyId;
import com.EntityAndroid.UserScoreInfo;
import com.EntityWeb.Collect;
import com.EntityWeb.CompetitionInfo;
import com.EntityWeb.User;


//用户管理
public class CBllUser {
	
	IDaoFrame iDaoFrame = CDaoFrame.getInstance();
	
//	//CBllCompetition单例
//	private volatile static CBllUser cBllUser = null;
//	
//	private CBllUser(){
//		System.out.println("CBllUser构造函数被调用");
//	};
//	
//	public static CBllUser getInstance(){
//		if(cBllUser == null){
//			synchronized (CBllUser.class) {
//				if(cBllUser == null){
//					cBllUser = new CBllUser();
//				}
//			}
//		}
//		
//		return cBllUser;
//	}
	
	public CBllUser(){
		System.out.println("CBllUser构造函数被调用");
    };

//------------------------------安卓部分-----------------------------------	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:21:34
	 *函数名：LoginAccount
	 *功能：通过账号密码登录
	 *参数：账号：account；密码：password
	 *返回值：UserBaseInfo
	 */
	public UserBaseInfo LoginAccount(String account,String password){
		UserBaseInfo user=null;
		user=iDaoFrame.UserLogin(account, password);
		return user;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-24下午12:09:26
	 *函数名：LoginWeb
	 *功能：在网页端的通过账号密码登录
	 *参数：电话号码（账号）：account；密码：password
	 *返回值：int
	 */
	public int LoginWeb(String account,String password){
		int Userid=iDaoFrame.QueryUserId(account, password);
		return Userid;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午04:00:38
	 *函数名：UserRegister
	 *功能：用户注册
	 *参数：手机号：UserPhone；密码：UserPassword
	 *返回值：boolean
	 */
	public boolean UserRegister(User user){
		boolean result=iDaoFrame.CreateUser(user);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午08:27:58
	 *函数名：ChangeUserNikeName
	 *功能：修改用户昵称
	 *参数：用户昵称：userNickname,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserNikeName(int UserId,String UserNikeName){
		boolean result=iDaoFrame.UpdataUserNike(UserId, UserNikeName);
		return result;
	}
	
	public boolean ChangeUserName(int UserId,String UserName){
		boolean result=iDaoFrame.UpdataUserName(UserId, UserName);
		return result;
	}
	
	public boolean ChangeContactMan(int UserId,String ContactMan){
		boolean result=iDaoFrame.UpdataContactMan(UserId, ContactMan);
		return result;
	}
	
	public boolean ChangeUserSchool(int UserId,String UserSchool){
		boolean result=iDaoFrame.UpdataUserSchool(UserId, UserSchool);
		return result;
	}
	
	public boolean ChangeUserIDNumber(int UserId, String UserIDNUmber) {
		boolean result=iDaoFrame.UpdataUserIDNumber(UserId, UserIDNUmber);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午04:04:13
	 *函数名：SearchUserBasicInfo
	 *功能：查询用户的昵称，性别，联系电话,学习年级和地址
	 *参数：用户id：userid
	 *返回值：User
	 */
	public User SearchUserBasicInfo(int userid){
		User rsult = null;
		try {
			rsult = iDaoFrame.QueryUserBasicInfo(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsult;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午05:02:11
	 *函数名：ChangeUserContactsPhon
	 *功能：修改用户联系电话
	 *参数：用户联系电话：userContactsPhon,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserContactsPhon(int UserId,String userContactsPhon){
		boolean result=iDaoFrame.UpdataUserPhon(UserId, userContactsPhon);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-17下午05:34:52
	 *函数名：ChangeUserContactsSex
	 *功能：修改用户性别
	 *参数：用户性别：userSex,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserContactsSex(int userid,String userSex){
		boolean result=iDaoFrame.UpdataUserSex(userid, userSex);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-17下午05:47:30
	 *函数名：ChangeUserGrade
	 *功能：用户年级修改
	 *参数：用户年级：UserGrade,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserGrade(int userid,int UserGrade){
		boolean result=iDaoFrame.UpdataUserGrade(userid, UserGrade);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-21下午12:33:03
	 *函数名：ChangeUserPassword
	 *功能：用户密码修改
	 *参数：用户新密码：UserPassword,用户旧密码：OldPassword,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserPassword(int userid,String OldPassword,String UserPassword) {
		boolean result=iDaoFrame.UpdataUserPassword(userid, OldPassword, UserPassword);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:21:34
	 *函数名：LoginAccount
	 *功能：通过QQ号码登录
	 *参数：QQ号码：UserQQAccount
	 *返回值：UserBaseInfo
	 */
	public UserBaseInfo LoginQQ(String UserQQAccount){
		return null;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:21:34
	 *函数名：LoginAccount
	 *功能：通过微博账号登录
	 *参数：QQ号码：UserQQAccount
	 *返回值：UserBaseInfo
	 */
	public UserBaseInfo LoginMicro(String UserMicrobloggingAccount){
		return null;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:30:59
	 *函数名：QueryCollectCompetition
	 *功能：查看收藏的比赛的列表
	 *参数：收藏的类型：CollectionType；用户的id：userid
	 *返回值：UserFavoriteCompetition
	 */
	public UserFavoriteCompetition QueryCollectCompetition(int CollectionType,int userid){
		return null;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:30:59
	 *函数名：QueryCollectCompetition
	 *功能：查看收藏的新闻的列表
	 *参数：收藏的类型：CollectionType；用户的id：userid
	 *返回值：UserFavoriteCompetition
	 */
	public UserFavoriteNews QueryCollectNews(int CollectionType,int userid){
		return null;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:30:59
	 *函数名：QueryCollectCompetition
	 *功能：查看收藏的商品的列表
	 *参数：收藏的类型：CollectionType；用户的id：userid
	 *返回值：UserFavoriteCompetition
	 */
	public UserFavoriteGoods QueryCollectGoods(int CollectionType,int userid){
		return null;
		
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-26下午01:36:15
	 *函数名：searchScord
	 *功能：查询学生成绩
	 *参数：ContestSubject,StudentName,StudentTicket
	 *返回值：SearchScord
	 */
	public SearchScord searchScord(String ContestSubject,String StudentName,String StudentTicket,String EnrollmentPassword){
		
		SearchScord searchScord=null;
		searchScord=iDaoFrame.searchScord(ContestSubject, StudentName, StudentTicket,EnrollmentPassword);
		return searchScord;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-26下午09:12:44
	 *函数名：GetUserInfobyId
	 *功能：通过用户id查询报名信息
	 *参数：用户id：userid
	 *返回值：UserInfobyId
	 */
	public UserInfobyId GetUserInfobyId(int UserId){
		UserInfobyId result=iDaoFrame.SearchUserInfobyId(UserId);
		return result;
	}

	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午06:40:08
	 *函数名：CollectCreate
	 *功能：收藏试卷
	 *参数：CollectName:收藏名字，TestPaperId：试卷id，Userid：用户id
	 *返回值：boolean
	 */
	public boolean CollectCreate(Collect collect){
		boolean result=iDaoFrame.CollectCreate(collect);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午08:35:52
	 *函数名：QueryCollectInfoByUserid
	 *功能：通过用户id查找收藏信息
	 *参数：用户id：userid
	 *返回值：List<Collect>
	 */
	public List<Collect> QueryCollectInfoByUserid(int Userid){
		List<Collect> result=iDaoFrame.QueryCollectInfoByUserid(Userid);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午09:16:37
	 *函数名：CancelCollenctState
	 *功能：通过用户Id和试卷id改变状态
	 *参数：用户id：collectId，试卷id：TestPaperId
	 *返回值：boolean
	 */
	public boolean CancelCollenctState(int Userid,int TestPaperId){
		boolean result=iDaoFrame.CancelCollenctState(Userid, TestPaperId);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午10:02:43
	 *函数名：QueryScoreByUserid
	 *功能：通过用户id查询成绩
	 *参数：
	 *返回值：List<Enrollment>
	 */
	public List<UserScoreInfo> SearchScoreByUserid(int Userid){
		List<UserScoreInfo> result=iDaoFrame.QueryScoreByUserid(Userid);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-27下午08:39:37
	 *函数名：QueryEnrollComByUserid
	 *功能：根据用户id获取已报名比赛
	 *参数：用户Id
	 *返回值：List<UserScoreInfo>
	 */
	public List<UserScoreInfo> QueryEnrollComByUserid(int Userid){
		
		List<UserScoreInfo> result=iDaoFrame.QueryEnrollComByUserid(Userid);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-28下午02:52:21
	 *函数名：GetUserInfoById
	 *功能：根据用户id获取个人信息
	 *参数：userid
	 *返回值：User
	 */
	public User GetUserInfoById(int UserId){
		
		User result=iDaoFrame.GetUserInfoById(UserId);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-28下午03:17:45
	 *函数名：ChangeUserInfo
	 *功能：修改用户信息（昵称，性别，联系号码，学习阶段，地址，图片）
	 *参数：  昵称，性别，联系号码，学习阶段，地址，图片,用户id
	 *返回值：true/false
	 */
	public boolean ChangeUserInfo(String UserNickName,String UserSex,String UserPhone,int UserGrade,String UserAddress,String UserPic,int UserId){
		
		boolean result=iDaoFrame.ChangeUserInfo(UserNickName, UserSex, UserPhone, UserGrade, UserAddress, UserPic, UserId);
		return result;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-2下午08:37:21
	 *函数名：ChangeUserPicture
	 *功能：上传用户头像
	 *参数：用户id：userId,用户头像：userPictureurl
	 *返回值：boolean
	 */
	public boolean ChangeUserPicture(int userid,String userpictureurl){
		boolean result=iDaoFrame.UpdataUserPicture(userid, userpictureurl);
		return result;
	}
	
	/**
	 * 
	 *作者：QiuMeifang
	 *时间：2016-3-4下午07:53:12
	 *函数名：UpdataUserAddress
	 *功能：用户地址修改
	 *参数：用户地址：userAddress,用户id：userid
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean UpdataUserAddress(int userid,String userAddress) {
		boolean result=iDaoFrame.UpdataUserAddress(userid, userAddress);
		return result;	
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-9下午07:30:01
	 *函数名：JudgeUserPhone
	 *功能：判断用户是否已经注册
	 *参数：用户账户：UserAccount
	 *返回值：boolean
	 */
	public boolean JudgeUserPhone(String UserAccount){
		boolean result=iDaoFrame.QueryUserPhone(UserAccount);
		return result;
	}
	
	/**
	 * 
	 *作者：QiuMeifang
	 *时间：2016-3-9下午03:22:16
	 *函数名：UpdataUserPassword
	 *功能：用户密码修改
	 *参数：用户密码：UserPassage,用户id：userid
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean UpdataUserPassword(String UserPhone,String UserPassage){
		boolean result=iDaoFrame.UpdataUserPassword(UserPhone, UserPassage);
		return result;	
	}
//------------------------------web部分-----------------------------------	

	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午02:41:43
	 *函数名：UserCreate
	 *功能：新增用户
	 *参数：user
	 *返回值：boolean
	 */
	public boolean UserCreate(User user){
		if(iDaoFrame.UserCreate(user)){
			return true;
		}
		return false;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午02:44:22
	 *函数名：UserChangeInfo
	 *功能：修改用户个人信息
	 *参数：user
	 *返回值：boolean
	 */
	public boolean UserChangeInfo(User user){
		return false;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午02:45:33
	 *函数名：UserSearchByName
	 *功能：通过用户名字查询用户信息
	 *参数：用户名字：Username
	 *返回值：User
	 */
	public List<User> UserSearchByName(String Username,int page){
		List<User> user=null;
		user=iDaoFrame.UserSearchByName(Username, page);
		return user;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午02:46:54
	 *函数名：UserSearchInfo
	 *功能：查询所有用户信息
	 *参数：无
	 *返回值：User
	 */
	public List<User> UserSearchInfo(int page){
		List<User> users=null;
		users=iDaoFrame.UserSearchInfo(page);
		return users;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午02:48:58
	 *函数名：UserSearchSingelInfo
	 *功能：查询单个用户基本信息
	 *参数：用户id：UserId
	 *返回值：User
	 */
	public User UserSearchSingelInfo(int UserId){
		User user=null;
		user=iDaoFrame.UserSearchSingelInfo(UserId);
		return user;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午02:53:11
	 *函数名：UserSearchSingelCompetitionInfo
	 *功能：查询单个用户信息的所有大赛信息
	 *参数：用户id：UserId
	 *返回值：CompetitionInfo
	 */
	public List<CompetitionInfo> UserSearchSingelCompetitionInfo(int UserId,int page){
		List<CompetitionInfo> competitionInfo=null;
		competitionInfo=iDaoFrame.UserSearchAllCompetitionById(UserId,page);
		return competitionInfo;
		
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-21下午03:04:42
	 *函数名：UserSearchInfo
	 *功能：
	 *参数：
	 *返回值：List<User>
	 */
	public List<User> UserSearchInfo(JSONObject obj, int page) {

		List<User> usesList = null;
		int searchType = obj.getInt("searchType");
		String searchCondition = obj.getString("searchCondition");
		
		// 1. 姓名模糊查询
		if(1 == searchType) {
			usesList = iDaoFrame.UserSearchByName(searchCondition, page);
			return usesList;
		}
		
		if(2 == searchType) {
			// usesList = cBllUser.wait(timeout, nanos);
			return null;
		}
		// 2. 电话号码查询
		return usesList;
	}
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-22下午06:11:56
	 *函数名：ModifyUser
	 *功能：
	 *参数：@param type
	 *参数：@param id
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean ModifyUser(int id, int type) {
		
		boolean flag = true;
		// 1. 修改用户状态（删除）
		if(1 == type) {
			flag = iDaoFrame.changeUserStateById(id, 0);
			return flag;
		}
		
		// 2. 修改用户状态（恢复）
		if(2 == type) {
			flag = iDaoFrame.changeUserStateById(id, 1);
			return flag;
		}
		
		return flag;
	}
	
		
}
