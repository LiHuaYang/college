<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>使用报名帮助</title>
    <meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="WeChat/css/help.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="head">
        <div class="logo">
		<span><i class="iconfont font" id="size"  onclick="history.go(-1)">&#xf016e</i></span>
          <span class="dasai">使用报名帮助</span>
        </div>
	</div>

      <div class="user">
   		    <div id="on" >
   		          报名步骤：   
			</div>
			<div id="on">
			  1、先登录。（如没注册过的请先注册）	
		   </div>
		   <div id="on">
			  1、先登录。（如没注册过的请先注册）	
		   </div>
		   <div id="on">
			  2、在竞赛界面选择自己要参加的比赛，点击报名。
		   </div>
		   <div id="on">
			  3、填写自己的报名信息（包括个人信息，大赛信息，联系信息，其中个人信息，联系信息必填）
		   </div>
		   <div id="on">
			    4、点击报名。	
		   </div>
		   <div id="on">
			 5、请在20分钟内完成维信支付。
		   </div>
		   <div id="on">
			   6、报名成功。	
		   </div>
	  </div>

</html>
