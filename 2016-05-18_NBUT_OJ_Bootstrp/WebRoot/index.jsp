<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<h1></h1>
<script language="JavaScript">
	var path = '${pageContext.request.contextPath}';
	setTimeout("window.location.href='" + path+ "/Front/Pages/problem_list.html'",0);
</script>


</body>
</html>