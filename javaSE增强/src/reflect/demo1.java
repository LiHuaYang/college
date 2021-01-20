package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;

public class demo1 {
	
	
	/**
	 * 1. 可以通过类名直接访问Class，也可以通过类的实例来getClass()
	 * 2. 获取Class的三种方法
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		// Class stu = Class.forName("cn.usgame.domain.Student");
		
		// 通过类--获取简单类名
//		System.out.println("Student.class.getName()--" + Student.class.getSimpleName());
		// 通过类的实例--获取简单类名
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
		
		// 无参数构造函数
//		Constructor cc = class1.getConstructor(null);
//		Object oo = cc.newInstance(null);
		
		// String构造函数
//		Constructor cc = class1.getConstructor(String.class);
//		Object oo = cc.newInstance("Ni");
		
		
		// 私有构造函数
//		Constructor cc = class1.getDeclaredConstructor(null);
//		cc.setAccessible(true); // 暴力反射，设置访问权限
//		Object oo = cc.newInstance(null);
		
		
		// 共有的带多个参数的构造函数的反射
		Constructor cc1 = class1.getDeclaredConstructor(String.class, int.class);
		Object oo1 = cc1.newInstance("小明", 12);
	}

	
	
	@Test
	public void test2 () throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Public  Constructor getConstructor(Class<?>... parameterTypes)
//		Public  Method getMethod(String name, Class<?>... parameterTypes)
//		Public  Field  getField(String name)   public	

		Class class1 = Class.forName(Student.class.getName());
		
		// 共有的一般方法反射
//		Method method = class1.getMethod("eat", String.class);
//		// 调用无参的构造函数
//		// parmeter1： 类的实例
//		// parmeter2： 所要的形参
//		method.invoke(class1.newInstance(), "外卖");
		
		// 私有方法的反射
//		Method method = class1.getDeclaredMethod("count", int.class);
//		method.setAccessible(true);
//		method.invoke(class1.newInstance(), 12);
		
		
		// 静态共有方法的反射
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
		
		// 私有字段的反射
//		Field ff = class1.getDeclaredField("name");
//		ff.setAccessible(true);
//		ff.set(oo, "Nihao1");
		
		// 反射出方法来打印设置好的值
//		Method method = class1.getMethod("getName", null);
//		System.out.println(method.invoke(oo, null));
		
		
		// 拿到类的所有属性
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
