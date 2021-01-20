package io;

import java.io.FileReader;
import java.io.IOException;

// 1. ע����루Ĭ�ϱ��룬��ϵͳ�ı��룩
// 2. �����ַ���ȡ
// 3. �ַ������ȡ

public class FileReaderDemo01 {

	public static void main(String[] args) {

		String file = "C:\\test\\readme.txt";
		FileReader reader = null;
		try {
			reader = new FileReader(file);

			// int ch = reader.read(); // һ�ζ�ȡһ���ַ������Զ����¶�ȡ��

			// while (true) {
			// int ch = reader.read();
			// if (ch == -1) {
			// break;
			// }
			// System.out.println((char)ch);
			// }

//			int ch = 0;
//
//			// 
//			while ((ch = reader.read()) != -1) {
//				System.out.println((char) ch);
//			}
			
//			char buf[] = new char[1024];
//			
//			int num = reader.read(buf);
//			
//			System.out.println("��ȡ���ַ�--"+num + "--����Ϊ--" + new String(buf));
			
			char buf[] = new char[1024];
			int num = 0;
			while ((num=reader.read(buf))!=-1) {
				System.out.println("��ȡ���ַ�--"+num + "--����Ϊ--" + new String(buf, 0, num));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
