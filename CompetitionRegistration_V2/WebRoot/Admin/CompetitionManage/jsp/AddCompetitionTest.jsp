<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
    int jspCompetitionId = Integer.parseInt(request.getParameter("CompetitionId"));		
//    String ContestSubject = request.getParameter("Contestsubject");
//    String ContestObject = request.getParameter("ContestObject");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>增加试卷</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
		<link rel="stylesheet" href="Admin/CompetitionManage/css/competition.css" type="text/css"></link>
		<link href="Common/Tool/uploadify/uploadify.css" rel="stylesheet" type="text/css" />	
		<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="Admin/Common/common.js"></script>
		<script src="Common/Tool/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="Admin/CompetitionManage/js/addCompetitionTest.js"></script>
		<script type="text/javascript" > 
			var jspCompetitionId = <%=jspCompetitionId%>;

		</script>
	</head>
	<body>
	<div id="wrap">
				<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
				<div id="content">
					<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
					<div id="mainright">
						<div class="right-head">
							<h5><i class="iconfont font">&#xf017d</i> 大赛信息--概要信息描述</h5>
						</div>
	 					<table class="opera-form" >
							<tr>
								<td style="width:200px;">试卷名称:</td>
								<td>
									<input id="TestPaperName" class="Verificationselect"  style="display:block; resize: vertical;"  value=""/>
		                		</td>
		                	</tr>
							<tr>
								<td style="width:200px;">试卷科目:</td>
								<td>
								<%--
									<select class="Verificationselect" id="TestSubject" >
									     <option value ="1">数学</option>
		                				 <option value ="3">语文</option>
								 		 <option value="5">英语</option>
								 		 <option value="6">艺术</option>
								 --%>
		                			</select>
		                			
		                			
		                			<input class="Verificationselect" id="TestSubject" />
								</td>
							</tr>
							
							<tr>
								<td style="width:200px;">试卷难度：</td>
								<td>
									<select class="Verificationselect" id="TestDifficulty" >
		                			    <option value ="1">简单</option>
								 	    <option value ="2">一般</option>
								 	    <option value="3">困难</option>
		                			</select>
								</td>
							</tr>
							<tr>
								<td style="width:200px;">试卷知识点：</td>
								<td>
									<textarea type="text" value="" id="TestKnowledgepoint" style="display:block; resize: vertical;"></textarea>
								</td>
							</tr>
							<tr>
								<td>试卷年份：</td>
								<td>
									<select class="Verificationselect" id="TestYear" >
									
		                			</select>
								</td>
							</tr>
							<tr>
								<td style="width:200px;">年级类型：</td>
								
								<td>
								<input class="Verificationselect" id="TestState" />
								<%--
								<td>
									<select class="Verificationselect" id="TestState" >
									<option value ="1">小学一年级</option>
									  <option value ="2">小学二年级</option>
									<option value="3">小学三年级</option>
									 <option value="4">小学四年级</option>
									  <option value="5">小学五年级</option>
									   <option value="6">小学六年级</option>
									    <option value="7">中学一年级</option>
									    <option value="8">中学二年级</option>
									     <option value="9">中学三年级</option>
									      <option value="10">高中一年级</option>
									       <option value="11">高中二年级</option>
									        <option value="12">高中三年级</option>
		                			</select>
		                			--%>
								</td>
							</tr>
							<tr>
								<td>
									</br>
									<button class="op-button" onclick="puttestpaper()">
										<i class="iconfont font">&#xf0024</i>提交试卷(先提交这个)
									</button>
									</br>
								</td>
								
							</tr>
							<tr>
								<td style="width:200px;">试卷第几题：</td>
								<td>
									<textarea type="text" value="" id="TestPaperNumber" style="display:block; resize: vertical;" placeholder="这是第一步，记得填写纯数字，如：第一题则为，1，以此类推"></textarea>
								</td>
							</tr>
							<tr>
								<td style="width:200px;">试卷图片(1080*高随意)</td>
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
								<td style="width:200px;">试卷图片路径：</td>
								<td>
									<textarea type="text" value="" id="TestPapeTitleUrl" style="display:block; resize: vertical;" placeholder="这是用来显示的，不需要填写"></textarea>
								</td>
							</tr>
							<tr>
								<td style="width:200px;">试卷答案图片(1080*高随意)</td>
								<td>
									<div>
							        	<%--用来作为文件队列区域--%>
							       		 <div id="fileQueue">
							       		 </div>
							       		 <input type="file" name="uploadify" id="uploadify2" />
							            <a href="javascript:$('#uploadify').uploadify('upload')">上传</a>| 
							            <a href="javascript:$('#uploadify').uploadify('cancel')">取消上传</a>
						    		</div>
								</td>
							</tr>
							<tr>
								<td style="width:200px;">试卷答案图片路径：</td>
								<td>
									<textarea type="text" value="" id="TestPaperAnswerUrl" style="display:block; resize: vertical;" placeholder="这也是用来显示的，不需要填写"></textarea>
								</td>
							</tr>
						</table>

						</br>
						<button class="op-button" onclick="putContestInfoToServer()">
							<i class="iconfont font">&#xf0024</i>提交试卷图片(再提交这个，这是第四步！)
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
