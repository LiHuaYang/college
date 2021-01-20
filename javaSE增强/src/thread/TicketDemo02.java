 package thread;

import org.junit.Test;

/**
 * 实现创建两种方式之间的区别：
 * 	1. java只支持单继承（继承了Thread就不能继承其他的父类），避免了单继承的局限性
 *
 * 
 * 一种方法是将类声明为 Thread 的子类。该子类应重写 Thread 类的 run 方法 
 * 另一种方法是声明实现 Runnable 接口的类。该类然后实现 run 方法
 * 
 *
 * 作者：ariclee		时间：2016年10月9日下午8:15:19
 */
class Ticket02 implements Runnable  {
	private int ticketNumber = 100; 
	
	@Override
	public void run() {
		while (true) {
			if (ticketNumber > 0) {
				System.out.println(Thread.currentThread().getName() + " ==== " + ticketNumber--);
			}
		}
	}
}
public class TicketDemo02 {
	@Test
	public void test1() {
		Ticket02 t02 = new Ticket02();
		Thread t1 = new Thread(t02, "卖票线程 t1"); // 
		Thread t2 = new Thread(t02, "卖票线程 t2"); // 
		Thread t3 = new Thread(t02, "卖票线程 t3"); // 
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}
