package thread;


/**
 * �̼߳��ͨ�ţ����ǲ�ͬ���̣߳�����ͬ����Դ��������Դ�ķ�ʽ��һ��
 * 
 * 
 * 
 * ע�⡤������߳���Ҫʹ��ͬһ����
 * 
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��10��10������11:49:30
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
					re.name = "����";
					re.sex  = "Ů";
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
