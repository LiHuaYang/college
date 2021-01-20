<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	
	<meta http-equiv="description" content="This is my pagekkk">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    
	<link rel="stylesheet" type="text/css" href="Web/Main/css/Main.css">
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
    <script type="text/javascript" src="Web/Main/js/Main.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <div class="wrap" style="min-width:1000px;">
    <jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
    
    <div class="all">
    	<div class="pic"></div>
    	<div class="next_all">
    		<div class="pictureTrophy"></div>
    		<div class="competition_frame">
    			<div class="top">
    				<div class="top_left">
		    			<div class="com_obj">
		    				
		    			</div>
		    			<div class="com_detail">
		    				<!-- <div class="com_detail_left">
		    					<p id="com_total">总评分</p></br>
		    					<div class="com_score">7.7</div>
		    				</div> -->
		    				<div class="com_detail_middle">
		    					<!--  <div class="com_year">2015年</div>-->
		    					
		    				</div>
		    				<div class="com_detail_right">
		    					
		    				</div>
		    			</div>
		    		</div>
		    		<div class="top_right">
		    			<div class="com_money">
		    				
		    			</div>
		    		</div>
	    		</div>
    			<div class="middle">
    				<div class="search_score">

					<div class="wrap">  					
    						<h2> 成绩查询 </h2>
    					
    					<%-- 
    					<div class="input_id"></div>     
    					<div class="input_pass"></div>
    					<div class="input_psd"></div>
    					<div class="button_search"></div>
    					<div class="choice_com"></div>
    					<input class="input_idnumber" placeholder="考生姓名"/>
    					<input class="input_password" placeholder="准考证号码"/>
    					<input type="password" class="input_password" id="input_secret_password" placeholder="密码"/>
    					<div class="font_search_score">成绩查询</div>
    					--%>
    					<ul>
    					  <li> <select id="choice_com_select" class=""></select> </li>
						  <li> <input  class="input_idnumber" placeholder="考生姓名"/> </li>
						  <li> <input  class="input_password" placeholder="准考证号码"/> </li>
						  <li> <input type="password" id="input_secret_password" placeholder="密码"/> </li>
						</ul>

    					
    					<button class="button_search_score" onclick="show_score()">查找</button>
    					
    					<div class="question">如有疑义，请联系400-000-1234</div>
    					</div>  
    				</div>
    				<fieldset  class="contesting">
    				
    					<div class="wrap">
    					<legend class="ing">
    						<div class="font_ing">
    						</div>
    						
    						<div class="ing_more" onclick="appear_more_on()">更多> </div>
    					</legend>
    					<div class="ing_com_big">
    						<div class="ing_com_small_box"></div>	
    						<!-- 
    						<div class="ing_page">
    							<div class="ing_page_num">1</div>
    							<div class="ing_page_num">2</div>
    							<div class="ing_page_num">3</div>
    							<div class="ing_page_num">></div>
    						</div>
    						 -->
    					</div>
    					</div>
    				</fieldset>
    			</div>
    			
    			<div class="Main_Down">
	    			<div class="soon_com_div">
		    			<div class="soon_com">	
		    				<div class="soon_com_num_div">
		    				
		    				</div>   				
		    			</div>
		    			<div class="soon_com_more" onclick="appear_more_ing()">更多></div>
		    		</div>
	    			<div class="soon_com_big">
	    			    <div class="soon_com_small_box"></div>
	    				<!-- 
	    				<div class="soon_page">
							<div class="soon_page_num">1</div>
							<div class="soon_page_num">2</div>
							<div class="soon_page_num">3</div>
							<div class="soon_page_num">></div>
	 					</div>
	 					 -->
	    			</div>
    			</div>
    			
    		</div>
    	</div>
    </div>
    <jsp:include page="../../Common/jsp/End.jsp" flush="true" />
    </div>
  </body>
</html>
