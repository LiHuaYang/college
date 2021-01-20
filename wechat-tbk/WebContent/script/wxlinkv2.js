function Browser() {
    var a = navigator.userAgent,
    b = a.indexOf("Opera") > -1;
    return b ? "Opera": a.indexOf("Firefox") > -1 ? "FF": a.indexOf("Chrome") > -1 ? "Chrome": a.indexOf("Safari") > -1 ? "Safari": a.indexOf("compatible") > -1 && a.indexOf("MSIE") > -1 && !b ? "IE": void 0
}
function alertModal(a, b) {
    new jBox("Modal").setTitle(a).setContent(b).open()
}
function Notice(a, b) {
    new jBox("Notice", {
        autoClose: 3e4,
        attributes: {
            x: "right",
            y: "bottom"
        },
        theme: "NoticeBorder",
        color: "blue",
        animation: {
            open: "slide:bottom",
            close: "slide:left"
        },
        title: a,
        content: b
    })
}
function checkDX() {
    var b, e, f, a = Main.linkQuery,
    c = new RegExp("(http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&amp;*+?:_/=<>]*)?", "gi"),
    d = a.match(c);
    for (e = 0; e < d.length; e++) b = GetQueryString(d[e], "id"),
    itemRes = GetQueryString(d[e], "itemId"),
    b ? f = b: itemRes ? f = itemRes: d[e].indexOf("s.click.taobao.com") > 0 && (f = GetNumiid(d[e]));
    null != f ? window.open("http://pub.alimama.com/promo/search/index.htm?q=https%3A%2F%2Fdetail.tmall.com%2Fitem.htm%3Fid%3D" + f) : Notice("", "获取地址失败")
}
function changeURLPar(a, b, c) {
    var e, f, g, h, d = "";
    if ( - 1 == a.indexOf("?")) return a + "?" + b + "=" + c;
    if (d = a.substr(a.indexOf("?") + 1), e = "", f = "", h = "0", -1 != d.indexOf("&")) {
        g = d.split("&");
        for (i in g) g[i].split("=")[0] == b ? (f = c, h = "1") : f = g[i].split("=")[1],
        e = e + g[i].split("=")[0] + "=" + f + "&";
        e = e.substr(0, e.length - 1),
        "0" == h && e == d && (e = e + "&" + b + "=" + c)
    } else - 1 != d.indexOf("=") ? (g = d.split("="), g[0] == b ? (f = c, h = "1") : f = g[1], e = g[0] + "=" + f, "0" == h && e == d && (e = e + "&" + b + "=" + c)) : e = b + "=" + c;
    return a.substr(0, a.indexOf("?")) + "?" + e
}
function linkQuery() {
    var e, f, a = Main.linkQuery,
    b = new RegExp("(http[s]{0,1})://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&amp;*+?:_/=<>]*)?", "gi"),
    c = a.match(b),
    d = c.length;
    if (2 > d) return Notice("", "请输入优惠券及商品链接"),
    !1;
    if (d > 2) return Notice("", "最多只能输入优惠券和商品2个链接"),
    !1;
    for (e = new Array, f = 0; 1 >= f; f++) c[f].indexOf("activity_id") > 0 || c[f].indexOf("activityId") > 0 ? (e["activity_id"] = GetQueryString(c[f].replace(/&amp;/g, "&"), "activity_id"), null == e["activity_id"] && (e["activity_id"] = GetQueryString(c[f].replace(/&amp;/, "&"), "activityId"))) : (c[f].indexOf("item") > 0 || c[f].indexOf("id") > 0 || c[f].indexOf("s.click.taobao.com") > 0) && (e["id"] = GetQueryString(c[f].replace(/&amp;/g, "&"), "id"), null == e["id"] && (e["id"] = GetNumiid(c[f])));
    return e
}
function GetQueryString(a, b) {
    var c, d;
    return a = a.split("?")[1],
    void 0 == a ? null: (c = new RegExp("(^|&)" + b + "=([^&]*)(&|$)"), d = a.match(c), null != d ? unescape(d[2]) : null)
}
function cleanSetting() {
    Main.isDx = !1,
    Main.isDxFi = !1,
    Main.isShowPic = !1,
    Main.isHSL = !1,
    Main.isHPIC = !1,
    Main.isDisc = !1,
    Main.isChangeTitle = !1,
    Main.ChangeTitle = "",
    Main.isShare = !1,
    Main.moreTj = !1,
    Main.shareID = ""
}
function getThum(a, b) {
    switch (b) {
    case "600":
        thumSrc = a.replace(".jpg", ".jpg_600x600.jpg").replace(".png", ".png_600x600.jpg").replace(".SS2", ".SS2_600x600.jpg");
        break;
    default:
        thumSrc = a.replace(".jpg", ".jpg_400x400.jpg").replace(".png", ".png_400x400.jpg").replace(".SS2", ".SS2_400x400.jpg")
    }
    return thumSrc
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
            b = a
        },
        error: function() {
            console.log("error")
        }
    }),
    b
}
function GetItemDetail(a) {
    var b;
    return $.ajax({
        type: "get",
        data: {
            num_iids: a
        },
        url: "../../api/tb2/GetItemDetail_num_iid.php",
        dataType: "json",
        async: !1,
        success: function(a) {
            console.log(a),
            b = a
        },
        error: function() {
            console.log("error")
        }
    }),
    b
}
function GetTkl(a, b, c, d, e) {
    var f = "",
    g = "";
    return $("#submit").attr("limit", "true"),
    $.ajax({
        type: "post",
        url: "../../api/tb/GetTkl_wxxx.php",
        async: !1,
        data: {
            text: a,
            url: b,
            logo: c,
            action: "refresh",
            isHSL: d,
            shareID: e
        },
        dataType: "json",
        success: function(a) {
            $(".level .num").html(a.refresh),
            "15" == a.code || "41" == a.code ? Notice("", "*你输入的参数有误，请检查网址、设置") : void 0 != a.model ? (f = a.model, g = d ? "": a.results.tbk_spread[0].content) : "0" == a.times ? (Notice("", "*你今天的使用次数已经耗尽"), f = "（暂无淘口令）") : "speed_limit" == a.warning ? Notice("", "*你提交的速度太快了！") : "not_logge" == a.warning ? (Notice("", "由于生成口令是淘宝的付费接口，为了防止被个别软件盗用&滥用，\n暂时只供微信会员使用。注册方法请点击上面“立即注册”。"), f = "（请登录后使用）") : (f = "未知错误", g = ""),
            $("#sumbit").removeAttr("limit")
        },
        error: function() {
            console.log("失败"),
            $("#sumbit").removeAttr("limit")
        }
    }),
    f + "|" + g
}
function getCouponInfo(a) {
    var b;
    return $.ajax({
        type: "post",
        url: "../../api/tb/coupon_2in1.php",
        async: !1,
        data: {
            url: a
        },
        dataType: "text",
        success: function(a) {
            b = JSON.parse(a)
        },
        error: function() {
            console.log("失败")
        }
    }),
    b
}
function onbeforeunload_handler() {
    var a = {
        desc: Main.desc,
        linkQuery: Main.linkQuery
    };
    localStorage["localJson"] = JSON.stringify(a)
}
function saveSetting() {
    var a = {
        isDxFi: Main.isDxFi,
        isShowPic: Main.isShowPic,
        isHSL: Main.isHSL,
        isHPIC: Main.isHPIC,
        isDisc: Main.isDisc,
        isChangeTitle: Main.isChangeTitle,
        ChangeTitle: Main.ChangeTitle,
        isShare: Main.isShare,
        moreTj: Main.moreTj,
        shareID: Main.shareID,
        setPid: Main.setPid.replace("，", ",")
    };
    a = JSON.stringify(a),
    $.post("../../api/wx/save-setting.php", {
        jsonData: a
    },
    function(a) {
        var a = $.parseJSON(a);
        Notice("", a.msg + "，PID修改需刷新页面才生效")
    })
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
    }), void 0) : (Notice("", "请输入密码"), !1) : (Notice("", "请输入用户名"), !1)
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
    if ("null" != a) {
        var a = $.parseJSON(a),
        b = a.warning;
        switch (b) {
        case "password_err":
            Notice("错误", "用户名或者密码错误，请重新发送'注册'到公众号"),
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
function sponsor() {
    var a = $.trim(Main.sponsorNumber);
    return a.length < 20 ? (alertModal("充值失败", "请输入正确的交易订单号"), !1) : 1 != isLogin ? (Notice("", "请登录后再操作"), !1) : ($.ajax({
        type: "post",
        url: "../../api/wx/pay.php",
        async: !1,
        data: {
            sponsorNumber: a
        },
        dataType: "json",
        success: function(a) {
            0 == a.error ? alertModal("充值成功", a.msg) : 300 == a.error && alertModal("充值失败", a.msg)
        },
        error: function() {
            return alertModal("未知错误", "请联系网站管理员（shapl@qq.com）"),
            !1
        }
    }), void 0)
}
var desc, mgSrc, oupon_text, bk_text, $resultObj, GetTklRes, pict_list, shortUrl, pid, linkStr, $floatBar, $sponsor, $setting, $selectPid, $tipsEm, $txtDesc, Main, mb = Browser();
"IE" == mb && alert("请不要使用IE浏览器，或者其他IE内核的浏览器，否则无法使用"),
$resultObj = $("#result"),
GetTklRes = "",
pict_list = $("#pict_list"),
shortUrl = "",
$floatBar = $(".menu .canDo"),
$sponsor = $(".sponsor"),
$setting = $(".setTing"),
$selectPid = $(".selectPid"),
$tipsEm = $(".main .tips>em"),
$txtDesc = $(".txt-desc"),
Main = new Vue({
    el: "body",
    data: {
        linkQuery: "",
        desc: "",
        result: "",
        isDx: !1,
        isDxFi: !1,
        isShowPic: !1,
        isHSL: !1,
        isHPIC: !1,
        isDisc: !1,
        isChangeTitle: !1,
        ChangeTitle: "",
        isShare: !1,
        shareID: "",
        moreTj: !1,
        pid: "",
        setPid: "",
        sponsorNumber: ""
    }
}),
$(function() {
    var b, c, d, e, a = localStorage["localJson"];
    if (void 0 == a ? (Main.desc = "", Main.linkQuery = "") : (a = JSON.parse(a), Main.desc = a.desc, Main.linkQuery = a.linkQuery), isLogin && void 0 != setting) {
        if (Main.isDxFi = setting.isDxFi, Main.isShowPic = setting.isShowPic, Main.isHSL = setting.isHSL, Main.isHPIC = void 0 != setting.isHPIC ? setting.isHPIC: !1, Main.isDisc = void 0 != setting.isDisc ? setting.isDisc: !1, Main.isChangeTitle = setting.isChangeTitle, Main.ChangeTitle = setting.ChangeTitle, Main.isShare = setting.isShare, Main.shareID = setting.shareID, Main.moreTj = setting.moreTj, Main.setPid = setting.setPid, "" != Main.setPid) if (b = "", c = Main.setPid, c.indexOf(",") > 0) {
            for (c = Main.setPid.split(","), d = 0, e = c.length; e > d; d++) b += '<option value="' + c[d] + '">' + c[d] + "</option>";
            $selectPid.html(b)
        } else $selectPid.html('<option value="' + c + '">' + c + "</option>");
        Main.isDxFi && (Main.isDx = !0)
    }
}),
$(".tooltip").jBox("Tooltip"),
new jBox("Modal", {
    width: 550,
    height: 280,
    attach: $("#myModal_1"),
    title: "注册",
    content: '<div class="left"><img src="http://ww2.sinaimg.cn/large/5e48c153gw1f7kihoijrdj2076076dg1.jpg"/><p>第1步：先用微信扫描关注公众号，<br>回复“注册”，即可得到密码</p></div><div class="right"><p>第2步：请输入6位数的临时密码</p><input type="text" name="password" id="password" value="" placeholder="输入临时密码"/><p>第3步：输入新用户名和新密码</p><input type="text" name="user_name" id="user_name" value="" placeholder="输入用户名"/><input type="password" name="user_pass" id="user_pass" value="" placeholder="输入新密码"/><button class="btn" id="register" onclick="LRbtn(this)">注册</button></div>'
}),
new jBox("Modal", {
    width: 450,
    height: 240,
    attach: $("#myModal_2"),
    title: "登录",
    content: '<p>请输入用户名和密码</p><input type="text" name="user_name" id="user_name" value="" placeholder="输入用户名"/><input type="password" name="user_pass" id="user_pass" value="" placeholder="输入密码"/><p class="tips">如想重置账号和密码，请重新发送“注册”到微信公众号；<br/>取消关注公众号，将会导致账号失效。</p><button class="btn" id="login" onclick="LRbtn(this)">登陆</button>'
}),
$(function() {
    var a = new Clipboard("#copy", {
        target: function() {
            return document.querySelector("#result")
        }
    });
    a.on("success",
    function() {
        Notice("", "复制成功")
    }),
    a.on("error",
    function() {
        Notice("", "暂时不支持你的浏览器，复制失败")
    })
}),
$(".submit,.testLink").click(function() {
    var e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, a = "",
    b = "",
    c = "",
    d = $(this).data("type");
    if ($resultObj.html(""), pict_list.html(""), linkStr = Main.linkQuery, "" == linkStr) return Notice("", "请输入优惠券及商品链接"),
    !1;
    if (pid = $.trim($selectPid.val()), "" == pid) return Notice("", "请输入你的推广PID，否则推广无效"),
    !1;
    if (pid.indexOf("mm_") < 0 || pid.length < 24) return Notice("", "无效的PID，请检查格式"),
    !1;
    if (0 == isLogin && "submit" == d) return Notice("由于生成口令是淘宝的付费接口，为了防止被个别软件盗用&滥用，", "暂时只供微信会员使用。注册方法请点击上面“立即注册”。"),
    !1;
    if (linkStr.indexOf("uland.taobao.com") > 0) {
        if (linkStr.indexOf("edetail?e=") > 0) return Notice("", '输入的二合一链接被加密，无法转换成你的。<br/>如果已经是你从联盟获取来的链接，不需要再使用本工具。<a href="http://kouss.com/wxlink-help.html#title-7" target="_blank">>>查看帮助</a>'),
        !1;
        Notice("", "输入的二合一链接，已转换成为你PID的"),
        e = new RegExp("(http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&amp;*+?:_/=<>]*)?", "gi"),
        f = linkStr.match(e),
        g = changeURLPar(f[0], "pid", pid),
        g = changeURLPar(g, "src", "czhk_cztkl"),
        g = g.replace("http://", "https://"),
        b = GetQueryString(linkStr, "itemId")
    } else if (a = linkQuery(), b = a["id"], c = a["activity_id"], "" == b || "" == c || void 0 == c) return Notice("网址错误，无法生成口令", "请检查你输入的网址是否跟示范的格式一致，<br/>不支持t.cn、dwz.cn、ysl.so等短链接，请了解。"),
    !1;
    switch (h = Main.isDx ? linkStr.indexOf("uland.taobao.com") > 0 ? linkStr.indexOf("&dx") > 0 ? changeURLPar(g, "dx", "1") : g + "&dx=1": "https://uland.taobao.com/coupon/edetail?activityId=" + c + "&itemId=" + b + "&pid=" + pid + "&src=czhk_cztkl&dx=1": linkStr.indexOf("uland.taobao.com") > 0 ? linkStr.indexOf("&dx") > 0 ? g.replace("&dx=1", "") : g: "https://uland.taobao.com/coupon/edetail?activityId=" + c + "&itemId=" + b + "&pid=" + pid + "&src=czhk_cztkl", Main.moreTj && (h += "&tj1=1&tj2=1&tjrank=1"), d) {
    case "submit":
        if (i = Main.desc.replace(/\n/g, "<br/>"), i.indexOf("￥") >= 0 ? (j = new RegExp("￥", "g"), Notice("", "检查到文案中带有‘￥’号，会对淘口令造成冲突，已经为你移除。"), i = i.replace(j, "")) : i.indexOf("¥") >= 0 && (j = new RegExp("¥", "g"), Notice("", "检查到文案中带有‘￥’号，会对淘口令造成冲突，已经为你移除。"), i = i.replace(j, "")), k = GetItemDetail(b), l = k.data.item_info.title, m = k.data.item_info.pics.string, m instanceof Array) {
            if (!Main.isShowPic) {
                for (n = "", o = 0; m.length > o; o++) n += '<img src="' + m[o] + '">';
                pict_list.append(n)
            }
            m = m[0]
        }
        if (p = Main.isHSL, q = Main.isShare, r = Main.shareID.replace(/^\s+|\s+$/g, ""), s = Main.isChangeTitle, t = Main.ChangeTitle.replace(/^\s+|\s+$/g, ""), u = Main.isHPIC, v = Main.isDisc, w = "", x = "", w = s && "" != t ? t: l, GetTklRes = q && "" != r ? GetTkl(w, h, m, p, r) : GetTkl(w, h, m, p, null), tkl = GetTklRes.split("|")[0], shortUrl = p ? "": GetTklRes.split("|")[1].replace("http://", "https://"), u || (x = "<img src='" + m + "'/>"), v) i = tkl;
        else {
            for (y = ["{淘口令}", "{短链接}", "{标题}", "{30天销量}", "{店铺名}", "{优惠券面额}", "{券后价}", "{促销价}"], z = !1, A = 0, B = y.length; B > A; A++) if (i.indexOf(y[A]) >= 0) {
                z = !0;
                break
            }
            "" == i ? i = x + "复制这条信息，打开👉手机淘宝 👈即可看到【" + l + "】" + tkl + " " + shortUrl: z ? (C = getCouponInfo(h), D = {
                picUrl: C.result.item.picUrl,
                biz30Day: C.result.item.biz30Day,
                effectiveEndTime: C.result.effectiveEndTime,
                effectiveStartTime: C.result.effectiveStartTime,
                title: C.result.item.title,
                shopName: C.result.shopName,
                reservePrice: C.result.item.reservePrice,
                discountPrice: C.result.item.discountPrice,
                amount: C.result.amount,
                tmall: C.result.item.tmall,
                postFree: C.result.item.postFree
            },
            i = i.replace(/{标题}/g, l), i = i.replace(/{淘口令}/g, tkl), i = i.replace(/{短链接}/g, shortUrl), i = i.replace(/{30天销量}/g, D.biz30Day), i = i.replace(/{店铺名}/g, D.shopName), i = i.replace(/{优惠券面额}/g, D.amount), i = i.replace(/{促销价}/g, D.discountPrice), i = i.replace(/{券后价}/g, Math.round(100 * (D.discountPrice - D.amount)) / 100), i = x + i) : i = x + i + tkl + "&nbsp;" + shortUrl
        }
        $resultObj.html(i);
        break;
    default:
        window.open(h),
        $resultObj.html(h)
    }
}),
$("#clear").click(function() {
    Main.linkQuery = "",
    pict_list.html(""),
    $resultObj.html("")
}),
$floatBar.on("click",
function() {
    var a = $(this).data("type");
    switch (a) {
    case "showSponsor":
        $sponsor.slideToggle(200);
        break;
    default:
        $setting.slideToggle(200)
    }
    $(this).hasClass("active") ? $(this).removeClass("active") : $(this).addClass("active")
}),
$tipsEm.on("click",
function() {
    var a = $(this).text();
    $txtDesc.val($txtDesc.val() + a),
    Main.desc = $txtDesc.val()
}),
window.onbeforeunload = onbeforeunload_handler;