var cornamelist=new Array();

$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	showcorporation();
	showhotcorporationname() ;
	
	
})
//显示所有社团
function showcorporation() {
	$.getJSON("./GetAllCorporation",function(json){
		$(".corporationline").html("");
		for ( var i = 0; i < json.length; i++) {
			cornamelist.push(json[i].corporationName);
			var set=i%4;
			$(".corporationline").eq(set).append('	<div class="corporationone" onclick="tocorporationpage('+json[i].corporationId+')">'+
  				'<img  src="'+json[i].corporationPic+'" width="100%">'+
  				'<div class="corporationone-title">'+json[i].corporationName+'</div>'+
  				'<div class="corporationone-more">'+json[i].corporationIntroduction+'</div>'+
  			'</div>')
	
		}
		slide();
	})
}
//显示热门社团
function showhotcorporationname() {
	$.getJSON("./GetHotcorporation",function(json){
		for ( var i = 0; i < json.length; i++) {
			
			$(".hotcorporation").append("<font onclick='tocorporationpage("+json[i].corporationId+")'>"+json[i].corporationName+"</font>");
			if (i!=json.length-1) {
				$(".hotcorporation").append("、");
			}
		}

	})
}
//查找社团
function searchcorporation() {
	var corporationName=$(".corporationsearch-input").val();
	var json={
			"corporationName":corporationName
	}
	$.getJSON("./SearchCorporation",{json:JSON.stringify(json)},function(json){
		$(".corporationline").html("");
		for ( var i = 0; i < json.length; i++) {
		var set=i%4;
		$(".corporationline").eq(set).append('	<div class="corporationone"onclick="tocorporationpage('+json[i].corporationId+')">'+
				'<img  src="'+json[i].corporationPic+'" width="100%">'+
				'<div class="corporationone-title">'+json[i].corporationName+'</div>'+
				'<div class="corporationone-more">'+json[i].corporationIntroduction+'</div>'+
			'</div>')
		}
	})
}

//搜索框下拉
function slide(){
$(".corporationsearch-input").autocomplete(cornamelist,{
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
function tocorporationpage(mycorporationId) {
	window.location.href="jsp/corporation.jsp?mycorporationId="+mycorporationId;

}