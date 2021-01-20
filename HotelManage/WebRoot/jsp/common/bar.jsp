<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int baruserid=0;
try{
    baruserid=(Integer)request.getSession().getAttribute("UserId123");
}catch(Exception e){
    e.printStackTrace();
}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <link rel="stylesheet" type="text/css" href="css/common/bar.css">
	  <link rel="stylesheet" type="text/css" href="css/usercss/searchlow.css">
	  
	  	<script type="text/javascript">
		var baruserid=<%=baruserid%>;
		
		</script>
	  
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common/bar.js"></script>		
	<script type="text/javascript" src="js/userjs/searchlow.js"></script>
	
	

	
  </head>
  
  <body>
 

  <div class="homehead">
	
		
   <div class="comp" onclick="showmianpage()">
				<i class="iconfont" id="find">&#xf01ca</i>住宿
			</div>
			<input id="suggestId" class="homehead-input" placeholder="想去哪里就去哪里。"/>
			<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
			<i class="iconfont" search="0" id="me" onclick="tosearch()">&#xf012c</i>
			<div class="homehead_input_right"> 
				<div class="homehead-input-right1"><div>成为房东</div></div>
				<div class="homehead-input-right2" onclick="showvip()">VIP</div>
				<div class="homehead-input-right3"onclick="showregister()">注册</div>
				<div class="homehead-input-right4"onclick="showlogin()">登录</div>
			</div>
			
			<div  class="homehead_person_show"  onmouseover="showquitbutton()" onmouseout="hidequitbutton()" style="display: none;">
			    <div class="homehead_person_head" onclick="topersoninfo()"></div>
			    <div class="homehead_person_quit" style="display: none;">
			    	<i class="iconfont" id="quick_signal" onclick="exitlongin()">&#xf0204</i>
			    </div>
			</div>
			
</div>
  </body>
</html>
