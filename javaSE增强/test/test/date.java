package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class date {

	public static void main(String[] args) {
		// 获取昨天十二点的毫秒值
		// SimpleDateFormat dateForamte = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm");
		// Calendar cc = new GregorianCalendar();
		//
		// cc.add(Calendar.DAY_OF_WEEK, -1); // 加上 -1，昨天
		//
		// cc.set(Calendar.HOUR_OF_DAY, 12); // 设置小时（24 小时计数法）
		// cc.set(Calendar.MINUTE, 0); // 设置分钟
		// cc.set(Calendar.SECOND, 0); // 设置秒钟
		// cc.set(Calendar.MILLISECOND , 0); // 设置毫秒数
		//
		// long yesterDayTimeStramp = cc.getTimeInMillis();
		// System.out.println(yesterDayTimeStramp);
		// System.out.println(dateForamte.format(yesterDayTimeStramp));

		// 获取明天十二点的毫秒值
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_WEEK, 1); // 明天
		calendar.set(Calendar.HOUR_OF_DAY, 12);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime()));

		// 获取去年此刻的毫秒值
		// Calendar ccc = new GregorianCalendar();
		// ccc.add(Calendar.YEAR, -1);
		// long timeStamp = ccc.getTime().getTime();
		// System.out.println(new SimpleDateFormat("yyyy-MM-dd
		// HH:mm").format(ccc.getTime())); // 2015-12-27 16:18

		// 获取某年某月某天现在时间的时间戳
		// int year = 2014;
		// int month = 2;
		// int dayOfMonth = 1;
		//// Calendar cccc = new GregorianCalendar(year, month, dayOfMonth); //
		// 使用有参构造函数时，不传默认为0
		//// System.out.println(new SimpleDateFormat("yyyy-MM-dd
		// HH:mm").format(cccc.getTime()));
		//
		// Calendar cccc = new GregorianCalendar();
		// cccc.set(year, month, dayOfMonth);
		// System.out.println(new SimpleDateFormat("yyyy-MM-dd
		// HH:mm").format(cccc.getTime()));

		// 获取这个学期的有效上课数
		// Calendar startC = new GregorianCalendar(2016, 8, 1);
		// Calendar endC = new GregorianCalendar(2016, 8, 30);
		//// Calendar endC = new GregorianCalendar(2017, 1, 19);
		// int count = 0;
		//
		// while (startC.compareTo(endC) <= 0) {
		// count++;
		//// System.out.println("Today is " + startC.get(Calendar.DAY_OF_WEEK));
		// if (startC.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
		// System.out.println("SATURDAY");
		// }
		// startC.add(Calendar.DAY_OF_MONTH, 1);
		// }
		//
		// System.out.println(new
		// SimpleDateFormat("yyyy-MM-dd").format(startC.getTime()));
		// System.out.println(count); // 141
	}

	public void test() {
		// 1. 把日期转换成java.util.Date对象， 然后调用Date类的getTime方法。
		// 2. 把日期转换成java.util.Calendar对象， 然后调用get(time)方法。
		SimpleDateFormat dateForamte = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cl = new GregorianCalendar();
		int year = 2016;
		int month = 11;
		int date = 26;
		int hourOfDay = 0;
		int minute = 0;
		cl.set(year, month, date, hourOfDay, minute);
		cl.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cl.getTimeInMillis());
		// System.out.println(cl.get(Calendar.MONTH));
		System.out.println(dateForamte.format(cl.getTime()));
		// System.out.println(cl.getTimeInMillis());
	}
}
