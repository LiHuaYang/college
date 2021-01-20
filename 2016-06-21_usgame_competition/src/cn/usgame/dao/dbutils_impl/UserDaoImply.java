package cn.usgame.dao.dbutils_impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.usgame.dao.UserDao;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.User;
import cn.usgame.utils.JdbcUtils_DBCP;
import cn.usgame.utils.TransactionUtil;

public class UserDaoImply implements UserDao {
	
	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils_DBCP.getDataSource());
	
	@Override
	public boolean registerUser(String id,String phone, String password) {
		boolean result = false;
		String sql = "INSERT INTO `bsjw`.`user` ( `userId`,`phonenumber`, `password`) VALUES (? , ? , ?)";
		
		Object[ ] param = {
				id,phone,password
			};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			result = true;
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}
	@Override
	public boolean login(String phone, String password) {
		boolean result = false;
		String sql = "select password from User where phonenumber= ? ";
		Object[ ] param = {
				phone
		};
		try {	
			User user = runerQuery.query(sql, param, new BeanHandler<>(User.class));
			String pw = user.getPassword();
            if(pw.equals(password)) {
            	result = true;
            }			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public User getUser(String phone) {
		User user = null;
		
		String sql = "select * from User where phonenumber= ? ";
		Object[ ] param = {
				phone
		};
		try {
			user = runerQuery.query(sql, param, new BeanHandler<>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public boolean toUser(User user) {
		boolean result = false;
		String sql = "update User set name = ?,sex=?,school=?,grade=?,contactNumber=?,iDcard=?,address=?,motto=? where phonenumber=?";
		Object[ ] param = {
				user.getName(),user.getSex(),user.getSchool(),user.getGrade(),user.getContactNumber(),user.getiDcard(),user.getAddress(),user.getMotto(),user.getPhonenumber()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>=1) {
				result = true;
			}
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean changepw(String new_pw, String phonenumber) {
		boolean result = false;
		String sql = "update User set password = ? where phonenumber=?";
		Object[ ] param = {
				new_pw,phonenumber
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>=1) {
				result = true;
			}
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<ApplyReport> getUserCompetition(String Phonenumber) {
		List<ApplyReport> applyreports = null;
		String sql = "select * from applyreport  where phoneNumber = ?"; 
		Object[] param = {Phonenumber};
		try {
			applyreports = runerQuery.query(sql, param, new BeanListHandler<ApplyReport>(ApplyReport.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applyreports;
	}
	@Override
	public ApplyReport applyreportInfo(String Phonenumber, String applyReportId) {
		ApplyReport  applyreport = null;
		String sql = "select * from applyreport  where phoneNumber = ? and applyReportId= ?"; 
		Object[] param = {Phonenumber,applyReportId};
		try {
			applyreport = runerQuery.query(sql, param, new BeanHandler<>(ApplyReport.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applyreport;
	}
}
