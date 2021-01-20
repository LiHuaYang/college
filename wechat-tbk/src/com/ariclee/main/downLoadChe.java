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
				// 打开和URL之间的连接
				URLConnection connection = realUrl.openConnection();
				InputStream in = connection.getInputStream();
				out = new FileOutputStream("C:\\test\\carimg\\" + i + ".png");

				byte[] buf = new byte[1024];
				int res = 0;
				while ((res = in.read(buf)) != -1) { // 一次读取1024字节的数据
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
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
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
