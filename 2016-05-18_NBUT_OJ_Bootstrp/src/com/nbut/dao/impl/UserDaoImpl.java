package com.nbut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nbut.dao.UserDao;
import com.nbut.entity.User;
import com.nbut.utils.JdbcUtils_DBCP;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserDaoImpl implements UserDao {

	@SuppressWarnings("finally")
	@Override
	public User getAModel (String id) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		User user = null;
		String sql = "SELECT GROUP_CONCAT(rightstr) as privilege, uu.* from users as uu, privilege as pp where uu.user_id=pp.user_id AND uu.user_id='" + id +"' LIMIT 1";
		try {
			st = conn.createStatement();
			st.executeQuery(sql);
			set = st.getResultSet();
			user = new User(set);
		} catch (SQLException e) {
			throw new RuntimeException("UserDaoImpl--getAModel ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return user;
		}
	}
	
	@SuppressWarnings("finally")
	@Override
	public User register(User user) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "INSERT INTO users (user_id, email,ip,accesstime, password, reg_time, nick, school) values (?,?,?,?,?,?,?,?)";
		PreparedStatement st = null;
		Date now = new Date();
		try {
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setObject(1, user.getUser_id());
			st.setObject(2, user.getEmail());
			st.setObject(3, user.getIp());
			st.setObject(4, now); // 注册时间
			st.setObject(5, user.getPassword());
			st.setObject(6, now); // 注册时间
			st.setObject(7, user.getNick());
			st.setObject(8, user.getSchool());
			if (st.executeUpdate() == 0) {
				user = null;
			}
		} catch (SQLException e) {
			user = null;
			throw new RuntimeException("");
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return user;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public User getUserByUserId(String UserId) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		User user = null;
		String sql = "select u.*,GROUP_CONCAT(p.rightstr) as privilege from users u,privilege p where u.user_id = p.user_id and p.user_id='"+UserId+"'";
		try {
			st = conn.createStatement();
			st.executeQuery(sql);
			set = st.getResultSet();
			user = new User(set);
		} catch (SQLException e) {
			user = null;
			throw new RuntimeException("UserDaoImpl--getUserByUserId ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return user;
		}
	}
	
	@SuppressWarnings("finally")
	public JSONArray getAllPrivilege () {
		Connection conn = JdbcUtils_DBCP.getConnection();
		PreparedStatement st = null;
		ResultSet set = null;
		JSONArray array = new JSONArray();
		String sql = "select * from privilege where rightstr in ('administrator','problem_editor','source_browser','contest_creator','http_judge','password_setter') Order by user_id";
		try {
			st = conn.prepareStatement(sql);
			set = st.executeQuery();
			while (set.next()) {
				JSONObject obj = new JSONObject();
				obj.put("user_id", set.getObject("user_id"));
				obj.put("rightstr", set.getObject("rightstr"));
				array.add(obj);
			}
		} catch (SQLException e) {
			array = null;
			throw new RuntimeException("UserDaoImpl--getAllPrivilege ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return array;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean addPrivilege(String user_id, String privilege) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		PreparedStatement st = null;
		String sql = "INSERT into privilege(user_id,rightstr) value(?,?)";
		boolean flag = true;
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, user_id);
			st.setObject(2, privilege);
			st.execute();
		} catch (SQLException e) {
			flag = false;
			throw new RuntimeException("UserDaoImpl--addPrivilege ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return flag;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<String> getUserPrivilege(String user_id) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		PreparedStatement st = null;
		List<String> out = new ArrayList<String>();
		ResultSet res = null;
		String sql = "SELECT rightstr FROM 	privilege WHERE user_id=?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, user_id);
			res = st.executeQuery();
			while (res.next()) {
				out.add((String)res.getObject("rightstr"));
			}
		} catch (SQLException e) {
			out = null;
			throw new RuntimeException("UserDaoImpl--getUserPrivilege ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, res);
			return out;
		}
	}

	//DELETE FROM 表名称 WHERE 列名称 = 值
	@SuppressWarnings("finally")
	@Override
	public boolean delUserPrivilege(String user_id, String pivilege) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		PreparedStatement st = null;
		String sql = "DELETE FROM privilege WHERE user_id=? and rightstr=?";
		boolean flag = true;
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, user_id);
			st.setObject(2, pivilege);
			int res = st.executeUpdate();
			if(res > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return flag;
		}
	}
}
