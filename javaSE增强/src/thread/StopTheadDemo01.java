package thread;



/**
 * 如何停止一个线程--方法一
 * 
 * 控制循环
 * 
 * @author ariclee
 */
class Thread1 implements Runnable {

	private boolean flag = true;
	private int num;
	
	public void changeFlag() {
		this.flag = false;
	}
	
	@Override
	public void run() {
		while (this.flag) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
public class StopTheadDemo01 {

	public static void main(String[] args) throws Throwable {
		Thread1 t1 = new Thread1();
		new Thread(t1).start();
		new Thread(t1).start();
		
		Thread.sleep(100);
		
		int num = 0;
		while (true) {
			System.out.println(Thread.currentThread().getName() + "---------" + num);
			if(num++ == 1000) {
				t1.changeFlag();
				break;
			}
		}
	}
}

























