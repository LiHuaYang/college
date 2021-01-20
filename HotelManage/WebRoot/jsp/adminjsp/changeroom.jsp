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
		<title>修改房间页面</title>
		<link rel="stylesheet" href="css/admincss/mainroom.css"
			type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/main.js"></script>
		<script type="text/javascript" src="js/adminjs/seeroom.js"></script>
		<script type="text/javascript" src="js/adminjs/changeroom.js"></script>
		<script type="text/javascript" src="js/common/comm.js"></script>
	</head>
	<body>
		<jsp:include page="Header.html" flush="true" />
		<div class="content">
			<jsp:include page="MainLeft.html" flush="true" />
			<div class="mainright">
				<ul class="room-info-wrap">
					<li>
						<!--TODO:    condition-title需要修改    -->
						<div class="condition-title">
							<p>
								<span style="font-weight: bold;">||</span>&nbsp基本信息
							</p>
						</div>
						<table class="data-table">
							<tr class="odd">
								<td>
									房间ID:
								</td>
								<td id="infoId">
								</td>
								<td>
									密码:
								</td>
								<td>
									<input id="infopwd" type="text">
								</td>
							</tr>
							<tr>
								<td>
									房间类型:
								</td>
								<td>
									<select name="selectRoomType" id="selectRoomType">
										<option value="1">
											标间
										</option>
										<option value="2">
											单人间
										</option>
										<option value="3">
											套房
										</option>
									</select>
								</td>
								<td >
									房间号码:
								</td>
								<td  id="infoaddress"> 
								</td>
							</tr>

							<tr class="odd">
								<td>
									房间详细地址:
								</td>
								<td id="infodetailaddress">
								</td>

								<td>
									房间价格:
								</td>

								<td>
									<input id="inforoomprice" type="text" >
								</td>
							</tr>
						</table>
					</li>
					<li>
						<input class="op-button" type="submit" value="确认" onclick="ChangeRoom()"/>
					</li>
					<li>
						<div class="condition-title">
							<button class="tag-button" onclick=judge(this);>
								<span class="split">||</span>房间评价
							</button>
							<button class="tag-button" onclick=judge(this);>
								<span class="split">||</span>7天记录
							</button>
						</div>
						<div class="mainevaluationdiv">
							<table class="property">
								<tr>
									<td>
										客户评价号</
									</td>
									<td>
										客户号
									</td>
									<td>
										清洁工号
									</td>
									<td>
										评价时间
									</td>
									<td>
										评价内容
									</td>
									<td>
										评价星级
									</td>
								</tr>
							</table>
							<div class="mrtruediv"></div>
							<div class="fenye"></div>
						</div>
					</li>
				</ul>
			</div>
			<div style="clear: both"></div>
		</div>
		<jsp:include page="Footer.html" flush="true" />
	</body>
</html>
