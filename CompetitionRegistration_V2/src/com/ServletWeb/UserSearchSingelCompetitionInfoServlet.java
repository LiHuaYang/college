package com.ServletWeb;

import javax.servlet.http.HttpServlet;

public class UserSearchSingelCompetitionInfoServlet extends HttpServlet {

	
//	public void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		request.setCharacterEncoding("UTF-8");	
//		response.setContentType("text/html;charset=UTF-8");
//		
//		JSONObject jsonObject = JSONObject.fromObject(new String(request.getParameter("json").getBytes("ISO-8859-1"),"utf-8"));
//		int UserId = jsonObject.getInt("UserId"); 
//		int page=jsonObject.getInt("page");
//		
//		
//		ICBllFrame interfaceOfBllFrame=new CBllFrame();
//		JSONArray json = null;
//		List<CompetitionInfo> result = interfaceOfBllFrame.UserSearchSingelCompetitionInfo(UserId,page);
//		try {
//			json=JSONArray.fromObject(result);	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(json);
//		PrintWriter out = response.getWriter();
//		out.println(json);
//		out.flush();
//		out.close();
//	}
}
