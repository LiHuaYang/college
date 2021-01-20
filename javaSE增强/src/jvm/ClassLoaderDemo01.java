package jvm;

class Singleton {
//	private static Singleton instance = new Singleton(); // 情况一
	
	public static int count1;
	public static int count2 = 0;

	private static Singleton instance = new Singleton(); // 情况二
	
	private Singleton() {
		count1++;
		count2++;
	}
	
	public static Singleton getInstance() {
		return instance;
	}
}

public class ClassLoaderDemo01 {

	public static void main(String[] args) {
		Singleton ins = Singleton.getInstance();
		
		System.out.println(ins.count1); 
		System.out.println(ins.count2); 
	}
}





