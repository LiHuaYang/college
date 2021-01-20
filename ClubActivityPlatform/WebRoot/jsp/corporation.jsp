<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int mycorporationId=Integer.parseInt(request.getParameter("mycorporationId"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'corporation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/corporation.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
    <script type="text/javascript" src="js/corporation.js"></script>
    <script type="text/javascript">
    	var mycorporationId=<%=mycorporationId%>;
    </script>
  </head>
  
  <body  id="k">
  <div class="cpic">
  	<div class="heads"></div>
  	<div class="cpic-title">吉他社</div>
  </div>
  <div class="corporation-content">
  		<div class="corporation-content-row">
  			<div class="corporation-content-title">简介</div>
  			<div class="corporation-content-more">asd</div>
  		</div>
  </div>
  <div class="corporation-member">
  		<div class="corporation-member-row">
  			<div class="corporation-member-left" onclick="ileft()"><i class="iconfont" id="memberleft" >&#xf016e;</i></div>
  			<div class="corporation-member-list">
  				<div class="corporation-member-all">
  					
  				</div>
  			</div>
  			<div class="corporation-member-right"onclick="iright()"><i class="iconfont" id="memberright">&#xf016d;</i></div>
  		</div>
  </div>
  <div class="corporation-end">
  	<div class="corporation-end-row">
  		<div class="corporation-end-row-left">
  			<div class="corporation-notice-title">公告</div>
  			<div class="corporation-notice-list"></div>
  			<div class="corporation-notice-button">
  				<div class="prev" style="float: left;"onclick="prevpage()">prev</div>
    			<div class="pagecount" style="display: inline-block;width: 90px;text-align: center;padding-top: 10px;"></div>
    			<div class="next" style="float: right;"onclick="nextpage()">next</div>
  			</div>
  		</div>
  		<div class="corporation-end-row-right">
  			<div class="part-in">
  				<div style="padding-top: 5px;text-align: center;margin: auto;width:200px;border-bottom: 1px solid rgb(200,200,200);">加入我们</div>
  				<div style="width:100%;text-align: center;font-size: 12px;">收获更多的朋友，更多的乐趣。</div>
  				<textarea class="part-text"placeholder="说点什么呗！"></textarea>
  				<div style="margin-top: 30px;">
  				<div class="button1" onclick="partin()">提交</div>
  				<div class="button2" onclick="reset()">取消</div>
  				</div>
  			</div>
  		</div>
  	</div>
  </div>
  <div class="mainend">
			<div class="mainend-row">
				<div class="say1">
					鸟儿因翅膀而自由翱翔，
				</div>
				<div class="say2">
					鲜花因芬芳而美丽，
				</div>
				<div class="say3">
					校园因文明而将更加进步。
				</div>
				<div class="bordershow"></div>
				<div class="dm501">
					<i class="iconfont" id="write">&#xf00f5;</i>dm501
				</div>
			</div>
		</div>
  </body>
</html>
