

$( function(){
    // 在这里编写我们希望在DOM准备就绪后执行的代码
	
} );

/**
 * 点击选中行
 * @param tab
 * @return
 */
function do_onclick(tab) {
	// 获取当前点击节点的父节点tr
    var _table = tab.parentNode;
    
    $("tr").each(function (i, element) {
        this.style.backgroundColor = "#F3F3F3";
    });
    $(_table).css("backgroundColor","#FBEC88");
    
    // 获取父节点下面的第一个子节点td 里面的子节点checkbox
    // var input = tt.find("input[type='checkbox']");
    // $("[name='box']").attr("checked",'true');
    var input = $(_table).children('td').eq(0).children('input');
    if ($(input).attr('checked')) {
    	 $(input).attr("checked",false);
    }	
    else{
    	$(input).attr("checked",true);
    }
}

/**
 * 取消或是全选
 * @param tag
 * @return
 */
function checkAll(tag)
{
	var tbl=$(".data-table");
	var trlist=tbl.find("tr");
	for(var i=1; i<trlist.length; i++)
 	{
      var tr=$(trlist[i]);
      var input=tr.find("input[type='checkbox']");
      input.attr("checked",tag);
 	}
}

/**
 * 标签切换样式
 */
$(function(){	
	$('.panel-title li').click(function(){
		$(this).addClass('hit').siblings().removeClass('hit');
		$('.panes>div:eq('+$(this).index()+')').show().siblings().hide();	
	})
})

