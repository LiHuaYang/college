package com.ningbobw.servlet;

import javax.servlet.annotation.WebServlet;

import com.ningbobw.filter.MyResponseWrapper;
import com.ningbobw.filter.MyResquestWrapper;
import com.ningbobw.service.Service;
import com.ningbobw.utils.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/f")
public class FrontServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void getAll(MyResquestWrapper request, MyResponseWrapper response) throws Exception {
		JSONObject json = Service.getInstance().getArticles();
		WebUtils.send(response.getWriter(), json.toString());
	}
	
	public void getTitle (MyResquestWrapper request, MyResponseWrapper response) throws Exception {
		String id = request.getParameter("js_id");
		String type = request.getParameter("js_type");
		
		JSONArray array = Service.getInstance().getTitleList(id, type);
		WebUtils.send(response.getWriter(), array.toString());
	}
	
	public void getDetial (MyResquestWrapper request, MyResponseWrapper response) throws Exception {
		String id = request.getParameter("js_article_id"); 
		JSONObject obj = Service.getInstance().getArticleDetail(id);
		WebUtils.send(response.getWriter(), obj.toString());
	}
}
