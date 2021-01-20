package reflect;

import java.util.Date;

public class Student {

	private String name;
	private int age;
	private Date birth;
	
//	private Student(){
//		System.out.println("Private Construct called");
//	};
	
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Student(){
		System.out.println("Student 无参Constructor被调用！");		
	}	
	
	public Student (String name) {
		System.out.println("Student String参Constructor被调用！");	
	}
	
	public Student (String name, int age) {
		System.out.println("多个构造函数被调用！");
	}

	public String getName() {
//		System.out.println("get方法调用String");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		System.out.println("get方法调用int");
		this.age = age;
	}


	public int getAge() {
		return age;
	}
	
	public void eat (String food) {
		System.out.println("吃" + food);
	}
	
	private void count (int num) {
		System.out.println("数" + num);
	}
	public static void run () {
		System.out.println("静态的共有方法");
	}
	
	
}
