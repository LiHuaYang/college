package thread;


/**
 * 
 * �ȴ����ѻ�����ϰ
 * 
 * 
 * wait(), notify(), notifyAll()
 * ��ʹ����ͬ���У���ΪҪ�Գ��м��������̲߳�����
 * 
 * ΪʲôҪ����Щ�����̵߳Ĳ���������Object���У�
 * ��Ϊ��Щ�����ڲ����߳�ʱ��������Ҫ��ʶ�������������̵߳ĳ�����
 * ֻ��ͬһ�����ϵȴ����̣߳����ܱ�ͬһ�������߳�������
 * ����������������������ǹ��÷���
 * 
 * ���ߣ�ariclee		ʱ�䣺2016��10��10������11:49:30
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
					re.name = "����";
					re.sex  = "Ů";
				}
				
				x = (x+1) % 2;
				re.flag = true; // ����ʶλ��Ϊ�棬˵���������
				re.notify(); // ����
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
						re.wait(); // wait(); ��ָ�����ĸ����Ļ���Ĭ�Ͼ��ǵ�ǰ�̶߳�����������������ͬ�����
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
