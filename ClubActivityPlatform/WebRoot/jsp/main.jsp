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
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/datedropper.css" rel="stylesheet" type="text/css" />
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/main.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
 	<script type="text/javascript">
 		var myuserid=<%=myuserid%>
 		
 	</script>
    <script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/common/datedropper.js"></script>
	
  </head>
  
  <body id="k">
   <div class="barhead">
   		<div class="barheadlog"><i class="iconfont" id="log">&#xf029d;</i>   <font >Activity Platform</font></div>
   		<div class="barhead-right"><div onclick="toactivity()">活动</div><div onclick="tonotice()">公告</div><div onclick="toyouth()">团委</div><div>学生会</div><div>社联</div><div onclick="tocorporation()">社团</div><div class="barusername" onclick="login()">登录</div></div>
   	</div>
   <div class="mainall">
  	<div id="hotactivity" >
  		<div class="hotactivityblack">
  			<div class="hotactivityblackpoint"><div id="whitepointer" onclick="changepointer(this,0)"></div ><div onclick="changepointer(this,1)"></div><div onclick="changepointer(this,2)"></div><div onclick="changepointer(this,3)"></div><div onclick="changepointer(this,4)"></div></div>
  			<div class="hotactivitysearch">
  				<div class="hotactivitysearch-center">
  				<input placeholder="想参加的活动？" class="activiysearchname" type="text"/>
  				<input placeholder="活动时间"  class="activiysearchtime" type="text"/>
  				<input placeholder="活动地点"  class="activiysearchaddress" type="text"/>
  				<div class="hotactivitysearch-in" onclick="tosearchactivity()">搜索</div>
  				</div>
  			</div>
  			<div class="hotactivityblackgo" onclick="hotactivityblackhide()"><i class='iconfont'>&#xf02a9;</i></div>
  			<div class="hotactivityblackmain">
  				<div class="hotactivitytitle"></div>
  				<div class="hotactivitydetail"><font>了解更多  >></font></div>
  				<div class="hotactivitycontent"></div>
  				<div class="hotactivitystarttime">活动开始时间：<font></font></div>
  			</div>
  		</div>
  	</div>
  </div>
  <div class="hotvideo">
  	<div class="hotvideo-row">
  		<div class="videopic"><i class="iconfont" id="playvideo" onclick="playvideo()">&#xf01cb;</i></div>
		
  	</div>
  </div>
  <div class="hotcur">
  	<div class="panel1">
			<div class="seacherworld">热门社团</div>
			<div class="seacherworldtext">在这里，本年度最受欢迎的社团</div>
		</div>
  	<div class="panel2" >
		<div class="panel2-line1">
			<div class="panel2-line1-block1">
				<div class="panel-title" style="width: 655px;">吉他社</div>
				<div class="panel-block">
					<div class="panel-block-title">吉他社</div>
					<div class="panel-block-more">吉他是深受我们青年朋友喜爱的乐器，在校园里更是同学们的宠儿。协会在通过吉他等各种乐器的教学与交流，丰富同学们的课余生活，达到共同学习、共同提高吉他技巧，陶治同学们的艺术情操，增进同学们的友谊,为有音乐才华的同学展现自我提供一个平台为目的。一直以来，凭借丰富多彩的活动以及高质量的服务受到广大师生的好评与喜爱。</div>
				</div>
			</div>
			<div class="panel2-line1-block2" >
				<div class="panel-title" style="width: 314px;">吉他社</div>
					<div class="panel-block">
					<div class="panel-block-title">吉他社</div>
					<div class="panel-block-more">吉他是深受我们青年朋友喜爱的乐器，在校园里更是同学们的宠儿。协会在通过吉他等各种乐器的教学与交流，丰富同学们的课余生活，达到共同学习、共同提高吉他技巧，陶治同学们的艺术情操，增进同学们的友谊,为有音乐才华的同学展现自我提供一个平台为目的。一直以来，凭借丰富多彩的活动以及高质量的服务受到广大师生的好评与喜爱。</div>
					
					</div>
			</div>
		</div>
		<div class="panel2-line2">
			<div class="panel2-line2-block1"><div class="panel-title" style="width: 314px;">吉他社</div><div class="panel-block"><div class="panel-block-title"></div><div class="panel-block-more"></div></div></div>
			<div class="panel2-line2-block2"><div class="panel-title" style="width: 314px;">吉他社</div><div class="panel-block"><div class="panel-block-title"></div><div class="panel-block-more"></div></div></div>
			<div class="panel2-line2-block3"><div class="panel-title" style="width: 314px;">吉他社</div><div class="panel-block"><div class="panel-block-title"></div><div class="panel-block-more"></div></div></div>
		</div>
		<div class="panel2-line3">
			<div class="panel2-line3-block1">
				<div class="panel-title" style="width: 314px;">吉他社</div>
				<div class="panel-block"><div class="panel-block-title"></div><div class="panel-block-more"></div></div>
			</div>
			<div class="panel2-line3-block2">
				<div class="panel-title" style="width: 655px;">吉他社</div>
				<div class="panel-block"><div class="panel-block-title"></div><div class="panel-block-more"></div></div>
			</div>
		</div>
	
		</div>
  </div>
  <div class="hotbullten">
  		<div class="panel1">
			<div class="seacherworld">热门公告</div>
			<div class="seacherworldtext">在这里，展示最受关注的公告</div>
			<div class="hotbullten-type">
				<div  class="hotbullten-federation"style="margin-left: 0px;"><div class="hotbullten-pic"></div><div class="hotbullten-title">社团联合会</div><div class="bu-mm"></div></div>
				<div  class="hotbullten-studentunion"><div class="hotbullten-pic"></div><div class="hotbullten-title">学生会</div><div class="bu-mm"></div></div>
				<div  class="hotbullten-youth"><div class="hotbullten-pic"></div><div class="hotbullten-title">团委</div><div class="bu-mm"></div></div>
				<div  class="hotbullten-cor"><div class="hotbullten-pic"></div><div class="hotbullten-title">各个社团</div><div class="bu-mm"></div></div>
			</div>
		</div>
  </div>
  <div class="mainend">
 	 <div class="mainend-row">
  		<div class="say1">鸟儿因翅膀而自由翱翔，</div>
 	 	<div class="say2">鲜花因芬芳而美丽，</div>
 	 	<div class="say3">校园因文明而将更加进步。</div>
 	 	<div class="bordershow"></div>
 	 	<div class="dm501"><i class="iconfont" id="write">&#xf00f5;</i>dm501</div>
  	</div>
  </div>
  	<div class="shadow">
  		<div style="width: 100%; height: 30px;padding-top:30px; "><i class="iconfont" id="closevideo" onclick="closevideo()">&#xf00b3;</i></div>
  		<video id="vi" src="img/md.mp4" onclick="offvideo()">
		您的浏览器不支持 video 标签。
		</video>
		<i class="iconfont" id="govideo" onclick="govideo()">&#xf01cb;</i>
  	</div>
</body>
</html>
