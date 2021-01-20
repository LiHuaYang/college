package io;

import java.io.FileReader;
import java.io.IOException;

// 1. 注意编码（默认编码，看系统的编码）
// 2. 单个字符读取
// 3. 字符数组读取

public class FileReaderDemo01 {

	public static void main(String[] args) {

		String file = "C:\\test\\readme.txt";
		FileReader reader = null;
		try {
			reader = new FileReader(file);

			// int ch = reader.read(); // 一次读取一个字符，会自动往下读取。

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
//			System.out.println("读取的字符--"+num + "--内容为--" + new String(buf));
			
			char buf[] = new char[1024];
			int num = 0;
			while ((num=reader.read(buf))!=-1) {
				System.out.println("读取的字符--"+num + "--内容为--" + new String(buf, 0, num));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
