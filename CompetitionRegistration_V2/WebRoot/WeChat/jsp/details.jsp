<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int baruserid = 0;
	try {
		baruserid = (Integer) request.getSession().getAttribute("Userid");
	} catch (Exception e) {
		e.printStackTrace();
	}
	/*竞赛项目id*/
	int competitionId = Integer.parseInt(new String(request.getParameter("competitionId").getBytes("ISO-8859-1"),"utf-8"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>详细信息</title>
		 <meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="WeChat/css/details.css" type="text/css">
		<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css">
		<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/js/details.js"></script>
	<script type="text/javascript">
	   var competitionId=<%=competitionId%>;
	   var userid = <%=baruserid%>;	 
	</script>
	</head>

	<body>
	<div class="back"><i class="iconfont font" id="left" onclick="history.go(-1)">&#xf016e</i></div>
		<div class="fl"></div>
		<div class="score"></div>
		<div class="head"></div>
		<div class="main">

		</div>
		<div class="introduction">
			
		</div>
		
		<%--<div class="foot">
			<div class="sort">
				<div class="key">
					<div>1</div>
					<div>大赛排行</div>
				</div>
				<div class="key">
					<div>344</div>
					<div>周报名人数</div>

				</div>
				<div class="key" id="help" >
					<div>201111</div>
					<div>累计报名人数</div>
				</div>
			</div>
		</div>--%>
		<div class="evaluates">
			<div class="evaluates_1">
				<div class="evaluates_number">
					
				</div>
				<div class="list">

			</div>
			<div class = "more" >没有更多</div>
		</div>
		</div>
	</body>
</html>
	