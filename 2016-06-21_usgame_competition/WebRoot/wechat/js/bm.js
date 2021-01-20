var money;
$(document).ready(function(){
	var competitionSubject = decodeURIComponent(getUrlParam("competitionSubject"));
	var competitionName = decodeURIComponent(getUrlParam("competitionName"));
	var grade = decodeURIComponent(getUrlParam("competitionGrade"));
	money = getUrlParam("money");
	$('#competitionName').html(competitionName);
	$('#competitionSubject').html(competitionSubject);	
	var i = 1;
	var length = grade.length;
	while(length>0) {
		var Pos = grade.indexOf("，");
		length = length - Pos;
		if(Pos==-1){
			length=0;
			$('#competitionGrade').append(
					"<option value='"+i+"'>"+grade.substring(0)+"</option>"
			);
		}
		else {
			$('#competitionGrade').append(
					"<option value='"+i+"'>"+grade.substring(0,Pos)+"</option>"
			);
		}
		i++;
		grade = grade.substring(Pos+1);	
	}
});


function qd() {
	var message = getData();
	if(message.name.length!=0&&message.idCard.length!=0&&message.contectName.length!=0&&message.contectPhone.length!=0) {
		$.post("../CompetitionServlet", {
			method : "apply",
			name :message.name,
			idCard : message.idCard,
			school : message.school,
			grade : message.grade,
			competitionSubject : message.competitionSubject,
			competitionName : message.competitionName,
			competitionGrade : message.competitionGrade,
			contectName : message.contectName,
			contectPhone : message.contectPhone,
			money : money
		}, function(json) {
			var data = JSON.parse(json);
//			alert(data.data);
			$("#wx_out").val(data.data);
			if(data.msg==1||data.msg==3) {
				window.location.href="bmqr.html?name="+encodeURI(encodeURI(message.name))+"&&idCard="+message.idCard+"&&school="+encodeURI(encodeURI(message.school))+"&&" +
						"grade="+message.grade+"&&competitionSubject="+encodeURI(encodeURI(message.competitionSubject))+"&&competitionName="+encodeURI(encodeURI(message.competitionName))+"&&" +
								"competitionGrade="+message.competitionGrade+"&&contectName="+encodeURI(encodeURI(message.contectName))+"&&contectPhone="+message.contectPhone  + "&out_trade_no=" + data.data+"&money="+money
			}
			else if(data.msg==2) {
				$('#warming_title').html("提醒");
				$('#warming').html("您已报过名!");
				show2();
			}
			else if(data.msg==0) {
				$('#warming_title').html("提醒");
				$('#warming').html("请先登陆!");
				show2();
			}
			else if(data.msg==4) {
				$('#warming_title').html("报名失败");
				$('#warming').html(data.other);
				show2();
			}
		});
	}
	else {
		$('#warming').html("资料未填写完全！");
		show2();
	}
}

//获取用户填写的值
function getData() {
	var message = new Object();
	message.name = $('#name').val();
	message.idCard = $('#idCard').val();
	message.school = $('#school').val();
	message.grade = $('#grade').val();
	message.competitionSubject = $('#competitionSubject').html();
	message.competitionName = $('#competitionName').html();
	message.competitionGrade = $('#competitionGrade').val();
	message.contectName = $('#contectName').val();
	message.contectPhone = $('#contectPhone').val();
	return message;
}

//function geturl() {
//	var strHref = window.document.location.href;
//	var intPos = strHref.indexOf("competitionName");
//	var strRight = strHref.substr(intPos + 16);
//	var pos1;
//	var pos2;
//	strRight = decodeURIComponent(strRight);
//	strHref = strRight;
//	pos1 = strRight.indexOf("&&");
//	$('#competitionName').html(strRight.substring(0,pos1));
//	pos2 = strHref.indexOf("=");
//	strRight = strHref.substring(pos2+1);
//	strHref = strRight;
//	pos1 = strHref.indexOf("&&");
//	$('#competitionSubject').html(strRight.substring(0,pos1));	
//	pos2 = strHref.indexOf("=");
//	strRight = strHref.substring(pos2+1);
//	strHref = strRight;
//	pos1 = strHref.indexOf("&&");
//	var grade = strRight.substring(0);
//	var length = grade.length;
//	var i = 1;
//	while(length>0) {
//		var Pos = grade.indexOf("，");
//		length = length - Pos;
//		if(Pos==-1){
//			length=0;
//			$('#competitionGrade').append(
//					"<option value='"+i+"'>"+grade.substring(0)+"</option>"
//			);
//		}
//		else {
//			$('#competitionGrade').append(
//					"<option value='"+i+"'>"+grade.substring(0,Pos)+"</option>"
//			);
//		}
//		i++;
//		grade = grade.substring(Pos+1);	
//	}
//	
//}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}
function show2() {
    $('#dialog2').show().on('click', '.weui_btn_dialog', function () {
        $('#dialog2').off('click').hide();
    });
}

function qx() {
	if($('#warming').html()=="请先登陆!") {
		window.location.href="denglu.html";
	}
}