<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
		<head>
			<base href="<%=basePath%>">
			<title>添加大赛</title>
			<link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
			<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
			<link rel="stylesheet" href="Admin/CompetitionManage/css/competition.css" type="text/css"></link>
			<link href="Admin/Common/Tool/JqDate/jquery-ui.min.css" rel="stylesheet" type="text/css" />
			<link href="Common/Tool/uploadify/uploadify.css" rel="stylesheet" type="text/css" />	
			<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
			<script type="text/javascript" src="Admin/Common/common.js"></script>
			<script src="Admin/Common/Tool/JqDate/jquery-ui.js" type="text/javascript"></script>
			<script src="Common/Tool/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
			<script type="text/javascript" src="Admin/CompetitionManage/js/addCompetition.js"></script>
			<script type="text/javascript" src="Common/Tool/ckeditor/ckeditor.js"></script>
		</head>
		<body>
			<div id="wrap">
				<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
				<div id="content">
					<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
					<div id="mainright">
						<div class="right-head">
							<h5><i class="iconfont font">&#xf017d</i> 大赛信息--概要信息描述</h5>
						</div>
	 					<table class="opera-form" id="">
							<tr>
								<td style="width:200px;">竞赛名称:</td><td>
								<select class="Verificationselect" id="select_competition_name" style="height:100%">
		                		<option selected="true" disabled="true" >请选择大赛名字</option>
		                		</select>
		                		</td></tr>
								<tr><td style="width:100px;">竞赛届数:</td><td><textarea type="text" value="" id="sf_CompetitionSession" style="display:block; resize: vertical;" placeholder="只能填数字"></textarea></td></tr>
								<tr><td style="width:100px;">主办单位:</td><td><textarea type="text" value="" id="sf_Organinaze" style="display:block; resize: vertical;" placeholder="选填"></textarea></td></tr>
								<tr><td style="width:100px;">赛事形式:</td><td><textarea type="text" value="" id="sf_ContestexamType" style="display:block; resize: vertical;" placeholder="选填"></textarea></td></tr>
							<tr>
							<td style="width:200px;">赛事时间描述:</td><td><textarea type="text" value="" id="sf_CompetitionTime" style="display:block; resize: vertical;" placeholder="选填"></textarea></td>
							</tr>
							<tr>
							<td style="width:200px;">奖项设置描述:</td><td><textarea id="sf_Contest_Prize" style="display:block; resize: vertical;" type="text" placeholder="选填"></textarea></td>
							</tr>
							<tr>
							<td style="width:200px;">赛事对象描述：</td><td><textarea id="sf_Contest_Obj" style="display:block; resize: vertical;" type="text" placeholder="选填"></textarea></td>
							</tr>
							<tr>
							<td style="width:200px;">赛事简介：</td><td><textarea id="sf_CompetitionIntro" style="display:block; resize: vertical;" type="text" placeholder="选填"></textarea></td>
							</tr>
							<tr>
							<td style="width:200px;">赛事标语：</td><td><textarea id="sf_ContestPropaganda" style="display:block; resize: vertical;" type="text" placeholder="选填"></textarea></td>
							</tr>
							<tr>
							<td>费用描述:</td><td><textarea id="sf_Contest_Price" style="display:block; resize: vertical;" type="text" placeholder="选填"></textarea></td>
						</tr>
						
						<tr>
							<td>大赛Logo(200*250)</td><td>
							<div>
					        	<%--用来作为文件队列区域--%>
					       		 <div id="fileQueue">
					       		 </div>
					       		 <input type="file" name="uploadify" id="uploadify" />
					            	<a href="javascript:$('#uploadify').uploadify('upload')">上传</a>| 
					            	<a href="javascript:$('#uploadify').uploadify('cancel')">取消上传</a>
				    		</div>
							</td>
						</tr>
						<tr>
							<td>竞赛详情宽图(1920*480)</td><td>
							<div>
					        	<%--用来作为文件队列区域--%>
					       		 <div id="fileQueue">
					       		 </div>
					       		 <input type="file" name="uploadify" id="uploadify1" />
					            <a href="javascript:$('#uploadify1').uploadify('upload')">上传</a>| 
					            <a href="javascript:$('#uploadify1').uploadify('cancel')">取消上传</a>
				    		</div>
							</td>
						</tr>
						
						<tr><td style="">大赛报名时间设置:</td><td>
						</i><input type="text" placeholder="竞赛开始报名时间" class="Phonetext" id="nsf_CompetitionEnrollStartTime" />
		                <input type="text" placeholder="竞赛结束报名时间" class="Phonetext" id="nsf_CompetitionEnrollEndTime" />
						</td></tr>
							<tr>
							<td style="width:100px;">赛事详情:</td>
							<td>
							<textarea type="text" name="editor1" value="" id="sf_Competitiondetails" style="display:block; resize: vertical;" placeholder="选填"></textarea>
							<script>CKEDITOR.replace('editor1');</script>
							</td>
							</tr>
						</table>
	
						<div class="right-head">
							<h5>
								<i class="iconfont font">&#xf017d</i> 大赛信息--科目信息设置
							</h5>
						</div>
						<div id="subject_info_panel">
							<table class="cl-info" id="basic_dt">
								<tr class="odd data-title">
								<td style="width:20px;"></td>
							    <td>考试科目</td>
							    <td>考试形式</td>
							    <td>考试对象</td>
						  	</tr>
							</table>
							<ul class="cl-opr">
							  <li> <button style="display:block" onclick="show()">增加大赛科目</button> </li>
							  <%--<li> <button style="display:block" onclick="DeleteAContestDataList()">删除大赛科目</button> </li>--%>
							</ul>
							<div style="clear:both"></div>
						</div>
						<br><br>
						<div class="right-head">
							<h5>
								<i class="iconfont font">&#xf017d</i> 大赛信息--承办方信息设置
							</h5>
						</div>
						<div id="subject_info_panel">
							<table class="cl-info" id="org_dt">
								<tr class="odd data-title">
								<td style="width:20px;"></td>
							    <td>考试科目</td>
							    <td>考试形式</td>
							    <td>考试对象</td>
							    <td>承办方</td>
						  		</tr>
							</table>
							<ul class="cl-opr">
							  <li> <button style="display:block" onclick="showOrzPanel()" >增加承办方信息</button> </li>
							  <%--<li> <button style="display:block" >删除承办方信息</button> </li>--%>
							</ul>
							<div style="clear:both"></div>
						</div>
						<br>
						<button class="op-button" onclick="putContestInfoToServer()">
							<i class="iconfont font">&#xf0024</i>提交
						</button>
						<div style="clear: both"></div>
					</div>
					<div style="clear: both"></div>
				</div>
				<div style="clear: both"></div>
				<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
			</div>
			
			<!-- ------------------------------弹窗样式------------------------------  -->
			<div id="contestPanel" class="bodymiddle" style="display: none;">
		    <div class="middleFrame">
		        <div class="middleClose" onclick="middleClose()"><i class="iconfont">&#xf00b3;</i></div>
		        <div class="Frameinformation">
			        <div class="Frameinput">
			        <select class="Verificationselect" id="nsf_ContestSubject">
		                	<option selected="true" disabled="true">请选择考试科目</option>
		                </select>
		                <table id="grade1" class="grade-style">
		                <tr><td><input type="checkbox" value="1" />小学一年级</td>              
		                	<td><input type="checkbox" value="2" />小学二年级</td>
		                </tr>
		                <tr>
		                	<td><input type="checkbox" value="3"/>小学三年级</td>
		                	<td><input type="checkbox" value="4"/>小学四年级</td>
		                </tr>
		                <tr>
		                	<td><input type="checkbox" value="5"/>小学五年级</td>
		                	<td><input type="checkbox" value="6"/>小学六年级</td>
		                </tr>
		                <tr><td></td><td></td><td><span style="font-size:13px;" onclick="checkAll(this)">全选<span/></td></tr>
		                </table>	
		                
		                <hr>
		                <table id="grade2" class="grade-style">
		               <tr><td> <input type="checkbox" value="7"/>初中一年级</td> 
		               <td> <input type="checkbox" value="8"/>初中二年级</td></tr>
		                <tr><td><input type="checkbox" value="9"/>初中三年级</td>
		                <td></td></tr>
		                <tr><td></td><td></td><td><span style="font-size:13px;" onclick="checkAll(this)">全选<span/></td></tr>
		                 </table>
		                <hr>
		                <table id="grade3" class="grade-style">
		                <tr><td><input type="checkbox" value="10"/>高中一年级</td> 
		                <td><input type="checkbox" value="11"/>高中二年级</td></tr>
		                <tr><td><input type="checkbox" value="12"/>高中三年级</td>
		                <td></td></tr>
		                <tr><td></td><td></td><td><span style="font-size:13px;" onclick="checkAll(this)">全选<span/></td></tr>
		                </table>	
		                
		                <select class="Verificationselect" id="nsf_ContestexamType">
		                	<option selected="true" disabled="true">请选择考试形式</option>
		                    <option>笔试</option>
		                    <option>上机</option>
		                    <option>口试</option>
		                </select>
		                <input type="text" placeholder="报名费用" class="Phonetext" id="nsf_SignUpMoney" />
			        </div>
			        </div>
			        <button class="Phonetext" onclick="MakeUpContestInfo()">确认</button>
		        </div>
		    </div>
	    <!-- ------------------------------弹窗样式------------------------------  -->
	    
	    <!-- ------------------------------弹窗样式二------------------------------  -->
	    <div id="organizePanel" class="bodymiddle" style="display: none;" >
		    <div class="middleFrame">
		        <div class="middleClose" onclick="middleClose()"><i class="iconfont">&#xf00b3;</i></div>
		        <div class="Frameinformation">
					<select class="Verificationselect" id="nsf_ComepetitionOrg" >
		                	<option selected="true" disabled="true" onclick="">请选择大赛承办方</option>
		                </select>
			        </div>
			        <button class="Phonetext" onclick="AppendOrginazInfo()">确认</button>
		        </div>
		    </div>
		    <!-- ------------------------------弹窗样式------------------------------  -->
		</body>
	</html>
