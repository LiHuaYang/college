package demo;

import java.util.concurrent.ArrayBlockingQueue;

public class DataResource {
	
	private static ArrayBlockingQueue abq = new ArrayBlockingQueue<String>(1000);
	private static DataResource instance = new DataResource();
	
	private DataResource() {}
	
	public static DataResource getInstance() {
		return instance;
	}
	
	public synchronized void get() {
		System.out.print(Thread.currentThread().getName()+"--当前数组元素个数 : " + this.abq.size() + " || ");
		System.out.println(Thread.currentThread().getName()+"--当前正在移除的数组元素 : " + this.abq.poll());
	}
	
	public void set(Object obj) {
		try {
			this.abq.put(obj);
			
		} catch (InterruptedException e) {
			System.out.println("------------------------------------------------------DataResource Exception----------------------------------------------------------------");
			e.printStackTrace();
		} // 阻塞式方法
	}
}
