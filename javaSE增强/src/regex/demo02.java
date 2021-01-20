package regex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo02 {

	
	public static void main(String[] args) throws Exception {
		
		String reg = "[A-Z]{2,4}-[0-9]{3,4}";
//		String strBuf = "AAA-2342";
		String line = "";
		String file = "C:\\test\\5.html";
		StringBuffer strBuf = new StringBuffer();
		
		FileInputStream in = new FileInputStream(file);
		BufferedReader bReader = new BufferedReader(new InputStreamReader(in, "GBK"));
		
		
		while ((line = bReader.readLine()) != null) {
			strBuf.append(line);
			
			Pattern pp = Pattern.compile(reg);
			Matcher mm = pp.matcher(strBuf);
			
			while (mm.find()) {
				System.out.println("Æ¥Åä½á¹û--- " + mm.group());
			}
		}
	}
}
