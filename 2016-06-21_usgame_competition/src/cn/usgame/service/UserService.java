package cn.usgame.service;

import java.util.List;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.SMS;
import cn.usgame.entity.User;

public interface UserService {
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
	public User login(String phone,String password);
	
	
	/**
	 * 函数名称：checkVerificationCode
	 * 功能描述：验证内存中手机号码和验证码
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月5日下午2:17:42
	 */
	public boolean checkVerificationCode();
	
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
	public boolean changepw(String new_old,String phonenumber);
	
	/**
	 * 
	 * 函数名称：testUser
	 * 功能描述：验证手机号码是否已被使用
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月7日下午4:31:17
	 */
	boolean testPhone(String phonenumber);
	
	/**
	 * 
	 * 函数名称：pushSMS
	 * 功能描述：将SMS放入栈内
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月7日下午7:23:46
	 */
	boolean pushSMS(SMS sms);
	
	/**
	 * 
	 * 函数名称：popSMS
	 * 功能描述：出队列
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月7日下午7:27:52
	 */
	boolean popSMS();
	
	/**
	 * 
	 * 函数名称：IsTimeOver
	 * 功能描述:验证是否超过时间周期
	 * 参数说明：
	 * 返回值：boolean 1成功验证2:验证码错误3；验证超时
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月7日下午7:47:36
	 */
	boolean IsTimeOver(SMS sms2);
	
	/**
	 * 
	 * 函数名称：IsQualifiedSMS
	 * 功能描述：验证验证码是否有效
	 * 参数说明：
	 * 返回值：int
	 * 备注：未超时true超时false
	 * 
	 * 作者：joker		时间：2016年7月7日下午7:48:07
	 */
	int IsQualifiedSMS(String Phone, String SMSNumber);
	
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
