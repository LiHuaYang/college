package thread;

/**
 * ������-�����ߣ����������ߺ͵���������
 *
 *
 * ���ߣ�ariclee ʱ�䣺2016��10��10������1:34:05
 */

class Resource {
	private String name;
	private int id;
	boolean flag = false;

	public synchronized void set(String name, int id) {
		if (this.flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		this.name = name;
		this.id = id;
		System.out.println(Thread.currentThread().getName() + "-- ������Ʒ���Ϊ----" + this.id);
		this.flag = true;
		this.notify();
	}

	public synchronized void show() {
		if (!this.flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + "--������Ʒ���Ϊ------------" + this.id);

		this.flag = false;
		this.notify();
	}
}

// ������
class Producer implements Runnable {
	private Resource res;

	public Producer(Resource res) {
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

class Consumer implements Runnable {
	private Resource res;

	public Consumer(Resource res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			res.show();
		}
	}

}

public class ProducerConsumerDemo01 {

	public static void main(String[] args) {
		Resource res = new Resource();
		
		new Thread(new Producer(res),"������1��").start();
		new Thread(new Consumer(res),"������1��").start();
	}

}
