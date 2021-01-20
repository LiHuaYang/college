package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.Dao.DaoCompetition;

public class AddOrganizationInfoServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// JSONObject jsonObject = JSONObject.fromObject(new String(request
		// .getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request
				.getParameter("json"));

		String Name = jsonObject.getString("Name");
		String Address = jsonObject.getString("Address");
		int Station = jsonObject.getInt("Station");
		String Tel = jsonObject.getString("Tel");
		String Contacts = jsonObject.getString("Contacts");

		DaoCompetition cd = new DaoCompetition();
		boolean flag = cd.AddOrganizationInfo(Name, Address, Station, Tel,
				Contacts);

		jsonObject.put("flag", flag);

		System.out.println(jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}
