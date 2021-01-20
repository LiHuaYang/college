<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body style="text-align: center;">

	<%--数据列表显示--%>
    <table style="margin: 0 auto" width="60%" frame="border" border="1">
    	<tr>
    		<td>id</td>
    		<td>姓名</td>
    		<td>性别</td>
    	</tr>
    	<c:forEach var="item" items="${requestScope.result.pageData}">
    		<tr>
	    		<td><c:out value="${item.id }"   escapeXml="true"/></td>
	    		<td><c:out value="${item.name }" escapeXml="true"/></td>
	    		<td><c:out value="${item.sex }"  escapeXml="true"/></td>
    		</tr>
    	</c:forEach>
    </table>
    
    <%--页码显示 --%>
	<a href="${ctx}/student/getStudents?page=${requestScope.result.startPage}"> 首页 </a>
	<%-- 如果当前页码大于1，显示上一页按钮 --%>
	<c:if test="${requestScope.result.currentPage > 1}">
		<a href="${ctx}/student/getStudents?page=${requestScope.result.currentPage - 1}"> 上一页 </a>
	</c:if>
	
	<c:forEach var="pageNum" begin="${requestScope.result.startPage}" end="${requestScope.result.endPage}" >
		[<a href="${ctx}/student/getStudents?page=${pageNum}"> ${pageNum} </a>]
	</c:forEach>
	
	<%-- 如果当前页码小于总页数，显示下一页按钮 --%>
	<c:if test="${requestScope.result.currentPage < requestScope.result.totalPage }">
		<a href="${ctx}/student/getStudents?page=${requestScope.result.currentPage + 1 }"> 下一页 </a>    
	</c:if>
	<a href="${ctx}/student/getStudents?page=${requestScope.result.endPage}"> 尾页 </a>    
    
</body>
</html>