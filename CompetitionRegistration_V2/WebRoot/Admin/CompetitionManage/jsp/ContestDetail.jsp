<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>二级页面</title>
	<link href="Common/common.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="Common/common.js"></script>
    
    <script type="text/javascript">
    	function change() {
    		// $("#competitionBasicInfo").attr("class", "select-style"); //设置p元素的class为 "high"
		}
    	$(function(){	
    		$('.tabPanel ul li').click(function(){
    			$(this).addClass('hit').siblings().removeClass('hit');
    			$('.panes>div:eq('+$(this).index()+')').show().siblings().hide();	
    		})
    	})
    </script>
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
	        			大赛管理
	        		</h4>
	        	</div>
	        	<div class="panel-title">
					<h5>基本信息</h5>
				</div>
	        	<div class="pane" style="display:block;">
			    		这里显示大赛的基本信息
				</div>
			    	
	        	<%--标签切切换--%>
			    <div class="tabPanel">
					<ul class="panel-title">
						<li class="hit">大赛承办方</li>
						<li>相关评价</li>
						<li>大赛参加人员</li>
					</ul>
					<div class="panes">
						<div class="pane" style="display:block;">
						</div>
						<div class="pane"><h4>Secend tab content</h4><p>First tab content</p></div>
						<div class="pane"><h4>Third tab content</h4><p>First tab content</p></div>
					</div>
			    </div>
        	</div>
        	<div style="clear:both"></div>
	  	</div>
	  	<jsp:include page="../../Common/Foot/Foot.jsp" flush="true" />
  	</div>
  </body>
</html>
