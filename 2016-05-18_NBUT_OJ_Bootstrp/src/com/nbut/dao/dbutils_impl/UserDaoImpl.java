package com.nbut.dao.dbutils_impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nbut.dao.UserDao;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.User;
import com.nbut.utils.MyDBUtils;

import net.sf.json.JSONArray;


/**
 * 用DBUtils实现UserDao接口
 *
 * 作者：ariclee		时间：2016年6月11日下午11:00:01
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User getAModel(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserId(String UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getAllPrivilege() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPrivilege(String user_id, String pivilege) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JSONArray getUserPrivilege(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delUserPrivilege(String user_id, String pivilege) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	// 将数据源作为参数传入框架，框架自动管理连接（获取和关闭）
//	private static QueryRunner queruRunner = new QueryRunner(MyDBUtils.getDataSource());
//	
//	/**
//	 * 函数名称：getModel
//	 * 功能描述：
//	 * 参数说明：
//	 * 返回值：doMain
//	 * 备注：
//	 * 
//	 * 作者：ariclee		时间：2016年6月16日下午2:40:31
//	 */
//	public doMain getModel () {
//		String sql = "";
//		doMain obj = null;
//		
//		try {
//			obj = this.queruRunner.query(sql, new BeanHandler<doMain.class>());
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//
//		} finally {
//			return obj;
//		}
//	}
	
	
	

}
