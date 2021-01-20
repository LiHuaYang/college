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
		<title>管理员主页</title>
		<link rel="stylesheet" href="css/admincss/main.css" type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/main.js"></script>
		<script type="text/javascript" src="js/common/comm.js"></script>
	</head>
	<body>
		<div class="wrap" id="aa">
			<!-- 页面头部开始 -->
			<div class="head">
				<!-- 网站图标 -->
				<div class="web-info-wrap">
					<span class="logo-wrap"><i class="iconfont font">&#xf01ca</i>
					</span>
					<span class="title-wrap"><p>
							远方民宿管理系统
						</p> </span>
				</div>
				<div class="admin-info-wrap">
					<div class="admin-name-wrap">
						<p>
							欢迎Adminietrator
						</p>
					</div>
					<div class="opration-wrap">
						<a href="http://www.w3school.com.cn">修改密码</a><a
							href="http://www.w3school.com.cn">退出登录</a>
					</div>
				</div>
			</div>
			<!-- 页面头部结束 -->

			<!-- 页面内容开始 -->
			<div class="content">
				<div class="mainleft">
					<div class="mainlefthead">
						系统导航
					</div>
					<ul class="left_list">
						<li id="room" onclick=liClick(this);>
							房间管理
						</li>
						<li id="user" onclick=liClick(this);>
							客户管理
						</li>
						<li id="order" onclick=liClick(this);>
							订单管理
						</li>
						<li id="cleaner" onclick=liClick(this);>
							保洁员管理
						</li>
						<li id="message" onclick=liClick(this);>
							消息管理
						</li>
						<li id="financialsettlement" onclick=liClick(this);>
							财务结算
						</li>
						<li id="telephonehelp" onclick=liClick(this);>
							电话帮助
						</li>
					</ul>
				</div>
				<div class="mainright" id="main_right">
					<div class="telephonehelp"></div>
					<div class="mainroom"></div>
					<div class="mainclient"></div>
					<div class="maincleaner"></div>
					<div class="mainorder"></div>
					<div class="messagemanage"></div>
					<div class="financialsettlement"></div>
				</div>
			</div>
			<!-- 页面内容结束 -->

			<!-- 页面底部开始 -->
			<div class="foot">
				<div class="foot-text">
					<p>
						Copyright ©2015 NBUT-YFL501
					</p>
				</div>
			</div>
			<!-- 页面底部结束 -->
		</div>
	</body>

</html>
