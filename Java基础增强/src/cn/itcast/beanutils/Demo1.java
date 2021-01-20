package cn.itcast.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Demo1 {

	/**
	 * ÓÃbeanUtils²Ù×÷bean
	 
	 */
	public static void main(String[] args) throws IllegalAccessException, Exception {
		
		String name = "flx";
		String password = "123";
		String age = "23";
		String email = "flx@sina.com";
		String birthday = "1980-09-09";  //date
		
		Student s = new Student();
		
		//×¢²á×ª»»Æ÷
		ConvertUtils.register(new Converter(){

			public Object convert(Class type, Object value) {  //"1980-09-09"
				
				if(value==null){
					return null;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try {
					date = format.parse((String)value);
				} catch (ParseException e) {
					throw new ConversionException(e);
				}
				return date;
			}
			
			
		}, Date.class);
		
		BeanUtils.setProperty(s, "name", name);
		BeanUtils.setProperty(s, "password", password);
		BeanUtils.setProperty(s, "age", age);  //int
		BeanUtils.setProperty(s, "email", email);
		BeanUtils.setProperty(s, "birthday", birthday);  //string
		
		
		System.out.println(s.getAge());
		System.out.println(s.getBirthday());  //date


	}

}
