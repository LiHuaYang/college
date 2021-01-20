package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bll.CBllFrame;
import com.EntityAndroid.SearchScord;
import com.EntityAndroid.UserBaseInfo;
import com.EntityAndroid.UserInfobyId;
import com.EntityAndroid.UserScoreInfo;
import com.EntityWeb.Collect;
import com.EntityWeb.CompetitionInfo;
import com.EntityWeb.User;
import com.Tool.sql.JdbcUnit;



public class DaoUser {
	
	private volatile static DaoUser cDaoUser = null;
	
	public DaoUser(){
		System.out.println("DaoUser构造函数被调用");
	};
	
	public static DaoUser getInstance(){
		if(cDaoUser == null){
			synchronized (CBllFrame.class) {
				if(cDaoUser == null){
					cDaoUser = new DaoUser();
				}
			}
		}
		
		return cDaoUser;
	}
//------------------------------安卓部分-----------------------------------	
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-12下午17:51:34
	 *函数名：UserLogin
	 *功能：通过账号密码查询用户信息
	 *参数：账号：account；密码：password
	 *返回值：UserBaseInfo
	 * @throws SQLException 
	 */
	public UserBaseInfo UserLogin(String account,String password) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select UserId,userName,userPicture,UserNickname,UserPhone,userSex,userYear from user where UserPhone='"+account+"' and UserPassage='"+password+"'";
		UserBaseInfo user = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {	
				user = new UserBaseInfo(rs);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-24下午12:02:23
	 *函数名：QueryUserId
	 *功能：通过账号和密码查询用户id
	 *参数：电话号码（账号）：account；密码：password
	 *返回值：int
	 */
	public int QueryUserId(String account,String password){	
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select UserId from user where UserPhone='"+account+"' and UserPassage='"+password+"'";
		int userid=0;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {	
				userid = rs.getInt(1);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userid;
	}

	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午04:36:58
	 *函数名：CreateUser
	 *功能：新增用户
	 *参数：user
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean CreateUser(User user) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "insert into user(UserPhone,UserPassage) "
				+ "values('"
				+ user.getUserPhone()
				+ "','"
				+ user.getUserPassage()
				+ "')";
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		
		boolean result = true;
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午08:15:12
	 *函数名：UpdataUserNike
	 *功能：用户昵称修改
	 *参数：用户昵称：userNickname,用户id：userid
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean UpdataUserNike(int userid,String userNickName) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserNickname='"
				+ userNickName+ "' where UserId=" +  userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean UpdataUserName(int userid,String userName) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserName='"
				+ userName+ "' where UserId=" +  userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean UpdataContactMan(int userid,String ContactMan) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserContactsMan='"
				+ ContactMan+ "' where UserId=" +  userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean UpdataUserSchool(int userid,String userSchool) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserSchool='"
				+ userSchool+ "' where UserId=" +  userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean UpdataUserIDNumber(int UserId, String UserIDNUmber) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserIDNUmber='"
				+ UserIDNUmber+ "' where UserId=" +  UserId;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午03:42:02
	 *函数名：QueryUserBasicInfo
	 *功能：通过用户id查询用户基本信息
	 *参数：用户id：UserId
	 *返回值：user
	 * @throws SQLException 
	 */
	public User QueryUserBasicInfo(int userid) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "Select UserNickname,UserSex,userContactsPhon,UserGrade,UserAddress from user where userid="+userid;
		User user = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				String UserNickname=rs.getString(1);
				String UserSex=rs.getString(2);
				String userContactsPhon=rs.getString(3);
				int UserGrade=rs.getInt(4); 
				String UserAddress=rs.getString(5);
				user = new User(UserNickname, UserSex, userContactsPhon, UserGrade,UserAddress);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午04:52:58
	 *函数名：UpdataUserPhon
	 *功能：用户联系电话修改
	 *参数：用户联系电话：userContactsPhon,用户id：userid
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean UpdataUserPhon(int userid,String userContactsPhon) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set userContactsPhon='"
				+ userContactsPhon+ "' where UserId=" +  userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午04:52:58
	 *函数名：UpdataUserSex
	 *功能：用户性别修改
	 *参数：用户性别：userSex,用户id：userid
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean UpdataUserSex(int userid,String userSex) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set usersex='"
				+ userSex+ "' where UserId=" +  userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-17下午05:41:13
	 *函数名：UpdataUserGrade
	 *功能：用户年级修改
	 *参数：用户年级：UserGrade,用户id：userid
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean UpdataUserGrade(int userid,int UserGrade) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserGrade='"
			+ UserGrade+ "' where UserId=" +  userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-20下午10:18:15
	 *函数名：UpdataUserPassword
	 *功能：用户密码修改
	 *参数：用户新密码：UserPassword,用户旧密码：OldPassword,用户id：userid
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean UpdataUserPassword(int userid,String OldPassword,String UserPassword) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserPassage='" + UserPassword+ "' where UserId=" +  userid +" and UserPassage='"+OldPassword+"'";
		int i=0;
		
		boolean result = false;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			
			i=ps.executeUpdate();//返回int类型，表示更新了数据库中的几条数据
			if(i>0)
			{
				result = true;
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-3-10下午10:28:56
	 *函数名：UpdataUserPassword
	 *功能：TODO
	 *参数：根据用户ID设置新密码
	 *返回值：boolean
	 */
	public boolean UpdataUserPassword(int userid,String UserNewPassword) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserPassage='" + UserNewPassword+ "' where UserId=" +  userid ;
		
		boolean result = false;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			
			int i = ps.executeUpdate();//返回int类型，表示更新了数据库中的几条数据
			if(i>0)
			{
				result = true;
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-26下午08:27:09
	 *函数名：SearchUserInfobyId
	 *功能：通过用户id查询报名信息
	 *参数：用户id：UserId
	 *返回值：UserInfobyId
	 */
	public UserInfobyId SearchUserInfobyId(int UserId){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select UserNickname,UserName,UserSex,UserIDNumber,UserSchool,UserContactsMan," +
				"UserContactsPhon,UserAddress,UserTeacher,UserTeacherPhon,UserGrade,UserPicture " +
				"from user where UserId='"+UserId+"' ";
		UserInfobyId userInfobyId = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {	
				userInfobyId = new UserInfobyId(rs);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userInfobyId;
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
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select StudentName,StudentSex,StudentSchool,StudentPicture,StudentGrade," +
				"StudentTicket,StartTime,ContestObject,ContestSubject,Studentscore," +
				"StudentRank,CompetitionName from enrollment where StudentTicket='"+StudentTicket+
				"' and StudentName='"+StudentName+"' and CompetitionName='"+ContestSubject+
				"' and EnrollmentPassword='"+EnrollmentPassword+"'";
		
		SearchScord searchScord = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {	
				searchScord = new SearchScord(rs);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return searchScord;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午06:40:08
	 *函数名：CollectCreate
	 *功能：新增收藏表
	 *参数：CollectName:收藏名字，TestPaperId：试卷id，Userid：用户id
	 *返回值：boolean
	 */
	public boolean CollectCreate(Collect collect){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "insert into collect(CollectName,CollectTime,CollectState,TestPaperId,Userid) "
				+ "values('"
				+ collect.getCollectName()
				+ "','"
				+ collect.getCollectTime()
				+ "',1"
				+ ","
				+ collect.getTestPaperId()
				+ ","
				+ collect.getUserid()
				+ ")";
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		
		boolean result = true;
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
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
	 *备注：报名状态为CollectState=1
	 */
	public List<Collect> QueryCollectInfoByUserid(int Userid){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select * from Collect where CollectState=1 and Userid="+Userid;
		
		List<Collect> collects = new ArrayList<Collect>();
		
		Collect collect = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				collect=new Collect(rs);
				collects.add(collect);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  collects;
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
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "Update collect set CollectState=0 where Userid="+Userid+" and TestPaperId="+TestPaperId;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		
		boolean result = true;
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
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
	public List<UserScoreInfo> QueryScoreByUserid(int Userid){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select e.StudentName,e.StudentGrade,e.CompetitionName,e.ContestSubject," +
				"e.CompetitionSession,e.Studentscore,e.StartTime,p.CompetitionId from " +
				"enrollment e,Contest c,Competition p where e.ContestId=c.ContestId and " +
				"c.CompetitionId=p.CompetitionId and e.ContestState=4 and e.Userid="+Userid;
		System.out.println(sql);
		
		List<UserScoreInfo> userScoreInfos = new ArrayList<UserScoreInfo>();
		
		UserScoreInfo userScoreInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				userScoreInfo=new UserScoreInfo(rs);
				userScoreInfos.add(userScoreInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i = 0;i<userScoreInfos.size();i++){
			if(userScoreInfos.get(i).getStudentscore()==-1){ 
				System.out.println("成功");
				userScoreInfos.get(i).setStudentscore(-1);
			}
		}
		return  userScoreInfos;
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
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "Select e.StudentGrade,e.CompetitionName,e.ContestSubject," +
				"e.CompetitionSession,e.StartTime,p.CompetitionId,e.studentname, o.OrganizationAddress from " +
				"enrollment e,Contest c,Competition p,Organization o where e.ContestId=c.ContestId and o.OrganizationId=e.OrganizationId and " +
				"c.CompetitionId=p.CompetitionId and e.enrollmentState!=-1 and e.Userid="+Userid;
		System.out.println(sql);
		List<UserScoreInfo> userScoreInfos = new ArrayList<UserScoreInfo>();
		
		UserScoreInfo userScoreInfo = null;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				String StudentGrade = rs.getString(1);
				String CompetitionName = rs.getString(2);
				String ContestSubject = rs.getString(3);
				int CompetitionSession = rs.getInt(4);
				String StartTime = rs.getString(5);
				int CompetitionId = rs.getInt(6);
				String studentName = rs.getString(7);
				String organizationAddress = rs.getString(8);
				
				userScoreInfo=new UserScoreInfo(StudentGrade,CompetitionName,ContestSubject,CompetitionSession,StartTime,CompetitionId,studentName);
				userScoreInfo.setOrganizationAddress(organizationAddress);
				userScoreInfos.add(userScoreInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  userScoreInfos;
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
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select UserNickname,UserSex,UserPhone,UserGrade,UserAddress,UserPicture " +
				     "from user where UserId='"+UserId+"' ";
		User user = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {	
				user = new User(rs);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
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
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserNickname='"+UserNickName+"',UserSex='"+UserSex+"',UserPhone='"+UserPhone+"'," +
				"UserGrade="+UserGrade+",UserAddress='"+UserAddress+"',UserPicture='"+UserPic+"' where UserId="+UserId+"";
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-2下午08:30:05
	 *函数名：UpdataUserPicture
	 *功能：修改用户头像图片
	 *参数：用户id：userId,用户头像：userPictureurl
	 *返回值：boolean
	 */
	public boolean UpdataUserPicture(int userid,String userpictureurl){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserPicture='"+userpictureurl+"' where UserId="+userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-9下午07:09:09
	 *函数名：QueryUserPhone
	 *功能：查找用户 
	 *参数：用户账户：UserAccount
	 *返回值：boolean
	 */
	public boolean QueryUserPhone(String UserAccount){
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql ="Select count(*) from user where UserPhone='"+UserAccount+"'";
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		int count=0;
		try {
			ResultSet rs = ps.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
			if(count!=0){
				result=false;
			}
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
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
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserAddress='"
				+ userAddress+ "' where UserId=" +  userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
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
	public boolean UpdataUserPassword(String UserPhone,String UserPassage) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserPassage='"
				+ UserPassage+ "' where UserPhone=" +  UserPhone;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
//------------------------------web部分-----------------------------------	
	

	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-14下午16:28:34
	 *函数名：UserCreate
	 *功能：增加用户
	 *参数：user
	 *返回值：true/false
	 * @throws SQLException 
	 */
	public boolean UserCreate(User user) {
		boolean result = true;
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql="insert into user(UserPhone,UserName,UserSex,UserIDNumber,UserSchool,UserYear,UserContactsMan,UserContactsPhon," +
				"UserAddress,UserTeacher,UserTeacherPhon,UserPicture,UserState,UserGrade) values('"+user.getUserPhone()+"','"+user.getUserName()+"','"+user.getUserSex()+"'," +
				"'"+user.getUserIDNumber()+"','"+user.getUserSchool()+"',"+user.getUserYear()+",'"+user.getUserContactsMan()+"','"+user.getUserContactsPhon()+"','"+user.getUserAddress()+"'," +
				"'"+user.getUserTeacher()+"','"+user.getUserTeacherPhon()+"','"+user.getUserPicture()+"','1','"+user.getUserGrade()+"')";
		PreparedStatement pstmt = null;
		try
		{
			pstmt = (PreparedStatement)con.prepareStatement(sql);
			pstmt.execute();
			con.close();
			pstmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			result=false;
		}
		
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-14下午19:53:34
	 *函数名：UserSearchByName
	 *功能：通过用户名字查询用户
	 *参数：UserName
	 *返回值：User
	 * @throws SQLException 
	 */
	public List<User> UserSearchByName(String UserName,int page) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos = (page - 1) * 10;
		String sql = "select UserId, UserName,UserNickname,UserGrade,UserContactsMan,UserContactsPhon,UserTeacher," +
				"UserTeacherPhon from user where UserName like '%"+UserName+"%' limit " + startPos + "," +10;
		
		User user = null;
		List<User> users=new ArrayList<User>();
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {	
				user = new User(rs);
				users.add(user);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-14下午20:22:34
	 *函数名：UserSearchInfo
	 *功能：查询所有用户信息
	 *参数：无
	 *返回值：User
	 * @throws SQLException 
	 */
	public List<User> UserSearchInfo(int page) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos = (page - 1) * 10;
		User user =null;
		List<User> users=new ArrayList<User>();
		String sql = "select UserId, UserName,UserNickname,UserGrade,UserContactsMan,UserContactsPhon,UserTeacher,UserState," +
					"UserTeacherPhon, UserPhone from user limit " + startPos + "," +10;
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {	
				user = new User(rs);
				users.add(user);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-14下午20:48:34
	 *函数名：UserSearchSingelInfo
	 *功能：通过用户id查找单个用户所有信息
	 *参数：UserId
	 *返回值：User
	 * @throws SQLException 
	 */
	public User UserSearchSingelInfo(int UserId) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "select * from user where UserId='"+UserId+"' ";
		User user = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {	
				user = new User(rs);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-14下午21:21:34
	 *函数名：UserSearchAllCompetitionById
	 *功能：通过用户id查询单个用户信息的所有大赛信息
	 *参数：UserId
	 *返回值：CompetitionInfo
	 * @throws SQLException 
	 */
	public List<CompetitionInfo> UserSearchAllCompetitionById(int UserId,int page) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		int startPos = (page - 1) * 10;
		String sql = "Select * from competition,contest where competition.CompetitionId=contest.CompetitionId and contest.Userid="+UserId+" limit "+ startPos + "," +10;
		List<CompetitionInfo> competitionInfos = new ArrayList<CompetitionInfo>();
		CompetitionInfo competitionInfo = null;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				
				competitionInfo = new CompetitionInfo(rs);
				competitionInfos.add(competitionInfo);
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  competitionInfos;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-22下午06:09:04
	 *函数名：changeUserStateById
	 *功能：
	 *参数：@param UserId
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean changeUserStateById(int UserId, int state) {
		boolean flag = true;
		
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		
		String sql = "update user set UserState=" + state + " where userid=" + UserId;
		
		System.out.println(sql);
		
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return  flag;
	}
	/**
	 * 
	 *作者：linguoyi
	 *时间：2016-2-26
	 *函数名：ModifyAUser
	 *功能：修改用户信息
	 *参数：User
	 *返回值：boolean
	 */
	public boolean  ModifyAUser (User user){
		boolean flag=true;
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		//System.out.println(user.getUserId());
		String sql = "update user set UserName='"+user.getUserName()+"',UserSchool='"+user.getUserSchool()+
		"',UserContactsMan='"+user.getUserContactsMan()+"',UserContactsPhon='"+user.getUserContactsPhon()+
		"',UserAddress='"+user.getUserAddress()+"',UserTeacher='"+user.getUserTeacher()+"',UserTeacherPhon='"+
		user.getUserTeacherPhon()+"',UserPicture='"+user.getUserPicture()+"',UserGrade="+user.getUserGrade()+
		",UserYear="+user.getUserYear()+",UserSex='"+user.getUserSex()+"',UserPhone='"+user.getUserPhone()+
		"',UserIDNumber='"+user.getUserIDNumber()+"' where UserId=" + user.getUserId();
		//System.out.println(sql);
		PreparedStatement ps = jdbcUnit.prepare(con, sql);

		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return  flag;
	}
	

	
	/**
	 * 
	 *作者：linguoyi
	 *函数名：ModifyAUserHeadPic
	 *功能：修改用户头像
	 *参数：用户id：userid,用户头像userPicture
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean ModifyAUserHeadPic(int userid,String userPicture) {
		JdbcUnit jdbcUnit = JdbcUnit.getInstance();
		Connection con = jdbcUnit.createConn(); // 连接数据库
		String sql = "update user set UserPicture='"
				+ userPicture+ "' where UserId=" +  userid;
		boolean result = true;
		PreparedStatement ps = jdbcUnit.prepare(con, sql);
		try {
			ps.execute();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
	
}
