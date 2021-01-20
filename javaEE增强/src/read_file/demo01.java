package read_file;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class demo01
 */
@WebServlet("/demo01")
public class demo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public demo01() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// forward��ʱ�򣬻��֮ǰд��response�����ݣ����
		// Ҳ���������Ǿ仰��û�õģ�������ҳ������ʾ
		response.getOutputStream().write("Nihao".getBytes());
		
		// ��ȡӦ�õ�Context��
		// �൱��Servlet�Ĺ������������ȫ��
		// ����������������
		ServletContext context = this.getServletContext();
		context.setAttribute("name", "XiaoMing");
		
		// ����������д�������servletContext�ķ�����������ת��
		// ����������������ת��
		RequestDispatcher res = context.getRequestDispatcher("/");
		res.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
