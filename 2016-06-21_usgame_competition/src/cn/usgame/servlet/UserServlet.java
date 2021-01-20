package cn.usgame.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.SMS;
import cn.usgame.entity.User;
import cn.usgame.entity_dto.UserForm;
import cn.usgame.filter.MyResponseWrapper;
import cn.usgame.filter.MyResquestWrapper;
import cn.usgame.service.ServiceFactory;
import cn.usgame.service.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 1. 手机号码
	 * 2. 验证码
	 * 3. 生成时间
	 */
	private static Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * 用户业务层对象
	 */
	private UserService userService = ServiceFactory.getInstance().getUserManage();
    
	
	/**
	 * 函数名称：register
	 * 功能描述：用户注册
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月4日19:16:25
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void register(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		
		String phonenumber = request.getParameter("phone");
		String password = request.getParameter("password");
		String SMSNumber = request.getParameter("yanzhengma");
		System.out.println("Servlet:"+SMSNumber);
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		UserForm userform = new UserForm();
		JsonObject out_json = new JsonObject();
//		Map<String, String[]> map = request.getParameterMap();
//		UserForm user = new UserForm(map);
		int judge = userService.IsQualifiedSMS(phonenumber, SMSNumber);
		if (judge==1) {
			boolean flag = userform.judgePhone(phonenumber);
			if(flag) {
				boolean result = userService.registerUser(id,phonenumber,password);
				if(result) {
					User user = userService.login(phonenumber, password);
					HttpSession session = request.getSession();
					session.setAttribute("user", user); // 设置Session
					session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
					
					//设置cookie
					String userHistory = phonenumber;    //  3_2
					Cookie cookie = new Cookie("UserHistory",userHistory);
					cookie.setMaxAge(1*30*24*3600);
					response.addCookie(cookie);
					
					out_json.addProperty("msg", true);
					out_json.addProperty("other", "注册成功");
				}
				else {
					out_json.addProperty("msg", true);
					out_json.addProperty("other", "注册失败");
				}
			}
			else {
				out_json.addProperty("msg", false);
				out_json.addProperty("other", "手机号码不合法！");
			}
		}
		else if(judge == 2) {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "验证码错误！");
		}
		else if(judge == 3) {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "验证超时！");
		}
		else {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "请先获取验证码！");
		}
		out_json.add("data", null);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：login
	 * 功能描述：用户登录
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月4日19:54:10
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void login(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String phonenumber = request.getParameter("phone");
		String password = request.getParameter("password");
		
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();
		
		User user = userService.login(phonenumber,password);
		if(user!=null) {
			jsonData = user.toJSON();
			HttpSession session = request.getSession();
			session.setAttribute("user", user); // 设置Session
			session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
			//设置cookie
			String userHistory = phonenumber;    //  3_2
			Cookie cookie = new Cookie("UserHistory",userHistory);
			cookie.setMaxAge(1*30*24*3600);
			response.addCookie(cookie);
			
			out_json.add("data", jsonData);
			out_json.addProperty("msg", true);
		}
		else {
			out_json.add("data", null);
			out_json.addProperty("msg", false);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 函数名称：getUserInfo
	 * 功能描述：获取个人信息
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月5日16:30:26
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void getUserInfo(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();
		
		if(us!=null) {
			jsonData = us.toJSON();
			out_json.addProperty("msg", true);
			out_json.add("data", jsonData);
		}
		else {
			out_json.addProperty("msg", false);
			out_json.add("data", null);
		}
		
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	/**
	 * 函数名称：toUser
	 * 功能描述：保存个人信息
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月5日20:27:01
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void toUser(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		
		
//		String name = request.getParameter("name");
//		String sex = request.getParameter("sex");
//		String school = request.getParameter("school");
//		String grade = request.getParameter("grade");
//		String contactNumber = request.getParameter("contactNumber");
//		String iDcard = request.getParameter("iDcard");
//		String address = request.getParameter("address");
//		String motto = request.getParameter("motto");
//		String phonenumber = request.getParameter("phonenumber");
		Map<String, String[]> map = request.getParameterMap();
		UserForm userform = new UserForm(map);
		
		boolean sexflag = userform.judgeSex();
		boolean iDcardflag = userform.judgeiDcard();
		boolean contactNumber = userform.judgeContactNumber();
		JsonObject out_json = new JsonObject();
		
		if(sexflag&&iDcardflag&&contactNumber) {
			User user = userform.toUser();
			boolean result = userService.toUser(user);
			if(result) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user); // 设置Session
				session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
				
				//设置cookie
				String userHistory = user.getPhonenumber();    //  3_2
				Cookie cookie = new Cookie("UserHistory",userHistory);
				cookie.setMaxAge(1*30*24*3600);
				response.addCookie(cookie);
				
				out_json.addProperty("msg", true);
			}
			else {
				out_json.addProperty("msg", false);
			}
		}
		else {
			out_json.addProperty("msg", false);
			//未完待续
			out_json.addProperty("other", "格式不对");
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	/**
	 * 函数名称：logout
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月5日22:14:02
	 */
	public void logout(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException{
		request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		JsonObject out_json = new JsonObject();
		if (us==null) {
			out_json.addProperty("msg", true);
		} else {
			out_json.addProperty("msg", false);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：changepw
	 * 功能描述：修改密码
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月5日22:31:42
	 */
	public void changepw(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException{
		JsonObject out_json = new JsonObject();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		String old_pw = request.getParameter("old_pw");
		String new_pw = request.getParameter("new_pw");
		boolean result = false;
		if(old_pw.equals(us.getPassword())) {
			result = userService.changepw(new_pw,us.getPhonenumber());
		}else {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "原密码错误！");
		}
		if (result) {
			out_json.addProperty("msg", true);
			out_json.addProperty("other", "修改成功！");
		} else {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "修改失败！");
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：CAPTCHA
	 * 功能描述：发送验证码
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月7日下午7:38:44
	 */
	public void RCAPTCHA(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String phoneNumber = request.getParameter("phone");
		System.out.println(phoneNumber);
		UserForm userForm = new UserForm();
		JsonObject out_json = new JsonObject();
		userForm.setPhonenumber(phoneNumber);
		boolean result = userForm.judgePhone(phoneNumber);
		System.out.println(result);
		if(result==true) {
			boolean flag = userService.testPhone(phoneNumber);
			if(flag==true) {
				out_json.addProperty("other","联系号码已被使用！");
				out_json.addProperty("msg", false);
			}
			else {
				int lifecycle = 60; // 周期为60秒
				SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowtime = d.format(new Date());
				// 2. 发送短信
				String SMSNumber = SendCheckNumber(phoneNumber);

				if (!("").equals(SMSNumber)) {
					SMS sms = new SMS(phoneNumber,SMSNumber,nowtime,lifecycle);
					boolean result1 = userService.pushSMS(sms);
//					System.out.println("新生成的SMS对象的手机号码：" + sms.getPhoneNumber());
//					System.out.println("新生成的SMS对象的生成时间：" + sms.getBulidtime());
//					System.out.println("新生成的SMS对象的生命周期：" + sms.getLifecycle());
//					System.out.println("新生成的SMS对象的手机验证：" + sms.getCheckNumber());
					out_json.addProperty("other", "验证码发送成功");
					out_json.addProperty("msg", result1);

				} else {
					out_json.addProperty("other", "验证码发送失败");
				}
			}
		}
		else {
			out_json.addProperty("other","联系号码格式有误！");
			out_json.addProperty("msg", false);
		}
		out_json.add("data", null);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	

	private String SendCheckNumber(String phoneNumber) {
		boolean flag = false;
		String SMSNumber = null;
		// 阿里大鱼短信服务器地址
		String url = "http://gw.api.taobao.com/router/rest";
		// 阿里大鱼应用密钥
		String appkey = "23317766";
		// 阿里大鱼...
		String secret = "793012aac1dffea9b8a4900c5eeb8c80";

		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);

		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();

		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("优赛乐学");

		SMSNumber = CreateAndReturnASecurityNumber();
		// {"code":"1234","product":"alidayu"}
		req.setSmsParamString("{\"code\":" + "'" + SMSNumber + "'" + "," + "\"product\":\"优赛乐学\",\"item\":\"优赛乐学\"}");
		// 目标手机号
		req.setRecNum(phoneNumber);
		// 短信模版
		req.setSmsTemplateCode("SMS_5250341");

		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			flag = true;
//			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			SMSNumber = null;
			e.printStackTrace();
		}
		return SMSNumber;
	}

	private String CreateAndReturnASecurityNumber() {
		String SecurityNumber = "";
		for (int i = 0; i < 6; i++) {
			java.util.Random random = new java.util.Random();	// 定义随机类
			int result = random.nextInt(10);		// 返回[0,10)集合中的整数，注意不包括10
			SecurityNumber = SecurityNumber + Integer.toString(result);
		}
		return SecurityNumber;
	}
	
	/**
	 * 
	 * 函数名称：getUserCompetition
	 * 功能描述：获得用户报名的比赛
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月9日11:05:30
	 */
	public void getUserCompetition(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		List<ApplyReport> applyreports = userService.getUserCompetition(us.getPhonenumber());
		for (int i = 0; i < applyreports.size(); i++) {
			jsonData.add(applyreports.get(i).toJSON());
		}
		out_json.add("data", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	/**
	 * 
	 * 函数名称：applyreportInfo
	 * 功能描述：获得特定报名比赛的详情
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月9日11:05:30
	 */
	public void applyreportInfo(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String applyReportId = request.getParameter("applyReportId");
		JsonObject jsonData = new JsonObject();
		JsonObject out_json = new JsonObject();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		ApplyReport applyreport = userService.applyreportInfo(us.getPhonenumber(),applyReportId);
		jsonData=applyreport.toJSON();
		out_json.add("data", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
}
