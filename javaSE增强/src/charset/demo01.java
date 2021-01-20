package charset;

import java.nio.charset.Charset;
import org.junit.Test;

public class demo01 {

	public static void main(String[] args) {
		
		 System.out.println("��ǰJRE��" + System.getProperty("java.version")); 
         System.out.println("��ǰJVM��Ĭ���ַ�����" + Charset.defaultCharset()); 
         
         System.out.println(System.getProperty("file.encoding"));  
         System.out.println(System.getProperty("user.language")); 
         
         Object obj = null;
	}
	
	public static String bytesToHexString(byte[] src){   
	    StringBuilder stringBuilder = new StringBuilder("");   
	    if (src == null || src.length <= 0) {   
	        return null;   
	    }   
	    for (int i = 0; i < src.length; i++) {   
	        int v = src[i] & 0xFF;   
	        String hv = Integer.toHexString(v);   
	        if (hv.length() < 2) {   
	            stringBuilder.append(0);   
	        }   
	        stringBuilder.append(hv);   
	    }   
	    return stringBuilder.toString();   
	} 
	
	public static void printBytes(byte[] bs) {
		for (byte b : bs) {
			System.out.print(b + ",");
		}
		System.out.println();
	}
	
	@Test
	public void test1() throws Exception {
		/**
		 * ��jvm�еı���һ����һ���ģ�����unicode��ֻ��ȡ������ʱ��
		 * ���õı��벻һ����
		 * 
		 * UTF-8��unicode��һ��formate����ͷ����Ǻã�����ַ�ռ��λ
		 * 
		 */
		String utfStr = new String("����".getBytes(), "GBK"); // ��GBK��ʽ����������JBK�ķ�ʽȥ��
		String gbkStr = new String("����".getBytes("UTF-8"), "UTF-8"); // ����UTF-8��ʽ����������UTF-8�ķ�ʽȥ��
		
		System.out.println(utfStr);
		System.out.println(gbkStr);
		
		System.out.println("---------------------");
		printBytes(utfStr.getBytes());
		printBytes(utfStr.getBytes("GBK"));
		printBytes(utfStr.getBytes("UTF-8"));
		printBytes(utfStr.getBytes("UTF-16"));
		
		System.out.println("---------------------");
		printBytes(gbkStr.getBytes());
		printBytes(gbkStr.getBytes("GBK"));
		printBytes(gbkStr.getBytes("UTF-8"));
		printBytes(gbkStr.getBytes("UTF-16"));
		
		System.out.println("---------------------");
		printBytes("����".getBytes());
		printBytes("����".getBytes("GBK"));
		printBytes("����".getBytes("UTF-8"));
		printBytes("����".getBytes("UTF-16"));
		
//		System.out.println(utfStr.toCharArray());
//		System.out.println(gbkStr.toCharArray());
		
		System.out.println("---------------------");
		System.out.println(bytesToHexString(utfStr.getBytes()));
		System.out.println(bytesToHexString(gbkStr.getBytes()));
		
		System.out.println("---------------------");
		System.out.println(bytesToHexString(utfStr.getBytes("UTF-8")));
		System.out.println(bytesToHexString(gbkStr.getBytes("UTF-8")));
		
//		String str = "�й�"; // unicode
//		
//		System.out.println(str.getBytes()); // û����ʾ��ָ�����룬ʹ��windowsƽ̨Ĭ�ϵı���GBK
//		System.out.println(str.getBytes("UTF-8"));
		
		
	}
	
	@Test
	public void test2() {
		String str = "����";
		
		byte[] bs = str.getBytes();
		byte[] bs1 = str.getBytes();
		
		for (byte b:bs) {
			System.out.println(b);
		}
		System.out.println("---------------------");
		for (byte b:bs1) {
			System.out.println(b);
		}
		
		System.out.println("---------------------");
		System.out.println(str.getBytes());
		System.out.println(str.getBytes());
		
//		System.out.println(str.getBytes().toString());
//		
//		System.out.println("����".getBytes());
//		System.out.println("����".getBytes());
	}
	
	@Test
	public void test3() {
		String str1 = "HelloWorld";
		String str2 = "HelloWorld";
		
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
	}
	
	@Test
	public void test4() throws Exception {
		String str1 = "Hello�й�";
		
		printBytes(str1.getBytes());
		printBytes(str1.getBytes("UTF-8"));
		printBytes(str1.getBytes("UTF-16"));
		printBytes(str1.getBytes("ISO-8859-1"));
	}
	
	
	@Test
	public void test5() throws Exception {
		String str = "Hello�й�";
		
		String str1 = new String(str.getBytes("GBK"), "GBK"); // 
		String str2 = new String(str.getBytes("UTF-8"), "UTF-8");
		
//		printBytes(str1.getBytes("ISO-8859-1"));
//		printBytes(str2.getBytes("ISO-8859-1"));
		
		System.out.println(str1);
		System.out.println(str2);
	}
	
	
	
	
	
	
	
	
	 
}
