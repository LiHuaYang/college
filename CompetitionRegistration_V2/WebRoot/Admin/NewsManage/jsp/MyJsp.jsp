<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	        $(function () {
	            $("#uploadify").uploadify({
	                //指定swf文件
	                'swf': 'uploadify/uploadify.swf',
	                //后台处理的页面
	                'uploader': '/upload',
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
	                'auto': false,
	                //设置为true将允许多文件上传
	                'multi': true,
	                 //上传成功后执行
	                'onUploadSuccess': function (file, data, response) {
	                    $('#' + file.id).find('.data').html(' 上传完毕');
	                    }
	            });
	        });
	   </script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
