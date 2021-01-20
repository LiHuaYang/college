$(document).ready(function() {
	
	changecolors("#userbit");
	toareahotel();
}) ;



function changecolors(x) {
	$(".left_list div").attr("class","one");
	  $(x).attr("class","two");
}

function tomain() {
	window.location.href="jsp/adminjsp/main.jsp"
}



function toareahotel() {
	$(".areahotel").hide();
	$(".areaorder").hide();
	$(".areaclient").hide();
	$(".areaactivity").hide();
	if($(".areahotel").html()==""){
		$(".areahotel").load("jsp/adminjsp/areahotel.jsp");
	}
	$(".areahotel").show();
	
	
}


function toareaorder() {
	$(".areahotel").hide();
	$(".areaorder").hide();
	$(".areaclient").hide();
	$(".areaactivity").hide();
	if($(".areaorder").html()==""){
		$(".areaorder").load("jsp/adminjsp/areaorder.jsp");
	}
	$(".areaorder").show();
}

function toareaclient() {
	$(".areahotel").hide();
	$(".areaorder").hide();
	$(".areaclient").hide();
	$(".areaactivity").hide();
	if($(".areaclient").html()==""){
		$(".areaclient").load("jsp/adminjsp/areaclient.jsp");
	}
	$(".areaclient").show();
}



function toareaactivity() {
	$(".areahotel").hide();
	$(".areaorder").hide();
	$(".areaclient").hide();
	$(".areaactivity").hide();
	if($(".areaactivity").html()==""){
		$(".areaactivity").load("jsp/adminjsp/areaactivity.jsp");
	}
	$(".areaactivity").show();
	
}




















