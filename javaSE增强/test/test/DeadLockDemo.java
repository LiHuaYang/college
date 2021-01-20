package test;

public class DeadLockDemo {

	public void method1() {
		synchronized (Integer.class) {
			System.out.println(Thread.currentThread().getName() + " ��ȡ�� Integer ��");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName() + " ��ȡ�� String ��");
			}
		}
	}
	
	public void method2() {
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName() + " ��ȡ�� String ��");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + " ��ȡ�� Integer ��");
			}
		}
	}
	
	public static void main(String[] args) {
		final DeadLockDemo d1 = new DeadLockDemo();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				d1.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				d1.method2();
			}
		}).start();
	}
}
