 package thread;

import org.junit.Test;

/**
 * ʵ�ִ������ַ�ʽ֮�������
 * 	1. javaֻ֧�ֵ��̳У��̳���Thread�Ͳ��ܼ̳������ĸ��ࣩ�������˵��̳еľ�����
 *
 * 
 * һ�ַ����ǽ�������Ϊ Thread �����ࡣ������Ӧ��д Thread ��� run ���� 
 * ��һ�ַ���������ʵ�� Runnable �ӿڵ��ࡣ����Ȼ��ʵ�� run ����
 * 
 *
 * ���ߣ�ariclee		ʱ�䣺2016��10��9������8:15:19
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
		Thread t1 = new Thread(t02, "��Ʊ�߳� t1"); // 
		Thread t2 = new Thread(t02, "��Ʊ�߳� t2"); // 
		Thread t3 = new Thread(t02, "��Ʊ�߳� t3"); // 
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}
