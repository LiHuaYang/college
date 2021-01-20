var picPathArr = new Array();
//文件上传
$(function () {
    $("#uploadify").uploadify({
        //指定swf文件
        'swf': 'Common/Tool/uploadify/uploadify.swf',
        //后台处理的页面
        'uploader': 'GetCompetitionPictureServlet',
        //按钮显示的文字
        'buttonText': '上传图片',
        //显示的高度和宽度，默认 height 30；width 120
        //'height': 15,
        //'width': 80,
        //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
        //在浏览窗口底部的文件类型下拉菜单中显示的文本
        'fileTypeDesc': 'Image Files',
        //允许上传的文件后缀
        'fileTypeExts': '*.gif; *.jpg; *.png',
        //发送给后台的其他参数通过formData指定
        
       // 'formData': { json: JSON.stringify(json) },
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        //'queueID': 'fileQueue',
        //选择文件后自动上传
        'auto': true,
        //设置为true将允许多文件上传
        'multi': true,
         //上传成功后执行
        'onUploadSuccess': function (file, data, response) {
            $('#' + file.id).find('.data').html(' 上传完毕');
          // alert(data.filePath);
            var dataObj = eval("("+data+")");
            if (dataObj.flag) {
            	alert("添加网站首页图片成功！");
            }
            else {
            	alert("添加网站首页图片失败！请重新添加！");
            }
            picPathArr.push(dataObj.fileName);
        }
    });
});

function submitpic(){
	if(picPathArr.length !=0 )
	{
		var json = {
			"picPathArr":picPathArr[0]
	};
		//alert(json.picPathArr);
		
		$.getJSON("./AddCompetitiompicServlet", {
			json : JSON.stringify(json)
		}, function(json) {
			
				if(json.flag){
					alert("提交成功！");
				}
				else{
					alert("提交失败！");
				}
				//TestId = json.TestId;
		});
	}
	else{
		alert("请先上传图片，再提交！！！");
	}
	
}