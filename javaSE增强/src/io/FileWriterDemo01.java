package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo01 {

	public static void main(String[] args) {
		
		// ����һ��FileWriter���󣬳�ʼ��ʱ������ȷ���������ļ�
		// �����ṩ��·������û��ָ�����ļ������½��ļ�
		// �����ṩ��·��������ָ���ĵ��ļ����򸲸��ļ� // ����
		String path = "C:\\test\\1.txt";
		
//		String path = "C:\\test1\\1.txt"; // ��ָ�����ļ������ļ��в�����ʱ�򣬲����Զ������ļ���
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			// ��ʾ�������ļ������ļ�ĩβ����д�ļ�����
			// fw = new FileWriter(path, true);
			fw.write("Hello!!");
			
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			// close����Ҫ���������쳣
			try {
				if (fw!=null) { // ���ļ������ڵ�ʱ����Ҫ��finallyִ��֮ǰ�жϣ��ļ��Ƿ����
					fw.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

// 1. �����д�ļ������ļ�������ʱ�򣬻��ᴴ���ļ��𣬲���

// 2. ���д�뻻�з� \r\n

// 


























// 




















