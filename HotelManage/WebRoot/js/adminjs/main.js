$(document).ready(function() {
	// $(".heads").load("jsp/common/adminbar.jsp");
	// tomainroom();
}) ;




function tocustomerrevise(){
	var x=tabuser;
	var UserId=$(x).find("th").eq(0).html();
	if(x==null){
		alert("Not Clicked");
	}else{
		if (confirm("是否修改？")){
		window.location.href="jsp/adminjsp/customerrevise.jsp?UserId="+UserId;
		}
		else{
			alert("取消修改");
		}
	}
}

function tochangeorder(){
	window.location.href="jsp/adminjsp/orderrevise.jsp";
}

function toseecustomer(){
	var x=tabuser;
	var UserId=$(x).find("th").eq(0).html();
	if(x==null){
		alert("Not Clicked");
	}else{
		window.location.href="jsp/adminjsp/seecustomer.jsp?UserId="+UserId;
	}
}



function closepage() {
	$(".shadow").hide();
}