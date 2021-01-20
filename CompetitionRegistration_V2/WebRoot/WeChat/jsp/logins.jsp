<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    <meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="WeChat/css/logins.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="WeChat/js/logins.js"></script>
  </head>
  
  <body>
    <div class="head">
        <div class="logo">
		<span><i class="iconfont font" id="size"  onclick="history.go(-1)">&#xf016e</i></span>
          <span class="dasai">优赛乐学</span>
        </div>
	</div>
    <div class="ww">
	     <div class="user">
   		       <div id="on" >
   		         <i class="iconfont font" style="font-size:1.5em; color:#737383;padding-left:8px;">&#xf012d</i>  
			    <input class="box" type="text" id="account" placeholder="手机号/昵称"></input>
			</div>
			<div id="on">
				<i class="iconfont font" style="font-size:1.5em;color:#737383;padding-left:8px;">&#xf0195</i>
				 <input class="box" type="password" id="password" placeholder="密码"></input>
		   </div>
	      </div>
	</div>
	      
	 <div class="ww">
			 <button class="submit" onclick="login();">登录</button>
			  <button class="register" onclick="registers();">免费注册</button>
			   <button class="findpass" onclick="find();">忘记密码</button>
			  
    </div>
  </body>
</html>
