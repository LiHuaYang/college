<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>SaoMaZhiFu</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="Web/Main/js/Main.js"></script>
  </head>
  <body>
  
   	<table>
  <tr>
    <td><input id="name" type="text" style="width:300px; height:40px;" placeholder="商品名字"/></td>
     </tr>
    <tr>
    <td><input id="price" type="text" style="width:300px; height:40px;" placeholder ="商品价格"/></td>
  </tr>
</table>

<button onclick="pay()" value="支付" style="width:80px; height:35px;">支付</button>

  </body>
</html>
