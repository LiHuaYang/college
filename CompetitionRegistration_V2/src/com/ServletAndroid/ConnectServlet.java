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
         * ҵ���߼���������������doGet����doPost����
         */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ������ת��doGet����doPost����
		req.setCharacterEncoding(CharacterEncoding);//���ñ���
		resp.setCharacterEncoding(CharacterEncoding);
		super.service(req, resp);//�жϵ���doGet����doPost
	}


        /**
         * ���Get�������˵��ô˷���
         */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ����Get���͵�����
		// super.doGet(req, resp);
		doPost(req, resp);
	}


        /**
         * ���Post�������˵��ô˷���
         */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		// ����Post���͵�����
//		// super.doPost(req, resp);
//		String _id = req.getParameter("_id");
//		String _name = req.getParameter("_name");
//
//		System.out.println("�յ� -- _id:"+_id + "  _name:" + _name);
//		
//		PrintWriter printWriter = resp.getWriter();
//		
//		JsonBase jsonResult = new JsonBase(true, "�յ� -- _id:"+_id + "  _name:" + _name);
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
		// �����ܱ���������
		super.service(req, res);
	}

}
