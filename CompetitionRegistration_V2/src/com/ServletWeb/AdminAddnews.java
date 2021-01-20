package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Dao.DaoCompetition;


public class AdminAddnews extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
//			JSONObject jsonObject=JSONObject.fromObject(new String(request
//					.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
			JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
			
			String NewsTitle = jsonObject.getString("newstitle");
			String NewsContent = jsonObject.getString("newscontent");
			String NewsExtralInfo = jsonObject.getString("newsExtralInfo");
			int NewsState = jsonObject.getInt("newsState");
			int NewsTop= jsonObject.getInt("newsTop");
			String NewsSource = jsonObject.getString("newssource");
			
			JSONArray jsonObject2 = JSONArray.fromObject(jsonObject.getString("picPathArr"));
			
			//System.out.println(length);
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String NewsPutTime = s.format(new Date());
			
			// 先创建新闻
			DaoCompetition competition = new DaoCompetition();
			// 返回最新生成的新闻ID
			int NewsId = competition.CreateANews(NewsTitle, NewsContent, NewsExtralInfo, NewsPutTime, NewsState, NewsTop, NewsSource,1);
			// 再创建新闻图片
			// String NewsPicUrl = jsonObject2.toString();
			int length = jsonObject2.size();
			boolean  flag = true;
			if(length == 0){
				//System.out.println(length);
				flag = competition.CreateANewsPicture("", NewsId);
				System.out.println(flag);
			}else
			{
				//System.out.println(length);
				for (int i=0; i<length; i++) {
					String NewsPicUrl = (String) jsonObject2.get(i);
					flag = competition.CreateANewsPicture(NewsPicUrl, NewsId);
					System.out.println(flag);
				}
			}
			JSONObject jsonobject= new JSONObject();
			
				jsonobject.put("result",flag);
		
			
			PrintWriter out = response.getWriter();
			out.println(jsonobject);
			out.flush();
			out.close();
	}
}
