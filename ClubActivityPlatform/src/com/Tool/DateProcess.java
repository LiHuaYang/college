package com.Tool;

public class DateProcess {
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-11-21����01:20:04
	 *��������getintDate
	 *���ܣ���ʱ��ת��int���ͣ��������Ƚ�
	 *������@param time
	 *������@return 
	 *����ֵ��int
	 */
	public static int getintDate(String time){
		String[] spltime1=time.split(" ");
		String[] spltime2=spltime1[0].split("-");
		int newtime=Integer.parseInt(spltime2[0]+spltime2[1]+spltime2[2]);
		return newtime;
	}
}
