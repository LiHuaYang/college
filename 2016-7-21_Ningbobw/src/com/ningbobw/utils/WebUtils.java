package com.ningbobw.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class WebUtils {

	
	/**
	 * 函数名称：CreateRanNumber
	 * 功能描述：生成随机数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月5日下午2:28:16
	 */
	public static String CreateRanNumber(int length) {
		String SecurityNumber = "";
		for (int i = 0; i < length; i++) {
			java.util.Random random = new java.util.Random();	// 定义随机类
			int result = random.nextInt(10);		// 返回[0,10)集合中的整数，注意不包括10
			SecurityNumber = SecurityNumber + Integer.toString(result);
		}
		return SecurityNumber;
	}
	
	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * @return String
	 */ 
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	
	
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	
	
	
	public static void send (PrintWriter out, String data) {
		
		if (out != null & data != null) {
			out.write(data);
			out.flush();
			out.close();
		}
	}
	
	
	
	
	
	
	
	
	
}
