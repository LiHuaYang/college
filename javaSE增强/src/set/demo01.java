package set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 
 * 对于基本数据类型： TreeSet自动排序
 * 
 * 对于用户自定义数据类型：TreeSet不会进行自动排序。
 * 	所以要是自定义对象没有实现排序接口，或者是
 * 
 * 若是该用户自定义类型实现了Comparable接口或者是TreeSet实现了Comparator接口也能实现排序
 * 
 * 告诉TreeSet该怎么样进行排序
 *
 */
// TreeSet实现自定义对象的排序

/**
 * 需求1：
 * 		实现某个自定义对象具有某中方式排序的功能
 *
 * 方式1：使自定义对象，实现Comparable接口
 *
 */

/**
 * 需求2：
 * 		当某个自定义对象不具备比较性的，或者该比较方式并不满足当前需求时，这时候，就需要集合自身具备比较性
 * 
 * 方式2：实现Comparator接口（实现自己的比较器）
 *
 */

/**
 * 需求3：
 * 		字符串长度排序
 * 
 * 
 *
 */

public class demo01 {
	/**
	 * 
	 * 作者：ariclee		时间：2016年8月26日下午9:28:25
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
	
	// 负整数、零或正整数，根据此对象是小于、等于还是大于指定对象
	// 使Student对象在TreeSet中实现按照年龄排序
	
	/**
	 * 主要条件相同时候，比较次要条件，当次要条件相同时，两个对象就认为一致
	 */
	@Override
	public int compareTo(Student stu) {
		int res = new Integer(this.age).compareTo(new Integer(stu.getAge()));
		
		// 一定要判断这一歩，不是说两个人年龄相同，两个人就是同一个人
		if (res == 0) { // 当两者的年龄比较，相等时，则判断两者的名字是否一致
			return this.name.compareTo(stu.getName()); 
		}
		return new Integer(this.age).compareTo(new Integer(stu.getAge()));
	}
}

/**
 * 实现自己的比较器 
 *
 * 作者：ariclee		时间：2016年8月26日下午9:46:03
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
