<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	int baruserid = 0;
	try {
		baruserid = (Integer) request.getSession().getAttribute(
				"Userid");
	} catch (Exception e) {
		e.printStackTrace();
	}
	int pagerid=Integer.parseInt(request.getParameter("pagerId"));
//	int testYear=Integer.parseInt(request.getParameter("testYear"));
	//  testPaperName=(request.getParameter("testPaperName"));
	String testPaperName = request.getParameter("testPaperName");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>试卷详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="WeChat/css/PastYearsPagerDetail.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/js/PastYearsPagerDetail.js"></script>
	<script type="text/javascript">

	   
	    var userid = <%=baruserid%>;	 
		var pagerId =<%=pagerid%>;
		var testPaperName = "<%=testPaperName%>";
	
	</script>
  </head>

  <body>
    <!-- 标题栏 -->
  	<div class="titlebar">
  		<span><i class="iconfont font" id="size"  onclick="history.go(-1)">&#xf016e</i></span>
  		
  		<div class="title_fix"></div>
  		<div class="collect" onclick="collection()"></div>
  	</div>
  	<!-- 试卷页码 -->
  	<div class="testPageNum">
  	   <div class="fix">
  	   </div>
  	</div>
  	<!-- 分隔线 -->
  	<div class="line"></div>
  	<!-- 试卷内容 -->
  	<div class="content">
  		<!-- 前后翻页提示符 -->
  		<div id="goprev" onclick="goback()"></div>
  		<div id="gonext" onclick="gonext()"></div>
  	</div>
  </body>
</html>
