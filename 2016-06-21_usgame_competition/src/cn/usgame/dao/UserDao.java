package cn.usgame.dao;

import java.util.List;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.User;

public interface UserDao {
	/**
	 * 
	 * 函数名称：RegisterUser
	 * 功能描述：注册用户
	 * 参数说明：注册号码，密码
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月4日12:42:00
	 */
	public boolean registerUser(String id,String phone,String password);
	/**
	 * 
	 * 函数名称：login
	 * 功能描述：登录
	 * 参数说明：注册号码，密码
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月4日16:27:44
	 */
	public boolean login(String phone,String password);
	/**
	 * 
	 * 函数名称：getUser
	 * 功能描述：获取用户
	 * 参数说明：注册号码
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月4日16:27:44
	 */
	public User getUser(String phone);
	
	/**
	 * 函数名称：toUser
	 * 功能描述：保存个人信息
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月5日20:37:12
	 */
	public boolean toUser(User user);
	
	/**
	 * 函数名称：changepw
	 * 功能描述：修改密码
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月5日20:37:12
	 */
	public boolean changepw(String new_pw,String phonenumber);
	
	/**
	 * 
	 * 函数名称：getUserComptietion
	 * 功能描述：获取用户报名的比赛
	 * 参数说明：Phonenumber  注册手机号
	 * 返回值：<List>ApplyReport
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月8日20:59:06
	 */
	List<ApplyReport> getUserCompetition(String Phonenumber);
	/**
	 * 
	 * 函数名称：applyreportInfo
	 * 功能描述：获得特定报名比赛的详情
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月9日11:05:30
	 */
	ApplyReport applyreportInfo(String Phonenumber,String applyReportId);
}
