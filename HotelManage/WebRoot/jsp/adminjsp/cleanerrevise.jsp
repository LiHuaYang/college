<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>保洁员修改界面</title>
		<link rel="stylesheet" href="css/common/iconfont/iconfont.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/mainroom.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/main.css" type="text/css"></link>
		<link rel="stylesheet" href="css/admincss/seeroom.css" type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/main.js"></script>
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
                    <li id="toroom"    >房间</li>
                    <li id="toclient"  >客户</li>
                    <li id="toorder"   >订单</li>
                    <li id="tocleaner" >清洁工</li>
                    <li id="tocommit"  >评价</li>
                    <li id="tohistroy" >历史纪录</li>
                    </ul>
                </div>
                <div class="mainright">
                    <div class="room-info-wrap">
                        <ul>
                            <li>
                                <div class="basic">
                                    <!--TODO:    condition-title需要修改    -->
                                    <div class="condition-title"><p><span style="font-weight:bold;">||</span>&nbsp基本信息</p></div>
                                    <table class="data-table">
                                      	<tr class="odd">
                                          <td>清洁员号 ：</td><td><input value="1111"></td>
                                          <td>身份证号:</td><td><input value="1111"></td>
                                          </tr>
                                          <tr>
                                          <td>电话号码:</td><td><input value="1111"></td>
                                          <td>名字:</td><td><input value="1111"></td>
                                          </tr>
                                          <tr class="odd">
                                          <td>密码:</td><td><input value="1111"></td>
                                          <td>性别:</td><td><input value="1111"></td>
                                          </tr>
                                          <tr>
                                          <td>状态:</td><td><input value="1111"></td>
                                          <td></td><td></td>
                                      	</tr>
                                    </table>  
                                    <div class="condition-title"><p><span style="font-weight:bold;">||</span>&nbsp其他信息</p></div>
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
