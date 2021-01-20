<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'friend.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/common/friend.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
    <script type="text/javascript" src="js/common/friend.js"></script>
     <script type="text/javascript" src="js/common/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
     <script type="text/javascript">
            $(function () {
                $(".chats").draggable({containment:"body",cancel:".chats-more"});
            });
        </script>
  </head>
  
  <body>
  		<div class="rightf" onclick="rightf()"><i class="iconfont" id="c" style="font-size: 30px;">&#xf016e;</i></div>
   		<div class="friendlist">

   				 
   			<div class="f-bar">
   			<div class="f-bar-m" onclick="showflist(this)" style="border-right: 1px dashed rgb(200,200,200)"><i class="iconfont" style="font-size: 26px;margin:10px;color:#fcd947">&#xf014b;</i></div>
   			<div class="f-bar-m" onclick="showslist(this)" style="border-right: 1px dashed rgb(200,200,200)"><i class="iconfont" style="font-size: 26px;margin:10px;color:#fb5721">&#xf014c;</i></div>
   			<div class="f-bar-m" onclick="showclist(this)" style=""><i class="iconfont" style="font-size: 26px;margin:10px;color:#51210d">&#xf0141;</i></div>
   			</div>
   			<div class="searchfriend"><input class="searchf"  placeholder="想搜索的用户名" type="text"/><i class="iconfont" style="float:right;font-size: 20px;color:white;padding: 4px;cursor: pointer;" onclick="searchuser()">&#xf012c;</i></div>

			<div class="f-list">

			</div>
			<div class="s-list" style="display: none;"></div>
			<div class="c-list" style="display:none">
				
			</div>
		</div>
		<div class="chats" style="display: none;">
			<div class="chats-headle">
				<i class="iconfont" style="font-size: 20px;margin:4px;color:white;float:left;">&#xf0133;</i>
				<div style="text-align: center;padding-top: 5px;color: white;width: 540px;float: left;">与<font class="ppps"></font>的聊天</div>
				<i class="iconfont" style="font-size: 20px;margin:4px;color:white;float: right;cursor: pointer;" onclick="closechats()">&#xf0155;</i>
			</div>
			<div class="chats-more">
				<div class="chats-more-left">
					<div id="chat-show">
					<div class="chat-show">
					</div>
					</div>
					<div class="chat-send">
						<div class="chat-send-text"  contenteditable="true">

						</div>
						<div class="chat-bu"><div class="x" onclick="closechats()">关闭</div><div class="x" onclick="sentchats()">发送</div></div>
					</div>
				</div>
				<div class="chats-more-right">
					<div class="chats-people">
						<div class="chats-people-pic">
							<div style="height: 25px;width: 100%;overflow: hidden;">
								<div class="chats-people-name">小黑</div>
							</div>
						</div>
					</div>
				
				</div>
			</div>
		</div>
  </body>
</html>
