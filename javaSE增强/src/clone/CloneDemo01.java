package clone;


class Student implements Cloneable {
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Student1 implements Cloneable {
	private String name;
	private int age;
	private Teacher t;
	
	public Teacher getT() {
		return t;
	}
	public void setT(Teacher t) {
		this.t = t;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student1 s1 = (Student1)super.clone();
		s1.setT((Teacher) this.getT().clone());
		
		return s1;
	}
	
}

class Teacher implements Cloneable {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
public class CloneDemo01 {

	public static void main(String[] args) throws Throwable {
		// 简单类的clone（无需重写父类的clone()）
//		Student s1 = new Student();
//		s1.setName("zhangsan");
//		s1.setAge(12);
//		
//		Student s2 = (Student) s1.clone();
//		System.out.println(s2.getName());
//		System.out.println(s2.getAge());
		
		// 带引用类的clone（需要重写父类的clone()）
		Teacher t1 = new Teacher();
		t1.setName("teacher1");
		t1.setAge(13);
		
		Student1 ss1 = new Student1();
		ss1.setT(t1);
		ss1.setName("zhangsan");
		ss1.setAge(16);
		
		Student1 sss1 = (Student1)ss1.clone();
		
		t1.setName("teacher2");
		
		System.out.println(ss1.getT().getName());
		System.out.println(sss1.getT().getName());
	}
	
}
