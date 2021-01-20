package thread;



/**
 * ���ֹͣһ���߳�--������
 * 
 * ���߳��д��ڶ���״̬�������ȡ�����λ
 * 
 * -- JDK
 * ����߳��ڵ��� Object ��� wait()��wait(long) �� wait(long, int) ������
 * ���߸���� join()��join(long)��join(long, int)��sleep(long) �� sleep(long, int) 
 * �������������裬�����ж�״̬����������������յ�һ�� InterruptedException�� 
 * ------
 * 
 * ��û��û��ָ���ķ�ʽ�����ָ̻߳�������״̬����ʱ����Ҫ���̵߳�״̬�������
 * ǿ�����ָ̻߳�������״̬��
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

























