var length = 0;
var orderpage = 1;
$(document).ready(function() {
	$.getJSON("./WGetOrderNumberServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.ordernumber <= 10) {
			pages = 1;
		} else {
			pages = parseInt(jsonObject.ordernumber / 10);// 获取当前的总页数
			if (pages < jsonObject.ordernumber / 10) {
				pages = pages + 1;
			}
		}
		length = pages;
		showfenye(pages);
	});

	toloadmainorder(1);

}) ;

function toseeorderbyaddress_button(){
	toseeorderbyaddress_number();
	toseeorderbyaddress(1);
}
function toseeorderbyaddress_number(){
	var AddressProvince = $("#orAddressProvince").val();
	var AddressCity = $("#orAddressCity").val();
	var AddressVillage = $("#orAddressVillage").val();
	var DetatilAddress = $("#orkey_input").val();
	$.getJSON("./WGetOrderNumberServlet",{
		AddressProvince:AddressProvince,
		AddressCity:AddressCity,
		AddressVillage:AddressVillage,
		DetatilAddress:DetatilAddress,
	},function(jsonObject) {
		var pages2 = 0;
		if (jsonObject.ordernumber <= 10) {
			pages2 = 1;
		} else {
			pages2 = parseInt(jsonObject.ordernumber / 10);// 获取当前的总页数
			if (pages2 < jsonObject.ordernumber / 10) {
				pages2 = pages2 + 1;
			}
		}
		length = pages2;
		showfenye(pages2);
	});
}
function toseeorderbyaddress(page){
	$(".mrtruediv").html("");
	$(".mrtruediv").append('<div "> '+
			'<table>'+
			'<tbody>'+
			'<tr>'+
			'<td>订单号</td>'+
			'<td>入住天数</td>'+                 
			'<td>入住人数</td>'+
			'<td>入住时间</td>'+                 
			'<td>下单时间</td>'+
			'<td>退房时间</td>'+
			'<td>付款金额</td>'+
			'</tr>'+
			'</tbody>'+
			'<tbody  class="thisgroup">'+
			'</tbody>'+
			'</table>'+
	'</div>');
	var AddressProvince = $("#orAddressProvince").val();
	var AddressCity = $("#orAddressCity").val();
	var AddressVillage = $("#orAddressVillage").val();
	var DetatilAddress = $("#orkey_input").val();
	$.getJSON("./WGetOrdersByAddressServlet",{
		AddressProvince:AddressProvince,
		AddressCity:AddressCity,
		AddressVillage:AddressVillage,
		DetatilAddress:DetatilAddress,
		page:page
		},function(json){
		for ( var i = 0; i < json.length; i++) {
			var co="rgb(255,255,255)";
			if(i%2==0){
				co="rgb(255,255,255)";
			}
			else if(i%2!=0){
				co="rgb(175,196,224)";
			}
			for( var j = 0;j < $(".mrtruediv").length; j++){
				$(".mrtruediv").eq(j).find(".thisgroup").append('<tr onclick=do_onclick(this)    onselectstart="return false;" style="height:60px;font-size:12px;font-weight: normal;-moz-user-select:none;background-color:'+co+'">'+
						'<td>'+json[i].orderId+'</td>'+
						'<td>'+json[i].orderStayinDay+'</td>'+
						'<td>'+json[i].orderStayinPeopleNumber+'</td>'+
						'<td>'+json[i].orderCheckinTime+'</td>'+
						'<td>'+json[i].orderTime+'</td>'+
						'<td>'+json[i].orderCheckoutTime+'</td>'+
						'<td>'+json[i].orderMoney+'</td>'+
				'</tr>')
			}
		}
	})
}
function seeorder(){
	var x=tabuser;
	var OrderId=$(x).find("th").eq(0).html();
	if(x==null){
		alert("Not Clicked");
	}else{
		$.getJSON("./WGetOrderByIdServlet",{
			OrderId:OrderId
		},function(json){
			var OrderId=json.result.orderId;
			var OrderStayinDay=json.result.orderStayinDay;
			var OrderStayinPeopleNumber=json.result.orderStayinPeopleNumber;
			var OrderCheckinTime=json.result.orderCheckinTime;
			var OrderTime=json.result.orderTime;
			var OrderCheckoutTime=json.result.orderCheckoutTime;
			var OrderMoney=json.result.orderMoney;
			var RoomId=json.result.roomId;
			var UserId=json.result.userId;
			var OrderUserIDnumber=json.result.orderUserIDnumber;
			var OrderUserphon=json.result.orderUserphon;
			var OrderUsername=json.result.orderUsername;
			var OrderState=json.result.orderState;
			if(OrderState == 0){
				OrderState = "未付款";
			}
			if(OrderState == 1){
				OrderState = "已付款";
			}
			if(OrderState == 2){
				OrderState = "未入住";
			}
			if(OrderState == 3){
				OrderState = "已入住";
			}
			if(OrderState == 4){
				OrderState = "已退房";
			}
			if(OrderState == 5){
				OrderState = "已续房";
			}
			if(OrderState == -1){
				OrderState = "已删除";
			}
			$(".shadow").show();
			$(".pagehead font").html("订单信息");
			$(".pagemain").html("<div class=userset>"+
					"<div><a>订单号码：<input type='text' disabled='disabled' id='OrderId' value='"+OrderId+"'/></a></div>"+
					"<div <a>入住天数：<input disabled='disabled' id='OrderStayinDay'  type='text' value='"+OrderStayinDay+"'/></a></div>"+
					"<div <a>入住人数：<input disabled='disabled' id='OrderStayinPeopleNumber'  type='text' value='"+OrderStayinPeopleNumber+"'/></a></div>"+
					"<div <a>入住时间：<input disabled='disabled' id='OrderCheckinTime'  type='text' value='"+OrderCheckinTime+"'/></a></div>"+
					"<div <a>下单时间：<input disabled='disabled' id='OrderTime'  type='text' value='"+OrderTime+"'/></a></div>"+
					"<div <a>退房时间：<input disabled='disabled' id='OrderCheckoutTime'  type='text' value='"+OrderCheckoutTime+"'/></a></div>"+
					"<div <a>付款金额：<input disabled='disabled' id='OrderMoney'  type='text' value='"+OrderMoney+"'/></a></div>"+
					"<div <a>房&nbsp;间&nbsp;号&nbsp;：<input disabled='disabled' id='RoomId'  type='text' value='"+RoomId+"'/></a></div>"+
					"<div <a>客&nbsp;户&nbsp;号&nbsp;：<input disabled='disabled' id='UserId'  type='text' value='"+UserId+"'/></a></div>"+
					"<div <a>下单客户ID号：<input disabled='disabled' id='OrderUserIDnumber'  type='text' value='"+OrderUserIDnumber+"'/></a></div>"+
					"<div <a>下单电话号码：<input disabled='disabled' id='OrderUserphon'  type='text' value='"+OrderUserphon+"'/></a></div>"+
					"<div <a>下单客户姓名：<input disabled='disabled' id='OrderUsername'  type='text' value='"+OrderUsername+"'/></a></div>"+
					"<div <a>订&nbsp;&nbsp;单&nbsp;&nbsp;状&nbsp;&nbsp;态：<input disabled='disabled' id='OrderState'  type='text' value='"+OrderState+"'/></a></div>"+
					"<button class=search-btn2 onclick='closepage()' style='float:right; margin-right:20px; margin-top:20px;'>确定</button></div>"+
			"</div>"); 
		})
	}
}
function changeorder(){
	var x=tabuser;
	var OrderId=$(x).find("th").eq(0).html();
	if(x==null){
		alert("Not Clicked");
	}else{
		if (confirm("是否修改？")){
			$.getJSON("./WGetOrderByIdServlet",{
				OrderId:OrderId
			},function(json){
				var OrderId=json.result.orderId;
				var OrderStayinDay=json.result.orderStayinDay;
				var OrderStayinPeopleNumber=json.result.orderStayinPeopleNumber;
				var OrderCheckinTime=json.result.orderCheckinTime;
				var OrderTime=json.result.orderTime;
				var OrderCheckoutTime=json.result.orderCheckoutTime;
				var OrderMoney=json.result.orderMoney;
				var RoomId=json.result.roomId;
				var UserId=json.result.userId;
				var OrderUserIDnumber=json.result.orderUserIDnumber;
				var OrderUserphon=json.result.orderUserphon;
				var OrderUsername=json.result.orderUsername;
				var OrderState=json.result.orderState;
				if(OrderState == 0){
					OrderState = "未付款";
				}
				if(OrderState == 1){
					OrderState = "已付款";
				}
				if(OrderState == 2){
					OrderState = "未入住";
				}
				if(OrderState == 3){
					OrderState = "已入住";
				}
				if(OrderState == 4){
					OrderState = "已退房";
				}
				if(OrderState == 5){
					OrderState = "已续房";
				}
				if(OrderState == -1){
					OrderState = "已删除";
				}
				$(".shadow").show();
				$(".pagehead font").html("订单信息");
				$(".pagemain").html("<div class=userset>"+
						"<div><a>订单号码：<input type='text' id='OrderId' value='"+OrderId+"'/></a></div>"+
						"<div <a>入住天数：<input id='OrderStayinDay'  type='text' value='"+OrderStayinDay+"'/></a></div>"+
						"<div <a>入住人数：<input id='OrderStayinPeopleNumber'  type='text' value='"+OrderStayinPeopleNumber+"'/></a></div>"+
						"<div <a>入住时间：<input id='OrderCheckinTime'  type='text' value='"+OrderCheckinTime+"'/></a></div>"+
						"<div <a>下单时间：<input id='OrderTime'  type='text' value='"+OrderTime+"'/></a></div>"+
						"<div <a>退房时间：<input id='OrderCheckoutTime'  type='text' value='"+OrderCheckoutTime+"'/></a></div>"+
						"<div <a>付款金额：<input id='OrderMoney'  type='text' value='"+OrderMoney+"'/></a></div>"+
						"<div <a>房&nbsp;间&nbsp;号&nbsp;：<input id='RoomId'  type='text' value='"+RoomId+"'/></a></div>"+
						"<div <a>客&nbsp;户&nbsp;号&nbsp;：<input id='UserId'  type='text' value='"+UserId+"'/></a></div>"+
						"<div <a>下单客户ID号：<input id='OrderUserIDnumber'  type='text' value='"+OrderUserIDnumber+"'/></a></div>"+
						"<div <a>下单电话号码：<input id='OrderUserphon'  type='text' value='"+OrderUserphon+"'/></a></div>"+
						"<div <a>下单客户姓名：<input id='OrderUsername'  type='text' value='"+OrderUsername+"'/></a></div>"+
						"<div <a>订&nbsp;&nbsp;单&nbsp;&nbsp;状&nbsp;&nbsp;态：<input id='OrderState'  type='text' value='"+OrderState+"'/></a></div>"+
						"<div <button style='float:left; margin-left:10px; margin-top:20px;' class=search-btn2 onclick='changeorder_save()'>保存</button><button class=search-btn2 onclick='closepage()'>取消</button></div>"+
				"</div>"); 
			})
		}
		else{
			alert("取消修改");
		}
	}
}
function changeorder_save(){
	var OrderId=$("#OrderId").val();
	var OrderStayinDay=$("#OrderStayinDay").val();
	var OrderStayinPeopleNumber=$("#OrderStayinPeopleNumber").val();
	var OrderCheckinTime=$("#OrderCheckinTime").val();
	var OrderTime=$("#OrderTime").val();
	var OrderCheckoutTime=$("#OrderCheckoutTime").val();
	var OrderMoney=$("#OrderMoney").val();
	var UserId=$("#UserId").val();
	var RoomId=$("#RoomId").val();
	var OrderState=$("#OrderState").val();
	var OrderUserIDnumber=$("#OrderUserIDnumber").val();
	var OrderUserphon=$("#OrderUserphon").val();
	var OrderUsername=$("#OrderUsername").val();
	if(OrderState == "未付款"){
		OrderState = 0;
	}
	if(OrderState == "已付款"){
		OrderState = 1;
	}
	if(OrderState == "未入住"){
		OrderState = 2;
	}
	if(OrderState =="已入住"){
		OrderState = 3;
	}
	if(OrderState == "已退房"){
		OrderState = 4;
	}
	if(OrderState == "已续房"){
		OrderState = 5;
	}
	if(OrderState == "已删除"){
		OrderState = -1;
	}
	$.getJSON("./ChangeOrderServlet",{
		OrderId:OrderId,
		OrderStayinDay:OrderStayinDay,
		OrderStayinPeopleNumber:OrderStayinPeopleNumber,
		OrderCheckinTime:OrderCheckinTime,
		OrderTime:OrderTime,
		OrderCheckoutTime:OrderCheckoutTime,
		OrderMoney:OrderMoney,
		UserId:UserId,
		RoomId:RoomId,
		OrderState:OrderState,
		OrderUserIDnumber:OrderUserIDnumber,
		OrderUserphon:OrderUserphon,
		OrderUsername:OrderUsername
	},function(json){
		if(json.result){
			alert("修改成功");
		}
		else {
			alert("修改失败");
		}
	})
}


function toloadmainorder(page) {
	$(".mrtruediv").html("");
	$(".mrtruediv").append('<table id="data_tab">'+  '<tbody class="thisgroup">' + '</tbody>'+'</table>');
	$.getJSON("./WGetOrderPageServlet",{page:page},function(json){
		for ( var i = 0; i < json.length; i++) {
			for( var j = 0;j < $(".mrtruediv").length; j++){
				$(".mrtruediv").eq(j).find(".thisgroup").append('<tr onclick=do_onclick(this)   onselectstart="return false;">'+
						'<td >'+json[i].orderId+'</td>'+
						'<td>'+json[i].orderStayinDay+'</td>'+
						'<td>'+json[i].orderStayinPeopleNumber+'</td>'+
						'<td>'+json[i].orderCheckinTime+'</td>'+
						'<td >'+json[i].orderTime+'</td>'+
						'<td >'+json[i].orderCheckoutTime+'</td>'+
						'<td >'+json[i].orderMoney+'</td>'+
				'</tr>')
			}
		}
	})
}
function showfenye(pages){
	$(".fenye").html("");
	$(".fenye").append('<ul>'+
			'<li id="first" onclick=firstclick();>首页</li>'+
			'<li id="top" onclick=topclick();>上一页</li>'+
			'<li class="xifenye" id="xifenye">'+
			'<a id="xiye">1</a>	/  <a id="mo">'+length+'</a>'+
			'<div class="xab" id="xab" style="display: none">'+
			'<ul id="uljia"></ul>'+
			'</div>'+
			'</li>'+
			'<li id="down" onclick=downclick();>下一页</li>'+
			'<li id="last" onclick=lastclick();>末页</li>'+
			'</ul>'
	);
}
function changeorderpage(page) {
	$(".fenye").html("");
	$(".fenye").append('<ul>'+
			'<li id="first" onclick=firstclick();>首页</li>'+
			'<li id="top" onclick=topclick();>上一页</li>'+
			'<li class="xifenye" id="xifenye">'+
			'<a id="xiye">'+page+'</a>	/  <a id="mo">'+length+'</a>'+
			'<div class="xab" id="xab" style="display: none">'+
			'<ul id="uljia"></ul>'+
			'</div>'+
			'</li>'+
			'<li id="down" onclick=downclick();>下一页</li>'+
			'<li id="last" onclick=lastclick();>末页</li>'+
			'</ul>'
	);
}

//分页的的上一页和下一页
function topclick(){
	var pages = parseInt(length);// 获取当前的总页数
	if (orderpage > 1) {
		orderpage = orderpage - 1;
		changeorderpage(orderpage);
		scrolltop(orderpage);
	}
	toloadmainorder(orderpage);
}
function downclick(){
	var pages = parseInt(length);// 获取当前的总页数
	if (orderpage < pages) {
		orderpage = orderpage + 1;
		changeorderpage(orderpage);
		scrolltop(orderpage);
	}
	toloadmainorder(orderpage);
}
//分页的的首页和未页
function firstclick() {
	changeorderpage(1);
	orderpage = 1;
	toloadmainorder(1);

}
function lastclick() {
	changeorderpage(length);
	orderpage = length;
	toloadmainorder(length);
}

//滚动条
function scrolltop(top){
	var hei=25*top-25;
	$("#xab").scrollTop(hei);
}