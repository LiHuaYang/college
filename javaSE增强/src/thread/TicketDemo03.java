package thread;


/**
 * 问题：线程之间有共享数据，当其中一个线程对数据操作到一半时候，被其他的线程抢占了执行权。
 * 
 * 解决：使用同步代码块，synchronized
 * 
 * synchronized (对象) { // 线程操作 }
 * 
 * 对象如同锁，持有锁的线程可以在同步中执行
 * 没有持有锁的线程，即使是获得了当前CPU执行权，也不能进去执行，因为没有获取锁
 * 
 * 同步的前提：
 * 	1. 多个线程
 * 	2. 多个线程使用同一个锁
 * 	3. 
 * 
 * 作者：ariclee		时间：2016年10月9日下午8:43:57
 */
class Ticket03 implements Runnable  {
	private int ticketNumber = 100; 
	private Object obj = new Object();
	
	@Override
	public void run() {
		while (true) {
			synchronized (obj) {
				if (ticketNumber > 0) {
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " ==== " + ticketNumber--);
				}
			}
		}
	}
}
public class TicketDemo03 {
	
	public static void main(String[] args) {
		Ticket03 t02 = new Ticket03();
		Thread t1 = new Thread(t02, "卖票线程 t1"); // 
		Thread t2 = new Thread(t02, "卖票线程 t2"); // 
		Thread t3 = new Thread(t02, "卖票线程 t3"); // 
		
		t1.start();
		t2.start();
		t3.start();
	}
//	@Test
//	public void test1() {
//		Ticket03 t02 = new Ticket03();
//		Thread t1 = new Thread(t02, "卖票线程 t1"); // 
//		Thread t2 = new Thread(t02, "卖票线程 t2"); // 
//		Thread t3 = new Thread(t02, "卖票线程 t3"); // 
//		
//		t1.start();
//		t2.start();
//		t3.start();
//	}
}
