<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>客户列表</title>
		<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/mainclient.js"></script>
	</head>
	<body>
	<jsp:include page="Header.html" flush="true" />
	<div class="content">
			<div class="mainclient" >
			<jsp:include page="MainLeft.html" flush="true" />
			<div class="mainright" >
				<!-- 右侧总div开始 -->
				<div class="navbar-content">
					<!--
					-------------右界面导航条一开始--查询条件
					-->
					<div class="top-wrap">
						<div class="condition-title"><p><span style="font-weight:bold; color:white;">||</span>&nbsp查询条件</p></div>
						<div class="navbar">
							<ul>
							<li class="op4-detail">
							<input type="text" class="key_input" id="RoomDetailAddress" placeholder="姓名模糊关键字"/>
							<div class="op-button" onclick="tosearchbyname_button()">搜索</div>
							</li>
							<li>
							<input type="text" class="key_input" id="RoomDetailAddress" placeholder="电话号码"/>
							<div class="op-button" onclick="tosearchbyname_button()">搜索</div>
							</li>
							<li>
								<div class="op-button" onclick="toseecustomer()"><i class="iconfont font">&#xf012c</i>&nbsp查看客户</div>
								<div class="op-button" onclick="tocustomerrevise()"><i class="iconfont font">&#xf014f</i>&nbsp修改客户</div>
								<div class="op-button" value="0" onchange="activateorlock2()"><i class="iconfont font">&#xf0195</i>&nbsp激活/锁定</div>
							</li>
							<div style="clear:both"></div>
							</ul>
							<div style="clear:both"></div>
						</div>
					</div>
					<div class="buttom-wrap">
						<div class="condition-title"><p><span style="font-weight:bold; color:white;">||</span>&nbsp数据管理</p></div>
	
						<!-- 数据列表开始 -->
						<div class="mainclientdiv">
							<table class="property">
								<tr>
									<td>客户号</td>
									<td>客户姓名</td>
									<td>登入密码</td>
									<td>客户性别</td>
									<td>客户电话</td>
									<td>客户邮箱</td>
									<td>身份证号</td>
									<td>VIP类型</td>
									<td>客户状态</td>
									<td>账户余额</td>
								</tr>
							</table>
							<div class="mrtruediv"></div>
							<div class="fenye"></div>
						</div>
						<!-- 数据列表结束 -->
						<!--清除页面浮动-->
						<div style="clear:both"></div>					
					</div>
					<div style="clear:both"></div>
				</div>
			</div>
			<!-- 右侧总div结束 -->
		</div>
		</div>
		<jsp:include page="Footer.html" flush="true" />
	</body>
</html>
