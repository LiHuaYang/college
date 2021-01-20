package com.ningbobw.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
	public static boolean writeToFile(OutputStream out, InputStream in) {
		boolean flag = true;
		byte[] buf = new byte[1024];
		int len = 0;
		
		try {
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
			
		} finally {
			try {
				if (in != null)   in.close();
				if (out != null)  out.close();
				
			} catch (IOException e) {
				flag = false;
				e.printStackTrace();
			}
		}
		return flag;
	}
}
	
	
