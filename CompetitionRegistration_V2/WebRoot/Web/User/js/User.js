var picPathArr = new Array();
$(document).ready(function(){
	GetUserIdfoById();  //根据用户id获得用户基本信息
});


//点击我的信息
function Show_message(){
	$(".save").hide();
	$(".com").hide();
	$(".enroll_com").hide();
	$(".message").show();
	$(".my_message").css({
		"background-color":"#EDEDED"
	})
	$(".my_competition").css({
		"background-color":"white"
	})
	$(".enroll_competition").css({
		"background-color":"white"
	})
	$(".my_save").css({
		"background-color":"white"
	})
}

//点击我的收藏
function Show_Save(){
	$(".message").hide();
	$(".com").hide();
	$(".enroll_com").hide();
	$(".save").show();
	$(".my_message").css({
		"background-color":"white"
	})
	$(".my_competition").css({
		"background-color":"white"
	})
	$(".enroll_competition").css({
		"background-color":"white"
	})
	$(".my_save").css({
		"background-color":"#EDEDED"
	})
	
	GetCollectById();   //获取我的收藏
}

//点击我的比赛
function Show_Com(){
	$(".message").hide();
	$(".enroll_com").hide();
	$(".save").hide();
	$(".com").show();
	$(".my_message").css({
		"background-color":"white"
	})
	$(".my_competition").css({
		"background-color":"#EDEDED"
	})
	$(".enroll_competition").css({
		"background-color":"white"
	})
	$(".my_save").css({
		"background-color":"white"
	})
	
	GetFinishedComById();   //获取我的比赛
}

//点击已报名比赛
function Show_Enroll_Com(){
	$(".message").hide();
	$(".save").hide();
	$(".com").hide();
	$(".enroll_com").show();
	$(".my_message").css({
		"background-color":"white"
	})
	$(".my_competition").css({
		"background-color":"white"
	})
	$(".enroll_competition").css({
		"background-color":"#EDEDED"
	})
	$(".my_save").css({
		"background-color":"white"
	})
	
	FetEnroollCom();  //获取已报名比赛
}

var collect_temp=0;   //收藏只刷新一次
//根据用户id获取收藏
function GetCollectById(){
	
	if(collect_temp==0){
		$.ajax({
			type: "GET",
			url: "./GetCollectInfoByUseridServlet",
			data:{Userid:userid},
			dataType: "json",
			success: function(json){
				if(json.flag!=false){
					for ( var i = 0; i < json.result.length; i++) {
						PaperId=json.result[i].testPaperId;					
						name=json.result[i].collectName;
						$(".text_paper_box").append(
							'<div class="com_big" onclick="Go_Paper_Detail('+PaperId+')">'	
								+'<div class="text_paper" >'
				    				+'<div class="paper_name">'+json.result[i].collectName+'</div>'
				    				+'<div class="paper_time">收藏时间：'+json.result[i].collectTime+'</div>'
				    			+'</div>'
				    		+'</div>'
						)
					}
				}
				else{
					$(".none_save").show();
				}
			}
		})
		collect_temp=1;
	}
}

//跳转到试卷详细界面
function Go_Paper_Detail(i){
	window.location.href="Web/Paper/jsp/PaperDetail.jsp?paperid="+i+"&papername='"+name+"'";
}


var fincom_temp=0;    //我的比赛只刷新一次
//根据用户id获取我的成绩(已结束比赛)
function GetFinishedComById(){
	
	
	if(fincom_temp==0){
		$.ajax({
			type: "GET",
			url: "./GetScoreByUseridServlet",
			data:{UserId:userid},
			dataType: "json",
			success: function(json){
				if(json.flag!=false){
					var StudentScore=0;
					for ( var i = 0; i < json.result.length; i++) {
						competitionId=json.result[i].competitionId;
						var StudentGrade=json.result[i].studentGrade;
						switch(StudentGrade){
						case "0":
							StudentGrade=" ";
							break;
						case "1":
							StudentGrade="小学一年级";
							break;
						case "2":
							StudentGrade="小学二年级";
							break;
						case "3":
							StudentGrade="小学三年级";
							break;
						case "4":
							StudentGrade="小学四年级";
							break;
						case "5":
							StudentGrade="小学五年级";
							break;
						case "6":
							StudentGrade="小学六年级";
							break;
						case "7":
							StudentGrade="初中一年级";
							break;
						case "8":
							StudentGrade="初中二年级";
							break;
						case "9":
							StudentGrade="初中三年级";
							break;
						case "10":
							StudentGrade="高中一年级";
							break;
						case "11":
							StudentGrade="高中二年级";
							break;
						case "12":
							StudentGrade="高中三年级";
							break;
						}
						
						
						
						if(json.result[i].studentscore==-1){
							StudentScore="未出成绩"
						}
						else{
							StudentScore=json.result[i].studentscore;
						}
						
						$(".com_big_box").append(
								'<div class="com_big" onclick="Go_Competition_Detail('+competitionId+')">'
				    				+'<div class="com_name">第'+json.result[i].competitionSession+'届'+json.result[i].competitionName+'</div>'
				    				+'<div class="com_sub">'+json.result[i].contestSubject+'</div>'
				    				+'<div class="com_obj">'+StudentGrade+'</div>'
				    				+'<div class="com_grade">'+StudentScore+'</div>'
				    			+'</div>'
						)
					}
				}
				else{
					$(".none_com").show();
				}
			}
		})
		fincom_temp=1;
	}
}


//跳转到试卷详细界面
function Go_Competition_Detail(i){
	window.location.href="Web/Competition/jsp/competitionDetail.jsp?competitionId="+i;
}
var enroll_com_temp=0;    //已报名比赛只刷新一次
//根据用户id获取已报名比赛
function FetEnroollCom(){
	
	if(enroll_com_temp==0){
		$.ajax({
			type: "GET",
			url: "./GetEnrollComByUseridServlet",
			data:{UserId:userid},
			dataType: "json",
			success: function(json){
				if(json.flag!=false){
					for ( var i = 0; i < json.result.length; i++) {
						competitionId=json.result[i].competitionId;
						$(".enroll_com_box").append(
							'<div class="enroll_com_big"  onclick="Go_Competition_Detail('+competitionId+')">'
			    				+'<div class="enroll_com_name">第'+json.result[i].competitionSession+'届'+json.result[i].competitionName+'</div>'
			    				+'<div class="enroll_com_sub">'+json.result[i].contestSubject+'</div>'
			    				+'<div class="enroll_com_obj">'+json.result[i].studentGrade+'年级</div>'
			    				+'<div class="enroll_com_time">'+json.result[i].startTime+'</div>'
			    			+'</div>'
						)
					}
				}
				else{
					$(".none_enroll_com").show();
				}
			}
		})
		enroll_com_temp=1;
	}
}
var path="";
//根据用户Id获取我的信息
function GetUserIdfoById(){
	$.ajax({
		type: "GET",
		url: "./GetUserInfoByIdServlet",
		data:{UserId:userid},
		dataType: "json",
		success: function(json){
			var StudentGrade=json.result.userGrade;
			
			switch(StudentGrade){
			case 0:
				StudentGrade=" ";
				break;
			case 1:
				StudentGrade="小学一年级";
				break;
			case 2:
				StudentGrade="小学二年级";
				break;
			case 3:
				StudentGrade="小学三年级";
				break;
			case 4:
				StudentGrade="小学四年级";
				break;
			case 5:
				StudentGrade="小学五年级";
				break;
			case 6:
				StudentGrade="小学六年级";
				break;
			case 7:
				StudentGrade="初中一年级";
				break;
			case 8:
				StudentGrade="初中二年级";
				break;
			case 9:
				StudentGrade="初中三年级";
				break;
			case 10:
				StudentGrade="高中一年级";
				break;
			case 11:
				StudentGrade="高中二年级";
				break;
			case 12:
				StudentGrade="高中三年级";
				break;
			}
			
			
			document.getElementById("my_name_input").value=json.result.userNickname;
			document.getElementById("my_sex_input").value=json.result.userSex;
			document.getElementById("my_phone_input").value=json.result.userPhone;
			document.getElementById("my_learn_input").options[0].text=StudentGrade;
			document.getElementById("my_address_input").value=json.result.userAddress;
			 path = json.result.userPicture;
			$(".my_pic").css({
		    	//"background-image":"url('C:/image/cat.jpg')"
				 "background-image":"url('"+json.result.userPicture+"')"
			})
		}
	})
	
}

//通过用户id改变用户信息（昵称，性别，联系号码，学习阶段，用户地址，图片）
function ChangeUserInfo(){
	if(tag_pic==1){     //修改了图片
		var UserNickName=$("#my_name_input").val();
		var UserSex=$("#my_sex_input").val();
		var UserPhone=$("#my_phone_input").val();
		var UserGrade=$("#my_learn_input").val();
		var UserAddress=$("#my_address_input").val();
		var UserPicture=pic_url;   //头像路径
		
		var StudentGrade=$("#my_learn_input").find("option:selected").text();
		switch(StudentGrade){
		case " ":
			StudentGrade=0;
			break;
		case "小学一年级":
			StudentGrade=1;
			break;
		case "小学二年级":
			StudentGrade=2;
			break;
		case "小学三年级":
			StudentGrade=3;
			break;
		case "小学四年级":
			StudentGrade=4;
			break;
		case "小学五年级":
			StudentGrade=5;
			break;
		case "小学六年级":
			StudentGrade=6;
			break;
		case "初中一年级":
			StudentGrade=7;
			break;
		case "初中二年级":
			StudentGrade=8;
			break;
		case "初中三年级":
			StudentGrade=9;
			break;
		case "高中一年级":
			StudentGrade=10;
			break;
		case "高中二年级":
			StudentGrade=11;
			break;
		case "高中三年级":
			StudentGrade=12;
			break;
		}
		alert(StudentGrade);
	
		$.ajax({
			type: "GET",
			url: "./ChangeUserInfoServlet",
			data:{UserNickName:UserNickName,UserSex:UserSex,UserPhone:UserPhone,UserGrade:StudentGrade,UserAddress:UserAddress,UserPicture:UserPicture,UserId:userid},
			dataType: "json",
			success: function(json){
				alert("保存成功!!!");
				location.reload(true);
			}
		})
	}
	else if(tag_pic==0){     //没有修改图片
		var UserNickName=$("#my_name_input").val();
		var UserSex=$("#my_sex_input").val();
		var UserPhone=$("#my_phone_input").val();
		var UserAddress=$("#my_address_input").val();
		var UserPicture=path;   //头像路径
		
		var StudentGrade=$("#my_learn_input").find("option:selected").text();
		switch(StudentGrade){
		case " ":
			StudentGrade=0;
			break;
		case "小学一年级":
			StudentGrade=1;
			break;
		case "小学二年级":
			StudentGrade=2;
			break;
		case "小学三年级":
			StudentGrade=3;
			break;
		case "小学四年级":
			StudentGrade=4;
			break;
		case "小学五年级":
			StudentGrade=5;
			break;
		case "小学六年级":
			StudentGrade=6;
			break;
		case "初中一年级":
			StudentGrade=7;
			break;
		case "初中二年级":
			StudentGrade=8;
			break;
		case "初中三年级":
			StudentGrade=9;
			break;
		case "高中一年级":
			StudentGrade=10;
			break;
		case "高中二年级":
			StudentGrade=11;
			break;
		case "高中三年级":
			StudentGrade=12;
			break;
		}
		alert(StudentGrade);
	
		$.ajax({
			type: "GET",
			url: "./ChangeUserInfoServlet",
			data:{UserNickName:UserNickName,UserSex:UserSex,UserPhone:UserPhone,UserGrade:StudentGrade,UserAddress:UserAddress,UserPicture:UserPicture,UserId:userid},
			dataType: "json",
			success: function(json){
				alert("保存成功!!!");
				location.reload(true);
			}
		})
	}
}

var tag_pic=0;
$(function () {
	//alert(userid);
    $("#uploadify").uploadify({
        //指定swf文件
        'swf': 'Common/Tool/uploadify/uploadify.swf',
        //后台处理的页面
        'uploader': 'ModifyHeadpicServlet',
        //按钮显示的文字
        'buttonText': '修改头像',
        //显示的高度和宽度，默认 height 30；width 120
       // 'height': 20,
      //  'width': 80,
        //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
        //在浏览窗口底部的文件类型下拉菜单中显示的文本
        'fileTypeDesc': 'Image Files',
        //允许上传的文件后缀
        'fileTypeExts': '*.gif; *.jpg; *.png',
        //发送给后台的其他参数通过formData指定
       // 'formData': { 'json': userid},
       // 'scriptData':{'json': 12356789},
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        //'queueID': 'fileQueue',
        //选择文件后自动上传
        'auto': true,
        //设置为true将允许多文件上传2
        'multi': true,
         //上传成功后执行
//        'onUploadStart': function (file) {  
//            $("#uploadify").uploadify("settings", "formData", { 'json': userid });  
//            //在onUploadStart事件中，也就是上传之前，把参数写好传递到后台。  
//        }  ,
        'onUploadSuccess': function (file, data, response) {
            $('#' + file.id).find('.data').html('修改完毕');
            // alert(data);
            var dataObj = eval("("+data+")");
            // alert(dataObj.fileName);
            picPathArr.push(dataObj.fileName);
           // console.log("文件名数组：" + picPathArr);
//            pic_url=picPathArr[0];    // 赋值给全局变量
//            alert(pic_url)
            json=$.parseJSON(data);
            pic_url= new String(json.fileName)
            tag_pic=1;
            }  
    });
});



function showChangePassword() {
	$(".bodymiddleLogin").show();
}

//修改密码
function ChangePassword() {
	var OldPassword=$("#OldPassword").val();
	var UserPassword=$("#NewPassword").val();
	var UserCopyPassword=$("#NewCopyPassword").val();
	
	if(OldPassword==""||UserPassword==""||UserCopyPassword==""){
		alert("输入信息不可为空");
	}
	else{
		if(UserPassword!=UserCopyPassword){
			alert("确认密码与新密码不符");
		}
		else{
			$.ajax({
				type: "GET",
				url: "./UserChangePasswordServlet",
				data:{UserId:userid,OldPassword:OldPassword,UserPassword:UserPassword},
				dataType: "json",
				success: function(json){
					if(json.result==true){
						alert("修改成功");
						$(".bodymiddleLogin").hide();
					}
					else{
						alert("旧密码输入错误，请从新输入");
					}
				}
			})
		}
	}
}










