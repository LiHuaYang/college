<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="javax.sound.midi.SysexMessage"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String condition = request.getParameter("condition");  //大赛名称或科目名称
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SearchCompetition.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="Web/SearchCompetition/css/SearchCompetition.css">
	<script type="text/javascript" src="Web/SearchCompetition/js/SearchCompetition.js"></script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		var condition=<%=condition%>;
	</script>

  </head>
  
  <body>
    <jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
    <div class="all">
    	<div class="com_box">
    		<div class="com_each">
    			
			</div>
    	</div>
    </div>
    <jsp:include page="../../Common/jsp/End.jsp" flush="true" />
  </body>
</html>
