package com.fenye.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fenye.domain.Student;
import com.fenye.utils.JdbcUtils;

public class StudentDao {
	
	public List<Student> getPage(int startIndex, int pageSize) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from student limit ?,?";
		List<Student> list = new ArrayList<>();
		
		try {
			conn = JdbcUtils.getConnection();
			
			st = conn.prepareStatement(sql);
			st.setInt(1, startIndex);
			st.setInt(2, pageSize);
			rs = st.executeQuery();
			
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
			
				list.add(student);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		
		return list.size() > 0 ? list : null; 
	}

	
	public int getNum() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select count(*) from student";
		int num = 0;
		
		try {
			conn = JdbcUtils.getConnection();
			
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			
			if (rs.next()) {
				num = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		
		return num;
	}
}
