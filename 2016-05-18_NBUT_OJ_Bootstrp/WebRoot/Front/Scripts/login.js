





/**
 * 去除字符串两端的空格
 * @param str
 * @returns
 */
function trim(str){ //删除左右两端的空格
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

function login () {
	var id = trim($("#id").val());
	var pw = trim($("#pw").val());
	
	// 值是否为空验证
	if (id=="" || pw=="") {
		alert("值不能为空");
		return ;
	}
	
	$.post("../../UserActionV2",{ 
		"id" : id, "passwd":pw ,"method":"login"},
		function(json) {
			var data = JSON.parse(json);
			if (data.res == "true") {
				// 1. 显示
//				$('#man').removeAttr('style');
//				$('#lot').removeAttr('style');
//				$('#per').removeAttr('style');
				
//				$("#per").show();
//				$("#lot").show();
//				$("#man").show();
				// 2. 跳转
				window.location.href="problem_list.html"; 
			}
			else {
				alert(data.msg);
//				return ;
			}
		}
	);
}