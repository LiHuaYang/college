<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Enrollment</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body style="text-align:center">
  <%--
	<c:foreach var="item" items="${json}">
	</c:foreach>
	  --%>
	  <table border=1 width=400px >
	  <tr>
	    <th>本地用户ID</th>
	    <td><%out.write((String)request.getAttribute("localuserid"));%></td>
	  </tr>
	  
	  <tr>
	  	<th>微信端ID</th>
	    <td><%out.write((String)request.getAttribute("openid"));%></td>
	  </tr>
	  
	  <tr>
	  	<th>总金额</th>	
	    <td><%out.write((String)request.getAttribute("total_fee"));%></td>
	  </tr>
	  
	  <tr>
	  	<th>微信订单号</th>
	    <td><%out.write((String)request.getAttribute("transaction_id"));%></td>
	  </tr>
	  <tr>
	  	<th>商户订单号</th>
	    <td><%out.write((String)request.getAttribute("out_trade_no"));%></td>
	  </tr>
	  <tr>
	  	<th>下单时间</th>
	    <td><%out.write((String)request.getAttribute("time_end"));%></td>
	  </tr>
	  <tr>
	  	<th>附加信息</th>
	    <td><%out.write((String)request.getAttribute("attach"));%></td>
	  </tr>
	</table>

  </body>
</html>
