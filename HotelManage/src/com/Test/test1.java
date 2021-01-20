package com.Test;

import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections.map.LinkedMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Bll.CBllImpl;
import com.Bll.ICBllFrame;
import com.Dao.CDaoFrameImpl;
import com.Dao.IDaoFrame;
import com.Entity.Address;
import com.Entity.Room;

public class test1 {
	public static void main(String[] args) {
		ICBllFrame interfaceOfBllFrame = new CBllImpl();
		IDaoFrame interfaceOfDaoFrame = new CDaoFrameImpl();

		JSONArray jsonArray = new JSONArray();
		// 根据村庄名模糊查询地区ID
		Address address = interfaceOfDaoFrame
				.queryAddressByAddressVillage("海曙");
		System.out.println(address);

		// 模糊查询
		// 地区ID、模糊关键字、页数
		LinkedMap maps = interfaceOfBllFrame.GetRoomByAddress(address
				.getAddressId(), "海曙", 1);

		Iterator ite = maps.entrySet().iterator();
		while (ite.hasNext()) {
			Map.Entry entry = (Map.Entry) ite.next();
			Object value = entry.getValue();
			LinkedMap map = (LinkedMap) value;
			Room room = (Room) map.get("Room");
			Address address2 = (Address) map.get("Address");
			jsonArray.add(toJSON(room, address2));
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("RoomInfo", jsonArray);
		
		System.out.println(jsonObject);
	}

	public static Object toJSON(Room room, Address address2) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("RoomId", room.getRoomId());
		jsonObject.put("RoomPrice", room.getRoomUnitPrice());
		jsonObject.put("RoomLockState", room.getRoomLockState());
		jsonObject.put("RoomType", room.getRoomType());
		jsonObject.put("RoomUsingState", room.getRoomUsingState());
		if (address2 != null) {
			jsonObject.put("AddressProvince", address2.getAddressProvince());
			jsonObject.put("AddressCity", address2.getAddressCity());
			jsonObject.put("AddressVillage", address2.getAddressVillage());
		} else {
			jsonObject.put("AddressProvince", "");
			jsonObject.put("AddressCity", "");
			jsonObject.put("AddressVillage", "");
		}
		return jsonObject;
	}
}
