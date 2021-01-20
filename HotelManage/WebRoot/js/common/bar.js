$(document).ready(function(){
	
	if (baruserid!=0) {
		$(".blackbar").hide();
		$(".homehead_person_show").show();
		$(".homehead_input_right").hide();
		var json={
				"UserId":baruserid
		}
		
		$.getJSON("./GetSingelUserServlet",{json:JSON.stringify(json)},function(json){
			$(".homehead_person_head").css({"background":"url("+json.result.userPicture+")"});
			$(".homehead_person_head").css({"background-size":"100%"});
		});
	}
	searchAddress();
});
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
			'<div class="modal-cell-registerbutton"><button  onclick="zhuce()">注册</button></div>'+
			'<div class="modal-cell-registertitle3">已经是Airbnb会员？<font onclick="showlogin()">登录</font></div>'+
		'</div>'+
	'</div>');
	$(".blackbar").show();
}

function showlogin() {
	$(".blackbar").html('<div class="modal-cell" ><div class="main" ><i class="iconfont" id="del" onclick="closeblackbar()">&#xf0204</i>'
			
			+ '<div class="suiyi1">'
			+ '<div class="guge">'
			+ '<div class="guge1"></div>'
			+ '<div class="guge2" onclick="change1()">用手机登录</div>'
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
			+ '<div class="guge2" onclick="change2()">用邮箱登录</div>'
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

function change1(){
	$(".suiyi1").hide();
	$(".suiyi2").show();
}
function change2() {
	$(".suiyi2").hide();
	$(".suiyi1").show();
}

function closeblackbar() {
	$(".blackbar").hide();
}

function showmianpage() {
	window.location.href="jsp/userjsp/main.jsp"
}

function showvip() {
	window.location.href="jsp/userjsp/vippage.jsp"
}

function tosearch() {
	var address=$(".homehead-input").val();
	if (address=="") {
		address="海曙区";
	}
	var key=parseInt($("#me").attr("search"));
	if (key==0) {//不在搜索界面则跳转
		var startdata="";
		var enddata="";
		var people="";
		window.location.href="jsp/userjsp/search.jsp?where="+address+"&startdata="+startdata+"&enddata="+enddata+"&people="+people+"&userid="+userid;
	}
	else {
		onesearch();//在搜索界面则不跳转
	}
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

/*//百度地图API功能（搜索自动填补列表）
function G(id) {
	return document.getElementById(id);
}

var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
	{"input" : "suggestId"
	,"location" : 0
});

ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
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

var myValue;
ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
var _value = e.item.value;
	myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
	G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
	
	tosearch();
}); */


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

//退出登入
function exitlongin() {
	
	$.getJSON("./ExitLoginServlet",function(json){
		if(json.result==true){
			alert("退出成功！");
		}
		else{
			alert("退出未成功，请重试");
		}
	});
	window.location.href="jsp/userjsp/main.jsp"
}



//跳转到personinfo
function topersoninfo() {
	var indata="";
	var outdata="";
	var people="";
	var roomtotalMoney="";
	var roomId=0;
	window.location.href="jsp/userjsp/personinfo.jsp?indata="+indata+"&outdata="+outdata+"&people="+people+"&roomId="+roomId+"&userid="+userid+"&roomtotalMoney="+roomtotalMoney;
}

//显示退出按钮
function showquitbutton() {
	$(".homehead_person_quit").show();
}
//隐藏退出按钮
function hidequitbutton() {
	$(".homehead_person_quit").hide();
}
