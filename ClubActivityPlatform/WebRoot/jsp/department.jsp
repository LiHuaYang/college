<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int mydepartmentId=Integer.parseInt(request.getParameter("mydepartmentId"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'department.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/department.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
    <script type="text/javascript" src="js/department.js"></script>
    <script type="text/javascript">
    	var mydepartmentId=<%=mydepartmentId%>;
    </script>
  </head>
  
  <body id="k">
   	<div class="dpic">
   		<div class="heads"></div>
   		<div class="dpic-left"></div>
   		<div class="dpic-right">
   			<div class="dpic-context"></div>
   		</div>
   		<div class="dpic-name">办公室</div>
   	</div>
   	
   	<div class="dmember">
   		<div class="dmember-row">
   		
   			<div class="dmember-list">
   					<div style="width: 500px;text-align: center;font-size: 20px;height: 30px;margin: auto;border-bottom: 1px solid rgb(200,200,200);">部门成员</div>
   			<div style="text-align: center;font-size: 13px;">我们来自不同的地方，为了相同的目标，一起努力，一起奋斗。</div>
   			</div>
   			<div class="dmember-add">
   				<div class="part-in">
  				<div style="padding-top: 5px;text-align: center;margin: auto;width:200px;border-bottom: 1px solid rgb(200,200,200);">加入我们</div>
  				<div style="width:100%;text-align: center;font-size: 12px;">收获更多的朋友，更多的乐趣。</div>
  				<textarea class="part-text" placeholder="说点什么呗！"></textarea>
  				<div style="margin-top: 30px;">
  				<div class="button1" onclick="partin()">提交</div>
  				<div class="button2" onclick="reset()">取消</div>
  				</div>
  			</div>
   			</div>
   		</div>
   	</div>
   	<div class="other-department">
   		<div class="other-department-row">
   				<div style="padding-top:30px;width: 500px;text-align: center;font-size: 20px;height: 15px;margin: auto;border-bottom: 1px solid rgb(200,200,200);"><div style="background: white;margin: auto;width: 100px;">其他部门</div></div>
   				<div class="department-list"></div>
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
