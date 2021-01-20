package com.nbut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import com.factory.BllFactory;
import com.nbut.entity.Contest;
import com.nbut.entity.ContestSet;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.SolutionSet;
import com.nbut.entity.User;
import com.nbut.filter.MyResponseWrapper;
import com.nbut.filter.MyResquestWrapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 
 *
 * 作者：ariclee		时间：2016年6月11日下午10:31:19
 */
@WebServlet("/ContestActionV2")
public class ContestActionV2 extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 函数名称：getContest
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月5日下午9:43:56
	 */
	public void getContest(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		Contest contest = BllFactory.getInstance().getProgramManage().getContest(id);
		JSONObject out_json = new JSONObject();
		out_json = contest.toJson();
		out.println(out_json);
		out.flush();
		out.close();
	}

	// ../././../ContestActionV2?method=getJoinerInfo
	/**
	 * 函数名称：AddContest
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月5日下午9:43:59
	 */
	public void AddContest(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		JSONObject out_json = new JSONObject();
		String title = jsonRequest.getString("title");
		String starttime = jsonRequest.getString("starttime");
		String endtime = jsonRequest.getString("endtime");
		int privilege = jsonRequest.getInt("privilege");
		String password = jsonRequest.getString("password");
		int language = jsonRequest.getInt("language");

		String problem = jsonRequest.getString("problem");// 1000,1001,1002
															// 问题和问题之间用英文逗号分隔
		String[] problems = problem.split(",");
		String describe = jsonRequest.getString("describe");

		String user = jsonRequest.getString("users"); // 学号之间用换行符分开
		String[] users = user.split("\n");

		User creator = (User)request.getSession().getAttribute("user");
		String creatorId = creator.getUser_id();
		
		int result = 0;
		Contest contest = new Contest(title, starttime, endtime, "N", describe, privilege, language, password);
		result = BllFactory.getInstance().getProgramManage().addContest(contest, users, problems, creatorId);
		if (result != 1) {
			out_json.put("res", "false");
			out_json.put("msg", "添加竞赛失败");
		} else {
			out_json.put("res", "true");
			out_json.put("msg", "添加竞赛成功");
		}
		out_json.put("data", null);
		out_json.put("other", null);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 函数名称：getContestProblemSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月5日下午9:44:03
	 */
	public void getContestProblemSet(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		String page = jsonRequest.getString("page");
		int contestId = jsonRequest.getInt("contestId");
		List<ProgramSet> list = BllFactory.getInstance().getProgramManage().getContestProgramSet(Integer.parseInt(page),
				contestId);
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject = list.get(i).toJson(1);
			jsonArray.add(jsonObject);
		}
		PrintWriter out = response.getWriter();
		out.println(jsonArray);
		out.flush();
		out.close();
	}

	/**
	 * 函数名称：getContestSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月8日下午3:11:08
	 */
	public void getContestSet(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		
		String typeStr = request.getParameter("type");
		List<ContestSet> lists = BllFactory.getInstance().getProgramManage().getContestSet(typeStr);
		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < lists.size(); i++) {
			jsonArray.add(lists.get(i).toJson());
		}
		PrintWriter out = response.getWriter();
		out.println(jsonArray);
		out.flush();
		out.close();
	}

	public void getContestSolution(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		String page = jsonRequest.getString("page");
		int contestId = Integer.parseInt(jsonRequest.getString("contestId"));

		// 获取session
		HttpSession session = request.getSession();
		User uu = (User) session.getAttribute("user");
		int judge = 0;
		String userId = null;

		// 判断权限
		if (uu != null) {
			userId = new String(uu.getUser_id());
			List<String> privileges = uu.getPrivileges();
			if (privileges != null && privileges.contains("source_browser")) {
				judge = 1;
			}
		}
		// 获取solution
		JSONArray jsonArray = new JSONArray();
		List<SolutionSet> solus = BllFactory.getInstance().getProgramManage()
				.getContestSolutionSet(Integer.parseInt(page), contestId);
		jsonArray = toJsonArray(judge, solus, userId);
		PrintWriter out = response.getWriter();
		out.println(jsonArray);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：updateContestState
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月8日下午9:31:14
	 */
	public void updateContestState(MyResquestWrapper request, MyResponseWrapper response) throws IOException {

		PrintWriter out = response.getWriter();
		JSONObject out_json = new JSONObject();
		String key = request.getParameter("key");
		String id = request.getParameter("contest_id");
		String state = request.getParameter("state");;
		int res = BllFactory.getInstance().getProgramManage().setContestState(id, key, state);
		if (res!=0) {
			out_json.put("res", "true");
			out_json.put("msg", "修改状态成功");
		} else {
			out_json.put("res", "false");
			out_json.put("msg", "修改状态失败");
		}
		out_json.put("data", null);
		out_json.put("other", null);
		out.println(out_json);
	}
	

	private JSONArray toJsonArray(int judge, List<SolutionSet> solus, String userId) {
		JSONArray jsonArray = new JSONArray();
		if (judge == 1) {
			for (int i = 0; i < solus.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject = solus.get(i).toJson(1);
				jsonArray.add(jsonObject);
			}
		} else {
			for (int i = 0; i < solus.size(); i++) {
				if (solus.get(i).getUser_id().equals(userId)) {
					JSONObject jsonObject = new JSONObject();
					jsonObject = solus.get(i).toJson(1);
					jsonArray.add(jsonObject);
				} else {
					JSONObject jsonObject = new JSONObject();
					jsonObject = solus.get(i).toJson(0);
					jsonArray.add(jsonObject);
				}
			}
		}
		return jsonArray;
	}

}
