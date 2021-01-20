package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class demo05 {
	public static void main(String[] args) throws Exception {

		String name = URLEncoder.encode("if you", "UTF-8");
		URLConnection conn = getSongJson(name);
		printLine(conn.getInputStream());
		
//		getSonglyric("17753288");
		
		
//		System.out.println(sendPost("http://music.163.com/api/search/get/", "s=" + "if you" + "&limit=1&type=1&offset=0"));
	}

	
	
	public static URLConnection getSongJson(String name) throws Exception {
		String path = "http://s.music.163.com/search/get/?type=" + 1 + "&limit=" + 40 + "&s=" + name;

//		path = "http://music.163.com/api/search/get/s=326695&limit=1&type=1&offset=0";
		
		URL url = new URL(path);
		return (URLConnection) url.openConnection();
	}

	
	
	public static String getSonglyric (String songId) {

		
//		lv：值为-1，我猜测应该是判断是否搜索lyric格式
//		kv：值为-1，这个值貌似并不影响结果，意义不明
//		tv：值为-1，是否搜索tlyric格式
//		String url = "http://music.163.com/api/song/lyric?id=" + songId + "&lv=-1&kv=-1&tv=-1";
		// String urlNameString = url + "?" + param;
		String res = HttpRequest.sendGet("http://music.163.com/api/song/lyric", "id=" + songId + "&lv=-1&kv=-1&tv=-1");
		
		System.out.println(res);
		return res;
	}
	public static void printLine(InputStream in) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		String line = "";

		while ((line = bReader.readLine()) != null) {
//			System.out.println("结果---" + line);
			Gson gson = new Gson();
			JsonObject obj = gson.fromJson(line, JsonObject.class);
			JsonObject result = obj.getAsJsonObject("result");
			JsonArray jsonA = result.getAsJsonArray("songs");
			
			for (JsonElement item : jsonA) {
				String musicUrl = item.getAsJsonObject().get("audio").getAsString();
				String songId = item.getAsJsonObject().get("id").getAsString();
				
				System.out.println("歌曲ID--" + songId);
				System.out.println("歌曲链接--" + musicUrl);
			}
		}
		bReader.close();
	} 
	
	
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("Cookie", "2.0.2");
			conn.setRequestProperty("Referer", "http://music.163.com");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("连接音乐服务器异常……正在重试……");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
//			PostAndGet.sendPost(url, param);
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}

 class test {
 public static void main(String[] args) throws UnsupportedEncodingException {
	 //将application/x-www-form-urlencoded字符 转换成普通字符串
//	 String keyWord =URLDecoder.decode("Can%27t%20Feel%20My%20Face","UTF-8");
//	 System.out.println(keyWord);
	
	 //将普通字符串转换 application/x-www-form-urlencoded字符串
	 String urlStr =URLEncoder.encode("410161183" ,"GBK");
	 System.out.println(urlStr);
	 }
 }
