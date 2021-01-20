package regex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo01 {

 	public static void main(String[] args) throws Exception {
// 		URL(String protocol, String host, String file) 
//       根据指定的 protocol 名称、host 名称和 file 名称创建 URL。
 		String reg = "[A-Z]{3,4}-[0-9]{3,4}";
        
 		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\test\\res.txt")));
 		for (int j=2; j<=8; j++) {
 			String urlPath = "http://m.lameshuang.com/fanhao/282_" + j + ".html";

 			URL url = new URL(urlPath);
 			
 			URLConnection conn = (URLConnection) url.openConnection();
 			
 			BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
 			
// 			String fileName = "";
 			
 			String line = "";
 			
 			while ((line = bReader.readLine()) != null) {
 				
 				Pattern pp = Pattern.compile(reg);
 				Matcher mm = pp.matcher(line);
 				String name = null;
 				while (mm.find()) {
 					name  = mm.group();
 					System.out.println("匹配结果--- " + name);
 				}
 				
 				bWriter.write(name);
 				bWriter.flush();
 				
// 				bWriter.write(line);
// 				System.out.println(getfh(line));
// 				bWriter.flush();
 			}
 			
 			bReader.close();
 			bWriter.close();
 		}
 	}
 	
 	
 	public static String getfh (String line) {
 		
 		String reg = "[A-Z]{3,4}";
 		Pattern pp = Pattern.compile(reg);
 		
 		Matcher ma = pp.matcher(line);
 		
 		ma.find();
// 		ma.group();
 		return ma.group();
 	}

 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
}
