<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String UserId = new String(request.getParameter("UserId").getBytes("ISO-8859-1"),"utf-8");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>客户查看页面</title>
		<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/main.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/seeroom.css" type="text/css"></link>
		<link rel="stylesheet" href="css/common/iconfont/iconfont.css" type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/main.js"></script>
		<script type="text/javascript" src="js/adminjs/seecustomer.js"></script>
		<script type="text/javascript" src="js/adminjs/consumehis.js"></script>
		<script type="text/javascript" src="js/common/comm.js"></script>
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
	                    <li onclick="liClick(this)">房间</li>
	                    <li onclick="liClick(this)">客户</li>
	                    <li onclick="liClick(this)">订单</li>
	                    <li onclick="liClick(this)">清洁工</li>
	                    <li onclick="liClick(this)">评价</li>
	                    <li onclick="liClick(this)">历史纪录</li>
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
                              <td>客户姓名:</td><td>张三</td>
                              <td>客户性别:</td><td>男</td>
                            </tr>     
							<tr>	
                              <td>客  户  号 :</td><td>1201201</td>
                              <td>登陆密码:</td><td>wooo</td>
                            </tr> 
                            <tr class="odd">	
                              <td>电话:</td><td>12131323421</td>
                              <td>电子邮箱:</td><td>1111@qq.com</td>
                            </tr>
							<tr>	
                              <td>身份证</td><td>888182818828182818828</td>
                              <td>账户余额:</td><td>1000</td>
                            </tr>							
                            <tr>	
                              <td>客户状态:</td><td>在线</td>
                              <td>VIP类型：</td><td>VIP</td>
                            </tr>
                            </table>
<!-- -------------------------------------------------------------------------------------------- -->                               
                                </div>
                            </li>
                        <li class="room-info-wrap">
                            <div class="other">
                                <div class="condition-title">
                                <button class="tag-button" onclick="judge(this)">消费记录</button>
                                <button class="tag-button" onclick="judge(this)">充值记录</button>
                                <button class="tag-button" onclick="judge(this)">订单记录</button>
                                </div>
								<div class="mainhistorydiv" id="customer1" style="display:block">
									<table class="property">
										<tr>
											<td>消费记录号</td>
											<td>消费时间</td>
											<td>消费金额</td>
											<td>下单名字</td>
											<td>下单手机号</td>
											<td>下单身份证</td>
											<td>消费地点</td>
											<td>客户号</td>
										</tr>
									</table>
									<div class="mrtruediv"></div>
									<div class="fenye"></div>
								</div>
								<div class="mainclientdiv" id="customer2" style="display:none">
									<table class="property">
										<tr>
											<td>充值记记录号</td>
											<td>充值时间</td>
											<td>充值金额</td>
											<td>客户号</td>
										</tr>
									</table>
									<div class="mrtruediv"></div>
									<div class="fenye"></div>
								</div>
								<div class="mainorderdiv" id="customer3" style="display:none">
									<table class="property">
										<tbody>
											<tr>
												<td>订单号</td>
												<td>入住天数</td>
												<td>入住人数</td>
												<td>入住时间</td>
												<td>下单时间</td>
												<td>退房时间</td>
												<td>付款金额</td>
											</tr>
										</tbody>
									</table>
									<div class="mrtruediv"></div>
									<div class="fenye"></div>
									<!-- -------------------------------------------------------------------------------------------- -->
									<!-- -------------------------------------------------------------------------------------------- -->
								</div></li>
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
		<script type="text/javascript">
			var UserId3 = <%=UserId%>
		</script>
	</body>
</html>
