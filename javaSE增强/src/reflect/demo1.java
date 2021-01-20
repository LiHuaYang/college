package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;

public class demo1 {
	
	
	/**
	 * 1. ����ͨ������ֱ�ӷ���Class��Ҳ����ͨ�����ʵ����getClass()
	 * 2. ��ȡClass�����ַ���
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		// Class stu = Class.forName("cn.usgame.domain.Student");
		
		// ͨ����--��ȡ������
//		System.out.println("Student.class.getName()--" + Student.class.getSimpleName());
		// ͨ�����ʵ��--��ȡ������
//		System.out.println("new Student().getClass()--" + new Student().getClass().getSimpleName());
		
		
//		Class class1 = Class.forName("cn.usgame.domain.Student");
//		Class class2 = Student.class;
//		Class class3 = new Student().getClass();
		
	}
	
	@Test
	public void test1 () throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Public  Constructor getConstructor(Class<?>... parameterTypes)
//		Public  Method getMethod(String name, Class<?>... parameterTypes)
//		Public  Field  getField(String name)   public	

	
		Class class1 = Class.forName(Student.class.getName());
		
		// �޲������캯��
//		Constructor cc = class1.getConstructor(null);
//		Object oo = cc.newInstance(null);
		
		// String���캯��
//		Constructor cc = class1.getConstructor(String.class);
//		Object oo = cc.newInstance("Ni");
		
		
		// ˽�й��캯��
//		Constructor cc = class1.getDeclaredConstructor(null);
//		cc.setAccessible(true); // �������䣬���÷���Ȩ��
//		Object oo = cc.newInstance(null);
		
		
		// ���еĴ���������Ĺ��캯���ķ���
		Constructor cc1 = class1.getDeclaredConstructor(String.class, int.class);
		Object oo1 = cc1.newInstance("С��", 12);
	}

	
	
	@Test
	public void test2 () throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Public  Constructor getConstructor(Class<?>... parameterTypes)
//		Public  Method getMethod(String name, Class<?>... parameterTypes)
//		Public  Field  getField(String name)   public	

		Class class1 = Class.forName(Student.class.getName());
		
		// ���е�һ�㷽������
//		Method method = class1.getMethod("eat", String.class);
//		// �����޲εĹ��캯��
//		// parmeter1�� ���ʵ��
//		// parmeter2�� ��Ҫ���β�
//		method.invoke(class1.newInstance(), "����");
		
		// ˽�з����ķ���
//		Method method = class1.getDeclaredMethod("count", int.class);
//		method.setAccessible(true);
//		method.invoke(class1.newInstance(), 12);
		
		
		// ��̬���з����ķ���
		Method method = class1.getDeclaredMethod("run", null);
		method.invoke(null, null);
		
	}
	
	
	@Test
	public void test3 () throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
//		Public  Constructor getConstructor(Class<?>... parameterTypes)
//		Public  Method getMethod(String name, Class<?>... parameterTypes)
//		Public  Field  getField(String name)   public	

		Class class1 = Class.forName(Student.class.getName());
		Object oo = class1.newInstance();
		
		// ˽���ֶεķ���
//		Field ff = class1.getDeclaredField("name");
//		ff.setAccessible(true);
//		ff.set(oo, "Nihao1");
		
		// �������������ӡ���úõ�ֵ
//		Method method = class1.getMethod("getName", null);
//		System.out.println(method.invoke(oo, null));
		
		
		// �õ������������
		Field[] ff1 = class1.getDeclaredFields();
		for (Field f : ff1) {
			f.setAccessible(true);
			
//			System.out.println(f.getType());
//			System.out.println(String.class);
			
			if (f.getType()==String.class) {
//				System.out.println("f.getType()==String.class");
				f.set(oo, "1212");
				System.out.println(f.get(oo));
			}
			if (f.getType()==int.class) {
//				System.out.println("f.getType()==int.class");
				f.set(oo, 11);
				System.out.println(f.get(oo));
			}
		}
	}
	
	
	
	@Test
	public void test4() {
		Student s1 = new Student();
		s1.setAge(10);
		Student s2 = new Student();
		s2.setAge(20);
		
		Class clazz1 = s1.getClass();
		Class clazz2 = s2.getClass();
		
		System.out.println("clazz1--" + clazz1);
		System.out.println("clazz2--"+clazz2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
