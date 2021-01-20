<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>意见反馈</title>
     <meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<link rel="stylesheet" href="WeChat/css/feedback.css" type="text/css" >

  </head>
  
  <body>
    <div class="navigation">
        <div class="back"><i class="iconfont font" id="left" onclick="history.go(-1)">&#xf016e</i></div>
        <div class="font_enroll">意见反馈</div>
	</div>
	 <div class="ww">
	     <div class="white">	        
		    <input class="box1" type="text" id="account" placeholder="输入你的反馈..."></input>
		 </div>
				 <input class="box2" type="text" id="password" placeholder="手机号码（选填）"></input>
		
		  <div class="on">
			 <button class="submit" onclick="goto();">提交</button>	  
        </div>
	</div>
  </body>
</html>
