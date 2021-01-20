package regex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo03 {
	
	public static void main(String[] args) throws Exception {
		
		// 1. 结果输出文本
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\test\\res.txt", true)));
		BufferedReader bReader = null;
		String line = "";
		// 
		TreeSet set = new TreeSet<String>();
		
		// http://www.faxingzhan.com/mingrenziliao/1733874.html
		for (int j=2; j<=4; j++) {
 			String urlPath = "http://www.faxingzhan.com/mingrenziliao/1733874_" + j + ".html";
 			URLConnection conn = (URLConnection) new URL(urlPath).openConnection();
 			
 			bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
 			
 			while ((line = bReader.readLine()) != null) {
 				String res = getFH(line); // 获取一行中的fh
 				// 将结果缓存
 				if (res != null) {
 					set.add(res);
 					bWriter.write(res);
 					bWriter.newLine();
 					bWriter.flush();
 				}
 			}
 			bReader.close();
 		}
		bWriter.close();
		
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	// 方法命名：这个方法是干什么用的，而不是怎么干
	private static void addCache() {
		
	}
	
	// 方法命名：干什么，而不是怎么干！
	private static String getFH(String strIn) {
		// 
		String reg = "[A-Z]{2,4}-[0-9]{3,4}";		
		List<String> res = new ArrayList<String>();
		
		Pattern pp = Pattern.compile(reg);
		Matcher mm = pp.matcher(strIn);
		String name = null;
		while (mm.find()) {
			name  = mm.group();
			if (name.length() > 0) {
				res.add(name);
				System.out.println("匹配结果--- " + name);
			}
		}
		return name;
	}
}
