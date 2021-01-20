package generic;

import org.junit.Test;

public class Demo01 {
	@Test
	public void testGenericClass() {
		new GenericClassDemo<String>().show("String Type");
		new GenericClassDemo<Integer>().show(10);
		new GenericClassDemo<Person>().show(new Person());
	}
	
	@Test
	public void testGenericMethod() {
		GenericMethodDemo dgm = new GenericMethodDemo();
		dgm.show("String Type");
		dgm.show(10);
		dgm.show(new Person());
	}
	
	@Test 
	public void testGenericStaticMethod() {
		GenericStaticMethod.show("String Type");
		GenericStaticMethod.show(10);
		GenericStaticMethod.show(new Person());
	}
	
	@Test 
	public void testGenericFactoryDemo() {
		GenericFactoryDemo instance = GenericFactoryDemo.getInstance();
		Animal lion = instance.get_qualifier("generic.Lion", Lion.class);
		lion.eat();
//		 Demo01 demo = instance.get_qualifier("generic.Deme01", Demo01.class); // error
	}
}

class GenericClassDemo<T> {
	public void show(T t) {
		System.out.println("GenericClassDemo--show--" + t);
	}
}	


class GenericMethodDemo {
	public <T> void show(T t) {
		System.out.println("GenericMethodDemo--show--" + t);
	}
}

class GenericStaticMethod {
	public static <T> void show(T t) {
		System.out.println("GenericStaticMethod--show--" + t);
	}
}
class Person {
	private String name;
}