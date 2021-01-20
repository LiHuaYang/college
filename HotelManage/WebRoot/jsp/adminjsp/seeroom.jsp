
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	// String RoomId = request.getParameter("RoomId");
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>房间详情</title>
		<link rel="stylesheet" href="css/admincss/mainroom.css"
			type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/main.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/seeroom.css" type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/common/comm.js"></script>
		<script type="text/javascript" src="js/adminjs/mainevaluation.js"></script>
		<script type="text/javascript" src="js/adminjs/seeroom.js"></script>
		<link rel="stylesheet" href="css/common/iconfont/iconfont.css"
			type="text/css"></link>
	</head>
	<body>
	<jsp:include page="Header.html" flush="true" />
			<!-- 页面内容开始 -->
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
									<td>房间ID:</td>
									<td id="infoId">00001</td>
									<td>密码:</td>
									<td id="infopwd">woooo</td>
								</tr>
								<tr>
								<td>房间类型:</td>
								<td id="infotype">普通房</td>
								<td>房间号码:</td>
								<td id="infoaddress">江东1号房</td>
								</tr>
								<tr class="odd">
									<td>房间详细地址:</td>
									<td id="infodetailaddress">经度110纬度110</td>
									<td>房间价格:</td>
									<td id="inforoomprice">90小时/晚</td>
								</tr>
							</table>
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
			</div>
			<div style="clear: both"></div>
			<jsp:include page="Footer.html" flush="true" />
	</body>
	<script type="text/javascript">
		//function getQueryString(name) { 
			//var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
			//var r = window.location.search.substr(1).match(reg); 
			//if (r != null) 
				//return unescape(r[2]); 
			//return null; 
		//}
		// alert("asdasdasdasdas");
		//var RoomId = getQueryString("RoomId");
		///alert(RoomId);
		
		// getRoomDetailInfo();
		// var str = "sadada";
		// $("#infoId").html(str); 
	</script>
</html>