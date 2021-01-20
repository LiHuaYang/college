$(document).ready(function() {
	
	toloadareahotel();
	
}) ;

function toloadareahotel() {
	$(".areahoteltruediv").html("");
	$(".areahoteltruediv").append('<div "> '+
  			'<div class=areahotel-title><font style="font-size:20px" >酒店列表</font><img src="img/add.png" style="float:right;height:25px;width:25px;margin-right:10px;cursor:pointer;" onclick="addarea()"></div>'+
  			
  				
			'</div>');
	var arrayname=new Array();
	arrayname.push("一号酒店")
	arrayname.push("二号酒店");
	arrayname.push("三号酒店");
	var arrayImg=new Array();
	arrayImg.push("img/qinshione.jpg");
	arrayImg.push("img/qinshitwo.png");
	arrayImg.push("img/qinshithree.png");
	
	var j=0;
	for(var i=0;i<30;i++){
		
		$(".areahoteltruediv").append('<div class=areap> <img src="'+arrayImg[j]+'" style="float:left;height:250px;width:220px;margin-left:5px;cursor:pointer;"onclick="toarea()">'+
				'<div ><font>'+arrayname[j]+'</font></div>'+
		'</div>'
		
		);
		j++;
		if(j==arrayname.length){
			j=0;
		}
		
	}
}

