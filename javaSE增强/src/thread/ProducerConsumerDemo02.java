package thread;

/**
 * ������-�����ߣ���������߶��������
 *
 *
 * ���ߣ�ariclee ʱ�䣺2016��10��10������1:34:05
 */

class Resource02 {
	private String name;
	private int id;
	boolean flag = false;

	public synchronized void set(String name, int id) {
		while (this.flag) 
			try { this.wait(); } catch (InterruptedException e) { }
		
		this.name = name;
		this.id = id;
		System.out.println(Thread.currentThread().getName() + "-- ������Ʒ���Ϊ----" + this.id);
		this.flag = true;
		this.notifyAll();
//		this.notify();
	}

	public synchronized void show() {
		while (!this.flag) 
			try { this.wait(); } catch (InterruptedException e) { }
		
		System.out.println(Thread.currentThread().getName() + "--������Ʒ���Ϊ------------" + this.id);

		this.flag = false;
		this.notifyAll();
//		this.notify();
	}
}

// ������
class Producer02 implements Runnable {
	private Resource02 res;

	public Producer02(Resource02 res) {
		this.res = res;
	}

	@Override
	public void run() {
		int i = 1;
		while (true) {
			res.set("����", i++);
		}
	}
}

class Consumer02 implements Runnable {
	private Resource02 res;

	public Consumer02(Resource02 res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			res.show();
		}
	}
}

public class ProducerConsumerDemo02 {

	public static void main(String[] args) {
		Resource02 res = new Resource02();
		
		new Thread(new Producer02(res),"������1��").start();
		new Thread(new Producer02(res),"������2��").start();
		new Thread(new Consumer02(res),"������1��").start();
		new Thread(new Consumer02(res),"������2��").start();
	}

}
