
/**
 * 
 * 获取url中的参数
 * 
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);   // 匹配目标参数
	if (r != null) return unescape(r[2]); 
	return null;  // 返回参数值
}

$(document).ready(function() {
	showdata();
	
})
function middleClose(){
	$("#organizePanel").hide();
}
//弹出框
function entering(obj){
	$("#organizePanel").show();
	$(".Frameinformation").remove();
	$(".Phonetext").remove();
	$(".middleFrame").append(
			"<div class='Frameinformation'></div>"+
			"<button class='Phonetext' onclick='okenter()'>"+"确认"+"</button>");
	switch (obj.className){
	case "nickname":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"昵称:"+"</span>"+
        		"<input class='nickname1' id='font_size input_style'>"+
        		"</input>"
		);
		if($("#nickname").text()!="未设置"){
			$(".nickname1").val($("#nickname").text());
		}
		break;
	case "Name":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"姓名:"+"</span>"+
        		"<input class='name1' id='font_size input_style'>"+
        		"</input>"
		);
		if($("#Name").text()!="未设置"){
			$(".name1").val($("#Name").text());
		}
		break;
		
	case "sex":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"性别:"+"</span>"+
        		"<select class='sex1' id='font_size input_style'>"+
        			"<option>"+"男"+"</option>"+
        			"<option>"+"女"+"</option>"+
        		"</select>"
		);
		if($("#sex").text()!="未设置"){
			$(".sex1").val($("#sex").text());
		}
		break;
	case "phone":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"电话:"+"</span>"+
        		"<input class='contack_phone1' id='font_size input_style'>"+
        		"</input>"
		);
		if($("#phone").text()!="未设置"){
			$(".contack_phone1").val($("#phone").text());
		}
		break;
	case "revise":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"旧密码:"+"</span>"+
        		"<input class='password1' id='font_size input_style' type='password'>"+
        		"</br>"+
        		"<span id='font_size' style='margin-top:5px;'>"+"新密码:"+"</span>"+
        		"<input class='password2' id='font_size input_style' type='password'>"+
        		"</input>"
		);
		break;
	case "study":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"阶段:"+"</span>"+
        		"<select class='sex1' id='font_size input_style'>"+
        			"<option>"+"小学一年级"+"</option>"+
        			"<option>"+"小学二年级"+"</option>"+
        			"<option>"+"小学三年级"+"</option>"+
        			"<option>"+"小学四年级"+"</option>"+
        			"<option>"+"小学五年级"+"</option>"+
        			"<option>"+"小学六年级"+"</option>"+
        			"<option>"+"初中一年级"+"</option>"+
        			"<option>"+"初中二年级"+"</option>"+
        			"<option>"+"初中三年级"+"</option>"+
        			"<option>"+"高中一年级"+"</option>"+
        			"<option>"+"高中二年级"+"</option>"+
        			"<option>"+"高中三年级"+"</option>"+
        		"</select>"
		);
		if($("#study").text()!="未设置"){
			$(".grade1").val($("#study").text());
		}
		break;
	case "user_address":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"地址:"+"</span>"+
        		"<input class='address1' id='font_size input_style'>"+
        		"</input>"
		);
		break;
	case "school":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"学校:"+"</span>"+
        		"<input class='school1' id='font_size input_style'>"+
        		"</input>"
		);
		if($("#school").text()!="未设置"){
			$(".school1").val($("#school").text());
		}
		break;
	case "contact_people":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"联系:"+"</span>"+
        		"<input class='people1' id='font_size input_style'>"+
        		"</input>"
		);
		if($("#contact_people").text()!="未设置"){
			$(".people1").val($("#contact_people").text());
		}
		break;
	case "IDnumber":
		$(".Frameinformation").append(
				"<span id='font_size'>"+"身份证号:"+"</span>"+
        		"<input class='idnumber1' id='font_size input_style'>"+
        		"</input>"
		);
		if($("#IDnumber").text()!="未设置"){
			$(".idnumber1").val($("#IDnumber").text());
		}
		break;
	}
}

//显示数据

function showdata() {
	$.getJSON("./UserInfobyIdServlet",  {
		"UserId" : getUrlParam('userId') 
		}, 
		function(jsonObject) {
			$(".pic").attr('src',jsonObject.result.userPicture);
			$("#Name").text(jsonObject.result.userName);
			$("#nickname").text(jsonObject.result.userNickName);
			if(!jsonObject.result.userSex){
				$("#sex").text("未设置");
			}
			else {
				$("#sex").text(jsonObject.result.userSex);
			}
			if(!jsonObject.result.userContactsPhon){
				$("#phone").text("未设置");
			}
			else {
				$("#phone").text(jsonObject.result.userContactsPhon);
			}
			if(!jsonObject.result.userContactsMan){
				$("#contact_people").text("未设置");
			}
			else {
				$("#contact_people").text(jsonObject.result.userContactsMan);
			}
			if(!jsonObject.result.userSchool){
				$("#school").text("未设置");
			}
			else {
				$("#school").text(jsonObject.result.userSchool);
			}
			switch(jsonObject.result.userGrade){
			case 1:
				$("#study").text("一年级");
				break;
			case 2:
				$("#study").text("二年级");
				break;
			case 3:
				$("#study").text("三年级");
				break;
			case 4:
				$("#study").text("四年级");
				break;
			case 5:
				$("#study").text("五年级");
				break;
			case 6:
				$("#study").text("六年级");
				break;
			case 7:
				$("#study").text("初一");
				break;
			case 8:
				$("#study").text("初二");
				break;
			case 9:
				$("#study").text("初三");
				break;
			case 10:
				$("#study").text("高一");
				break;
			case 11:
				$("#study").text("高二");
				break;
			case 12:
				$("#study").text("高三");
				break;
			default:
				$("#study").text("未设置");
				break;
			}
			if(!jsonObject.result.userAddress){
				$("#user_address").text("未设置");
			}
			else {
				$("#user_address").text(jsonObject.result.userAddress);
			}
			if(!jsonObject.result.userIDNumber){
				$("#IdNumber").text("未设置");
			}
			else {
				$("#IdNumber").text("已设置");
			}
			
		});
}

function okenter() {
	switch($("input").attr('class')||$("select").attr('class')) {
	case "name1":
		var name = $("input").val();
		var json = {
				"UserId" : getUrlParam('userId') ,
				"UserName" : name
			// 初始化为当前页数
			};
		$.getJSON("./UpdataUserName",  {
			"data" : JSON.stringify(json)
			}, 
			function(jsonObject) {
				if(jsonObject.result==true){
					window.location.reload();
				}
				else {
					alert("修改姓名失败！");
				}
			});
		break;
	case "school1":
		var json = {
				"UserId" : getUrlParam('userId') ,
				"UserSchool" : $("input").val()
			};
		$.getJSON("./UpdateUserSchoolServlet",  {
			"data" : JSON.stringify(json)
		   }, 
			function(result) {
				if(result.result==true){
					window.location.reload();
				}
				else {
					alert("修改学校失败！");
				}
			});
		break;
	case "people1":
		
		var json = {
				"UserId" : getUrlParam('userId') ,
				"ContactMan" : $("input").val()
			};
		$.getJSON("./UpdateContactManServlet",  {
			"data" : JSON.stringify(json)
		   }, 
			function(result) {
				if(result.result==true){
					window.location.reload();
				}
				else {
					alert("修改联系人失败！");
				}
			});
		break;
	case "idnumber1":
		var json = {
				"UserId" : getUrlParam('userId') ,
				"IDNumber" : $("input").val()
			// 初始化为当前页数
			};
		
		$.getJSON("./UpdateIdNumberServlet",{
			 "data" : JSON.stringify(json)
		  },
			function(result) {
				if(result.result==true){
					window.location.reload();
				}
				else {
					alert("修改身份证号码失败！");
				}
			});
		break;
	case "contack_phone1":
		$.getJSON("./UserChangeContactsPhoneServlet",  {
			UserId : getUrlParam('userId') ,
			"userContactsPhon" : $("input").val()
			}, 
			function(result) {
				if(result.result==true){
					window.location.reload();
				}
				else {
					alert("修改联系电话失败！");
				}
			});
		break;
	case "grade1":
		var grade = 0;
		switch ($("select").val()) {
		case "小学一年级":
			grade = 1 ;
			break;
		case "小学二年级":
			grade = 2 ;
			break;
		case "小学三年级":
			grade = 3 ;
			break;
		case "小学四年级":
			grade = 4 ;
			break;
		case "小学五年级":
			grade = 5 ;
			break;
		case "小学六年级":
			grade = 6 ;
			break;
		case "初中一年级":
			grade = 7 ;
			break;
		case "初中二年级":
			grade = 8 ;
			break;
		case "初中三年级":
			grade = 9 ;
			break;
		case "高中一年级":
			grade = 10 ;
			break;
		case "高中二年级":
			grade = 11 ;
			break;
		case "高中三年级":
			grade = 12 ;
			break;
			
		}
		$.getJSON("./UserChangeGradeServlet",  {
			UserId : getUrlParam('userId') ,
			UserGrade : grade
			}, 
			function(result) {
				if(result.result==true){
					window.location.reload();
				}
				else {
					alert("修改学习阶段失败！");
				}
			});
		break;
	case "nickname1":
		$.getJSON("./UserChangeNikeNameServlet",  {
			UserId : getUrlParam('userId') ,
			"userNickName" : $("input").val()
			}, 
			function(result) {
				if(result.result==true){
					window.location.reload();
				}
				else {
					alert("修改昵称失败！");
				}
			});
		break;
	case "password1":
		$.getJSON("./UserChangePasswordServlet",  {
			UserId : getUrlParam('userId') ,
			"OldPassword" : $(".password1").val(),
			"UserPassword" : $(".password2").val()
			}, 
			function(result) {
				if(result.result==true){
					window.location.reload();
				}
				else {
					alert("修改成绩失败！");
				}
			});
		break;
	case "sex1":
		$.getJSON("./UserChangeSexServlet",  {
			UserId : getUrlParam('userId') ,
			"userSex" : $("select").val(),
			}, 
			function(result) {
				if(result.result==true){
					window.location.reload();
				}
				else {
					alert("修改性别失败！");
				}
			});
		break;
	case "address1":
		var json = {
				"UserAddress" : $("input").val(),
				"Userid" : getUrlParam('userId') 
			// 初始化为当前页数
			};
		console.log(JSON.stringify(json));
		$.getJSON("./ChangeUserAddressServlet",  {
			"json" : JSON.stringify(json)
		 }, 
			function(result) {
				if(result.result==true){
					window.location.reload();
				}
				else {
					alert("修改地址失败！");
				}
			});
		break;
	}
}
