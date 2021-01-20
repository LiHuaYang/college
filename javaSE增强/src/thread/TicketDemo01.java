package thread;

import org.junit.Test;

class Ticket extends Thread {

	private int ticketNumber = 100; // 3������3��Ʊ��, ������һ����
	
//	private static int ticketNumber = 100; // ��̬����
	
	public Ticket(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (true) {
			if (ticketNumber > 0) {
				System.out.println(Thread.currentThread().getName() + " ==== " + ticketNumber--);
			}
		}
	}
}


public class TicketDemo01 {
	@Test
	public void test1() {
		Thread t1 = new Ticket("��Ʊ�߳� t1");
		Thread t2 = new Ticket("��Ʊ�߳� t2");
		Thread t3 = new Ticket("��Ʊ�߳� t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
	// java.lang.IllegalThreadStateException
	@Test
	public void test2() { 
		Thread t1 = new Ticket("��Ʊ�߳� t1");
		
		t1.start();
		t1.start();
		t1.start();
	}
	
}
