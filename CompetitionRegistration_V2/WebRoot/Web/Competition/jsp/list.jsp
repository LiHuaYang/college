<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int  flag = -1;
	try{
		flag = Integer.parseInt(request.getParameter("flag"));
	}catch(Exception e){
		flag = -1;
	}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>比赛列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
		<link rel="stylesheet" type="text/css" href="Web/Competition/css/list.css">
		<script type="text/javascript" src="Web/Competition/js/list.js"></script>
	</head>

	<body>
		<script type="text/javascript">
			var flag = <%=flag%>
		</script>
		<div id="wrap">
			<jsp:include page="../../Common/jsp/Title.jsp" flush="true" />

			<!-- <div class="nav-img">
				<a href="http://www.baidu.com"> <img
						src="Web/image/1452744742.jpg" style="width: 100%; height: 450px;" />
				</a>
			</div>
			<div class="search">
				<div style="width: 1000px; margin: 0 auto">
					<div class="cityselect">
						<h2>
							宁波
						</h2>
						<a>切换城市</a>
					</div>
					<div class="subjectselect">
						<span class="tip">请选择科目</span>
						<a class="ico_select"></a>
					</div>
					<button class="search-btn">
						查询
					</button>
				</div>
			</div> -->
			<div id="content">
			
				<div class="competition_left">
				      <div class="competition_text1_pic">
							<div class="competition_text1">
								大赛动态
								<p>COMPETITION</p>
							</div>
					   </div>
					   <div class="search1">
		    		      <div class="search_left">
		    			    <input type="text"  placeholder="搜索大赛" class="SearchBox" >
		    		      </div>
		    		      <div class="search_right" onclick="Search_Competition()"></div>
		   			   </div>
				</div>
				<div class="competition_list">
				<div class="title" id="hot">
					<span class="Nav_title">正在火热报名<span class="hot_enro" id="number"></span>个赛事</span>
					<span class="school_pri navgrade" onclick="school(1,2)" style="margin-left:20px;">小学</span>
					<span>|</span>
					<span class="school_midd navgrade" onclick="school(2,2)">初中</span>
					<span>|</span>
					<span class="school_high navgrade" onclick="school(3,2)">高中</span>
				</div>
				
				
				<%--正在火热报名赛事 --%>
				<ul  class="contest-item" id="contest-item1">
				</ul>
				

				<div class="title" id="begin">
				<span class="Nav_title">即将开始报名<span class="begin_enro" id="number"></span>个赛事</span>
				<span class="school_pri1 navgrade" onclick="school(1,1)" style="margin-left:20px;">小学</span>
					<span>|</span>
					<span class="school_midd1 navgrade" onclick="school(2,1)">初中</span>
					<span>|</span>
					<span class="school_high1 navgrade" onclick="school(3,1)">高中</span>
				</div>
				
				<%--即将开始报名赛事 --%>
				<ul class="contest-item" id="contest-item2">
				</ul>
				
				
				
				</div>
			</div>

		</div>
		<jsp:include page="../../Common/jsp/End.jsp" flush="true" />
	</body>
</html>
