package jvm;




class AA {
	public AA() {
		System.out.println("constructor AA");
	}
}

class BB {
	
	public BB() {
		System.out.println("constructor BB");
	}
	
	AA aa = new AA();
}

public class demo05 {

	public demo05() {
		System.out.println("consturctor demo05");
	}
	
	public static void main(String[] args) {
		BB bb = new BB();
	}
}
