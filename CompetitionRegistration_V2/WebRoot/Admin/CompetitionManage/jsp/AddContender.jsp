<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'AddContender.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="Common/iconfont/iconfont.css"
			type="text/css"></link>
		<link rel="stylesheet"
			href="Admin/CompetitionManage/css/competition.css" type="text/css"></link>
		<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
		<script type="text/javascript"
			src="Admin/CompetitionManage/js/addContender.js"></script>
	</head>

	<body>
		<div id="wrap">
			<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
			<div id="content">
				<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
				<div id="mainright">
					<div class="right-head">
						<h5>
							<i class="iconfont font">&#xf017d</i> 参赛人信息--概要信息描述
						</h5>
					</div>
					<table class="opera-form" id="">
						<tr>
							<td>
								报名人姓名:
							</td>
							<td>
								<textarea type="text" value="" id="StudentName"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								性别:
							</td>
							<td>
								<select id="StudentSex">
									<option>
										男
									</option>
									<option>
										女
									</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								报名人身份证号:
							</td>
							<td>
								<textarea type="text" value="" id="StudentIDNumber"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								就读学校:
							</td>
							<td>
								<textarea type="text" value="" id="StudentSchool"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								就读年级:
							</td>
							<td>
								<textarea type="text" value="" id="StudentGrade"></textarea>
							</td>
						</tr>
						<tr><td>竞赛名称:</td><td><select  id="CompetitionName"></select></td></tr>
						<tr>
							<td>
								联系人:
							</td>
							<td>
								<textarea id="StudentContactsMan" style="display: block"
									type="text"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								联系电话:
							</td>
							<td>
								<textarea id="StudentContactsPhon" style="display: block"
									type="text"></textarea>
							</td>
						</tr>
						<tr>
							<td>竞赛年级:</td><td><select  id="ContestObject"></select></td>
						</tr>
						<tr>
							<td>
								地址:
							</td>
							<td>
								<textarea id="UserAddress" style="display: block" type="text"></textarea>
							</td>
						</tr>
						<tr>
							<td>科目:</td><td><select  id="ContestSubject"></select></td>
						</tr>
						<tr>
							<td>
								指导老师:
							</td>
							<td>
								<textarea id="StudentTeacher" style="display: block" type="text" placeholder="选填"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								指导老师电话:
							</td>
							<td>
								<textarea id="StudentTeacherPhon" style="display: block" type="text" placeholder="选填"></textarea>
							</td>
						</tr>
						<tr>
							<td>承办方名称:</td><td><select  id="OrganizationName"></select></td>
						</tr>
						<tr>
							<td>学生照片:</td><td><textarea id="StudentPicture" style="display:block" type="text"></textarea></td>
						</tr>
						<tr>
							<td>
								竞赛届数:
							</td>
							<td>
								<textarea id="CompetitionSession" style="display: block" type="text" placeholder="只能填数字"></textarea>
							</td>
						</tr>
						<tr>
							<td>报名状态:</td><td>
								<select id="enrollmentState">
									<option>未付款</option>
									<option>即将开始</option>
									<option>已付款</option>
									<option>取消参加</option>
								</select>
							</td>
						</tr>
					</table>
					</br>
					<button class="op-button" >
						<i class="iconfont font">&#xf0131</i>保存
					</button>
					<button class="op-button" onclick="addcontender()";
>
						<i class="iconfont font">&#xf0024</i>提交
					</button>
					<div style="clear: both"></div>
				</div>
				<div style="clear: both"></div>
			</div>
			<div style="clear: both"></div>
			<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
		</div>
	</body>
</html>
