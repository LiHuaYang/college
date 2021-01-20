<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'corporationlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
	<link href="css/common/searchlow.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/corporationlist.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
 		<script type="text/javascript" src="js/common/searchlow.js"></script>
    <script type="text/javascript" src="js/corporationlist.js"></script>
	
  </head>
  
  <body id="k">
  	
  	<div class="cpic">
  	<div class="heads"></div>
  	<div class="corporationsearch">
  		<div class="corporationsearch-black">
  			<div>
  			<input type="text" class="corporationsearch-input" placeholder="    搜索社团、关键字"/>
  			 <div id="tip"></div>
  			<div class="corporationsearch-button" onclick="searchcorporation()">搜索</div>
  			</div>
  			<div class="hotcorporation">热门社团：</div>
  			<font class="corporationsearch-max" onclick="showcorporation()">查看全部社团列表>></font>
  		</div>
  	</div>
  	</div>
  	<div class="corporationlist">
  		<div class="corporationline">
  		</div>
  		<div class="corporationline"></div>
  		<div class="corporationline"></div>
  		<div class="corporationline"></div>
  	</div>
  </body>
</html>
