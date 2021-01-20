$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	showscreen();
	showcommit();
	Judge_Equipment();
	Disp_Similar_Room();
	
	Judge_Order_NOt(roomId,$("#indata").val(),$("#outdata").val());
});


var map;
function showmap(n,p,t) {
	var json={
			"RoomId":roomId,
	}
	
	
	$.getJSON("./GetRoomDetailServlet",{json:JSON.stringify(json)},function(json){
		
		
	var lat=json.result.Room.roomLatitude;
	var lng=json.result.Room.roomLongitude;
	
	
	map = new BMap.Map("allmap");
	var point = new BMap.Point(lng,lat); 
	map.centerAndZoom(point, 15);  
	map.addControl(new BMap.NavigationControl());    
	map.addControl(new BMap.ScaleControl());    
	map.addControl(new BMap.OverviewMapControl());    
	map.addControl(new BMap.MapTypeControl());    
	map.enableScrollWheelZoom(true);
	setTimeout(function(){
		map.setZoom(14);   
		 
	}, 300);
	 var marker = new BMap.Marker(point);
	  map.addOverlay(marker);
	  var infoWindow = new BMap.InfoWindow(
			    "<div style='font-size:20px;font-weight:bold;'> <i class='iconfont' id='maproom'>&#xf012b</i>四季青藤"+n+"号房</div>" +
				"<div>价格：<font class='mapmoney'  style='width:200px;font-size:12px;'>"+p+"</font>/每晚</div>" +
				"<div style='width:200px;font-size:12px;'>房间类型："+t+"</div>"
				);
	  marker.openInfoWindow(infoWindow);
	  
	});
}


var addressId;
var Room_type;
var roomtype="";
var roomid;
//显示房间信息
function showscreen() {
	$.ajaxSettings.async = false;
	var roompeople;
	var bednumber;
	
	$(".Order_Box").html(
			'<div class="summary-right3" onclick="topay()"><i class="iconfont" id="destine">&#xf00f5</i>即时预订 </div>'
	);
	var json={
			"RoomId":roomId,
	}
	
	
	$.getJSON("./GetRoomDetailServlet",{json:JSON.stringify(json)},function(json){
		
		$(".homepic").css({"background-image":"url('"+json.result.Room.roomPicture+"')"});
		$(".homepic").css({"background-size":"100% 100%"});
		
		var roomMassage=json.result.Room.roomMassage;
		addressId=json.result.Room.addressId;
		Room_type=json.result.Room.roomType;
		roomid=json.result.Room.roomNumber;
			
		if(json.result.Room.roomType==2){
			roomtype="单人间";
			roompeople=1;
			bednumber=1;
		}
		else if(json.result.Room.roomType==1){
			roomtype="标准间";
			roompeople=2;
			bednumber=2;
		}
		else if(json.result.Room.roomType==3){
			roomtype="套房";
			roompeople=4;
			bednumber=4;
		}
		else{
			roomtype="无";
			roompeople=0;
			bednumber=0;
		}
		//alert(roomtype);
		
		var startindata=$("#indata").val();
		var startoutdata=$("#outdata").val();
		var indata1=startindata.split("-");
		var outdata1=startoutdata.split("-");
		var data1=new Date(indata1);
		var data2=new Date(outdata1);

		var time = parseInt(data2.getTime())-parseInt(data1.getTime()); //日期的值之差
		var numberval=Math.floor(time/(24*60*60*1000));
		var totolmoney=numberval*json.result.Room.roomUnitPrice;
		
		
		//总价格
		$(".homepic-title").html(
				'<div class="homepic-title-left">￥'+totolmoney+'</div>'
				+'<div class="homepic-title-right"></div>'
				);
		
		//标题
		$(".summary_left_con1_box").html(
				'<div class="summary-left-con1">四季青藤'+json.result.Room.roomNumber+'号房</div>'
				);
		
		//房源
		$(".landsourse_content").html(
				'<div class="landsourse_content_left">'
		          +'<div>房间类型： <b>'+roomtype+'</b></div>'
		          +'<div>房源类型： <b>酒店</b></div>'
		          +'<div>可住人数： <b>'+roompeople+'</b></div>'
		       +'</div> '
		       +'<div class="landsourse_content_right">'
		           +'<div>卫生间： <b>1</b></div>'
		          +'<div>床位： <b>'+bednumber+'</b></div>'
		          +'<div>入住时间： <b>12:00</b></div>'
		          +'<div>退房时间： <b>12:00</b></div>'
		       +'</div>'
				);
		
		//价格
		$(".price_content_left").html(
				   '<div id="money">￥'+json.result.Room.roomUnitPrice+'</b></div>'
//		          +'<div>标准间： <b>￥403</b></div>'
//		          +'<div>套房： <b>￥2014</b></div>'
				);
	   //描述
		$(".landcon_content").html(
				 '<div class="landcon_content_up">'+roomMassage+'</div>'
			     +'<div class="landcon_content_down">更多内容</div>'
				);
		
		//可租用性
		var roomusingState="";
		if(json.result.Room.roomUsingState==1){
			roomusingState="正在被使用";
		}
		else if(json.result.Room.roomUsingState==2){
			roomusingState="可租用"
		}
		else{
			roomusingState="不可租用"
		}
		
		
		
		showmap(json.result.Room.roomNumber,json.result.Room.roomUnitPrice,roomtype);
		
	});
}

//改变了预定日期的text的触发事件
function indata(i){
	var startindata=document.getElementById(i).value;
	var startoutdata=$("#outdata").val();
	
	var indata1=startindata.split("-");
	var outdata1=startoutdata.split("-");
	var data1=new Date(indata1);
	var data2=new Date(outdata1);

	var time = parseInt(data2.getTime())-parseInt(data1.getTime()); //日期的值之差
	var numberval=Math.floor(time/(24*60*60*1000));

	Judge_Order_NOt(roomId,startindata,startoutdata);   //判断能否预定
	
	var json={
		"RoomId":roomId,
    }
	
	$.getJSON("./GetRoomDetailServlet",{json:JSON.stringify(json)},function(json){
		var totolmoney=numberval*json.result.Room.roomUnitPrice;
		//总价格
		$(".homepic-title").html(
				'<div class="homepic-title-left">￥'+totolmoney+'</div>'
//				+'<div class="homepic-title-right">每晚</div>'
				);
	});
}

//改变了退房日期的text的触发事件
function outdata(o){
	var startoutdata=document.getElementById(o).value;
	var startindata=$("#indata").val();
	
	var indata1=startindata.split("-");
	var outdata1=startoutdata.split("-");
	
	var data1=new Date(indata1);
	var data2=new Date(outdata1);

	var time = parseInt(data2.getTime())-parseInt(data1.getTime()); //日期的值之差
	var numberval=Math.floor(time/(24*60*60*1000));
	Judge_Order_NOt(roomId,startindata,startoutdata);      //判断能否预定

	var json={
		"RoomId":roomId,
    }
	
	$.getJSON("./GetRoomDetailServlet",{json:JSON.stringify(json)},function(json){
		var totolmoney=numberval*json.result.Room.roomUnitPrice;
		//总价格
		$(".homepic-title").html(
				'<div class="homepic-title-left" id="money">￥'+totolmoney+'</div>'
//				+'<div class="homepic-title-right">每晚</div>'
				);
	});
}

//展开评论
function Disp_commont_more(i){
	$("#xxxx"+i+"").css({
		"height":"auto",
	});
	$("#xxhide"+i+"").show();
	$("#xxshow"+i+"").hide();
}

//收起评论
function Hide_commont_more(i){
	$("#xxxx"+i+"").css({
		"height":"60px",
	});
	$("#xxhide"+i+"").hide();
	$("#xxshow"+i+"").show();
}



var commitlist=new Array();
var page=0;
var nowpage=0;
//显示评论信息
function showcommit(){
	
	
	var json1={
			"RoomId":roomId,
	}
	
	$.getJSON("./GetRoomCommitByRoomServlet",{json:JSON.stringify(json1)},function(json){
		commitlist=json;
		var max=4;
		if(json.length<max){
			max=json.length;
		}
	$(".commentleft_box").append(
			'<div class="commentleft-title">'+json.length+'条评论</div>'
			+'<div class="commentleft_append"></div>'
			);
	for(var i=0;i<max;i++){		
		
		$(".commentleft_append").append(
			'<div class="commentleft_all_box">'
			    +'<div class="commentleft_all">'
			        +'<div class="commentleft_picture_box">'
			           +'<div class="commentleft_picture" id="'+i+'"></div>'
			           +'<div class="commentleft_picture_name">'+json[i].user.userName+'</div>'
			        +'</div>'
			        +'<div class="commentleft_text_box">'
			           +'<div class="commentleft_text" id="xxxx'+i+'">'+json[i].RoomCommitContent+'</div>'
			           +'<div class="commentleft_text_down">'
			              +'<div class="commentleft_text_date">'+json[i].RoomCommitTime+'</div>'
			             +' <div class="commentleft_text_use" id="xxshow'+i+'" onclick="Disp_commont_more('+i+')"><i class="iconfont font" >&#xf017d</i> 展开</div>'
			             +' <div class="commentleft_text_use_shou" id="xxhide'+i+'" style="display:none" onclick="Hide_commont_more('+i+')"><i class="iconfont font" >&#xf017d</i> 收起</div>'
			           +'</div>'
			        +'</div>'
			    +'</div>'
			+'</div>'
				);
		$("#"+i+"").css({"background-image":"url('"+json[i].user.userPicture+"')"});
		$("#"+i+"").css({"background-size":"100% 100%"});
	}
	
	page=Math.ceil(json.length/4);
	$(".text_bottom_number_box").append(
			' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage('+0+')">1</div>'
	);
	for(var i=1;i<page;i++){
		var x=i+1;
		$(".text_bottom_number_box").append(
				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage('+i+')">'+x+'</div>'
				);
	}
	
	});
}
//下一页
function nextpage() {
	//alert(1);
	if(nowpage<page-1){
		nowpage++;
		changepage(nowpage);
	}
}

//改变页码
function changepage(num) {
	nowpage=num;
	var min=num*4;
	var max=num*4+4;
	if (max>commitlist.length) {
		max=commitlist.length;
	}
	$(".commentleft_append").html("");
	 for ( var i = min; i <max ; i++) {
		 $(".commentleft_append").append(
					'<div class="commentleft_all_box">'
					    +'<div class="commentleft_all">'
					        +'<div class="commentleft_picture_box">'
					           +'<div class="commentleft_picture" id="'+i+'"></div>'
					           +'<div class="commentleft_picture_name">'+commitlist[i].user.userName+'</div>'
					        +'</div>'
					        +'<div class="commentleft_text_box">'
					           +'<div class="commentleft_text" id="xxxx'+i+'">'+commitlist[i].RoomCommitContent+'</div>'
					           +'<div class="commentleft_text_down">'
					              +'<div class="commentleft_text_date">'+commitlist[i].RoomCommitTime+'</div>'
					              +' <div class="commentleft_text_use" id="xxshow'+i+'" onclick="Disp_commont_more('+i+')"><i class="iconfont font" >&#xf017d</i> 展开</div>'
						          +' <div class="commentleft_text_use_shou" id="xxhide'+i+'" style="display:none" onclick="Hide_commont_more('+i+')"><i class="iconfont font" >&#xf017d</i> 收起</div>'
					           +'</div>'
					        +'</div>'
					    +'</div>'
					+'</div>'
						);
		 $("#"+i+"").css({"background-image":"url('"+commitlist[i].user.userPicture+"')"});
		 $("#"+i+"").css({"background-size":"100% 100%"});
	}
	 $(".text_bottom_number_box").html("");
	 
	 for ( var i = 0; i < page; i++) {
		 var x=i+1;
		 if (i==num) {
			 $(".text_bottom_number_box").append(
						'<div id="text_bottom_number" class="text_bottom_number" onclick="changepage('+i+')">'+x+'</div>'
				);
			}else {
				$(".text_bottom_number_box").append(
						' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage('+i+')">'+x+'</div>'
						);
			}
	 }
	 
	 
}



//到付款界面
function topay() {
	
	//拿到float类型的总价
	var totelmoney=document.getElementById("money").innerHTML;
	var roomtotalMoney=totelmoney.substring(1, totelmoney.length);
	//var inttotelmoney=parseFloat(totelmoney1);//转换成float类型
	//拿到订房日期
	var indata=$("#indata").val();
	//拿到退房日期
	var outdata=$("#outdata").val();
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	
	window.location.href="jsp/userjsp/pay.jsp?roomtotalMoney="+roomtotalMoney+"&indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid;
}

//显示设备更多内容
function Disp_More_Content(){
	$(".more-content").toggle();
}

//判断有无设备
function Judge_Equipment(){
	var json={
			"RoomId":roomId,
	};
	$.getJSON("./GetRoomDetailServlet",{json:JSON.stringify(json)},function(json){
		//alert(json.result.RoomEquipment.roomEquipmentId);
		if(json.result.RoomEquipment.TV==0)
		{
			$(".Tv").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.PETFacilities==0)
		{
			$(".Pet").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.airConditioner==0)
		{
			$(".workingSpace").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.breakfast==0)
		{
			$(".Breakfast").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.coatHanger==0)
		{
			$(".Cloth").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.dryingMachine==0)
		{
			$(".Drying").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.heating==0)
		{
			$(".Heating").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.hotTub==0)
		{
			$(".HotTub").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.indoorFirePlace==0)
		{
			$(".Indoorfireplace").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.iron==0)
		{
			$(".Iron").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.kitchen==0)
		{
			$(".Kitchen").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.necessities==0)
		{
			$(".Lifenecessary").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.network==0)
		{
			$(".Network").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.swimmingPool==0)
		{
			$(".Swimming").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.washingMachine==0)
		{
			$(".Washing").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.wheelchairAccessible==0)
		{
			$(".Wheelchair").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
		if(json.result.RoomEquipment.workingSpace==0)
		{
			$(".Workplace").css({
				"padding-bottom":"6px",
				"text-decoration":"line-through",
				"color":"#82888a",
			});
		}
	});
}

//鼠标触碰和点击事件
function Dispsumm1()
{
	$(".temp_summ1").show();
}
function Hidesumm1(){
	$(".temp_summ1").hide();
}
function Dispsumm2()
{
	$(".temp_summ2").show();
}
function Hidesumm2(){
	$(".temp_summ2").hide();
}
function Dispsumm3()
{
	$(".temp_summ3").show();
}
function Hidesumm3(){
	$(".temp_summ3").hide();
}
function Dispsumm4()
{
	$(".temp_summ4").show();
}
function Hidesumm4(){
	$(".temp_summ4").hide();
}
function jump1(){
	window.location.hash = "#Homee";
	window.location.hash = "#title";
}
function jump2(){
	window.location.hash = "#Comm";
	window.location.hash = "#title";
}
function jump3(){
	window.location.hash = "#Add";
	window.location.hash = "#title";
}
function jump4(){
	window.location.hash = "#similar";
	window.location.hash = "#title";
}

//显示，隐藏地图
function Disp_Map(){
	$(".enddown-map").toggle();
	$(".enddown-left-title").toggle();
}

var Room_Picture_Y=new Array();
var Room_Id_Y=new Array();
var Room_Price_Y=new Array();
var Room_Picture_N=new Array();
var Room_Id_N=new Array();
var Room_Price_N=new Array();

//显示相似房源信息
function Disp_Similar_Room(){
	var count=0;    //记录同类型同地区的房间数
	var count_another=0;      //记录同类型不同地区的房间数
	var json={
			"RoomType":Room_type
	};
	$.getJSON("./QueryRoomByRoomtypeServlet",{json:JSON.stringify(json)},function(json){
		
		for(var i=0;i<json.length;i++)
		{
			if(json[i].addressId==addressId)   //同类型同地区
			{
				if(roomid!=json[i].roomId)
				{
					Room_Picture_Y[count]=json[i].roomPicture;
					Room_Id_Y[count]=json[i].roomId;
					Room_Price_Y[count]=json[i].roomUnitPrice;
					count++;
				}
			}
			else         //同类型不同地区
			{
				Room_Picture_N[count_another]=json[i].roomPicture;
				Room_Id_N[count_another]=json[i].roomId;
				Room_Price_N[count_another]=json[i].roomUnitPrice;
				count_another++;
			}
		}
		if(count>6 ||count==6)
		{
			for(var i=0;i<6;i++){
				$(".enddown_end_picture").append(	
					'<div class="left_box_picture">'
						+'<div class="left_background_image" id="ss'+i+'" onclick="tohome('+Room_Id_Y[i]+')">'
	                        +'<div class="image_heart"></div>'
	                        +'<div class="text_hotel_price">￥'+Room_Price_Y[i]+'</div>'
	                    +'</div>'
	//	                +'<div class="left_image_round"></div>'
		                +'<div class="left_text_information">'
		                     +'<div class="left_text_address">四季青藤'+Room_Id_Y[i]+'号房 </div><br>'
		                     +'<div class="left_text_star">'
		                          +'<div class="left_text_room">'+roomtype+'</div>'
		                     +'</div>'
		                 +'</div>'
	                 +'</div>'
				);	
				$("#ss"+i+"").css({"background-image":"url('"+Room_Picture_Y[i]+"')"});
				$("#ss"+i+"").css({"background-size":"100% 100%"});
			}
		}
		else
		{
			for(var x=0;x<count;x++){
				$(".enddown_end_picture").append(
						'<div class="left_box_picture">'
					+'<div class="left_background_image" id="ss'+x+'" onclick="tohome('+Room_Id_Y[x]+')">'
                          +'<div class="image_heart"></div>'
                          +'<div class="text_hotel_price">￥'+Room_Price_Y[x]+'</div>'
                    +'</div>'
 //                   +'<div class="left_image_round"></div>'
                    +'<div class="left_text_information">'
                         +'<div class="left_text_address">四季青藤'+Room_Id_Y[x]+'号房 </div><br>'
                         +'<div class="left_text_star">'
                              +'<div class="left_text_room">'+roomtype+'</div>'
                         +'</div>'
                     +'</div>'
                     +'</div>'
				);
				$("#ss"+x+"").css({"background-image":"url('"+Room_Picture_Y[x]+"')"});
				$("#ss"+x+"").css({"background-size":"100% 100%"});
			}
			for(var j=count;j<6;j++){
				$(".enddown_end_picture").append(
						'<div class="left_box_picture">'
					+'<div class="left_background_image" id="ss'+j+'" onclick="tohome('+Room_Id_N[j-count]+')">'
                          +'<div class="image_heart"></div>'
                          +'<div class="text_hotel_price">￥'+Room_Price_N[j-count]+'</div>'
                    +'</div>'
//                    +'<div class="left_image_round"></div>'
                    +'<div class="left_text_information">'
                         +'<div class="left_text_address">四季青藤'+Room_Id_N[j-count]+'号房 </div><br>'
                         +'<div class="left_text_star">'
                              +'<div class="left_text_room">'+roomtype+'</div>'
                         +'</div>'
                     +'</div>'
                     +'</div>'
				);
				$("#ss"+j+"").css({"background-image":"url('"+Room_Picture_N[j-count]+"')"});
				$("#ss"+j+"").css({"background-size":"100% 100%"});
			}
		}
	});
}

//到房间
function tohome(r) {
	var indata=$("#indata").val();
	var outdata=$("#outdata").val();
	roomId=r;
	
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	
	window.location.href="jsp/userjsp/home.jsp?indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid;
}


//判断某日期的房间是否能被预定
function Judge_Order_NOt(roomid,ordercheckintime,ordercheckouttime){
	
	$.ajaxSettings.async = false;
	
	var json={
			"RoomId":roomid,
	};
	$.getJSON("./GetOrderByRoomServlet",{json:JSON.stringify(json)},function(json){
		for(var i=0;i<json.length;i++){
			var OrderCheckInTime=json[i].orderCheckinTime;      //获得其他客户这个房间的入住时间
			var OrderOut=json[i].orderCheckoutTime;          //获得其他客户这个房间的退房时间
			
			var SplitCheckOutOld=ordercheckintime.split("-");    //预定的入住时间
			var data_in=new Date(OrderCheckInTime.split("-"));       //其他客户这个房间的入住时间
			var data_out=new Date(OrderOut.split("-"));       //其他客户这个房间的退房时间
			var data_temp=new Date(ordercheckouttime.split("-"));   //预定的退房时间
			var data_old=new Date(SplitCheckOutOld);     //预定的入住时间
			var second=data_old.getTime();
			
//			alert(data_temp.getTime())
//			alert(data_in.getTime())
			if(data_old.getTime()<data_temp.getTime())    //只有入住时间小于退房时间时才比较
			{
				while(second!=data_temp.getTime())
				{
	//				alert(second)
					if( second==data_in.getTime() || (second>data_in.getTime()&&second<data_out.getTime()) ){
	//					alert("不满足");
						$(".Order_Box").html(
							'<div class="summary-right3"><i class="iconfont" id="destine">&#xf00f5</i>不可预订 </div>'
						);
						$(".landsent_content").html(
								'<div class="landsent_content_left">正在被使用</div>'
//							    +'<div class="landsent_content_right" style="color: #ff5a5f"><b>查看日历</b></div>'
						);
						return false;
					}
					else{      
	//					alert(1)				
						second=second+86400000;
						$(".Order_Box").html(
								'<div class="summary-right3" onclick="topay()"><i class="iconfont" id="destine">&#xf00f5</i>即时预订 </div>'
						);
						$(".landsent_content").html(
								'<div class="landsent_content_left">可租用</div>'
//							    +'<div class="landsent_content_right" style="color: #ff5a5f"><b>查看日历</b></div>'
						);
					}
				}
			}
			else
			{
				$(".Order_Box").html(
						'<div class="summary-right3"><i class="iconfont" id="destine">&#xf00f5</i>不可预订 </div>'
				);
				$(".landsent_content").html(
						'<div class="landsent_content_left">正在被使用</div>'
//					    +'<div class="landsent_content_right" style="color: #ff5a5f"><b>查看日历</b></div>'
				);
			}
		}
	});
}


