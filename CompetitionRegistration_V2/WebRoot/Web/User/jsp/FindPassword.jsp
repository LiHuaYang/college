<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FindPassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="Web/User/css/FindPassword.css"></link>
       <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="Web/User/js/FindPassword.js"></script>
  </head>
  
  <body>
   <jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
   <div style="text-align:center;">
  	<div class="title">
  		<span class="center publishfont" style="font-size:25px">修改密码</span>
  	</div>
     <div id="firstcontent">
  	  	<div class="indicate">
  		<div class="indicate-frame1">1:填写绑定手机号码</div>
  		<div class="indicate-frame">2:验证码验证</div>
  		<div class="indicate-frame">3:重置密码</div>
  	    </div>
  		<div class="content">
      <div class="next">
	      <div class="tel">
	                            请输入绑定手机号码：
	      </div>
	      <div class="tel-input">
	           <input style="margin-top:20px;height:30px;width:150px;" id="user_phone"/>           
	      </div>
	   </div>
	   <div class="next">
	    </div>
	      <div class="next">
	          <button id="first" class="commit" style="width:100px;" onclick="getyanz(this)">获取验证码</button>
	      </div>
  		</div>
  	</div>
  	    <div id="secondcontent" style="display:none">
  	  	<div class="indicate">
  		<div class="indicate-frame">1:填写绑定手机号码</div>
  		<div class="indicate-frame1">2:验证码验证</div>
  		<div class="indicate-frame">3:重置密码</div>
  	    </div>
  		<div class="content">
	      <div class="next">
		      <div class="tel2">
		                      手机号：
		      </div>
		   
		       <div class="tel-input">
		           <input style="margin-top:20px;height:30px;width:200px;" id="UserPhone_input"/>           
		      </div>
		   </div>
		   <div class="next">
		      <div class="yanz">
		                      验证码：
		      </div>
		      <div class="tel-input3">
		           <input style="margin-top:20px;height:30px;width:200px;" id="SMSNumber_input"/>           
		      </div>
		   </div>
		      <div class="next">
		           <button id="second" class="commit" style="width:100px;" onclick="publish2(this)">上一步</button>
		           <button id="second" class="commit" style="width:100px;" onclick="send_check_number(this)">下一步</button>
		      </div>
		</div>
  	</div>
  	    <div id="thirdcontent" style="display:none">
  	  	<div class="indicate">
  		<div class="indicate-frame">1:填写绑定手机号码</div>
  		<div class="indicate-frame">2:验证码验证</div>
  		<div class="indicate-frame1">3:重置密码</div>
  	    </div>
  		<div class="content">
	      <div class="next">
		      <div class="yanz">
		                      新的密码：
		      </div>
		      <div class="tel-input3">
		           <input style="margin-top:20px;height:30px;width:245px;" id="Userpass" placeholder="6~20位字符、字母、符号组成"/>           
		      </div>
		  </div>
		   <div class="next">
		   <div class="yanz">
		                      确认密码：
		      </div>
		      <div class="tel-input3">
		           <input style="margin-top:20px;height:30px;width:245px;" id="sure-Userpass"/>           
		      </div>
		   </div>
	      <div class="next">
	         <button id="third" class="commit" style="width:100px;" onclick="publish2(this)">上一步</button>
	      
	          <button class="commit" style="width:100px;" 	onclick="ChangeUserPassword()">提交</button>
	      </div>
  		</div>
  	</div>
     <jsp:include page="../../Common/jsp/End.jsp" flush="true" />
  </body>
</html>
