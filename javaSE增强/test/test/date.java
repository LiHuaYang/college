package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class date {

	public static void main(String[] args) {
		// ��ȡ����ʮ����ĺ���ֵ
		// SimpleDateFormat dateForamte = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm");
		// Calendar cc = new GregorianCalendar();
		//
		// cc.add(Calendar.DAY_OF_WEEK, -1); // ���� -1������
		//
		// cc.set(Calendar.HOUR_OF_DAY, 12); // ����Сʱ��24 Сʱ��������
		// cc.set(Calendar.MINUTE, 0); // ���÷���
		// cc.set(Calendar.SECOND, 0); // ��������
		// cc.set(Calendar.MILLISECOND , 0); // ���ú�����
		//
		// long yesterDayTimeStramp = cc.getTimeInMillis();
		// System.out.println(yesterDayTimeStramp);
		// System.out.println(dateForamte.format(yesterDayTimeStramp));

		// ��ȡ����ʮ����ĺ���ֵ
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_WEEK, 1); // ����
		calendar.set(Calendar.HOUR_OF_DAY, 12);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime()));

		// ��ȡȥ��˿̵ĺ���ֵ
		// Calendar ccc = new GregorianCalendar();
		// ccc.add(Calendar.YEAR, -1);
		// long timeStamp = ccc.getTime().getTime();
		// System.out.println(new SimpleDateFormat("yyyy-MM-dd
		// HH:mm").format(ccc.getTime())); // 2015-12-27 16:18

		// ��ȡĳ��ĳ��ĳ������ʱ���ʱ���
		// int year = 2014;
		// int month = 2;
		// int dayOfMonth = 1;
		//// Calendar cccc = new GregorianCalendar(year, month, dayOfMonth); //
		// ʹ���вι��캯��ʱ������Ĭ��Ϊ0
		//// System.out.println(new SimpleDateFormat("yyyy-MM-dd
		// HH:mm").format(cccc.getTime()));
		//
		// Calendar cccc = new GregorianCalendar();
		// cccc.set(year, month, dayOfMonth);
		// System.out.println(new SimpleDateFormat("yyyy-MM-dd
		// HH:mm").format(cccc.getTime()));

		// ��ȡ���ѧ�ڵ���Ч�Ͽ���
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
		// 1. ������ת����java.util.Date���� Ȼ�����Date���getTime������
		// 2. ������ת����java.util.Calendar���� Ȼ�����get(time)������
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
