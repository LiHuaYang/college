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

		// ��������վ�����Ժ󣬸���û��srcĿ¼
//		FileInputStream file = new FileInputStream("src/1.properties");
		
		// ���·��--���˭��������˭���У��������˭���У�JVM���У��ĸ�Ŀ¼�������JVM--tomcat--binĿ¼
		FileInputStream file = new FileInputStream("1.properties");
		
		// ����web����ʱ���������ô�ͳ��ʽ����ȡ�ļ�����
		test1();
		
	}
	
	// ��ȡsrc�������Դ�ļ�--��ʽ1--��ͳ
	public void test1() throws IOException {
		InputStream in = this.getServletConfig().getServletContext().getResourceAsStream("/WEB-INF/classes/O1.properties");
		
		Properties pro = new Properties();
		pro.load(in);
		
		String name = pro.getProperty("name");
		String age = pro.getProperty("age");
	}
	
	// ��ȡsrc�������Դ�ļ�--��ʽ2--��װ����
	// 1. ��ȡʱ�򣬽��ļ�д���ڴ棬�����ļ�����JVM�ڴ����
	// 2. ֻת��һ�Σ���ʹ��δ�������Ŀ�еĺܶ�ط�������
	public void test2() throws IOException {
		
		ClassLoader class1 = demo02.class.getClassLoader();
		InputStream in = class1.getResourceAsStream("O1.properties");
		
		Properties pro = new Properties();
		pro.load(in);
		
		String name = pro.getProperty("name");
		String age = pro.getProperty("age");
	}
	
	// ��ȡ���ڵ���Դ�ļ�
	public void test3() throws IOException {
		
		ClassLoader class1 = demo02.class.getClassLoader();
		InputStream in = class1.getResourceAsStream("cn/usgame/servletO1.properties");
		
		Properties pro = new Properties();
		pro.load(in);
		
		String name = pro.getProperty("name");
		String age = pro.getProperty("age");
	}
	
		
	// ��ȡwebrootĿ¼�������Դ
	public void test4() throws IOException {
		InputStream in = this.getServletConfig().getServletContext().getResourceAsStream("/O1.properties");
		
		Properties pro = new Properties();
		pro.load(in);
		
		String name = pro.getProperty("name");
		String age = pro.getProperty("age");
	}
	
	
	// ��ȡ���ļ�
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
	
	
	// ��Dao����ô��д����--
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
