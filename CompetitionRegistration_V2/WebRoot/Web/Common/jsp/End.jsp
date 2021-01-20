<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'End.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="Web/Common/css/End.css">
	
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>

  </head>
  
  <body>
    <div class="final">
    <div class = "final_1">
    				<div class="final_left">
    					<div class="final_line_first">
    						<div class="final_company">宁波资优教育科技有限公司</div>
    						<div class="final_company_eng">Copyright 2006-2016 Mtime.com Inc.All rights reserved</div>
    					</div>
    					<div class="final_line_second">
    						<div class="final_card1">京ICP证050715号</div>
    						<div class="final_card2">网络视听许可证0108265号</div>
    						<div class="final_card3">网络文化经营许可证</div>
    						<div class="final_card4">京公网安备：110105000744号</div>
    					</div>
    				</div>
    				<div class="final_right">
    					<div class="final_pic"></div>
    					<div class="final_download">扫描二维码 下载客户端</div>
    				</div>
    				</div>
    			</div>
  </body>
</html>
