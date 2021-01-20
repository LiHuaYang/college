<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>contender</title>
    <link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
    <link href="Common/Tool/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
    
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script src="Common/Tool/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="Admin/Common/common.js"></script>
    <script type="text/javascript" src="Admin/Common/Page/paging.js"></script>
    <script type="text/javascript" src="Admin/CompetitionManage/js/contender.js"></script>
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
	        			大赛管理--参赛人员
	        		</h5>
        		</div>
        		<ul class="opration-bar">
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="exportcontender()"><i class="iconfont font">&#xf00a8</i>导出参赛人员</button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="inportcontender()"><i class="iconfont font">&#xf00a8</i>导入参赛人员</button>
				  </li>
				   <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="addcontender()"><i class="iconfont font">&#xf0175</i>添加参赛人员</button>
				  </li>
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="entering()"><i class="iconfont font">&#xf0175</i>录入成绩 </button>
				  </li>
				  
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="entering()"><i class="iconfont font">&#xf012c</i>报名详情</button>
				  </li>
				  
				  	 <li>
				  	<div style="margin-left:300px;">
			       		 <div id="fileQueue">
			       		 </div>
			       		 <input type="file" name="uploadify" id="upExcel" />
			             <%--<a href="javascript:$('#uploadify1').uploadify('upload')">上传</a>| 
			             <a href="javascript:$('#uploadify1').uploadify('cancel')">取消上传</a>--%>
				 	 </div>
				  </li>
				  
				</ul>
        			<ul class="opration-bar">
        				<li>
        					<span style="font-size:0.80em;">大赛选择:</span>
        					<select class="Verificationselect" id="select_orga">
		                	
		                	</select>
		                	<span style="font-size:0.80em;">科目选择:</span>
        					<select class="Verificationselect_subject" id="select_sub" onclick="show_subject()">
		                    
		                	</select>
        					<button class="op-button" onclick="getStudentInfo()"><i class="iconfont font">&#xf012c</i>查找</button>
        				</li>
        				<li>
        					<input type="text" id="student_name_keyword" placeholder="用户姓名关键字"></input>
        					<button class="op-button" onclick="search()"><i class="iconfont font">&#xf012c</i>查找</button>
        				</li>
        			
        			</ul>
        			
        			<table class="data-table">
					  <tr class="odd data-title">
					  	<td style="width:35px;"></td>					  
					    <td>姓名</td>
					    <td>大赛名</td>
					    <td>参赛科目</td>
					    <td>参赛报名状态</td>
					    <td>联系电话</td>
					    <td>学生成绩</td>
					    <td>报名详情</td>
					  </tr>
					  <%for (int i=0; i<10; i++) { %>
					  <tr class="odd">
					    <td><input name="box" type="checkbox" value="Heating"></td>
					    <td id="enrollmentid" style="display:none"></td>
					    <td id="JoinerName" onclick="do_onclick(this)"></td>
					    <td id="CompetitionName" onclick="do_onclick(this)"></td>
					    <td id="CompetitionSubject" onclick="do_onclick(this)"></td>
					    <td id="BaoMingZhunagTai" onclick="do_onclick(this)"></td>
					    <td id="Phone" onclick="do_onclick(this)"></td>
					    <td id="Score" onclick="do_onclick(this)"></td><%--
					    浏览器请求
					    --%><td><a id="enroDetail" href="" target="_blank">报名详情</a></td>
					  </tr>
					  <% } %>
					</table>
					<jsp:include page="../../Common/Page/Page.jsp" flush="true" />
        		</div>
        	</div>
        	<div style="clear:both"></div>
	  	</div>
	  	<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
  	</div>
  	
  		    <!-- ------------------------------弹窗样式二------------------------------  -->
	    <div id="organizePanel" class="bodymiddle" style="display: none;" >
		    <div class="middleFrame">
		        <div class="middleClose" onclick="middleClose()"><i class="iconfont">&#xf00b3;</i></div>
		        <div class="Frameinformation">
		        	<span>请输入成绩</span>
		        	<input id="inputscore">
			       </div>
			        <button class="Phonetext" onclick="okenter()">确认</button>
		        </div>
		    </div>
		    <!-- ------------------------------弹窗样式------------------------------  -->
  </body>
</html>
