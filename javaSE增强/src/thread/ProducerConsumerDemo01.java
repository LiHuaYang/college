package thread;

/**
 * 生产者-消费者：单个生产者和单个消费者
 *
 *
 * 作者：ariclee 时间：2016年10月10日下午1:34:05
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
		System.out.println(Thread.currentThread().getName() + "-- 生产商品编号为----" + this.id);
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
		System.out.println(Thread.currentThread().getName() + "--消费商品编号为------------" + this.id);

		this.flag = false;
		this.notify();
	}
}

// 生产者
class Producer implements Runnable {
	private Resource res;

	public Producer(Resource res) {
		this.res = res;
	}

	@Override
	public void run() {
		int i = 1;
		while (true) {
			res.set("饼干", i++);
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
		
		new Thread(new Producer(res),"生产者1号").start();
		new Thread(new Consumer(res),"消费者1号").start();
	}

}
