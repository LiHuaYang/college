package com.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.Dao.CDaoFrame;
import com.Dao.DaoCompetition;
import com.EntityAndroid.NewsInfo;
import com.EntityWeb.Enrollment;

public class AddContender extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
//			JSONObject jsonObject = JSONObject.fromObject(new String(request
//					.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
			JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
			
			String StudentName = jsonObject.getString("StudentName");
			String StudentSex = jsonObject.getString("StudentSex");
			String StudentIDNumber = jsonObject.getString("StudentIDNumber");
			String StudentSchool = jsonObject.getString("StudentSchool");
			int StudentGrade = jsonObject.getInt("StudentGrade");
			String StudentContactsMan = jsonObject.getString("StudentContactsMan");
			String StudentContactsPhon = jsonObject.getString("StudentContactsPhon");
			String UserAddress = jsonObject.getString("UserAddress");
			String StudentTeacher = jsonObject.getString("StudentTeacher");
			String StudentTeacherPhon = jsonObject.getString("StudentTeacherPhon");
			String CompetitionName = jsonObject.getString("CompetitionName");
			int CompetitionSession = jsonObject.getInt("CompetitionSession");
			int ContestObject = jsonObject.getInt("ContestObject");
			String ContestSubject = jsonObject.getString("ContestSubject");
			int ContestMoney = jsonObject.getInt("ContestMoney");
			String StartTime = jsonObject.getString("StartTime");
			String EndTime = jsonObject.getString("EndTime");
			String OrganizationName = jsonObject.getString("OrganizationName");
			int enrollmentState = jsonObject.getInt("enrollmentState");
			String StudentTicket = jsonObject.getString("StudentTicket");
			int Studentscore = jsonObject.getInt("Studentscore");
			int StudentRank = jsonObject.getInt("StudentRank");
			String StudentPicture = jsonObject.getString("StudentPicture");
			
			Enrollment enrollment = null;
			enrollment = new Enrollment(StudentName, StudentSex, StudentIDNumber, StudentSchool, StudentGrade, StudentContactsMan, StudentContactsPhon, UserAddress, StudentTeacher, StudentTeacherPhon, StudentPicture, CompetitionName, CompetitionSession, ContestObject, ContestSubject, ContestMoney, StartTime, EndTime, OrganizationName, enrollmentState, StudentTicket, Studentscore, StudentRank);
			
			DaoCompetition daocompetition = new DaoCompetition();
			daocompetition.AddContender(enrollment);
			
			//System.out.println(news.toString());
			//System.out.println(newstitle+newscontent+newspic);
			
			PrintWriter out = response.getWriter();
			
			out.flush();
			out.close();
	}

}
