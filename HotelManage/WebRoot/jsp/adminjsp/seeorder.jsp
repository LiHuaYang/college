<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>保洁员详情</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/common/iconfont/iconfont.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/main.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/seeroom.css" type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/main.js"></script>
		<script type="text/javascript" src="js/adminjs/comm.js"></script>		
	</head>

	<body>
	      <div class="wrap">
            <!-- 页面头部开始 -->
		<div class="head"> 
        	<!-- 网站图标 -->
        	<div class="web-info-wrap">
        		<span class="logo-wrap"><i class="iconfont font">&#xf01ca</i></span>
        		<span class="title-wrap"><p>远方民宿管理系统</p></span>
        	</div>
        	<div class="admin-info-wrap">
        		<div class="admin-name-wrap"><p>欢迎Adminietrator</p></div>
        		<div class="opration-wrap"><a href="http://www.w3school.com.cn">修改密码</a><a href="http://www.w3school.com.cn">退出登录</a></div>
        	</div>
        </div>
            <!-- 页面头部结束 -->
<!-- ------------------------------------------------------------------------------------- -->  
            <!-- 页面内容开始 -->
            <div class="content">
                <div class="mainleft">
                    <div class="mainlefthead">系统导航</div>
                    <ul class="left_list">
                    <li class="one" id="userbit" onclick="changecolors(this),tomainroom()">房间</li>
                    <li class="one" onclick="changecolors(this),tomainclient()">客户</li>
                    <li class="one" onclick="changecolors(this),tomainorder()">订单</li>
                    <li class="one" onclick="changecolors(this),tomaincleaner()">清洁工</li>
                    <li class="one" onclick="changecolors(this),tomainevaluation()">评价</li>
                    <li class="one" onclick="changecolors(this),tomainhistory()">历史纪录</li>
                    </ul>
                </div>
                <div class="mainright">
                <div class="room-info-wrap">
                    <ul>
                        <li>
                            <div class="basic">
                            <!--TODO:    condition-title需要修改    -->
                            <div class="condition-title"><p><span style="font-weight:bold;">||</span>&nbsp基本信息</p></div>
<!-- -------------------------------------------------------------------------------------------- -->
								<table class="data-table">
									<tr class="odd">
										<td>订单号码:</td>
										<td>2</td>
										<td>入住天数:</td>
										<td>2</td>
									</tr>
									<tr>
										<td>入住人数 :</td>
										<td>2</td>
										<td>入住时间:</td>
										<td>2015-1-10</td>
									</tr>
									<tr class="odd">
										<td>退房时间:</td>
										<td>2015-1-11</td>
										<td>付款金额:</td>
										<td>200</td>
									</tr>
									<tr>
										<td>房间号</td>
										<td>201</td>
										<td>客户号:</td>
										<td>101</td>
									</tr>
									<tr>
										<td>下单客户ID号:</td>
										<td>201214</td>
										<td>下单电话号码：</td>
										<td>178261621728</td>
									</tr>
            						<tr>
										<td>下单客户姓名:</td>
										<td>老王</td>
										<td>订单状态：</td>
										<td>完成</td>
									</tr>
								</table>
<!-- -------------------------------------------------------------------------------------------- -->                               
                                </div>
                            </li>
                    </ul>
                </div>
                </div>
            </div>
    
    
<!-- ------------------------------------------------------------------------------------- -->
            <div style="clear:both"></div>
            <!-- 页面底部开始 -->
            <div class="foot"></div>
            <!-- 页面底部结束 -->
        </div>
	</body>
</html>
