<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int myactivityId=Integer.parseInt(request.getParameter("myactivityId"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'activity.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/activity.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
    <script type="text/javascript" src="js/activity.js"></script>
    <script type="text/javascript">
    var myactivityId=<%=myactivityId%>;
    </script>
  </head>
  
  <body id="k">
	<div class="heads"></div>
	<div class="topactivity">
	<div class="activitypic"></div>
	<div class="ativitymm">
		<div class="ativitymm1">
			<div class="ac1"><i class="iconfont"  style="color: #f58220">&#xf0104;</i> 活动资料</div>
			
			<div class="zx1">活动名：<font></font></div>
			<div class="zx2">举办方：<font></font></div>
		
			<div class="zx3">活动地点：<font></font></div>
				<div class="zx4">活动开始时间：<font></font></div>
			<div class="zx5">活动结束时间：<font></font></div>
		</div>
		<div class="ativitymm2"><div class="ac1"><i class="iconfont"  style="color: #f58220">&#xf0104;</i> 活动信息</div>
		<div class="cx1"></div>
		
		</div>
		<div class="ativitymm3">
		<div class="partin" onclick="partinactivity()">报名参加</div>
		<div class="ac1"style="text-indent: 2em"><i class="iconfont"  style="color: #f58220">&#xf0104;</i> 活动参与人员</div>
		<div class="parts"></div>
		
		</div>
		
	</div>
	<div class="activestages">
		
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
