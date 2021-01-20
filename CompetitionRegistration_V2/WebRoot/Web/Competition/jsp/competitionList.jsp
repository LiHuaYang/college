<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

int flag=Integer.parseInt(request.getParameter("flag"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'competitionList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
    <script type="text/javascript" src="Web/Competition/js/competitionList.js"></script>
	<link rel="stylesheet" type="text/css" href="Web/Competition/css/competitionList.css">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		var flag=<%=flag%>;
	</script>

  </head>
  
  <body>
  	<jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
  	<div class="all">
    	<div class="pic"></div>
    	<div class="next">
    		<div class="com_title">
    			<div class="com_left_box">
    				
    			</div>
				<div class="com_middle"></div>
				<div class="com_right_box">
					
				</div>
    		</div>
    		<div class="school_title">
    			<div class="school_pri" onclick="appear_pri()">小学</div>
    			<div class="school_move"></div>
    			<div class="school_midd" onclick="appear_midd()">初中</div>
    			<div class="school_high" onclick="appear_high()">高中</div>
    		</div>
    		<div class="ing_com_big">
    			<div class="div_each_ing">
   					
   				</div>
    		</div>
    		<div class="ing_page">
				<div class="ing_page_num">1</div>
				<div class="ing_page_num">2</div>
				<div class="ing_page_num">3</div>
				<div class="ing_page_num"></div>
			</div>
			
			<!--  即将报名赛事-->
			<div class="soon_com_big" style="display:none;">
				<div class="div_each_soon">
   					
   				</div>
    		</div>
    		<div class="soon_page" style="display:none;">
				<div class="soon_page_num">1</div>
				<div class="soon_page_num">2</div>
				<div class="soon_page_num">3</div>
				<div class="soon_page_num">4</div>
				<div class="soon_page_num">></div>
			</div>
			<!-- *************************************************************************** -->
    	</div>
    </div>
    <jsp:include page="../../Common/jsp/End.jsp" flush="true" />
  </body>
</html>
