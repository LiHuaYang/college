<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>历年真题列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="WeChat/css/PastYearsPagerList.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/js/PastYearsPagerList.js"></script>
  </head>
  <body>
  	<!-- 标题栏 -->
  	<div class="titlebar">
  		<div class="backbtn"><i class="iconfont font" id="left" onclick="history.go(-1)">&#xf016e</i></div>
  		<!-- 搜索框 -->
    	<div type="text" class="searchEdit">
    			<div class="iconstyle"><i class="iconfont" style="font-size:1.3em;color:grey;;font-weight:100;">&#xf012c</i></div>
    			<div id="subject_choose" ></div>
    			<div id="grade_choose"></div>
    			<div id="competition_choose"></div>
    			
    	</div>
   	 	<div class="find" onclick="searchTextPagers()">搜索</div>
  	</div>
 	<!-- 条件搜索栏 -->
 	<div class="choosebar">
 		<div class="choosebaritem">
 			<div class="choosebatitem_tip1">科目：</div>
 			<select class="subject" onchange="option_click()">
 				<option>&nbsp;</option>
 			</select>
 		</div>
 		<div class="choosebaritem">
 			<div class="choosebatitem_tip2">年级：</div>
 			<select class="grade" onchange="option_click1()">
 				<option>&nbsp;</option>
 			</select>
 		</div>
 		<div class="choosebaritem">
 			<div class="choosebatitem_tip3">比赛：</div>
 			<select class="competion" onchange="option_click2()">
 				<option>&nbsp;</option>
 			</select>
 		</div>
 	</div>
    <!-- 真题列表 -->
    <div id="pagerlist"></div>
    <div style="width: 100%;height: 3em;"></div>
    <jsp:include page="../Common/bottom.jsp" flush="true" />
  </body>
</html>
