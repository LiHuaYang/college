package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

// 1. 读取文件
// 2. 写入文件

public class FileCopyDemo01 {

	public static void main(String[] args) throws Exception {
		
		 demo01();
//		 demo02();
//		 dmeo03();
//		 demo04();
//		 demo05();
//		 demo06();
		
		Properties pro = System.getProperties();
		
		pro.list(System.out);
	}

	/**
	 * 
	 * 1. 什么时候需要将字符流转化为字节流
	 * 
	 * 2. 什么时候需要将字节流转化为字符流
	 * 
	 * 3. 怎么将字节流转化为字符流
	 * 
	 * 4. 怎么将字符流转化为字节流
	 * 
	 * 作者：ariclee 时间：2016年7月15日下午3:12:48
	 */
	public static void demo06() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String line = "";
		// 将键盘录入的文件按照一定的格式存入文本文件
		// InputStream in = System.in;
		//// BufferedInputStream bin = new BufferedInputStream(in);
		// // 用字符流中的readeLine(),需要用到InputStreamReader()
		// InputStreamReader isr = new InputStreamReader(in);
		// BufferedReader breader = new BufferedReader(isr);

		// 如何把字节流转化为字符流，并使用缓冲区
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));

		// 如何把字符流转化为字节流
		// OutputStreamWriter osw = new OutputStreamWriter(new
		// FileOutputStream("C:\\test\\formKeyBoradToUtf-8.txt"),"UTF-8");
		// BufferedWriter bwriter = new BufferedWriter(osw);
		BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(""), "UTF-8"));

		while ((line = breader.readLine()) != null) {
			bwriter.write(line); // 默认不换行
			bwriter.flush();
		}

		if (bwriter != null) {
			bwriter.close();
		}
		if (breader != null) {
			breader.close();
		}
	}

	public static void demo05() throws FileNotFoundException, IOException {
		// 将键盘录入的数据缓存自己的缓冲区，并写入文件
		InputStream in = System.in;
		String file = "C:\\test\\formKeyBorad.txt";
		FileOutputStream out = new FileOutputStream(file);

		int res = 0;
		byte buf[] = new byte[1024 * 4];

		while ((res = in.read(buf)) != -1) {
			// System.out.print((char)res);
			// System.out.println(res);
			// System.out.println(new String (buf, 0, res));
			out.write(buf, 0, res); // 直接写入字节流的话,无需刷新缓冲区
		}
		in.close();
		// out.close();
	}

	// 将数据写入自定义的缓冲区里面，一般大小为1024的整数倍
	public static void demo04() throws FileNotFoundException, IOException {
		String file = "C:\\test\\silme.jpeg";
		String file1 = "C:\\test\\silmeCopy.jpeg";
		FileInputStream in = new FileInputStream(file);
		FileOutputStream out = new FileOutputStream(file1);

		byte[] buf = new byte[1024]; // 使用自定义大小的缓冲区
		int res = 0;

		while ((res = in.read(buf)) != -1) { // 一次读取1024字节的数据
			/**
			 * 一次写如1024字节的数据， 特殊情况，当文件的大小小于1024时候，写入也是1024， 所以写入数据的大小应该为
			 */
			out.write(buf, 0, res);
		}

		in.close();
		out.close();
	}

	// 拷贝文件，需要用到字节流，不要用字符流来拷贝非纯文本文件
	public static void dmeo03() throws FileNotFoundException, IOException {
		// 拷贝图片
		String file = "C:\\test\\silme.jpeg";
		String file1 = "C:\\test\\silmeCopy.jpeg";
		FileInputStream in = new FileInputStream(file);
		FileOutputStream out = new FileOutputStream(file1);

		int res = 0;

		while ((res = in.read()) != -1) {
			out.write(res);
		}

		in.close();
		out.close();
	}

	// 利用缓冲，提高读取和写入的效率
	public static void demo02() throws FileNotFoundException, IOException {
		// 为了提高效率，使用缓冲来实现文件的拷贝
		String file = "C:\\test\\readme.txt";
		String file1 = "C:\\test\\readmeCopy.txt";

		FileReader reader = new FileReader(file);
		BufferedReader buReader = new BufferedReader(reader);

		FileWriter writer = new FileWriter(file1);
		BufferedWriter buWriter = new BufferedWriter(writer);

		String line = "";

		while ((line = buReader.readLine()) != null) {
			buWriter.write(line); // 默认输出没有换行符，需要手动添加换行符
			// 若是在windows操作系统中，换行符为\r\n,两个字节
			buWriter.newLine();
			// buWriter.close();
		}
		buWriter.close();
		buReader.close();
	}

	// 单个字符读取，
	public static void demo01() throws FileNotFoundException, IOException {
		String file = "C:\\test\\test1.txt";
		String file1 = "C:\\test1\\readmeCopy.txt";

		FileReader reader = new FileReader(file);
		FileWriter writer = new FileWriter(file1); // 创建时，无论文件是否存在，都会新建空白文件

		int res = 0;

		// 按字符读取：当读取到文件的末尾时，返回-1
		while ((res = reader.read()) != -1) {
			System.out.println((char) res);

			writer.write(res); // 按单个字符写入文件
		}
		reader.close();
		writer.close();
	}
}

class exception {

	public static void main1(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("demo.txt");
			fw.write("abcdefg");

		} catch (IOException e) {
			System.out.println("catch:" + e.toString());
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
}

class MyObj {
	public int id;
	public String name;
	
	@Override
	public boolean equals(Object obj) {
		MyObj myObj = (MyObj) obj;
 		if (myObj.name == this.name) {
			return true;
		}
 		return false;
	}
}



