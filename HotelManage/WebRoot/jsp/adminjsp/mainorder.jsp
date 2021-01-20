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
		<title>订单</title>
		<link rel="stylesheet" href="css/admincss/mainroom.css"
			type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/mainorder.js"></script>
	</head>
	<body>
		<jsp:include page="Header.html" flush="true" />
		<div class="content">
			<div class="mainorder">
			<jsp:include page="MainLeft.html" flush="true" />
				<!-- 右侧总div开始 -->
				<div class="mainright">
					<div class="navbar-content">
						<!---------------右界面导航条一开始--查询条件-->
						<div class="top-wrap">
							<div class="condition-title">
								<p>
									<span style="font-weight: bold; color: white;">||</span>&nbsp;查询条件
								</p>
							</div>
							<div class="navbar">
								<ul>
									<li class="op4-detail">
										<input type="text" class="key_input" id="RoomDetailAddress"
											placeholder="地址模糊关键字" />
										<div class="op-button" onclick=toseeorderbyaddress_button();>
											搜索
										</div>
									</li>
									<li>
										<div class="op-button" onclick=toseeorder();>
											<i class="iconfont font">&#xf012c</i>&nbsp查看订单
										</div>
										<div class="op-button" onclick=tochangeorder();>
											<i class="iconfont font">&#xf014f</i>&nbsp修改订单
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
									<span style="font-weight: bold; color: white;">||</span>&nbsp;数据管理
								</p>
							</div>
							<!-- 数据列表开始 -->
							<div class="mainorderdiv">
								<table class="property">
									<tbody>
										<tr>
											<td>
												订单号
											</td>
											<td>
												入住天数
											</td>
											<td>
												入住人数
											</td>
											<td>
												入住时间
											</td>
											<td>
												下单时间
											</td>
											<td>
												退房时间
											</td>
											<td>
												付款金额
											</td>
										</tr>
									</tbody>
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
				</div>
				<!-- 右侧总div结束 -->
			</div>
		</div>
		<jsp:include page="Footer.html" flush="true" />
	</body>
</html>
