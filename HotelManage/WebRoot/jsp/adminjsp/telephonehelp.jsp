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
			<button class="tag-button" onclick="judge(this)">�绰Ԥ��</button>
			<button class="tag-button" onclick="judge(this)">��������</button>
			<button class="tag-button" onclick="judge(this)">�˶�����</button>
			<button class="tag-button" onclick="judge(this)">�˷�</button>
			<button class="tag-button" onclick="judge(this)">��ס</button>
			<button class="tag-button" onclick="judge(this)">����</button>
			<button class="tag-button" onclick="judge(this)">��ɨ���</button>
			<button class="tag-button" onclick="judge(this)">��������</button>
		</div>
		<div class="login" id="telephonehelp1">
		<ul> 
       <li class="op4-detail" id="login_input"> <span class="key_span">�� �� �� �룺</span> <input type="text" class="key_input" id="RoomDetailAddress" /> </li> 
       <li class="op4-detail" id="login_input"> <span class="key_span">���֤���룺</span> <input type="text" class="key_input" id="RoomDetailAddress" /> </li>
       <li class="op4-detail" id="login_input"><span id="login_span"></span><div class="op-button">&nbspȷ����Ϣ</div></li> 
       </ul>
		</div>
		<!-- -------------------------------------------------------------------------------------------- -->
		<!-- -------------------------------------------------------------------------------------------- -->
	</div>
	<!-- ------------------------------------------------------------------------------------- -->
            <div style="clear:both"></div>
  </body>
</html>
