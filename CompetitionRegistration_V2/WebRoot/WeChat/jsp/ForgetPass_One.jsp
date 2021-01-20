<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="WeChat/css/ForgetPass_One.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="WeChat/js/ForgetPass_One.js"></script>
  </head>
  
  <body>
    <div class="navigation">
        <div class="back"><i class="iconfont font" id="left" onclick="history.go(-1)">&#xf016e</i></div>
        <div class="font_enroll">身份验证</div>
	</div>
	<div class="phone_box">
		<div class="font_phone">手机号：</div>
		<input class="input_phone" id="phone" type="text" placeholder="请输入手机号码"></input>
	</div>
	<div class="behind" >
		<div class="font_phone">验证码：</div>
	    <input class="bbox" type="text"  id="identify" ></input>
	    <input class="get_mess" onclick="getyanz(this)" value="获取验证码"></input>
	</div>
	<div class="next">
		<button class="next_butt" onclick="next_step()">下一步</button>
    </div>
   
  </body>
</html>
