<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'NewsList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Web/News/css/NewsList.css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
    <script type="text/javascript" src="Web/News/js/NewsList.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
    <div class="all">
               <div class="news_left">
       		           <div class="news_text1_pic">
							<div class="news_text1">
								新闻动态
								<p>NEWS</p>
							</div>
					   </div>
					   <div class="search">
		    		      <div class="search_left">
		    			    <input type="text"  placeholder="搜索新闻" class="SearchBox" >
		    		      </div>
		    		      <div class="search_right" onclick="Search_News()"></div>
		   			   </div>
				</div>
	    
	    <div class="center_news">
	         <div class="main">
				<div class="news_list">
					<div class="news_list_top">
						<div class="news_text2">
							新闻动态
						</div>
					</div><%--
					<div class="TopNews">
		             	<div class="top_font">   			
	   	            	</div>
	                </div>
					--%><div class="news_each">
					</div>
					<div class="news_page">
					</div>
				</div>
			</div>
		</div>
	   
	</div>
	    <jsp:include page="../../Common/jsp/End.jsp" flush="true" />
  </body>
</html>
