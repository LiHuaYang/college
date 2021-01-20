

var picPathArr = new Array();
var picNameArr = new Array();


// 提交新闻
function sumbitnews(){
	var newstitle = $("#news_title").val();
	
	var newscontent = CKEDITOR.instances.news_content.getData();
	// console.log("这是富文本编辑器：" + data);
	// G_competition.contestIntro = sf_CompetitionIntro;
	// var newscontent=$("#news_content").val();
	//alert(newscontent);
	var newsExtralInfo=$("#news_add").val();
	var newsState=$("#news_type").val();
	
	// alert(newsState);
	var newssource = $("#news_source").val();
	// var newspic = $("#news_pic").val(); 
	var newsTop = $("#news_ishead").is(':checked')?1:0;
	// alert(newsTop+newsState);
	if( newstitle==""||newscontent==""){
		if(newstitle==""){
			alert("请输入标题！");
		}
		if(newscontent==""){
			alert("请输入新闻内容！");
		}
		
	}else{
	var json = {
		"newstitle" : newstitle,
		"newscontent" : newscontent,
		"newsExtralInfo": newsExtralInfo,
		"newsState" :newsState,
		"newssource":newssource,	
		"newsTop":newsTop
	};
	// alert(newspic+newstitle+newscontent);
	json.picPathArr = picPathArr;
	
	console.log("添加的新闻详情为：" + JSON.stringify(json));
	
	$.post("./AdminAddnews", {
		json : JSON.stringify(json)
	}, function(jsonObject) {
		
		var contact = JSON.parse(jsonObject); 
		
		// alert(contact.result);
		if(contact.result) {
			//alert("");
			alert("创建新闻成功！");
		}
		else {
			alert("创建新闻失败，请刷新重试！");
		}
	});
	}
}


// 文件上传
$(function () {
    $("#uploadify").uploadify({
        //指定swf文件
        'swf': 'Common/Tool/uploadify/uploadify.swf',
        //后台处理的页面
        'uploader': 'upload',
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
        //'formData': { 'someKey': 'someValue', 'someOtherKey': 1 },
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        //'queueID': 'fileQueue',
        //选择文件后自动上传
        'auto': true,
        //设置为true将允许多文件上传
        'multi': true,
         //上传成功后执行
        'onUploadSuccess': function (file, data, response) {
            $('#' + file.id).find('.data').html(' 上传完毕');
            // alert(data);
            var dataObj = eval("("+data+")");
             //alert(dataObj.fileName);
            picPathArr.push(dataObj.fileName);
            console.log("文件名数组：" + picPathArr);
            }
    });
});






