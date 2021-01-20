<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String where=new String(request.getParameter("where").getBytes("ISO-8859-1"),"utf-8");
String startdata=new String(request.getParameter("startdata").getBytes("ISO-8859-1"),"utf-8");
String enddata=new String(request.getParameter("enddata").getBytes("ISO-8859-1"),"utf-8");
String people=new String(request.getParameter("people").getBytes("ISO-8859-1"),"utf-8");
String userid=new String(request.getParameter("userid").getBytes("ISO-8859-1"),"utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/usercss/search.css">
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common/jq.js"></script>
	
	<link rel="stylesheet" href="css/common/normalize.min.css" />
    <link rel="stylesheet" href="css/common/ion.rangeSlider.css" />
    <link rel="stylesheet" href="css/common/ion.rangeSlider.skinFlat.css" id="styleSrc"/>
	<script src="js/common/ion.rangeSlider.js"></script> 

	<script type="text/javascript" src="js/userjs/search.js"></script>
	<script type="text/javascript" src="js/common/date.js"></script>
	
	 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xTGYDhxlbHjfvpB4CsrtxvsA"></script>
	 
	 <script type="text/javascript">
		var where="<%=where%>";		
		var userid="<%=userid%>"
	</script>
		
		
  </head>
  
  <body>
     
  	<div class="heads">
   			
   	    </div>
   	<div class="mainpic">   	  
   	    <div class="mainpic_left">
   	        <div class="mainpic_left_date">
   	            <div class="left_text_date">日期</div> 
   	            <input class="date_same" id="indata" placeholder="入住日期"  onclick="SelectDate(this,'yyyy-MM-dd')" type="text" value="<%=startdata %>" >
   	            <input class="date_same" id="outdata" placeholder="退房日期"  onclick="SelectDate(this,'yyyy-MM-dd')" type="text" value="<%=enddata %>">
   	            <select class="date_same" id="test">
   	              <option><%= people%></option>
   	              <option>2位房客</option>
   	            </select>
   	        </div>
   	       <div class="mainpic_left_street"></div>
   	       <div class="street_more" style="display:none;" onclick="street_umbrella_close()">
   	       </div>
   	             
   	        <div class="mainpic_left_price">
   	            <div class="left_text_price">价格范围</div>
   	            
   	            <div class="left_price_show">
					<input type="text" id="range_1"/>
				</div>
				<input type="button" class="left_price_sure" value="确定" onClick="ok()">
				
   	            <div class="Total_price">
   	            </div>
   	            
   	            <div class="price_down" onclick="price_umbrella_close()"></div>
   	            <div class="price_up" onclick="price_umbrella_open()" style="display: none;"></div>
   	        </div>
   	        
   	        
   	        <div class="mainpic_left_more" style="display: none;">
   	           <div class="mainpic_left_area">
   	               <div class="left_text_area">面积</div> 
   	               <select class="date_same">
   	                  <option>卧室</option>
   	               </select>
   	               <select class="date_same">
   	                  <option>卫生间</option>
   	               </select>
   	               <select class="date_same">
   	                  <option>床位</option>
   	               </select>
   	           </div>
   	           <div class="mainpic_left_option">
   	               <div class="left_text_option">选项</div> 
   	           </div>
   	           
   	           <div class="mainpic_left_facilities">
   	               <div class="left_text_facilities">便利设施</div>
   	               <div class="street_same"><input type="checkbox" class="right_checkbox"/> 无线网络</div>
   	               <div class="street_same"><input type="checkbox" class="right_checkbox"/> 游泳池</div>
   	               <div class="street_same"><input type="checkbox" class="right_checkbox"/> 厨房</div>
   	               <div class="facilities_down" onclick="facilities_umbrella_close()"></div>
   	               <div class="facilities_up" onclick="facilities_umbrella_open()" style="display: none;"></div>
   	           </div>
   	           <div class="mainpic_left_facilities_more" style="display:none" onclick="facilities_umbrella_close()">
   	           		<div class="street_same"><input type="checkbox" class="right_checkbox"/>24小时随时入住</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>一氧化碳探测器</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>健身房</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>允许吸烟</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>允许携带宠物</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>内部提供免费停车</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>卧室门装锁</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>大厦内电梯</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>安全卡</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>室内壁炉</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>急救包</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>提供可以使用笔记本</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>无障碍设施</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>早餐</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>暖气</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>有线电视</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>欢迎家庭/携带孩子入住</div>
   	                <div class="street_same"><input type="checkbox" class="right_checkbox"/>洗发水</div>
   	           </div>
   	           <div class="mainpic_left_house">
   	               <div class="left_text_house">房源类型</div>
   	               <div class="street_same"><input type="checkbox" class="right_checkbox"/> 公寓</div>
   	               <div class="street_same"><input type="checkbox" class="right_checkbox"/> 独立屋</div>
   	               <div class="street_same"><input type="checkbox" class="right_checkbox"/> 住宿加早餐</div>
   	               <div class="house_down" onclick="house_umbrella_close()"></div>
   	               <div class="house_up" onclick="house_umbrella_open()" style="display: none;"></div>
   	           </div>
   	           <div class="mainpic_left_space"></div>
   	           <div class="mainpic_left_fixed_box">
   	           <div class="mainpic_left_fixed">
   	               <input type="button" class="left_fixed_search" value="搜索">
   	               <input type="button" class="left_fixed_cancel" onclick="left_fixed_cancel()" value="取消">
   	           </div>
   	           </div>
   	        </div>
   	        
   	        
   	        <div class="mainpic_left_condition">
   	           <div class="left_text_condition" onclick="condition_choice()">更多筛选条件</div>
   	           <div class="image_condition"></div>
   	        </div>
   	        
   	        <div class="mainpic_left_picture"></div>
   	        
   	        <div class="left_text_bottom">
   	            <div class="left_text_number">
   	                <div class="text_bottom_word">1-18共300+房源出租</div><br/>
   	                
   	                <div class="text_number_box">
   	                        <div class="text_bottom_number_box"></div>
   	                        
   	                </div>  
   	            </div>
   	            
   	            <div class="left_bottom_nearlink">
   	               <div class="bottom_nearlink_room"> <b>悉尼更多房源：</b>公寓 • 独立屋 • 阁楼 • 别墅</div><br>
   	               <div><b>人们还会住在：</b>沙利山 · 邦迪海滩 · 帕兹角 · 格利贝 · 纽镇</div><br/>
   	               <div> 澳大利亚 >新南威尔士州> 悉尼 </div>
   	            </div>
   	        </div>

   	    </div>
   	   	         <div class="mainpic_right" id="allmap"></div>
	</div> 
	
<div class="blackbar" style="display: none;" ></div>

  </body>
</html>
