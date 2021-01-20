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

// 1. ��ȡ�ļ�
// 2. д���ļ�

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
	 * 1. ʲôʱ����Ҫ���ַ���ת��Ϊ�ֽ���
	 * 
	 * 2. ʲôʱ����Ҫ���ֽ���ת��Ϊ�ַ���
	 * 
	 * 3. ��ô���ֽ���ת��Ϊ�ַ���
	 * 
	 * 4. ��ô���ַ���ת��Ϊ�ֽ���
	 * 
	 * ���ߣ�ariclee ʱ�䣺2016��7��15������3:12:48
	 */
	public static void demo06() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String line = "";
		// ������¼����ļ�����һ���ĸ�ʽ�����ı��ļ�
		// InputStream in = System.in;
		//// BufferedInputStream bin = new BufferedInputStream(in);
		// // ���ַ����е�readeLine(),��Ҫ�õ�InputStreamReader()
		// InputStreamReader isr = new InputStreamReader(in);
		// BufferedReader breader = new BufferedReader(isr);

		// ��ΰ��ֽ���ת��Ϊ�ַ�������ʹ�û�����
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));

		// ��ΰ��ַ���ת��Ϊ�ֽ���
		// OutputStreamWriter osw = new OutputStreamWriter(new
		// FileOutputStream("C:\\test\\formKeyBoradToUtf-8.txt"),"UTF-8");
		// BufferedWriter bwriter = new BufferedWriter(osw);
		BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(""), "UTF-8"));

		while ((line = breader.readLine()) != null) {
			bwriter.write(line); // Ĭ�ϲ�����
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
		// ������¼������ݻ����Լ��Ļ���������д���ļ�
		InputStream in = System.in;
		String file = "C:\\test\\formKeyBorad.txt";
		FileOutputStream out = new FileOutputStream(file);

		int res = 0;
		byte buf[] = new byte[1024 * 4];

		while ((res = in.read(buf)) != -1) {
			// System.out.print((char)res);
			// System.out.println(res);
			// System.out.println(new String (buf, 0, res));
			out.write(buf, 0, res); // ֱ��д���ֽ����Ļ�,����ˢ�»�����
		}
		in.close();
		// out.close();
	}

	// ������д���Զ���Ļ��������棬һ���СΪ1024��������
	public static void demo04() throws FileNotFoundException, IOException {
		String file = "C:\\test\\silme.jpeg";
		String file1 = "C:\\test\\silmeCopy.jpeg";
		FileInputStream in = new FileInputStream(file);
		FileOutputStream out = new FileOutputStream(file1);

		byte[] buf = new byte[1024]; // ʹ���Զ����С�Ļ�����
		int res = 0;

		while ((res = in.read(buf)) != -1) { // һ�ζ�ȡ1024�ֽڵ�����
			/**
			 * һ��д��1024�ֽڵ����ݣ� ������������ļ��Ĵ�СС��1024ʱ��д��Ҳ��1024�� ����д�����ݵĴ�СӦ��Ϊ
			 */
			out.write(buf, 0, res);
		}

		in.close();
		out.close();
	}

	// �����ļ�����Ҫ�õ��ֽ�������Ҫ���ַ����������Ǵ��ı��ļ�
	public static void dmeo03() throws FileNotFoundException, IOException {
		// ����ͼƬ
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

	// ���û��壬��߶�ȡ��д���Ч��
	public static void demo02() throws FileNotFoundException, IOException {
		// Ϊ�����Ч�ʣ�ʹ�û�����ʵ���ļ��Ŀ���
		String file = "C:\\test\\readme.txt";
		String file1 = "C:\\test\\readmeCopy.txt";

		FileReader reader = new FileReader(file);
		BufferedReader buReader = new BufferedReader(reader);

		FileWriter writer = new FileWriter(file1);
		BufferedWriter buWriter = new BufferedWriter(writer);

		String line = "";

		while ((line = buReader.readLine()) != null) {
			buWriter.write(line); // Ĭ�����û�л��з�����Ҫ�ֶ���ӻ��з�
			// ������windows����ϵͳ�У����з�Ϊ\r\n,�����ֽ�
			buWriter.newLine();
			// buWriter.close();
		}
		buWriter.close();
		buReader.close();
	}

	// �����ַ���ȡ��
	public static void demo01() throws FileNotFoundException, IOException {
		String file = "C:\\test\\test1.txt";
		String file1 = "C:\\test1\\readmeCopy.txt";

		FileReader reader = new FileReader(file);
		FileWriter writer = new FileWriter(file1); // ����ʱ�������ļ��Ƿ���ڣ������½��հ��ļ�

		int res = 0;

		// ���ַ���ȡ������ȡ���ļ���ĩβʱ������-1
		while ((res = reader.read()) != -1) {
			System.out.println((char) res);

			writer.write(res); // �������ַ�д���ļ�
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



