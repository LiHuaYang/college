package com.AndroidServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.AndroidBll.IFrame;
import com.AndroidBll.Impl;
import com.AndroidTool.OperationCode;
import com.AndroidTool.OperationCode.Operation;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Entity.Address;
import com.Entity.Room;

/**
 * AUserLoginServlet 概述：用户登录 输入：1. userphone 2. userpassword 输出：成功：List<User> +
 * check 失败：check + reason 备注：
 * 
 * @author Aric
 * 
 */
public class AUserLoginServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String serverAddressStr = "http://10.20.4.128:8080/HotelManage/";

		// 接受数据
		String userinfo = new String(request.getParameter(
				OperationCode.User.UserPhone).getBytes("ISO-8859-1"), "utf-8");
		String password = new String(request.getParameter(
				OperationCode.User.UserPassword).getBytes("ISO-8859-1"),
				"utf-8");

		// 处理数据
		ICBllFrame interfaceOfBllFrame = new CBllImpl();
		List<HashMap<String, Object>> result = interfaceOfBllFrame
				.QueryPhonuserother(userinfo, password);

		int userid = (Integer) result.get(0).get("UserId");

		for (int i = 0; i < result.size(); i++) {
			HashMap hh = result.get(i);
			String roomPic = (String) hh.get("UserPicture");

			StringBuffer userBuffer = new StringBuffer(roomPic);
			String userPicture = userBuffer.insert(0, serverAddressStr)
					.toString();
			System.out.println(userPicture);
			hh.put("UserPicture", userPicture);
		}

		String jsonResult = null;
		JSONArray jsonArray = null;
		JSONObject jsonObject = new JSONObject();
		PrintWriter out = response.getWriter();

		// 判断数据正确性--核对数据失败
		if (result == null) {
			jsonObject.put(Operation.SIGN, "false"); // 构造JOSNObject
			jsonResult = String.format("%s", jsonObject);// 转化成字符串
			out.println(jsonResult); // 输出流写数据
			out.flush();
			out.close();
			System.out.println("登录未成功输出信息：" + jsonResult);// 打印输出的信息
		}

		// 判断数据正确性--核对数据正确
		else {
			try {
				jsonArray = new JSONArray().fromObject(result);
				jsonObject.element(OperationCode.User.UserList, jsonArray);
				jsonObject.put(Operation.SIGN, "true");
			} catch (Exception e) {
				e.printStackTrace();
			}

			/********** 开始返回地区列表 *************/
			List<Address> address_list = new ArrayList<Address>();
			address_list = interfaceOfBllFrame.GetAllAddress();

			/********** 开始返回订单列表 *************/
			IFrame interfaceOfBllFrame1 = new Impl();
			// int user_id = user.get(0).getUserId();
			List<HashMap<String, Object>> orderdetail_list = new ArrayList<HashMap<String, Object>>();
			orderdetail_list = interfaceOfBllFrame1
					.GetOrderAndRoomByOrderId(userid);

			// 添加服务器头部地址
			for (int i = 0; i < orderdetail_list.size(); i++) {

				HashMap<String, Object> has = orderdetail_list.get(i);
				Room room = (Room) has.get("room");
				StringBuffer roomBuffer = new StringBuffer(room
						.getRoomPicture());
				String roomPicture = roomBuffer.insert(0, serverAddressStr)
						.toString();
				System.out.println(roomPicture);
				room.setRoomPicture(roomPicture);
			}

			for (int j = 0; j < address_list.size(); j++) {
				StringBuffer addressBuffer = new StringBuffer(address_list.get(
						j).getAddressPicture());
				String addressPicture = addressBuffer.insert(0,
						serverAddressStr).toString();
				System.out.println(addressPicture);
				address_list.get(j).setAddressPicture(addressPicture);
			}

			JSONArray jsonArray2 = new JSONArray().fromObject(address_list);

			jsonObject.element(OperationCode.Address.AddressList, jsonArray2); // 添加地区列表至JSON对象
			jsonObject.element(OperationCode.Order.OrderList, orderdetail_list);

			jsonResult = String.format("%s", jsonObject);
			out.println(jsonResult);
			out.flush();
			out.close();

			System.out.println("登录成功输出个人信息和地区信息：" + jsonResult);
		}
	}
}
