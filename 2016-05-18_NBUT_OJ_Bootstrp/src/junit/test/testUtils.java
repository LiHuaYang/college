package junit.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.nbut.entity.User;
import com.nbut.utils.JdbcUtils_DBCP;
import com.nbut.utils.MD5Util;

public class testUtils {

	
	
	
	@Test 
	public void test1 () {
		String mm = MD5Util.MD5Encode("111", "UTF-8");
		String mm1 = MD5Util.MD5Encode("111", "UTF-8");
		String my = MD5Util.MD5Encode("nbut123456", "UTF-8");
		
		
		System.out.println(my);
	}
	
	
	@Test 
	public void test2 () {
		
		String str = ",1000,1001,1002,";
		String[] ss = str.split(",");
		int length = ss.length;
		
		for (int i=0; i<length; i++) {
			System.out.println(ss[i]);
		}
		
	}
	
	
	@Test 
	public void test3 () {
		
		QueryRunner run =  new QueryRunner();getClass();
		String sql = "select * from users where user_id=?";
		User uu = null;
		// public BeanHandler(Class<T> type)
		try {
			uu = run.query(JdbcUtils_DBCP.getConnection(), sql, new BeanHandler(User.class), "13401010407");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(uu.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
