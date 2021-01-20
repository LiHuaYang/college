package cn.itcast.enumeration3;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s = new Student();
		s.setGrade(Grade.A);  //Grade
		
		
		String value = Grade.C.getValue();
		System.out.println(value);
	}
}
