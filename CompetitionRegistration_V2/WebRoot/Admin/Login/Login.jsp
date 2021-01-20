<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="Admin/Login/Login.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="Admin/Login/Login.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form id="form1" runat="server">
    <%--NBUT--%>
    <div id="head">
		Welcome to
		<div class="head_font ">
			宁波工程学院
		</div>
	</div>

    <%--内容主体--%>
	<div id="wrap" class="border-test">

		<!-- 邮箱输入框 -->
		<div id="content_mail" class="border-test input-size">
			<div id="mail" class="font">
				学号
			</div>
			<div class="div-input">
                <input id="username" class="input-style" runat="server" type="text" placeholder="学号" />
			</div>
		</div>

		<!-- 密码输入框 -->
		<div id="content_pwd" class="border-test input-size">
			<div id="password"  class="font">
				密码
			</div>
			<div class="div-input">
				<input id="stu_pass" class="input-style" runat="server" type="password" placeholder="密码"/>
			</div>
		</div>

		<!-- 登录状态框 -->
		<div id="content_status" class="border-test">
			<div id="remeberme">
                记住我
            </div>
		</div>

		<!-- 登录按钮框 -->
		<div id="content_btn_login" onclick="login()">
			<button  id="btn_login" class="btn-style">登录</button>
		</div>
	</div>
    </form>
</body>
</html>
