<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
</head>

<body>
	<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
		<div class="am-offcanvas-bar admin-offcanvas-bar">
			<ul class="am-list admin-sidebar-list">
				<li>
					<a href="${ctx}/index.jsp"><span class="am-icon-home am-icon-fw"></span>	首页</a>
				</li>
				
				<li class="admin-parent">
					<a class="am-cf" data-am-collapse="{target: '#collapse-nav'}">
						<span class="am-icon-users am-icon-fw"></span>	
						信息管理 
						<span class="am-icon-angle-right am-fr am-margin-right"></span>
					</a>
					
					<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
							<li>
								<a href="${ctx}/admin/studentgetPage" class="am-cf">
									<span class="am-icon-list am-icon-fw"></span>	
									学生信息
									<!-- <span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span> -->
								</a>
							</li>
							
							<li>
								<a href="${ctx}/admin/teachergetPage" >
									<span class="am-icon-list am-icon-fw"></span> 
										老师信息
								</a>
							</li>
					
					</ul>
					
				</li>
				
				<li class="admin-parent">
					<a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}">
						<span class="am-icon-cog am-icon-fw"></span> 
							系统管理 
						<span class="am-icon-angle-right am-fr am-margin-right"></span>
					</a>
					
					<ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav2">
						
							<li><a href="admin-gallery.html"><span class="am-icon-th am-icon-fw"></span>
									相册页面<span
									class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
							<li><a href="admin-log.html"><span
									class="am-icon-calendar am-icon-fw"></span> 系统日志</a></li>
							<li><a href="admin-404.html"><span class="am-icon-bug am-icon-fw"></span>
									404</a>
							</li>
					</ul>
					
				</li>
				
				
				
				
<!-- 				<li><a href="admin-table.html"><span class="am-icon-table am-icon-fw"></span>
						表格</a></li>
				<li><a href="admin-form.html"><span
						class="am-icon-pencil-square-o"></span> 表单</a></li> -->
				<li><a href="#"><span class="am-icon-sign-out am-icon-fw"></span> 注销</a></li>
			</ul>

			<div class="am-panel am-panel-default admin-sidebar-panel">
				<div class="am-panel-bd">
					<p>
						<span class="am-icon-bookmark am-icon-fw"></span> info
					</p>
					<p>This is black board</p>
				</div>
			</div>

			<div class="am-panel am-panel-default admin-sidebar-panel">
				<div class="am-panel-bd">
					<p>
						<span class="am-icon-tag am-icon-fw"></span> wiki
					</p>
					<p>Welcome to the admin system!</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>