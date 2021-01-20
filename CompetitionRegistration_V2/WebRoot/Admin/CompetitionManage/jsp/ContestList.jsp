<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>CompetitionIndexJSP</title>
    <link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
    <link href="Admin/CompetitionManage/css/competition.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="Admin/Common/common.js"></script>
    <script type="text/javascript" src="Admin/Common/Page/paging.js"></script>
    <script type="text/javascript" src="Admin/CompetitionManage/js/competition.js"></script>
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
	        			大赛管理--赛事列表
	        		</h5>
        		</div>
        		<div class="data-panel">
        		<ul class="opration-bar">
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="addcompetition()"><i class="iconfont font">&#xf0175</i>添加大赛</button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="deletemost()"><i class="iconfont font">&#xf013f</i>批量删除</button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="entering()"><i class="iconfont font">&#xf00b2</i>编辑状态</button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="importTest()"><i class="iconfont font">&#xf00a8</i>导入试卷</button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="openCheckGrade()"><i class="iconfont font">&#xf00b2</i>开放成绩查询 </button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="clearCheckGrade()"><i class="iconfont font">&#xf013f</i>清除成绩缓存 </button>
				  </li>
				</ul>
        			<ul class="opration-bar">
        				<li>
        					<input type="text" id="contest_name_keyword" placeholder="大赛模糊关键字"></input>
        					<button class="op-button" onclick="Search()"><i class="iconfont font">&#xf012c</i>查找</button>
        				</li>
        			</ul>
        			<table class="data-table">
					  <tr class="odd data-title">
					  	<td style="width:35px;"></td>
					    <td>赛事名称</td>
					    <td>开始报名时间</td>
					    <td>结束报名时间</td>
					    <td>科目</td>
					    <td>赛事对象</td>
					    <td>考试形式</td>
					    <td>发布状态</td>
					    <td>操作</td>
					  </tr>
					  <%for (int i=0; i<10; i++) { %>
					  <tr class="odd" id="row"+<%=i%> onclick="choose(this)">
					    <td id="check-item"><input name="box" type="checkbox" value="Heating"></td>
					    <td onclick="do_onclick(this)" id="contest_id" style="display:none"></td>
					    <td onclick="do_onclick(this)" id="contest_name"></td>
					    <td onclick="do_onclick(this)" id="contest_start_time"></td>
					    <td onclick="do_onclick(this)" id="contest_end_time"></td>
					    <td onclick="do_onclick(this)" id="contest_Subject"></td>
					    <td onclick="do_onclick(this)" id="contest_player"></td>
					    <td onclick="do_onclick(this)" id="contest_test_type"></td>
					    <td onclick="do_onclick(this)" id="contest_publish_state"></td>
					    <td style="width:100px;">
					    <i class="iconfont font" onclick="deletemost(this)">&#xf00b3</i></td>
					  </tr>
					  <% } %>
					</table>
						<jsp:include page="../../Common/Page/Page.jsp" flush="true" />
        		</div>
        	</div>
        	<div style="clear:both"></div>
	  	</div>
	  	<br><br><br><br>
	  	<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
  	</div>
  	
  	<!-- ------------------------------弹窗样式二------------------------------  -->
	    <div id="organizePanel" class="bodymiddle" style="display: none;" >
		    <div class="middleFrame">
		        <div class="middleClose" onclick="middleClose()"><i class="iconfont">&#xf00b3;</i></div>
		        <div class="Frameinformation">
		        	<span>竞赛状态</span>
		        		<select class="conteststate">
		        			<option>未发布</option>
		        			<option>即将开始报名</option>
		        			<option>正在报名</option>
		        			<option>比赛进行中</option>
		        			<option>已结束</option>
		        			<option>大赛删除</option>
		        			<option>置顶</option>
		        		</select>
			       </div>
			        <button class="Phonetext" onclick="okenter()">确认</button>
		        </div>
		    </div>
		    <!-- ------------------------------弹窗样式------------------------------  -->
       <!-- ------------------------------弹窗样式三------------------------------  -->
	    <div id="checkPanel" class="bodymiddle" style="display: none;" >
		    <div class="middleFrame">
		        <div class="middleClose" onclick="closeCheckPanel()"><i class="iconfont">&#xf00b3;</i></div>
		        <div class="Frameinformation">
		        	<span class="checkClass">确认开放成绩查询？</span>
		        	<span class="checkClass1">（开放前请先导入成绩）</span>
			       </div>
			        <button class="Phonetext" onclick="okCheck()">确认</button>
		        </div>
		    </div>
		 <!-- ------------------------------弹窗样式三------------------------------  -->
		  <!-- ------------------------------弹窗样式四------------------------------  -->
	    <div id="checkPanel1" class="bodymiddle" style="display: none;" >
		    <div class="middleFrame">
		        <div class="middleClose" onclick="closeCheckPanel1()"><i class="iconfont">&#xf00b3;</i></div>
		        <div class="Frameinformation">
		        	<span class="checkClass">确认清除成绩缓存？</span>
			       </div>
			        <button class="Phonetext" onclick="okCheck1()">确认</button>
		        </div>
		    </div>
		 <!-- ------------------------------弹窗样式四------------------------------  -->
	</body>
</html>
