package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * contains�����ײ�ʵ����Object�����equals������
 * ��List�У����ǰ��������Զ��������Ҫ��дequals����
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


// ArrayListʵ��ȥ�أ��Զ������
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

	// ���Ϊtrue����֮��false
	@Override
	public boolean equals(Object obj) {
		
		// ������Ͳ���Student�Ļ�������false
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
    	new Inner().func(); // ��Ϊ��ͬһ�����У�Outter��
    }
}


class test {
	public static void main(String[] args) {
//		new Outter1().new Inner1().func(); // �����ܷ��ʵ� Inner1 �ֶΣ���Ϊ�� private��
	}
}



