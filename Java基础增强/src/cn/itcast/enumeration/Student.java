package cn.itcast.enumeration;

public class Student {
	private String name;
	private String grade;  //A B C D E
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {  //F
		
		if(!grade.matches("[ABCDE]")){
			throw new RuntimeException("�Բ��𣬴�������Ƿ�����");
		}
		
		this.grade = grade;
	}
	
	
	
	
}
