package com.Dao;

import java.util.List;

import com.Entity.Room;

public class test {

	public static void main(String[] args) {
		CDaoRoom cDaoroom=new CDaoRoom();
		
//		String address="����";
//		List<Room> result=cDaoroom.queryRoomByAddressViilage(address);
//		System.out.print(result);
		
		//��������ѯ����
		List<Room> result=cDaoroom.QueryRoomselectcondition("��","2015-02-13","2015-02-20",0,200);
        System.out.print(result);
	}
}
