package com.nbut.bll;

import java.util.List;

import com.nbut.entity.Privilege;
import com.nbut.entity.User;
import net.sf.json.JSONArray;

public interface UserManage {

	/**
	 * 函数名称：login
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月22日下午1:42:56
	 */
	User login(String id, String passwd);
	
	
	/**
	 * 函数名称：register
	 * 功能描述：
	 * 参数说明：
	 * 返回值：User
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月22日下午8:03:26
	 */
	User register(User user);
	
	/**
	 * 
	 * 函数名称：getUserByUserId
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<User>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月23日下午8:41:34
	 */
	User getUserByUserId(String UserId);
	
	/**
	 * 函数名称：getAllPrivilege
	 * 功能描述：得到数据库中所有的权限
	 * 参数说明：
	 * 返回值：JSONArray
	 * 备注：
	 *  不包括m1001、c1000之类
	 * 	包含以下权限：	
	 * 		contest_creator
	 *		administrator
	 *		problem_editor
	 *		source_browser
	 *		http_judge
	 *		password_setter
	 * 
	 * 作者：ariclee		时间：2016年5月25日下午7:58:36
	 */
	JSONArray getAllPrivilege();
	
	/**
	 * 函数名称：addPrivilege
	 * 功能描述：给某个用户增加权限
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月26日下午1:42:45
	 */
	boolean addPrivilege(String user_id, Privilege privilege);

	
	/**
	 * 函数名称：delUserPrivilege
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月31日下午7:46:16
	 */
	boolean delUserPrivilege(String user_id, Privilege privilege);
}