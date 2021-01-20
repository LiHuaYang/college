<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
	<link rel="stylesheet" href="Admin/CompetitionManage/css/competition.css" type="text/css"></link>
	
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link href="Common/Tool/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
	<script src="Common/Tool/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="Admin/Common/common.js"></script>
	<script type="text/javascript" src="Admin/NewsManage/js/addnews.js"></script>
	<script type="text/javascript" src="Common/Tool/ckeditor/ckeditor.js"></script>
  </head>
  
  <body>
    <div id="wrap">
			<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
			<div id="content">
				<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
				<div id="mainright">
					<div class="right-head">
						<h5>
							<i class="iconfont font">&#xf017d</i> 新闻管理--增加新闻
						</h5>
					</div>
					<table class="opera-form" id="">
						<tr>
							<td style="width:100px;">
								新闻标题
							</td>
							<td>
								<textarea type="text" value="" id="news_title" style="display:block; resize: vertical;"></textarea>
							</td>
						</tr>
						<tr>
							<td style="width:100px;">
								新闻内容
							</td>
							<td>
								<textarea type="text" name="editor1" value="" id="news_content" style="display:block; resize: vertical;"></textarea>
								<script>CKEDITOR.replace('editor1');</script>
							</td>
						</tr>
						<tr>
							<td style="width:100px;">
								新闻附加信息
							</td>
							<td>
								<textarea type="text" value="" id="news_add" style="display:block; resize: vertical;"></textarea>
							</td>
						</tr>
						
						<tr>
							<td style="width:100px;">
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
							<td style="width:100px;">
								新闻出处
							</td>
							<td>
								<textarea type="text" value="" id="news_source" style="display:block; resize: vertical;"></textarea>
							</td>
						</tr>
						<tr>
							<td style="width:100px;">
								新闻图片
							</td>
							<td>
  									<div>
				        <%--用来作为文件队列区域--%>
				        <div id="fileQueue">
				        </div>
				       		 <input type="file" name="uploadify" id="uploadify" />
				            <a href="javascript:$('#uploadify').uploadify('upload')">上传</a>| 
				            <a href="javascript:$('#uploadify').uploadify('cancel')">取消上传</a>
			    		</div>
							</td>
						</tr>
						<tr>
							<td style="width:100px;">
								新闻是否上头条
							</td>
							<td>
								<input type="checkbox" id="news_ishead">
							</td>
						</tr>
					</table>
					<br>
					<br>
					<button class="op-button" onclick="sumbitnews()">
						<i class="iconfont font">&#xf0024</i>提交
					</button>
					<div style="clear: both"></div>
				</div>
				<div style="clear: both"></div>
			</div>
			<div style="clear: both"></div>
			<br>
			<br>
			<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
		</div>
  </body>
</html>
