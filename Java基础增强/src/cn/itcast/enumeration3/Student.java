package cn.itcast.enumeration3;

public class Student {
	
	
	private String name;
	private Grade grade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
}

//如何让枚举封装更多的信息（如何让枚举对象拥有自己的属性）
enum Grade{ 
	
	A("100-90"),B("89-80"),C("79-70"),D("69-60"),E("59-0");  //对应的是Grade类的对象  //100-90 89-80

	private String value;
	private Grade(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}

/*
class Grade{
	
	private Grade(){}
	public static Grade A = new Grade();
	public static Grade B = new Grade();
	public static Grade C = new Grade();
	public static Grade D = new Grade();
	public static Grade E = new Grade();
}

*/

enum Demo{  //类 new  demo
	demo;
}


