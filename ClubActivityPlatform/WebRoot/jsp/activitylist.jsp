<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String actime="";
String acname="";
String acaddress="";
try{
 	actime=new String(request.getParameter("actime").getBytes("ISO-8859-1"), "utf-8");
 	acname=new String(request.getParameter("acname").getBytes("ISO-8859-1"), "utf-8");
 	acaddress=new String(request.getParameter("acaddress").getBytes("ISO-8859-1"), "utf-8");
}catch(Exception e){
	e.printStackTrace();
	actime="";
	acname="";
	acaddress="";
}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'activitylist.jsp' starting page</title>
    
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
 	<link rel="stylesheet" href="css/activitylist.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
    <script type="text/javascript" src="js/activitylist.js"></script>
    <script type="text/javascript" src="js/common/datedropper.js"></script>
    <script type="text/javascript">
    	var actime='<%=actime%>';
    	var acname='<%=acname%>';
    	var acaddress='<%=acaddress%>';
    </script>
  </head>
  
  <body  id="k">
	<div class="apic">
		<div class="heads"></div>
		<div class="apictext">校园活动</div>
		<div class="apictext1">开展大学校园精品活动,促进大学校园精品文化建设。</div>
		<div class="apic-black">
			<div class="hotactivitysearch-center">
  				<input placeholder="想参加的活动？" class="activiysearchname" type="text"/>
  				<input placeholder="活动时间"  class="activiysearchtime" type="text"/>
  				<input placeholder="活动地点"  class="activiysearchaddress" type="text"/>
  				<div class="hotactivitysearch-in" onclick="searchactivity()">搜索</div>
			</div>
		</div>
	</div>
	<div class="hotactivity">
		<div style="font-weight: bold;"><i class="iconfont"  style="color: #f58220">&#xf0104;</i>     热门活动</div>
		<div class="hotactivity-more">
			
		</div>
	</div>
	<div class="activitylist">
		<div  class="activitylist-row">
			<div style="width: 500px;height:12px;border-bottom: 1px solid rgb(200,200,200);margin: auto;"><div style="margin: auto;width: 100px; text-align: center;background: #EDEFED;font-weight: bold;">活动列表</div></div>
			<div class="activitylist-row-list"></div>
			<div class="activitylist-row-page">
				<div class="notice-row-left-page">
    				<div class="prev" style="float: left;"onclick="prevpage()">prev</div>
    				<div class="pagecount" style="display: inline-block;width: 90px;text-align: center;padding-top: 10px;"></div>
    				<div class="next" style="float: right;"onclick="nextpage()">next</div>
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
