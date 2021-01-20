package thread;


/**
 * 
 * 等待唤醒机制练习--代码优化
 * 
 * 
 * 作者：ariclee		时间：2016年10月10日上午11:49:30
 */
class res03 {
	private String sex;
	private String name;
	
	boolean flag = false;
	
	public synchronized void set(String name, String sex) {
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		
		this.flag = true;
		this.notify();
	}
	
	public synchronized void out() {
		if (!this.flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.name + "----" + this.sex);
		this.flag = false;
		this.notify();
	}
}

class In03 implements Runnable {
	private res03 re = null;

	public In03(res03 re) {
		this.re = re;
	}
	
	@Override
	public void run() {
		int x = 0;
		while (true) {
			if (x==0) {
				re.set("aric", "man");
			} else {
				re.set("莉莉", "女");
			}
			x = (x+1) % 2;
		}
	}
}

class Out03 implements Runnable {
	private res03 re ;
	
	public Out03(res03 re) {
		this.re = re;
	}
	
	@Override
	public void run() {
		while (true) {
			re.out();
		}
	}
}


public class InputOutputDemo03 {

	public static void main(String[] args) {
		res03 re = new res03();
		new Thread(new In03(re)).start();;
		new Thread(new Out03(re)).start();;
	}
}
