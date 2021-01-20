<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'competitionDetael.jsp' starting page</title>
    
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
    <script type="text/javascript" src="Web/Competition/js/competitionDetail.js"></script>
	<link rel="stylesheet" type="text/css" href="Web/Competition/css/competitionDetail.css">
	<link rel="stylesheet" type="text/css" href="Common/Tool/starcommit/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="Common/Tool/starcommit/css/default.css">
    <link rel="stylesheet" type="text/css" href="Common/Tool/starcommit/css/demo.css" />
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css'>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
	<!-- -->
	<script type="text/javascript">
	</script>
  </head>
  
  <body>
  	<jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
  	<div class="all">
  		<div class="pic">
  		</div>
  		<div class = "main">
  		<div class="middle">
  		<div class = "middle_1">
  		
  		
  		<div class = "main_pic"></div>
  		
  		
  		
  		<div class = "main_info">
  			<div class="com_detail">
  				<div class="com_detail_first">
		    		<div class="com_detail_right"></div>
  					<div class="com_detail_left"></div>
  				</div>
  			</div>
  			<div class="com_bref_box">
	  			
  			</div>
  			</div></div>

					<div class = "want_commit">
					<div class = "want_commit_1">
					<div class = "want_font"></div>
					<input type = "text" id = "want_score" value = "0" style="display: none;"> 
					<div class = "want_font" id = "want_font_style" style="display: none;">分</div>
					<article class="htmleaf-container">
					
						<div id="demo6" class="demo">
							我要评分:&nbsp<span class="ratyli"></span>
						</div>
							</article>
							<div class="commit_content"><textarea class="content" type="text" placeholder="留下你想说的"></textarea></div>
									<button class="submit" onclick="createcommit()" style="margin-top:10px;">确定</button>
							</div>
					</div>
					
					
		<div class="com">
  		
  			
  			
  			<!-- <div class="text_downloadBox">
	  			<div class="text_download">历史试题下载</div>
	  			<div class="download_big">
	  				<% for(int i=0;i<5;i++){%>
	  					<div class="download_each">2014年数学竞赛模拟考试题下载</div>
	  				<%} %>
	  			</div>
  			</div>
  			-->
  			
  			<!-- 我要评论
  			<div class="want_commit_big" style="display: none;">
  				<div class="want_first">
  					<div class="want_star">
  						<div id="demo6" class="demo">
	        				<span class="ratyli"></span>
	   					 </div>
  					</div>
  					<div class="want_close" onclick="close_want_commit()">
  						<i class="iconfont font" id="icon_close">&#xf00b3</i>
  					</div>
  				</div>
  				<textarea class="text_want"></textarea>
  				<div class="want_save">
  					<button class="commit_want_butt" onclick="commit_want()">提交</button>
  				</div>
  			</div>
  			 -->
  			
  			<div class="comment_big">
  				<div class="comment_big_box">
  				
	  				<div class="comm_font_div"></div>
	  				
	  				<div class="comment_each"></div>
		  			
  				</div>
  				
  				<div class="comm_page"></div>
  				
  			</div>
  			
  			<div class="s"></div>
  		</div>
  			
  		</div>
  		<div class="enroll">
  				<div class="com_hot">热赛排行热度：暂无开放</div>
  				<div class="week_box">
  					
  				</div>
  				<div class="enroll_com_all"></div>
  				<div class="com_enroll">
  					
  				</div>
  			</div>
  			</div>
  		
  	</div>
  	<jsp:include page="../../Common/jsp/End.jsp" flush="true" />
  	
  		<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="Common/Tool/starcommit/js/jquery-2.1.1.min.js"><\/script>')</script>
	<script src="Common/Tool/starcommit/js/jquery.ratyli.js"></script>
    <script src="Common/Tool/starcommit/js/demo.js"></script>
  </body>
</html>
