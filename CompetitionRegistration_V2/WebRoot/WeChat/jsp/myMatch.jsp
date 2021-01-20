<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int baruserid=0;
try{
    baruserid=Integer.parseInt(request.getParameter("baruserid"));
}catch(Exception e){
    e.printStackTrace();
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的成绩</title>
        <meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="WeChat/css/myMatch.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript">var userId=<%=baruserid%></script>
    <script type="text/javascript" src="WeChat/js/myMatch.js"></script>
  </head>
  
  <body>
    <div class="navigation">
	        <div class="back">
	       <span> <i class="iconfont font" id="left" onclick="history.go(-1)">&#xf016e</i></span>
	        <span class="mymatch" >我的成绩</span>
	        </div>
	   </div>   
       <div class="mymatchbody">
       <div class="mymatchnull" style="display:none;">您还没有比赛，快去报名吧!!!</div>
     
       	<!--  	<table class="matchlist" >
       			<tr>
       				<span class="tablehead" cellpadding="0"  cellspacing="0" >2016年全国”迎新杯“科普活动</span>
       			</tr>
       			<tr>
       				<td>
       					<div class="divkuang">第一届
       				</div>
       				</td>
       			</tr>
       			<tr> 
       				<td>比赛等级：</td>
       				<td>初中八级</td>
       			</tr>
       			<tr>
       				<td>比赛类别：</td>
       				<td>数学</td>
       			</tr>
       			<tr>
       				<td>参赛者：</td>
       				<td>1</td>
       				<td class="gradetd" >成绩:</td>
       				<td style="color:#808080;">未出成绩</td>
       			</tr>
       		</table>
      -->
       </div>
  </body>
</html>
