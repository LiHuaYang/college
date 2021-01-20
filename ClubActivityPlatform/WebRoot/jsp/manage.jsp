<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int mygrade=0;
int mybelongId=0;
int mybelongType=0;
try{
mygrade=Integer.parseInt(request.getParameter("mygrade").toString());
mybelongId=Integer.parseInt(request.getParameter("mybelongId").toString());
mybelongType=Integer.parseInt(request.getParameter("mybelongType").toString());
}catch(Exception e){
e.printStackTrace();
mygrade=0;
mybelongId=0;
mybelongType=0;
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/manage.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
 		<script type="text/javascript">
 		var mygrade=<%=mygrade%>
 		var mybelongId=<%=mybelongId%>
		var mybelongType=<%=mybelongType%>
 	</script>
    <script type="text/javascript" src="js/manage.js"></script>
      <link href="uploadify/uploadify.css" rel="stylesheet" type="text/css" />
     <script src="uploadify/jquery.uploadify.js" type="text/javascript"></script>
    		<script type="text/javascript">
 		 $(function () {
             $("#loadify").uploadify({
                //指定swf文件
                'swf': 'uploadify/uploadify.swf',
                //后台处理的页面
                'uploader': '../UploadUserPicServlet',
       
                //按钮显示的文字
                'buttonText': '上传图片',
                //显示的高度和宽度，默认 height 30；width 120
                //'height': 15,
                //'width': 80,
                //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
                //在浏览窗口底部的文件类型下拉菜单中显示的文本
                'fileTypeDesc': 'Image Files',
                //允许上传的文件后缀
                'fileTypeExts': '*.gif; *.jpg; *.png',
                //发送给后台的其他参数通过formData指定
                //'formData': { 'someKey': 'someValue', 'someOtherKey': 1 },
                //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
                //'queueID': 'fileQueue',
                //选择文件后自动上传
                'auto': true,
                //设置为true将允许多文件上传
                'multi': false,
                'onUploadSuccess' : function(file, data, response) {
					json=$.parseJSON(data);
					
                      $(".gradeimg").css("background-image","url("+json.result+")");   
                      $(".gradeimg").attr("img",json.result)                 
                      }
            });
             $("#loadify1").uploadify({
                //指定swf文件
                'swf': 'uploadify/uploadify.swf',
                //后台处理的页面
                'uploader': '../UploadUserPicServlet',
       
                //按钮显示的文字
                'buttonText': '上传图片',
                //显示的高度和宽度，默认 height 30；width 120
                //'height': 15,
                //'width': 80,
                //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
                //在浏览窗口底部的文件类型下拉菜单中显示的文本
                'fileTypeDesc': 'Image Files',
                //允许上传的文件后缀
                'fileTypeExts': '*.gif; *.jpg; *.png',
                //发送给后台的其他参数通过formData指定
                //'formData': { 'someKey': 'someValue', 'someOtherKey': 1 },
                //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
                //'queueID': 'fileQueue',
                //选择文件后自动上传
                'auto': true,
                //设置为true将允许多文件上传
                'multi': false,
                'onUploadSuccess' : function(file, data, response) {
					json=$.parseJSON(data);
					
                      $(".noticeimg").css("background-image","url("+json.result+")");   
                      $(".noticeimg").attr("img",json.result)                 
                      }
            });

            });
             
 	</script>
  </head>
  
  <body>
   	<div class="heads"></div>
   	<div class="basic">
   	<div class="basic-row">
   		<div class="basic-title">
   			基本资料<font class="changebasic" onclick="changebasic()">  修改 <i class="iconfont"  style="color: #f58220">&#xf0022;</i></font>
   		</div>
   		<div class="basic-more">
   			<div class="basic-pic"></div>
   			<div class="basic-con">
   				<div class="basic-name">办公室</div>
   				<div class="basic-content">拉喀什东路交口杀菌的挥洒空间</div>
   			</div>
   		</div>
   	</div>
   	</div>
   	<div class="activity-manage">
   	<div class="activity-manage-row">
   		<div class="activity-manage-title">
   			活动管理
   			<font class="changebasic" onclick="createactivity()">新建活动 <i class="iconfont"  style="color: #f58220">&#xf02b4;</i></font>
   		</div>
   		<div class="activity-list">
   			
   		</div>
   	</div>
   	</div>
   	<div class="notice-manage">
   		<div class="people-manage-row">
   		<div class="activity-manage-title">
   			公告管理
   			<font class="changebasic" onclick="createnotice()">新建公告 <i class="iconfont"  style="color: #f58220">&#xf02b4;</i></font>
   			
   		</div>
   		<div class="notice-list">
   		
   		</div>
   		</div>
   	</div>
   	<div class="people-manage">
   		<div class="people-manage-row">
   		<div class="activity-manage-title">
   			人员管理
   			<font class="changebasic" onclick="showapply()">查看申请列表 <i class="iconfont"  style="color: #f58220">&#xf02a4;</i></font>
   		</div>
   		<div class="member-list">
   		
   		</div>
   		</div>
   	</div>
   	
   	<div class="infoblack" style="display: none;">
   		<div class="ci">
   		<div style="width: 100%;height: 20px;text-align: center;border-bottom:1px solid rgb(200,200,200)">修改基本资料</div>
   				<div class="usergradeimg" style="height: 100px;width:100%;padding-top: 10px;"><div class="gradeimg"><div class="sqlit"><input type="file" name="loadify" id="loadify" /></div></div></div>
   				<div class="grade-content" contenteditable="true"></div>
   				<div class="godsz"><button onclick="commitchange()" class="mmza">提交</button><button onclick="closeg()">取消</button></div>
   		</div>
   	</div>
   	<div class="acblack" style="display: none;">
   		<div class="ac">
   		  		<div style="width: 100%;height: 20px;text-align: center;border-bottom:1px solid rgb(200,200,200)">活动意向</div>
   				<div style="font-size: 12px;text-align: center;">选择活动策划人</div>
   				<select id="p"></select>
   				<div style="font-size: 12px;text-align: center;">选择任务方案制定人</div>
   				<select id="p2"></select>
   				<div class="m-content" contenteditable="true">输入活动意向</div>
   				<div class="godsz"><button onclick="createactivityok()" class="mmza">提交</button><button onclick="closeg()">取消</button></div>
   		</div>
   	</div>
   	<div class="noblack" style="display: none;">
   		<div class="no">
	   		<div style="width: 100%;height: 20px;text-align: center;border-bottom:1px solid rgb(200,200,200)">创建公告</div>
   			<div class="usernoticeimg" style="height: 100px;width:100%;padding-top: 10px;"><div class="noticeimg"><div class="sqlit1"><input type="file" name="loadify1" id="loadify1" /></div></div></div>
   			<input type="text" placeholder="公告标题" id="noticetitlein"/>
   			<div class="n-content" contenteditable="true">输入内容</div>
   			<div class="godsz"><button onclick="createnoticeok()" class="mmza">提交</button><button onclick="closeg()">取消</button></div>
   			
   		</div>
   	</div>
   	<div class="apblack" style="display: none;">
   			<div class="ap">
   			   		<div style="width: 100%;height: 20px;text-align: center;border-bottom:1px solid rgb(200,200,200)">申请列表</div>
   			   		<div class="aplist">
   			   			   			   				
   			   		</div>
   			   		<div class="godsz"><button onclick="closeg()">取消</button></div>
   			
   			</div>
   	</div>
  </body>
</html>
