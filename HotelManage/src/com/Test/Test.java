package com.Test;

import java.util.HashMap;
import java.util.List;

import com.Dao.CDaoOrder;
import com.Dao.CDaoUser;
import com.Entity.OrderTable;

public class Test {
	
	public static void main(String[] args) {
		CDaoUser cDaouser=new CDaoUser();
		//通过电话号码和密码查询出密码以外的所有用户的信息
//		String userphon="1";
//		String userpassword="1";
//		List<HashMap<String, Object>> result= cDaouser.QueryPhonuserother (userphon,userpassword);
//		System.out.print(result);
		
		
		CDaoOrder cDaoOrder=new CDaoOrder();
		List<OrderTable> result=cDaoOrder.queryorderbytime("2015-12-15", "2015-12-16");
		System.out.print(result);
	}
}
