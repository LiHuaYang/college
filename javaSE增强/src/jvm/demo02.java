package jvm;




class A1 {
	
//	{
//		System.out.println("构造函数代码块1");
//	}
	
	public A1() {
		System.out.println("A1构造函数");
	}
	
//	static {
//		System.out.println("静态构造函数代码块");
//	}
	
	
	private static int b = 2;
	
	private int c = print();
	
	public static int print() {
		System.out.println("b 的值为: " + b);
		return ++b;
	}
	
	public void getC() {
		System.out.println("c 的值为: " + this.c);
	}
}
public class demo02 {
	
	public static void main(String[] args) {
		A1 a = new A1();
//		A1 a1 = new A1();
		
		a.getC(); // 3
//		a1.getC(); // 4
	}
}
