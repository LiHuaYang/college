<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/common/bar.css">
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common/bar.js"></script>
  </head>
  
  <body>
  <div class="homehead">
			
		
   <div class="comp">
				<i class="iconfont" id="find">&#xf01ca</i>住宿
			</div>
			<i class="iconfont" id="me">&#xf01fd</i>
			<input  class="homehead-input" placeholder="想去哪里就去哪里。"/>
			<div class="homehead-input-right"> 
<!--				<div class="homehead-input-right2">帮助</div>-->
<!--				<div class="homehead-input-right3"onclick="showregister()">注册</div>-->
<!--				<div class="homehead-input-right4"onclick="showlogin()">登录</div>-->
			</div>
</div>
  </body>
</html>
