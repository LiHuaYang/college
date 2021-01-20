<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int baruserid=0;
try{
    baruserid=(Integer)request.getSession().getAttribute("Userid");
}catch(Exception e){
    e.printStackTrace();
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Title.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css"></link>
    <script type="text/javascript" src="Web/Common/js/Title.js"></script>
	<link rel="stylesheet" type="text/css" href="Web/Common/css/Title.css">
	<link rel="stylesheet" type="text/css" href="Common/Tool/city-picker/picker.css">
	
	
	<script type="text/javascript">
	   var userid = <%=baruserid%>;
	</script>
	
  </head>
  
  <body>
    <div class="titleall">
       <div class="titleLogo">
           <div class="titleLogoPic"></div>
           <input class="titleLogoCity" id="place_title" placeholder="城市名"/>
           <!-- <input id="citySelect"/>     -->      
       </div>
       <div class="titleMune">
           <div class="Mune" id="MuneHome" onclick="gotoHome()">首页</div>
           <div class="Mune" id="MuneCompetition" onclick="gotocompetitionList()">赛事</div>
           <div class="Mune" id="MuneNews" onclick="gotoNews()">新闻</div>
           <div class="Mune" id="MunePaper" onclick="gotoPaper()">试卷</div>
           <div class="Mune" id="MuneMall" onclick="gotoShopping()">商城</div>
       </div>
       <div class="titleOperation">
           <div class="Operationbutton">
               <div class="Operationbefore">
	               <div class="buttonLogin" onclick="UserLogin()">登录</div>
	               <div class="buttonRegist" onclick="UserRigest()">注册</div>
               </div>
               <div class="Operationlater"></div>
           </div>
          <!--  <div class="OperationSearch">
               <input type="text"  placeholder="搜索比赛" class="OperationSearchBox">
               <div class="SearchPic" onclick="Search_Com()"></div>
           </div> -->
       </div>
    </div>
    
    <!-- 注册框 -->
    <div class="bodymiddleRegist" style="display: none;">
	    <div class="middleFrame">
	        <div class="middleClose" onclick="middleRegistClose()"><i class="iconfont">&#xf00b3;</i></div>
	        <div class="Frameinformation">
		        <div class="Frameinput">
		            <div class="inputPhone">
		                <input type="text" placeholder="电话号码" class="Phonetext">
		            </div>
		            <div class="inputPassword">
		                <input type="password" placeholder="密码" class="Passwordtext">
		            </div>
		            <div class="inputVerification">
		                <input type="text" placeholder="验证码" class="Verficationtext">
		                <input type="button" class="Verificationget" onclick="Verificationget(this)" value="获取验证码 ">
		            </div>
		            <!-- <div class="inputVerification">
		                <select class="Verificationselect">
		                    <option>学习阶段</option>
		                    <option>小学</option>
		                    <option>初中</option>
		                    <option>高中</option>
		                </select>
		            </div> -->
		        </div>
		        
		        <div class="Frameclick">
		              <div class="clickButton">
		                  <button class="ButtonRigest" onclick="Rigester()">注  册</button>
		              </div>
		              <div class="clickText">
		                  <div class="Textask">已经有账户？</div>
		                  <div class="Textlogin" onclick="gotoLoginFrame()">登录</div>
		              </div>
		        </div>
	        </div>
	    </div>
    </div>
    
    <!-- 登录框 -->
    <div class="bodymiddleLogin" style="display: none;">
        <div class="middleFrameLogin">
            <div class="middleClose" onclick="middleLoginClose()"><i class="iconfont">&#xf00b3;</i></div>
            <div class="FrameinformationLogin">
                <div class="Frameinput">
                    <div class="inputAccount">
		                <input type="text" placeholder="手机号/昵称" class="Accounttext">
		            </div>
		            <div class="inputLoginPassword">
		                <input type="password" placeholder="密码" class="LoginPasswordtext">
		            </div>
                </div>
                <div class="Frameclick">
		              <div class="clickButton">
		                  <button class="ButtonRigest" onclick="Login()">登  录</button>
		              </div>
		              
		        </div>
		        
		        <div class="clickText">
		              <div class="Textforget"  onclick="gotofindpassword()">忘记密码</div>
		              <div class="Textask">还未注册账户？</div>
		              <div class="Textlogin" onclick="gotoRigestFrame()">注册</div>
		        </div>
		        
            </div>
        </div>
    </div>
    
    
  </body>
  <script type="text/javascript" src="Common/Tool/city-picker/picker.js"></script>
</html>