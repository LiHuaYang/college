package jvm;




class A1 {
	
//	{
//		System.out.println("���캯�������1");
//	}
	
	public A1() {
		System.out.println("A1���캯��");
	}
	
//	static {
//		System.out.println("��̬���캯�������");
//	}
	
	
	private static int b = 2;
	
	private int c = print();
	
	public static int print() {
		System.out.println("b ��ֵΪ: " + b);
		return ++b;
	}
	
	public void getC() {
		System.out.println("c ��ֵΪ: " + this.c);
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
