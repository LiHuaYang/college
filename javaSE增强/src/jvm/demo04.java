package jvm;


class demo044 {

	public static int aa = 10;
	
	static {
		System.out.println("demo044 static block");
	}
	
	public demo044() {
		System.out.println("constructor demo044");
	}
}


public class demo04 {
	
	public demo04() {
		System.out.println("constructor demo04");
	}
	
	/**
	 *
	 * @author ariclee
	 */
	public static void main(String[] args) {
		System.out.println("demo04 main function");
	}
	
	static {
		System.out.println("demo04 static block");
	}
}
