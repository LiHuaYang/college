<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'mainclient.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
	<link rel="stylesheet" href="css/common/iconfont/iconfont.css" type="text/css"></link>
    <script type="text/javascript" src="js/common/jq.js"></script>
  	<script type="text/javascript" src="js/adminjs/rechargehis.js"></script>
  </head>
  
  <body>
  	<div class="mainroom" >
			<!-- 右侧总div开始 -->
			<div class="navbar-content">
				<!--
				-------------右界面导航条一开始--查询条件
				-->
				<div class="top-wrap">
					<div class="condition-title"><p><span style="font-weight:bold;">||</span>&nbsp查询条件</p></div>
					<div class="navbar">
						<ul >
						<li class="op4-detail">
						<span class="key_span">模糊关键字：</span>
						<input type="text" class="key_input" id="RoomDetailAddress" />
						</li>
						<li>
						<div class="op-button" onclick="tosearchroom_button()">搜索</div>
						</li>
						</ul>
						<div style="clear:both"></div>
					</div>
				</div>
				<!--
				-------------右界面导航条一结束--查询条件
				-->
					<!-- 数据列表开始 -->
					<div class="buttom-wrap">
						<div class="condition-title"><p><span style="font-weight:bold;">||</span>&nbsp数据管理</p></div>
					<div class="mainhistorydiv">
						<table class="property">
							<tr>
							<td>充值记记录号	</td>
							<td>充值时间</td>
							<td>充值金额</td>
							<td>客户号</td>
							</tr>
						 </table>
						<div class="mhtruediv">
						</div>
						<div class="fenye"></div>
					</div>
					<!-- 数据列表结束 -->
					<!--清除页面浮动-->
					<div style="clear:both"></div>					
				</div>
				</div>
				<!--
				-------------右界面导航条二结束--数据列表
				-->
				<!--清除页面浮动-->
				<div style="clear:both"></div>
			</div>
			<!-- 右侧总div结束 -->
  </body>
</html>
