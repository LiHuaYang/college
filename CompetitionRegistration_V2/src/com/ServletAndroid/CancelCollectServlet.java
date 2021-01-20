package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;

public class CancelCollectServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		JSONObject jsonObject = JSONObject.fromObject(new String(request
				.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));

		int TestPaperId = jsonObject.getInt("TestPaperId");
		int userid = jsonObject.getInt("userid");

		// System.out.println(TestPaperId);
		// System.out.println(userid);

		// ICBllFrame interfaceOfBllFrame = new CBllFrame();
		IBllFrame interfaceOfBllFrame = CBllFrame.getInstance();
		boolean flag = interfaceOfBllFrame.CancelCollect(TestPaperId, userid);

		jsonObject.put("flag", flag);

		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}
