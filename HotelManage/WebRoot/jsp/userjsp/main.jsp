<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//String username="";
//String userpic="";
int userid=0;
try{
    //username=(String)request.getSession().getAttribute("userName");
    //userpic=(String)request.getSession().getAttribute("UserPic");
    userid=(Integer)request.getSession().getAttribute("UserId123");
    System.out.print(userid);
}catch(Exception e){
    e.printStackTrace();
}

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
	<link rel="stylesheet" type="text/css" href="css/usercss/main.css">
	<link rel="stylesheet" type="text/css" href="css/usercss/searchlow.css">
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
	 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xTGYDhxlbHjfvpB4CsrtxvsA"></script>
	<script type="text/javascript" src="js/common/jq.js"></script>
	<script type="text/javascript" src="js/userjs/main.js"></script>
	<script type="text/javascript" src="js/common/date.js"></script>
	<script type="text/javascript" src="js/userjs/searchlow.js"></script>
	<script type="text/javascript">
		var userid=<%=userid%>;
		</script>
  </head>
  
  <body>
    <div class="mainpic_box">
   <div class="pic_four">
   	 	<div class="pic_one"></div>
   	 	<div class="pic_one"></div>
   	 	<div class="pic_one"></div>
   	 	<div class="pic_one"></div>
   	 </div>
   	<div class="mainpic">
   	
   		<div class="mainpic_title">
   			<div class="mainpic-title-one"><div class="mainpic-title-onename">s房屋租借平台</div></div>
   				<div class="mainpic_title_two">
   					<div class="beroomer">成为房东</div>
   					<div onclick="showvip()">VIP</div>
   					<div onclick="showregister()">注册</div>
   					<div onclick="showlogin()">登录</div>
   				</div>
   				<div  class="homehead_person_show" style="display: none;">
			        <div class="homehead_person_head" onclick="gotopersoninfo()"></div>
			    </div>
   		</div>
   		
   		<div class="mainpic-main">
   			<div class="mainpic-main-home">欢迎回家</div>
   			<div class="mainpic-main-text">
   				 <div class="press1" >
   				    <i class="iconfont font" id="press_temp" onclick="press_left()">&#xf016e</i>
   				 </div> 向超过190个国家的当地人租住独一无二的家。
   				 <div class="press2" >
   				     <i class="iconfont font" id="press_temp" onclick="press_right()">&#xf016d</i>
   				 </div>
   			</div>

   			
   			<div class="mainpic-main-button"><div class="mainpic-main-buttonshow">如何使用平台</div></div>
   		</div>
   		<div class="mainpic-black">
   			<div class="mainpic-black-in">
   				<input class="mainpic-black-input1" id="suggestId" placeholder="您想去哪里？"  type="text"/>
   				<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
   				<input class="mainpic-black-input2" placeholder="入住日期"  onclick="SelectDate(this,'yyyy-MM-dd')"type="text"/>
   				<input class="mainpic-black-input3" placeholder="退房日期" onclick="SelectDate(this,'yyyy-MM-dd')" type="text"/>
   				<select class="mainpic-black-input4" id="test">
   					<option value="1" >1位房客</option>
   					<option value="2" >2位房客</option>
   				</select>
   				<button class="mainpic-black-input5" onclick="tosearch()">搜索</button>
   			</div>
   		</div>
   	</div>
   	</div>
   	
   	
	<div class="media-cover">  
		<div class="media-cover-see">
			<div class="media-cover-seetext">遇见是一种美好的形式！</div>
			<div class="media-go">▶</div>
		</div>
	</div>
	<div class="panel">
		<div class="panel1">
			<div class="seacherworld">搜索浙江</div>
			<div class="seacherworldtext">搜罗宁波热门房间</div>
		</div>
		<div class="panel2" >
		<div class="panel2-line1">
			<div class="panel2-line1-block1" onclick="fengling()">
				<div id="fengling" >海曙</div>
			</div>
			
			<div class="panel2-line1-block2-box"></div>
			
		</div>
		<div class="panel2-line2">
			<div class="panel2-line2-block1" onclick="ziran()"><div id="ziran">镇海</div></div>
			<div class="panel2-line2-block2" onclick="pingyao()"><div id="pingyao">鄞州</div></div>
			<div class="panel2-line2-block3" onclick="tongyi()"><div id="tongyi">江北</div></div>
		</div>
		<div class="panel2-line3">
		<div class="panel2_line3_block1_box"></div>
			<div class="panel2-line3-block2" onclick="lishutang()">
				<div id="lishutang">江东</div>
			</div>
		</div>
		<div class="panel2-line4">
			<div class="panel2-line4-block1" onclick="qinyong()"><div id="qinyong">余姚</div></div>
			<div class="panel2-line4-block2" onclick="shaobai()"><div id="shaobai">慈溪</div></div>
			<div class="panel2-line4-block3" onclick="hualong()"><div id="hualong">奉化</div></div>
		</div>
		</div>
	</div> 
	<div id="dd">
		<img name="a1" src="img/end_image_1.jpg" width="1341" height="400"/>
		<div id="da" class="a">
			<a onclick="change2()"></a>
		</div>
		<div id="dc" class="c">
			<!-- <a ></a> -->
		</div>
		<div id="db" class="b">
			<a  onclick="change1()"></a>
		</div>
	</div>
	
	<!-- <div class="community">我们的社区</div>
	<div class="picture">
		<a href="#">
			<div class="picture1">
				<div class="inpicture1_1">create</div>
				<div class="inpicture1_2">
					<div class="inpicture1_3">
						<h2 align="center" >创造属于您的Airbnb</h2>
					</div>
					<div class="inpicture2_4">
						<span style="display:block;text-align:center;">创造您的标志,分享您的故事！</span>
					</div>
				</div>
			</div>
		</a>
		<a href="#">
			<div class="picture2">
				<div class="inpicture2_1">旅行</div>
				<div class="inpicture2_2">
					<div class="inpicture2_3">
						<h1 align="center" >Alice & Chris</h1>
					</div>
					<div class="inpicture2_4">
						<span style="display:block;text-align:center;">不管是跨洋过海还是跨城旅游，Alice &</span>
						<span style="display:block;text-align:center">Chris总是寻找着最本真最当地</span>
					 	<span style="display:block;text-align:center;">化的体验。</span>
					</div>
				</div>
				<div class="inpicture2_5">了解如何通过Airbnb旅行。</div>
			</div>
		</a>
		<a href="#">
			<div class="picture3">
				<div class="inpicture3_1">商务差旅</div>
				<div class="inpicture3_2">
					<div class="inpicture3_3">
						<h1 align="center" >商务Airbnb</h1>
					</div>
					<div class="inpicture2_4">
						<span style="display:block;text-align:center;">不管您因为工作来到哪里，都像回到了家</span>
						<span style="display:block;text-align:center">里一样。</span>
					</div>
				</div>
				<div class="inpicture3_4">让您的团队加入Airbnb。</div>
			</div>
		</a>
		<a href="#">
			<div class="picture4">
				<div class="inpicture4_1">出租</div>
				<div class="inpicture4_2">
					<div class="inpicture4_3">
						<h1 align="center" >Nina</h1>
					</div>
					<div class="inpicture2_4">
						<span style="display:block;text-align:center;">专业摄影师Nina喜欢帮助房客探索上海的</span>
						<span style="display:block;text-align:center">艺术气息。</span>
					</div>
				</div>
				<div class="inpicture4_4">了解如何在Airbnb出租。</div>
			</div>
		</a>
	</div>
	<div class="div1">
		<div class="indiv1_1">以信任为基础的社区</div>
		<div class="indiv1_2">
			<div class="indiv1_3">
				<div class="indiv2_1"></div>
				<div class="indiv2_2">微博验证</div>
				<div class="indiv2_3">使用您的微博账户登录以验证您的身份。
					<a style="text-decoration:underline;color:white;" href="#">了解更多</a>
				</div>
			</div>
			<div class="indiv1_4">
				<div class="indiv4_1"></div>
				<div class="indiv2_2">可信赖的服务</div>
				<div class="indiv2_3">维护Airbnb的信任和安全是我们的首要任务。
					<a style="text-decoration:underline;color:white;" href="#">了解更多</a>
				</div>
			</div>
			<div class="indiv1_5">
				<div class="indiv5_1"></div>
				<div class="indiv2_2">安全支付</div>
				<div class="indiv2_3">支付宝付款现已面向中国用户开通，欢迎使用。
					<a style="text-decoration:underline;color:white;" href="#">了解更多</a>
				</div>
			</div>
		</div>
	</div>
	<div class="div2"></div>
	<div class="div3">
		<div class="div3_1">
			<div class="indiv3_1">
				<select class="select1">
					<option>中文（简体）</option>
					<option>English</option>
				</select>
				<select class="select1">
					<option>CNY</option>
					<option>AED</option>
				</select>
				<br>
				<div class="word1">
					<a>客服电话</a><br>
					<a>国内：400-890-0309</a><br>
					<a>海外：+86-105904-5310</a><br>
				</div>
			</div>
			<div class="indiv3_2">
				<a style="font-weight:bold;font-size:17px;">公司信息</a><br>
				<div class="word2">
					<a href="#" style="color:white;text-decoration:none;">关于</a><br>
					<a href="#" style="color:white;text-decoration:none;">工作机会</a><br>
					<a href="#" style="color:white;text-decoration:none;">新闻</a><br>
					<a href="#" style="color:white;text-decoration:none;">博客</a><br>
					<a href="#" style="color:white;text-decoration:none;">帮助</a><br>
					<a href="#" style="color:white;text-decoration:none;">政策</a><br>
					<a href="#" style="color:white;text-decoration:none;">灾难与相应</a><br>
					<a href="#" style="color:white;text-decoration:none;">条款与隐私</a><br>
				</div>
			</div>
			<div class="indiv3_3">
				<a style="font-weight:bold;font-size:17px;">发现</a><br>
				<div class="word2">
					<a href="#" style="color:white;text-decoration:none;">信任与安全</a><br>
					<a href="#" style="color:white;text-decoration:none;">邀请好友</a><br>
					<a href="#" style="color:white;text-decoration:none;">礼品卡</a><br>
					<a href="#" style="color:white;text-decoration:none;">Airbnb精选</a><br>
					<a href="#" style="color:white;text-decoration:none;">移动版</a><br>
					<a href="#" style="color:white;text-decoration:none;">支持纽约市</a><br>
					<a href="#" style="color:white;text-decoration:none;">商务差旅</a><br>
					<a href="#" style="color:white;text-decoration:none;">网站地图</a><br>
				</div>
			</div>
			<div class="indiv3_4">
				<a style="font-weight:bold;font-size:17px;">出租</a><br>
				<div class="word3">
					<a href="#" style="color:white;text-decoration:none;">为什么要出租？</a><br>
					<a href="#" style="color:white;text-decoration:none;">好客之道</a><br>
					<a href="#" style="color:white;text-decoration:none;">房东义务</a><br>
					<a href="#" style="color:white;text-decoration:none;">好客之道</a><br>
				</div>
			</div>
		</div>
		<div class="div4"></div>
		<h3 align="center" style="color:white;">关注我们</h3>
		<h3 align="center" style="font-size:15px;font-weight:normal;color:#82888a;">@Airbnb,Inc</h3>
	</div> -->
	<div class="blackbar" style="display: none;" ></div>
		
	    
  </body>
</html>
