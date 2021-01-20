$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	showvippic();
	showvipcon();
	showvipactivity();
});

function showvippic(){
	var pic=new Array("img/vip0.jpg","img/vip1.jpg","img/vip2.jpg","img/vip3.jpg","img/vip4.png");
	for ( var i = 0; i < 5; i++) {
		$(".vipinpicone").eq(i).css("background-image","url('"+pic[i]+"')");
	}
}

//右按钮
function vippicright() {
	var range=$(".vippic").css("width");
	var right=$(".vipinpic").css("right");
	var goright=parseInt(range)+parseInt(right);
	var max=parseInt($(".vipinpic").css("width"));
	if(goright>=max){
		goright=0;
	}
	$(".vipinpic").css("right",goright);
}

//左按钮
function vippicleft() {
	var range=$(".vippic").css("width");
	var right=$(".vipinpic").css("right");
	var goright=parseInt(right)-parseInt(range);
	if(parseInt(right)>0){
	$(".vipinpic").css("right",goright);
	}
}


//显示vip优惠
function showvipcon() {
	for ( var i = 0; i < 5; i++) {
		var x=i+1;
		$(".vipconmore").append('<div class="vipconone">'+
				'<div class="vipconone-left">VIP'+x+'</div>'+
				'<div class="vipconone-right">'+
					'<div class="vipconone-right-case">成为条件：<font>充值大于'+x+'00元</font></div>'+
					'<div>享受优惠：</div>'+
					'<div class="vipconone-right-list">'+
						'1.入住优先于普通用户</br>'+
						'2.享受住房9.8折优惠'+
					'</div>'+
				'</div>'+
			'</div>')
	}
}
//显示vip活动
function showvipactivity() {
	for ( var i = 0; i < 8; i++) {
		$(".vipactivitylist").append('<div class="vipactivityone">'+
				'<div class="vipactivityone-black">'+
					'<div class="vipactivityone-title">新活动</div>'+
					'<div class="vipactivityone-con">我是活动内容内容内容内容内容内容内容内容内容内容内容</div>'+
				'</div>'+
			'</div>');
	}
}
function topay(){
	window.location.href="jsp/userjsp/pay.jsp"
	
}