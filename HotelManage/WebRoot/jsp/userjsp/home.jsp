<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String indata=new String(request.getParameter("indata").getBytes("ISO-8859-1"),"utf-8");
    String outdata=new String(request.getParameter("outdata").getBytes("ISO-8859-1"),"utf-8");
    String people=new String(request.getParameter("people").getBytes("ISO-8859-1"),"utf-8");
    String roomId=new String(request.getParameter("roomId").getBytes("ISO-8859-1"),"utf-8");
    //String userid=new String(request.getParameter("userid").getBytes("ISO-8859-1"),"utf-8");
    int userid=Integer.parseInt(new String(request.getParameter("userid").getBytes("ISO-8859-1"),"utf-8"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'home.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="css/usercss/home.css">
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/userjs/home.js"></script>
		<script type="text/javascript" src="js/common/date.js"></script>
		 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xTGYDhxlbHjfvpB4CsrtxvsA"></script>
	     <script type="text/javascript">
	         var roomId="<%= roomId%>";
	         var userid=<%= userid%>;
	     </script>
	</head>

	<body>
		<div class="heads"></div>
		<div class="homepic">
			<div class="row">
			
				<div class="homepic-title "></div>
			</div>
			
		</div>
		<div class="summary">
			<div class="row">
				<div class="summary-left">
					<!-- <div class="summary-left-pic">
						<div class="summary-left-img"></div>
						<div class="summary-left-name">小白</div>
					</div> -->
					<div class="summary-left-con">
					
					    <div class="summary_left_con1_box"></div>
						
						<!--  <div class="summary-left-con2">干尼亚, 克里特岛(Crete), 希腊</div>-->
						<div class="summary-left-con3">
							<div class="summary-left-con31"><i class="iconfont font" id="summ1" onMouseMove="Dispsumm1()" onMouseOut="Hidesumm1()" onclick="jump1()">&#xf012b</i><!-- <div class="conhome">整套房子</div> -->
								<div class="temp_summ1" style="display:none;">房源</div>
							</div>
							<div class="summary-left-con32"><i class="iconfont font" id="summ2" onMouseMove="Dispsumm2()" onMouseOut="Hidesumm2()" onclick="jump2()">&#xf00d5</i><!--<div class="conpeople">6位房客</div>-->
								<div class="temp_summ2" style="display:none;">评论</div>
							</div>
							<div class="summary-left-con33"><i class="iconfont font" id="summ3" onMouseMove="Dispsumm3()" onMouseOut="Hidesumm3()" onclick="jump3()">&#xf027f</i><!--<div class="conroom">3间卧室</div>-->
								<div class="temp_summ3" style="display:none;">地址</div>
							</div>
							<div class="summary-left-con34"><i class="iconfont font" id="summ4" onMouseMove="Dispsumm4()" onMouseOut="Hidesumm4()" onclick="jump4()">&#xf0141</i><!--<div class="consleep">4张床</div>-->
								<div class="temp_summ4" style="display:none;">相似房源</div>
							</div>
						</div>
					</div>
				</div>
				<div class="summary-right">
					<div class="summary-right1"><div>入住日期</div><div>退房日期</div><div>房客</div></div>
					<div class="summary-right2">
					<input placeholder="年-月-日" type="text" id="indata" onclick="SelectDate(this,'yyyy-MM-dd')" onchange="indata(this.id)" value="<%= indata%>">
					<input placeholder="年-月-日" type="text" id="outdata" onclick="SelectDate(this,'yyyy-MM-dd')" onchange="outdata(this.id)" value="<%=outdata %>">
					<select id="test">
						<option value="1" selected = "selected">1位房客</option>
						<option value="2">2位房客</option>
						<option value="3">3位房客</option>
						<option value="4">4位房客</option>
						<option value="5">5位房客</option>
						<option value="6">6位房客</option>
					</select>
					</div>
					<!--<div class="summary-right4">
						<select >
							<option value="single" selected = "selected">单人间</option>
							<option value="double">双人间</option>
							<option value="tao">套房</option>
						</select>
					</div>  -->
					<div class="Order_Box">
					
					</div>
				</div>
			</div>
		</div>
		<div class="homemiddle" id="Homee">
			<div class="row">
				<div class="homemiddleleft">
				
				    <div class="homemiddleleft-title">关于此房源</div>
			        <div class="homemiddleleft-con">通过xx，您可以在我们宾馆中找到独一无二的住宿体验——从独栋房子到公寓，再到树屋和圆顶小屋。以下的房源详情阐述了此房源所提供的一切。如有任何疑问，您可以直接联系客服人员。</div>
			        <div class="homemiddleleft-landlord">联系客服</div>
				
					<div class="homemiddleleft-landsourse">
					    <div class="landsourse_name">房源</div>
					    
					    <div class="landsourse_content"></div>
					    
					    <div class="landsourse_content_rule">《房屋守则》</div>
					</div>				
					<div class="homemiddleleft-landpleasure">
					    <div class="landpleasure_name">便利设备</div>
					    <div class="landpleasure_content">
					       <div class="landpleasure_content_left">
					          <div class="Kitchen"><i class="iconfont font" >&#xf0039</i> 厨房</div>
					          <div class="Network"><i class="iconfont font" >&#xf01bd</i> 无线网络</div>
					       </div>
					       <div class="landpleasure_content_right">
					           <div class="TV"><i class="iconfont font" >&#xf0099</i> 电视</div>
					           <div class="Pet"><i class="iconfont font" >&#xf01c7</i> 宠物设施</div>
					           <div class="landpleasure_more_content" onclick="Disp_More_Content()">更多内容</div>
					       </div>
					    </div>
					    <div class="more-content" style="display:none;">
					    	<div class="more-content-left">
					    		<div class="AirConditioner"><i class="iconfont font" >&#xf0005</i> 空调</div>
					          	<div class="Heating"><i class="iconfont font" >&#xf02b2</i> 暖气</div>
					          	<div class="HotTub"><i class="iconfont font" >&#xf0123</i> 热水浴缸</div>
					          	<div class="Washing"><i class="iconfont font" >&#xf0129</i> 洗衣机</div>
					          	<div class="Swimming"><i class="iconfont font" >&#xf004e</i> 游泳池</div>
					          	<div class="Wheelchair"><i class="iconfont font" >&#xf014b</i> 无障碍设施</div>
					          	<div class="Workplace"><i class="iconfont font" >&#xf0146</i> 工作区域</div>
					    	</div>
					    	<div class="more-content-right">
					    		<div class="Drying"><i class="iconfont font" >&#xf020c</i> 烘干机</div>
					          	<div class="Breakfast"><i class="iconfont font" >&#xf01d8</i> 早餐</div>
					          	<div class="Cloth"><i class="iconfont font" >&#xf01d1</i> 衣架</div>
					          	<div class="Iron"><i class="iconfont font" >&#xf0162</i> 熨斗</div>
					          	<div class="Indoorfireplace"><i class="iconfont font" >&#xf01b1</i> 室内壁炉</div>
					          	<div class="Lifenecessary"><i class="iconfont font" >&#xf0178</i> 生活必需品</div>
					    	</div>
					    </div>
					</div>					
					<div class="homemiddleleft-price">
					    <div class="price_name">价格</div>
					    <div class="price_content">
					    
					       <div class="price_content_left"></div> 
					       
					       <div class="price_content_right">
					          <div>退订政策： <b style="color: #ff5a5f">灵活</b></div>
					       </div>
					    </div>
					</div>
					<div class="homemiddleleft-landcon">
					    <div class="landcon_name">描述</div>
					    <div class="landcon_content"></div>
					</div>
					
					<div class="homemiddleleft-landsent">
					    <div class="landsent_name">可租用性</div>
					    
					    <div class="landsent_content"></div>
					
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="comment" id="Comm">
			<div class="row">
				<div class="commentleft">
				
				<div class="commentleft_box"></div>
					
					<div class="text_number_box">
   	                        <div class="text_bottom_number_box"></div>
   	                        <div class="text_bottom_next" onclick="nextpage()">▶</div>
   	                </div>  
				</div>
			</div>
		</div>
		
		
		<div class="enddown" id="Add">
			<div class="enddown-left-title-kuang">
				<div class="enddown-left-title" onclick="Disp_Map()">地址显示</div>
				<div class="enddown-left-title" onclick="Disp_Map()" style="display: none;">地址收起</div>
			</div>
			
			<div class="row">
				 <!-- <div class="enddown-left">
					
					<div class="enddown_left_content">
					    <div class="enddown_content_picture">
					        <div class="enddown_picture"></div>
					    </div>
					    <div class="enddown_content_text">
					        <div class="content_one_text">xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</div>
					        <div class="content_text_check">查看个人完整资料</div>
					        <div class="content_center_text">
					           <div class="center_text_left">
					               <div>Paris, France</div>
					               <div>注册时间: 2014年10月</div>
					           </div>
					           <div class="center_text_right">
					              <div>回复率: <b>94%</b></div>
					              <div>回复时间: <b>几小时内</b></div>
					           </div>
					        </div>
					        <div class="button_connect">
					            <input type="button" class="content_text_connect" value="联系房东">
					        </div>
					    </div>
					</div>					
				</div>-->
				
				
				<div class="enddown-map"id="allmap" style="display:none;"></div>
				
				<div class="enddown-end" >
				<div class="temp_div"></div>
				   <div class="enddown_name_box" id="similar">
				       <div class="enddown_end_name">相似房源</div>
				   </div>
				   
				   <div class="enddown_end_picture">
				   </div>
				   
				</div>
			</div>
		</div>
		
		
		<div class="blackbar" style="display: none;" ></div>
	</body>
</html>
