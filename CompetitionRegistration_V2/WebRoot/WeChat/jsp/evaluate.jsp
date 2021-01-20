<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			int baruserid=0;
try{
    baruserid=(Integer)request.getSession().getAttribute("Userid");
}catch(Exception e){
    e.printStackTrace();
}
int competitionId=Integer.parseInt(new String(request.getParameter("competitionId").getBytes("ISO-8859-1"),"utf-8"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title></title>
		<meta name="viewport"
			content="width=320,maximum-scale=1,user-scalable=no">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="WeChat/css/evaluate.css" type="text/css">
		<link rel="stylesheet" href="Common/iconfont/iconfont.css"/>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/js/evaluate.js"></script>
	    <script type="text/javascript">
	   var userid = <%=baruserid%>;	 
	   var competitionId = <%=competitionId%>;	 
	</script>
	</head>

	<body>
	<div class="back"><i class="iconfont font" id="left" onclick="javascript:history.back(-1);">&#xf016e</i></div>
		<div class="score">
			<div class="score_1">
				评分：
				<select id="comscore" onchange="changescorecom();">
					<option value="10">
						10分
					</option>
					<option value="9">
						9分
					</option>
					<option value="8">
						8分
					</option>
					<option value="7">
						7分
					</option>
					<option value="6">
						6分
					</option>
					<option value="5">
						5分
					</option>
					<option value="4">
						4分
					</option>
					<option value="3">
						3分
					</option>
					<option value="2" >
						2分
					</option>
					<option value="1" >
						1分
					</option>
				</select>
				<div class="score_1_1">很完美，不容错过</div>
			</div>
		</div>
		<div class="comment">
		评语
		<textarea class = "content" type="text" placeholder="留下你想说的"></textarea>
		</div>
		<div class="confirm"><button class="submit" onclick = "createcommit();">
					确定
				</button></div>
	</body>
</html>
