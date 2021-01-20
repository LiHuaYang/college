<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int baruserid=0;
try{
    baruserid=(Integer)request.getSession().getAttribute("Userid");
}catch(Exception e){
    e.printStackTrace();
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EnrollCompetition.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="WeChat/css/EnrollCompetition.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/js/EnrollCompetition.js"></script>
	
	<script type="text/javascript">
		 var baruserid=<%=baruserid%>;
	</script>

  </head>
  	
  <body>
    <div class="navigation">
        <div class="back"><i class="iconfont font" id="left" onclick="history.go(-1)">&#xf016e</i></div>
        <div class="font_enroll">已报名比赛</div>
	</div>
	<div class="enroll_each_box">
		
	</div>
  </body>
</html>
