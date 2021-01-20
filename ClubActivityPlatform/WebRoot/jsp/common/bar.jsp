<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int myuserid=0;
try{
myuserid=Integer.parseInt(session.getAttribute("UserId").toString());
}catch(Exception e){
e.printStackTrace();
myuserid=0;
}
 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/common/bar.css">
	<link rel="stylesheet" href="css/common/friend.css" type="text/css"></link>
		<script type="text/javascript">
 		var myuserid=<%=myuserid%>
 		
 	</script>
 	<script type="text/javascript" src="js/common/bar.js"></script>
     <script type="text/javascript" src="js/common/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
     <script type="text/javascript">
            $(function () {
                $(".chats").draggable({containment:"window",cancel:".chats-more"});
            });
        </script>
  </head>
  
  <body>
   	<div class="barall">
   		<div class="barspan">
   			<div class="bartitle"><i class="iconfont" id="log">&#xf029d;</i>    团学社社团活动管理平台</div>
   			<div class="barmain" onclick="tomain()">主界面</div>
   			<div class="baractivity" onclick="toactivity()">活动</div>
   			
   			<div class="barbulltin" onclick="tonotice()">公告</div>
   				<div class="barorganize"><div style="height: 38px;width: 100%;text-align: center;">组织</div>
   				<div class="barorganizelow"">
   					<div onclick="toyouth()">团委</div>
   					<div>学生会</div>
   					<div>社团联合会</div>
   					
   				</div>
   				</div>
   			<div class="barcor" onclick="tocorporation()">社团</div>
   			<span style="float:right;" class="px"><div class="baruserpic"></div><div class="barusername" onclick="tologin()">登录</div></span>
   		</div>
   	</div>
   	
   	
   
  </body>
  	<!--好友	-->
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
</html>
