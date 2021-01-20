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
		<title>用户信息修改</title>
		<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/main.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/seeroom.css" type="text/css"></link>
		<link rel="stylesheet" href="css/common/iconfont/iconfont.css" type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/main.js"></script>
		<script type="text/javascript" src="js/adminjs/comm.js"></script>		
		<script type="text/javascript" src="js/adminjs/customerrevise.js"></script>
	</head>
	<body>
	      <div class="wrap">
            <!-- 页面头部开始 -->
		<div class="head">
			<!-- 网站图标 -->
			<div class="web-info-wrap">
				<span class="logo-wrap"><i class="iconfont font">&#xf01ca</i>
				</span> <span class="title-wrap"><p>远方民宿管理系统</p> </span>
			</div>
			<div class="admin-info-wrap">
				<div class="admin-name-wrap">
					<p>欢迎Adminietrator</p>
				</div>
				<div class="opration-wrap">
					<a href="http://www.w3school.com.cn">修改密码</a><a
						href="http://www.w3school.com.cn">退出登录</a>
				</div>
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
                            <div class="condition-title"><p><span style="font-weight:bold;">||</span>&nbsp基本信息<button value="提交"  onclick=ChangeUser();>修改	</button></p></div>
<!-- -------------------------------------------------------------------------------------------- -->
								<table class="data-table">
									<tr class="odd">
										<td>客户姓名:</td>
										<td><input value="张三"></td>
										<td>客户性别:</td>
										<td><select><option>男</option><option>女</option></select></td>
									</tr>
									<tr>
										<td>客 户 号 :</td>
										<td><input value="1201201"></td>
										<td>登陆密码:</td>
										<td><input value="12012"></td>
									</tr>
									<tr class="odd">
										<td>电话:</td>
										<td><input value="12012012222"></td>
										<td>电子邮箱:</td>
										<td><input value="1111@qq.com"></td>
									</tr>
									<tr>
										<td>身份证</td>
										<td><input value="888182818828182818828"></td>
										<td>账户余额:</td>
										<td><input value="888"></td>
									</tr>
									<tr>
										<td>客户状态:</td>
										<td><input value="在线"></td>
										<td>VIP类型：</td>
										<td><select><option>VIP</option><option>非VIP</option></select></td>
									</tr>
								</table>
								<!-- -------------------------------------------------------------------------------------------- -->                               
                            </div>
                            </li>
                        <li class="room-info-wrap">
                            <div class="other">
                                <div class="condition-title"><p><span style="font-weight:bold;">||</span>&nbsp其他信息</p></div>
                                
<!-- -------------------------------------------------------------------------------------------- -->
							     <div class="info-content"">
								<div>
									<form>
										<textarea id="UserMessage" rows="18" cols="130"
											style="height:200px;"></textarea>
									</form>
								</div>
							</div>
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
		<script type="text/javascript">
			var UserId3 = <%=UserId%>
		</script>
	</body>
</html>
