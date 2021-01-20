package com.ServletAndroid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Bll.CBllFrame;
import com.Bll.IBllFrame;
import com.EntityWeb.Enrollment;

public class EnrollmentCompetition extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
		
		String StudentName = request.getParameter("StudentName"); //学生姓名
		String StudentSex = request.getParameter("StudentSex"); //学生性别
		String StudentIDNumber = request.getParameter("StudentIDNumber"); //学生身份证号
		String StudentSchool = request.getParameter("StudentSchool"); //学生学校
		int StudentGrade = Integer.parseInt(request.getParameter("StudentGrade")); //学生年级
		String UserAddress = request.getParameter("UserAddress"); //通讯地址
		String StudentContactsMan = request.getParameter("StudentContactsMan"); //联系人
		String StudentContactsPhon = request.getParameter("StudentContactsPhon"); //联系人号码
		String StudentTeacher = request.getParameter("StudentTeacher"); //指导老师
		String StudentTeacherPhon = request.getParameter("StudentTeacherPhon"); //指导老师电话
		String StudentPicture = request.getParameter("StudentPicture"); //学生图片路径
		String CompetitionName = request.getParameter("CompetitionName");  //大赛名称
		int CompetitionSession = Integer.parseInt(request.getParameter("CompetitionSession")); /**大赛届数*/
		// int ContestObject = Integer.parseInt(request.getParameter("ContestObject")); //参赛级别
		String contestObject_str = request.getParameter("ContestObject");
		int ContestObject = Integer.parseInt(contestObject_str);
		
		String ContestSubject = request.getParameter("ContestSubject"); //参赛类别
		int ContestMoney = Integer.parseInt(request.getParameter("ContestMoney")); //报名费
		String StartTime = request.getParameter("StartTime"); /**大赛开始时间*/
		String EndTime = request.getParameter("EndTime");/**大赛结束时间*/
		String OrganizationName = request.getParameter("OrganizationName"); //报名机构
		int ContestId = Integer.parseInt(request.getParameter("ContestId")); /**竞赛项目id*/
		int OrganizationId = Integer.parseInt(request.getParameter("OrganizationId")); /**机构id*/
		int UserId = Integer.parseInt(request.getParameter("UserId")); /**用户id*/
		int enrollmentState = 2;
		System.out.print(StudentName);
		
		
//		json.StudentIDNumber = StudentIDNumber;
//		json.CompetitionName = CompetitionName;
//		json.ContestObject = ContestObject;
//		json.ContestSubject = ContestSubject;
//		json.OrganizationName = OrganizationName;
		
		
		IBllFrame interfaceOfBllFrame=CBllFrame.getInstance();
		JSONObject json = new JSONObject();
		
		Enrollment enrollment=new Enrollment(StudentName, StudentSex, StudentIDNumber, StudentSchool, 
				StudentGrade, StudentContactsMan, StudentContactsPhon, UserAddress, StudentTeacher, 
				StudentTeacherPhon, StudentPicture, CompetitionName, CompetitionSession, ContestObject, 
				ContestSubject, ContestMoney, StartTime, EndTime, OrganizationName,
				ContestId, OrganizationId,UserId,enrollmentState);
		boolean result=interfaceOfBllFrame.EnrollmentComptition(enrollment);
		json.put("result",result);
		
		System.out.print("elloh"+result);
		
		
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
	

}
