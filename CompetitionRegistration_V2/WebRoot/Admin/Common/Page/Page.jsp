<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="Admin/Common/Page/Page.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
    <div class="page">
	<div class="page_left">
		<table>
			<tbody>
				<tr>
					<td style="width: 80px">
						<span class="page_font" onclick="checkAll(false)">取消</span>
						<span class="page_font" onclick="checkAll(true)">全选</span>
					</td>
					<td>
						<select>
							<option>
								1
							</option>
							<option>
								2
							</option>
							<option>
								3
							</option>
							<option>
								4
							</option>
						</select>
					</td>
					<td>
						<div class="pagination-btn-separator"></div>
					</td>
					<td>
						<span class="icon pagination-first"></span>
					</td>
					<td>
						<span class="icon pagination-prev" id="btn_pre_page"></span>
					</td>
					<td>
						<div class="pagination-btn-separator"></div>
					</td>
					<td>
						<span class="page_font">第</span>
					</td>
					<td>
						<input id="current_page" style="width: 20px;" type="text" value="1" />
					</td>
					<td>
						<span class="page_font">共10页</span>
					</td>
					<td>
						<div class="pagination-btn-separator"></div>
					</td>
					<td>
						<span class="icon pagination-next" id="btn_next_page"></span>
					</td>
					<td>
						<span class="icon pagination-last"></span>
					</td>
					<td>
						<span class="icon pagination-load"></span>
					</td>
					<td>
						<div class="pagination-btn-separator"></div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="page_right ">
		显示
		<span>1</span>到
		<span>10</span>,共
		<span>10</span>记录
	</div>
	<div style="clear: both;"></div>
</div>
  </body>
</html>
