/**
 * 
 */

$("#submit").click(function() {
    var a, b, c, d, e, f, g, h, i, j;
    return resultObj.html(null),
    a = $("#coupon_url").val(), // 优惠券地址
    b = $("#tbk_url").val(), // 商品地址
    c = $("#pid").val(), // PID
    0 == isLogin ? (Notice("由于生成口令是淘宝的付费接口，为了防止被个别软件盗用&滥用，", "暂时只供微信会员使用。注册方法请点击上面“立即注册”。"), void 0) : 
    	"" == a || "" == b ? (Notice("", "请输入优惠券及商品链接"), void 0) : 
    	"" == c ? (Notice("", "请输入你的推广PID，否则推广无效"), void 0) : 
    		
    	c.indexOf("mm_") < 0 ? (Notice("", "无效的PID，请检查格式"), void 0) : (d = $(".txt-desc").val().replace(/\n/g, "<br/>"), d.indexOf("￥") >= 0 ? (e = new RegExp("￥", "g"), Notice("", "检查到文案中带有‘￥’号，会对淘口令造成冲突，已经为你移除。"), d = d.replace(e, "")) : d.indexOf("¥") >= 0 && (e = new RegExp("¥", "g"), Notice("", "检查到文案中带有‘￥’号，会对淘口令造成冲突，已经为你移除。"), d = d.replace(e, "")), coupon_id = dealCoupon(a), f = GetNumiidInfo(b), g = f.num_iid, h = f.data.item_info.title, i = f.data.item_info.pics.string, i instanceof Array && (i = i[0]), i = getThum(i), console.log(coupon_id + "\n" + g), resultObj.prepend("<img src='" + i + "' />"), "" == d && (d = "复制这条信息，打开👉手机淘宝 👈即可看到【" + h + "】"), j = dx.is(":checked") ? "http://uland.taobao.com/coupon/edetail?activityId=" + coupon_id + "&itemId=" + g + "&pid=" + c + "&src=czhk_cztkl&dx=1": "http://uland.taobao.com/coupon/edetail?activityId=" + coupon_id + "&itemId=" + g + "&pid=" + c + "&src=czhk_cztkl", tkl = GetTkl(h, j, i), resultObj.append(d + tkl), void 0)
})

// 复制这条信息，打开👉手机淘宝 👈即可看到【纯竹工坊本色手帕纸不漂白纸巾便携式面巾纸小包纸巾抽纸4层60包】￥AAWXqYZu￥

function GetNumiidInfo(a) {
    var b;
    return $.ajax({
        type: "get",
        data: {
            url: a
        },
        url: "../../api/tb2/GetNumiid_auto.php",
        dataType: "json",
        async: !1,
        success: function(a) {
            b = a
        },
        error: function() {
            console.log("error")
        }
    }),
    b
}


f = GetNumiidInfo(b)

h = f.data.item_info.title // 商品名字

i = f.data.item_info.pics.string // 

j = dx.is(":checked") ? 
		"http://uland.taobao.com/coupon/edetail?activityId=" + coupon_id + "&itemId=" + g + "&pid=" + c + "&src=czhk_cztkl&dx=1": 
	"http://uland.taobao.com/coupon/edetail?activityId=" + coupon_id + "&itemId=" + g + "&pid=" + c + "&src=czhk_cztkl"

g = f.num_iid
	
c = $("#pid").val(), // PID

function GetTkl(a, b, c) {
var d;
return $("#submit").attr("limit", "true"),
$.ajax({
    type: "post",
url: "../../api/tb/GetTkl_wx.php",
async: !1,
data: {
    text: a,
    url: b,
    logo: c,
    action: "refresh"
},
dataType: "json",
success: function(a) {
    "15" == a.code || "41" == a.code ? Notice("", "*你输入的参数有误，请检查网址") : void 0 != a.model ? d = a.model: "0" == a.times ? (Notice("", "*你今天的使用次数已经耗尽"), d = "（暂无淘口令）") : "speed_limit" == a.warning ? Notice("", "*你提交的速度太快了！") : "not_logge" == a.warning && (Notice("", "由于生成口令是淘宝的付费接口，为了防止被个别软件盗用&滥用，\n暂时只供微信会员使用。注册方法请点击上面“立即注册”。"), d = "（请登录后使用）"),
$("#sumbit").removeAttr("limit"),
$(".level .num").html(a.refresh)
},
error: function() {
    console.log("失败"),
$("#sumbit").removeAttr("limit")
        }
    }),
    d
}


function dealCoupon(a) {
    var b, c;
    return "" !== a ? (a = a.split("&clk1=")[0].replace("%253D", "="), b = GetQueryString(a, "sellerId"), null == b && (b = GetQueryString(a, "seller_id")), c = GetQueryString(a, "activityId"), null == c && (c = GetQueryString(a, "activity_id")), c) : void 0
}


function GetQueryString(a, b) {
    var c, d;
    return a = a.split("?")[1],
    void 0 == a ? null: (c = new RegExp("(^|&)" + b + "=([^&]*)(&|$)"), d = a.match(c), null != d ? unescape(d[2]) : null)
}

