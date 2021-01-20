<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	/*用户id*/
	int userid=Integer.parseInt(request.getParameter("Userid"));
	/*大赛届数*/
	int CompetitionSession=Integer.parseInt(request.getParameter("CompetitionSession"));
	/*竞赛项目id*/
	int ContestId=Integer.parseInt(request.getParameter("ContestId"));
	/*大赛名字*/
	// String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"GB2312"); 
	/*竞赛项目id*/
	int competitionId=Integer.parseInt(request.getParameter("competitionId"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">	
    <title>报名界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" type="text/css" href="Web/Enrollment/css/enrollment.css">
	<script type="text/javascript" src="Web/Enrollment/js/enrollment.js"></script>
	<script type="text/javascript">
	   var userid=<%=userid%>;
	   var CompetitionSession=<%=CompetitionSession%>;
	   var ContestId=<%=ContestId%>;
	   var competitionId=<%=competitionId%>;
	</script>
  </head>
  
  <body>
    <div class="Enrollmentall">
    <jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
       <div class="Enrollmentmessage">
       
           <div class="messageCompetition">
           <a href="javascript :;" onClick="javascript :history.back(-1);">返回</a>
              <div class="CompetitionTitle">报名大赛资料</div>
              <table class="Competitioninfo" style="font-size:12px;">
                  <tr class="CompetitioninfoName">
                      <th class="CominfoName">大赛名称：</th>
                      <th><div class="CominfoNametext" id="Com_Name" ></div></th>
                  </tr>
                  <tr style="height: 5px;"></tr>
                  <tr  class="CompetitioninfoType">
                  <th class="CominfoType">科目：</th>
					  <th>
			         <select class="CominfoTypetext" id="CominfoTypetext" >
			         <option disabled="true">请选择</option>
			         </select>
			     </th>
                  </tr>
                  
                  <tr style="height: 5px;"></tr>
                  
                  <tr class="CompetitioninfoRank">
	                   <th class="CominfoRank">参赛年级：</th>
	                   <th>
		                   <select class="CominfoRanktext" id="CominfoRanktext" onchange="GetContestId()" onclick="Subject_before()"> 
		                     <option disabled="true">请选择</option>
		                   </select>
	                   </th>
                  </tr>
                  
                  <tr style="height: 5px;"></tr>
                  <tr class="CompetitioninfoPrice">
                      <th class="CominfoPrice">报名费：</th>
                      <th>
                          <div class="CominfoPricetext" id="CominfoPricetext" >请先选择科目和年级</div>
                      </th>
                  </tr>
                  <tr style="height: 5px;"></tr>
                  <tr class="CompetitioninfoMechanism" >
                      <th class="CominfoMechanism">报名机构：</th>
                      <th>
	                      <select class="CominfoMechanismtext" id="CominfoMechanismtext" onclick="Sub_Obj_Before()">
	                          <option>请选择</option>
	                      </select>
                      </th>
                  </tr>
              </table>
           </div>
           
           
           <div class="messageParticipant">
              <div class="ParticipantTitle">参赛者资料</div>
              <div class="Participantinfo">
		          <div class="AddChoice">
		               <div class="Adduser" onclick="AddUserInfo()">
		                   <div class="AddUserPic"></div>
		                   <button class="AddUsername button">用户</button>
		               </div>
		               <div class="AddOther" onclick="AddOtherInfo()">
		                   <div class="AddOtherPic"></div>
		                   <button class="AddOtherPicname button">其他人</button>
		               </div>
		           </div>
		           
	              <table class="ParticipantinfoStudent" style="font-size:12px;">
	                  <!--  <div class="ParticipantPictureInfo">
	                      <div class="ParticipantPic"></div>
	                      <div class="ParticipantStrans">
	        				<%--用来作为文件队列区域--%>
	       					  <div id="fileQueue"></div>
	        				  <input type="file" name="uploadify" id="uploadify" />
	                      </div>
	                  </div>-->
	                  
	                  <tr class="ParticipantinfoName">
	                      <th class="ParinfoName">姓名：</th>
	                      <th><input type="text" class="ParinfoNametext" id="ParinfoNametext"/></th>
	                  </tr>
	                  <tr style="height: 5px;"></tr>
	                  <tr class="ParticipantinfoSex">
	                      <th class="ParinfoSex">性别：</th>
	                      <th><input type="text" class="ParinfoSextext" id="ParinfoSextext"/></th>
	                  </tr>
	                  <tr style="height: 5px;"></tr>
	                   <tr class="ParticipantinfoIDNumber">
	                      <th class="ParinfoIDNumber">身份证号码：</th>
	                      <th><input type="text" class="ParinfoIDNumbertext" id="ParinfoIDNumbertext"/></th>
	                  </tr>
	                  <tr style="height: 5px;"></tr>
	                   <tr class="ParticipantinfoSchool">
	                      <th class="ParinfoSchool">学校名称：</th>
	                      <th><input type="text" class="ParinfoSchooltext" id="ParinfoSchooltext"/></th>
	                  </tr>
	                  <tr style="height: 5px;"></tr>
	                   <tr class="ParticipantinfoGread">
	                      <th class="ParinfoGread">年级：</th>
	                      <th><input type="text" class="ParinfoGreadtext" id="ParinfoGreadtext"/></th>
	                  </tr>
	                  <tr style="height: 5px;"></tr>
	                   <tr class="ParticipantinfoAdress">
	                      <th class="ParinfoAdress">通讯地址：</th>
	                      <th><textarea rows="5" cols="30" class="ParinfoAdresstext" id="ParinfoAdresstext"></textarea></th>
	                  </tr>
	                  <tr style="height: 5px;"></tr>
	                  <tr class="GuardianinfoName">
	                      <th class="GuainfoName">监护人：</th>
	                      <th><input type="text" class="GuainfoNametext" id="GuainfoNametext"/></th>
	                  </tr>
	                  <tr style="height: 5px;"></tr>
	                  <tr class="GuardianinfoPhone">
	                      <th class="GuainfoPhone">监护人号码：</th>
	                      <th><input type="text" class="GuainfoPhonetext" id="GuainfoPhonetext"/></th>
	                  </tr>
	                  <tr style="height: 5px;"></tr>
	                  <tr class="GuardianinfoTeacher">
	                      <th class="GuainfoTeacher">指导老师：</th>
	                      <th><input type="text" class="GuainfoTeachertext" id="GuainfoTeachertext"/></th>
	                  </tr>
	                  <tr style="height: 5px;"></tr>
	                  <tr class="GuardianinfoTeacherPhone">
	                      <th class="GuainfoTeacherPhone">指导老师号码：</th>
	                      <th><input type="text" class="GuainfoTeacherPhonetext" id="GuainfoTeacherPhonetext"/></th>
	                  </tr>
	              </table>
	              
	              
              </div>
           </div>
           
           <div class="enrollmentButton">
              <input type="button" class="enrollmentButtonSave button" value="保存" onclick="Judge_Enroll()">
           </div>
       </div>
       <jsp:include page="../../Common/jsp/End.jsp" flush="true" />
    </div>
  </body>
</html>
