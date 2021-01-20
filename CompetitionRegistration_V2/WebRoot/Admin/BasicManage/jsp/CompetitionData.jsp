<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'competitionData.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
		<link rel="stylesheet" href="Admin/CompetitionManage/css/competition.css" type="text/css"></link>
		<link rel="stylesheet" href="Admin/BasicManage/css/CompetitionData.css" type="text/css"></link>
		<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="Admin/Common/common.js"></script>
		<script type="text/javascript" src="Admin/BasicManage/js/CompetitionData.js"></script>
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
	        			大赛基础数据--大赛名
	        		</h5>
        		</div>
        		<ul class="opration-bar">
				  <li>
					<input id="competition_name" class="data-input" type="text" placeholder="请输入需要添加的大赛名"></input>
					<input id="competition_simple_name" class="data-input" type="text" placeholder="请输入需要添加的大赛简称"></input>
					<button class="op-button" onclick="add_competition_name()"><i class="iconfont font">&#xf0175</i>提交大赛名称</button>
				  </li>
				</ul>
				    <table class="data-table">
					  <tr class="odd data-title">
					  	<td style="width:3%;"></td>					  
					    <td style="width:47%">大赛名</td>
					    <td style="width:55%">大赛简称</td>
					  </tr>
					</table>
				<div id="addcompetition"  class="scrolldiv">
        			<table class="data-table">
					</table>
				</div>	
					<br><br>
					
					<div class="right-head">
	        		<h5>
	        			<i class="iconfont font">&#xf017d</i>
	        			大赛基础数据-竞赛科目
	        		</h5>
        		</div>
        		<ul class="opration-bar">
				  <li>
					<input id="competition_project" class="data-input" type="text" placeholder="请输入需要添加的竞赛科目"></input>
					<button class="op-button" onclick="submit_competition_project()"><i class="iconfont font">&#xf0175</i>提交竞赛科目</button>
				  </li>
				</ul>
				<table class="data-table">
					  <tr class="odd data-title">
					  	<td style="width:35px;"></td>					  
					    <td>竞赛科目</td>
					  </tr>
					</table>
				<div id="Competition_project" class="scrolldiv">
        			<table class="data-table">
					</table>
				</div>	
					<br><br>
					
					<div class="right-head">
	        		<h5>
	        			<i class="iconfont font">&#xf017d</i>
	        			大赛基础数据-竞赛对象
	        		</h5>
        		</div>
        		<ul class="opration-bar">
				  <li>
					<input id="competition_object" class="data-input" type="text" placeholder="请输入需要添加的竞赛对象"></input>
					<button class="op-button" onclick="submit_competition_object()"><i class="iconfont font">&#xf0175</i>提交竞赛对象</button>
				  </li>
				</ul>
				<table class="data-table">
					  <tr class="odd data-title">
					  	<td style="width:35px;"></td>					  
					    <td>竞赛对象</td>
					  </tr>
					</table>
					
				<div id="Competition_object" class="scrolldiv">
				<table class="data-table">
				</table>
				</div>
				<br><br>
					
				<div class="right-head">
	        		<h5>
	        			<i class="iconfont font">&#xf017d</i>
	        			大赛基础数据-承办方
	        		</h5>
        		</div>
        		<ul class="opration-bar">
				  <li>
					<button class="op-button" onclick="show_organization()"><i class="iconfont font">&#xf0175</i>新增承办方</button>
				  </li>
				</ul>
				<table class="data-table">
					  <tr class="odd data-title">
					  	<td style="width:35px;"></td>					  
					    <td style="width:100px">承办方名称</td>
					    <td style="width:100px">地址</td>
					    <td style="width:100px">状态</td>
					    <td style="width:100px">联系电话</td>
					    <td style="width:100px">联系人</td>
					  </tr>
					</table>
				<div id="competition_Organization" class="scrolldiv">
        			<table class="data-table">
					</table>
				</div>	
					<br><br>
				<div style="clear:both"></div>
        		</div>
        	</div>
        	<div style="clear:both"></div>
	  	</div>
	  	<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
	  	
		    
		<!-- ------------------------------弹窗样式一------------------------------  -->
	    <div id="add_ompetiton_name_panel" class="bodymiddle" style="display: none;" >
		    <div class="middleFrame">
		        <div class="middleClose" onclick="middleClose()"><i class="iconfont">&#xf00b3;</i></div>
		        <div class="Frameinformation">
					<input id="organization_name" class="data-input" type="text" placeholder="请输入需要添加的承办方名称"></input> 
					<br><br/>
					<input id="organization_address" class="data-input" type="text" placeholder="请输入需要添加的承办方地址"></input>
					<br/>
					<table id="grade1" class="grade-style">
		                <tr><td><input  name="organization_station" type="radio" value="0" />不可报名 </td>              
		                	<td><input name="organization_station" type="radio" value="1" />可以报名</td>
		                </tr>
		                </table>
					<br/>
					<input id="organization_tel" class="data-input" type="text" placeholder="请输入需要添加的承办方电话"></input>
					<br><br/>
					<input id="organization_contacts" class="data-input" type="text" placeholder="请输入需要添加的承办方联系人"></input>
					
			        </div>
			        <button class="Phonetext" onclick="submit_organizationInfo()">确认</button>
		        </div>
		    </div>
		    <!-- ------------------------------弹窗样式------------------------------  -->    
	</body>
</html>
