package com.nbut.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import org.junit.Test;
import sun.misc.BASE64Encoder;

public class WebUitls {

	@Test
	public void test() {
		String path = "/2016-05-18_NBUT_OJ/Test/Common/NewFile.css";
		String filename = path.substring(path.lastIndexOf("/"));
		System.out.println(replace(path, "/2016-05-18_NBUT_OJ"));
	}
	
	/**
	 * 函数名称：replace
	 * 功能描述：
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月21日下午2:48:12
	 */
	public static String replace(String id,String where){
	    int index = id.indexOf(where);
	    if(index != -1){
	        id = id.replaceAll(where, "");
	        System.out.println("After id.replaceAll--"+ id);
	    }
	    return id;
	}
	
	/**
	 * 函数名称：isExistColumn
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月21日下午2:48:08
	 */
	public static boolean isExistColumn(ResultSet rs, String columnName) {
		try {
		    if (rs.findColumn(columnName) > 0 ) {
		        return true;
		    } 
		}
		catch (SQLException e) {
			return false;
		}
		return false;
	}
	
	/**
	 * 函数名称：makeToken
	 * 功能描述：
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月22日上午11:55:46
	 */
	public static String makeToken(){  //checkException
		
		String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] =  md.digest(token.getBytes());
			
			//base64编码--任意二进制编码明文字符   
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
}
