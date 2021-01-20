<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>订单</title>
 	<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
 	<link rel="stylesheet" href="css/admincss/seeroom.css" type="text/css"></link>
	<script type="text/javascript" src="js/common/jq.js"></script>
	<script type="text/javascript" src="js/common/comm.js"></script>
	<script type="text/javascript" src="js/adminjs/mainorder.js"></script>
	
		
  </head>
  <body>
  <div class="financialsettlement"> 
   <div class="condition-title">
                                <button class="tag-button" onclick="judge(this)">今日收益</button>
                                <button class="tag-button" onclick="judge(this)">维护费用</button>
                                </div>
									<table class="property" class="financialsettlementdiv" id="money1" style="display:block">
										<tr>
											<td>消费记录号</td>
											<td>消费时间</td>
											<td>消费金额</td>
											<td>下单名字</td>
											<td>下单手机号</td>
											<td>下单身份证</td>
											<td>消费地点</td>
											<td>客户号</td>
										</tr>
									</table>
									<table class="property" id="money2" style="display:none" >
										<tr>
											<td>充值记记录号</td>
											<td>充值时间</td>
											<td>充值金额</td>
											<td>客户号</td>
										</tr>
									</table>
  </div>
 </body>
</html>
