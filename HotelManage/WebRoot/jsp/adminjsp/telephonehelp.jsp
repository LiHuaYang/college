<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'telephonehelp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
 	<link rel="stylesheet" href="css/admincss/seeroom.css" type="text/css"></link>
	<script type="text/javascript" src="js/common/jq.js"></script>

  </head>
  
  <body>
	<div class="messagemanage">
		<div class="condition-title">
			<button class="tag-button" onclick="judge(this)">电话预定</button>
			<button class="tag-button" onclick="judge(this)">续订房间</button>
			<button class="tag-button" onclick="judge(this)">退订房间</button>
			<button class="tag-button" onclick="judge(this)">退房</button>
			<button class="tag-button" onclick="judge(this)">入住</button>
			<button class="tag-button" onclick="judge(this)">开房</button>
			<button class="tag-button" onclick="judge(this)">打扫完成</button>
			<button class="tag-button" onclick="judge(this)">重置密码</button>
		</div>
		<div class="login" id="telephonehelp1">
		<ul> 
       <li class="op4-detail" id="login_input"> <span class="key_span">电 话 号 码：</span> <input type="text" class="key_input" id="RoomDetailAddress" /> </li> 
       <li class="op4-detail" id="login_input"> <span class="key_span">身份证号码：</span> <input type="text" class="key_input" id="RoomDetailAddress" /> </li>
       <li class="op4-detail" id="login_input"><span id="login_span"></span><div class="op-button">&nbsp确定信息</div></li> 
       </ul>
		</div>
		<!-- -------------------------------------------------------------------------------------------- -->
		<!-- -------------------------------------------------------------------------------------------- -->
	</div>
	<!-- ------------------------------------------------------------------------------------- -->
            <div style="clear:both"></div>
  </body>
</html>
