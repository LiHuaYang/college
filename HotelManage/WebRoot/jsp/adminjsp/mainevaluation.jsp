<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>评价</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
    <script type="text/javascript" src="js/common/jq.js"></script>
  	<script type="text/javascript" src="js/adminjs/mainevaluation.js"></script>
  </head>
  <body>
   		<div class="search" style="margin-left:10px;margin-top:10px;">
  		<div class="pos">
			<span class="key_span">模糊关键字：</span>
			<input type="text" class="key_input" id="key_input" />
			<div class="search-btn1" onclick="">搜索</div>
			<div style="float:right; margin-right: 40px;" class="search-btn1" onclick="seeEvaluation()">查看</div>
			</div>
	</div>
  	<div class="mainevaluationdiv" style="margin-left:10px;">
		<div class="metruediv" style="height: 800px; background-color: rgb(241,242,246);"></div>
		<div class="wrap" style="margin-top:0px;">
				<div class="fenye"></div>
		</div>
	</div>
	<div class="shadow" style="display: none;">
		<div class="showpage" style="width:320px; height:380px; margin-left:30%; margin-top: 200px;">
  			<div class="pagehead" style="background-color: rgb(70,70,70);"><font></font><div class="closepage" onclick="closepage()"></div></div>
  			<div class="pagemain" style="padding: 5px; text-align: left;"></div>
  		</div>
  		</div>
  </body>
</html>
