package com.jiqiren.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jiqiren.entity.QueryResult;
import com.jiqiren.entity.Student;
import com.jiqiren.service.impl.ServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	
	private static final ServiceImpl service = new ServiceImpl();
	
	public String execute() throws Exception {
		return "success";
	}
	
	public String getAll() {
		ActionContext actionContext = ActionContext.getContext(); 
		List<Student> items = service.getAllStudent();
		Map<String, Object> request = (Map) actionContext.get("request"); 
		request.put("students", items);
		return "getAll";
	}

	public String getPage() {
		HttpServletRequest request = (HttpServletRequest)ActionContext // 
				.getContext() // 
				.get(ServletActionContext.HTTP_REQUEST); //      
		
		String page = request.getParameter("page");
		QueryResult result = service.getPageStudent(page);

		ActionContext.getContext().put("result", result);
		return "getPage";
	}
	
	/**
	 * 获取一个学生的信息
	 * @return
	 * @author ariclee
	 */
	public String detail() {
		HttpServletRequest request = (HttpServletRequest)ActionContext // 
				.getContext() // 
				.get(ServletActionContext.HTTP_REQUEST); // 
		
		String id = request.getParameter("id");
		Student stu = service.getAStudent(id);
		request.setAttribute("detail", stu);
		return "detail";
	}
	
	/**
	 * 
	 * @return
	 * @author ariclee
	 */
	public String login() {
		return "";
	}
	
	
}
