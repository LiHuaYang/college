package test;

public class ThreadTest2 {
	
	public static void main(String[] args) {
		Example example = new Example();
		
		Thread1 t1 = new Thread1(example);
		Thread1 t2 = new Thread1(example);
		
		new Thread(t1).start();
		new Thread(t2).start();
	}
}

class Example {
	public synchronized void execute() throws Exception {
		for (int i=0; i<20; i++) {
			Thread.sleep(1000);
			System.out.println("hello --" + i);
		}
	}
	public synchronized static void execute2() throws Exception {
		for (int i=0; i<20; i++) {
			Thread.sleep(1000);
			System.out.println("world --" + i);
		}
	}
}

class Thread1 implements Runnable {
	private Example example;
	public Thread1(Example example) {
		this.example = example;
	}
	@Override
	public void run() {
		try {
			example.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class Thread2 implements Runnable {
	private Example example;
	public Thread2(Example example) {
		this.example = example;
	}
	@Override
	public void run() {
		try {
			example.execute2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}














