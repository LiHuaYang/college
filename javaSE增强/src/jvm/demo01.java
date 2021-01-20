package jvm;



class A {
	public A() {
		System.out.println("In a constructor");
	}
	static {
		System.out.println("In  a"); // 3
	}
}

class demo {
	
	public demo() {
		System.out.println("In demo constructor");
	}
	
	static {
		System.out.println("Before new a"); // 1
	}

	
	A a = new A();

	static {
		System.out.println("After new a"); // 2
	}
	
}
public class demo01 {

	public static void main(String[] args) {
		demo d = new demo();
	}
}
