package com.nbut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import com.factory.BllFactory;
import com.nbut.bll.ProgramManage;
import com.nbut.entity.Program;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.Solution;
import com.nbut.entity.User;
import com.nbut.filter.MyResponseWrapper;
import com.nbut.filter.MyResquestWrapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 *
 * 作者：ariclee 时间：2016年6月4日下午4:02:14
 */
@WebServlet("/ProblemActionV2")
public class ProblemActionV2 extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// 声明时的参数类型是: HttpServletRequest HttpServletResponse
	// 运行时的参数类型是:com.nbut.filter.MyRequest, com.nbut.filter.BufferResponse
	// MyRequest--HttpServletRequestWrapper
	// BufferResponse--HttpServletResponseWrapper
	// com.nbut.servlet.ProblemActionV2.list(com.nbut.filter.MyRequest,
	// com.nbut.filter.BufferResponse)
	// com.nbut.servlet.ProblemActionV2.list(com.nbut.filter.MyResquestWrapper,
	// com.nbut.filter.BufferResponse)
	// com.nbut.servlet.ProblemActionV2.list(com.nbut.filter.MyResquestWrapper,
	// com.nbut.filter.MyResponseWrapper)

	/**
	 * 
	 * 函数名称：list 
	 * 功能描述：前台、后台获取问题列表 
	 * 参数说明： 
	 * 返回值：void 
	 * 备注：
	 * 
	 * 作者：joker 时间：2016年6月5日下午2:56:03
	 */
	public void list(MyResquestWrapper request, MyResponseWrapper respons) throws IOException {
		JSONObject out_json = new JSONObject();
		PrintWriter out = respons.getWriter();
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		int type = Integer.parseInt(jsonRequest.getString("type"));// 判断是用户获取列表还是管理员获取2:管理员
		
		String page = jsonRequest.getString("page");
		JSONArray jsonArray = new JSONArray();
		
		List<ProgramSet> list = BllFactory.getInstance().getProgramManage().getProgramSet(Integer.parseInt(page), type);
		
		if (type==2) { // 如果是管理员界面请求
			HttpSession session = request.getSession();
			User uu = (User) session.getAttribute("user");
			String userId = null;
			// 判断权限
			if (uu != null) {
				userId = uu.getUser_id();
				List<String> privileges = uu.getPrivileges();
				if (privileges != null && (privileges.contains("problem_editor") || privileges.contains("administrator") || privileges.contains("contest_creator"))) { // 如果有权限
					for (int i=0; i<list.size(); i++) {
						JSONObject jsonObject = new JSONObject();
						jsonObject = list.get(i).toJson(type);
						jsonArray.add(jsonObject);
					}
					out_json.put("data", jsonArray);
					out_json.put("msg", true);
					out_json.put("other", null);
				}
			} else {
				out_json.put("msg", false);
				out_json.put("data", null);
				out_json.put("other", "您没有权限！");
			}
		}
		
		
		if (type==1) { // 如果普通用户请求
			for (int i=0; i<list.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject = list.get(i).toJson(type);
				jsonArray.add(jsonObject);
			}
			out_json.put("data", jsonArray);
			out_json.put("msg", true);
			out_json.put("other", null);
		}
		
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 函数名称：addProblem 功能描述：添加问题 参数说明： 返回值：void 备注：
	 * 
	 * 作者：joker 时间：2016年6月5日下午2:56:53
	 */
	public void addProblem(MyResquestWrapper request, MyResponseWrapper respons) throws IOException {
		JSONObject out_json = new JSONObject();
		PrintWriter out = respons.getWriter();
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		String title = jsonRequest.getString("title");
		String time_limit = jsonRequest.getString("time_limit");
		String memory_limit = jsonRequest.getString("memory_limit");
		String description = jsonRequest.getString("description");
		String output = jsonRequest.getString("output");
		String input = jsonRequest.getString("input");
		String sample_input = jsonRequest.getString("sample_input");
		String sample_output = jsonRequest.getString("sample_output");
		String hint = jsonRequest.getString("hint");
		String spj = jsonRequest.getString("spj");
		String source = jsonRequest.getString("source");
		String contestId = jsonRequest.getString("contestId");
		if (title.equals("") || time_limit.equals("") || memory_limit.equals("") || description.equals("")
				|| output.equals("") || input.equals("") || sample_input.equals("") || sample_output.equals("")
				|| hint.equals("") || spj.equals("") || source.equals("") || contestId.equals("")) {
			out_json.put("msg", false); // res false true
			out_json.put("data", null); // msg ""
			out_json.put("other", null); //
		} else {
			boolean result = false;
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String inTime = s.format(new Date());
			Program problem = new Program(0, title, description, input, output, sample_input, sample_output, spj, hint,
					source, inTime, Integer.parseInt(time_limit), Integer.parseInt(memory_limit), "N", 0, 0, "0");
			result = BllFactory.getInstance().getProgramManage().addProblem(problem, Integer.parseInt(contestId));
			out_json.put("msg", result);
			out_json.put("data", null);
			out_json.put("other", null);
		}
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 函数名称：getProblemDetail 功能描述：获取问题详情 参数说明： 返回值：void 备注：
	 * 
	 * 作者：joker 时间：2016年6月5日下午2:57:25
	 */
	public void getProblemDetail(MyResquestWrapper request, MyResponseWrapper respons) throws IOException {
		JSONObject out_json = new JSONObject();
		PrintWriter out = respons.getWriter();
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		String problem_id = jsonRequest.getString("id");
		ProgramManage pro = BllFactory.getInstance().getProgramManage();
		Program program = pro.getProgram(problem_id);
		JSONObject jsonData = program.toJson();
		if (jsonData != null) {
			out_json.put("msg", true);
		} else {
			out_json.put("msg", false);
		}
		out_json.put("data", jsonData);
		out_json.put("other", null);
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 函数名称：setProblemStatus 功能描述：设置问题status 参数说明： 返回值：void 备注：
	 * 
	 * 作者：joker 时间：2016年6月5日下午2:57:46
	 */
	public void setProblemStatus(MyResquestWrapper request, MyResponseWrapper respons) throws IOException {
		JSONObject out_json = new JSONObject();
		PrintWriter out = respons.getWriter();
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		String problem_id = jsonRequest.getString("problem_id");
		String status = jsonRequest.getString("status");
		boolean result = BllFactory.getInstance().getProgramManage().setProblemStatus(Integer.parseInt(problem_id),
				status);
		out_json.put("msg", result);
		out_json.put("data", null);
		out_json.put("other", null);
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 函数名称：deleteProblem 功能描述：删除问题 参数说明： 返回值：void 备注：
	 * 
	 * 作者：joker 时间：2016年6月5日下午2:58:04
	 */
	public void deleteProblem(MyResquestWrapper request, MyResponseWrapper respons) throws IOException {
		JSONObject out_json = new JSONObject();
		PrintWriter out = respons.getWriter();
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));

		String problem_id = jsonRequest.getString("problem_id");
		boolean result = BllFactory.getInstance().getProgramManage()
				.deleteProblemByProblemId(Integer.parseInt(problem_id));
		out_json.put("msg", result);
		out_json.put("data", null);
		out_json.put("other", null);
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：submiteProblem
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月7日下午8:09:24
	 */
	public void submiteCode(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		String problemId = jsonRequest.getString("problemId");
		String code = jsonRequest.getString("code");
		String language = jsonRequest.getString("language");
		String ip = jsonRequest.getString("ip");
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String inTime = s.format(new Date());
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("user");
		String userId = null;
		if (uu!=null) {
			userId = uu.getUser_id();
		}
		Solution solution = new Solution(code.length(), userId, Integer.parseInt(problemId), inTime, ip, Integer.parseInt(language));
		boolean result = BllFactory.getInstance().getProgramManage().submitCode(solution, code);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	
}
