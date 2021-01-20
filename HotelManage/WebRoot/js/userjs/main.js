$(document).ready(function(){

	if (userid!=0) {
		$(".blackbar").hide();
		$(".homehead_person_show").show();
		$(".mainpic_title_two").hide();
		
		
		var json={
				"UserId":userid
		}
		
		$.getJSON("./GetSingelUserServlet",{json:JSON.stringify(json)},function(json){
			//alert(json.result.userPicture);
			$(".homehead_person_head").css({"background":"url("+json.result.userPicture+")"});
			$(".homehead_person_head").css({"background-size":"100%"});
		});
		
		
		
		$(".homehead_person_show").css({"background-color":"#ffffff"});
		$(".mainpic-title-one").hide();
	}
	
	showhome1();
	showhome2();
	searchAddress();
	pic_array();
	
});

//图片跳转
function pic_array(){
	var picture=new Array("img/title_main.jpg","img/room-img/cixi2.jpg","img/room-img/jiangdong1.jpg","img/yuyao (2).jpg");
	for ( var i = 0; i < 4; i++) {
		$(".pic_one").eq(i).css("background-image","url('"+picture[i]+"')");
	}
}

//右按钮
function press_right() {
	var range=$(".mainpic_box").css("width");
	var right=$(".pic_four").css("right");
	var goright=parseInt(range)+parseInt(right);
	var max=parseInt($(".pic_four").css("width"));
	if(goright>=max){
		goright=0;
	}
	$(".pic_four").css("right",goright);
}

//左按钮
function press_left() {
	var range=$(".mainpic_box").css("width");
	var right=$(".pic_four").css("right");
	var goright=parseInt(right)-parseInt(range);
	if(parseInt(right)>0){
		$(".pic_four").css("right",goright);
	}
}
/*
var main_image=new Array("img/title_main.jpg","img/room-img/cixi2.jpg","img/room-img/jiangdong1.jpg","img/yuyao (2).jpg");
var i=0;
//图片跳转
function press_left(){
	i++;
	if(i>3 || i<0)
	{
		i=0;
	}
	$(".mainpic").css({
		"background-image":"url('"+main_image[i]+"')",
	});
}

//图片跳转
function press_right(){
	i--;
	if(i>3 || i<0)
	{
		i=3;
	}
	$(".mainpic").css({
		"background-image":"url('"+main_image[i]+"')",
	});
}
*/

//显示注册框
function showregister() {

	$(".blackbar").html('<div class="modal-cell" >'+
			'<div class="modal-cell-register"><i class="iconfont" id="del" onclick="closeblackbar()">&#xf0204</i>'+
			'<div class="modal-cell-registertitle">通过<font>谷歌</font>或<font>微博</font>注册</div>'+
			'<div class="modal-cell-line"><div class="modal-cell-line1"></div><font>或</font><div class="modal-cell-line2"></div></div>'+
			'<input type="text" placeholder="姓名" class="modal-cell-name1"/>'+
			'<input type="text" placeholder="电话" class="modal-cell-name2"/>'+
			'<input type="text" placeholder="电子邮件地址" class="modal-cell-email"/>'+
			'<input type="password" placeholder="密码" class="modal-cell-password"/>'+
			//'<input type="text" placeholder="生日" class="modal-cell-birthday" onclick="SelectDate(this,\'yyyy-MM-dd\')"/>'+
			'<div class="modal-cell-checkbox"><input type="checkbox" > <font>我想要收到优惠券和灵感</font></div>'+
			'<div class="modal-cell-registertitle2">注册即代表我同意<font>服务条款</font>、<font>隐私政策</font>、<font>房客退款政策</font> 及<font>房东保障计划条款</font>。</div>'+
			'<div class="modal-cell-registerbutton"><button onclick="zhuce()">注册<tton></div>'+
			'<div class="modal-cell-registertitle3">已经是Airbnb会员？<font onclick="showlogin()"> 登录</font></div>'+
		'</div>'+
	'</div>');
	$(".blackbar").show();
}

//显示登录框
function showlogin() {
$(".blackbar").html('<div class="modal-cell" ><div class="main" ><i class="iconfont" id="del" onclick="closeblackbar()">&#xf0204</i>'
			
			+ '<div class="suiyi1">'
			+ '<div class="guge">'
			+ '<div class="guge1"></div>'
			+ '<div class="guge2" onclick="tophone()">用手机登录</div>'
			+ '</div>'
			+ '<div class="or">'
			+ '<div class="or1"></div>'
			+ '<div class="or2">或</div>'
			+ '<div class="or3"></div>'
			+ '</div>'
			+ '<div class="input">'
			+ '<input class="input1" id="emailnumber" placeholder="电子邮件地址" type="text" />'
			+ '</div>'
			+ '<div class="password">'
			+ '<input class="password1" id="emailpassword" placeholder="密码" type="password" />'
			+ '</div>'
			+ '<div class="forget">'
			+ '<div class="forget3">'
			+ '<input type="checkbox" name="remember" class="forget1"/>'
			+ '</div>'
			+ '<div class="forget2">自动登录</div>'
			+ '<div class="forget4">忘记密码？</div>'
			+ '</div>'
			+ '<div class="button1">'
			+ '<button type="button" class="button" onclick="LoginEmail()">登录</button>'
			+ '</div>'
			+ '<div class="line"></div>'
			+ '<div class="no">'
			+ '<div class="no1">还没有账号？</div>'
			+ '<div class="no2">'
			+ '<a href="#" style="color:#ff5a5f;text-decoration:none;" onclick="showregister()">注册</a>'
			+ '</div>' 
			+ '</div>' 
			+ '</div>' 
			
			
			
			+ '<div class="suiyi2" style="display: none;">'
			+ '<div class="guge">'
			+ '<div class="guge3"></div>'
			+ '<div class="guge2" onclick="toemail()">用邮箱登录</div>'
			+ '</div>'
			+ '<div class="or">'
			+ '<div class="or1"></div>'
			+ '<div class="or2">或</div>'
			+ '<div class="or3"></div>'
			+ '</div>'
			+ '<div class="input">'
			+ '<input class="input1" id="phonenumber" placeholder="电话号码" type="text" />'
			+ '</div>'
			+ '<div class="password">'
			+ '<input class="password1" id="phonepassword" placeholder="密码" type="password" />'
			+ '</div>'
			+ '<div class="forget">'
			+ '<div class="forget3">'
			+ '<input type="checkbox" name="remember" class="forget1"/>'
			+ '</div>'
			+ '<div class="forget2">自动登录</div>'
			+ '<div class="forget4">忘记密码？</div>'
			+ '</div>'
			+ '<div class="button1">'
			+ '<button type="button" class="button" onclick="LoginPhone()">登录</button>'
			+ '</div>'
			+ '<div class="line"></div>'
			+ '<div class="no">'
			+ '<div class="no1">还没有账号？</div>'
			+ '<div class="no2">'
			+ '<a href="#" style="color:#ff5a5f;text-decoration:none;" onclick="showregister()">注册</a>'
			+ '</div>' + '</div>' + '</div>' 
			
			
			
			+'</div></div>');
			$(".blackbar").show();
}

//电话登录
function tophone(){
	$(".suiyi1").hide();
	$(".suiyi2").show();
}
//邮箱登入
function toemail() {
	$(".suiyi2").hide();
	$(".suiyi1").show();
}

//关闭登入框或者是注册框
function closeblackbar() {
	$(".blackbar").hide();
}


//图片轮播
var image=new Array("img/end_image_1.jpg","img/end_image_2.jpg","img/end_image_3.jpg")
var i=0;
function change1()
{	
	i++;
	if(i>2||i<0){i=0;}
	document.a1.src=image[i];
	
}
function change2()
{
	i--;
	if(i<0||i>2){i=2;}
	document.a1.src=image[i];
	
}

function showhome1() {
	
	var rommId=1;
	var json={
			"RoomId":rommId,
	}
	
	
	$.getJSON("./GetRoomDetailServlet",{json:JSON.stringify(json)},function(json){
		
		$(".panel2_line3_block1_box").html(
				'<div class="panel2-line3-block1" onclick="tohome('+rommId+')">'
				+'<div class="panel2-line3-block1-title">四季青藤'+json.result.Room.roomNumber+'号房</div>'
				+'<div class="panel2-line3-block1-content">宁波</div>'
			    +'</div>');
		$(".panel2-line3-block1").css({"background-image":"url('"+json.result.Room.roomPicture+"')"});
		
		$(".panel2-line3-block1").css({"background-size":"100% 100%"});
	});
}

function showhome2() {
	
	var rommId=2;
	var json={
			"RoomId":rommId,
	}
	
	
	$.getJSON("./GetRoomDetailServlet",{json:JSON.stringify(json)},function(json){
		
		$(".panel2-line1-block2-box").html(
				'<div class="panel2-line1-block2" onclick="tohome('+rommId+')">'
				+'<div class="panel2-line1-block2-title">四季青藤'+json.result.Room.roomNumber+'号房</div>'
				+'<div class="panel2-line1-block2-content">宁波</div>'
			    +'</div>'
			    );
		$(".panel2-line1-block2").css({"background-image":"url('"+json.result.Room.roomPicture+"')"});
		$(".panel2-line1-block2").css({"background-size":"100% 100%"});
	});
	
}

//跳转到房间界面
function tohome(r) {
	var now=new Date();
	var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日
    var indata=year+"-"+month+"-"+day;
    var SpiltCheckOutTime=indata.split("-");   //字符串拆分
	var date=new Date(SpiltCheckOutTime);            //把旧的日期当做当天日期
	date.setDate(parseInt(SpiltCheckOutTime[2])+1);    //加上1天
	var newday=(date.getDate()).toString();                      //获得年月日的字符串类型
	var newmonth=(date.getMonth()+1).toString();
	var newyear=(date.getFullYear()).toString();
	var outdata=newyear+"-"+newmonth+"-"+newday;

	var people="";
	var roomId=r;
	window.location.href="jsp/userjsp/home.jsp?indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid;
}


function blackbarhide(x) {
	$(x).hide();
	
}

//跳转到vip界面
function showvip() {
	window.location.href="jsp/userjsp/vippage.jsp"
}

//注册
function zhuce() {
	
	var username=$(".modal-cell-name1").val();
	var userphon=$(".modal-cell-name2").val();
	var useremail=$(".modal-cell-email").val();
	var userpassword=$(".modal-cell-password").val();
	if(username==null&&userphon==null&&useremail==null&&userpassword==null){
		alert("登录信息为空！");
	}
	var json={
		"UserName":username,
		"UserPhone":userphon,
		"UserPassword":userpassword,
		"UserEmail":useremail
	}
	
	$.getJSON("./CreateUserServlet",{json:JSON.stringify(json)},function(json){
		if(json.result==true){
			$(".blackbar").hide();
			alert("注册成功，请登录！");
		}
		
	});
}

//使用邮登录
function LoginEmail() {
	
	var emailnumber=$("#emailnumber").val();
	var emailpassword=$("#emailpassword").val();
	
	if(emailnumber==""||emailpassword==""){
		alert("登录信息不能为空！");
	}
	else{
		var json={
				"UserEmail":emailnumber,
				"UserPassword":emailpassword,
		}
		$.getJSON("./UserLoginEmailServlet",{json:JSON.stringify(json)},function(json){
			if(json.result==true){
			
		    	 window.location.reload();//刷新当前页面.
			}
			else if(json.result==false){
				alert("输入的用户名或者密码不正确");
			}
			
		});
	}
}

//使用电话登录
function LoginPhone() {
    var phonenumber=$("#phonenumber").val();
    var phonepassword=$("#phonepassword").val();

    if(phonenumber==""||phonepassword==""){
        alert("登录信息不能为空！");
    }
    else{
        var json={
        "UserPhone":phonenumber,
        "UserPassword":phonepassword,
        }
    $.getJSON("./UserLoginPhonServlet",{json:JSON.stringify(json)},function(json){
    	if(json.result==true){
			
	    	 window.location.reload();//刷新当前页面.
		}
		else if(json.result==false){
			alert("输入的用户名或者密码不正确");
		}
    });
    }
}


//跳转到search界面
function tosearch() {
	var address=$(".mainpic-black-input1").val();
	
	
	var startdata=$(".mainpic-black-input2").val();//获取入住日期
	var enddata=$(".mainpic-black-input3").val();//获取退房日期
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	if (address==""||startdata==""||enddata=="") {
		alert("搜索条件不可为空！");
	}
	else{
		window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid;
	}
}

//搜索海曙区
function fengling() {
	
	 var addressbefore=document.getElementById("fengling").innerHTML;
	 var address=addressbefore+"区";
	
	var startdata=$(".mainpic-black-input2").val();//获取入住日期
	var enddata=$(".mainpic-black-input3").val();//获取退房日期
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	
	window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid}

//搜索镇海区
function ziran() {
	
    var addressbefore=document.getElementById("ziran").innerHTML;
	 var address=addressbefore+"区";
	
	var startdata=$(".mainpic-black-input2").val();//获取入住日期
	var enddata=$(".mainpic-black-input3").val();//获取退房日期
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	
	window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid}

//搜索鄞州区
function pingyao() {
	
	 var addressbefore=document.getElementById("pingyao").innerHTML;
	 var address=addressbefore+"区";
	
	var startdata=$(".mainpic-black-input2").val();//获取入住日期
	var enddata=$(".mainpic-black-input3").val();//获取退房日期
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	
	window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid
	}

//搜索江北区
function tongyi() {
	var addressbefore=document.getElementById("tongyi").innerHTML;
	 var address=addressbefore+"区";
	
	var startdata=$(".mainpic-black-input2").val();//获取入住日期
	var enddata=$(".mainpic-black-input3").val();//获取退房日期
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	
	window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid
	}

//搜索江东区
function lishutang() {
	var addressbefore=document.getElementById("lishutang").innerHTML;
	 var address=addressbefore+"区";
	
	var startdata=$(".mainpic-black-input2").val();//获取入住日期
	var enddata=$(".mainpic-black-input3").val();//获取退房日期
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	
	window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid}

//搜索余姚市
function qinyong() {
	var addressbefore=document.getElementById("qinyong").innerHTML;
	 var address=addressbefore+"市";
	
	var startdata=$(".mainpic-black-input2").val();//获取入住日期
	var enddata=$(".mainpic-black-input3").val();//获取退房日期
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid
}

//搜索慈溪市
function shaobai() {
	var addressbefore=document.getElementById("shaobai").innerHTML;
	 var address=addressbefore+"市";
	
	var startdata=$(".mainpic-black-input2").val();//获取入住日期
	var enddata=$(".mainpic-black-input3").val();//获取退房日期
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本
	
	window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid
	}

//搜索奉化
function hualong() {
	var addressbefore=document.getElementById("hualong").innerHTML;
	 var address=addressbefore+"市";
	
	var startdata=$(".mainpic-black-input2").val();//获取入住日期
	var enddata=$(".mainpic-black-input3").val();//获取退房日期
	
	//获取入住人数
	var  myselect=document.getElementById("test");//拿到select对象
	var index=myselect.selectedIndex ; //拿到选中项的引索
	var people=myselect.options[index].text;//拿到选中的option的文本

	
	window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid;
}


var allAddresslist=new Array();
//搜索全部地区
function searchAddress() {
	$.getJSON("./GetAllAddressesServlet",function(json){
		for(var x=0;x<json.length;x++){
			var addressVillage=json[x].addressVillage
			allAddresslist.push(addressVillage);
			
		}
		showVillage();
	});
	
}

//点击显示下拉列表
function showVillage() {
	
	$("#suggestId").autocomplete(allAddresslist,{
        minChars: 0, //双击空白文本框时显示全部提示数据
        formatItem: function (data, i, total) {
            return "<div>" + data[0] + "</div>"; //改变匹配数据显示的格式
        },
        formatMatch: function (data, i, total) {
            return data[0];
        },
        formatResult: function (data) {
            return data[0];
        }
    }).result(SearchCallback); 
    function SearchCallback(event, data, formatted) {
    
    }
}


/*
//百度地图API功能（搜索自动填补列表）
function G(id) {
	return document.getElementById(id);
}

//建立一个自动完成的对象
var ac = new BMap.Autocomplete(   
	{"input" : "suggestId"
	,"location" : 0
});

//鼠标放在下拉列表上的事件
ac.addEventListener("onhighlight", function(e) {  
var str = "";
	var _value = e.fromitem.value;
	var value = "";
	if (e.fromitem.index > -1) {
		value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
	}    
	str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
	
	value = "";
	if (e.toitem.index > -1) {
		_value = e.toitem.value;
		value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
	}    
	str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
	G("searchResultPanel").innerHTML = str;
});

//鼠标点击下拉列表后的事件
var myValue;
ac.addEventListener("onconfirm", function(e) {    
var _value = e.item.value;
	myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
	G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
	

}); */


//跳转到personinfo
function topersoninfo() {
	
//	var indata="";
//	var outdata="";
//	var people="";
//	var roomtotalMoney="";
//	var rommId=0;
	window.location.href="jsp/userjsp/personinfo.jsp?indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid+"&roomtotalMoney="+roomtotalMoney;
}

function gotopersoninfo() {

	var indata="";
	var outdata="";
	var people="";
	var roomId=0;
	var roomtotalMoney="";
	
    window.location.href="jsp/userjsp/personinfo.jsp?indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid+"&roomtotalMoney="+roomtotalMoney;
}


