<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>查询成绩界面</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="WeChat/css/SearchResult.css" type="text/css" >
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/js/SearchResult.js"></script>
  </head>
  <body>
  	<!-- 标题栏 -->
  	<div class="titlebar">
  		<div class="backbtn" onclick="backevent()"><</div>
  		<div class="title_tip">我的比赛</div>
  	</div>
  	<!-- 查询成绩 -->
  	<div class="searchResult">
  	  <div class="search">
  		<div class="input_style" >
  			<div class="input_tip">大赛名称:</div>
  			<div class="input_tip" >考生姓名:</div>
  			<div class="input_tip">准考证号码:</div>
  		</div>
  		<div class="input">
  			<input type="text" id="comName"/>
  			<input type="text" id="stdName"/>
  			<input type="text" id="admCard"/>
  		</div>
  		<button class="btnstyle" onclick="getCompetionResultInfo()">查询</button>
  	  </div>
  	</div>
  	<!-- 分隔区 -->
  	<div class="division"></div>
  	<!-- 成绩列表 -->
  	<div class="resultList"></div>
  </body>
</html>
