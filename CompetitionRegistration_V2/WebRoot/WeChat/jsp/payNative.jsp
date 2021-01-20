<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String code_url = request.getParameter("code_url");		//订单详情扩展字符串
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<base href="<%=basePath%>">
		<title>扫码</title>
		<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="Common/Tool/jquery.qrcode.min.js"></script>

	</head>
	<body>

		<div id="qrcode">

		</div>

		<script type="text/javascript">

		 var code_url = "<%=code_url%>";
		 console.log(code_url);
		 $(document).ready(function(){
			 $('#qrcode').qrcode({width: 200,height: 200,text: code_url});
		 });

	</script>

	</body>



</html>