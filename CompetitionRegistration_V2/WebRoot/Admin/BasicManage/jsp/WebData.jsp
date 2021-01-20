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
		<title>My JSP 'competitionData.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
		<link rel="stylesheet" href="Admin/CompetitionManage/css/competition.css" type="text/css"></link>
		<link rel="stylesheet" href="Admin/BasicManage/css/CompetitionData.css" type="text/css"></link>
		<link href="Common/Tool/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="Admin/Common/common.js"></script>
		<script src="Common/Tool/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="Admin/BasicManage/js/WebDate.js"></script>
	</head>

	<body>
	<div id="wrap">
	  	<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
	  	<div id="content">
	  		<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
        	<div id="mainright">
        		<table class="data-table">
        			<tr>
       				<td style="width:200px;background-color:#F5F9FB">网站图片:</td>
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
        		</table>
        		<button class="op-button" onclick="">
					<i class="iconfont font">&#xf0131</i>保存
				</button>
				<button class="op-button" onclick="submitpic()">
					<i class="iconfont font">&#xf0024</i>提交
				</button>
		    </div>
		</div>
	</div>
	</body>
</html>
