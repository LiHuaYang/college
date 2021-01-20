package thread;



/**
 * 如何停止一个线程--方法二
 * 
 * 当线程中处于冻结状态，不会读取到标记位
 * 
 * -- JDK
 * 如果线程在调用 Object 类的 wait()、wait(long) 或 wait(long, int) 方法，
 * 或者该类的 join()、join(long)、join(long, int)、sleep(long) 或 sleep(long, int) 
 * 方法过程中受阻，则其中断状态将被清除，它还将收到一个 InterruptedException。 
 * ------
 * 
 * 当没有没有指定的方式，将线程恢复到运行状态中来时，需要对线程的状态进行清除
 * 强制让线程恢复到运行状态中
 * 
 * interrupt()
 * 
 * @author ariclee
 */
class Thread2 implements Runnable {

	private boolean flag = true;
	private int num;
	
	public void changeFlag() {
		this.flag = false;
	}
	
	@Override
	public synchronized void run() {
		while (this.flag) {
			System.out.println(Thread.currentThread().getName() + "--Run!");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + "--Exception!");
				this.changeFlag();
			}
		}
	}
}
public class StopTheadDemo02 {

	public static void main(String[] args) throws Throwable {
		Thread2 t1 = new Thread2();
		Thread thread = new Thread(t1);
		Thread thread1 = new Thread(t1);
		thread.start();
		thread1.start();
		
		Thread.sleep(100);
		
		int num = 0;
		while (true) {
			System.out.println(Thread.currentThread().getName() + "---------" + num);
			if(num++ == 1000) {
				thread.interrupt();
				thread1.interrupt();
				
				break;
			}
		}
	}
}

























