<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/style/css/amazeui.page.css">

<title>学生列表</title>
</head>

<body>
	<!------------------------------------------ 中间开始 -------------------------------------------->

	<div class="am-cf am-padding am-padding-bottom-0">
		<div class="am-fl am-cf">
			<strong class="am-text-primary am-text-lg">表格</strong> / <small> 学生信息列表 </small>
		</div>
	</div>  


	<hr>

	<div class="am-g">
		<div class="am-u-sm-12 am-u-md-6">
			<div class="am-btn-toolbar">
				<div class="am-btn-group am-btn-group-xs">
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-plus"></span> 新增
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-save"></span> 保存
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-archive"></span> 审核
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-trash-o"></span> 删除
					</button>
				</div>
			</div>
		</div>
		<div class="am-u-sm-12 am-u-md-3">
			<div class="am-form-group">
				<select data-am-selected="{btnSize: 'sm'}">
					<option value="option1">所有类别</option>
					<option value="option2">IT业界</option>
					<option value="option3">数码产品</option>
					<option value="option3">笔记本电脑</option>
					<option value="option3">平板电脑</option>
					<option value="option3">只能手机</option>
					<option value="option3">超极本</option>
				</select>
			</div>
		</div>
		<div class="am-u-sm-12 am-u-md-3">
			<div class="am-input-group am-input-group-sm">
				<input type="text" class="am-form-field"> <span
					class="am-input-group-btn">
					<button class="am-btn am-btn-default" type="button">搜索</button>
				</span>
			</div>
		</div>
	</div>
	
	<div class="am-g">
		<div class="am-u-sm-12">
			<!-- <form class="am-form"> -->
				<table class="am-table am-table-striped am-table-hover table-main">
					<thead>
						<tr>
							<th class="table-check"><input type="checkbox" /></th>
							<th>ID</th>
							<th>名字</th>
							<th>年龄</th>
							<th>所在学校</th>
							<th class="table-set">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.result.pageData}" var="item"
							varStatus="status">
							<tr>
								<td><input type="checkbox" /></td>
								<td><c:out value="${item.id}" /></td>
								<td><c:out value="${item.name}" /></td>
								<td><c:out value="${item.age}" /></td>
								<td><c:out value="${item.gradulate}" /></td>
								<td>
									<div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs">
											<button id="bj_+${item.id}"
												class="am-btn am-btn-default am-btn-xs am-text-secondary">
												<span class="am-icon-pencil-square-o"></span> 
												<a href="${ctx}/admin/teacherdetail?id=${item.id}">编辑</a>
											</button>
											<button 
												class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
												<span class="am-icon-copy"></span> 复制
											</button>
											<button 
												class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
												<span class="am-icon-trash-o"></span> 删除
											</button>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div style="margin:0 auto; text-align:center">
					<a href="${ctx}/admin/teachergetPage?page=${requestScope.result.startPage}"> 首页 </a>
					<c:if test="${requestScope.result.currentPage > 1}">
						<a href="${ctx}/admin/teachergetPage?page=${requestScope.result.currentPage - 1}"> 上一页 </a>
					</c:if>
					<c:forEach var="pageNum" begin="${requestScope.result.startPage}" end="${requestScope.result.endPage}" >
						[<a href="${ctx}/admin/teachergetPage?page=${pageNum}"> ${pageNum} </a>]
					</c:forEach>
					
					<c:if test="${requestScope.result.currentPage < requestScope.result.totalPage }">
						<a href="${ctx}/admin/teachergetPage?page=${requestScope.result.currentPage + 1 }"> 下一页 </a>    
					</c:if>
					<a href="${ctx}/admin/teachergetPage?page=${requestScope.result.endPage}"> 尾页 </a>   
	

				</div>
				<!-- <div data-am-page="{pages:10}"></div> -->
				<!-- 需要知道总的页数和请求地址 -->
				<%-- ${requestScope.result.totalPage} --%>
				<%-- <div data-am-page="{pages:${requestScope.result.totalPage}, jump:'${ctx}/admin/getPage?page=%page%'}"> --%>         
			</div>
				
			<!-- </form> -->
		</div>
	
	
<script type="text/javascript" src="${ctx}/script/amazeui.page.js"></script>
	<!------------------------------------------ 中间结束 -------------------------------------------->
</body>
</html>