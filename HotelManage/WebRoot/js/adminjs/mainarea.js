$(document).ready(function() {
	
	toloadmainarea();
	
}) ;

function toloadmainarea() {
	$(".matruediv").html("");
	$(".matruediv").append('<div "> '+
  			'<div class=mainarea-title><font >地区列表</font><img src="img/add.png" onclick="addarea()"></div>'+
  			
  				
			'</div>');
	var arrayname=new Array();
	arrayname.push("东钱湖")
	arrayname.push("天一阁");
	arrayname.push("月湖");
	arrayname.push("象山");
	arrayname.push("宁波工程学院");
	var arrayImg=new Array();
	arrayImg.push("img/dongqianhu.png");
	arrayImg.push("img/tianyige.png");
	arrayImg.push("img/yuehu.png");
	arrayImg.push("img/xiangshang.png")
	arrayImg.push("img/xueyuan.png")
	
	var j=0;
	for(var i=0;i<30;i++){
		
		$(".matruediv").append('<div class=mainareap> <img src="'+arrayImg[j]+'" onclick="toarea()">'+
				'<div style="text-align:center; width:200px"><font style="font-size:20px;"  >'+arrayname[j]+'</font></div>'+
		'</div>'
		
		);
		j++;
		if(j==arrayname.length){
			j=0;
		}
		
	}
}
function toarea() {
	window.location.href="jsp/adminjsp/area.jsp"
}

function addarea() {
	$(".shadow").show();
	$(".pagehead font").html("添加地区")
	$(".showpage").css("width","380px");
	$(".showpage").css("height","420px");
	$(".showpage").css("margin-left","600px");
	$(".pagemain").html("<div class=userset>"+
				"<div><img src='img/wait.png' style='height:250px;width:220px;margin-left:60px;'></div>"+
  				"<div style='margin-left:20px;'><a style='font-family:Microsoft YaHei;'>图片附件:</a><input type='text' style='margin-left:10px; ' value='"+""+"' /><button class='but1'>上传</button></div>"+
  				"<div style='margin-left:20px;'><a>酒店名称:</a><input type='text' style='margin-left:10px; ' value='"+""+"'/></div>"+
  				
  				
  				"<div style='margin-left: 80px;margin-top: 20px;'><button class='but1'>确定</button><button class='but1'>取消</button></div>"+
  				"</div>");
}
