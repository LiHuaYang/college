<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'noticelist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/datedropper.css" rel="stylesheet" type="text/css" />
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/noticelist.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
    <script type="text/javascript" src="js/noticelist.js"></script>
    <script type="text/javascript" src="js/common/datedropper.js"></script>
  </head>
  
  <body id="k">
    	<div class="npic">
    		<div class="heads"></div>
    		<div class="npictext">校园公告</div>
    		<div class="npic-block">
    			<div> <input type="text" class="noticeinput-name" placeholder="搜索公告、关键字"/><input type="text" class="noticeinput-starttime" placeholder="开始时间"/><input type="text" class="noticeinput-endtime" placeholder="结束时间"/><div class="corporationsearch-button" onclick="searchnotice()">搜索</div></div>
    			<form action="" method="get" style="color: white;"> 
					<label><input name="set" type="radio" value="0"  checked="checked"/>所有 </label> 
					<label><input name="set" type="radio" value="2" />团委 </label> 
					<label><input name="set" type="radio" value="1" />学生会 </label> 
					<label><input name="set" type="radio" value="3" />社团联合会</label> 
					<label><input name="set" type="radio" value="4" />社团</label> 
				</form>
    		</div>
    		<div class="hotbulltinb"> <div class="hotbulltinb-title"><div class="sab"><i class="iconfont" id="nc">&#xf0201;</i> 热点公告</div><div class="sab2"></div></div></div>
    	</div>
    	<div class="notice-row">
    	<div class="notice-row-left">
    		<div class="notice-row-title"><i class="iconfont" id="na">&#xf00fd;</i> 公告列表</div>
    		<div class="notice-row-left-list">
    			
    				
    		</div>
    		<div class="notice-row-left-page">
    			<div class="prev" style="float: left;"onclick="prevpage()">prev</div>
    			<div class="pagecount" style="display: inline-block;width: 90px;text-align: center;padding-top: 10px;"></div>
    			<div class="next" style="float: right;"onclick="nextpage()">next</div>
    		</div>
    	</div>
    	<div class="notice-row-right">
    		<div class="notice-row-right-more"></div>
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
