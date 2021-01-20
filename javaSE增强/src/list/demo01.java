package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * contains方法底层实现是Object对象的equals，所以
 * 在List中，若是包含的是自定义对象，需要重写equals方法
 * 
 */

// ArrayList

public class demo01 {

	public static void main(String[] args) {
//		ArrayList list = new ArrayList<String>();
//		list.add(new Student("java01", 10));
//		list.add(new Student("java02", 11));
//		list.add(new Student("java03", 12));
//		list.add(new Student("java03", 12));
//		System.out.println(quChong(list));
		
		List list11 = null;
		Vector vector = null;
		
		int i = 0;
		int j = 0;
		
		System.out.println(i++); // 0
		System.out.println(++j); // 1
		
		
		Thread t = null;
	}
	// 
	public static ArrayList quChong(ArrayList list) {
		ArrayList temp = new ArrayList();
		
		Iterator it =  list.iterator(); 
		while (it.hasNext()) {
			Object item = it.next();
			if (!(temp.contains(item))) {
				temp.add(item);
			}
		}
//		for(Iterator it = al.iterator(); it.hasNext() ; )
//		{
//			sop(it.next());
//		}
		return temp;
	}
}


// ArrayList实现去重（自定义对象）
class Student {
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

	// 相等为true，反之，false
	@Override
	public boolean equals(Object obj) {
		
		// 如果类型不是Student的话，返回false
		if (!(obj instanceof Student)) {
			return false;
		}
		Student stu = (Student) obj;
		if (this.name==stu.getName() && this.age==stu.getAge()) {
			return true;
		}
		return false;
//		return this.name==stu.getName() && this.age==stu.getAge();
	}
}


class Outter {
    private static class Inner {
        public void func() {
        }
    }
    
    public static void main(String[] args) {
//        new Outter().new Inner().func();
    	new Outter.Inner().func();
    	new Inner().func(); // 因为在同一个域中（Outter）
    }
}


class test {
	public static void main(String[] args) {
//		new Outter1().new Inner1().func(); // 并不能访问到 Inner1 字段，因为是 private的
	}
}



