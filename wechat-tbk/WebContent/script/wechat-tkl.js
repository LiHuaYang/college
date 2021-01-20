

function checkDX() {
    var a = $("#tbk_url").val(),
    b = GetNumiid(a);
    window.open("http://pub.alimama.com/promo/search/index.htm?q=https%3A%2F%2Fdetail.tmall.com%2Fitem.htm%3Fid%3D" + b)
}
function GetQueryString(a, b) {
    var c, d;
    return a = a.split("?")[1],
    void 0 == a ? null: (c = new RegExp("(^|&)" + b + "=([^&]*)(&|$)"), d = a.match(c), null != d ? unescape(d[2]) : null)
}
function getThum(a) {
    return thumSrc = a.replace(".jpg", ".jpg_400x400.jpg").replace(".png", ".png_400x400.jpg").replace(".SS2", ".SS2_400x400.jpg")
}
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
function GetNumiid(a) {
    var b, c = GetQueryString(a, "id");
    return c ? b = c: $.ajax({
        type: "get",
        data: {
            url: a
        },
        url: "../../api/tb2/GetNumiid.php",
        dataType: "text",
        async: !1,
        success: function(a) {
            b = a,
            console.log(a)
        },
        error: function() {
            console.log("error")
        }
    }),
    b
}
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



function onbeforeunload_handler() {
    localStorage["tbk_url"] = $("#tbk_url").val(),
    localStorage["coupon_url"] = $("#coupon_url").val(),
    localStorage["desc"] = $(".txt-desc").val()
}
function LRbtn(a) {
    var b = $(a).parents(".jBox-content").find("#password").val(),
    c = $(a).parents(".jBox-content").find("#user_name").val(),
    d = $(a).parents(".jBox-content").find("#user_pass").val();
    return c ? d ? ($.post("../api/wx/wx-login.php", {
        password: b,
        user_name: c,
        user_pass: d
    },
    function(a) {
        $.cookie("user_name", c, {
            expires: 7
        }),
        $.cookie("user_pass", d, {
            expires: 7
        }),
        addUserInfo(a)
    }), void 0) : (Notice("", "请输入密码"), void 0) : (Notice("", "请输入用户名"), void 0)
}
function autoLogin() {
    var a = $.cookie("user_name"),
    b = $.cookie("user_pass");
    "" !== a && "" !== !b && $.post("../api/wx/wx-login.php", {
        password: "",
        user_name: a,
        user_pass: b
    },
    function(a) {
        addUserInfo(a)
    })
}
function addUserInfo(a) {
    var b;
    switch (a = $.parseJSON(a), console.log(a), b = a.warning) {
    case "password_err":
        Notice("错误", "用户名或者密码错误"),
        delCookie();
        break;
    case "repeat_user":
        Notice("错误", "用户名已经被注册，请更换");
        break;
    case "unsubscribe":
        Notice("错误", "由于你取消关注公众号，暂时无法登陆。\n请重新关注：超值菌。"),
        delCookie();
        break;
    case "user_code":
        Notice("错误", "临时密码有误，请重新输入。"),
        delCookie();
        break;
    default:
        location.reload()
    }
}
function logout() {
    $.get("../api/wx/wx-login.php", {
        logout: "logout"
    },
    function() {
        delCookie(),
        location.reload()
    })
}
function delCookie() {
    $.cookie("user_name", ""),
    $.cookie("user_pass", "")
}
var desc, imgSrc, coupon_text, tbk_text, resultObj = $("#result"),
dx = $("#dx");
$("#testLink").click(function() {
    var d, e, a = $("#coupon_url").val(),
    b = $("#tbk_url").val(),
    c = $("#pid").val();
    return "" == a || "" == b ? (Notice("", "请输入优惠券及商品链接"), void 0) : "" == c ? (Notice("", "请输入你的推广PID，否则推广无效"), void 0) : (coupon_id = dealCoupon(a), d = GetNumiid(b), e = dx.is(":checked") ? "http://uland.taobao.com/coupon/edetail?activityId=" + coupon_id + "&itemId=" + d + "&pid=" + c + "&src=czhk_cztkl&dx=1": "http://uland.taobao.com/coupon/edetail?activityId=" + coupon_id + "&itemId=" + d + "&pid=" + c + "&src=czhk_cztkl", window.open(e), void 0)
}),
$("#submit").click(function() {
    var a, b, c, d, e, f, g, h, i, j;
    return resultObj.html(null),
    a = $("#coupon_url").val(),
    b = $("#tbk_url").val(),
    c = $("#pid").val(),
    0 == isLogin ? (Notice("由于生成口令是淘宝的付费接口，为了防止被个别软件盗用&滥用，", "暂时只供微信会员使用。注册方法请点击上面“立即注册”。"), void 0) : "" == a || "" == b ? (Notice("", "请输入优惠券及商品链接"), void 0) : "" == c ? (Notice("", "请输入你的推广PID，否则推广无效"), void 0) : c.indexOf("mm_") < 0 ? (Notice("", "无效的PID，请检查格式"), void 0) : (d = $(".txt-desc").val().replace(/\n/g, "<br/>"), d.indexOf("￥") >= 0 ? (e = new RegExp("￥", "g"), Notice("", "检查到文案中带有‘￥’号，会对淘口令造成冲突，已经为你移除。"), d = d.replace(e, "")) : d.indexOf("¥") >= 0 && (e = new RegExp("¥", "g"), Notice("", "检查到文案中带有‘￥’号，会对淘口令造成冲突，已经为你移除。"), d = d.replace(e, "")), coupon_id = dealCoupon(a), f = GetNumiidInfo(b), g = f.num_iid, h = f.data.item_info.title, i = f.data.item_info.pics.string, i instanceof Array && (i = i[0]), i = getThum(i), console.log(coupon_id + "\n" + g), resultObj.prepend("<img src='" + i + "' />"), "" == d && (d = "复制这条信息，打开👉手机淘宝 👈即可看到【" + h + "】"), j = dx.is(":checked") ? "http://uland.taobao.com/coupon/edetail?activityId=" + coupon_id + "&itemId=" + g + "&pid=" + c + "&src=czhk_cztkl&dx=1": "http://uland.taobao.com/coupon/edetail?activityId=" + coupon_id + "&itemId=" + g + "&pid=" + c + "&src=czhk_cztkl", tkl = GetTkl(h, j, i), resultObj.append(d + tkl), void 0)
}),
$("#clear").click(function() {
    $("#coupon_url,#tbk_url,.txt-desc").val(null),
    resultObj.html(null)
}),
window.onbeforeunload = onbeforeunload_handler,
$(function() {
    $("#tbk_url").val(localStorage["tbk_url"]),
    $("#coupon_url").val(localStorage["coupon_url"]),
    $(".txt-desc").val(localStorage["desc"]),
    $("#pid").val(localStorage["pid"])
}),
$("#pid").blur(function() {
    localStorage["pid"] = $("#pid").val()
});