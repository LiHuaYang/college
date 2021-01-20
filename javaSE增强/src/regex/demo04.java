package regex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class demo04 {

	public static void main(String[] args) throws Exception {
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		// https://fh4g.com/search?query=EBOD-282
		
		// 1. 结果输出文本
		BufferedReader bReader = null;
		String line = "";
		
		// https://fh4g.com/api/search?page=0&query=IESP-588&_=1468680840219
		String qu = "https://fh4g.com/api/search?page=0&_=1468680840219&query=";

		FileInputStream in = new FileInputStream("C:\\test\\yg.txt");
		bReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

		while ((line = bReader.readLine()) != null) {
			String urlPath = qu + line;
			System.out.println(urlPath);
			
			HttpsURLConnection conn = (HttpsURLConnection) new URL(urlPath).openConnection();
			conn.setSSLSocketFactory(ssf);
			InputStream lianjie = conn.getInputStream();

			readIn(lianjie);
		}
		bReader.close();
	}

	private static void readIn(InputStream in) throws Exception {
		String line = "";
		BufferedReader bReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\test\\res.html", true)));
		
		try {
			while ((line = bReader.readLine()) != null) {
				Gson gson = new Gson();
				
				JsonObject obj = gson.fromJson(line, JsonObject.class);;
				JsonArray json = obj.getAsJsonArray("result");
				JsonObject item = null;
				
				for (int i=0; i<json.size(); i++) {
					item = (JsonObject) json.get(i);
					System.out.println(item.get("maglink").getAsString());
				}
				
				bWriter.write(line);
				bWriter.newLine();
				bWriter.flush();
			}
		} catch (IOException e) {
			System.out.println("Wrong!!!!!!!");
		} finally {
			if (bReader != null) {
				bReader.close();
			} 
			if (bWriter != null) {
				bWriter.close();
			}
		}
	}
}
