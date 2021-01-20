
package spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

public class HTMLPraser {

	
	@Test
	public void test1() {
		String html = "<html><head><title>First parse</title></head>" + "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		
		Elements elses = doc.getAllElements();
		
		System.out.println(elses.select("title").text());;
	
//		System.out.println(elses.toString());
//		System.out.println("==================================================================");
//		System.out.println(elses.text());
	}
}
