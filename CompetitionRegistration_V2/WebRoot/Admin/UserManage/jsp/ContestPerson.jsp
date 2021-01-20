<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ContestPersonjsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="Common/common.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="Common/common.js"></script>

  </head>
  <body>
 	<div id="wrap">
	  	<jsp:include page="../../Common/Head/Head.jsp" flush="true" />
	  	<div id="content">
	  		<jsp:include page="../../Common/MainLeft/LeftNav.jsp" flush="true" />
        	<div id="mainright">
        		<div class="right-head">
	        		<h4>
	        			<i class="iconfont font">&#xf017d</i>
	        			客户管理
	        		</h4>
        		</div>
        		
        		<div class="panel-title">
        				<h5>比赛人员</h5>
				</div>
				
        		<div class="data-panel">
        			<div class="opration-bar">
        				<button class="op-button"><i class="iconfont font">&#xf015c</i>刷新</button>
        				<button class="op-button"><i class="iconfont font">&#xf012c</i>查找</button>
        			</div>
        			<table class="data-table">
        			
					  <tr class="odd data-title">
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					  </tr>
					  <%for (int i=0; i<10; i++) { %>
					  <tr class="odd">
					    <td onclick="do_onclick(this)"></td>
					    <td onclick="do_onclick(this)"></td>
					    <td onclick="do_onclick(this)"></td>
					    <td onclick="do_onclick(this)"></td>
					    <td onclick="do_onclick(this)"></td>
					    <td onclick="do_onclick(this)"></td>
					    <td onclick="do_onclick(this)"></td>
					  </tr>
					  <% } %>
					</table>
        		</div>
        	</div>
        	<div style="clear:both"></div>
	  	</div>
	  	<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
  	</div>
  </body>
</html>
