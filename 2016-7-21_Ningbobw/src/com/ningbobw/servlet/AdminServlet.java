package com.ningbobw.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ningbobw.entity.Article;
import com.ningbobw.filter.MyResponseWrapper;
import com.ningbobw.filter.MyResquestWrapper;
import com.ningbobw.service.Service;
import com.ningbobw.utils.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/a")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void add(MyResquestWrapper request, MyResponseWrapper response) throws Exception {
		DiskFileItemFactory factory = new DiskFileItemFactory();	// 1.得到解析器工厂
		ServletFileUpload upload = new ServletFileUpload(factory);		// 2.得到解析器
	
		if (!upload.isMultipartContent(request)) {// 上传表单为普通表单，则按照传统方式获取数据即可
			return ;
		}
		
		List<FileItem> list = upload.parseRequest(request); 
		JSONObject article = new JSONObject();
		
		String res = null;
		for (FileItem item : list) {  // 遍历list，得到用于封装第一个上传输入项数据fileItem对象
			if (item.isFormField()) {
				article.put(item.getFieldName(), item.getString("UTF-8"));
				
			} else {
				String savepath = this.getServletContext().getRealPath("/upload");
				res = Service.getInstance().uploadAttach(item.getName(), savepath, item.getInputStream());
			}
		}
		
		String cat = article.getString("board_id"); // 类型
		String title = article.getString("title"); 
		String source= article.getString("source");
		String introduce= article.getString("introduce");
		String content = article.getString("content");
		String attach = "";
		
		if (res != null) {  // 2. 文件上传了..... 
			attach = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+ "/upload/" + res; // 项目路径加上文件名
		}
		// 判断是否为空
		if (cat == "" || cat==null) {
		}
		Article art = new Article(Integer.parseInt(cat), title, source, introduce, content, attach);
		if (Service.getInstance().addArticle(art)) {
			WebUtils.send(response.getWriter(), "Success");
		} else {
			WebUtils.send(response.getWriter(), "False");
		}
	}
	
	/**
	 * 函数名称：getCategory
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月25日下午2:46:28
	 */
	public void getCategory (MyResquestWrapper request, MyResponseWrapper response) throws Exception {
		JSONObject jsonObj = new JSONObject();
		JSONArray array = Service.getInstance().getCategory();
		WebUtils.send(response.getWriter(), array.toString());
	}
	
	/**
	 * 
	 * 函数名称：list
	 * 功能描述：获取文章列表
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月26日下午9:14:08
	 */
	public void list(MyResquestWrapper request, MyResponseWrapper response) throws Exception {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		JSONObject out_json = new JSONObject();
		int total = Integer.parseInt(Service.getInstance().getArticleListNum());
		JSONArray jsonData = Service.getInstance().getArticleList(page,rows);
		out_json.put("total", total);
		out_json.put("rows", jsonData);
		WebUtils.send(response.getWriter(), out_json.toString());
	}
	
	public void detail(MyResquestWrapper request, MyResponseWrapper response) throws Exception {
		String article_id = request.getParameter("article_id");
		JSONObject jsonData = new JSONObject();
		jsonData = Service.getInstance().getArticleDetail(article_id);
		WebUtils.send(response.getWriter(), jsonData.toString());
	}
	
	
	
	
	
	
	
	
}
