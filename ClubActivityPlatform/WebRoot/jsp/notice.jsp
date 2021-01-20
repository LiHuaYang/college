<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int mynoticeId=Integer.parseInt(request.getParameter("mynoticeId"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'notice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/notice.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
     <link href="uploadify/uploadify.css" rel="stylesheet" type="text/css" />
     <script src="uploadify/jquery.uploadify.js" type="text/javascript"></script>
       <script type="text/javascript">
    	var mynoticeId=<%=mynoticeId%>;
        $(function () {
            $("#uploadify").uploadify({
                //指定swf文件
                'swf': 'uploadify/uploadify.swf',
                //后台处理的页面
                'uploader': '../UpLoadCommentServlet',
       
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
                      $(".committext").append('<div class="np" contenteditable="false" style="background-image:url('+json.result+');display:inline-block;"></div>');
                    }
            });
        });
    
    </script>
  </head>
  
  <body id="k">
  	<div class="heads"></div>
  	<div style="height: 200px;"></div>
	<div class="notice">
		<div class="noticebelong">
			<div class="noticebelong-pic"></div>
			<div class="noticebelong-right">
				<div class="noticebelong-name">asd</div>
			</div>
			
		</div>
		<div class="page"></div>
		<div class="notice-list">
			<div class="notice-list-left">
				<div class="notice-title">
				</div>
				<div class="notice-more"></div>
				<div class="comment">
					
				</div>
			</div>
			<div class="notice-list-right">
				<div>公告列表</div>
			</div>
		</div>
		<div class="page1"><font>下一页</font><span></span><font>上一页</font></div>
		<div class="commentout">
			<div class="commentout-out"><i class="iconfont" style="font-size: 20px;color: #ffa854">&#xf0201;</i> 发表回复</div>
			<div class="comment-in">
				<div class="up">
					    		<input type="file" name="uploadify" id="uploadify" />
					<div class="outs" onclick="commitcomment()">发表</div>
    
				<p contenteditable="true"  class="committext" ></p>
			
			</div>
		</div>
	</div>
	
  </body>
</html>
