package com.Tool.sql;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlHelper {
	
	List<String> ProNames;
	/**
	   基本类型、包装类型、String类型
	*/
	private String[] types = {"java.lang.Integer",
		        "java.lang.Double",
		        "java.lang.Float",
		        "java.lang.Long",
		        "java.lang.Short",
		        "java.lang.Byte",
		        "java.lang.Boolean",
		        "java.lang.Char",
		        "java.lang.String",
		        "int","double","long","short","byte","boolean","char","float"};
	 
	public boolean isBasicType (String type) {
		boolean flag = false;
		for (String str : this.types) {
			if (type.equals(str)) {
				flag = true;
				return true;
			}
			else {
				flag = false;
			}
		}
		return flag;
	}
	 
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-3-31下午08:32:23
	 *函数名：getModelPro
	 *功能：遍历实体类的属性，生成数据库属性语句
	 *参数：
	 *返回值：String
	 */
 	public  String getModelPro(Object model) {
		StringBuilder builder = new StringBuilder();
		
		Field[] field = model.getClass().getDeclaredFields();  
		int length = field.length;
		
		for (int i=0; i<length; i++) {
			String name = field[i].getName(); // 获取属性名
			
			String type= field[i].getType().getName(); // 获取属性的数据类型
			
			name = name.substring(0, 1).toUpperCase() + name.substring(1);  // 将属性的首字母大写，方便构造get/set函数
			if (isBasicType(type)) {
				builder.append(name);
				builder.append(",");
			}
		}
		
		builder.setLength(builder.length()-1); // 去掉多余的字符
		return builder.toString();
	}
 	
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
 	
 	public static int getResultSetLength(ResultSet rs){
 		int length = 0;
 		
 		try {
			rs.last();                  // 游标移到最后, 获得rs长度
			length = rs.getRow();
	 		rs.first();                 // 还原游标到rs开头  
		} catch (SQLException e) {
			e.printStackTrace();
		} 
 		
 		
 		return length;
 	}
 	
// 	public SqlHelper (Object model) {
// 		this.ProNames =  new ArrayList<String>();
// 		Field[] field = model.getClass().getDeclaredFields();  
//		int length = field.length;
//		
//		for (int i=0; i<length; i++) {
//			String name = field[i].getName(); // 获取属性名
//			this.ProNames.add(name);
//		}
// 	}
//	public List<String> getProNames() {
//		return ProNames;
//	}
// 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
}
