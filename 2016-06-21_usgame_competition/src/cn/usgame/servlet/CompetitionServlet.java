package cn.usgame.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Competition;
import cn.usgame.entity.User;
import cn.usgame.entity_dto.ApplyReportForm;
import cn.usgame.entity_dto.CompetitionForm;
import cn.usgame.filter.MyResponseWrapper;
import cn.usgame.filter.MyResquestWrapper;
import cn.usgame.service.CompetitionService;
import cn.usgame.service.ServiceFactory;

@WebServlet("/CompetitionServlet")
public class CompetitionServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	private CompetitionService comService = ServiceFactory.getInstance().getProgramManage();

	/**
	 * 函数名称：add 功能描述： 参数说明： 返回值：void 备注：
	 * 
	 * 作者：ariclee 时间：2016年7月3日下午2:31:55
	 */
	public void addCompetition(MyResquestWrapper request,MyResponseWrapper response) throws SQLException, IOException {
		
//		String competitionName = request.getParameter("js_competitionName");
//		String competitionSubject = request.getParameter("js_competitionSubject");
//		int competitionForm = Integer.parseInt(request.getParameter("js_competitionForm"));
//		int competitionType = Integer.parseInt(request.getParameter("js_competitionType"));
//		String competitionApplyStartTime =request.getParameter("js_competitionApplyStartTime");
//		String competitionApplyEndTime =request.getParameter("js_competitionApplyEndTime");
//		String competitionJoinerDes = request.getParameter("js_competitionJoinerDes");
//		String competitionMoney = request.getParameter("js_competitionMoney");
//		String competitionPrizeDes = request.getParameter("js_competitionPrizeDes");
//		String competitionTestTimeDes = request.getParameter("js_competitionTestTimeDes");
//		String competitionApplyAddress =request.getParameter("js_competitionApplyAddress");
//		String competitionTestAddress = request.getParameter("js_competitionTestAddress");
//		String competitionDetail = request.getParameter("js_competitionDetail");
//		String competitionSupportDesc = request.getParameter("js_competitionSupportDesc");
//		System.out.println(competitionType);
//		CompetitionForm competitionform = new CompetitionForm(competitionName, competitionSubject, competitionForm, competitionType, competitionApplyStartTime, competitionApplyEndTime, competitionJoinerDes, competitionMoney, competitionPrizeDes, competitionTestTimeDes, competitionApplyAddress, competitionTestAddress, competitionDetail, competitionSupportDesc);
//		Competition competition = competitionform.toCompetition();
		Map<String, String[]> map = request.getParameterMap();
		CompetitionForm competitionForm = new CompetitionForm(map);
		Competition competition = competitionForm.toCompetition();
		boolean result = comService.addCompetition(competition);
		JsonObject out_json = new JsonObject();
		out_json.addProperty("msg", result);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 函数名称：getList 功能描述：获取比赛列表 参数说明： 返回值：void 备注：
	 * 
	 * 作者：joker 时间：2016年7月3日下午2:34:30
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void list(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		int page = 0;
		if (type == 1) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		JsonArray jsonData = new JsonArray();
		JsonObject out_json = new JsonObject();
		List<Competition> competitions = comService.getCompetitionList(page, type);
		for (int i = 0; i < competitions.size(); i++) {
			jsonData.add(competitions.get(i).toJSON());
		}
		String num = comService.getCompetitionNum();
		// EasyUI json格式
		
		PrintWriter out = response.getWriter();
		if(type==1) {
			out_json.addProperty("total", num);
			out_json.add("rows", jsonData);
		}
		else {
			out_json.addProperty("total", competitions.size());
			out_json.add("data", jsonData);
		}
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 函数名称：detail 
	 * 功能描述：获取比赛详情 
	 * 参数说明： 返回值：void 备注：
	 * 
	 * 作者：joker 时间：2016年7月4日下午4:16:51
	 */
	public void detail(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int competitionId = Integer.parseInt(request.getParameter("competitionId"));
		int type = Integer.parseInt(request.getParameter("type"));
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();
		if (type == 1) {
			Competition competition = comService.getCompetitionDetail(competitionId);
			jsonData = competition.toJSON();
			if (competition != null) {
				out_json.add("data", jsonData);
				out_json.addProperty("msg", true);
			} else {
				out_json.add("data", null);
				out_json.addProperty("msg", false);
			}
			out_json.add("other", null);
		} else if (type == 2) {
			String competitionDes = comService.getCompetitionDes(competitionId);
			if (competitionDes != null) {
				out_json.addProperty("data", competitionDes);
				out_json.addProperty("msg", true);
			} else {
				out_json.add("data", null);
				out_json.addProperty("msg", false);
			}
			out_json.add("other", null);
		}
		if(type == 3) {
			Competition competition = comService.getCompetitionDetail(competitionId);
			jsonData = competition.toJSON();
			PrintWriter out = response.getWriter();
			out.println(jsonData);
			out.flush();
			out.close();
		}
		else {
			PrintWriter out = response.getWriter();
			out.println(out_json);
			out.flush();
			out.close();
		}
	}

	/**
	 * 
	 * 函数名称：apply 功能描述：提交报名申请 参数说明： 返回值：void 备注：msg 1:报名成功 2:用户已经支付过 3:修改报名成功 4:身份证或手机号错误
	 * 
	 * 作者：joker 时间：2016年7月5日下午4:09:57
	 */
	public void apply(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		Map<String, String[]> map = request.getParameterMap();
		JsonObject out_json = new JsonObject();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if(us!=null) {
			ApplyReportForm applyReportForm = new ApplyReportForm(map, us.getPhonenumber());
			boolean flagForIdcard = applyReportForm.judgeIdcard();
			boolean flagForPhoneNum = applyReportForm.judgePhoneNum();
			if (flagForIdcard == true && flagForPhoneNum == true) {
				ApplyReport applyReport = applyReportForm.toApplyReport();
				int result = comService.applyReport(applyReport);
				out_json.addProperty("msg", result);
				out_json.addProperty("data", applyReport.getOut_trade_no());
				out_json.add("other", null);
			} else {
				if (flagForIdcard == false && flagForPhoneNum == true) {
					out_json.addProperty("other", "身份证号码有误！");
				} else if (flagForPhoneNum == false && flagForIdcard == true) {
					out_json.addProperty("other", "电话号码有误！");
				} else if (flagForPhoneNum == false && flagForIdcard == false) {
					out_json.addProperty("other", "电话号码,身份证有误！");
				}
				out_json.addProperty("msg", 4);
				out_json.add("data", null);
			}
		}
		else {
			out_json.addProperty("msg", 0);
			out_json.add("data", null);
			out_json.addProperty("other", "请先登陆!");
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param request
	 * 	
	 * @param response
	 * @throws IOException
	 * 
	 * @author ariclee
	 */
	public void reviseState(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int competitionId = Integer.parseInt(request.getParameter("competitionId"));
		int competitionState = Integer.parseInt(request.getParameter("competitionState"));
		JsonObject out_json = new JsonObject();
		boolean result = false;
		result = comService.reviseCompetitionState(competitionId, competitionState);
		out_json.addProperty("msg", result);
		out_json.add("data", null);
		if(result==false) {
			out_json.addProperty("other", "修改状态失败！");
		}
		else {
			out_json.addProperty("other", "修改状态成功！");
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：getApplyList
	 * 功能描述：获取报名列表
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月13日下午8:47:21
	 */
	public void getApplyList(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<ApplyReport> applyReports = comService.getAllApplyReport(page);
		String total = comService.getApplyReportNum();
		for(int i=0;i<applyReports.size();i++) {
			jsonData.add(applyReports.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	public void getApplyDetail(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String phoneNum = request.getParameter("phoneNum");
		JsonObject jsonData = new JsonObject();
		ApplyReport applyReport = comService.getApplyReportDetail(phoneNum);
		jsonData = applyReport.toJSON();
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		out.flush();
		out.close();
	}
	
	public void search(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String options = request.getParameter("options");
		String Info = URLDecoder.decode(request.getParameter("Info"));
		int orderState = Integer.parseInt(request.getParameter("orderState"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<ApplyReport> applyReports = comService.getApplyReport(starttime, endtime, options, Info, orderState, page);
		String total = comService.getSearchNum(starttime, endtime, options, Info, orderState);
		for(int i=0;i<applyReports.size();i++) {
			jsonData.add(applyReports.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		out.flush();
		out.close();
	}
	
	public void Export(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String options = request.getParameter("options");
		String Info = URLDecoder.decode(request.getParameter("Info"));
		int orderState = Integer.parseInt(request.getParameter("orderState"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<ApplyReport> applyReports = comService.getApplyReport(starttime, endtime, options, Info, orderState, page);
		String total = comService.getSearchNum(starttime, endtime, options, Info, orderState);
		for(int i=0;i<applyReports.size();i++) {
			jsonData.add(applyReports.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		out.flush();
		out.close();
	}
	
	
//	/**
//	 * 
//	 * 函数名称：delete
//	 * 功能描述：删除比赛
//	 * 参数说明：
//	 * 返回值：void
//	 * 备注：
//	 * 
//	 * 作者：joker		时间：2016年7月11日下午2:46:08
//	 */
//	public void delete(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
//		String competitionId = request.getParameter("competitionId");
//		JsonObject out_json = new JsonObject();
//		boolean result = comService.deleteCompetition(competitionId);
//		out_json.add("data", null);
//		out_json.add("other", null);
//		out_json.addProperty("msg",result);
//		PrintWriter out = response.getWriter();
//		out.println(out_json);
//		out.flush();
//		out.close();
//	}

}
