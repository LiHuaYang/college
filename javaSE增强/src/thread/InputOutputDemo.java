package thread;


/**
 * 线程间的通信：就是不同的线程，共享同种资源，操作资源的方式不一样
 * 
 * 
 * 
 * 注意·：多个线程需要使用同一把锁
 * 
 * 
 * 作者：ariclee		时间：2016年10月10日上午11:49:30
 */
class res {
	String sex;
	String name;
}

class In implements Runnable {
	private res re = null;
	private boolean flag = true;
	
	public In(res re) {
		this.re = re;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (re) {
				if (flag) {
					re.name = "aric";
					re.sex  = "man";
					flag = false;
				} else {
					re.name = "莉莉";
					re.sex  = "女";
					flag = true;
				}
			}
		}
	}
}

class Out implements Runnable {
	private res re ;
	
	public Out(res re) {
		this.re = re;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (re) {
				System.out.println(re.name + "----" + re.sex);
			}
		}
	}
}


public class InputOutputDemo {

	public static void main(String[] args) {
		res re = new res();
		new Thread(new In(re)).start();;
		new Thread(new Out(re)).start();;
	}
}
