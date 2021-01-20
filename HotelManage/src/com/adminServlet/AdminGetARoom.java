package com.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;

public class AdminGetARoom extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String RoomId = new String(request.getParameter("RoomId").getBytes(
				"ISO-8859-1"), "utf-8");

		int roomid = Integer.parseInt(RoomId);

		ICBllFrame interfaceOfBllFrame = new CBllImpl();

		HashMap<String, Object> result1 = interfaceOfBllFrame
				.QueryRoomDetail(roomid);

		JSONObject jsonObject = new JSONObject().fromObject(result1);

		System.out.println("���ؿͻ�����ݣ�" + jsonObject);

		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}

}
