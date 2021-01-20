package com.Tool;

public class DateProcess {
	/**
	 * 
	 *作者：movie
	 *时间：2015-11-21下午01:20:04
	 *函数名：getintDate
	 *功能：把时间转成int类型，用于做比较
	 *参数：@param time
	 *参数：@return 
	 *返回值：int
	 */
	public static int getintDate(String time){
		String[] spltime1=time.split(" ");
		String[] spltime2=spltime1[0].split("-");
		int newtime=Integer.parseInt(spltime2[0]+spltime2[1]+spltime2[2]);
		return newtime;
	}
}
