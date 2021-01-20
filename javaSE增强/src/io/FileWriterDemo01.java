package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo01 {

	public static void main(String[] args) {
		
		// 创建一个FileWriter对象，初始化时必须明确被操作的文件
		// 若是提供的路径下面没有指定的文件，则新建文件
		// 若是提供的路径下面有指定的的文件，则覆盖文件 // 若是
		String path = "C:\\test\\1.txt";
		
//		String path = "C:\\test1\\1.txt"; // 当指定的文件所在文件夹不存在时候，不会自动创建文件夹
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			// 表示不覆盖文件，在文件末尾处续写文件内容
			// fw = new FileWriter(path, true);
			fw.write("Hello!!");
			
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			// close流需要单独处理异常
			try {
				if (fw!=null) { // 当文件不存在的时候，需要在finally执行之前判断，文件是否存在
					fw.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

// 1. 如何叙写文件，当文件不存在时候，还会创建文件吗，不会

// 2. 如何写入换行符 \r\n

// 


























// 




















