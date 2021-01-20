package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ������-�����ߣ�ʹ������������д���루Lock�� V1
 * 
 * Lock - Synchronized
 * Condition, signal() - wait(), notify(), notifyAll()
 * 
 * ���ߣ�ariclee ʱ�䣺2016��10��10������1:34:05
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
			
			System.out.println(Thread.currentThread().getName() + "-- ������Ʒ���Ϊ----" + this.id);
			
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
			
			System.out.println(Thread.currentThread().getName() + "--������Ʒ���Ϊ------------" + this.id);
			this.flag = false;
			condition.signalAll();
			
		} finally {
			lock.unlock();
		}
		
	}
}

// ������
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
				res.set("����", i++);
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
		
		new Thread(new Producer03(res),"������1��").start();
		new Thread(new Producer03(res),"������2��").start();
		new Thread(new Consumer03(res),"������1��").start();
		new Thread(new Consumer03(res),"������2��").start();
	}

}
