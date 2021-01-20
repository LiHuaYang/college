<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int mygrade=0;
int myactivityId=0;

try{
mygrade=Integer.parseInt(request.getParameter("mygrade").toString());
myactivityId=Integer.parseInt(request.getParameter("myactivityId").toString());

}catch(Exception e){
e.printStackTrace();
mygrade=0;
myactivityId=0;

}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'activitymanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/activitymanage.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
 		<script type="text/javascript">
 		var mygrade=<%=mygrade%>
 		var myactivityId=<%=myactivityId%>
 	</script>
    <script type="text/javascript" src="js/activitymanage.js"></script>
  </head>
  
  <body>
  	<div class="heads"></div>
  	<div class="basic">
   	<div class="basic-row">
  	<div class="basic-title">
   			活动意向<font class="changebasic" onclick="changein()">  修改 <i class="iconfont"  style="color: #f58220">&#xf0022;</i></font>
   		</div>
   		<div class="zxh">活动名：<font></font></div>
   		<div class="p">活动策划人:<font></font></div>
   		<div class="p2">任务方案制定人:<font></font></div>
   		<div class="in-content"></div>
  	</div>
  	</div>
  	<div class="activitysc">
  		<div class="basic-row">
  	<div class="basic-title">
   			活动策划<font class="changebasic" onclick="changein()">  修改 <i class="iconfont"  style="color: #f58220">&#xf0022;</i></font>
   	</div>
   	<div>活动开始时间：<font class="m1"></font></div>
   	<div>活动结束时间：<font class="m2"></font></div>
   	<div>活动地点：<font class="m3"></font></div>
   	<div>活动内容：<font>奥运会自公元 776 年于希腊的奥林匹亚举行以来，已经有 1200 年的历史。当时的运动项目有五项全能（包含铁饼、标枪、跳远、赛跑和摔跤）、赛跑、拳击、摔跤、Pankration（拳击和摔跤的混合运动）、四轮马车赛跑和骑马。奥 跳高项目 跳高项目 林匹克的复兴始自 1896 年，当时希腊的雅典举办了第一次现代奥运会，当时有来自 14 个国家的 245 名运动员参加。此后，参赛运动员、参赛国家和比赛项目与日俱增，在 2000 年澳大利亚的悉尼奥运会上，有来自 199 个国家的 10,000 多名运动员参赛。</font></div>
  	</div>
  	</div>
  	  	
  	<div class="activityti">
  		<div class="basic-row">
  		<div class="basic-title">
  			活动阶段<font class="changebasic" onclick="changein()"> 添加 <i class="iconfont"  style="color: #f58220">&#xf0022;</i></font>
  		 	</div>
  		 <div class="activestages"></div>	
  		</div>
  	</div>
  	<div class="activity-plan">
  		<div class="basic-row">
  		<div class="basic-title">
  			任务方案<font class="changebasic" onclick="changein()"> 编辑 子任务<i class="iconfont"  style="color: #f58220">&#xf0022;</i></font>
  		 	</div>
  		 <div class="saz">任务方案名：<font></font></div>
  		 <div class="asd">任务方案内容：<font></font></div>
  		</div>
  	</div>
  	<div class="activity-member">
  	<div class="basica-row">
  		<div class="basic-title">
  			参与人员<font class="changebasic" onclick="getapply()"> 查看报名<i class="iconfont"  style="color: #f58220">&#xf0022;</i></font>
  		 	</div>
  		 	
		<div class="part-list">
				
		</div>  		 	
  	</div>
  	</div>
  	
  	
  	<div class="psbac" style="display: none;">
  		<div class="psw">
  			<div style="width: 100%;height: 20px;text-align: center;border-bottom:1px solid rgb(200,200,200)">申请列表</div>
  			<div class="plist" style="width: 100%;height: 200px;overflow-x:hidden;  "></div>
  			<div class="godsz"><button onclick="closzg()">取消</button></div>
  		</div>
  	</div>
  </body>
</html>
