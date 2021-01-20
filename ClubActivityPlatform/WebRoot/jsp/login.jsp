<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" href="css/login.css" type="text/css"></link>
     <script type="text/javascript" src="js/common/jq.js"></script>
     <script type="text/javascript" src="js/login.js"></script>
   </head>
  
  <body id="k">
 		<div class="all">
 			<div class="login">
 				<div class="login-top"><div>登录</div></div>
 				<div class="login-bottom">
 					<div class="login-bottom1"><img src="./img/user.png"/>   USER NUMBER</div>
 					<div class="login-bottom2"> <input type="text" /></div>
 					<div class="login-bottom1"><img src="./img/password.png"/>   PASSWORD</div>
 					<div class="login-bottom2"> <input type="password" /></div>
 					<button onclick="login()">Login...</button>
 				</div>
 			</div>
 		</div>
  </body>
</html>
