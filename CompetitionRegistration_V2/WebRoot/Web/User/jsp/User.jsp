<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'User.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="Web/User/css/User.css"></link>
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
    
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="Common/Tool/uploadify/uploadify.css" type="text/css" ></link>
    <script src="Common/Tool/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
    
 	<script type="text/javascript" src="Web/User/js/User.js"></script>
   <script type="text/javascript">
   
   
	   
   
   </script>	
  </head>
  
  <body>
    <jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
    <div class="all">
       <div class="na_left">
    	  <div class="navi_left">
    		<div class="my_message" onclick="Show_message()">我的信息</div>
    		<div class="my_save" onclick="Show_Save()">我的收藏</div>
    		<div class="my_competition" onclick="Show_Com()">我的成绩</div>
    		<div class="enroll_competition" onclick="Show_Enroll_Com()">已报名比赛</div>
    	  </div>
       </div>
    	<div class="message">
    		<div class="mess_first">
    			<div class="mess_first_left">
    				<div class="my_name_box">
    					<div class="my_name">昵称：</div>
    					<input type="text" id="my_name_input" />
    				</div>
    				<div class="my_sex_box">
    					<div class="my_sex">性别：</div>
    					<input type="text" id="my_sex_input" />
    				</div>
    				<div class="my_phone_box">
    					<div class="my_phone">联系号码：</div>
    					<input type="text" id="my_phone_input" />
    				</div>
    				<div class="my_learn_box">
		   				<div class="my_learn">学习阶段：</div>
		   					<select id="my_learn_input"  >
		   					    <option> </option>
		   					    <option>小学一年级</option>
		   					    <option>小学二年级</option>
		   					    <option>小学三年级</option>
		   					    <option>小学四年级</option>
		   					    <option>小学五年级</option>
		   					    <option>小学六年级</option>
		   					    <option>初中一年级</option>
		   					    <option>初中二年级</option>
		   					    <option>初中三年级</option>
		   					    <option>高中一年级</option>
		   					    <option>高中二年级</option>
		   					    <option>高中三年级</option>
		   					</select>
   					</div>
		   			<div class="my_address_box">
		   				<div class="my_address">用户地址：</div>
		   				<input type="text" id="my_address_input" />
		   			</div>
		   			<div class="mess_final">
			   			<!-- <div class="change_address">管理用户地址?</div> -->
			   			<div class="change_pass" onclick="showChangePassword()">修改密码？</div>
		   			</div>
		   			
    			</div>
    			<div class="mess_first_right">
    			    <div class="mess_first_right_box">
	    				<div class="my_pic" >
	    				</div>
	    				<div class="change_picture" >
	    				<%--用来作为文件队列区域--%>
				       		 <div id="fileQueue"></div>
				       		 <input type="file" name="uploadify" id="uploadify" />
	        			</div>
        			</div>
    			</div>
    			<div class="sure_save">
   					<button class="save_butt" onclick="ChangeUserInfo()">确认保存</button>
   				</div>
    		</div>
    	</div>
    	
    	
    	<!-- 我的收藏 -->
    	<div class="save" style="display: none;">
    		<div class="com_first">
    			<div class="mynavi_name">我的收藏</div>
    			<div class="mynavi_time">收藏时间</div>
    		</div>
    		<div class="none_save" style="display: none;">你还没有任何收藏哦</div>
    		<div class="text_paper_box">
    			
    		</div>
    		<!--  
    		<div class="paper_page">
				<div class="paper_num">1</div>
				<div class="paper_num">2</div>
				<div class="paper_num">3</div>
				<div class="paper_num">4</div>
				<div class="paper_num2">></div>
			</div>
			-->
    	</div>
    	
    	<!-- 我的比赛 -->
    	<div class="com" style="display: none;">
    		<div class="com_first">
    			<div class="navi_name">比赛名称</div>
    			<div class="navi_sub">比赛类别</div>
    			<div class="navi_obj">比赛等级</div>
    			<div class="navi_grade">分数</div>
    		</div>
    		<div class="none_com" style="display: none;">你还没有参加过任何比赛哦</div>
    		<div class="com_big_box">
    			
    		</div>
    		<!-- 
    		<div class="com_page">
				<div class="com_num">1</div>
				<div class="com_num">2</div>
				<div class="com_num">3</div>
				<div class="com_num">4</div>
				<div class="com_num2">></div>
			</div>
			-->
    	</div>
    	
    	<!-- 已报名比赛-->
    	<div class="enroll_com" style="display: none;">
    		<div class="enroll_com_first">
    			<div class="enroll_navi_name">比赛名称</div>
    			<div class="enroll_navi_sub">比赛类别</div>
    			<div class="enroll_navi_obj">比赛等级</div>
    			<div class="enroll_navi_time">开始时间</div>
    		</div>
    		<div class="none_enroll_com" style="display: none;">你还没有报名任何比赛哦</div>
    		<div class="enroll_com_box">
    			
    		</div>
    		<!-- 
    		<div class="enroll_com_page">
				<div class="enroll_com_num">1</div>
				<div class="enroll_com_num">2</div>
				<div class="enroll_com_num">3</div>
				<div class="enroll_com_num">4</div>
				<div class="enroll_com_num2">></div>
			</div>
			-->
    	</div>
    	
    	
    	 <!-- 修改密码框-->
	    <div class="bodymiddleLogin" style="display: none;">
	        <div class="middleFrameLogin">
	            <div class="middleClose" onclick="middleLoginClose()"><i class="iconfont">&#xf00b3;</i></div>
	            <div class="FrameinformationLogin">
	                <div class="Frameinput">
	                    <div class="inputAccount">
			                <input type="text" placeholder="旧密码" id="OldPassword" class="Accounttext">
			            </div>
			            <div class="inputLoginPassword">
			                <input type="password" placeholder="新密码" id="NewPassword" class="LoginPasswordtext">
			            </div>
			             <div class="inputLoginPassword">
			                <input type="password" placeholder="确认新密码" id="NewCopyPassword" class="LoginPasswordtext">
			            </div>
	                </div>
	                <div class="Frameclick">
			              <div class="clickButton">
			                  <button class="ButtonRigest" onclick="ChangePassword()">修改</button>
			              </div>
			              
			        </div>
	            </div>
	        </div>
	    </div>
    
    
    </div>
        <jsp:include page="../../Common/jsp/End.jsp" flush="true" />
  </body>

</html>
