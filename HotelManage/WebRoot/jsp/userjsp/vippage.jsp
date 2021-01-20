<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'vippage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/iconfont/common/iconfont.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/usercss/vippage.css">
	<script type="text/javascript" src="js/common/jq.js"></script>
	<script type="text/javascript" src="js/userjs/vippage.js"></script>
	<script type="text/javascript" src="js/common/date.js"></script>
  </head>
  
  <body>
    	<div class="heads"></div>
    	
    	<div class="vippic">
    		
    		<div class="vipinpic">
    			<div class="vipinpicone"></div>
    			<div class="vipinpicone"></div>
    			<div class="vipinpicone"></div>
    			<div class="vipinpicone"></div>
    			<div class="vipinpicone"></div>
    		</div>
    		<div class="showbu">
	    		<i class="iconfont" id="fontleft" onclick="vippicleft()">&#xf016e;</i>
	    		<i class="iconfont" id="fontright" onclick="vippicright()">&#xf016d;</i>
    		</div>
    	</div>
    	
    	<div class="uservip">
    		<div class="row">
    			<div style="border-bottom: 1px solid rgb(200,200,200);height: 20px;">用户VIP信息</div>
    			<div class="uservip-left">
    				<div class="vipuserpic"></div>
    				<div class="vipusername">小白</div>
    			</div>
    			<div class="uservip-right">
    				<div class="uservip-right-grade">VIP等级：<font>LV1  </font>   <i class="iconfont">&#xf017d;</i></div>
    				<div class="uservip-right-date">VIP已伴随您度过      <font>78</font>         天</div>
    				<img  src="img/seekBar.png">
    				<div class="uservip-right-pay">再充值   <font>78</font>   元可升级成<font>  LV2</font>  <i class="iconfont">&#xf017d;</i>        <font class="vippay" >充值</font></div>
    			</div>
    		 </div>
    		
    	</div>
    	<div class="vipcon">
    		<div class="vipconrow">
    		<div class="vipconrowtitle">关于VIP  <i class="iconfont" id="vv">&#xf017d;</i></div>
    		<div class="vipconmore">
    			
    		</div>
    		</div>
    	</div>
    	<div class="vipactivity">
    		<div class="vipactivityrow">
    			<div class="vipactivitytitle"><i class="iconfont" id="vv">&#xf017d;</i> <font>VIP</font>    活动</div>
    			<div class="vipactivitylist">
    				
    			</div>
    			<div class="vipactivitybu">
    			<div class="text_number_box" align="center">
   	                    <%for(int x=0;x<5;x++) {%>
   	                        <div id="text_bottom_number" class="text_bottom_number<%=x %>" onclick="text_numberx_box(<%=x %>)"><%=x+1 %></div>
   	                    <%} %>
   	                         <div class="text_bottom_next">▶</div>
   	                </div>
    			</div>
    			
    		</div>
    	</div>
    	<div class="blackbar" style="display: none;"></div>
  </body>
  	 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xTGYDhxlbHjfvpB4CsrtxvsA"></script>
  
</html>
