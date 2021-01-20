package com.ariclee.main;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * 
 * http://file.api.dbscar.com/auto_logos/1.png
 * 
 * http://file.api.dbscar.com/auto_logos/1.57png
 * 
 * @author ariclee
 */
public class downLoadChe {

	// 1.
	public static void main(String[] args) {

		int length = 157;
		URL realUrl = null;
		FileOutputStream out = null;

		try {
			
			for (int i = 157; i < length; i++) {
				String url = "http://file.api.dbscar.com/auto_logos/" + i + ".png";

				realUrl = new URL(url);
				// �򿪺�URL֮�������
				URLConnection connection = realUrl.openConnection();
				InputStream in = connection.getInputStream();
				out = new FileOutputStream("C:\\test\\carimg\\" + i + ".png");

				byte[] buf = new byte[1024];
				int res = 0;
				while ((res = in.read(buf)) != -1) { // һ�ζ�ȡ1024�ֽڵ�����
					out.write(buf, 0, res);
				}
			}
		} catch (Exception e) {
			System.out.println("error!!" );
		}
	}

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// �򿪺�URL֮�������
			URLConnection connection = realUrl.openConnection();
			// ����ͨ�õ���������
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// ����ʵ�ʵ�����
			connection.connect();
			// ��ȡ������Ӧͷ�ֶ�
			Map<String, List<String>> map = connection.getHeaderFields();
			// �������е���Ӧͷ�ֶ�
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// ���� BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("����GET��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally�����ر�������
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

}
