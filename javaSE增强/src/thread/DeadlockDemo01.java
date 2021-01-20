package thread;

class DeadlockTest implements Runnable {
	private boolean flag;
	
	public DeadlockTest(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		if (flag) {
			synchronized (MyLock.locka) {
				System.out.println("if locka");
				synchronized (MyLock.lockb) {
					System.out.println("if lockb");	
				}
			}
		} else {
			synchronized (MyLock.lockb) {
				System.out.println("else lockb");
				synchronized (MyLock.locka) {
					System.out.println("else locka");
				}
			}
		}
	}
}

class MyLock {
	static Object locka = new Object(); // Ëøa
	static Object lockb = new Object(); // Ëøb
}

public class DeadlockDemo01 {
	public static void main(String[] args) {
		new Thread(new DeadlockTest(true)).start();
		new Thread(new DeadlockTest(false)).start();
	}
}














