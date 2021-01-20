package thread;


/**
 * ���⣺�߳�֮���й������ݣ�������һ���̶߳����ݲ�����һ��ʱ�򣬱��������߳���ռ��ִ��Ȩ��
 * 
 * �����ʹ��ͬ������飬synchronized
 * 
 * synchronized (����) { // �̲߳��� }
 * 
 * ������ͬ�������������߳̿�����ͬ����ִ��
 * û�г��������̣߳���ʹ�ǻ���˵�ǰCPUִ��Ȩ��Ҳ���ܽ�ȥִ�У���Ϊû�л�ȡ��
 * 
 * ͬ����ǰ�᣺
 * 	1. ����߳�
 * 	2. ����߳�ʹ��ͬһ����
 * 	3. 
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��10��9������8:43:57
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
		Thread t1 = new Thread(t02, "��Ʊ�߳� t1"); // 
		Thread t2 = new Thread(t02, "��Ʊ�߳� t2"); // 
		Thread t3 = new Thread(t02, "��Ʊ�߳� t3"); // 
		
		t1.start();
		t2.start();
		t3.start();
	}
//	@Test
//	public void test1() {
//		Ticket03 t02 = new Ticket03();
//		Thread t1 = new Thread(t02, "��Ʊ�߳� t1"); // 
//		Thread t2 = new Thread(t02, "��Ʊ�߳� t2"); // 
//		Thread t3 = new Thread(t02, "��Ʊ�߳� t3"); // 
//		
//		t1.start();
//		t2.start();
//		t3.start();
//	}
}
