<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bottom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="WeChat/Common/bottom.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/Common/bottom.js"></script>
  </head>
  
  <body>
      <div class="bottombox">
	      <div class="bottomlist">
             <div class="gotoCompetitionlist" onclick="gotoCompetitionlist()">大赛</div>
             <div class="gotoTest" onclick="gotoTest()">试卷</div>
             <div class="gotoNews" onclick="gotoNews()">新闻</div>
             <div class="gotoMine" onclick="gotoMine()">我的</div>
	      </div>
      </div>
  </body>
</html>
