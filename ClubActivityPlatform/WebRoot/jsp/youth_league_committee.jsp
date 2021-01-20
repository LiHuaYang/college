<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'youth_league_committee.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
 	<link rel="stylesheet" href="css/youth_league_committee.css" type="text/css"></link>
 	<script type="text/javascript" src="js/common/jq.js"></script>
    <script type="text/javascript" src="js/youth_league_committee.js"></script>

  </head>
  
  <body id="k">
		<div class="youth_league_committee_pic">
			<div class="heads"></div>
			<div class="youth_league_committee_title">XXX大学&mdash;团委</div>
			<div class="youth_league_committee_title1">欢迎您！</div>
		</div>
		<div class="youth_league_committee_main">
			<div class="youth_league_committee_row">
				<div class="youth_league_committee_left">
					<div class="youth_league_committee_context">
						<div class="youth_league_committee_contexttitle">简介</div>
						<div class="youth_league_committee_contextmore">中国共产主义青年团委员会的简称是团委，是中国共青团的组织之一。中国共产主义青年团（简称共青团）是中国共产党领导的先进青年的群众组织，是广大青年在实践中学习中国特色社会主义和共产主义的学校，是中国共产党的助手和后备军。</div>
					</div>
					
				</div>
				<div class="youth_league_committee_right">
					<div class="partin" onclick="showblackbar()">加入我们</div>
					<div class="organizenotice">
						<div class="organizenotice1"><i class="iconfont" id="zxc1">&#xf0130;</i> 团委公告</div>
						<div class="organizenotice2"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="youth_league_committee_main1">
			<div class="youth_league_committee_main1-row">
				<div class="youth_league_committee_main1-left">
					<div class="department-title"><div style="width: 80px;margin: auto;background: white;text-align: center;">部门</div></div>
					<div class="department-list">
						
					</div>
				</div>
				<div class="youth_league_committee_main1-right">
					<div class="youth_league_committee_main1-right-notice"></div>
					<div class="youthactivity-ti">
						<div class="organizenotice1"><i class="iconfont" id="zxc2">&#xf0161;</i> 团委活动</div>
							<div class="organizenotice2"></div>
				</div>	
			</div>
		</div>
		</div>
		<div class="youth_league_committee_main2">
			<div class="youth_league_committee_main2-row">
			<div class="youth_league_committee_main2-left">
				<div class="department-title"><div style="width: 80px;margin: auto;background: #EDEFED;text-align: center;">成员</div></div>
				<div class="user-list">
				<div class="user-list-left"><div><i class="iconfont" id="mb">&#xf017d;</i>     主席</div><div>副主席</div><div>部长</div></div>
				<div class="user-list-right">
					<div class="user-top">
						
					</div>
					<div class="user-middle">
						
					</div>
					<div class="user-bottom">
						<div class="user-one-list">
							
						</div>
						<div class="lefts"onclick="ileft()"><i class="iconfont" id="fontleft" >&#xf016e;</i></div>
    					<div class="rights"onclick="iright()"><i class="iconfont" id="fontright">&#xf016d;</i></div>
					</div>
				</div>
				</div>
			</div>
			<div class="youth_league_committee_main2-right">
			<div class="youth_league_committee_main2-right-activity">
				
			</div>
			</div>
			</div>
		</div>
		
		
			<div class="mainend">
			<div class="mainend-row">
				<div class="say1">
					鸟儿因翅膀而自由翱翔，
				</div>
				<div class="say2">
					鲜花因芬芳而美丽，
				</div>
				<div class="say3">
					校园因文明而将更加进步。
				</div>
				<div class="bordershow"></div>
				<div class="dm501">
					<i class="iconfont" id="write">&#xf00f5;</i>dm501
				</div>
			</div>
		</div>
		
		<div class="shadow">
			<div style="padding-top: 10%;">
				<div class="showdowblock"><i class="iconfont" id="del" onclick="closeblackbar()">&#xf0204</i>
					<div style="font-size: 15px;border-bottom: 1px solid rgb(200,200,200);width: 230px;margin: auto;height: 30px;margin-bottom: 10px;">申请成为我们的一员</div>
					<select class="sel">
					</select>
					<div style="font-size: 13px;">您的想法？</div>
					<textarea class="texta"placeholder="说点什么呗！"></textarea>
					<button onclick="partinyouth()">提交</button>
				</div>
			</div>
		</div>
  </body>
</html>
