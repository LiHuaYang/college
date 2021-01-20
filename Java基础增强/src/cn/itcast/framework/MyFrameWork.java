package cn.itcast.framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;

public class MyFrameWork {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader("src/config.txt"));
		String className = br.readLine();
		String methodName = br.readLine();
		
		
		Class clazz = Class.forName(className);
		Method method = clazz.getMethod(methodName, null);
		method.invoke(clazz.newInstance(), null);
		
	
		

	}

}
