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
		System.out.println("Student �޲�Constructor�����ã�");		
	}	
	
	public Student (String name) {
		System.out.println("Student String��Constructor�����ã�");	
	}
	
	public Student (String name, int age) {
		System.out.println("������캯�������ã�");
	}

	public String getName() {
//		System.out.println("get��������String");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		System.out.println("get��������int");
		this.age = age;
	}


	public int getAge() {
		return age;
	}
	
	public void eat (String food) {
		System.out.println("��" + food);
	}
	
	private void count (int num) {
		System.out.println("��" + num);
	}
	public static void run () {
		System.out.println("��̬�Ĺ��з���");
	}
	
	
}
