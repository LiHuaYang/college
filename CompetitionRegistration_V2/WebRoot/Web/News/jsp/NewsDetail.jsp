<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

int newsid=Integer.parseInt(request.getParameter("newsid"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'NewsDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Web/News/css/NewsDetail.css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
    <script type="text/javascript" src="Web/News/js/NewsDetail.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		var newsid=<%=newsid%>;
	</script>

  </head>
  
  <body>
  	<jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
  	<div class="all">
  		<div class="TopNews"><div class = "goleft"><i class="iconfont" id="goleft_1" onclick="toprevious();">&#xf016e;</i></div>
  		<div class = "goright"><i class="iconfont" id="goright_1" onclick="tonext();">&#xf016d;</i></div></div>
  		<div class="news_detail">
  			<div class="news_title_box">
  				
  			</div>
  			<div class="news_content_box">
  				
  			</div>
  			<div class="news_time_box">
  				
  			</div>
  			<div class="news_from_box">
  				
  			</div>
  		</div>
  			
  	</div>
  </body>
</html>
