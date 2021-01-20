package cn.itcast.enumeration2;

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

class Grade{
	
	private Grade(){}
	public static Grade A = new Grade();
	public static Grade B = new Grade();
	public static Grade C = new Grade();
	public static Grade D = new Grade();
	public static Grade E = new Grade();
}
