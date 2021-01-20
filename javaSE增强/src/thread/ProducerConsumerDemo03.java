package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 生产者-消费者：使用新特性来重写代码（Lock） V1
 * 
 * Lock - Synchronized
 * Condition, signal() - wait(), notify(), notifyAll()
 * 
 * 作者：ariclee 时间：2016年10月10日下午1:34:05
 */

class Resource03 {
	private String name;
	private int id;
	boolean flag = false;
	
	private Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	
	public void set(String name, int id) throws InterruptedException {
		lock.lock();
		try {
			while (this.flag)
				condition.await();
			this.name = name;
			this.id = id;
			
			System.out.println(Thread.currentThread().getName() + "-- 生产商品编号为----" + this.id);
			
			this.flag = true;
			condition.signalAll();
			
		} finally {
			lock.unlock();
		}
	}

	public void show() throws InterruptedException {
		lock.lock();
		try {
			while (!this.flag)
				condition.await();
			
			System.out.println(Thread.currentThread().getName() + "--消费商品编号为------------" + this.id);
			this.flag = false;
			condition.signalAll();
			
		} finally {
			lock.unlock();
		}
		
	}
}

// 生产者
class Producer03 implements Runnable {
	private Resource03 res;

	public Producer03(Resource03 res) {
		this.res = res;
	}

	@Override
	public void run() {
		int i = 1;
		while (true) {
			try {
				res.set("饼干", i++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer03 implements Runnable {
	private Resource03 res;

	public Consumer03(Resource03 res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			try {
				res.show();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ProducerConsumerDemo03 {

	public static void main(String[] args) {
		Resource03 res = new Resource03();
		
		new Thread(new Producer03(res),"生产者1号").start();
		new Thread(new Producer03(res),"生产者2号").start();
		new Thread(new Consumer03(res),"消费者1号").start();
		new Thread(new Consumer03(res),"消费者2号").start();
	}

}
