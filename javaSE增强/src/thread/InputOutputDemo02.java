package thread;


/**
 * 
 * 等待唤醒机制练习
 * 
 * 
 * wait(), notify(), notifyAll()
 * 都使用在同步中，因为要对持有监视器的线程操作。
 * 
 * 为什么要把这些操作线程的操作定义在Object类中？
 * 因为这些方法在操作线程时，都必须要标识他们所操作的线程的持有锁
 * 只有同一把锁上等待的线程，才能被同一把锁上线程所唤醒
 * 而锁可以是任意对象，所以是公用方法
 * 
 * 作者：ariclee		时间：2016年10月10日上午11:49:30
 */
class res02 {
	String sex;
	String name;
	
	boolean flag = false;
}

class In02 implements Runnable {
	private res02 re = null;
	
	
	public In02(res02 re) {
		this.re = re;
	}
	
	@Override
	public void run() {
		int x = 0;
		while (true) {
			synchronized (re) {
				if (re.flag) {
					try {
						re.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (x==0) {
					re.name = "aric";
					re.sex  = "man";
				} else {
					re.name = "莉莉";
					re.sex  = "女";
				}
				
				x = (x+1) % 2;
				re.flag = true; // 将标识位置为真，说明生产完毕
				re.notify(); // 唤醒
			}
		}
	}
}

class Out02 implements Runnable {
	private res02 re ;
	
	public Out02(res02 re) {
		this.re = re;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (re) {
				if(!re.flag) {
					try {
						re.wait(); // wait(); 不指定是哪个锁的话，默认就是当前线程对象的锁，会出现锁不同的情况
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(re.name + "----" + re.sex);
				re.flag = false;
				re.notify();
			}
		}
	}
}


public class InputOutputDemo02 {

	public static void main(String[] args) {
		res02 re = new res02();
		new Thread(new In02(re)).start();;
		new Thread(new Out02(re)).start();;
	}
}
