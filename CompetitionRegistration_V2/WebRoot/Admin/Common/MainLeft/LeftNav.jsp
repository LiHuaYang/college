<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="Admin/Common/MainLeft/LeftNav.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="Admin/Common/MainLeft/LeftNav.js"></script>
  </head>
  
  <body>
    <div id="mainleft">
        <div class="left-head">
			<h3>板块导航</h3>        
        </div>
        <dl id="left0">
           <dt onclick="list(this)"  id="item0">基础管理</dt>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="basic_competition_data">基础数据</a></dd>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="basic_competition_setting">网站基本配置</a></dd>
       </dl>
       
        <dl id="left1">
           <dt onclick="list(this)"  id="item1">大赛管理</dt>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="const_list">赛事列表</a></dd>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="const_people">参赛人员</a></dd>
		   <dd><a href="javascript:void(0)" onclick="load_list(this)" id="const_score">大赛成绩</a></dd>
       </dl>
       <dl id="left2">
           <dt onclick="list(this)" id="item2">用户管理</dt>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="store_user">用户列表</a></dd>
       </dl>
       <dl id="left3">
           <dt onclick="list(this)" id="item3">订单管理</dt>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="wait_deal">待处理</a></dd>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="all_order">全部订单</a></dd>

       </dl>
       <dl id="left4">
           <dt onclick="list(this)" id="item4">商场管理</dt>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="stocks_list">库存列表</a></dd>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="today_add">今日新增</a></dd>
       </dl>
           <dl id="left5">
           <dt onclick="list(this)" id="item5">新闻管理</dt>
           <dd><a href="javascript:void(0)" onclick="load_list(this)" id="news_list">新闻列表</a></dd>
       </dl>
   </div>
  </body>
</html>
