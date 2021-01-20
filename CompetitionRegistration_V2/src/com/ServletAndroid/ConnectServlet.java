package com.ServletAndroid;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnectServlet extends HttpServlet {

	private static final String CharacterEncoding = "UTF-8";
	private static final long serialVersionUID = 1L;

        /**
         * 业务逻辑方法：决定调用doGet还是doPost方法
         */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 将请求转向doGet或者doPost方法
		req.setCharacterEncoding(CharacterEncoding);//设置编码
		resp.setCharacterEncoding(CharacterEncoding);
		super.service(req, resp);//判断调用doGet还是doPost
	}


        /**
         * 如果Get请求来了调用此方法
         */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 接收Get类型的请求
		// super.doGet(req, resp);
		doPost(req, resp);
	}


        /**
         * 如果Post请求来了调用此方法
         */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		// 接收Post类型的请求
//		// super.doPost(req, resp);
//		String _id = req.getParameter("_id");
//		String _name = req.getParameter("_name");
//
//		System.out.println("收到 -- _id:"+_id + "  _name:" + _name);
//		
//		PrintWriter printWriter = resp.getWriter();
//		
//		JsonBase jsonResult = new JsonBase(true, "收到 -- _id:"+_id + "  _name:" + _name);
//		
//		HashMap<String, Object> result = jsonResult.getResultMap();
//		
//		ArrayList<User> users = new ArrayList<User>();
//		
//		for (int i = 0; i < 5; i++) {
//			User user = new User();
//			user.set_id(i);
//			user.set_name("Name:" + i);
//			
//			users.add(user);
//		}
//		
//		result.put("Users", users);
//		
//		JSONObject js = JSONObject.fromObject(result);
//		
//		printWriter.write(js.toString());
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 接收受保护的请求
		super.service(req, res);
	}

}
