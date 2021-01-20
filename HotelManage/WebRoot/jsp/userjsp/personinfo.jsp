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
    
    <title>My JSP 'personinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/usercss/personinfo.css">
		<script type="text/javascript" src="js/common/jq.js"></script>
		<link href="uploadify/uploadify.css" rel="stylesheet" type="text/css" />
        <script src="uploadify/jquery.uploadify.js" type="text/javascript"></script>
        
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xTGYDhxlbHjfvpB4CsrtxvsA"></script>
		<script type="text/javascript" src="js/userjs/personinfo.js"></script>
        <script type="text/javascript">
        
        
            var roomId="<%=roomId%>";
            var roomtotalMoney="<%=roomtotalMoney%>";
            var people="<%=people%>";
            var indata="<%=indata%>";
            var outdata="<%=outdata%>";
            var userid=<%=userid%>;
           
            
        
        $(function () {
            $("#uploadify").uploadify({
                //指定swf文件
                'swf': 'uploadify/uploadify.swf',
                //后台处理的页面
                'uploader': '../../upload',
                //按钮显示的文字
                'buttonText': '上传图片',
                //显示的高度和宽度，默认 height 30；width 120
                //'height': 15,
                //'width': 80,
                //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
                //在浏览窗口底部的文件类型下拉菜单中显示的文本
                'fileTypeDesc': 'Image Files',
                //允许上传的文件后缀
                'fileTypeExts': '*.gif; *.jpg; *.png',
                //发送给后台的其他参数通过formData指定
                //'formData': { 'someKey': 'someValue', 'someOtherKey': 1 },
                //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
                //'queueID': 'fileQueue',
                //true为选择文件后自动上传,false则需要用到上传和取消上传
                'auto': false,
                //设置为true将允许多文件上传
                'multi': true,
                //上传文件成功后执行的代码
                'onUploadSuccess':function(file,data,response){
                array=jQuery.parseJSON(localStorage.getItem("OrderUnPair1"));
                
                   var json = eval("(" + data + ")");  //转换为json格式
                   var userpic=json.url;
                   var json={
                       "UserId":userid,
                       "UserPicture":userpic
                   }
                   $.getJSON("./ChangeUserPicServlet",{json:JSON.stringify(json)},function(json){
		               if(json.result==flase){
			           alert("数据保存失败");
		           }
	               });
                }
            });
        });
    
         
    </script>
  </head>
  
  <body>
    <div class="all">
        <div class="heads"></div>
        <div class="head_under">
        	<div class="head_under_imform" onclick="person_chagediv_info()">个人信息</div>
        	<div class="head_under_order" onclick="person_chagediv_oder()">个人订单</div>
        	<div class="head_under_mess" onclick="person_chagediv_message()">个人消息</div>
        	<div class="head_under_account" onclick="person_chagediv_account()">账号相关</div>
        	<div class="head_under_refill" onclick="person_chagediv_refill()">交易记录</div>
        	<!-- <div class="head_under_consum" >消费记录</div> -->
        </div>
        <div class="person_background">
        <div class="person_background_box">
            
                <div class="person_information_box">
                  <center>
                    <div class="person_information_leftmenu">
                            <div class="person_information_menu">
                            </div>
                        
                        <div class="person_test">
                            <div class="person_test_name">验证项</div>
                            <div class="test_same"><i class="iconfont" id="test_adress">&#xf00b2</i>电子邮件验证</div>
                            <div class="test_same"><i class="iconfont" id="test_adress">&#xf00b2</i>电话号码验证</div>
                        </div>
                    </div>
                    </center>
                    
                    <div class="person_chagediv">
                       <!-- <input type="button" onclick="button()" value="充值"> -->
                       
                       <!-- 个人信息div -->
                       <div class="person_chagediv_info"> 
                           <div class="chagediv_info_title">个人信息</div>
                           <div class="chagediv_info_box">
                              <div class="name">
                    		                 
                    	      </div>
                    	      <!-- <p class="p1">*仅当您和另一名用户确认预订时，此资料才会被分享</p> -->
                    	      <div class="sex">
                    		                        		
                    	      </div>
                    		   <!-- <p class="p1">*此数据仅用于分析，我们不会透露给其它用户。</p>-->
                    		  <div class="birth">
                    		                
                    	      </div>
                    	       <!-- <p class="p1">*此数据仅用于分析，我们不会透露给其它用户。</p>-->
                    	      <div class="tel">
                    		     
                    	      </div>
                    		   <!-- <p class="p1">*这是我们帮助大家联系彼此的方式。</p>  -->
                    	      <div class="email_address">
                    		       
                    	       </div>
                    	        <!-- <p class="p1">*我们不会向其他Airbnb用户透露您的个人电子邮件地址。</p>-->
                    	       <div class="idcard">
                    		       
                    	       </div>
                    		  <!-- <p class="p1">*该信息不会被泄露,请放心填写</p>  -->
                    	   </div>
                    	   
                    	   
                    	   <div class="chagediv_info_myselfe">
                    	      <div class="tel4">
                    		      <div class="tel3">自我简介:</div>
                    	      </div>  
                    	     <div class="textaa2">
                    	     </div> 
                    	      <div class="save">
                    		      <div class="bu1">
                    			      <button type="button" class="bu" onclick="Change_Person_Message()">保存</button>
                    		      </div>
                    	      </div> 
                    	   </div>
                       </div>
                       
                        <!-- 个人订单div -->
                       <div class="person_chagediv_oder" style="display: none;">
                        <div class="ooder">
                            <div class="order_title">个人订单</div>
                            <div class="orderbut">
                            	<button class="orderbut1">删除</button>
                        	    <button class="orderbut1" onclick="Check_Out()">退房</button>
                        	    <button class="orderbut1" onclick="Cancel_Order1()">退订</button>
                        	    <button class="orderbut1" onclick="Show_Continue_Order()">续住</button>
                            </div>
                            <div class="ordersearch">
    					        <select>
						            <option>全部订单</option>
						            <option>待付款订单</option>
						            <option>已付款订单</option>
    				            </select>
    				        </div>
    				    </div>
    				    <div class="orderlist">
    				    	<div class="orderpic"></div>
    					    <div class="orderinfo">房间信息</div>
    					    <div class="orderperson">预订人</div>
    					    <div class="orderstate">状态</div>
    					    <div class="orderinperson">入住人数</div>
    					    <div class="orderinorouttime">住/退时间</div>
    					    <div class="orderdays">入住天数</div>
    					    <div class="ordertime">下单时间</div>
    					    <div class="ordermoney">金额（元）</div>
    					    <div class="ordermore">操作</div>
    				    </div>
    				    <!-- 评价 -->
    				    <div class="Commit" style="display: none;">
    				    	<div class="Commit1">
    				    		<div class="Commit2">评价：</div>
    				    		<div class="Commit3" onclick="Close_Commit()"><i class="iconfont" id="Commit4">&#xf00b3</i></div>
    				    	</div>
    				    	<div class="Commit5">
    				    		<textarea class="Commit7"></textarea>
    				    	</div>
    				    	<div class="Commit6">
    				    		
    				    	</div>   	
    				    </div>
    				    <!-- 续住 -->
    				    <div class="Continue_Order" style="display: none;">
    				    	<div class="Continue_Order1">
    							<div class="Continue_Order2">续住天数:</div>
    							<div class="Continue_Order3">
    								<input type="text" class="Continue_Order4"/>
    							</div>
	    					</div>
	    					<div class="Continue_Order5">
    							<div class="true" onclick="Continue_Order()"><i class="iconfont" id="true1" >&#xf00b2</i></div>
    							<div class="false" onclick="Close_Continue_Order()"><i class="iconfont" id="false1">&#xf00b3</i></div>
	    					</div>
    				    </div>
    				    <div class="ordermain">
    					    <!--  <i class="iconfont" id="ordertype">&#xf0130;</i>-->
    					    <!--暂无订单-->
    					  
    					    <div class="orderrecord_box">
    					    	
    					    </div>
    					 
    				    </div>
    				       <div class="text_number_box">
	                       
   	                       		
   	                       </div>
    				   </div>
                       
                       <center>
                       <!-- 个人消息div -->
                       <div class="person_chagediv_message" style="display: none;">
                           <div class="msgtitle">
                    	   	   <div class="msgtitle-all">全部消息</div>
                    		   <div class="msgtitle-unread">未读消息(2)</div>
                    	   </div>
                    	   <div class="msgmain">
                    	   <%for(int i=0;i<4;i++){ %>
                    	       <div class="msgrecord">
                    	 		   <div class="msgpicture"><i class="iconfont" style="font-size: 20px;color: #F88000">&#xf0138;</i></div>
                    	 		   <div class="msgtxt">光棍节福利来咯 快来看看</div>
                    	 		   <div class="msgtime">2015-11-9</div>
                    	 		   <div class="msgstate">未读</div>
                    	       </div>
                    	    <%} %>
                    	    <%for(int i=0;i<3;i++){ %>
                    	 	   <div class="msgrecord">
                    	 		   <div class="msgpicture"><i class="iconfont" style="font-size: 20px;">&#xf0138;</i></div>
                    	 		   <div class="msgtxt">双十一购物券免费领啦</div>
                    	 		   <div class="msgtime">2015-11-3</div>
                    	 		   <div class="msgstate">已读</div>
                    	 	   </div>
                    	    <%} %>
                    	    </div>
	                        <!-- <i class="iconfont" id="msgtype">&#xf0138;</i>还没有新消息哦~ -->
	                        <div class="orderbottom">
		    				   <button disabled="true">首页</button>
		    				   <button disabled="true">上一页</button>
		    				 	   1/1
		    				   <button disabled="true">下一页</button>
		    				   <button disabled="true">末页</button>
	    				    </div>
	    			    </div>
	    			    
	    			    <!-- 账户相关界面 -->
	    			    
	    			    <div class="person_chagediv_account" style="display: none;">
	    					<div class="chagediv_info_title">账号相关</div>
	    					
	    					<div class="account_name">
                    			 
                    		</div>
                    		<div class="account_in1">                  			
                    				<p class="account_p1">*该账号不能更改</p>
                    		</div>
                    		<div class="account_password">
                    			
                    		</div>
                    		<div class="account_in1">                  			
                    				<p class="account_p1">*不要将密码随便泄露给他人</p>
                    		</div>
                    		<div class="account_pic">
                    			<div class="account_pic1">头像</div>
    							<div class="account_pic2" id="pic2"></div>
    							<div class="account_pic3" onclick="change_the_head()">更改头像？</div>
                    		</div>
                    		<div class="account_rest3">
                    			
                    		</div>
                    	</div>
                    	</center>
	    					
	    					<!-- 更改密码界面 -->
	    					<div class="Password_change" style="display: none;">
	    						<div class="old_password">
	    							<div class="old_password1">旧密码:</div>
	    							<div class="account_pass">
	    								<input type="text" class="account_pass2"/>
	    							</div>
	    						</div>
	    						<div class="old_password">
	    							<div class="old_password1">新密码:</div>
	    							<div class="account_pass">
	    								<input type="text" class="account_pass3"/>
	    							</div>
	    						</div>
	    						<div class="old_password">
	    							<div class="again">再次输入:</div>
	    							<div class="account_pass">
	    								<input type="text" class="again1"/>
	    							</div>
	    						</div>
	    						<div class="old_password">
	    							<div class="true"><i class="iconfont" id="true1">&#xf00b2</i></div>
	    							<div class="false" onclick="password_change_close()"><i class="iconfont" id="false1">&#xf00b3</i></div>
	    						</div>
	    					</div>
                    		
                    	
                    	
                    	<!-- 充值记录界面 -->
                        <div class="person_chagediv_refill" style="display: none;">
                            <div class="chagediv_refill_title_box"> 
                       	        <div class="chagediv_refill_title">充值记录</div>
                       	        <div class="chagediv_refill_data">
                       	            <div class="refill_data_year">一年</div>
                       	            <div class="refill_data_threemon">3个月</div>
                       	            <div class="refill_data_month">一个月以前</div>
                       	            <div class="refill_data_today">今天</div>
                       	        </div>
	                       	        
                       	    </div>
                       	   
	                       	<div class="chagediv_refill_table">
	                       	    <div class="chagediv_refill_table_th">
	                       	        <div class="refill_table_time">创建时间</div>
	                       	        <div class="refill_table_message">详情</div>
	                       	        <div class="refill_table_money">金额(元)</div>
	                       	        <div class="refill_table_state">状态</div>
	                       	    </div>
	                       	    <div class="chagediv_refill_td">
	                       	        <div class="chagediv_refill_table_td_box">
	                       	        </div>
                       	        </div>
                       	        <div class="refill_text_number_box">
   	                        		<div class="refill_text_bottom_number_box"></div>
   	                       		    <div class="refill_text_bottom_next" onclick="refill_nextpage()">▶</div>
   	                		    </div>
                   			 </div>
	            		</div>
                
                
               
                
                
                
                <!-- 充值的框 -->
                <div class="person_money_box" style="display: none;">
                    <i class="iconfont" id="money_move" onclick="money_move()">&#xf0204</i>
                    <input class="person_account_name" placeholder="充值账号">
                    <input class="person_money_name" placeholder="充值金额">
                    <div class="person_way_box">
                        <div class="person_way_name_box">
                            <div class="person_way_name">充值方式</div>
                        </div>
                        <div class="way_image_box">
                           <div class="zhifubao"></div>
                           <div class="weixin"></div>
                           <div class="yinhangka"></div>
                        </div>
                    </div>
                    <div class="modal-cell-registerbutton"><button>充值<tton></div>
                </div>
                
                <!-- 更改头像 -->
                <div class="person_change_head" style="display: none;">
                 <i class="iconfont" id="money_move" onclick="head_move()">&#xf0204</i>
                 <%--用来作为文件队列区域--%>
                    <div id="fileQueue">
                    </div>
                    <div>
                        <input type="file" name="uploadify" id="uploadify" />
                        <p>
                  			<a href="javascript:$('#uploadify').uploadify('upload')">上传</a>| 
            				<a href="javascript:$('#uploadify').uploadify('cancel')">取消上传</a>
        				</p>
                    </div>
                </div>
        </div>    
        </div>
    </div>
   
  </div>
   <div class="blackbar" style="display: none;" ></div>
  </div>
  </body>
</html>
