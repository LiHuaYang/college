<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int jspUserId = Integer.parseInt(request.getParameter("UserId"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'Modify.jsp' starting page</title>
	<link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="Admin/Common/common.js"></script>
	<script type="text/javascript" > jspUserId=<%=jspUserId%></script>
	 <script type="text/javascript" src="Admin/UserManage/js/modifyuser.js"></script>
  </head>
  
  <body>
  	<div id="wrap">
			<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
			<div id="content">
				<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
				<div id="mainright">
					<div class="right-head">
						<h5>
							<i class="iconfont font">&#xf017d</i> 用户信息修改--基本信息
						</h5>
					</div>
					<h3 style="text-align:center;">信息修改</h3>
					<table class="data-table">
						<tr>
							<td>
								用户姓名:
							</td>
							<td>
								<input id="UserName1" type="text">
							</td>
							<td>
								性别:
							</td>
							<td>
								<input id="UserSex1" type="text">
							</td>
							<td>
								身份证号码:
							</td>
							<td>
								<input id="UserIDNumber1" type="text" value="">
							</td>
							<td>
								联系方式
							</td>
							<td>
								<input id="UserPhone1" type="text">
							</td>
						</tr>
						<tr>
							<td>
								就读学校:
							</td>
							<td>
								<input id="UserSchool1" type="text" value="">
							</td>
							<td>
								就读年份:
							</td>
							<td>
								<input id="UserYear1" type="text" value="">
							</td>
							<td>
								就读年级:
							</td>
							<td>
								<input id="UserGrade1" type="text" value="">
							</td>
							<td>
								联系人:
							</td>
							<td>
								<input id="UserContactsMan1" type="text" value="">
							</td>
						</tr>
						<tr>
							
							<td>
								联系电话:
							</td>
							<td>
								<input id="UserContactsPhon1" type="text" value="">
							</td>
							<td>
								地址:
							</td>
							<td>
								<input id="UserAddress1" type="text" value="">
							</td>
							<td>
								指导老师:
							</td>
							<td>
								<input id="UserTeacher1" type="text" value="">
							</td>
							<td>
								指导老师电话:
							</td>
							<td>
								<input id="UserTeacherPhon1" type="text" value="">
							</td>
						</tr>
						<tr>
							<td>
								用户头像:
							</td>
							<td>
								<input id="UserPic1" type="text" value="">
								<button class="op-button" onclick="glanceover()">
									<i class="iconfont font">&#xf012c</i>浏览
								</button>
							</td>
						</tr>
						
					</table>
					
					<button class="op-button" onclick="save()">
						<i class="iconfont font">&#xf0131</i>保存
					</button>
					<button class="op-button" onclick="ModifyAUser()">
						<i class="iconfont font">&#xf0024</i>提交
					</button>
				</div>
				<div style="clear: both"></div>
			</div>
			<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
		</div>
  </body>
</html>
