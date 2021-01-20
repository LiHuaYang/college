<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>开始订房</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/WeChat/first.css">
		
  </head>
  
  <body>
	<!-- 页面头部开始 -->
	<div id="head" class="header test-border-blue">
		这里是页面头部
	</div>
	<!-- 页面头部结束 -->

	<!-- 页面中间内容开始 -->
	<div id="content" class="">

		<div id="destination" class="test-border-blue">目的地</div>

		<div id="time" class="test-border-blue">
			<div id="start-time" class="">入住时间</div>
			<div id="days" class="">住宿时间</div>
			<div id="end-time" class="">退房时间</div>
		</div>

		<div id="keyword" class="test-border-blue">关键字/位置/电话</div>

	</div>
	<!-- 页面中间内容结束 -->

	<!-- 页面底部开始 -->
	<div id="foot" class="">
		<div id="" class=""></div>
	</div>
	<!-- 页面底部结束 -->
  </body>
</html>
