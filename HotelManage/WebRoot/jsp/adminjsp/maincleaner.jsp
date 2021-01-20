<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<title>保洁员</title>
		<link rel="stylesheet" href="css/admincss/mainroom.css"
			type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/common/comm.js"></script>
		<script type="text/javascript" src="js/adminjs/maincleaner.js"></script>
	</head>
	<body>
		<jsp:include page="Header.html" flush="true" />
		<div class="content">
			<div class="maincleaner">
				<jsp:include page="MainLeft.html" flush="true" />
				<!-- 右侧总div开始 -->
				<div class="mainright">
					<div class="navbar-content">
						<div class="top-wrap">
							<div class="condition-title">
								<p>
									<span style="font-weight: bold; color: white;">||</span>&nbsp查询条件
								</p>
							</div>
							<div class="navbar">
								<ul>
									<li class="op4-detail">
										<input type="text" class="key_input" id="RoomDetailAddress"
											placeholder="模糊关键字" />

										<div class="op-button" onclick=tosearchroom_button();>
											搜索
										</div>
									</li>
									<li>
										<div class="op-button" onclick=toseecleaner();>
											<i class="iconfont font">&#xf012c</i>&nbsp查看保洁员
										</div>
										<div class="op-button" onclick=toModifyCleanerPage();>
											<i class="iconfont font">&#xf014f</i>&nbsp修改保洁员
										</div>
										<div class="op-button" onclick=addcleaner();>
											<i class="iconfont font">&#xf0175</i>&nbsp新增保洁员
										</div>
										<div class="op-button" onclick=workarrange();>
											<i class="iconfont font">&#xf0175</i>&nbsp新增工作安排
										</div>
										<div class="op-button" value="0" onchange="activateorlock3()">
											<i class="iconfont font">&#xf0195</i>&nbsp激活
										</div>
										<div class="op-button" value="1" onchange="activateorlock3()">
											<i class="iconfont font">&#xf00c9</i>&nbsp锁定
										</div>
									</li>
									<div style="clear: both"></div>
								</ul>
								<div style="clear: both"></div>
							</div>
						</div>
						<div class="buttom-wrap">
							<div class="condition-title">
								<p>
									<span style="font-weight: bold; color: white;">||</span>&nbsp数据管理
								</p>
							</div>
							<!-- 数据列表开始 -->
							<div class="maincleanerdiv">
								<table class="property">
									<tr>
										<td>
											清洁工号
										</td>
										<td>
											清洁工名
										</td>
										<td>
											性别
										</td>
										<td>
											电话
										</td>
										<td>
											状态
										</td>
										<td>
											身份证号
										</td>
									</tr>
								</table>
								<div class="mrtruediv"></div>
								<div class="fenye"></div>
							</div>
							<!-- 数据列表结束 -->
							<!--清除页面浮动-->
							<div style="clear: both"></div>

						</div>
						<div style="clear: both"></div>
					</div>
					<!-- 右侧总div结束 -->
				</div>
			</div>
		</div>
		<jsp:include page="Footer.html" flush="true" />
	</body>
</html>
