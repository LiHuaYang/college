$(document).ready(function(){
	

	//价格插件
	$("#range_1").ionRangeSlider({
		min: 0,
		max: 2000,
		from:300,
		to: 1000,
		type: 'double',//设置类型
		step: 1,
		prefix: "",//设置数值前缀
		postfix: "元",//设置数值后缀
		prettify: true,
		hasGrid: true
	});
	
	$(".heads").load("jsp/common/bar.jsp");
	
	setTimeout("showmap()", 200); //显示地图须在load后面，防止界面错乱
	 setTimeout(function(){	//同理改变标题栏中搜索框内值
			$(".homehead-input").val(where);
		}, 200);  
	 setTimeout(function(){//改变参数，说明这是在搜索页面内不需要重新加载
		$("#me").attr("search",1);   
	}, 210);  
	 
	
	showAddress();
	Disp_Price();
	
	
});

function ok(){
    var x=document.getElementById("irs-fromid").innerHTML; //价格最小值
	var y=document.getElementById("irs-toid").innerHTML; //价格最大值
	alert(x+y);
}

function showAddress(){
	 /***************显示地区选项栏*******************/
	$(".mainpic_left_street").html(
			 '<div class="left_text_street">地区</div> '
             +'<div class="street_same_box"></div>'
             +'<div class="street_down" onclick="street_umbrella_close()"></div>'
             +'<div class="street_up" onclick="street_umbrella_open()" style="display: none;"></div>'
			);
	$(".street_more").html(
			'<div class="street_more_box"><div>'
			);
	
	$.getJSON("./QueryAllAddressServlet",function(json){
	 for ( var i = 0; i < 3; i++) {
		 Address[i]=json[i].addressVillage;
		 AddressId[i]=json[i].addressId;
		 $(".street_same_box").append(
				 '<div class="street_same"><input type="checkbox" class="right_checkbox'+i+'" onclick="DispRoomByAddress()"/> '+json[i].addressVillage+'</div>'
				 );
	 }
	 
	 for ( var i = 3; i <json.length; i++) {
		 Address[i]=json[i].addressVillage;
		 AddressId[i]=json[i].addressId;
		 $(".street_more_box").append(
			 '<div class="street_more_disp"><input type="checkbox" class="right_checkbox'+i+'" onclick="DispRoomByAddress()"/> '+json[i].addressVillage+'</div>'
		 );
	 }
	});
}


var AddressId=new Array();
var Address=new Array();
var map;
function showmap() {
	map = new BMap.Map("allmap");          
	map.centerAndZoom(where, 15);  
	map.addControl(new BMap.NavigationControl());    
	map.addControl(new BMap.ScaleControl());    
	map.addControl(new BMap.OverviewMapControl());    
	map.addControl(new BMap.MapTypeControl());    
	map.enableScrollWheelZoom(true);
	setTimeout(function(){
		map.setZoom(14);   
		 
	}, 300);
	setTimeout(function(){
		showhome();   
		 
	}, 500);

	

	
}
function onesearch() {
	map.clearOverlays();
	var address=$(".homehead-input").val();
	map.centerAndZoom(address, 15);  
	setTimeout(function(){
		showhome();   
		 
	}, 500);  
}



//自定义创建点
function addMarker(point){

var marker = new BMap.Marker(point);
	mappointerlist.push(marker);
map.addOverlay(marker);
}


function findpointer(x,p,n,t) {
	var infoWindow = new BMap.InfoWindow("<div style='font-size:20px;font-weight:bold;'> <i class='iconfont' id='maproom'>&#xf012b</i>四季青藤"+n+"号房</div>" +
			"<div>价格：<font class='mapmoney'>"+p+"</font>/每晚</div>" +
			"<div>房间类型："+t+"</div>");
	mappointerlist[x].openInfoWindow(infoWindow);
}


//�����ı䱳����ɫ��������ɫ
function text_numberx_box(e) {
	for ( var i = 0; i < 5; i++) {
		if(e==i){
		    $(".text_bottom_number"+i).css("background-color", "#EDEFED"); 
		    $(".text_bottom_number"+i).addClass("#565A5C");
		}
		else{
			$(".text_bottom_number"+i).css("background-color", "#ffffff");
		    $(".text_bottom_number"+i).addClass("#FF5A5F");	
		}
	}
}

function condition_choice() {
	$(".mainpic_left_more").show(300);
	$(".mainpic_left_condition").hide(300);
	$(".mainpic_left_picture").hide(300);
	$(".left_text_bottom").hide(300);
}

function left_fixed_cancel() {
	$(".mainpic_left_more").hide(300);
	$(".mainpic_left_condition").show();
	$(".mainpic_left_picture").show();
	$(".left_text_bottom").show();
}

//�������ݴ�
function street_umbrella_close() {
	$(".street_up").show();
	$(".street_down").hide();
	$(".street_more").show();
}

//�������ݹر�
function street_umbrella_open() {
	$(".street_down").show();
	$(".street_up").hide();
	$(".street_more").hide();
}

//�������ݴ�
function price_umbrella_close() {
	$(".price_up").show();
	$(".price_down").hide();
}

//�������ݹر�
function price_umbrella_open() {
	$(".price_down").show();
	$(".price_up").hide();
}

//������ʩ���ݴ�
function facilities_umbrella_close() {
	$(".facilities_up").show();
	$(".facilities_down").hide();
	$(".mainpic_left_facilities_more").show();
}

//������ʩ���ݹر�
function facilities_umbrella_open() {
	$(".facilities_down").show();
	$(".facilities_up").hide();
	$(".mainpic_left_facilities_more").hide();
}

//��Դ�������ݴ�
function house_umbrella_close() {
	$(".house_up").show();
	$(".house_down").hide();
}

//��Դ�������ݹر�
function house_umbrella_open() {
	$(".house_down").show();
	$(".house_up").hide();
}


//横纵坐标
function homepoint(lon,lat) {
	this.lat=lat;
	this.lon=lon;
	return this;
}

var homepointlist=new Array(); 
var mappointerlist=new Array();
var typeresult=new Array();
var roompicturelist=new Array();
var roomUnitPricelist=new Array();
var roomNumberlist=new Array();
var roomIdlist=new Array();
var addressIdlist=new Array();


var roomshowlist=new Array();
var page=0;
var nowpage=0;

//展示房间位置
function showhome() {
	
	var where=$(".homehead-input").val();

	var json1={
			"AddressVillage":where
	}
	
	
	$.getJSON("./GetRoomByAddressServlet",{json:JSON.stringify(json1)},function(json){
		roomshowlist=json;
		var max=18;
		if(json.length<max){
			max=json.length
		}
		
	//var  = jsonObject.rooms[0].roomId;
	
    	
//    	var roomLongitude=jsonObject.rooms[x].roomLongitude;
//    	var roomLatitude=jsonObject.rooms[x].roomLatitude;
		
    	homepointlist.length=0;
    	mappointerlist.length=0;
   
        
    	for(var x=0;x<max;x++){
    		//var home=new homepoint(sw.lng + lngSpan * (Math.random() * 0.7), ne.lat - latSpan * (Math.random() * 0.7));
    		var home=new homepoint(json[x].roomLongitude, json[x].roomLatitude);
    		homepointlist.push(home);
    		var point = new BMap.Point(json[x].roomLongitude, json[x].roomLatitude);
    		addMarker(point);
    		
    		
    		
    		
    		
    		//判断类型
    		if(json[x].roomType==2){
    			var roomtype="单人间";
    			typeresult.push(roomtype);
    		}
    		else if(json[x].roomType==1){
    			var roomtype="标准间";
    			typeresult.push(roomtype);
    		}
    		else if(json[x].roomType==3){
    			var roomtype="套房";
    			typeresult.push(roomtype);
    		}
    		else
    		{
    			var roomtype="无";
    			typeresult.push(roomtype);
    		}
    		//房间图片
    		roompicturelist.push(json[x].roomPicture);
    		//房间价格
    		roomUnitPricelist.push(json[x].roomUnitPrice);
    		//房间号
    		roomNumberlist.push(json[x].roomNumber);
    		//房间ID
    		roomIdlist.push(json[x].roomId);
    		
    	}
    	
    	$(".mainpic_left_picture").html("");
    	for ( var i = 0; i < max; i++) {
		
    		$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist[i].lat+' lon='+homepointlist[i].lon+' onclick="tohome('+json[i].roomId+')" onmouseover="findpointer('+i+','+'\''+roomUnitPricelist[i]+'\''+','+'\''+roomNumberlist[i]+'\''+','+'\''+typeresult[i]+'\')">'+
    				' <div class="left_background_image" id='+i+'>' +
    				' <div class="image_heart"></div>' +
    				' <div class="text_hotel_price">￥'+roomUnitPricelist[i]+'</div>' +
    				' </div>' +
//    				' <div class="left_image_round" ></div>' +
    				' <div class="left_text_information">' +
    				'    <div class="left_text_address">四季青藤'+roomNumberlist[i]+'号房</div><br>' +
    				'    <div class="left_text_star">' +
    				'   <div class="left_text_room">'+typeresult[i]+'</div>' +
//    				'  <div class="yellow_star"></div>' +
//    				'  <div class="yellow_star"></div>' +
//    				'  <div class="yellow_star"></div>' +
//    				'  <div class="yellow_star"></div>' +
//    				'  <div class="yellow_star"></div>' +
//    				'  <div class="left_text_room">•108条评价</div>' +
    				'  </div>' +
    				' </div>' +
    				'  </div>'
    		)
	    	$("#"+i+"").css({"background-image":"url('"+roompicturelist[i]+"')"});
	    	$(".left_background_image").css({"background-size":"100% 100%"});
    	}
    	$(".text_bottom_number_box").html("");
    	page=Math.ceil(json.length/18);  	
    	for(var i=0;i<page;i++){
    		
    		var x=i+1;
    		$(".text_bottom_number_box").append(
    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage('+i+')">'+x+'</div>'
    				);
    	}
    	$(".text_bottom_number_box").append(
    			'<div class="text_bottom_next" onclick="nextpage()">▶</div>'
    			);
    	
	});
}

//下一页
function nextpage() {
	if(nowpage<page-1){
		nowpage++;
		changepage(nowpage);
	}
	else
	{
		alert("已经是最后一页了");
	}
}

//下一页2
function nextpage_price() {
	if(nowpage<page-1){
		nowpage++;
		changepage_price(nowpage);
	}
	else
	{
		alert("已经是最后一页了");
	}
}

///下一页3
function nextpage_temp() {
	if(nowpage<page-1){
		nowpage++;
		changepage_temp(nowpage);
	}
	else
	{
		alert("已经是最后一页了");
	}
}

//改变页码
function changepage(num) {
	nowpage=num;
	var min=num*18;
	var max=num*18+18;
	if (max>roomUnitPricelist.length) {
		max=roomUnitPricelist.length;
	}
	$(".mainpic_left_picture").html("");
	 for ( var i = min; i <max ; i++) {
		 $(".mainpic_left_picture").append(
				'  <div  class="left_box_picture" lat='+homepointlist[i].lat+' lon='+homepointlist[i].lon+' onclick="tohome('+roomIdlist[i]+')" onmouseover="findpointer('+i+','+'\''+roomUnitPricelist[i]+'\''+','+'\''+roomNumberlist[i]+'\''+','+'\''+typeresult[i]+'\')">'+
 				' <div class="left_background_image" id='+i+'>' +
 				' <div class="image_heart"></div>' +
 				' <div class="text_hotel_price">￥'+roomUnitPricelist[i]+'</div>' +
 				' </div>' +
 				' <div class="left_text_information">' +
 				'    <div class="left_text_address">四季青藤'+roomNumberlist[i]+'号房</div><br>' +
 				'    <div class="left_text_star">' +
 				'   <div class="left_text_room">'+typeresult[i]+'</div>' +
 				'  </div>' +
 				' </div>' +
 				'  </div>'
		 );
		 $("#"+i+"").css({"background-image":"url('"+roompicturelist[i]+"')"});
	     $(".left_background_image").css({"background-size":"100% 100%"});
	 }
     $(".text_bottom_number_box").html("");
 //    alert(page);
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
		 if(i==page-1)
		 {
			 $(".text_bottom_number_box").append(
					 '<div class="text_bottom_next" onclick="nextpage()">▶</div>'
					 );
		 }
	 }
}

//改变页码2
function changepage_price(num) {
	nowpage=num;
	var min=num*18;
	var max=num*18+18;
	if (max>roomUnitPricelist1.length) {
		max=roomUnitPricelist1.length;
	}
	$(".mainpic_left_picture").html("");
	 for ( var i = min; i <max ; i++) {
		 $(".mainpic_left_picture").append(
				'  <div  class="left_box_picture" lat='+homepointlist1[i].lat+' lon='+homepointlist1[i].lon+' onclick="tohome('+roomIdlist1[i]+')" onmouseover="findpointer('+i+','+'\''+roomUnitPricelist1[i]+'\''+','+'\''+roomNumberlist1[i]+'\''+','+'\''+typeresult1[i]+'\')">'+
 				' <div class="left_background_image" id='+i+'>' +
 				' <div class="image_heart"></div>' +
 				' <div class="text_hotel_price">￥'+roomUnitPricelist1[i]+'</div>' +
 				' </div>' +
 				' <div class="left_text_information">' +
 				'    <div class="left_text_address">四季青藤'+roomNumberlist1[i]+'号房</div><br>' +
 				'    <div class="left_text_star">' +
 				'   <div class="left_text_room">'+typeresult1[i]+'</div>' +
 				'  </div>' +
 				' </div>' +
 				'  </div>'
		 );
		 $("#"+i+"").css({"background-image":"url('"+roompicturelist1[i]+"')"});
	     $(".left_background_image").css({"background-size":"100% 100%"});
	 }
     $(".text_bottom_number_box").html("");
 //    alert(page);
	 for ( var i = 0; i < page; i++) {
		 var x=i+1;
		 if (i==num) {
			 $(".text_bottom_number_box").append(
						'<div id="text_bottom_number" class="text_bottom_number" onclick="changepage_price('+i+')">'+x+'</div>'
				);
			}else {
				$(".text_bottom_number_box").append(
						' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_price('+i+')">'+x+'</div>'
						);
			}
		 if(i==page-1)
		 {
			 $(".text_bottom_number_box").append(
					 '<div class="text_bottom_next" onclick="nextpage_price()">▶</div>'
					 );
		 }
	 }
}

//改变页码3
function changepage_temp(num) {
	nowpage=num;
	var min=num*18;
	var max=num*18+18;
	if (max>roomUnitPricelist_temp.length) {
		max=roomUnitPricelist_temp.length;
	}
	$(".mainpic_left_picture").html("");
	 for ( var i = min; i <max ; i++) {
		 $(".mainpic_left_picture").append(
				'  <div  class="left_box_picture" lat='+homepointlist_temp[i].lat+' lon='+homepointlist_temp[i].lon+' onclick="tohome('+roomIdlist_temp[i]+')" onmouseover="findpointer('+i+','+'\''+roomUnitPricelist_temp[i]+'\''+','+'\''+roomNumberlist_temp[i]+'\''+','+'\''+typeresult_temp[i]+'\')">'+
 				' <div class="left_background_image" id='+i+'>' +
 				' <div class="image_heart"></div>' +
 				' <div class="text_hotel_price">￥'+roomUnitPricelist_temp[i]+'</div>' +
 				' </div>' +
 				' <div class="left_text_information">' +
 				'    <div class="left_text_address">四季青藤'+roomNumberlist_temp[i]+'号房</div><br>' +
 				'    <div class="left_text_star">' +
 				'   <div class="left_text_room">'+typeresult_temp[i]+'</div>' +
 				'  </div>' +
 				' </div>' +
 				'  </div>'
		 );
		 $("#"+i+"").css({"background-image":"url('"+roompicturelist_temp[i]+"')"});
	     $(".left_background_image").css({"background-size":"100% 100%"});
	 }
     $(".text_bottom_number_box").html("");
 //    alert(page);
	 for ( var i = 0; i < page; i++) {
		 var x=i+1;
		 if (i==num) {
			 $(".text_bottom_number_box").append(
						'<div id="text_bottom_number" class="text_bottom_number" onclick="changepage_temp('+i+')">'+x+'</div>'
				);
			}else {
				$(".text_bottom_number_box").append(
						' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_temp('+i+')">'+x+'</div>'
						);
			}
		 if(i==page-1)
		 {
			 $(".text_bottom_number_box").append(
					 '<div class="text_bottom_next" onclick="nextpage_temp()">▶</div>'
					 );
		 }
	 }
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





var homepointlist1=new Array(); 
var typeresult1=new Array();
var roompicturelist1=new Array();
var roomUnitPricelist1=new Array();
var roomNumberlist1=new Array();
var roomIdlist1=new Array();
var addressIdlist1=new Array();

var homepointlist_temp=new Array(); 
var typeresult_temp=new Array();
var roompicturelist_temp=new Array();
var roomUnitPricelist_temp=new Array();
var roomNumberlist_temp=new Array();
var roomIdlist_temp=new Array();
//每次都要运行(通过价格查找房间,来更新数组)
function Every_Price(){
	$.ajaxSettings.async = false;
	homepointlist1.length=0;
	mappointerlist.length=0;
	roompicturelist1.length=0;
	roomUnitPricelist1.length=0;
	roomNumberlist1.length=0;
	typeresult1.length=0;
	roomIdlist1.length=0;
	addressIdlist1.length=0;
	for(var i=0;i<3;i++)
	{
		if($(".price_checkbox"+i+"").attr("checked")=="checked")
		{
			if(i==0)
			{
				$.getJSON("./GetAllRoomServlet",function(json){
					for ( var x = 0; x < json.length; x++) {
						if(json[x].roomUnitPrice<500){
							var home=new homepoint(json[x].roomLongitude, json[x].roomLatitude);
				    		homepointlist1.push(home);
		  		    		var point= new BMap.Point(json[x].roomLongitude, json[x].roomLatitude);
				    		addMarker(point);
				    		if(json[x].roomType==2){
				    			var roomtype="单人间";
				    			typeresult1.push(roomtype);
				    		}
				    		else if(json[x].roomType==1){
				    			var roomtype="标准间";
				    			typeresult1.push(roomtype);
				    		}
				    		else if(json[x].roomType==3){
				    			var roomtype="套房";
				    			typeresult1.push(roomtype);
				    		}
				    		else
				    		{
				    			var roomtype="无";
				    			typeresult1.push(roomtype);
				    		}			    		
				    		//房间图片
				    		roompicturelist1.push(json[x].roomPicture);
				    		//房间价格
				    		roomUnitPricelist1.push(json[x].roomUnitPrice);
				    		//房间号
				    		roomNumberlist1.push(json[x].roomNumber);
				    		//房间ID
				    		roomIdlist1.push(json[x].roomId);
				    		//地址
				    		addressIdlist1.push(json[x].addressId);
						}
					}
				});
			}
			else if(i==1)
			{
				$.getJSON("./GetAllRoomServlet",function(json){
					for ( var x = 0; x < json.length; x++) {
						if( (json[x].roomUnitPrice>500 && json[x].roomUnitPrice<1000) ||json[x].roomUnitPrice==500 ||json[x].roomUnitPrice==1000){
							var home=new homepoint(json[x].roomLongitude, json[x].roomLatitude);
				    		homepointlist1.push(home);
		  		    		var point= new BMap.Point(json[x].roomLongitude, json[x].roomLatitude);
				    		addMarker(point);
				    		if(json[x].roomType==2){
				    			var roomtype="单人间";
				    			typeresult1.push(roomtype);
				    		}
				    		else if(json[x].roomType==1){
				    			var roomtype="标准间";
				    			typeresult1.push(roomtype);
				    		}
				    		else if(json[x].roomType==3){
				    			var roomtype="套房";
				    			typeresult1.push(roomtype);
				    		}
				    		else
				    		{
				    			var roomtype="无";
				    			typeresult1.push(roomtype);
				    		}			    		
				    		//房间图片
				    		roompicturelist1.push(json[x].roomPicture);
				    		//房间价格
				    		roomUnitPricelist1.push(json[x].roomUnitPrice);
				    		//房间号
				    		roomNumberlist1.push(json[x].roomNumber);
				    		//房间ID
				    		roomIdlist1.push(json[x].roomId);
				    		//地址
				    		addressIdlist1.push(json[x].addressId);
						}
					}
				});
			}
			else if(i==2)
			{
				$.getJSON("./GetAllRoomServlet",function(json){
					for ( var x = 0; x < json.length; x++) {
						if(json[x].roomUnitPrice>1000){
							var home=new homepoint(json[x].roomLongitude, json[x].roomLatitude);
				    		homepointlist1.push(home);
		  		    		var point= new BMap.Point(json[x].roomLongitude, json[x].roomLatitude);
				    		addMarker(point);
				    		if(json[x].roomType==2){
				    			var roomtype="单人间";
				    			typeresult1.push(roomtype);
				    		}
				    		else if(json[x].roomType==1){
				    			var roomtype="标准间";
				    			typeresult1.push(roomtype);
				    		}
				    		else if(json[x].roomType==3){
				    			var roomtype="套房";
				    			typeresult1.push(roomtype);
				    		}
				    		else
				    		{
				    			var roomtype="无";
				    			typeresult1.push(roomtype);
				    		}			    		
				    		//房间图片
				    		roompicturelist1.push(json[x].roomPicture);
				    		//房间价格
				    		roomUnitPricelist1.push(json[x].roomUnitPrice);
				    		//房间号
				    		roomNumberlist1.push(json[x].roomNumber);
				    		//房间ID
				    		roomIdlist1.push(json[x].roomId);
				    		//地址
				    		addressIdlist1.push(json[x].addressId);
						}
					}
				});
			}
		}
	}
}
//每次都要运行(通过地址查找房间，来更新数组)
function Every_Address(){
	$.ajaxSettings.async = false;
	homepointlist.length=0;
	mappointerlist.length=0;
	roompicturelist.length=0;
	roomUnitPricelist.length=0;
	roomNumberlist.length=0;
	typeresult.length=0;
	roomIdlist.length=0;
	for ( var i = 0; i < Address.length; i++) {
		if($(".right_checkbox"+i+"").attr("checked")=="checked"){
			var json={
					"AddressVillage":Address[i]
			};
			$.getJSON("./GetRoomByAddressServlet",{json:JSON.stringify(json)},function(json){
				for ( var x = 0; x < json.length; x++) {
					var home=new homepoint(json[x].roomLongitude, json[x].roomLatitude);
		    		homepointlist.push(home);
			    		var point= new BMap.Point(json[x].roomLongitude, json[x].roomLatitude);
		    		addMarker(point);
		    		if(json[x].roomType==2){
		    			var roomtype="单人间";
		    			typeresult.push(roomtype);
		    		}
		    		else if(json[x].roomType==1){
		    			var roomtype="标准间";
		    			typeresult.push(roomtype);
		    		}
		    		else if(json[x].roomType==3){
		    			var roomtype="套房";
		    			typeresult.push(roomtype);
		    		}
		    		else
		    		{
		    			var roomtype="无";
		    			typeresult.push(roomtype);
		    		}
		    		
		    		//房间图片
		    		roompicturelist.push(json[x].roomPicture);
		    		//房间价格
		    		roomUnitPricelist.push(json[x].roomUnitPrice);
		    		//房间号
		    		roomNumberlist.push(json[x].roomNumber);
		    		//房间ID
		    		roomIdlist.push(json[x].roomId);
				}
			});
		}
	}
}

//通过地区查找房间
function DispRoomByAddress(){
	$(".mainpic_left_picture").html(""); 
	var temp=0;
	var tag=0;
	var temp_tag=0;
	var address_name=new Array();
	var con=0;
	
	for(var i=0;i<Address.length;i++)   //地址复选框循环
	{
		if(i==0)      //只执行一次
		{
			homepointlist_temp.length=0;
			mappointerlist.length=0;
			roompicturelist_temp.length=0;
			roomUnitPricelist_temp.length=0;
			roomNumberlist_temp.length=0;
			typeresult_temp.length=0;
			roomIdlist_temp.length=0;
		}
		if($(".right_checkbox"+i+"").attr("checked")=="checked"){
			address_name[con]=Address[i];
			con++;
			$(".homehead-input").val(address_name);
			tag=1;    //说明地址复选框被选中过
			Every_Address();     //更新数组	
			for(var j=0;j<3;j++)  //价格复选框循环
			{				
				if($(".price_checkbox"+j+"").attr("checked")=="checked")
				{
					temp_tag=1;     //说明价格复选框有选中
					for(var k=0;k<roomUnitPricelist1.length;k++)
					{
						if(addressIdlist1[k]==AddressId[i])
						{
							homepointlist_temp.push(homepointlist1[k]);
							roomIdlist_temp.push(roomIdlist1[k]);
							roomUnitPricelist_temp.push(roomUnitPricelist1[k]);
							roomNumberlist_temp.push(roomNumberlist1[k]);
							typeresult_temp.push(typeresult1[k]);
							roompicturelist_temp.push(roompicturelist1[k]);		
						}
					}
					//alert(roomUnitPricelist_temp.length)
					var max=18;
					if(roomUnitPricelist_temp.length<max){
						max=roomUnitPricelist_temp.length;
					}
					$(".mainpic_left_picture").html("");
					for(var k=0;k<max;k++)
					{						
						$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist_temp[k].lat+' lon='+homepointlist_temp[k].lon+' onclick="tohome('+roomIdlist_temp[k]+')" onmouseover="findpointer('+(k)+','+'\''+roomUnitPricelist_temp[k]+'\''+','+'\''+roomNumberlist_temp[k]+'\''+','+'\''+typeresult_temp[k]+'\')">'+
			    				' <div class="left_background_image" id='+(k)+'>' +
			    				' <div class="image_heart"></div>' +
			    				' <div class="text_hotel_price">￥'+roomUnitPricelist_temp[k]+'</div>' +
			    				' </div>' +
//			    				' <div class="left_image_round" ></div>' +
			    				' <div class="left_text_information">' +
			    				'    <div class="left_text_address">四季青藤'+roomNumberlist_temp[k]+'号房</div><br>' +
			    				'    <div class="left_text_star">' +
			    				'   <div class="left_text_room">'+typeresult_temp[k]+'</div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="left_text_room">•108条评价</div>' +
			    				'  </div>' +
			    				' </div>' +
			    				'  </div>'
			    		)
			    		
			    		$("#"+(k)+"").css({"background-image":"url('"+roompicturelist_temp[k]+"')"});
				    	$(".left_background_image").css({"background-size":"100% 100%"});
					}
					$(".text_bottom_number_box").html("");
		    		page=Math.ceil(roomUnitPricelist_temp.length/18);  	
		    		for(var l=0;l<page;l++){	    		
		    			var x=l+1;
		    			$(".text_bottom_number_box").append(
		    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_temp('+l+')">'+x+'</div>'
		    				);
		    		}
		    		$(".text_bottom_number_box").append(
		    			'<div class="text_bottom_next" onclick="nextpage_temp()">▶</div>'
		    			);
		    		break;
				}
			}
			
		}
	}
	for(var j=0;j<3;j++)  //价格复选框循环
	{
		if($(".price_checkbox"+j+"").attr("checked")=="checked")
		{
			temp_tag=1;
		}
	}
	if(temp_tag==0)    //只有地区复选框被选中或者地区复选框和价格都没被选中
	{
			$(".mainpic_left_picture").html("");
			var max=18;  
			if(roomUnitPricelist.length<max){
				max=roomUnitPricelist.length;
			}	
	    	for(var x=0;x<max;x++){
	    		
	    		$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist[x+temp].lat+' lon='+homepointlist[x+temp].lon+' onclick="tohome('+roomIdlist[x+temp]+')" onmouseover="findpointer('+(x+temp)+','+'\''+roomUnitPricelist[x+temp]+'\''+','+'\''+roomNumberlist[x+temp]+'\''+','+'\''+typeresult[x+temp]+'\')">'+
	    				' <div class="left_background_image" id='+(x+temp)+'>' +
	    				' <div class="image_heart"></div>' +
	    				' <div class="text_hotel_price">￥'+roomUnitPricelist[x+temp]+'</div>' +
	    				' </div>' +
//	    				' <div class="left_image_round" ></div>' +
	    				' <div class="left_text_information">' +
	    				'    <div class="left_text_address">四季青藤'+roomNumberlist[x+temp]+'号房</div><br>' +
	    				'    <div class="left_text_star">' +
	    				'   <div class="left_text_room">'+typeresult[x+temp]+'</div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="left_text_room">•108条评价</div>' +
	    				'  </div>' +
	    				' </div>' +
	    				'  </div>')
	    		
	    		//alert(json[x].roomPicture)
		    	$("#"+(temp+x)+"").css({"background-image":"url('"+roompicturelist[x+temp]+"')"});
		    	$(".left_background_image").css({"background-size":"100% 100%"});	    		
	    	}
	    	temp=temp+max;
	    	$(".text_bottom_number_box").html("");
    		page=Math.ceil(roomUnitPricelist.length/18);  	
    		for(var i=0;i<page;i++){	    		
    			var x=i+1;
    			$(".text_bottom_number_box").append(
    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage('+i+')">'+x+'</div>'
    				);
    		}
    		$(".text_bottom_number_box").append(
    			'<div class="text_bottom_next" onclick="nextpage()">▶</div>'
    			);
	}
	if(tag==0 && temp_tag==1)    //地区复选框没选中，但是价格复选框被选中
	{
		var max=18;  
		if(roomUnitPricelist1.length<max){
			max=roomUnitPricelist1.length;
		}
		$(".mainpic_left_picture").html("");
		for ( var k = 0; k < max; k++) {
			$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist1[k].lat+' lon='+homepointlist1[k].lon+' onclick="tohome('+roomNumberlist1[k]+')" onmouseover="findpointer('+(k)+','+'\''+roomUnitPricelist1[k]+'\''+','+'\''+roomNumberlist1[k]+'\''+','+'\''+typeresult1[k]+'\')">'+
    				' <div class="left_background_image" id='+(k)+'>' +
    				' <div class="image_heart"></div>' +
    				' <div class="text_hotel_price">￥'+roomUnitPricelist1[k]+'</div>' +
    				' </div>' +
//	    				' <div class="left_image_round" ></div>' +
    				' <div class="left_text_information">' +
    				'    <div class="left_text_address">四季青藤'+roomNumberlist1[k]+'号房</div><br>' +
    				'    <div class="left_text_star">' +
    				'   <div class="left_text_room">'+typeresult1[k]+'</div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="yellow_star"></div>' +
//	    				'  <div class="left_text_room">•108条评价</div>' +
    				'  </div>' +
    				' </div>' +
    				'  </div>'
    		)
    		$("#"+k+"").css({"background-image":"url('"+roompicturelist1[k]+"')"});
	    	$(".left_background_image").css({"background-size":"100% 100%"});
		}
		$(".text_bottom_number_box").html("");
		page=Math.ceil(roomUnitPricelist1.length/18);  	
		for(var i=0;i<page;i++){	    		
			var x=i+1;
			$(".text_bottom_number_box").append(
				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_price('+i+')">'+x+'</div>'
				);
		}
		$(".text_bottom_number_box").append(
			'<div class="text_bottom_next" onclick="nextpage_price()">▶</div>'
			);
	}
}

//显示价格
function Disp_Price()
{
	var price="";
	for(var i=0;i<3;i++)
	{
		if(i==0)
		{
			price="低于500";
		}
		else if(i==1)
		{
			price="500~1000";
		}
		else
		{
			price="高于1000";
		}
		$(".Total_price").append(
		        '<div class="price_same"><input type="checkbox" class="price_checkbox'+i+'" onclick="DispRoomByPrice()"/> '+price+'</div>' 
		);
	}
}

//通过价格查找房间
function DispRoomByPrice()
{
	var tag=0;
	$(".mainpic_left_picture").html("");  //只让这条语句执行一次
//	addressIdlist.length=0;
	for(var i=0;i<3;i++)  //价格复选框循环
	{
		if(i==0)
		{
			homepointlist_temp.length=0;
			mappointerlist.length=0;
			roompicturelist_temp.length=0;
			roomUnitPricelist_temp.length=0;
			roomNumberlist_temp.length=0;
			typeresult_temp.length=0;
			roomIdlist_temp.length=0;
		}
		if($(".price_checkbox"+i+"").attr("checked")=="checked")
		{
			tag=1;     //说明价格框被选中
			Every_Price();     //更新数组
			//alert(roomUnitPricelist1.length)
			if(i==0)    //选中小于500的价格复选框
			{
				for(var j=0;j<Address.length;j++)      //地区复选框循环
				{				
					if($(".right_checkbox"+j+"").attr("checked")=="checked")   //地区栏中有复选框被选中
					{
						for ( var k = 0; k < roomUnitPricelist.length; k++) {
							if(roomUnitPricelist[k]<500)
							{
								homepointlist_temp.push(homepointlist[k]);
								roomIdlist_temp.push(roomIdlist[k]);
								roomUnitPricelist_temp.push(roomUnitPricelist[k]);
								roomNumberlist_temp.push(roomNumberlist[k]);
								typeresult_temp.push(typeresult[k]);
								roompicturelist_temp.push(roompicturelist[k]);		
							}
						}
						var max=18;
						if(roomUnitPricelist_temp.length<max){
							max=roomUnitPricelist_temp.length;
						}
						$(".mainpic_left_picture").html("");
						for(var k=0;k<max;k++)
						{
							$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist_temp[k].lat+' lon='+homepointlist_temp[k].lon+' onclick="tohome('+roomNumberlist_temp[k]+')" onmouseover="findpointer('+(k)+','+'\''+roomUnitPricelist_temp[k]+'\''+','+'\''+roomNumberlist_temp[k]+'\''+','+'\''+typeresult_temp[k]+'\')">'+
				    				' <div class="left_background_image" id='+(k)+'>' +
				    				' <div class="image_heart"></div>' +
				    				' <div class="text_hotel_price">￥'+roomUnitPricelist_temp[k]+'</div>' +
				    				' </div>' +
//				    				' <div class="left_image_round" ></div>' +
				    				' <div class="left_text_information">' +
				    				'    <div class="left_text_address">四季青藤'+roomNumberlist_temp[k]+'号房</div><br>' +
				    				'    <div class="left_text_star">' +
				    				'   <div class="left_text_room">'+typeresult_temp[k]+'</div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="left_text_room">•108条评价</div>' +
				    				'  </div>' +
				    				' </div>' +
				    				'  </div>'
				    		)
				    		$("#"+k+"").css({"background-image":"url('"+roompicturelist_temp[k]+"')"});
					    	$(".left_background_image").css({"background-size":"100% 100%"});
						}
						$(".text_bottom_number_box").html("");
			    		page=Math.ceil(roomUnitPricelist_temp.length/18);  	
			    		for(var l=0;l<page;l++){	    		
			    			var x=l+1;
			    			$(".text_bottom_number_box").append(
			    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_temp('+l+')">'+x+'</div>'
			    				);
			    		}
			    		$(".text_bottom_number_box").append(
			    			'<div class="text_bottom_next" onclick="nextpage_temp()">▶</div>'
			    			);
						break;
					}			
					else if(j==Address.length-1)
					{
						var max=18;
						if(roomUnitPricelist1.length<max){
							max=roomUnitPricelist1.length;
						}
						var temp=0;
						$(".mainpic_left_picture").html("");
						var count=0;
						for ( var x = 0; x < max; x++) {					    		
					    		$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist1[count+temp].lat+' lon='+homepointlist1[count+temp].lon+' onclick="tohome('+roomIdlist1[count+temp]+')" onmouseover="findpointer('+(count+temp)+','+'\''+roomUnitPricelist1[count+temp]+'\''+','+'\''+roomNumberlist1[count+temp]+'\''+','+'\''+typeresult1[count+temp]+'\')">'+
					    				' <div class="left_background_image" id='+(count+temp)+'>' +
					    				' <div class="image_heart"></div>' +
					    				' <div class="text_hotel_price">￥'+roomUnitPricelist1[count+temp]+'</div>' +
					    				' </div>' +
//						    				' <div class="left_image_round" ></div>' +
					    				' <div class="left_text_information">' +
					    				'    <div class="left_text_address">四季青藤'+roomNumberlist1[count+temp]+'号房</div><br>' +
					    				'    <div class="left_text_star">' +
					    				'   <div class="left_text_room">'+typeresult1[count+temp]+'</div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="left_text_room">•108条评价</div>' +
					    				'  </div>' +
					    				' </div>' +
					    				'  </div>'
					    		)
					    		
					    		$("#"+(temp+count)+"").css({"background-image":"url('"+roompicturelist1[temp+count]+"')"});
						    	$(".left_background_image").css({"background-size":"100% 100%"});
						    	count++;
//							    alert(count)
						}
						temp=temp+count;
					//		alert(temp)
						$(".text_bottom_number_box").html("");
			    		page=Math.ceil(roomUnitPricelist1.length/18);  	
			    		for(var l=0;l<page;l++){	    		
			    			var x=l+1;
			    			$(".text_bottom_number_box").append(
			    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_price('+l+')">'+x+'</div>'
			    				);
			    		}
			    		$(".text_bottom_number_box").append(
			    			'<div class="text_bottom_next" onclick="nextpage_price()">▶</div>'
			    			);
					}
				}
			}
			else if(i==1)
			{
				for(var j=0;j<Address.length;j++)      //地区复选框循环
				{
					if($(".right_checkbox"+j+"").attr("checked")=="checked")   //地区栏中有复选框被选中
					{
						for ( var k = 0; k < roomUnitPricelist.length; k++) {
							if( (roomUnitPricelist[k]>500 &&roomUnitPricelist[k]<1000) ||roomUnitPricelist[k]==500 ||roomUnitPricelist[k]==1000)
							{
								homepointlist_temp.push(homepointlist[k]);
								roomIdlist_temp.push(roomIdlist[k]);
								roomUnitPricelist_temp.push(roomUnitPricelist[k]);
								roomNumberlist_temp.push(roomNumberlist[k]);
								typeresult_temp.push(typeresult[k]);
								roompicturelist_temp.push(roompicturelist[k]);		
							}
						}
						var max=18;
						if(roomUnitPricelist_temp.length<max){
							max=roomUnitPricelist_temp.length;
						}
						$(".mainpic_left_picture").html("");
						for(var k=0;k<max;k++)
						{
							$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist_temp[k].lat+' lon='+homepointlist_temp[k].lon+' onclick="tohome('+roomNumberlist_temp[k]+')" onmouseover="findpointer('+(k)+','+'\''+roomUnitPricelist_temp[k]+'\''+','+'\''+roomNumberlist_temp[k]+'\''+','+'\''+typeresult_temp[k]+'\')">'+
				    				' <div class="left_background_image" id='+(k)+'>' +
				    				' <div class="image_heart"></div>' +
				    				' <div class="text_hotel_price">￥'+roomUnitPricelist_temp[k]+'</div>' +
				    				' </div>' +
//				    				' <div class="left_image_round" ></div>' +
				    				' <div class="left_text_information">' +
				    				'    <div class="left_text_address">四季青藤'+roomNumberlist_temp[k]+'号房</div><br>' +
				    				'    <div class="left_text_star">' +
				    				'   <div class="left_text_room">'+typeresult_temp[k]+'</div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="left_text_room">•108条评价</div>' +
				    				'  </div>' +
				    				' </div>' +
				    				'  </div>'
				    		)
				    		$("#"+k+"").css({"background-image":"url('"+roompicturelist_temp[k]+"')"});
					    	$(".left_background_image").css({"background-size":"100% 100%"});
						}
						$(".text_bottom_number_box").html("");
			    		page=Math.ceil(roomUnitPricelist_temp.length/18);  	
			    		for(var q=0;q<page;q++){	    		
			    			var x=q+1;
			    			$(".text_bottom_number_box").append(
			    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_temp('+q+')">'+x+'</div>'
			    				);
			    		}
			    		$(".text_bottom_number_box").append(
			    			'<div class="text_bottom_next" onclick="nextpage_temp()">▶</div>'
			    			);
						break;
					}
					else if(j==Address.length-1)
					{	
						var max=18;
						if(roomUnitPricelist1.length<max){
							max=roomUnitPricelist1.length;
						}
						var temp=0;
						$(".mainpic_left_picture").html("");
						var count=0;
						for ( var x = 0; x < max; x++) {					    		
					    		$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist1[count+temp].lat+' lon='+homepointlist1[count+temp].lon+' onclick="tohome('+roomIdlist1[count+temp]+')" onmouseover="findpointer('+(count+temp)+','+'\''+roomUnitPricelist1[count+temp]+'\''+','+'\''+roomNumberlist1[count+temp]+'\''+','+'\''+typeresult1[count+temp]+'\')">'+
					    				' <div class="left_background_image" id='+(count+temp)+'>' +
					    				' <div class="image_heart"></div>' +
					    				' <div class="text_hotel_price">￥'+roomUnitPricelist1[count+temp]+'</div>' +
					    				' </div>' +
//						    				' <div class="left_image_round" ></div>' +
					    				' <div class="left_text_information">' +
					    				'    <div class="left_text_address">四季青藤'+roomNumberlist1[count+temp]+'号房</div><br>' +
					    				'    <div class="left_text_star">' +
					    				'   <div class="left_text_room">'+typeresult1[count+temp]+'</div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="left_text_room">•108条评价</div>' +
					    				'  </div>' +
					    				' </div>' +
					    				'  </div>'
					    		)
					    		
					    		$("#"+(temp+count)+"").css({"background-image":"url('"+roompicturelist1[temp+count]+"')"});
						    	$(".left_background_image").css({"background-size":"100% 100%"});
						    	count++;
//							    alert(count)
						}
						temp=temp+count;
					//		alert(temp)
						$(".text_bottom_number_box").html("");
			    		page=Math.ceil(roomUnitPricelist1.length/18);  	
			    		for(var w=0;w<page;w++){	    		
			    			var x=w+1;
			    			$(".text_bottom_number_box").append(
			    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_price('+w+')">'+x+'</div>'
			    				);
			    		}
			    		$(".text_bottom_number_box").append(
			    			'<div class="text_bottom_next" onclick="nextpage_price()">▶</div>'
			    			);
					}
				}
			}
			else if(i==2)
			{
				for(var j=0;j<Address.length;j++)      //地区复选框循环
				{
					if($(".right_checkbox"+j+"").attr("checked")=="checked")   //地区栏中有复选框被选中
					{
						for ( var k = 0; k < roomUnitPricelist.length; k++) {
							if( roomUnitPricelist[k]>1000)
							{
								homepointlist_temp.push(homepointlist[k]);
								roomIdlist_temp.push(roomIdlist[k]);
								roomUnitPricelist_temp.push(roomUnitPricelist[k]);
								roomNumberlist_temp.push(roomNumberlist[k]);
								typeresult_temp.push(typeresult[k]);
								roompicturelist_temp.push(roompicturelist[k]);		
							}
						}
						var max=18;
						if(roomUnitPricelist_temp.length<max){
							max=roomUnitPricelist_temp.length;
						}
						$(".mainpic_left_picture").html("");
						for(var k=0;k<max;k++)
						{
							$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist_temp[k].lat+' lon='+homepointlist_temp[k].lon+' onclick="tohome('+roomNumberlist_temp[k]+')" onmouseover="findpointer('+(k)+','+'\''+roomUnitPricelist_temp[k]+'\''+','+'\''+roomNumberlist_temp[k]+'\''+','+'\''+typeresult_temp[k]+'\')">'+
				    				' <div class="left_background_image" id='+(k)+'>' +
				    				' <div class="image_heart"></div>' +
				    				' <div class="text_hotel_price">￥'+roomUnitPricelist_temp[k]+'</div>' +
				    				' </div>' +
//				    				' <div class="left_image_round" ></div>' +
				    				' <div class="left_text_information">' +
				    				'    <div class="left_text_address">四季青藤'+roomNumberlist_temp[k]+'号房</div><br>' +
				    				'    <div class="left_text_star">' +
				    				'   <div class="left_text_room">'+typeresult_temp[k]+'</div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="yellow_star"></div>' +
//				    				'  <div class="left_text_room">•108条评价</div>' +
				    				'  </div>' +
				    				' </div>' +
				    				'  </div>'
				    		)
				    		$("#"+k+"").css({"background-image":"url('"+roompicturelist_temp[k]+"')"});
					    	$(".left_background_image").css({"background-size":"100% 100%"});
						}
						$(".text_bottom_number_box").html("");
			    		page=Math.ceil(roomUnitPricelist_temp.length/18);  	
			    		for(var e=0;e<page;e++){	    		
			    			var x=e+1;
			    			$(".text_bottom_number_box").append(
			    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_temp('+e+')">'+x+'</div>'
			    				);
			    		}
			    		$(".text_bottom_number_box").append(
			    			'<div class="text_bottom_next" onclick="nextpage_temp()">▶</div>'
			    			);
						break;
					}
					else if(j==Address.length-1)
					{	
						var max=18;
						if(roomUnitPricelist1.length<max){
							max=roomUnitPricelist1.length;
						}
						var temp=0;
						$(".mainpic_left_picture").html("");
						var count=0;
						for ( var x = 0; x < max; x++) {					    		
					    		$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist1[count+temp].lat+' lon='+homepointlist1[count+temp].lon+' onclick="tohome('+roomIdlist1[count+temp]+')" onmouseover="findpointer('+(count+temp)+','+'\''+roomUnitPricelist1[count+temp]+'\''+','+'\''+roomNumberlist1[count+temp]+'\''+','+'\''+typeresult1[count+temp]+'\')">'+
					    				' <div class="left_background_image" id='+(count+temp)+'>' +
					    				' <div class="image_heart"></div>' +
					    				' <div class="text_hotel_price">￥'+roomUnitPricelist1[count+temp]+'</div>' +
					    				' </div>' +
//						    				' <div class="left_image_round" ></div>' +
					    				' <div class="left_text_information">' +
					    				'    <div class="left_text_address">四季青藤'+roomNumberlist1[count+temp]+'号房</div><br>' +
					    				'    <div class="left_text_star">' +
					    				'   <div class="left_text_room">'+typeresult1[count+temp]+'</div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="yellow_star"></div>' +
//						    				'  <div class="left_text_room">•108条评价</div>' +
					    				'  </div>' +
					    				' </div>' +
					    				'  </div>'
					    		)
					    		
					    		$("#"+(temp+count)+"").css({"background-image":"url('"+roompicturelist1[temp+count]+"')"});
						    	$(".left_background_image").css({"background-size":"100% 100%"});
						    	count++;
//							    alert(count)
						}
						temp=temp+count;
					//		alert(temp)
						$(".text_bottom_number_box").html("");
			    		page=Math.ceil(roomUnitPricelist1.length/18);  	
			    		for(var l=0;l<page;l++){	    		
			    			var x=l+1;
			    			$(".text_bottom_number_box").append(
			    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage_price('+l+')">'+x+'</div>'
			    				);
			    		}
			    		$(".text_bottom_number_box").append(
			    			'<div class="text_bottom_next" onclick="nextpage_price()">▶</div>'
			    			);
					}
				}
			}
		}
		
	}
	if(tag==0)     //价格复选框都没被选中
	{
		for ( var j = 0; j < Address.length; j++) {       //地区循环
			if($(".right_checkbox"+j+"").attr("checked")=="checked"){
				$(".mainpic_left_picture").html("");
				var max=18;
				if(roomUnitPricelist.length<max){
					max=roomUnitPricelist.length;
				}
				for ( var k = 0; k < roomUnitPricelist.length; k++) {
					$(".mainpic_left_picture").append('  <div  class="left_box_picture" lat='+homepointlist[k].lat+' lon='+homepointlist[k].lon+' onclick="tohome('+roomNumberlist[k]+')" onmouseover="findpointer('+(k)+','+'\''+roomUnitPricelist[k]+'\''+','+'\''+roomNumberlist[k]+'\''+','+'\''+typeresult[k]+'\')">'+
		    				' <div class="left_background_image" id='+(k)+'>' +
		    				' <div class="image_heart"></div>' +
		    				' <div class="text_hotel_price">￥'+roomUnitPricelist[k]+'</div>' +
		    				' </div>' +
//			    				' <div class="left_image_round" ></div>' +
		    				' <div class="left_text_information">' +
		    				'    <div class="left_text_address">四季青藤'+roomNumberlist[k]+'号房</div><br>' +
		    				'    <div class="left_text_star">' +
		    				'   <div class="left_text_room">'+typeresult[k]+'</div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="yellow_star"></div>' +
//			    				'  <div class="left_text_room">•108条评价</div>' +
		    				'  </div>' +
		    				' </div>' +
		    				'  </div>'
		    		)
		    		$("#"+k+"").css({"background-image":"url('"+roompicturelist[k]+"')"});
			    	$(".left_background_image").css({"background-size":"100% 100%"});
				}
				$(".text_bottom_number_box").html("");
	    		page=Math.ceil(roomUnitPricelist.length/18);  	
	    		for(var f=0;f<page;f++){	    		
	    			var x=f+1;
	    			$(".text_bottom_number_box").append(
	    				' <div id="text_bottom_number" class="text_bottom_number" onclick="changepage('+f+')">'+x+'</div>'
	    				);
	    		}
	    		$(".text_bottom_number_box").append(
	    			'<div class="text_bottom_next" onclick="nextpage()">▶</div>'
	    			);
				break;
//				DispRoomByAddress();
//				break;
			}
			else if(j==Address.length-1)
			{
				$(".mainpic_left_picture").html("");
			}
		}	
	}
}
			
