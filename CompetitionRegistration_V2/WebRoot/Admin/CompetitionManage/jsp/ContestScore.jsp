<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>ContestScorejsp</title>
    <link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="Admin/Common/Page/paging.js"></script>
    <script type="text/javascript" src="Admin/CompetitionManage/js/contestScore.js"></script>
    <script type="text/javascript" src="Admin/Common/common.js"></script>
  </head>
    <body>
 	<div id="wrap">
	  	<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
	  	<div id="content">
	  		<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
        	<div id="mainright">
        	    <div class="right-head">
	        		<h5>
	        			<i class="iconfont font">&#xf017d</i>
	        			大赛管理--大赛成绩
	        		</h5>
        		</div>
				  <ul class="opration-bar">
				  <li>
					<input type="text" id="contest_name_keyword" placeholder="用户姓名模糊关键字"></input>
					<button class="op-button" onclick="search()"><i class="iconfont font">&#xf012c</i>查找</button>
				  </li>
				  
        				<li>
        					<span style="font-size:0.80em;">大赛选择:</span>
        					<select class="Verificationselect" id="select_competiiton">
		                	
		                </select>
		                	<span style="font-size:0.80em;">科目选择:</span>
        					<select class="Verificationselect" id="select_sub" onclick="addSubSelectData()">
        					<option selected="true" disabled="true" onclick="">科目</option>
		                </select>
        					<button class="op-button" onclick="searchCompetitionNameAndSubject()"><i class="iconfont font">&#xf012c</i>查找</button>
        				</li>
        			</ul>
        			
        			<table class="data-table">
					  <tr class="odd data-title">
					 	<td style="width:35px;"></td>
					    <td>姓名</td>
					    <td>准考证号</td>
					    <td>大赛名</td>
					    <td>大赛科目</td>
					    <td>用户成绩</td>
					  </tr>
					  <%for (int i=0; i<10; i++) { %>
					  <tr class="odd">
					    <td><input name="box" type="checkbox" value="Heating"></td>
					    <td id="studentName" onclick="do_onclick(this)"></td>
					    <td id="studentTicket" onclick="do_onclick(this)"></td>
					    <td id="competitionName" onclick="do_onclick(this)"></td>
					    <td id="contestSubject" onclick="do_onclick(this)"></td>
					    <td id="studentscore" onclick="do_onclick(this)"></td>
					  </tr>
					  <% } %>
					</table>
					<jsp:include page="../../Common/Page/Page.jsp" flush="true" />
        		</div>
        	</div>
        	<div style="clear:both"></div>
	  	<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
  	</div>
</body>
</html>
