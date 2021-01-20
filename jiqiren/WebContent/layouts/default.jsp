<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dolores Abernathy</title>

<link rel="stylesheet" type="text/css" href="${ctx}/style/css/amazeui.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/style/css/admin.css">
<link rel="Shortcut Icon" href="${ctx}/favicon.ico">

<sitemesh:head/>

</head>
<body>
	<%@ include file="/layouts/header.jsp"%>
	<div class="am-cf admin-main">
		<%@ include file="/layouts/sidebar.jsp"%>
		<div class="admin-content">
			<div class="admin-content-body">
				<script src="${ctx}/script/jquery-1.11.1.min.js" type="text/javascript"></script>
				<!--<![endif]-->
				<script src="${ctx}/script/amazeui.min.js" type="text/javascript"></script>
				<script src="${ctx}/script/app.js" type="text/javascript"></script>
				<sitemesh:body/> 
			</div>
		<%@ include file="/layouts/footer.jsp"%>
		</div>
	</div>

</body>
</html>