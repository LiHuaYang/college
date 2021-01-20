package regex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class QQBiaoQingDemo {
	/**
	 * 0. 获取请求网页内容，使用Url  Connection
	 * 
	 * 1. 获取图片的链接地址，使用正则表达式
	 * 
	 * 2. 图片地址处理，去除多余的地址
	 * 
	 * 3. 将图片地址写入文本，
	 * 
	 * 4. 读取图片地址文本文件
	 * 
	 * 5. 下载图片
	 * 
	 * 作者：ariclee		时间：2016年9月1日下午9:23:45
	 */
	public static void main(String[] args) throws Exception {
		String url = "http://www.zhuangbi.info/?page=";
		List<String> res = new ArrayList<String>();
		
		for (int i=1; i<=51; i++) {
			String html = readIntRes(url + i);
			List<String> picUrl = getImgUrlList(html);
			res.addAll(urlHandle(picUrl));
			showList(picUrl); // 
			// writeFile(picUrl);
		}
//		downLoadQQBq("C:\\test\\qqBq111.html");
	}


	public static List<String> urlHandle(List<String> picUrl) {
		for (int i=0; i<4; i++) {
			picUrl.remove(0);
			picUrl.remove(picUrl.size()-1);
		}
		return picUrl;
	}
	
	public static String readIntRes(String fileUrl) throws Exception {
		URLConnection conn = (URLConnection) new URL(fileUrl).openConnection();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String line = "";
		StringBuilder builder = new StringBuilder();
		while ((line = bReader.readLine()) != null) {
			builder.append(line);
		}
		bReader.close();
		return builder.toString();
	}
	
	public static void downLoadQQBq (String picUrlTextPath) throws Exception {
		BufferedReader bufferIn = new BufferedReader(new FileReader(picUrlTextPath));
		byte out[] = new byte[1024];
		int res = 0;
		String line = null;
		
		int i = 0;
		while ((line = bufferIn.readLine()) != null) {
			String name = line.substring(line.lastIndexOf("/s") + 1);
			URLConnection conn = (URLConnection) new URL(line).openConnection();
			InputStream fileIn = conn.getInputStream();
			FileOutputStream fileWriter = new FileOutputStream("C:\\test\\qqbq\\" + name);
			
			while ((res=fileIn.read(out)) != -1) {
				fileWriter.write(out, 0, res);
			}
		}
	}
	public static String readLocalRes(String filePath) throws Exception {
		FileReader input = new FileReader(filePath);
		BufferedReader buffIn = new BufferedReader(input);

		String line = "";
		StringBuilder builder = new StringBuilder();

		while ((line = buffIn.readLine()) != null) {
			builder.append(line);
		}

		buffIn.close();
		return builder.toString();
	}
	
	public static String writeFile(List<String> picUrls) throws Exception {
		String fileDestination = "C:\\test\\qqBq111.html";
		BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(fileDestination, true));

		for (Iterator it = picUrls.iterator(); it.hasNext(); ) {
			bufferWriter.write((String)it.next());
			bufferWriter.newLine();
		}
		
		bufferWriter.close();
		
		return fileDestination;
	}
	
	public static List<String> getImgUrlList(String htmlStr) {
		String img = "";
		Pattern p_image;
		Matcher m_image;
		List<String> pics = new ArrayList<String>();

		String regEx_img = "<img.*src=(.*?)[^>]*?>"; // 图片链接地址
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr);
		while (m_image.find()) {
			img = img + "," + m_image.group();
			Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); // 匹配src
			while (m.find()) {
				pics.add(m.group(1));
			}
		}
		return pics;
	}
	
	
	public static void showList(List<String> list) {
		for (Iterator it=list.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}
	}
	
	@Test
	public void test111 () {
		String url = "http://zhuangbi.idagou.com/i/2016-08-31-188f4cc8e0f726bbafcb6bfcfcccaa75.png";
		String name = url.substring(url.lastIndexOf("/") + 1);
		
		System.out.println(name);
	}
}
