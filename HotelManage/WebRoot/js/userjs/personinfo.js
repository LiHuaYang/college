$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	Person_Message_Display();
	Order_Display();
	
	showTransaction(); //显示交易信息
	
	//删除未付款订单
	setInterval(function(){removelocal();},5000);//每隔5秒调用一次removelocal函数
	

});

function top_up() {
	$(".person_money_box").show();
}

function money_move() {
	$(".person_money_box").hide();
}





//个人消息界面打开
function person_chagediv_message() {
	$(".person_chagediv_message").show();
	$(".person_chagediv_oder").hide();
	$(".person_chagediv_info").hide();
	$(".person_chagediv_account").hide();
	$(".person_chagediv_refill").hide();
	
	$(".person_information_leftmenu").show();
}

//个人订单界面打开
function person_chagediv_oder() {
	$(".person_chagediv_oder").show();
	$(".person_chagediv_message").hide();
	$(".person_chagediv_info").hide();
	$(".person_chagediv_account").hide();
	$(".person_chagediv_refill").hide();
	
	$(".person_information_leftmenu").hide();
}

//个人信息界面打开
function person_chagediv_info() {
	$(".person_chagediv_info").show();
	$(".person_chagediv_message").hide();
	$(".person_chagediv_oder").hide();
	$(".person_chagediv_account").hide();
	$(".person_chagediv_refill").hide();
	
	$(".person_information_leftmenu").show();
}
//账号相关界面打开
function person_chagediv_account() {
	$(".person_chagediv_account").show();
	$(".person_chagediv_info").hide();
	$(".person_chagediv_message").hide();
	$(".person_chagediv_oder").hide();
	$(".person_chagediv_refill").hide();
	
	$(".person_information_leftmenu").show();
}

//充值记录界面打开
function person_chagediv_refill() {
	$(".person_chagediv_account").hide();
	$(".person_chagediv_info").hide();
	$(".person_chagediv_message").hide();
	$(".person_chagediv_oder").hide();
	$(".person_chagediv_refill").show();
	
	$(".person_information_leftmenu").show();
}

//更改密码
function password_change() {
	$(".Password_change").show();
}
function password_change_close() {
	$(".Password_change").hide();
}

//显示“更改头像”的框
function change_the_head() {
	$(".person_change_head").show();
	
}

//隐藏“更改头像”的框
function head_move() {
	$(".person_change_head").hide();
	window.location.reload();
}

//显示个人信息
function Person_Message_Display(){
	
	var Username="";
	var Usersex;
	var Username_another;
	var Userbirth="";
	var Userphone="";
	var Useridcard="";
	var Useremail="";
	var Usermessage="";
//	var Userpassword="";
	var Userbalance;
	var Userpicture="";
	var json={
			"UserId":userid,
	}
	
	$.getJSON("./QueryUserExceptPasswordByIdServlet",{json:JSON.stringify(json)},function(json){
		Username=json[0].UserName;
		Userbirth=json[0].UserBoth;
		Userphone=json[0].UserPhone;
		Useremail=json[0].UserEmail;
		Useridcard=json[0].UserIDNumber;
		Usermessage=json[0].UserMessage;
//		alert(json[0].UserPassword)
//		Userpassword=json.result.userPassword;
		Userbalance=json[0].UserBalance;
		Userid=json[0].UserId;
		Userpicture=json[0].UserPicture;
		
		if(json[0].UserSex=="女性"){
			Usersex="女性";
			Usersex_another="男性";
		}
		else{
			Usersex="男性";
			Usersex_another="女性";
		}
		$(".name").html(
			'<div class="name1">姓名:</div>'
			+'<div class="name2">'
				+'<input type="text" class="cc" value="'+Username+'"/>'
			+'</div>'
		);
		
		$(".sex").html(
			'<div class="name1">性别:</div>'
 		    +'<div class="sex2">'
 		   	     +'<select class="sex1">'
 				      +'<option>'+Usersex+'</option>'
 				      +'<option>'+Usersex_another+'</option>'
 			     +'</select>'
 		     +'</div>' 
		);
		

		var i,j,x;
		var s=new Array(),s2=new Array();
		for(i=0;i<Userbirth.length;i++)
		{
			if(Userbirth[i]!='-')
			{
				s[i]=Userbirth[i];
				x=i;
			}
			else
			{
				i=Userbirth.length;
			}
		}
//		alert(s.join(''));
		for(j=x+2;j<Userbirth.length;j++)
		{
			s2[j-x-2]=Userbirth[j];
		}

		
		$(".birth").html(
			'<div class="birth1">生日:</div>'
  		    +'<div class="birth2">'
  		       +' <input type="text" class="month" value="'+s.join('')+'"/>月'
  		       +'<input type="text" class="day" value="'+s2.join('')+'"/>日'
  		    +'</div>'
		);
		
		$(".tel").html(
			'<div class="tel1">电话号码:</div>'
   		    +'<div class="tel2">'
   		  	     +'<input type="text" class="tt"  value="'+Userphone+'"/>'
   		    +'</div>'
		);
		
		$(".email_address").html(
			'<div class="email_address1">电子邮件地址:</div>'
 		    +'<div class="email_address2">'
 			    +'<input type="text" class="ea" value="'+Useremail+'" />'
 		    +'</div>'
		);
		
		$(".idcard").html(
			'<div class="idcard1">身份证号码:</div>'
 		    +'<div class="idcard2">'
 			    +'<input type="text" class="ii"  value="'+Useridcard+'"/>'
 		    +'</div>'
		);
		
		$(".textaa2").html(
   		    '<textarea class="textaa" >'+Usermessage+'</textarea>'
		);
		
		$(".person_information_menu").html(
			'<div class="person_information_picture"></div>'
            +'<div class="menu_choice">'+Username+'</div>'
		);
		
		$(".account_password").html(
//			'<div class="account_name1">密码</div>'
//    		+'<div class="account_pass">'
//    			+'<input type="password" class="account_pass1" value="'+Userpassword+'"/>'
//    		+'</div>' 
    		'<div class="account_word2" onclick="password_change()">更改密码？</div>'
		);
		
		$(".account_rest3").html(
			'<div class="account_name1">余额</div>'
    		+'<div class="account_rest">￥'
    			+'<font id="acc" style="color: ff5a5f;font-weight: bold;">'+Userbalance+'</font>'
    		+'</div>'
    		+'<div class="account_rest4" onclick="top_up()">充值？</div>'
		);
		
		$(".account_name").html(
			'<div class="account_name1">账号</div>'
    		+'<div class="account_name2">'
    			+'<input type="text" class="account_cc" value="'+Useremail+'"/>'
    		+'</div>'
    		+'<div class="account_word1">切换账号？</div>'
		);

		$("#pic2").css({
			"background-image":"url('"+Userpicture+"')",
			"width":"90px",
			"height":"90px",
			"float":"left",
			"margin-left":"20px",
			"border":"solid 5px #ffffff",
			"border-radius":"15px",
			"background-size":"100%",
		});
		
		$(".person_information_picture").css({
			"background":"url('"+Userpicture+"')",
			"width":"150px",
			"height":"150px",
			"border":"solid 5px #ffffff",
			"border-radius":"15px",
			"background-size":"100%",
		});
//		var Userpicture=$(".account_pic2").css('background-image');
//		alert(Userpicture);

	});
}

//修改个人消息
function Change_Person_Message(){
	var Username=$(".cc").val();
//	var Userpassword=$(".account_pass1").val();
	var Usersex=$(".sex1").val();
	var Userphone=$(".tt").val();
	var Useremail=$(".ea").val();
	var Userboth=$(".month").val()+"-"+$(".day").val();
	var Useridnumber=$(".ii").val();
//	var Userbalance=parseInt(document.getElementById("acc").innerHTML);
	var Usermessage=$(".textaa").val();
	
	var json={
		"UserId":userid,
		"UserName":Username,
//		"UserPassword":Userpassword,
		"UserSex":Usersex,
		"UserPhone":Userphone,
		"UserEmail":Useremail,
		"UserBoth":Userboth,
		"UserIDNumber":Useridnumber,
//		"UserBalance":Userbalance,	
		"UserMessage":Usermessage,
	};
	
	
	$.getJSON("./ChangeUserServlet",{json:JSON.stringify(json)},function(json){
		if(json.result==true){
			alert("数据保存成功");
		}
	});
}

var number=0;    //循环次数
var Intarray=new Array();     //订单号
var OrderstateArray=new Array();     //订单状态
var Checkouttime=new Array();      //退房时间
var RoomId=new Array();        //房间号
var OrderMoney=new Array();    //付款金额
var OrderDays=new Array();     //入住时间
var OrderUnPair=JSON.parse(localStorage.getItem("OrderUnPair1"));//get本地数据

//显示订单消息
function Order_Display(){
	page_order=0;
	nowpage_order=0;

	page=0;
	nowpage=0;
	var i;
	var Ordermoney;
	var Roomtype="";
	var Ordertime="";
	var Orderstate="";
	var count_total=0;
	
	var json={
			"UserId":userid,
	};
	$(".orderrecord_box").html("");
	$.getJSON("./GetOrderRoomByUserIdServlet",{json:JSON.stringify(json)},function(json){
	    orderList = json.concat(OrderUnPair);
	   
//		orderList=json;
		
		
		number=orderList.length;
		var max=5;
		if(max>orderList.length)
		{
			max=orderList.length;
		}
		for(i=0;i<max;i++){
			//显示未付款订单（本地数据）
			
			if(orderList[i].OrderState==0){
				if(OrderUnPair!=null){
						var indata=orderList[i].OrderCheckinTime;//入住时间
						var outdata=orderList[i].OrderCheckoutTime;//退房时间
						var people=orderList[i].OrderStayinPeopleNumber;//入住人数
						var roomId=orderList[i].RoomId;
						
						if(orderList[i].roomType==1)
						{
							Roomtype="标间";
						}
						else if(orderList[i].roomType==2)
						{
							Roomtype="单人房";
						}
						else if(orderList[i].roomType==3)
						{
							Roomtype="套房";
						}
						else
						{
							Roomtype="其他";
						}
					    if(userid==orderList[i].OrderUserid){	
					    	$(".orderrecord_box").append(
									'<div class="orderrecord">'
									+'<input type="checkbox" style="float:left;" id="xxx'+count_total+'" class="check_box"/>'
								    +'<div class="orderpic1"  id="'+count_total+'"></div>'
								    +'<div class="ordertypeandname">'
								    	+'<div class="order_name" onclick="gotoinfo(\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">四季青藤'+roomId+'号房</div>'
										+'<div class="orderinfo1">'+Roomtype+'</div>'
									+'</div>'
									+'<div class="user_name">'+orderList[i].OrderUsername+'</div>'
									+'<div class="orderstate1">未付款</div>'
									+'<div class="order_number">'+people+'</div>'
									+'<div class="order_check_all">'
										+'<div class="order_check_in">'+indata+'</div>'
										+'<div class="order_check_out">'+outdata+'</div>'
									+'</div>'
									+'<div class="orderindays">'+orderList[i].OrderStayinDay+'</div>'
									+'<div class="ordertime1">'+orderList[i].OrderTime+'</div>'
									+'<div class="ordermoney1">¥'+orderList[i].OrderMoney+'</div>'		
									+'<div class="otherorder">'
				//						+'<div id="orderbutton1" onclick="gotocomment('+Ordermoney+','+'\''+Ordercommit+'\''+','+'\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">评价</div>'
										
									+'</div>'
									+'</div>'
							);
					    	$(".Commit6").html(
					    			'<button type="button" class="Commit8" onclick="commit_submit('+orderList[i].RoomId+')">提交</button>'
					    		);
					    		$("#"+count_total+"").css({"background-image":"url('"+orderList[i].roomPicture+"')"});		
					        	$(".orderpic1").css({"background-size":"100% 100%"});
					        	count_total++;
					    	}
					}
				 
				
			}
			else if(orderList[i].OrderState!=0){
				var Ordercommit="";
				Intarray[count_total]=orderList[i].OrderId;
				OrderstateArray[count_total]=orderList[i].OrderState;
				Checkouttime[count_total]=orderList[i].OrderCheckoutTime;
				RoomId[count_total]=orderList[i].RoomId;
				OrderDays[count_total]=orderList[i].OrderStayinDay;
				OrderMoney[count_total]=orderList[i].OrderMoney;
				
				var indata=orderList[i].OrderCheckinTime;
				var outdata=orderList[i].OrderCheckoutTime;
				var people=orderList[i].OrderStayinPeopleNumber;
				var roomId=orderList[i].RoomId;
				var username=orderList[i].OrderUsername;
				
//				alert(Checkouttime[i]);
				

				if(orderList[i].room.roomType==1)
				{
					Roomtype="标间";
				}
				else if(orderList[i].room.roomType==2)
				{
					Roomtype="单人房";
				}
				else if(orderList[i].room.roomType==3)
				{
					Roomtype="套房";
				}
				else
				{
					Roomtype="其他";
				}
				
//				if(json[i].OrderState==0)
//				{
//					Orderstate="未付款";
//					Ordercommit="付 款";
//				}
				if(orderList[i].OrderState==1)
				{
					Orderstate="已付款";
				}
				else if(orderList[i].OrderState==4)
				{
					Orderstate="已退房";
					Ordercommit="评 价";
				}
				else if(orderList[i].OrderState==6)
				{
					Orderstate="已退订";
				}
				else if(orderList[i].OrderState==5)
				{
					Orderstate="已续房";
				}
				else{
					Orderstate="其他";
				}

				Ordermoney=orderList[i].OrderMoney;
				Ordertime=orderList[i].OrderTime;
//				if(Ordercommit=="付 款")
//				{
//					$(".orderrecord_box").append(
//						'<div class="orderrecord">'
//						+'<input type="checkbox" style="float:left;" id="xxx'+i+'"/>'
//					    +'<div class="orderpic1"  id="'+i+'"></div>'
//						+'<div class="orderinfo1">'+Roomtype+'</div>'
//						+'<div class="ordermoney1">¥'+Ordermoney+'</div>'
//						+'<div class="ordertime1">'+Ordertime+'</div>'
//						+'<div class="orderstate1">'+Orderstate+'</div>'
//						+'<div class="otherorder">'
//							+'<button id="orderbutton1" onclick="gotoinfo(\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">房间详情</button>'
//							+'<button id="orderbutton2" onclick="gotocomment('+Ordermoney+','+'\''+Ordercommit+'\''+','+'\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">'+Ordercommit+'</button>'
//						+'</div>'
//						+'</div>'
//					);
//				}
				
				if(Ordercommit=="评 价")
				{
					$(".orderrecord_box").append(
							'<div class="orderrecord">'
							+'<input type="checkbox" style="float:left;" id="xxx'+count_total+'" class="check_box"/>'
						    +'<div class="orderpic1"  id="'+count_total+'"></div>'
						    +'<div class="ordertypeandname">'
						    	+'<div class="order_name" onclick="gotoinfo(\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">四季青藤'+roomId+'号房</div>'
								+'<div class="orderinfo1">'+Roomtype+'</div>'
							+'</div>'
							+'<div class="user_name">'+username+'</div>'
							+'<div class="orderstate1">'+Orderstate+'</div>'
							+'<div class="order_number">'+people+'</div>'
							+'<div class="order_check_all">'
								+'<div class="order_check_in">'+orderList[i].OrderCheckinTime+'</div>'
								+'<div class="order_check_out">'+orderList[i].OrderCheckoutTime+'</div>'
							+'</div>'
							+'<div class="orderindays">'+orderList[i].OrderStayinDay+'</div>'
							+'<div class="ordertime1">'+Ordertime+'</div>'
							+'<div class="ordermoney1">¥'+Ordermoney+'</div>'		
							+'<div class="otherorder">'
								+'<div id="orderbutton1" onclick="gotocomment('+Ordermoney+','+'\''+Ordercommit+'\''+','+'\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">评价</div>'
								
							+'</div>'
							+'</div>'
					);
				}
				else{
					$(".orderrecord_box").append(
							'<div class="orderrecord">'
							+'<input type="checkbox" style="float:left;" id="xxx'+count_total+'" class="check_box"/>'
						    +'<div class="orderpic1"  id="'+count_total+'"></div>'
						    +'<div class="ordertypeandname">'
						    	+'<div class="order_name" onclick="gotoinfo(\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">四季青藤'+roomId+'号房</div>'
								+'<div class="orderinfo1">'+Roomtype+'</div>'
							+'</div>'
							+'<div class="user_name">'+username+'</div>'
							+'<div class="orderstate1">'+Orderstate+'</div>'
							+'<div class="order_number">'+people+'</div>'
							+'<div class="order_check_all">'
								+'<div class="order_check_in">'+orderList[i].OrderCheckinTime+'</div>'
								+'<div class="order_check_out">'+orderList[i].OrderCheckoutTime+'</div>'
							+'</div>'
							+'<div class="orderindays">'+orderList[i].OrderStayinDay+'</div>'
							+'<div class="ordertime1">'+Ordertime+'</div>'
							+'<div class="ordermoney1">¥'+Ordermoney+'</div>'		
							+'<div class="otherorder">'
		//						+'<div id="orderbutton1" onclick="gotocomment('+Ordermoney+','+'\''+Ordercommit+'\''+','+'\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">评价</div>'
								
							+'</div>'
							+'</div>'
					);
				}
				
				$(".Commit6").html(
					'<button type="button" class="Commit8" onclick="commit_submit('+roomId+')">提交</button>'
				);
				$("#"+count_total+"").css({"background-image":"url('"+orderList[i].room.roomPicture+"')"});		
		    	$(".orderpic1").css({"background-size":"100% 100%"});
		    	count_total++;
			}
			
		}
		$(".text_number_box").html("");
		page_order=Math.ceil(json.length/4);
		for ( var w = 0; w < page_order; w++) {
			var x=w+1;
			$(".text_number_box").append(
	                '<div id="text_bottom_number" class="text_bottom_number" onclick="changepage_order('+w+')">'+x+'</div>'
			);
		}
		$(".text_number_box").append(
				'<div class="text_bottom_next" onclick="nextpage_order()">▶</div>'
		);
	});
	
}

var page_order=0;
var nowpage_order=0;
//下一页
function nextpage_order() {
	//alert(1);
	if(nowpage_order<page_order-1){
		nowpage_order++;
		changepage_order(nowpage_order);
	}
}

var orderList=new Array();
//改变页面
function changepage_order(num){
	var Roomtype="";
	var Orderstate="";
	var Ordermoney;
	var Ordertime="";
	var count_total=num*4;
	nowpage_order=num;
	var min=num*5;
	var max=num*5+5;
	if (max>number) {
		max=number;
	}
	$(".orderrecord_box").html("");
	for ( var i = min; i <max ; i++) {
		if(orderList[i].OrderState==0){
            if(OrderUnPair!=null){
            	Ordercommit="付 款";
				var indata=orderList[i].OrderCheckinTime;//入住时间
				var outdata=orderList[i].OrderCheckoutTime;//退房时间
				var people=orderList[i].OrderStayinPeopleNumber;//入住人数
				var roomId=orderList[i].RoomId;
				
				if(orderList[i].roomType==1)
				{
					Roomtype="标间";
				}
				else if(orderList[i].roomType==2)
				{
					Roomtype="单人房";
				}
				else if(orderList[i].roomType==3)
				{
					Roomtype="套房";
				}
				else
				{
					Roomtype="其他";
				}
				
			    if(userid==orderList[i].OrderUserid){	
			    	$(".orderrecord_box").append(
							'<div class="orderrecord">'
							+'<input type="checkbox" style="float:left;" id="xxx'+count_total+'" class="check_box"/>'
						    +'<div class="orderpic1"  id="'+count_total+'"></div>'
						    +'<div class="ordertypeandname">'
						    	+'<div class="order_name" onclick="gotoinfo(\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">四季青藤'+roomId+'号房</div>'
								+'<div class="orderinfo1">'+Roomtype+'</div>'
							+'</div>'
							+'<div class="user_name">'+orderList[i].OrderUsername+'</div>'
							+'<div class="orderstate1">未付款</div>'
							+'<div class="order_number">'+people+'</div>'
							+'<div class="order_check_all">'
								+'<div class="order_check_in">'+indata+'</div>'
								+'<div class="order_check_out">'+outdata+'</div>'
							+'</div>'
							+'<div class="orderindays">'+orderList[i].OrderStayinDay+'</div>'
							+'<div class="ordertime1">'+orderList[i].OrderTime+'</div>'
							+'<div class="ordermoney1">¥'+orderList[i].OrderMoney+'</div>'		
							+'<div class="otherorder">'
							+'<div id="orderbutton1" onclick="gotocomment('+orderList[i].OrderMoney+','+'\''+Ordercommit+'\''+','+'\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">付款</div>'
								
							+'</div>'
							+'</div>'
					);
			    	$(".Commit6").html(
			    			'<button type="button" class="Commit8" onclick="commit_submit('+orderList[i].RoomId+')">提交</button>'
			    		);
			    		$("#"+count_total+"").css({"background-image":"url('"+orderList[i].roomPicture+"')"});		
			        	$(".orderpic1").css({"background-size":"100% 100%"});
			        	count_total++;
			    	}
			    
			}
            
           
		}
	    else if(orderList[i].OrderState!=0){
			var Ordercommit="";
			Intarray[count_total]=orderList[i].OrderId;
			OrderstateArray[count_total]=orderList[i].OrderState;
			Checkouttime[count_total]=orderList[i].OrderCheckoutTime;
			RoomId[count_total]=orderList[i].RoomId;
			OrderDays[count_total]=orderList[i].OrderStayinDay;
			OrderMoney[count_total]=orderList[i].OrderMoney;
			var indata=orderList[i].OrderCheckinTime;
			var outdata=orderList[i].OrderCheckoutTime;
			var people=orderList[i].OrderStayinPeopleNumber;
			var roomId=orderList[i].RoomId;
			var username=orderList[i].OrderUsername;
			if(orderList[i].room.roomType==1)
			{
				Roomtype="标间";
			}
			else if(orderList[i].room.roomType==2)
			{
				Roomtype="单人房";
			}
			else if(orderList[i].room.roomType==3)
			{
				Roomtype="套房";
			}
			else
			{
				Roomtype="其他";
			}
			
//			if(orderList[i].OrderState==0)
//			{
//				Orderstate="未付款";
//				Ordercommit="付 款";
//			}
			if(orderList[i].OrderState==1)
			{
				Orderstate="已付款";
			}
			else if(orderList[i].OrderState==4)
			{
				Orderstate="已退房";
				Ordercommit="评 价";
			}
			else if(orderList[i].OrderState==6)
			{
				Orderstate="已退订";
			}
			else if(orderList[i].OrderState==5)
			{
				Orderstate="已续房";
			}
			else{
				Orderstate="其他";
			}

			Ordermoney=orderList[i].OrderMoney;
			Ordertime=orderList[i].OrderTime;
			
			if(Ordercommit=="评 价")
			{
				$(".orderrecord_box").append(
						'<div class="orderrecord">'
						+'<input type="checkbox" style="float:left;" id="xxx'+count_total+'" class="check_box"/>'
					    +'<div class="orderpic1"  id="'+count_total+'"></div>'
					    +'<div class="ordertypeandname">'
					    	+'<div class="order_name" onclick="gotoinfo(\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">四季青藤'+roomId+'号房</div>'
							+'<div class="orderinfo1">'+Roomtype+'</div>'
						+'</div>'
						+'<div class="user_name">'+username+'</div>'
						+'<div class="orderstate1">'+Orderstate+'</div>'
						+'<div class="order_number">'+people+'</div>'
						+'<div class="order_check_all">'
							+'<div class="order_check_in">'+orderList[i].OrderCheckinTime+'</div>'
							+'<div class="order_check_out">'+orderList[i].OrderCheckoutTime+'</div>'
						+'</div>'
						+'<div class="orderindays">'+orderList[i].OrderStayinDay+'</div>'
						+'<div class="ordertime1">'+Ordertime+'</div>'
						+'<div class="ordermoney1">¥'+Ordermoney+'</div>'		
						+'<div class="otherorder">'
							+'<div id="orderbutton1" onclick="gotocomment('+Ordermoney+','+'\''+Ordercommit+'\''+','+'\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">评价</div>'
							
						+'</div>'
						+'</div>'
				);
			}
			else{
				$(".orderrecord_box").append(
						'<div class="orderrecord">'
						+'<input type="checkbox" style="float:left;" id="xxx'+count_total+'" class="check_box"/>'
					    +'<div class="orderpic1"  id="'+count_total+'"></div>'
					    +'<div class="ordertypeandname">'
					    	+'<div class="order_name" onclick="gotoinfo(\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">四季青藤'+roomId+'号房</div>'
							+'<div class="orderinfo1">'+Roomtype+'</div>'
						+'</div>'
						+'<div class="user_name">'+username+'</div>'
						+'<div class="orderstate1">'+Orderstate+'</div>'
						+'<div class="order_number">'+people+'</div>'
						+'<div class="order_check_all">'
							+'<div class="order_check_in">'+orderList[i].OrderCheckinTime+'</div>'
							+'<div class="order_check_out">'+orderList[i].OrderCheckoutTime+'</div>'
						+'</div>'
						+'<div class="orderindays">'+orderList[i].OrderStayinDay+'</div>'
						+'<div class="ordertime1">'+Ordertime+'</div>'
						+'<div class="ordermoney1">¥'+Ordermoney+'</div>'		
						+'<div class="otherorder">'
	//						+'<div id="orderbutton1" onclick="gotocomment('+Ordermoney+','+'\''+Ordercommit+'\''+','+'\''+indata+'\''+','+'\''+outdata+'\''+','+people+''+','+roomId+')">评价</div>'
							
						+'</div>'
						+'</div>'
				);
			}
			
			$(".Commit6").html(
				'<button type="button" class="Commit8" onclick="commit_submit('+roomId+')">提交</button>'
			);
			$("#"+count_total+"").css({"background-image":"url('"+orderList[i].room.roomPicture+"')"});		
	    	$(".orderpic1").css({"background-size":"100% 100%"});
	    	count_total++;
		}

		
	}
}

//删除未付款订单
function removelocal() {
	
	for(var i=0;i<OrderUnPair.length;i++){
		var OrderTime=OrderUnPair[i].OrderTime;
		
		var date1 = new Date(OrderTime);
		var date2 = new Date();//获取当前时间
		var s1 = date1.getTime(),s2 = date2.getTime();
		var total = (s2 - s1)/1000;
		var day = parseInt(total / (24*60*60));//计算整数天数
		var afterDay = total - day*24*60*60;//取得算出天数后剩余的秒数
		var hour = parseInt(afterDay/(60*60));//计算整数小时数
		var afterHour = total - day*24*60*60 - hour*60*60;//取得算出小时数后剩余的秒数
		var min = parseInt(afterHour/60);//计算整数分
		var totaltime=day*24+hour*60+min; //天+小时+分钟（单位/秒）
		
	    if(totaltime>=30){
	    	
	    	OrderUnPair.splice(i,1);
	    	localStorage.setItem( "OrderUnPair1", JSON.stringify(OrderUnPair));
	    	Order_Display();
	    }
    }
}





function gotocomment(Ordermoney,r,indata,outdata,people,roomId) {
	if(r=="评 价"){
		$(".Commit").show();
	}
	else{
		var roomtotalMoney=Ordermoney;
		window.location.href="jsp/userjsp/pay.jsp?roomtotalMoney="+roomtotalMoney+"&indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid;
	}
}

function gotoinfo(indata,outdata,people,roomId) {
	window.location.href="jsp/userjsp/home.jsp?indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid;
}


//关闭提交框
function Close_Commit(){
	$(".Commit").hide();
}

//提交评论
function commit_submit(roomId) {
	var RoomCommitContent=$(".Commit7").val();
	if(RoomCommitContent!=null){
		var json={
				"RoomId":roomId,
				"UserId":userid,
				"RoomCommitContent":RoomCommitContent,
				"RoomCommitRank":5
		}
		
		$.getJSON("./CreateRoomCommitServlet",{json:JSON.stringify(json)},function(json){
			if(json.result==true){
				alert("评论成功!");
			}
			else{
				alert("评论失败!");
			}
		});
	}
	else{
		alert("评论信息不能为空");
	}
	$(".Commit").hide();
}

//退房
function Check_Out(){
	//alert(1);
	var OrderState="已退房";    //4为已退房状态
    
	for ( var i = 0; i < number; i++) {
		
		var json={
				"OrderId":Intarray[i],
				"OrderState":4,
		};
		
		if($("#xxx"+i+"").attr("checked")=="checked"||$("#sss"+i+"").attr("checked")=="checked"){
			if(OrderstateArray[i]==0||OrderstateArray[i]==4||OrderstateArray[i]==6)
			{
				alert("无法退房");
			}
			else{
				$.getJSON("./ChangeOrderStateServlet",{json:JSON.stringify(json)},function(json){
//					window.location.href="jsp/userjsp/personinfo.jsp";
					alert(OrderState);
					$(".orderrecord_box").html("");
					Order_Display();
				});
			}
		}
	}
}



//退订
function Cancel_Order1(){
	
var OrderState="已退订";    //6为已退订状态
    
	for ( var i = 0; i < number; i++) {

		var json={
				"OrderId":Intarray[i],
				"OrderState":6,
		};
		
		if($("#xxx"+i+"").attr("checked")=="checked"){
			if(OrderstateArray[i]==0||OrderstateArray[i]==4||OrderstateArray[i]==6)
			{
				alert("无法退订");
			}
			else
			{
				
				$.getJSON("./ChangeOrderStateServlet",{json:JSON.stringify(json)},function(json){
//						window.location.href="jsp/userjsp/personinfo.jsp";
//						alert(OrderState);	
						$(".orderrecord_box").html("");
						Order_Display();
				});
			}
		}
	}
}



//显示续住界面
function Show_Continue_Order(){
	$(".Continue_Order").show();
}

//关闭续住界面
function Close_Continue_Order(){
	$(".Continue_Order").hide();
}

var OrderCheckOutTime;
var OrderCheckOutTemp;    //退房日期减1
var Ordernewday;
var OrderCheckOutTime_Old;   //旧的退房日期
//续房（获取参数进行续房）
function getRoomPrice(RoomPrice,RoomId){
	var OrderState="已续房";
	Ordernewday=parseInt($(".Continue_Order4").val());
	var SpiltCheckOutTime="";
	
	for ( var i = 0; i < number; i++) {
		if($("#xxx"+i+"").attr("checked")=="checked"){
			OrderCheckOutTime_Old=Checkouttime[i];
			/*更新退房日期*/
			SpiltCheckOutTime=Checkouttime[i].split("-");   //字符串拆分
			var date=new Date(SpiltCheckOutTime);            //把旧的退房日期当做当天日期
			date.setDate(parseInt(SpiltCheckOutTime[2])+Ordernewday);    //加上续房的天数
			var day=(date.getDate()).toString();                      //获得年月日的字符串类型
			var month=(date.getMonth()+1).toString();
			var year=(date.getFullYear()).toString();
			OrderCheckOutTime=year+"-"+month+"-"+day;
			
			var date_temp=new Date(SpiltCheckOutTime);            
			date_temp.setDate(parseInt(SpiltCheckOutTime[2])+Ordernewday-1); 
			var day_temp=(date_temp.getDate()).toString();             
			var month_temp=(date_temp.getMonth()+1).toString();
			var year_temp=(date_temp.getFullYear()).toString();
			OrderCheckOutTemp=year_temp+"-"+month_temp+"-"+day_temp;
			
			var a=Judge(RoomId,OrderCheckOutTime);
			if( a==false ){
				alert("不满足续房条件");
			}
			else{
				;
			}
		}
	}	
}


var RoomPrice;
//续房（获得房间单价）
function Continue_Order(){
	for ( var i = 0; i < number; i++) {
		if($("#xxx"+i+"").attr("checked")=="checked"){
			if(OrderstateArray[i]==0||OrderstateArray[i]==4||OrderstateArray[i]==6)
			{
				$(".Continue_Order").hide();
				alert("无法续房");
			}
			else
			{
				var Room=RoomId[i];
				var json={
						"RoomId":RoomId[i],
				};
				$.getJSON("./GetRoomDetailServlet",{json:JSON.stringify(json)},function(json){
						RoomPrice=json.result.Room.roomUnitPrice;
						getRoomPrice(RoomPrice,Room);						
				});
			}		
		}
	}
}

//判断是否符合续房条件(从旧的退房日期开始到新的退房日期的前一天不能是其他客户这个房间的入住日期)
function Judge(RoomId,OrderCheckOutTime){
	var OrderCheckInTime="";
	var json={
		"RoomId":RoomId,
	};
	$.getJSON("./GetOrderByRoomServlet",{json:JSON.stringify(json)},function(json){
		for(var i=0;i<json.length;i++){
			OrderCheckInTime=json[i].orderCheckinTime;      //获得其他客户这个房间的入住时间
			
			var SplitCheckOutOld=OrderCheckOutTime_Old.split("-");  
			var data_in=new Date(OrderCheckInTime.split("-"));       //其他客户这个房间的入住时间
			var data_temp=new Date(OrderCheckOutTemp.split("-"));   //新的退房时间的前一天
			var data_old=new Date(SplitCheckOutOld);     //原来的退房时间
			var second=data_old.getTime();
			
//			alert(data_temp.getTime())
//			alert(data_in.getTime())
			while(second!=(data_temp.getTime()+86400000))
			{
//				alert(second)
				if( second==data_in.getTime() ){
					alert("不满足续房条件");
					$(".Continue_Order").hide();
					return false;
				}
				else{      
//					alert(1)				
					second=second+86400000;
				}
			}
		}
		judge_final();
	});
}


function judge_final(){
	for ( var i = 0; i < number; i++) {
		if($("#xxx"+i+"").attr("checked")=="checked"){
			var json={
					"OrderId":Intarray[i],
					"increaseDay":Ordernewday,
					"OrderCheckoutTime":OrderCheckOutTime,
					"OrderMoney":OrderMoney[i]+RoomPrice*Ordernewday,
			};
			$.getJSON("./UserContinuedRoomServlet",{json:JSON.stringify(json)},function(json){
					$(".Continue_Order").hide();    //关闭续房框
					alert("已续房");
					$(".orderrecord_box").html("");
					Order_Display();
			});
		}
	}
}


var commitlist=new Array();
var Transactionpage=0;
var refillpage=0;
//显示交易记录信息
function showTransaction() {
	var json={
			"UserId":userid
	}
	$.getJSON("./GetQuerybyuseridServlet",{json:JSON.stringify(json)},function(json){
		commitlist=json;
		var max=8;
		if(json.length<max){
			max=json.length;
		}
		for(var i=0;i<max;i++){
			var transactionMoney=0;
			transactionMoney=json[i].transactionMoney;//交易金额
		    var transactionDetail=json[i].transactionDetail; //交易详情
			var transactionTime=json[i].transactionTime; //时间
			var transactionState="";//状态
			if(json[i].transactionState==1){
				transactionState="交易成功";
			}
			else{
				transactionState="交易失败";
			}
				
			$(".chagediv_refill_table_td_box").append(
					'<div class="chagediv_refill_table_td">'+
					'<div class="refill_table_td_time"><div>'+transactionTime+'</div></div>'+
       	            '<div class="refill_table_td_message">'+transactionDetail+' </div>'+
       	            '<div class="refill_table_td_money" id="'+i+'">'+transactionMoney+'</div>'+
       	            '<div class="refill_table_td_state">'+transactionState+'</div>'+
       	            '</div>'
					);
			
			if(transactionMoney>=0){
				$(".refill_table_td_money").eq(i).attr("style","color:#FF5A5F;");
			}
			else{
				$(".refill_table_td_money").eq(i).attr("style","color:#00796B;"); 
			}
		}
		Transactionpage=Math.ceil(json.length/8);
		$(".refill_text_bottom_number_box").append(
				' <div id="text_bottom_number" class="text_bottom_number" onclick="changerefillpage('+0+')">1</div>'
		);
		for(var i=1;i<Transactionpage;i++){
			var x=i+1;
			$(".refill_text_bottom_number_box").append(
					' <div id="text_bottom_number" class="text_bottom_number" onclick="changerefillpage('+i+')">'+x+'</div>'
					);
		}
	});
}

//交易记录下一页
function refill_nextpage() {
	//alert(1);
	if(refillpage<Transactionpage-1){
		refillpage++;
		changerefillpage(refillpage);
	}
}

//改变交易记录页码
function changerefillpage(number) {
	refillpage=number;
	var min=number*8;
	var max=number*8+8;
	if (max>commitlist.length) {
		max=commitlist.length;
	}
	$(".chagediv_refill_table_td_box").html("");
	 for ( var i = min; i <max ; i++) {
		 var transactionMoney=0;
			transactionMoney=commitlist[i].transactionMoney;//交易金额
		    var transactionDetail=commitlist[i].transactionDetail; //交易详情
			var transactionTime=commitlist[i].transactionTime; //时间
			var transactionState="";//状态
			if(commitlist[i].transactionState==1){
				transactionState="交易成功";
			}
			else{
				transactionState="交易失败";
			}
				
			$(".chagediv_refill_table_td_box").append(
					'<div class="chagediv_refill_table_td">'+
					'<div class="refill_table_td_time"><div>'+transactionTime+'</div></div>'+
    	            '<div class="refill_table_td_message">'+transactionDetail+' </div>'+
    	            '<div class="refill_table_td_money" id="'+i+'">'+transactionMoney+'</div>'+
    	            '<div class="refill_table_td_state">'+transactionState+'</div>'+
    	            '</div>'
					);
			
			if(transactionMoney>=0){
				$(".refill_table_td_money").eq(i).attr("style","color:#FF5A5F;");
			}
			else if(transactionMoney<0){
				$(".refill_table_td_money").eq(i).attr("style","color:#00796B;");
				$("#"+i+"").css("color","#00796B"); 
			}
	 }
	$(".refill_text_bottom_number_box").html("");
		 
		 for ( var i = 0; i < Transactionpage; i++) {
			 var x=i+1;
			 if (i==number) {
				 $(".refill_text_bottom_number_box").append(
							'<div id="text_bottom_number" class="text_bottom_number" onclick="changerefillpage('+i+')">'+x+'</div>'
					);
				}else {
					$(".refill_text_bottom_number_box").append(
							' <div id="text_bottom_number" class="text_bottom_number" onclick="changerefillpage('+i+')">'+x+'</div>'
							);
				}
		 }
	}

