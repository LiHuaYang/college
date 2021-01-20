package test;

public class PCTest1 {

	public static void main(String[] args) {
		Resource1 res = new Resource1();
		
		new Thread(new Producer1(res)).start(); // 
		new Thread(new Consumer1(res)).start(); // 
	}
}

class Producer1 implements Runnable {
	private Resource1 res = null;
	public Producer1 (Resource1 res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		while (true) { // ����Ʒ�������ﵽһ��ֵ��ʱ��ֹͣ����
			res.produce();
		}
	}
}

class Consumer1 implements Runnable {
	private Resource1 res = null;
	public Consumer1 (Resource1 res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		while (true) {
			res.consume();
		}
	}
}

class Resource1 {
	private volatile int count = 0;

	public void produce() {
		if(this.count != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (this) {
			System.out.println("������������Ʒ -- " + this.count++);
		}
		notify();
	}
	
	public  void consume() {
		synchronized (this) {
			if (this.count == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("������������Ʒ -- " + this.count--);
		}
		notify();
	}
}





