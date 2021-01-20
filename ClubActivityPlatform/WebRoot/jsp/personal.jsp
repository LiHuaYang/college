<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int myuserid1=0;
try{
myuserid1=Integer.parseInt(session.getAttribute("UserId").toString());
}catch(Exception e){
e.printStackTrace();
myuserid1=0;
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/personal.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
    <script type="text/javascript" src="js/personal.js"></script>
       <link href="uploadify/uploadify.css" rel="stylesheet" type="text/css" />
     <script src="uploadify/jquery.uploadify.js" type="text/javascript"></script>
    		<script type="text/javascript">
 		var myuserid1=<%=myuserid1%>
 		 $(function () {
            $("#uploadify").uploadify({
                //指定swf文件
                'swf': 'uploadify/uploadify.swf',
                //后台处理的页面
                'uploader': '../UploadGradePicServlet',
       
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
					
                      $(".img").css("background-image","url("+json.result+")");   
                      $(".img").attr("img",json.result)                 
                      }
            });
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
        });
    
 	</script>
  </head>
  
  <body id="k">
   		<div class="ppic">
   			<div class="heads"></div>
   			<div class="ppic-b">
   				<div class="ppic-row">
   					<div class="bac">
   						<div class="bac-rad">
   						<div class="bac-pic"></div>
   						</div>
   					</div>
   					<div class="ppb">
   						<div style="margin-left: 20px;" onclick="showuserinfo(this)">我的信息</div>
   						<div  onclick="showuserpart(this)">我的家庭</div>
   						<div onclick="showuseractivity(this)" >我的活动</div>
   						<div  onclick="showplan(this)">我的方案</div>
   						<div  onclick="showmymission(this)">我的任务</div>
   						<div  onclick="showmessage(this)">我的消息</div>
   						
   					</div>
   				</div>
   			</div>
   		</div>
   		<div class="personmore">
   				<div class="personmore-row">
   					<div class="personinfos" style="display: none;">
   						<div class="myname"></div>
   						<div class="mysex"></div>
   						<div class="mymajor"></div>
   						<div class="myphone"></div>
   						<div class="myroll"></div>
   						<div class="myaddress"></div>
   						<div class="myemail"></div>
   						<div class="mycontent"></div>
   						<button class="changeuser" onclick="changeuserinfo()">修改信息</button>
   					</div>
   					<div class="mypart" style="display: none;">
   						<div class="part1">
   							<div class="parttitle">我加入了</div>
   							<div class="partlist">
   								
   							
   							</div>
   						</div>
   						
   					</div>
   					<div class="mytask"  style="display: none;">
   					
   							<div style="text-align: right; border-bottom: 1px solid rgb(200,200,200);padding-top:10px;">共有<font id="numbh">2</font>条任务</div>
   							<div class="tasklist" style="height: 440px;width: 100%;">	
   							</div>
   							<div class="notice-row-left-page">
    						<div class="prev" style="float: left;"onclick="prevpage()">prev</div>
    						<div class="pagecount" style="display: inline-block;width: 90px;text-align: center;padding-top: 10px;"></div>
    						<div class="next" style="float: right;"onclick="nextpage()">next</div>
    						</div>
   					</div>
   					<div class="mymessage" style="display: none;">
   						<div class="messagelist">
   							<div class="message-one"><i class="iconfont" >&#xf0138;</i><font>恭喜你成为XXX社团一员！</font><font style="float:right">2015-12-19 10:20</font></div>
   						</div>
   						<div class="messagepage">
   							<div class="prev" style="float: left;"onclick="prevmessagepage()">prev</div>
    						<div class="messagepagecount" style="display: inline-block;width: 90px;text-align: center;padding-top: 10px;"></div>
    						<div class="next" style="float: right;"onclick="nextmessagepage()">next</div>
   						</div>
   					 </div>
   					<div class="myactivity"  style="display: none;">
   							<div class="parttitle">我参加的活动</div>
   							<div class="partactlist">
   								
   							</div>
   					</div>
   					<div class="myplan">
   						<div class="myplan-left">
   							<div class="createplan" onclick="openreb()"><div style="text-align:center;padding-top:18px;height:40px;width:58px;border-right: 3px solid white;float:left"><i class="iconfont" style="font-size:20px;">&#xf0175;</i></div><div style="float:left;height:40px;padding-top: 18px;text-align: center;width: 118px; ">创建任务方案</div></div>
   						</div>
   						<div class="myplan-right">
   							<div class="parttitle" >我的任务方案</div>
   							<div class="myplan-list">
   								
   							</div>	
   							
   						</div>
   					</div>
   				</div>
   		</div>
   		
   		
   		<div class="userblack" style="display: none;">
   			<div class="black-table">
   				<div class="black-table-title">用户修改</div>
   				<div class="userimg" style="height: 100px;width:100%;padding-top: 10px;"><div class="img"><div class="sqlit"><input type="file" name="uploadify" id="uploadify" /></div></div></div>
			<div class="tbs">
				<div class="myname0">姓名：<input /></div>
				<div class="mysex0">性别：<select ><option class="man" value ="0">男</option><option class="women" value ="1">女</option></select></div>
				<div class="mymajor0">专业：<input /></div>
				<div class="myphone0">电话：<input /></div>
				<div class="mypassword0">密码：<input /></div>
				<div class="myaddress0">地址：<input /></div>
				<div class="myemail0">邮箱：<input /></div>
				<div class="mycontent0">个性签名：</br><p class="con1" contenteditable="true"></p></div>
			</div>
				<button class="ok" onclick="userok()">确定</button>
				<button class="ok" onclick="resetbak()">取消</button>
			</div>
   		</div>
   		<div class="missionbac"  style="display: none;">
   			<div class="missionbac-table">
   				<div style="width: 100%;height: 20px;text-align: center;border-bottom:1px solid rgb(200,200,200)">任务总结</div>
   				<div class="task-content" >asdasds</div>
   				<div class="result-content" contenteditable="true"></div>
   				<div class="godsz"><button onclick="commitresult()" class="mmza">提交</button><button onclick="closeb()">取消</button></div>
   			</div>
   		</div>
   		<div class="gradebac" style="display: none;">
   		<div class="gradebic-table"  >
   				<div style="width: 100%;height: 20px;text-align: center;border-bottom:1px solid rgb(200,200,200)">修改职位信息</div>
   				<div class="usergradeimg" style="height: 100px;width:100%;padding-top: 10px;"><div class="gradeimg"><div class="sqlit"><input type="file" name="loadify" id="loadify" /></div></div></div>
   				<div class="grade-content" contenteditable="true"></div>
   				<div class="godsz"><button onclick="surechangegradeinfo()" class="mmza">提交</button><button onclick="closeg()">取消</button></div>
   			</div>
   		</div>
   		<div class="planbac" style="display: none;">
   			<i class="iconfont" id="clo" onclick="closeplanbac()">&#xf00b3;</i> 
   			<div class="planbac-table">
   				<div class="plan-tablename"contenteditable="true">任务方案名</div>
   				<div class="plan-content" contenteditable="true">内容请输这里</div>
   				<button class="fd">修改任务方案</button>
   				<div class="plan-tablemissionname">
   				<div style="width: 80px;float: left;">子任务列表 </div>
   				<div class="onc" style="width: 300px;float: right;text-align: right;">
   				<select class="partsel"></select>
   				
   				<button onclick="openmb()">添加子任务</button>
   				<button onclick="createmission()">提交</button>
   				</div>
   				
   				</div>
   				<div class="ms-list">
   					
   				</div>
   				
   				
   				<div class="createmissionb" style="display: none;">
   					<div class="cram">
   						<div class="mzm">子任务</div>
   						<div>选择人员：<select class="els"></select></div>
   						<div>是否要求任务结果：<select class="misresult"><option value="1">是</option><option value="0">否</option></select>
   						</div>
   						<div class="zxcd" contenteditable="true"></div>
   						<button onclick="createmb()">创建</button>
   						<button onclick="closemb()">取消</button>
   					</div>
   				</div>
   			</div>
   		</div>
   		<div class="createplanbac" style="display: none;">
   			<div class="createplanbac-table">
   				<div style="width: 100%;height: 23px;text-align: center;border-bottom: 1px solid rgb(200,200,200)">普通任务方案</div>
   				<input class="pname" placeholder="方案名称" />
   				<div class="pcontent" contenteditable="true">方案内容</div>
   				<div class="pbutton" onclick="createplan()">创建</div>
   				<div class="pbutton2" onclick="reb()">取消</div>
   			</div>
   		</div>
  </body>
</html>
