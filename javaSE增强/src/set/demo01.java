package set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 
 * ���ڻ����������ͣ� TreeSet�Զ�����
 * 
 * �����û��Զ����������ͣ�TreeSet��������Զ�����
 * 	����Ҫ���Զ������û��ʵ������ӿڣ�������
 * 
 * ���Ǹ��û��Զ�������ʵ����Comparable�ӿڻ�����TreeSetʵ����Comparator�ӿ�Ҳ��ʵ������
 * 
 * ����TreeSet����ô����������
 *
 */
// TreeSetʵ���Զ�����������

/**
 * ����1��
 * 		ʵ��ĳ���Զ���������ĳ�з�ʽ����Ĺ���
 *
 * ��ʽ1��ʹ�Զ������ʵ��Comparable�ӿ�
 *
 */

/**
 * ����2��
 * 		��ĳ���Զ�����󲻾߱��Ƚ��Եģ����߸ñȽϷ�ʽ�������㵱ǰ����ʱ����ʱ�򣬾���Ҫ��������߱��Ƚ���
 * 
 * ��ʽ2��ʵ��Comparator�ӿڣ�ʵ���Լ��ıȽ�����
 *
 */

/**
 * ����3��
 * 		�ַ�����������
 * 
 * 
 *
 */

public class demo01 {
	/**
	 * 
	 * ���ߣ�ariclee		ʱ�䣺2016��8��26������9:28:25
	 */
	@Test
	public void treeSetDemo01() {
		TreeSet set = new TreeSet();
		set.add(new Student("java01", 13));
		set.add(new Student("java02", 10));
		set.add(new Student("java03", 12));
		set.add(new Student("java04", 10));
		
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	} 
}


class Student implements Comparable<Student> {
	private String name;
	private int age;
	
	public Student (String _name, int _age) {
		this.name = _name;
		this.age = _age;
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
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	// ����������������������ݴ˶�����С�ڡ����ڻ��Ǵ���ָ������
	// ʹStudent������TreeSet��ʵ�ְ�����������
	
	/**
	 * ��Ҫ������ͬʱ�򣬱Ƚϴ�Ҫ����������Ҫ������ͬʱ�������������Ϊһ��
	 */
	@Override
	public int compareTo(Student stu) {
		int res = new Integer(this.age).compareTo(new Integer(stu.getAge()));
		
		// һ��Ҫ�ж���һ�i������˵������������ͬ�������˾���ͬһ����
		if (res == 0) { // �����ߵ�����Ƚϣ����ʱ�����ж����ߵ������Ƿ�һ��
			return this.name.compareTo(stu.getName()); 
		}
		return new Integer(this.age).compareTo(new Integer(stu.getAge()));
	}
}

/**
 * ʵ���Լ��ıȽ��� 
 *
 * ���ߣ�ariclee		ʱ�䣺2016��8��26������9:46:03
 */
class MyStudentCompertor implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int res = new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
		if (res == 0) {
			return o1.getName().compareTo(o2.getName());
		} else {
			return res;
		}
	}
}
