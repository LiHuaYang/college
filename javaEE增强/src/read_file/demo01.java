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
		
		// forward的时候，会把之前写入response的数据，清空
		// 也就是下面那句话是没用的，不会在页面上显示
		response.getOutputStream().write("Nihao".getBytes());
		
		// 获取应用的Context，
		// 相当于Servlet的共享的数据区，全局
		// ×××××存数据
		ServletContext context = this.getServletContext();
		context.setAttribute("name", "XiaoMing");
		
		// 不对请求进行处理，调用servletContext的方法来，请求转发
		// ××××××请求转发
		RequestDispatcher res = context.getRequestDispatcher("/");
		res.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
