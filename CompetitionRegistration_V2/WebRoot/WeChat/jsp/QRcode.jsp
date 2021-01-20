<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>扫描二维码</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" type="text/css" href="WeChat/css/QRcode.css">
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
  </head>
  
  <body>
  <div class="QR">
     <div class="head">
        <div class="logo">
		<span><i class="iconfont font" id="size"  onclick="history.go(-1)">&#xf016e</i></span>
          <span class="dasai">扫描二维码</span>
        </div>
	 </div>
	 
     <div class="QRpicture"></div>
  </div>
    
  </body>
</html>
