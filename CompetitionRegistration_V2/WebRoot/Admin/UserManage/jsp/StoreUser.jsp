<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>StoreUserjsp</title>
    <link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="Admin/Common/common.js"></script>
    <script type="text/javascript" src="Admin/Common/Page/paging.js"></script>
    <script type="text/javascript" src="Admin/UserManage/js/userlist.js"></script>
  </head>
  <body>
 	<div id="wrap">
	  	<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
	  	<div id="content">
	  		<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
        	<div id="mainright">
        		<div class="right-head">
	        		<h5>
	        			<i class="iconfont font">&#xf017d</i>
	        			客户管理--商城客户
	        		</h5>
        		</div>
        			<ul class="opration-bar">
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="toaddUser()"><i class="iconfont font">&#xf0175</i>添加用户</button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="deleteSomeUser()"><i class="iconfont font">&#xf013f</i>批量删除</button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="uploadUserInfo()"><i class="iconfont font">&#xf0175</i>Excel导入</button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="exportusers()"><i class="iconfont font">&#xf00a8</i>导出用户</button>
				  </li>
				</ul>
				<ul class="opration-bar">
        				<li>
        					<input id="name_keyword" type="text" placeholder="姓名模糊关键字"></input>
        					<button id="name" class="op-button" onclick="search(this)"><i class="iconfont font">&#xf012c</i>查找</button>
        				</li>
        			</ul>
        			<table class="data-table">
					  <tr class="odd data-title">
					    <td></td>
					    <td>用户姓名</td>
					    <td>用户昵称</td>
					    <td>就读年级</td>
					    <td>联系人</td>
					    <td>联系电话</td>
					    <td>指导老师</td>
					    <td>指导老师电话</td>
					    <td>状态</td>
					    <td>操作</td>
					  </tr>
					 <%for (int i=0; i<10; i++) { %>
					  <tr class="odd">
					  <input type="hidden" id="userID" value=""/>
					  <td><input name="box" type="checkbox" value="Heating"></td>
					    <td onclick="clickTr(this)" id="user"></td>
					    <td onclick="clickTr(this)" id="nickname"></td>
					    <td onclick="clickTr(this)" id="grade"></td>
					    <td onclick="clickTr(this)" id="connect-people"></td>
					    <td onclick="clickTr(this)" id="connect-phone"></td>
					    <td onclick="clickTr(this)" id="teacher"></td>
					    <td onclick="clickTr(this)" id="teacher-phone"></td>
					     <td onclick="clickTr(this)" id="state"></td>
					    <td style="width:100px;">
					    <i class="iconfont font" onclick="toModify(this)">&#xf014f</i>
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <i class="iconfont font" onclick="deleteAUser(this)">&#xf00b3</i></td>
					  </tr>
					  <% } %>
					</table>
					<jsp:include page="../../Common/Page/Page.jsp" flush="true" />
					
					<div class="tabPanel">
					<ul class="panel-title">
						<li class="hit">参加过比赛的信息</li>
						<li>相关评价</li>
						<li>大赛参加人员</li>
					</ul>
					<div class="panes">
					<div class="pane" style="display:block">
						<li id="">赛事名称</li><span id="contest_name"></span>
						<li >赛事承办方</li>
						<li>相关评价</li>
					</div>
					<div class="pane"><h4>Secend tab content</h4><p>Secend tab content</p></div>
					<div class="pane"><h4>Third tab content</h4><p>Third tab content</p></div>
					</div>
			    </div>
			    
        		</div>
				<div style="clear:both"></div>
        	</div>
        	<br><br><br><br>
	  	<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
  	</div>
  </body>
</html>
