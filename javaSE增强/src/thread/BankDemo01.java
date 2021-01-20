package thread;


/**
 * 银行金库问题
 * 
 * 
 * 如何找出多线程问题:
 * 	1. 明确哪些代码是多线程运行代码
 * 	2. 明确共享数据
 * 	3. 明确多线程运行代码中哪些语句是操作共享数据
 * 
 * 
 * 同步有两种表现形式:
 * 	1. 同步代码块
 * 	2. 同步函数
 *
 *
 * 注：
 * 	1. 同步函数锁的是this
 * 	2. 静态函数对应的锁是，类对应的字节码文件，类名.class
 * 
 * 作者：ariclee		时间：2016年10月9日下午9:18:12
 */
class Bank {
	private int sum ; // 共享数据
		
	// 使用同步代码块
	public void add(int num) {
		try {
			Thread.sleep(10); // 模拟真实情况
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.sum += num;
		System.out.println(Thread.currentThread().getName() + " -- The bank number is : " + sum);
	}
	// 使用同步函数
//	public synchronized void add(int num) {
//		this.sum += num;
//		System.out.println(Thread.currentThread().getName() + " -- The bank number is : " + sum);
//	}
}

class Customer implements Runnable {
	private Bank bank = new Bank(); // 共享数据
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			this.bank.add(100);
		}
	}
}


public class BankDemo01 {
	public static void main(String[] args) {
		Customer cus = new Customer();
		
		Thread th1 = new Thread(cus, "customer-one");
		Thread th2 = new Thread(cus, "customer-two");
		
		th1.start();
		th2.start();
	}
}
