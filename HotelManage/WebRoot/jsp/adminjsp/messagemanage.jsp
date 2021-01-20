<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'messagemanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 	<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
 	<link rel="stylesheet" href="css/admincss/seeroom.css" type="text/css"></link>
	<script type="text/javascript" src="js/common/jq.js"></script>
	<script type="text/javascript" src="js/adminjs/mainorder.js"></script>
	
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  
  
  
  
  
	<div class="messagemanage">

		<div class="condition-title">
			<button class="tag-button" onclick="judge(this)">用户反馈</button>
			<button class="tag-button" onclick="judge(this)">清洁员反馈</button>
		</div>
		<table class="property" id="message1" style="display:block">
			<tbody>
				<tr>
					<td>数据1</td>
					<td>数据2</td>
					<td>数据3</td>
					<td>数据4</td>
					<td>数据5</td>
					<td>数据6</td>
				</tr>
			</tbody>
		</table>
		<table class="property" id="message2" style="display:none">
			<tbody>
				<tr>
					<td>清洁员1</td>
					<td>清洁员2</td>
					<td>清洁员3</td>
					<td>清洁员4</td>
					<td>清洁员5</td>
					<td>清洁员6</td>
					<td>清洁员7</td>
				</tr>
			</tbody>
		</table>
		<!-- -------------------------------------------------------------------------------------------- -->
		<!-- -------------------------------------------------------------------------------------------- -->
	</div>
	<!-- ------------------------------------------------------------------------------------- -->
            <div style="clear:both"></div>
        </div>
  </body>
</html>
