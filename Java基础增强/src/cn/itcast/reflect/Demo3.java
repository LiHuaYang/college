package cn.itcast.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

public class Demo3 {
	//反射方法
	
	
	//反射：public void eat()
	@Test
	public void test1() throws Exception{
		
		Person p = new Person();  //
		Class clazz = Class.forName("cn.itcast.reflect.Person");  //完整名称
		Method method = clazz.getMethod("eat", null);  //eat
		method.invoke(p, null);  //eat
	}
	
	//反射：run(String address){
	@Test
	public void test2() throws Exception{
		
		Person p = new Person();  //
		
		Class clazz = Class.forName("cn.itcast.reflect.Person");  //完整名称
		Method method = clazz.getMethod("run", String.class);
		method.invoke(p, "北京");
		
	}
	
	//反射：public void run(String address,int num[],String ss[]){
	@Test
	public void test3() throws Exception{
		
		Person p = new Person();  //
		
		Class clazz = Class.forName("cn.itcast.reflect.Person");  //完整名称
		Method method = clazz.getMethod("run", String.class,int[].class,String[].class);
		method.invoke(p, "上海",new int[]{1,2},new String[]{"1","2"});
	}
	
	
	//反射：public String test(String str) (带返回值)
	@Test
	public void test4() throws Exception{
		
		Person p = new Person();  //
		
		Class clazz = Class.forName("cn.itcast.reflect.Person");  //完整名称
		Method method = clazz.getMethod("test", String.class);
		String result = (String) method.invoke(p, "xxxx");
		System.out.println(result);
	}
	
	//反射：private String test2(String str)  私有方法
	@Test
	public void test5() throws Exception{
		
		Person p = new Person();  //
		Class clazz = Class.forName("cn.itcast.reflect.Person");  //完整名称
		Method method = clazz.getDeclaredMethod("test2", String.class);
		method.setAccessible(true);
		method.invoke(p, "");
	}
	
	//反射：public static String test3(String str){ 静态方法
	@Test
	public void test6() throws Exception{
		
		
		Class clazz = Class.forName("cn.itcast.reflect.Person");  //完整名称
		
		Method method = clazz.getMethod("test3", String.class);
		String result = (String) method.invoke(null, "aaa");
		System.out.println(result);
		
	}
	
	//反射：public static void main(String[] args) {  反射main方法  
	//通过反射调用带数组的方法，要注意处理
	@Test
	public void test7() throws Exception{
		
		
		Class clazz = Class.forName("cn.itcast.reflect.Person");  //完整名称
		
		Method method = clazz.getMethod("main", String[].class);
		method.invoke(null, (Object)new String[]{"1","2"});//main(String args[])
		//method.invoke(null, new Object[]{new String[]{"1","2"}});//main(String args[])
		
		
		//public Object invoke(Object obj, Object... args)  //jdk1.5
		//public Object invoke(Object obj, Object[] args)  //jdk1.4
		
		//public void run(String name,String password)  
		//method.invoke(p,new Object[]{"flx,123"})//1.4
		//method.invoke(p,"flx","123")

		
	}
	
	
	
}
