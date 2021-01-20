package com.jiqiren.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jiqiren.entity.QueryResult;
import com.jiqiren.entity.Teacher;
import com.jiqiren.service.impl.ServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport {
	
	private static final ServiceImpl service = new ServiceImpl();
	
	public String getPage() {
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);     
		String page = request.getParameter("page");
		QueryResult result = service.getPageTeacher(page);

		ActionContext.getContext().put("result", result);
		return "getPage";
	}
	
	
	
	/**
	 * 获取一个学生的信息
	 * @return
	 * @author ariclee
	 */
	public String detail() {
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String id = request.getParameter("id");
		Teacher stu = service.getATeacher(id);
		request.setAttribute("detail", stu);
		return "detail";
	}
	
}
