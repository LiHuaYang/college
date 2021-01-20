<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String roomtotalMoney=new String(request.getParameter("roomtotalMoney").getBytes("ISO-8859-1"),"utf-8");
String indata=new String(request.getParameter("indata").getBytes("ISO-8859-1"),"utf-8");
String outdata=new String(request.getParameter("outdata").getBytes("ISO-8859-1"),"utf-8");
String people=new String(request.getParameter("people").getBytes("ISO-8859-1"),"utf-8");
String roomId=new String(request.getParameter("roomId").getBytes("ISO-8859-1"),"utf-8");
int userid=Integer.parseInt(new String(request.getParameter("userid").getBytes("ISO-8859-1"),"utf-8"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/usercss/pay.css">
	<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/userjs/pay.js"></script>
		<script type="text/javascript" src="js/common/date.js"></script>
		 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xTGYDhxlbHjfvpB4CsrtxvsA"></script>
        <script type="text/javascript">
            var roomId="<%=roomId%>";
            var roomtotalMoney="<%=roomtotalMoney%>";
            var people="<%=people%>";
            var indata="<%=indata%>";
            var outdata="<%=outdata%>";
            var userid=<%=userid%>
        </script> 
   </head>
  
<body>
   <div class="heads">

   </div>
   <div class="grey">
   		<div class="div1">
   			<div class="div1_1">
   				<div class="pay">付款</div>
   				<div class="country">城市</div>
   				<select class="select1">
					<option>宁波</option>
				</select>
				<div class="payway">付款方式</div>
				<div class="payway1">
					<div class="payway2">
						<select class="select2">
							<option>信用卡</option>
							<option>支付宝</option>
						</select>
					</div>
					<div class="payway3">
						<div class="picture1"></div>
						<div class="picture2"></div>
						<div class="picture3"></div>
						<div class="picture4"></div>
						<div class="picture5"></div>
					</div>
				</div>
				<div class="card">卡号</div>
				<div class="card2">
					<input type="text" class="card1"/>
					<div class="card3"></div>
				</div>
				<div class="date">
					<div class="date1">有效期至</div>
					<!-- <div class="date2">安全码</div> -->
				</div>
				<div class="date3">
					<div class="date4">
					    <input type="text" class="select3" value="<%=indata %>">
					</div>
					<div class="date8">
					    <input type="text" class="select4" value="<%=outdata %>">
					</div>
					
					<!-- <div class="date5">
						<input type="text" class="date6"/>
						<div class="date7"></div>
					</div> -->
					
				</div>
				<div class="save">
					<input type="checkbox" name="remember" class="forget1" checked/>
					<a class="a1">请保存我的信用卡信息以便在以后的交易中使用</a>
				</div>
				<div class="bill">
					<div class="pay">预订信息</div>
					<div class="bill_1">
						<div class="inbill_1">住客姓名
							<input type="text" class="inbill_3" id="OrderUsername"/>
						</div>
					</div>
					<div class="bill_1">
						<div class="inbill_1">身份证号
							<input type="text" class="inbill_3" id="OrderUserphon"/>
						</div>
					</div>
					<div class="bill_1">
						<div class="inbill_5">手机号码
							<input type="text" class="inbill_8" id="OrderUserIDnumber"/>
						</div>
					</div>
				</div>
				
				
				<!-- <div class="introduce">
					<div class="introduce1">向Alex介绍一下自己</div>
					<div class="introduce2">为房东提供尽可能多的信息将使他们更有可能确认您的预订申请：</div>
					<div class="introduce3">
						<li>向Alex介绍下您自己</li>
						<li>您是为什么来Lomita？还有谁一起来？</li>
						<li>您喜爱这个房源的哪些地方？请说一说！</li>
					</div>
					<div class="introduce4">
						<div class="introduce4_1"></div>
    					<textarea  placeholder="向房东发送消息..." class="textarea1"></textarea>
					</div>
				</div> -->
				
				
				<div class="help">通过点击“确定”，即表示您同意右边显示的总金额（包含服务费），也同意
					<a href="#" class="a2">服务条款</a> ,
					<a href="#" class="a3">《房屋守则》</a>, 
					<a href="#" class="a4">退订政策</a>以及
					<a href="#" class="a5">房客退款政策</a>。
				</div>
				<div class="goon">
					<div class="goon1">
						<button type="button" class="button" onclick="button()">确定</button>
					</div>
				</div>
				<!-- <div class="help1">只有当房东接受了您的申请，您才会被收取费用。房东有24小时的回
				复时间。如果房东拒绝了您的申请或没有回复，您将不会被收取任何费用
				</div> -->
   			</div>
   			
   			
   			<div class="div1_2">
   				<div class="pic"></div>
   				<div class="word">
   				    <div class="word_box">
   					
   					</div>
   				</div>
   				<div class="word">
   					<div class="inword3_1"><%=people %>预订的独立房间</div>
   					<div class="inword3_2"><%=indata %>至<%=outdata %></div>
   				</div>
   				<div class="word">
   					<div class="word4">
   						<div class="inword4_2">退订政策</div>
   						<div class="inword4_1">灵活</div>
   					</div>
   					<div class="word4">
   						<div class="inword4_2">《房屋守则》</div>
   						<div class="inword4_3">阅读政策</div>
   					</div>
   					<div class="word4">
   					    <div class="word4_inword4_box"></div>
   					</div>
   				</div>
   				<div class="price">
   					<div class="word4">
   					    <div class="word4_price1_box"></div>
   					</div>
   					
   					<!-- <div class="word4">
   						<div class="price3">清洁费</div>
   						<div class="price4">￥65</div>
   					</div>
   					<div class="word4">
   						<div class="price3">服务费</div>
   						<div class="price4">￥45</div>
   					</div> -->
   					
   					<div class="price5">优惠券代码</div>
   				</div>
   				<div class="total">
   					<div class="total_1">总价</div>
   					<div class="total_2">￥<%=roomtotalMoney %></div>
   				</div>
   				
   				<!-- <div class="final">您正以以下货币支付 €EUR. 您的费用总计为 €46. 预订此房源的
   					<a href="#" class="a6">汇率</a>为€1 EUR兑$1.10 USD（您房东的房源货币）。
   				</div> -->
   			</div>
   			
   		</div>
   </div>
   <div class="blackbar" style="display: none;" ></div>
</body>
</html>
