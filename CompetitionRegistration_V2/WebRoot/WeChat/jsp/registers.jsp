<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册</title>
	<link rel="stylesheet" href="WeChat/css/registers.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="WeChat/js/registers.js"></script>
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
			      手机号: <input class="box" type="text"  id="phone" placeholder="请输入手机号码"></input>
			</div>
                    <div id="on">
				   密&nbsp;码: <input class="box" type="password" id="password" placeholder="6-20位字母、数字"></input>
		   </div>
		   <div id="behind" >
			        验证码:<input class="bbox" type="text"  id="identify" ></input>
			   <input  type="button" value="获取验证码" onclick="getyzm(this)"></input>
			   
			</div>
	      </div>
	</div>
	 <div class="ww">
		 <button class="submit" onclick="register();">点击注册</button>
    </div>
  </body>
</html>
