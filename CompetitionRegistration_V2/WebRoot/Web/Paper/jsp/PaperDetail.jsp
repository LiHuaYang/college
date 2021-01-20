<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

int paperid=Integer.parseInt(request.getParameter("paperid"));
String papername=request.getParameter("papername");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'PaperDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Web/Paper/css/PaperDetail.css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
    <script type="text/javascript" src="Web/Paper/js/PaperDetail.js"></script>
    <link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		var paperid=<%=paperid%>;
		var papername=<%=papername%>;
	</script>

  </head>
  
  <body>
    <jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
    <div class="all">
    	<div class="first">
    		<div class="first_save" id="save_box">收藏
    			<!--  <i class="iconfont font" id="icon_save">&#xf02a8</i>-->
    			<div id="img_save" onclick="Collect_Paper()"></div>
    		</div>
    		<div class="first_ques">题目</div>
    		<div class="first_ans">答案</div>
    	</div>
  
    	<div class="all_left">
    		<div class="ques_box">
    		
    		</div>
    		
    	</div>
    	<div class="all_right">
    		<div class="ans_box">
	    		
	    	</div>
    	</div>
      </div>

    <div class="back-pic" id="back-pic"  style="display: none;">
          <div class="close" id="close"  onclick="close_score()">
               <i class="iconfont">&#xf00b3;</i>
          </div>
          <div class="bigpic" id="big-pic">
          </div>
           
    </div>
       <div class="back-pic-ans" id="back-pic-ans"  style="display: none;">
          <div class="close" id="close-ans"  onclick="close_score()">
               <i class="iconfont">&#xf00b3;</i>
          </div>
          <div class="bigpic" id="big-pic-ans">
          </div>
           
    </div>
    <div class="download">
          <div class="download-text">
                                   点此下载
          </div>
           <div class="download-pic" onclick="">
               <i class="iconfont">&#xf0111;</i>
          </div>
    </div>
  </body>
</html>
