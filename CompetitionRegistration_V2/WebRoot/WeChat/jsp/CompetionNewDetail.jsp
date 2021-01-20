<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int newsId = -1;
try{
	newsId=Integer.parseInt(new String(request.getParameter("newsId").getBytes("ISO-8859-1"),"utf-8"));
	
}catch(Exception e){
	newsId = -1;
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻详情</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="WeChat/css/CompetionNewDetail.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/js/CompetionNewDetail.js"></script>
	<script type="text/javascript">
		var newsId = <%=newsId%>;
	</script>
  </head>  
  <body>
  	<!-- 标题栏 -->
  	<div class="titlebar">
  		<div class="backbtn"><i class="iconfont font" id="left" onclick="history.go(-1)">&#xf016e</i></div>
  	</div>
    <!-- 新闻详情 -->
    <div class="detailstyle" style="width:100%;height:auto;display:inline-block;">
    </div>
  </body>
</html>
