<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'newlist.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="Admin/Common/common.css" rel="stylesheet" type="text/css" />
    <link href="Admin/CompetitionManage/css/competition.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="Admin/Common/common.js"></script>
    <script type="text/javascript" src="Admin/Common/Page/paging.js"></script>
    
    <script type="text/javascript" src="Admin/NewsManage/js/newsList.js"></script>
    
  </head>
  <body>
  	<div id="wrap">
	  	<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
	  	<div id="content">
	  		<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
        	<div id="mainright">
        		<div class="right-head">
	        		<h5>
	        			<i class="iconfont font">&#xf017d</i>
	        			新闻管理--新闻列表
	        		</h5>
        		</div>
        		<div class="data-panel">
        		<ul class="opration-bar">
				  <li>
					<input type="text" style="width:0px; border:none"></input>
					<button class="op-button" onclick="addNews()"><i class="iconfont font">&#xf0175</i>添加新闻</button>
				  </li>
        			</ul>
        			<table class="data-table">
					  <tr class="odd data-title">
					  	<td style="width:35px;"></td>
					    <td>新闻标题</td>
					    <td>发布时间</td>
					    <td>状态</td>
					    <td>操作</td>
					    
					  </tr>
					  <%for (int i=0; i<10; i++) { %>
					  <tr class="odd" id="row"+<%=i%> >
					 	 <input type="hidden" id="newsID" value=""/>
					    <td id="check-item"><input name="box" type="checkbox" value="Heating"></td>
					    <td onclick="do_onclick(this)" id="newstitle"></td>
					    <td onclick="do_onclick(this)" id="puttime"></td>
					    <td onclick="do_onclick(this)" id="state"></td>
					    <td style="width:100px;">
					    <i class="iconfont font" onclick="toModify(this)">&#xf014f</i>
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <i class="iconfont font" onclick="newsremove(this)">&#xf00b3</i></td>
					  </tr>
					  <% } %>
					</table>
						<jsp:include page="../../Common/Page/Page.jsp" flush="true" />
        		</div>
        	</div>
        	<div style="clear:both"></div>
	  	</div>
	  	<br><br><br><br>
	  	<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
  	</div>
  </body>
</html>
