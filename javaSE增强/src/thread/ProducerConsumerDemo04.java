package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 生产者-消费者：使用新特性来重写代码（Lock）V2
 * 
 * Lock - Synchronized
 * Condition, signal() - wait(), notify(), notifyAll()
 * 
 * 作者：ariclee 时间：2016年10月10日下午1:34:05
 */

class Resource04 {
	private String name;
	private int id;
	boolean flag = false;
	
	private Lock lock = new ReentrantLock();
	Condition pro_condition = lock.newCondition();
	Condition con_condition = lock.newCondition();
	
	public void set(String name, int id) throws InterruptedException {
		lock.lock();
		try {
			while (this.flag)
				pro_condition.await();
			this.name = name;
			this.id = id;
			
			System.out.println(Thread.currentThread().getName() + "-- 生产商品编号为----" + this.id);
			
			this.flag = true;
			con_condition.signal();
			
		} finally {
			lock.unlock();
		}
	}

	public void show() throws InterruptedException {
		lock.lock();
		try {
			while (!this.flag)
				con_condition.await();
			
			System.out.println(Thread.currentThread().getName() + "--消费商品编号为------------" + this.id);
			this.flag = false;
			pro_condition.signal();
			
		} finally {
			lock.unlock();
		}
	}
}

// 生产者
class Producer04 implements Runnable {
	private Resource04 res;

	public Producer04(Resource04 res) {
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

class Consumer04 implements Runnable {
	private Resource04 res;

	public Consumer04(Resource04 res) {
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


public class ProducerConsumerDemo04 {
	public static void main(String[] args) {
		Resource04 res = new Resource04();
		
		new Thread(new Producer04(res),"生产者1号").start();
		new Thread(new Producer04(res),"生产者2号").start();
		new Thread(new Consumer04(res),"消费者1号").start();
		new Thread(new Consumer04(res),"消费者2号").start();
	}
}
