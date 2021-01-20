

$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	showdata();
	
	
});



//显示当前日期
function shownowTime(){
	
}

//显示数据
var numberval=0;
var roomType=0;
var roomPicture="";
var roomNumber=0
function showdata() {
	
	var json={
			"RoomId":roomId,
	}
	
	
	
	$.getJSON("./GetRoomDetailServlet",{json:JSON.stringify(json)},function(json){
		roomType=json.result.Room.roomType;
		roomPicture=json.result.Room.roomPicture
		roomNumber=json.result.Room.roomNumber;
		$(".pic").css({"background-image":"url('"+roomPicture+"')"});
		$(".pic").css({"background-size":"100% 100%"});
		
		$(".word_box").html(
				'<div class="word1">四季青藤'+roomNumber+'号房间</div>'
				+'<div class="word2">浙江, 宁波</div>'
				);
		indata1=indata.split("-");
		outdata1=outdata.split("-");
		var indata2=parseFloat(indata1[2]);
		var outdata2=parseFloat(outdata1[2]);
		numberval=outdata2-indata2;
		
		$(".word4_inword4_box").html(
				'<div class="inword4_2">晚数</div>'
				+'<div class="inword4_4">'+numberval+'</div>'
				)
		$(".word4_price1_box").html(
				'<div class="price1">￥'+json.result.Room.roomUnitPrice+'x'+numberval+'晚</div>'
				+'<div class="price2">￥'+roomtotalMoney+'</div>'	
		);
		
	});
}




var array=new Array();
var initializationTime=(new Date()).getTime();//获得当前时间,刻度为一千分一秒
//付款按钮
function button() {
	
	var OrderState;
	var OrderMoney=parseFloat(roomtotalMoney);//总的金额,转换成float类型
	
	//入住人数
	var roomUsernumber1=people.substring(0,people.length-3);
	var OrderStayinPeopleNumber=parseFloat(roomUsernumber1);
	
	/******显示日期*******/
	var now=new Date();
	var year=now.getFullYear();
	var month=now.getMonth();
	var month2=month+1;
	var day=now.getDate();
	var hours=now.getHours();
	var minutes=now.getMinutes();
	var seconds=now.getSeconds();
	if(month<10){
		var month1="0"+month2;
	}
	else{
		var month1=month2;
	}
	if(day<10){
		var day1="0"+day;
	}
	else{
		var day1=day;
	}
	if(hours<10){
		var hours1="0"+hours;
	}
	else{
		var hours1=hours;
	}
	if(minutes<10){
		var minutes1="0"+minutes;
	}
	else{
		var minutes1=minutes;
	}
	if(seconds<10){
		var seconds1="0"+seconds;
	}
	else{
		var seconds1=seconds;
	}
	var nowtime=""+year+"-"+month1+"-"+day1+" "+hours1+":"+minutes1+":"+seconds1+"";
	
	var OrderUsername=$("#OrderUsername").val();//入住用户姓名
	
	var OrderUserphon=$("#OrderUserphon").val();//入住用户电话
	var OrderUserIDnumber=$("#OrderUserIDnumber").val();//入住用户身份证号
	
	
	
	if(OrderUsername==""||OrderUserphon==""||OrderUserIDnumber==""){
		alert("预定信息不可为空！");
	}
	else {
	
	
		
		if (confirm("确定付款吗?")){
			if(true){
				   var json={
							"OrderStayinDay":numberval,  //入住天数
							"OrderStayinPeopleNumber":OrderStayinPeopleNumber,  //入住人数
							"OrderCheckinTime":indata,  //入住时间
							"OrderCheckoutTime":outdata,  //退房时间
							"OrderMoney":OrderMoney,   //总金额
							"OrderState":1,   //订单状态
							"UserId":userid,   //用户id
							"RoomId":roomId,   //房间id
							"OrderUsername":OrderUsername,   //入住用户名字
							"OrderUserphon":OrderUserphon,   //入住用户电话
							"OrderUserIDnumber":OrderUserIDnumber   //入住用户身份证号码
					}
	
					$.getJSON("./CreateOrderServlet",{json:JSON.stringify(json)},function(json){
						
						if(json.result==true){
							alert("订单支付成功,请到个人信息页面查看");
						}
					});
				   
				   CreateTransaction(OrderMoney);
			}
		}
		else{
			
			var OrderUnPair={
					"OrderStayinDay":numberval,  //入住天数
					"OrderStayinPeopleNumber":OrderStayinPeopleNumber,  //入住人数
					"OrderCheckinTime":indata,  //入住时间
					"OrderTime":nowtime,  //下单时间
					"OrderCheckoutTime":outdata,  //退房时间
					"OrderMoney":OrderMoney,   //总金额
					"OrderState":0,   //订单状态
					"RoomId":roomId,   //房间id
					"OrderUsername":OrderUsername,   //入住用户名字
					//"OrderUserphon":OrderUserphon,   //入住用户电话
					//"OrderUserIDnumber":OrderUserIDnumber,   //入住用户身份证号码
					"roomPicture":roomPicture,  //此房间图片
					"roomType":roomType,   //房间类型
					"OrderUserid":userid,   //用户id
					"Minutes":minutes1   //分钟
			}
			
			
			array=jQuery.parseJSON(localStorage.getItem("OrderUnPair1"));
			//alert(array);
			if(array==null){
				array=new Array();
			}
			array.push(OrderUnPair);
			localStorage.setItem( "OrderUnPair1", JSON.stringify(array));
			alert("您有未付款成功的订单,请到个人信息页面查看");
			
			
		}
		window.location.href="jsp/userjsp/personinfo.jsp?indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid+"&roomtotalMoney="+roomtotalMoney;
	}
}

function CreateTransaction(OrderMoney) {
	var TransactionDetail="四季青藤"+roomNumber+"号房"
	var TransactionMoney=-OrderMoney;
	
	
	var json={
			"TransactionDetail":TransactionDetail,
			"TransactionMoney":TransactionMoney,
			"Userid":userid
	}
	
	$.getJSON("./CreateTransactionServlet",{json:JSON.stringify(json)},function(json){
		if(json.result==true){
			alert("交易记录创建成功");
		}
	});
	
	
}
/*if (confirm("确定付款吗?")){
	if(true){
	   OrderState=1;
		}
}
else{
	OrderState=0;
}

var json={
		"OrderStayinDay":numberval,
		"OrderStayinPeopleNumber":OrderStayinPeopleNumber,
		"OrderCheckinTime":indata,
		"OrderCheckoutTime":outdata,
		"OrderMoney":OrderMoney,
		"OrderState":OrderState,
		"UserId":userid,
		"RoomId":roomId,
		"OrderUsername":OrderUsername,
		"OrderUserphon":OrderUserphon,
		"OrderUserIDnumber":OrderUserIDnumber
}
$.getJSON("./CreateOrderServlet",{json:JSON.stringify(json)},function(json){
	
	if(json.result==true&&OrderState==1){
		alert("订单支付成功,请到个人信息页面查看")
	}
	else if(json.result==true&&OrderState==0){
		alert("您有未付款成功的订单,请到个人信息页面查看");
	}
	window.location.href="jsp/userjsp/personinfo.jsp?indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid+"&roomtotalMoney="+roomtotalMoney;
});*/

