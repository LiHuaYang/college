package read_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo02")
public class demo02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public demo02() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 错误，在网站发布以后，根本没有src目录
//		FileInputStream file = new FileInputStream("src/1.properties");
		
		// 相对路径--相对谁？代码有谁运行，这个类是谁运行，JVM运行，哪个目录下面起的JVM--tomcat--bin目录
		FileInputStream file = new FileInputStream("1.properties");
		
		// 在做web工程时，不建议用传统方式来读取文件数据
		test1();
		
	}
	
	// 读取src下面的资源文件--方式1--传统
	public void test1() throws IOException {
		InputStream in = this.getServletConfig().getServletContext().getResourceAsStream("/WEB-INF/classes/O1.properties");
		
		Properties pro = new Properties();
		pro.load(in);
		
		String name = pro.getProperty("name");
		String age = pro.getProperty("age");
	}
	
	// 读取src下面的资源文件--方式2--类装载器
	// 1. 读取时候，将文件写入内存，若是文件过大，JVM内存溢出
	// 2. 只转载一次，即使这段代码在项目中的很多地方都出现
	public void test2() throws IOException {
		
		ClassLoader class1 = demo02.class.getClassLoader();
		InputStream in = class1.getResourceAsStream("O1.properties");
		
		Properties pro = new Properties();
		pro.load(in);
		
		String name = pro.getProperty("name");
		String age = pro.getProperty("age");
	}
	
	// 读取包内的资源文件
	public void test3() throws IOException {
		
		ClassLoader class1 = demo02.class.getClassLoader();
		InputStream in = class1.getResourceAsStream("cn/usgame/servletO1.properties");
		
		Properties pro = new Properties();
		pro.load(in);
		
		String name = pro.getProperty("name");
		String age = pro.getProperty("age");
	}
	
		
	// 读取webroot目录下面的资源
	public void test4() throws IOException {
		InputStream in = this.getServletConfig().getServletContext().getResourceAsStream("/O1.properties");
		
		Properties pro = new Properties();
		pro.load(in);
		
		String name = pro.getProperty("name");
		String age = pro.getProperty("age");
	}
	
	
	// 读取大文件
	public void test5() throws IOException {
		String path = this.getServletConfig().getServletContext().getRealPath("/WEB-INFO/classes/1.mp4");
		String filename = path.substring(path.lastIndexOf("\\") + 1);
		
		InputStream in = this.getServletConfig().getServletContext().getResourceAsStream("/WEB-INFO/classes/1.mp4");
	
		byte buffer[] = new byte[1024];
		int len = 0;
		
		FileOutputStream out = new  FileOutputStream("e:\\" +filename);
		while ((len=in.read(buffer))>0) {
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
	}
	
	
	// 在Dao层怎么读写数据--
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
