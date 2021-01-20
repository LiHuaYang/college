package com.nbut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.BllFactory;
import com.nbut.bll.UserManage;
import com.nbut.entity.Privilege;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 分发管理员说对权限操作的请求
 * 	- 1. 查找所有权限列表    
 *  - 2. 增加用户权限
 *  - 3. 查询单个用户权限
 *  - 4. 删除一个用户的权限
 * 
 * 作者：ariclee		时间：2016年5月26日下午1:18:52
 */
@WebServlet("/PrivilegeActionServlet")
public class PrivilegeActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrivilegeActionServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method"); // 用户请求的操作
		PrintWriter out = response.getWriter();
		JSONObject out_json = new JSONObject();
		
		switch (method) {
			case "list": // 得到权限列表
				this.getList(out_json);
				break;
			case "add": // 增加用户权限
				this.addPrivilege(request, response, out_json);
				break;
			case "del":
				delUserPirilege(request, out_json);
				break;
		}
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：getList
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月26日下午3:16:15
	 */
	public void getList(JSONObject out_json) {
		UserManage user_handle = BllFactory.getInstance().getUserManage();
		JSONArray array = user_handle.getAllPrivilege();
		if (array == null) {
			out_json.put("msg", false);
		}
		else {
			out_json.put("msg", true);
		}
		out_json.put("data", array);
		out_json.put("other", null);
	}
	
	/**
	 * 函数名称：addPrivilege
	 * 功能描述：为某个用户删除某个权限
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月26日下午3:17:28
	 */
	public void addPrivilege(HttpServletRequest request, HttpServletResponse response, JSONObject out_json) {
		UserManage user_handle = BllFactory.getInstance().getUserManage();
		Privilege pp  = Privilege.contain((String)request.getParameter("pri_name"));
		boolean res = false;
		if (pp != null) {
			res = user_handle.addPrivilege(request.getParameter("user_id"), pp);
			out_json.put("msg", res);
		}
		else {
			out_json.put("msg", false);
		}
		out_json.put("data", null);
		out_json.put("other", null);
	}

	/**
	 * 函数名称：delUserPirilege
	 * 功能描述：删除某个用户的某个权限
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月31日下午7:48:29
	 */
	public void delUserPirilege(HttpServletRequest request, JSONObject out_json) {
		UserManage user_handle = BllFactory.getInstance().getUserManage();
		String user_id = request.getParameter("user_id");
		Privilege privilege  = Privilege.contain((String)request.getParameter("pri_name"));
		
		if (privilege!=null) {
			if (user_handle.delUserPrivilege(user_id, privilege)) {
				out_json.put("msg", true); // 权限删除成功
			} else {
				out_json.put("msg", false); // 权限删除失败
			}
		} else {
			out_json.put("msg", false); // 找不到权限
		}
		out_json.put("data", null);
		out_json.put("other", null);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
