package cn.itcast.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo1 {

	
	//ͨ����ʡapi����bean��name����
	@Test
	public void test1() throws Exception{
		
		Student s = new Student();
		
		PropertyDescriptor pd = new PropertyDescriptor("name",Student.class);
		Method method = pd.getWriteMethod();  //setName()
		method.invoke(s, "flx");
		
		//System.out.println(s.getName());
		method = pd.getReadMethod();   // getName
		String result = (String) method.invoke(s, null);
		System.out.println(result);
		
	}
	
	
	//����bean����������
	@Test
	public void test2() throws Exception{
		
		BeanInfo info = Introspector.getBeanInfo(Student.class);
		PropertyDescriptor pds[] = info.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
		}
		
	}
	
	
}
