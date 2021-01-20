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
		<title>房间</title>
		<link rel="stylesheet" href="css/admincss/mainroom.css"
			type="text/css"></link>
		<link rel="stylesheet" href="css/common/iconfont/iconfont.css"
			type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/mainroom.js"></script>
		<script type="text/javascript" src="js/adminjs/changeroom.js"></script>
		<script type="text/javascript" src="js/common/comm.js"></script>
	</head>
	<body>
		<jsp:include page="Header.html" flush="true" />
		<div class="content">
			<div class="mainroom">
				<jsp:include page="MainLeft.html" flush="true" />
				<!-- 右侧总div开始 -->
				<div class="mainright">
					<div class="navbar-content">
						<!---------------右界面导航条一开始--查询条件-->
						<div class="top-wrap">
							<div class="condition-title">
								<p>
									<span style="font-weight: bold;">||</span>&nbsp查询条件
								</p>
							</div>
							<div class="navbar">
								<ul>
									<li class="op4-detail">
										<input type="text" class="key_input" id="fuzzy_input"
											placeholder="地址模糊关键字" />
										<div class="op-button" onclick=tosearchroom_button();>
											搜索
										</div>
									</li>
									<li>
										<table
											style="width: 165px; display: inline-block; margin: 0px; padding: 0px">
											<tbody
												style="display: inline-block; margin: 0px; padding: 0px">
												<tr>
													<td style="border: 1px solid #CCC; width: 73px;">
														<input id="in_time" type="text" placeholder="入住日期"
															style="width: 70px; border: none">
													</td>
													<td style="border: 1px solid #CCC; width: 73px;">
														<input id="left_time" type="text" placeholder="退房日期"
															style="width: 70px; border: none">
													</td>
												</tr>
											</tbody>
										</table>
										<div class="op-button" onclick=SearchRoomByTime();>
											搜索
										</div>
									</li>
									<li>
										<div class="op-button" onclick="toseeroom()">
											<i class="iconfont font">&#xf012c</i>&nbsp查看房间
										</div>
										<div class="op-button" onclick="tochangeroom()">
											<i class="iconfont font">&#xf014f</i>&nbsp修改房间
										</div>
										<div class="op-button" onclick="addroom()">
											<i class="iconfont font">&#xf0175</i>&nbsp新增房间
										</div>
										<div class="op-button" id="ActiveOrLock" value="0"
											onclick="activateorlock(0)">
											<i class="iconfont font">&#xf0195</i>&nbsp激活/锁定
										</div>
									</li>
									<div style="clear: both" />
								</ul>
								<div style="clear: both"></div>
							</div>
						</div>
						<div class="buttom-wrap">
							<div class="condition-title">
								<p>
									<span style="font-weight: bold;">||</span>&nbsp数据管理
								</p>
							</div>
							<!-- 数据列表开始 -->
							<div class="mainroomdiv">
								<table class="property">
									<tr>
										<td>
											房间号
										</td>
										<td>
											区域
										</td>
										<td>
											房间类型
										</td>
										<td>
											价格
										</td>
										<td>
											使用状态
										</td>
										<td>
											房间锁状态
										</td>
									</tr>
								</table>
								<div class="mrtruediv"></div>
							</div>
							<div class="fenye">
							</div>
							<!-- 数据列表结束 -->
							<!--清除页面浮动-->
							<div style="clear: both"></div>
						</div>
						<!--清除页面浮动-->
						<div style="clear: both"></div>
					</div>
					<!-- 右侧总div结束 -->
				</div>
			</div>
		</div>
	<jsp:include page="Footer.html" flush="true" />
	</body>
</html>