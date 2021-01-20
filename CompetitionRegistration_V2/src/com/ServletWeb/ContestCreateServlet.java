package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.Competition;
import com.EntityWeb.Contest;

public class ContestCreateServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 1. 初始化大赛基本信息
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		Competition competition = initCompetition(jsonObject);
		System.out.println("客户端的数据:" + jsonObject);

		// 2. 初始化各个竞赛信息
		List<Contest> contests = initContests(jsonObject);
		
		// 2.1 初始化各个竞赛对应的承办方信息
		List<String> orgs = initOrgInfo(jsonObject);
		
		System.out.println("各个竞赛项目的信息: " + contests.toString());
		// 3. 创建各个大赛和大赛的各个项目 
		IBllFrame bllFrame = CBllFrame.getInstance();
		boolean flag = bllFrame.CreateCompetitionAndContest(competition, contests, orgs);
		
		JSONObject json = new JSONObject();
		
		try {
			json.put("Check", flag);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
	
	// 初始化竞赛的承办方信息
	public  List<String> initOrgInfo(JSONObject jsonObject) {
		
		List Arr = new ArrayList<String>();
		// 获取各个竞赛的承办方ID
		JSONArray ContestOrgList = JSONArray.fromObject(jsonObject.getString("ContestOrgList"));
		int contestCount = ContestOrgList.size();
		for (int i=0; i<contestCount; i++) {
			
			List<String> listStr = new ArrayList<String>();
			JSONObject OrgObj = (JSONObject)ContestOrgList.get(i);
			JSONArray ContestOrgIdList = JSONArray.fromObject(OrgObj.getString("OrgID"));
			int OrgIdCount = ContestOrgIdList.size();
			
			for (int j=0; j<OrgIdCount; j++) {
				String id = ContestOrgIdList.getString(j);
				listStr.add(id);
			}
			//String OrgID = OrgObj.getString("OrgID");
			// listStr.add(OrgID);
			
			Arr.add(listStr);
			
			System.out.println("初始化承办方ID数组：" + Arr);
		}
		
		return Arr;
	}
	// 初始化大赛各个项目
	public  List<Contest> initContests(JSONObject object) {
		
		List<Contest> contests = new ArrayList<Contest>();
		// {"StartTime":"2015-01-20","EndTime":"2015-01-25","ContestexamType":"笔试","ContestMoney":"67"}
		// 获取大赛中的不同科目
		JSONArray ContestInfoList = JSONArray.fromObject(object.getString("ContestInfoList"));
		int contestCount = ContestInfoList.size();
		for (int i=0; i<contestCount; i++) {
			// 获取科目中的不同年级段
			JSONObject subObj = (JSONObject) ContestInfoList.get(i);
			JSONArray array = JSONArray.fromObject(subObj.getString("ContestObjectList"));
			int length = array.size();
			for (int j=0; j<length; j++) {
				Contest contest = new Contest();
				// JSONObject jsonObject2 = JSONObject.fromObject(object.get(i));
				String ContestSubject = subObj.getString("ContestSubject");
				String ContestexamTypeS = subObj.getString("ContestexamType");
//				String CompetitionEnrollStartTime = subObj.getString("CompetitionEnrollStartTime");
//				String CompetitionEnrollEndTime = subObj.getString("CompetitionEnrollEndTime");
				
				int SignUpMoney = subObj.getInt("SignUpMoney");
				int ContestObj = array.getInt(j);
				System.out.println("比赛参加对象的编号: " + ContestObj);
				contest.setContestObject(ContestObj);
				contest.setContestexamType(ContestexamTypeS);
				contest.setContestMoney(SignUpMoney);
//				contest.setCompetitionEnrollEndTime(CompetitionEnrollEndTime);
//				contest.setCompetitionEnrollStartTime(CompetitionEnrollStartTime);
				contest.setContestSubject(ContestSubject);
				// 设置赛事状态为0(未发布)
				contest.setContestState(0);
				contests.add(contest);
			}
		}
		return contests;
	}
	// 初始化大赛
	public  Competition initCompetition(JSONObject jsonObject) {
		Competition competition = new Competition();
		
		String CompetitionName = jsonObject.getString("sf_CompetitionName"); // 大赛名字
		String CompetitionSessionI = jsonObject.getString("sf_CompetitionSession"); // 大赛届数
		String CompetitionSponsor = jsonObject.getString("sf_Organinaze"); // 大赛主办单位
		// String CompetitionSponsor = jsonObject.getString("sf_Organinaze"); // 赛事形式
		String CompetitionTimeDescribe = jsonObject.getString("contestTimeDes"); // 大赛时间说明
		String CompetitionPrize = jsonObject.getString("contestPrizeDes"); // 大赛奖项说明
		String CompetitionPriceDescribe = jsonObject.getString("contestPrizeDes"); // 大赛报名费用说明
		String CompetitionObjDescribe = jsonObject.getString("contestObjDes"); // 参赛对象说明
		String CompetitionEnrollStartTime = jsonObject.getString("enrollStartTime");//报名开始时间
		String CompetitionEnrollEndTime = jsonObject.getString("enrollEndTime");//报名结束时间
		
		
		String competitionpic = jsonObject.getString("Competitionpicpath");//大赛Logo 200x250
		String competitionPictureBig = jsonObject.getString("contestpicpath");//大赛大图片 1920x480
		
		
		int CompetitionSession = Integer.parseInt(CompetitionSessionI);
		String CompetitionInfo = jsonObject.getString("contestIntro");// 大赛简介
		String Competitiondetails = jsonObject.getString("competitiondetails");// 大赛详情
		
		String ContestPropaganda = jsonObject.getString("sf_ContestPropaganda"); // 大赛宣传语
		
		//competition.setCompetitionpic(competitionpic);
		competition.setCompetitionName(CompetitionName);
		competition.setCompetitionSession(CompetitionSession);
		competition.setCompetitionSponsor(CompetitionSponsor);
		competition.setCompetitionTimeDescribe(CompetitionTimeDescribe);
		competition.setCompetitionPrize(CompetitionPrize);
		competition.setCompetitionPriceDescribe(CompetitionPriceDescribe);
		competition.setCompetitionPicture(competitionpic);
		
		competition.setCompetitionPictureBig(competitionPictureBig);
		
		competition.setCompetitionEnrollStartTime(CompetitionEnrollStartTime);
		competition.setCompetitionEnrollEndTime(CompetitionEnrollEndTime);
		// competition.setCompetitionState(0);
		competition.setCompetitionObjectDescribe(CompetitionObjDescribe);
		competition.setCompetitionInfo(CompetitionInfo);
		competition.setCompetitiondetails(Competitiondetails);
		
		competition.setContestPropaganda(ContestPropaganda); // 设置大赛宣传标语
		
		// competition.set
		// competition.set
		// competition.set
		return competition;
	}
}
