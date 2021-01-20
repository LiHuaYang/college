package com.Dao;

import java.util.List;

import com.Entity.Room;

public class test {

	public static void main(String[] args) {
		CDaoRoom cDaoroom=new CDaoRoom();
		
//		String address="海曙";
//		List<Room> result=cDaoroom.queryRoomByAddressViilage(address);
//		System.out.print(result);
		
		//多条件查询房间
		List<Room> result=cDaoroom.QueryRoomselectcondition("镇海","2015-02-13","2015-02-20",0,200);
        System.out.print(result);
	}
}
