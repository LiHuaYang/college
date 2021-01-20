package com.nbut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import com.factory.BllFactory;
import com.nbut.entity.SolutionSet;
import com.nbut.entity.User;
import com.nbut.filter.MyResponseWrapper;
import com.nbut.filter.MyResquestWrapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class SolutionActionV2
 */
@WebServlet("/SolutionActionV2")
public class SolutionActionV2 extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void getsolutionlist(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JSONObject out_json = new JSONObject();
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		PrintWriter out = response.getWriter();

		String page = jsonRequest.getString("page");
		int type = Integer.parseInt(jsonRequest.getString("type"));
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
		if (type == 0) {
			List<SolutionSet> solus = BllFactory.getInstance().getProgramManage().getSolutionSet(Integer.parseInt(page));
			jsonArray = toJsonArray(judge, solus, userId);
		} else {
			int problemId = Integer.parseInt(jsonRequest.getString("problemId"));
			List<SolutionSet> solus = BllFactory.getInstance().getProgramManage().getSolutionSetByProblemId(Integer.parseInt(page), problemId, type);
			jsonArray = toJsonArray(judge, solus, userId);
		}
		out_json.put("msg", true);
		out_json.put("other", null);
		out_json.put("data", jsonArray);
		out.println(out_json);
		out.flush();
		out.close();
	}

	public void getsolutionset(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JSONObject out_json = new JSONObject();
		PrintWriter out = response.getWriter();
		JSONObject jsonRequest = JSONObject.fromObject(request.getParameter("json"));
		String solutionId = jsonRequest.getString("solutionId");
		String source = BllFactory.getInstance().getProgramManage().getSource(Integer.parseInt(solutionId));
		out_json = new JSONObject();
		if (source.length() != 0) {
			out_json.put("msg", true);
		} else {
			out_json.put("msg", false);
		}
		out_json.put("data", source);
		out_json.put("other", null);
		out.println(out_json);
		out.flush();
		out.close();
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
