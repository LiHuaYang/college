<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>roboter login</title>

<link rel="stylesheet" type="text/css"
	href="${ctx}/style/css/amazeui.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/style/css/admin.css">
<link rel="Shortcut Icon" href="${ctx}/favicon.ico">
<style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>

</head>
<body>

	<div class="header">
		<div class="am-g">
			<h1>Web ide</h1>
			<p>
				Integrated Development Environment<br>代码编辑，代码生成，界面设计，调试，编译
			</p>
		</div>
		<hr>
	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
			<h3>登录</h3>
			<hr>
			<div class="am-btn-group">
				<a href="#" class="am-btn am-btn-secondary am-btn-sm"><i
					class="am-icon-github am-icon-sm"></i> Github</a> <a href="#"
					class="am-btn am-btn-success am-btn-sm"><i
					class="am-icon-google-plus-square am-icon-sm"></i> Google+</a> <a
					href="#" class="am-btn am-btn-primary am-btn-sm"><i
					class="am-icon-stack-overflow am-icon-sm"></i> stackOverflow</a>
			</div>
			<br> <br>

			<form method="post" class="am-form" action="${ctx}/admin/login">
				<label for="email">邮箱:</label> 
				<input type="email" name="email" id="email" value=""> 

				<br> 
				<label for="password">密码:</label>
				<input type="password" name="pswd" id="password" value=""> <br>
				
				
				<label for="remember-me"> <input id="remember-me"
					type="checkbox"> 记住密码
				</label> <br>
				<div class="am-cf">
					<input type="submit" name="" value="登 录"
						class="am-btn am-btn-primary am-btn-sm am-fl"> <input
						type="submit" name="" value="忘记密码 ^_^? "
						class="am-btn am-btn-default am-btn-sm am-fr">
				</div>
			</form>
			
			<hr>
			
			<p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
		</div>
	</div>
	<script src="${ctx}/script/jquery-1.11.1.min.js" type="text/javascript"></script>
	<!--<![endif]-->
	<script src="${ctx}/script/amazeui.min.js" type="text/javascript"></script>
	<script src="${ctx}/script/app.js" type="text/javascript"></script>
</body>
</html>