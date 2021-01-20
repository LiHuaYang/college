<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'PaperList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Web/Paper/css/PaperList.css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
    <script type="text/javascript" src="Web/Paper/js/PaperList.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
    <div class="all">
        <div class="TestLeft">
		    <div class="news_text1_pic">
			      <div class="news_text1">
					试卷动态
					<p>TESTS</p>
				  </div>
			</div>
			<div class="TestLeftLine"></div>
			<div class="TestSearch">
			    <select class="Test_Search_Name">
			       <option>大赛选择</option>
			    </select>
			     <select class="Test_Search_Year">
			       <option>年份选择</option>
			    </select> 
			    <!-- <select class="Test_Search_Subject">
			       <option>科目选择</option>
			    </select> -->
			    <select class="Test_Search_Object">
			       <option>年级选择</option>
			    </select>
			    <input type="button" class="Test_Search_Button" onclick="SearchTestParper()" value="搜索">
			</div>
		</div>
		
        <div class="PaperList">
	    	<div class="navi">
	    		<div class="navi_name">试卷名称</div>
	    		<div class="navi_time">发布时间</div>
	    		<div class="navi_diff">试卷难度</div>
	    	</div>
	    	
		    <div class="text_paper_box">
			    <div class="gif">
			    	<div class="SearchTestgif"></div>
			    </div>
		        
			</div>
			
			<div class="paper_page">
				
			</div>
		</div>
    </div>
   <jsp:include page="../../Common/jsp/End.jsp" flush="true" />
  </body>
</html>
