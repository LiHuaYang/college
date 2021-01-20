package demo;

public class MsgHandler01 implements Runnable {

	private Object data ;
	private DataResource res;
	
	
	public MsgHandler01(Object data) {
		this.data = data;
	}
	
	public MsgHandler01(DataResource resource) {
		this.res = resource;
	}
	
	private synchronized void show() {
		System.out.println("MsgHandler01-------------------" + this.toString());
		System.out.println(Thread.currentThread().getName() + "---" + data.toString());
	}
	
	private void quchu() {
		// 取出
		
		// 操作
		
		// 放回
		this.res.get();
		
	}
	
	@Override
	public void run() {
//		show();
		quchu();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
