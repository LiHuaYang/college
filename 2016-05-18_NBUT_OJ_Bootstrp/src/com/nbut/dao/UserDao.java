package com.nbut.dao;

import java.util.List;

import com.nbut.entity.User;
import net.sf.json.JSONArray;

public interface UserDao {

	/**
	 * 函数名称：getAModel
	 * 功能描述：
	 * 参数说明：
	 * 返回值：User
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月22日下午1:46:12
	 */
	User getAModel(String id) ;
	
	/**
	 * 函数名称：register
	 * 功能描述：
	 * 参数说明：
	 * 返回值：User
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月22日下午8:07:22
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
	 * 作者：lujinye		时间：2016年5月23日下午8:48:47
	 */
	User getUserByUserId(String UserId);
	
	
	/**
	 * 函数名称：getAllPrivilege
	 * 功能描述：
	 * 参数说明：
	 * 返回值：JSONArray
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月25日下午7:50:36
	 */
	JSONArray getAllPrivilege ();
	
	/**
	 * 函数名称：addPrivilege
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月26日上午10:05:51
	 */
	boolean addPrivilege (String user_id, String pivilege);
	
	/**
	 * 函数名称：getUserPrivilege
	 * 功能描述：
	 * 参数说明：
	 * 返回值：JSONObject
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月26日下午3:53:59
	 */
	List<String> getUserPrivilege (String user_id);
	
	
	/**
	 * 函数名称：delUserPrivilege
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月31日下午7:42:32
	 */
	boolean delUserPrivilege (String user_id, String pivilege);
}