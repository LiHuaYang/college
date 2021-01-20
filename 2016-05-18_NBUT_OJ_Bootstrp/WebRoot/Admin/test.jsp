<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>


<form action="${pageContext.request.contextPath}sub/submit.jsp" method="post"> 
</form> 



<form action="ContestActionV2">

<input type="text" style="display:none" name="method" value="getContest">
<input type="text" style="display:none" name="id" value="1028">  

<input type="submit" vlaue="提交" />
</form>
</body>
</html>