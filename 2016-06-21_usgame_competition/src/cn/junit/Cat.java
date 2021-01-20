package cn.junit;

public class Cat extends Animal {


	public String name = "cat";
	
	public void SaJiao() {
		
		System.out.println(this.getClass().getName());
		System.out.println(this.name + "Cat Sa Jiao!");
	}
}
