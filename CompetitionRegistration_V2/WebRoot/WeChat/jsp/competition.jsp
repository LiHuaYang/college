<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>比赛</title>
		 <meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="WeChat/js/competition.js"></script>
		<link rel="stylesheet" href="WeChat/css/competition.css"
			type="text/css">
	</head>

	<body>
		<div class="search">
			<div class="area">
				宁波
			</div>
			<!--<div class="grade">
				<button class="grade_1" onclick="school(1);">
					小学
				</button>
				<button class="grade_2" onclick="school(2);" >
					初中
				</button>
				<button class="grade_3" onclick="school(3);" >
					高中
				</button>
			</div>
			-->
			<div class="title">  优赛乐学</div>
			<div class="search_butten" onclick = "tosearch();">
				搜索
			</div>
		</div>
		<!--<div class="bar">
			<button id="bar_1" onclick = "enroll(2);">
				正在报名
			</button>
			<button id="bar_2" onclick = "enroll(1);">
				即将开始
			</button>
		</div>
		--><div id="list" style="display:block">
			
		</div>
		<div id="list1" style="display:none">
			
		</div>

		<div style="width: 100%;height: 3em;"></div>
		<jsp:include page="../Common/bottom.jsp" flush="true" />

		  <div class="point" id="point">
                             
		</div>

	</body>
</html>
