package com.nbut.bll.impl;

import java.util.List;
import com.factory.DaoFactory;
import com.nbut.bll.UserManage;
import com.nbut.dao.UserDao;
import com.nbut.entity.Privilege;
import com.nbut.entity.User;
import com.nbut.utils.MD5Util;
import net.sf.json.JSONArray;

public class UserManageImpl implements UserManage {
	
	private UserDao udao = DaoFactory.getInstance().create("com.nbut.dao.impl.UserDaoImpl", UserDao.class);
	private static UserManageImpl uu = new UserManageImpl();
	private UserManageImpl () {}
	public static UserManageImpl getInstance () {
		return uu;
	}
	@Override
	public User login(String id, String passwdIn) {
		// 1. 检验数据库中是否存在此用户
		User uu = null;
		uu = udao.getAModel(id);
		if (uu.getUser_id() == null) {
			return null; // 找不到用户
		}
		// 2. 用户存在
		String pwInDB = uu.getPassword();
		String pw = MD5Util.MD5Encode(passwdIn, "UTF-8");
		if (pwInDB.equals(pw)) {
			return uu;   // 密码正确
		}
		else {
			return null; // 密码不正确
		}
	}
	
	@Override
	public User register(User user) {
		// 1. 检查用户是否为二次注册
		User uu = null;
		uu = udao.getAModel(user.getUser_id());
		if (uu.getUser_id() != null) {
			return null; // 此账号已经存在
		}
		// 2. 开始注册
		String pw = MD5Util.MD5Encode(user.getPassword(), "UTF-8");// MD5加密
		user.setPassword(pw);
		uu = udao.register(user);
		return uu;
	}

	@Override
	public User getUserByUserId(String UserId) {
		return udao.getUserByUserId(UserId);
	}
	
	@Override
	public JSONArray getAllPrivilege() {
		return udao.getAllPrivilege();
	}

	@Override
	public boolean addPrivilege(String user_id, Privilege privilege) {
		// 1. 先要查找该用户是否已经存在该权限
		List<String> list = udao.getUserPrivilege(user_id);
		
		// 1.1 已经存在权限
		if (list.contains(privilege.toString())) {
			return false;
		}
		// 1.2 没有存在权限
		return udao.addPrivilege(user_id, privilege.toString());
	}

	@Override
	public boolean delUserPrivilege(String user_id, Privilege privilege) {
		return udao.delUserPrivilege(user_id, privilege.toString());
	}
	
}
