package com.ServletWeb;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.Dao.DaoCompetition;

public class AddCompetitiompicServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// JSONObject jsonObject = JSONObject.fromObject(new String(request
		// .getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));

		String competitionpic = jsonObject.getString("picPathArr");
		// String competition_simple_name =
		// jsonObject.getString("competition_simple_name");

		System.out.println("AddCompetitiompicServlet:" + competitionpic);
		// System.out.println(competition_simple_name);

		DaoCompetition cd = new DaoCompetition();
		boolean flag = cd.CreateCompetitionPicture(competitionpic);

		jsonObject.put("flag", flag);

		System.out.println("AddCompetitiompicServlet" + jsonObject);
		PrintWriter out = response.getWriter();
		out.println(jsonObject);
		out.flush();
		out.close();
	}
}
