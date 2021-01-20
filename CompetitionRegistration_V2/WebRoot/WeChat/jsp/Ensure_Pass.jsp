<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String phone = request.getParameter("phone");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Ensure_Pass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="WeChat/css/Ensure_Pass.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="WeChat/js/Ensure_Pass.js"></script>
    
    <script type="text/javascript">
	   var phone=<%=phone%>;
	</script>

  </head>
  
  <body>
    <div class="navigation">
        <div class="back"><i class="iconfont font" id="left" onclick="history.go(-1)">&#xf016e</i></div>
        <div class="font_enroll">设置密码</div>
	</div>
	<div class="phone_box">
		<div class="font_phone">新的密码：</div>
		<input class="input_phone" type="password" id="phone_new" type="text" placeholder="6-20位字符、字母、符号组成"></input>
	</div>
	<div class="phone_again_box">
		<div class="font_phone_again">确认密码：</div>
		<input class="input_phone_again" type="password" id="phone_again" type="text" ></input>
	</div>
	<div class="next">
		<button class="next_butt" onclick="sure_change()">确定</button>
    </div>
  </body>
</html>
