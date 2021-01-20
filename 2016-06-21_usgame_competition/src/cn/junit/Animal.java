package cn.junit;

public class Animal {

	public String name = "Animal";
	
	public void eat () {
		System.out.println(this.getClass().getName());
		System.out.println(this.name + "--Animal Eat!");
	}
}
