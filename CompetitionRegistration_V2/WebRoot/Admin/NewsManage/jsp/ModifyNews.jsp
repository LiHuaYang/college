<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int jspNewsId = Integer.parseInt(request.getParameter("NewsId"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ModifyNews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
	<link rel="stylesheet" href="Admin/CompetitionManage/css/competition.css" type="text/css"></link>
	
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="Admin/Common/common.js"></script>
	<script type="text/javascript" > jspNewsId=<%=jspNewsId%></script>
	 <script type="text/javascript" src="Admin/NewsManage/js/ModifyNews.js"></script>
  </head>
  
  <body>
    <div id="wrap">
			<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
			<div id="content">
				<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
				<div id="mainright">
					<div class="right-head">
						<h5>
							<i class="iconfont font">&#xf017d</i> 新闻管理--修改新闻
						</h5>
					</div>
					<table class="opera-form" id="">
						<tr>
							<td>
								新闻标题
							</td>
							<td>
								<textarea type="text" value="" id="news_title"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								新闻内容
							</td>
							<td>
								<textarea type="text" value="" id="news_content"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								新闻附加信息
							</td>
							<td>
								<textarea type="text" value="" id="news_add"></textarea>
							</td>
						</tr>
						
						<tr>
							<td>
								新闻类型
							</td>
							<td>
								<select id="news_type" >		
								 	 <option value ="1">小学</option>
								 	 <option value="2">初中</option>
								 	 <option value="3">高中</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								新闻出处
							</td>
							<td>
								<textarea type="text" value="" id="news_source"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								新闻图片
							</td>
							<td>
								<textarea type="text" value="" id="news_pic">暂不支持修改</textarea>
							</td>
						</tr>
						<tr>
							<td>
								新闻是否上头条
							</td>
							<td>
								<input type="checkbox" id="news_ishead">
							</td>
						</tr>
					</table>
					<button class="op-button" onclick="save()">
						<i class="iconfont font">&#xf0131</i>保存
					</button>
					<button class="op-button" onclick="ModifyANews()">
						<i class="iconfont font">&#xf0024</i>提交
					</button>
				</div>
				<div style="clear: both"></div>
			</div>
			<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
		</div>
  </body>
</html>
