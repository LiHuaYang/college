<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

   // String subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"), "utf-8");
	//String subject = request.getParameter("subject");
	//String name = request.getParameter("name");
	//String id = request.getParameter("id");
	//String EnrollmentPassword=request.getParameter("EnrollmentPassword");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'QueryScore.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
		<link rel="stylesheet" href="Common/iconfont/iconfont.css"
			type="text/css"></link>
		<link rel="stylesheet" type="text/css"
			href="Web/QueryScore/css/QueryScore.css">
		<script type="text/javascript" src="Web/QueryScore/js/QueryScore.js"></script>

 </head>
	<body>
		<div class="all">
			<div class="query_frame">
				<div class="close_frame">
				<i class="iconfont" onclick="close_score()">&#xf00b3;</i>
				</div>
				<div class="name_sex_pic">
					<div class="name_frame">

					</div>
					<div class="ticket_number">

					</div>

				</div>
				<div class="contest_info">
					<div class="contest_name_frame">

					</div>
					<div class="contest_rank_frame">

					</div>
					<div class="contest_type_frame">

					</div>
				</div>
				<div class = "others">
				<div class="total_score_frame">

				</div>
				<div class="others_frame">
					<div class="others_font">
						备注：
					</div>
					<div class="others_div">
						好好学习，天天向上
					</div>
				</div>
				
				</div>
				<div class = "logo_info">
				<div class = "logo"></div>
				<div class="final_right">
					<div class="final_pic"></div>
					<div class="final_download">
								扫描二维码 下载客户端
							</div>

				</div>

					</div>
			</div>
		</div>
	</body>
</html>
