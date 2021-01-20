package thread;


/**
 * ���н������
 * 
 * 
 * ����ҳ����߳�����:
 * 	1. ��ȷ��Щ�����Ƕ��߳����д���
 * 	2. ��ȷ��������
 * 	3. ��ȷ���߳����д�������Щ����ǲ�����������
 * 
 * 
 * ͬ�������ֱ�����ʽ:
 * 	1. ͬ�������
 * 	2. ͬ������
 *
 *
 * ע��
 * 	1. ͬ������������this
 * 	2. ��̬������Ӧ�����ǣ����Ӧ���ֽ����ļ�������.class
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��10��9������9:18:12
 */
class Bank {
	private int sum ; // ��������
		
	// ʹ��ͬ�������
	public void add(int num) {
		try {
			Thread.sleep(10); // ģ����ʵ���
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.sum += num;
		System.out.println(Thread.currentThread().getName() + " -- The bank number is : " + sum);
	}
	// ʹ��ͬ������
//	public synchronized void add(int num) {
//		this.sum += num;
//		System.out.println(Thread.currentThread().getName() + " -- The bank number is : " + sum);
//	}
}

class Customer implements Runnable {
	private Bank bank = new Bank(); // ��������
	
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
