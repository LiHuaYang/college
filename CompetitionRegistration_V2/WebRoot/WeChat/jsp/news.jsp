<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'news.jsp' starting page</title>
    <meta name="viewport" content="width=device-width,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="WeChat/css/news.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="menu">
		  
		  <span><i class="iconfont font">&#xf011f</i></span>
		  <span>
			  <input class="abox" type="text" disabled="disabled" value="首页" onclick="ww()"></input>
			  <input class="abox" type="text" disabled="disabled" value="商城" onclick="ww()"></input>
			  <input class="abox" type="text" disabled="disabled" value="发现" onclick="ww()"></input>
		  </span>
		  <span><i class="iconfont font" id="user">&#xf012d</i></span>
	</div>
    <div class="navigation">
		   <div class="nav">
				<span>北京</span>
				<span><i class="iconfont font">&#xf0170</i></span>
				<span class="box">
					<span><i class="iconfont font">&#xf012c</i></span>
					<span><input type="text" placeholder="影片/影院/影人，任你搜"></input></span>
				</span>
		   </div>
	  </div>
		 <div class="news">
			 <div class="ww">
				  <span>正在热映（45部）</span>
				  <div class="fl"><i class="iconfont font">&#xf016d</i></div>
			 </div>
			 <div class="bbox">
					<div class="pic">
						 <div class="image"></div>
						 <div class="name">vvb</div>
					</div>
					<div class="pic">
						<div class="image"></div>
						 <div class="name">vvb</div>
					</div>
					<div class="pic">
							<div class="image"></div>
						 <div class="name">vvb</div>
					</div>
					<div class="pic">
							<div class="image"></div>
						 <div class="name">vvb</div>
					</div>
					<div class="pic">
							<div class="image"></div>
						 <div class="name">vvb</div>
					</div>
					<div class="pic">
							<div class="image"></div>
						 <div class="name">vvb</div>
					</div>
					<div class="pic">
							<div class="image"></div>
						 <div class="name">vvb</div>
					</div>
					<div class="pic">
							<div class="image"></div>
						 <div class="name">vvb</div>
					</div>
			 </div>
			 <div class="ww">
				  <span>即将上映（28部）</span>
				  <div class="fl"><i class="iconfont font">&#xf016d</i></div>
			 </div>
		 </div>
		 <div class="apic"></div>
		 <div class="foot">
			<div class="white">
					<span class="last">首页</span>
					<span class="last">购票</span>
					<span class="last">商城</span>
					<span class="last">发现</span>
					<span class="last">我的</span>
			</div>
			<div class="sort">
				<div class="key">
					 <span>pc端</span>
					 
				</div>
				<div class="key">
					 <span>客户端下载</span>
					 
				</div>
				<div class="key">
					 <span>意见反馈</span>
					 
				</div>
				<div class="key" id="help">
					 <span>帮助中心</span>
					 
				</div>
		  </div>
	</div>
  </body>
</html>
