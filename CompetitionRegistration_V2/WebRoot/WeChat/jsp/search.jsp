<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>大赛搜索</title>
        <meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="WeChat/css/search.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="WeChat/js/search.js"></script>
  </head>
  
  <body>
    <div class="navigation">
	        <div class="back"><i class="iconfont font" id="left" onclick="history.go(-1)">&#xf016e</i></div>
	        <div class="box">
				<i class="iconfont font" id="search_color">&#xf012c</i>
				<input type="text" placeholder="赛事，科目，任你搜" class = "searchwords" style="font-size:1em;"></input>
			</div>
			<div class = "search" onclick = "showContestInfo()">搜索</div>
	   </div>
	    <div class="point" id="point">
                   您还没有进行任何查找...
		</div>
        <div id="list">

		</div>
  </body>
</html>
