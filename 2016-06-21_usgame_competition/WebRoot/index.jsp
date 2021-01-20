<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>index</title>
  </head>
  <body>
	  <script language="JavaScript">
		var path = '${pageContext.request.contextPath}';
		setTimeout("window.location.href='" + path+ "/wechat/geren.html'",0);
	</script>
  </body>
</html>
