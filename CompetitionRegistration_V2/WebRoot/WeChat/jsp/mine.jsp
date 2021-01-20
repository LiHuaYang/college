<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int baruserid=0;
try{
    baruserid=(Integer)request.getSession().getAttribute("Userid");
}catch(Exception e){
    e.printStackTrace();
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>个人首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="WeChat/css/mine.css" type="text/css" >
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	
	<link rel="stylesheet" href="Common/iconfont/iconfont.css" type="text/css"></link>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="WeChat/js/mine.js"></script>
	<script type="text/javascript">
	 var baruserid=<%=baruserid%>;
	</script>
  </head>
  
  <body>
  <div class="mineall">
  	<div class="menu">
			<div class="user-pic">
			   <img alt=""  id="imgWeChat" src="WeChat/image/tx1.png">
			</div>
			<div class="log">
			   <button class="box1" onclick="turntologin()">登录</button>
			   <button class="box2" onclick="turntoregister()">注册</button>
			</div> 
    </div>
    
    <div class="my">
  		<div class="my-con" onclick="turntoMyCollection(baruserid);">
  		<%--我的收藏--%>
  		<div class="my-pic1">
  		<i class="iconfont font" style="color:#0075c4; font-size:2.8em;">&#xf0144</i>
  		</div>
  		     <div class="my-text">
  		         <button class="box4" >我的收藏</button>
  		    </div>
  		</div>
  		<div class="my-con">
  		    <div class="my-pic2"  onclick="goenroll_com()">
  		    	<i class="iconfont font" style="color:#0075c4; font-size:2.8em;">&#xf017d</i> 
  		    </div>
  		     <div class="my-text">
  		         <button class="box4">已报名比赛</button>
  		    </div>
  		</div>
  		
  		<div class="my-con" onclick="gotosearch();">
  		      
  		      <div class="my-pic3">
  		       <i class="iconfont font" style="color:#0075c4; font-size:2.8em;">&#xf00b0</i> 
  		      </div>
  		      
  		      
  		     <div class="my-text">
  		         <button class="box4">我的成绩</button>
  		    </div>
  		</div>
  		 
    </div>
      <div class="next">
			<%--<div id="in">
				<div class="in-info">
					设置
				</div>
	         	<i class="iconfont font" id="size">&#xf016d</i>
			</div>--%>
 			<div id="in" onclick="gotoQRcode()">
				<div class="in-info">
					扫描二维码
				</div>
				<%--<i class="iconfont font" id="size">&#xf016d</i>
			--%></div>
			<!--<div id="in"  onclick="gotoFeddback()">
				<div class="in-info">
					意见反馈
				</div>
				<i class="iconfont font" id="size">&#xf016d</i>
			</div>
			--><div id="in" onclick="ChangemineInfo()">
				<div class="in-info">
					修改资料
				</div>
				<%--<i class="iconfont font" id="size">&#xf016d</i>
			--%></div>
			<div id="in">
				<div class="in-info" onclick="gotohelp()">
					报名使用帮助
				</div>
				<%--<i class="iconfont font" id="size">&#xf016d</i>
			--%></div>
			<div class="exit" style="display: none;">
      			<div class="exit_butt" onclick="Exit()">退出登录</div>
      		</div>
		</div>
		<div style="width: 100%;height: 2em;"></div>
	</div>
	
       <jsp:include page="../Common/bottom.jsp" flush="true" />
  </body>
</html>
