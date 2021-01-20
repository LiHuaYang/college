<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int  UserId = -1;
	try{
		UserId = Integer.parseInt(request.getParameter("UserId"));
	}catch(Exception e){
		UserId = -1;
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改资料</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="WeChat/css/revisedata.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/js/revisedata.js"></script>

  </head>
  
<body>
	<script type="text/javascript">
			var UserId = <%=UserId%>
		</script>
	<div class="head">
        <div class="logo">
		<span><i class="iconfont font" style="float:left;font-size:1.3em;color:white;" onclick="history.go(-1)">&#xf016e</i></span>
          <span class="dasai">个人资料</span>
        </div>
	</div>
	  <!--<div class="user">
	  	<div id="user_pic">
	  		<div class="in-info">
					头像
			</div>
			
			   <img alt="" src="" class="pic">
	  	</div>
	  </div>
      --><div class="next">
			<div id="in" class="nickname" onclick="entering(this)">
				<div class="in-info">
					昵称
				</div>
	         	
	         	<span style="float:right;color:grey;" id="nickname"></span>
			</div>
			<div id="in" class="Name" onclick="entering(this)">
				<div class="in-info">
					姓名
				</div>
	         	
	         	<span style="float:right;color:grey;" id="Name"></span>
			</div>
			<div id="in" class="sex" onclick="entering(this)">
				<div class="in-info">
					性别
				</div>
				
				<span style="float:right;color:grey;" id="sex"></span>
			</div>
			<div id="in" class="phone" onclick="entering(this)">
				<div class="in-info">
					联系号码
				</div>
				
				<span style="float:right;color:grey;" id="phone"></span>
			</div>
			<div id="in" class="contact_people" onclick="entering(this)">
				<div class="in-info">
					联系人
				</div>
	         	
	         	<span style="float:right;color:grey;" id="contact_people"></span>
			</div>
			<div id="in" class="revise" onclick="entering(this)">
				<div class="in-info">
					修改密码
				</div>
				
			</div>
			<div id="in" class="study" onclick="entering(this)">
				<div class="in-info">
					学习阶段
				</div>
				
				<span style="float:right;color:grey;" id="study"></span>
			</div>
			<div id="in" class="school" onclick="entering(this)">
				<div class="in-info">
					就读学校
				</div>
				
				<span style="float:right;color:grey;" id="school"></span>
			</div>
			<div id="in" class="IDnumber" onclick="entering(this)">
				<div class="in-info">
					身份证号
				</div>
				
				<span style="float:right;color:grey;" id="IdNumber"></span>
			</div>
			<div id="in" class="user_address" onclick="entering(this)">
				<div class="in-info">
					管理用户地址
				</div>
				
				<span style="float:right;color:grey;" id="user_address"></span>
			</div>
		</div>
      <!-- ------------------------------弹窗样式二------------------------------  -->
	    <div id="organizePanel" class="bodymiddle" style="display:none;" >
		    <div class="middleFrame">
		        <div class="middleClose" onclick="middleClose()"><i class="iconfont">&#xf00b3;</i></div>
		        <div class="Frameinformation">
			      </div>
		        </div>
		    </div>
		    <!-- ------------------------------弹窗样式------------------------------  -->
  </body>
</html>
