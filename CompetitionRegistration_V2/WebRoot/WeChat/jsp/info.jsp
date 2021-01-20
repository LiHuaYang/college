<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	/*大赛届数*/
	int CompetitionSession = Integer.parseInt(request.getParameter("CompetitionSession"));
	String CompetitionName = request.getParameter("CompetitionName");
	/*竞赛项目id*/
	int competitionId = Integer.parseInt(request.getParameter("competitionId"));
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>填写报名信息</title>
    <meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="WeChat/js/info.js"></script>
    <link rel="stylesheet" href="WeChat/css/info.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
  
    <script type="text/javascript">
  	  var userid = '<%=session.getAttribute("Userid")%>';
  	  var CompetitionSession=<%=CompetitionSession%>;
  	  var competitionId=<%=competitionId%>;	 
	  var CompetitionName='<%=CompetitionName%>';	 
	</script>

  </head>
  
  <body>
    <div class="head">
        <div class="logo">
		<span><i class="iconfont font" id="size"  onclick="history.go(-1)">&#xf016e</i></span>
          <span class="dasai">填写报名信息</span>
        </div>
	</div>
    <div class="last">
        <div class="ww">
			<div class="user-pic"></div>
			<div class="user">
				<div id="on">
				    <div class="on-info">姓名：</div>
					<input class="box" type="text" id="name"></input>
				</div>
				<div id="on">
				    <div class="on-info">性别：</div>
					<select class="box" id="sex"> 
		                     <option>男</option>
		                     <option>女</option>
		            </select>
				</div>
			</div>
		</div>
		
		<div class="ww2">报名大赛资料：<span class="red">（*为必填信息）</span></div>
		
        <div class="ww3">
				<div id="in">
				    <div class="in-info">大赛名称：</div>
					<input type="text"  disabled="disabled" class="box-info" id="contname" value="<%=CompetitionName%>"></input>
				</div>
				<div id="in">
				     <div class="in-info" ><span class="red">*</span>参赛科目：</div>
					 <div class="ContestSubjectinfo">
  					 </div>	
				</div>
				<div id="in">
				    <div class="in-info"><span class="red">*</span>参赛年级：</div>
					<select class="ContestObject" id="CominfoRanktext" onchange="GetContestId()"> 
		                     <option disabled="true">请先选择参赛科目</option>
		            </select>
				</div>
				<div id="in">
				    <div class="in-info">报名费：</div>
						
						 <input type="text"  disabled="disabled" class="CominfoPricetext" id="CominfoPricetext" placeholder="请先选择大赛和科目"/>
				</div>
				<div id="in">
				    <div class="in-info">报名机构：</div>
					 <select class="CominfoMechanismtext" id="CominfoMechanismtext">
	                          <option>请选择</option>
	                          </select>
				</div>
		</div>
			<div class="ww2">参赛者资料：</div>
		
        <div class="ww3">
				<div id="in">
				    <div class="in-info"><span class="red">*</span>身份证号：</div>
					<input class="box" type="text" id="idnumber"></input>
				</div>
				<div id="in">
				    <div class="in-info"><span class="red">*</span>学校名称：</div>
					<input class="box" type="text" id="school"></input>
				</div>
				<div id="in">
				    <div class="in-info"><span class="red">*</span>所在年级：</div>
					
						<select class="box" id="grade"  >
						        <option>请选择</option>
		   					    <option>小学一年级</option>
		   					    <option>小学二年级</option>
		   					    <option>小学三年级</option>
		   					    <option>小学四年级</option>
		   					    <option>小学五年级</option>
		   					    <option>小学六年级</option>
		   					    <option>初中一年级</option>
		   					    <option>初中二年级</option>
		   					    <option>初中三年级</option>
		   					    <option>高中一年级</option>
		   					    <option>高中二年级</option>
		   					    <option>高中三年级</option>
		   					</select>
				</div>
				<div id="in">
				    <div class="in-info">通讯地址：</div>
					<input class="box" type="text" id="address"></input>
				</div>
		</div>
			<div class="ww2">联系：</div>
		
        <div class="ww3">
				<div id="in">
				    <div class="in-info"><span class="red">*</span>监护人：</div>
					<input class="box" type="text" id="man"></input>
				</div>
				<div id="in">
				    <div class="in-info"><span class="red">*</span>监护人号码：</div>
					<input class="box" type="text" id="phone"></input>
				</div>
				<div id="in">
				    <div class="in-info">指导老师：</div>
					<input class="box" type="text" id="tman"></input>
				</div>
				<div id="in">
				    <div class="in-info">电话号码：</div>
					<input class="box" type="text" id="tphone"></input>
				</div>
		</div>
		 <div class="ww">
			 <button class="submit" onclick="Judge_Enroll()">点击报名</button>
         </div>
	</div>
  </body>
</html>
