package com.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.map.LinkedMap;
import org.hibernate.Query;
import org.hibernate.Session;

import com.Entity.Address;
import com.Entity.OrderTable;
import com.Entity.Room;
import com.Test.HibernateUtil;

public class CDaoRoom {
	private Room room = new Room();
	private List<Room> rooms = new ArrayList<Room>();

	// ---------------1.新建房间---------------
	public boolean CreateRoom(Room room) {

		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			s.save(room);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// -------------2.查询房间详情--------------
	public Room QueryRoomDetail(int roomid) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from Room where RoomId=?").setParameter(0,
				roomid);
		room = (Room) query.uniqueResult();
		s.getTransaction().commit();
		s.close();
		// System.out.println(room.toString());
		return room;
	}

	// --------------3.通过地区查询房间-----------
	@SuppressWarnings("unchecked")
	public List<Room> QueryRoomByArea(int addressid) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from Room  where AddressId = ?")
				.setParameter(0, addressid);
		rooms = (List<Room>) query.list();
		s.getTransaction().commit();
		s.close();
		// for(Room room:rooms){
		// System.out.println(room.toString());
		// }
		return rooms;
	}

	// --------------4.按房间使用状态查询所有房间----------
	@SuppressWarnings("unchecked")
	public List<Room> QueryRoomByUsingState(int usingState) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from Room where RoomUsingState = ?");
		rooms = (List<Room>) query.setParameter(0, usingState).list();
		s.getTransaction().commit();
		s.close();
		return rooms;
	}

	// ---------------5.修改房间属性------------
	public boolean UpdateRoom(Room room) {
		System.out.println(room.getRoomId());
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			s.update(room);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// --------------6.激活或锁定房间:-----------
	public boolean LockCheckRoom(int roomid, int roomLockState) {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s
					.createQuery("update Room set RoomLockState = ? where RoomId = ?");
			query.setParameter(0, roomLockState);
			query.setParameter(1, roomid);
			query.executeUpdate();
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// -------------7.通过锁定状态查询房间------------
	@SuppressWarnings("unchecked")
	public List<Room> QueryRoomByLockingState(int lockState) {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from Room where RoomLockState = ?");
		rooms = (List<Room>) query.setParameter(0, lockState).list();
		s.getTransaction().commit();
		s.close();
		return rooms;
	}

	// ---------------8.删除房间----------------
	public boolean DeleteRoom(int roomid) {
		boolean result = false;
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s
					.createQuery("update Room set RoomLockState = -1 where RoomId = ?");
			query.setParameter(0, roomid);
			query.executeUpdate();
			s.getTransaction().commit();
			s.close();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查找roomCleaningState=-1的房间信息
	public List<Room> QueryRoomByRoomCleaningState() {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from Room where RoomCleaningState = -1");
		rooms = (List<Room>) query.list();
		s.getTransaction().commit();
		s.close();
		return rooms;
	}

	//查询所有房间
	public List<Room> QueryRooms() {
		Session s = HibernateUtil.getSession();
		s.beginTransaction();
		Query query = s.createQuery("from Room ");
		rooms = (List<Room>) query.list();
		s.getTransaction().commit();
		s.close();
		return rooms;
	}

	// 通过村庄来查找房间信息
	public List<Room> queryRoomByAddressViilage(String address) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			Query query1;
			query1 = session
					.createSQLQuery(
							"select * from Room, Address where Room.AddressId=Address.AddressId and Address.addressVillage like '%"
									+ address + "%'").addEntity(Room.class);
			System.out.println("address=" + address);
			rooms = (List<Room>) query1.list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}
	
	
	//sql="select * from Room r,Address a,OrderTable o where r.AddressId=a.AddressId"

	// --------------10修改房间使用状态-----------
	public boolean UsingCheckRoom(int roomid, int usingCheckRoom) {
		try {
			Session s = HibernateUtil.getSession();
			s.beginTransaction();
			Query query = s
					.createQuery("update Room set RoomUsingState = ? where RoomId = ?");
			query.setParameter(0, usingCheckRoom);
			query.setParameter(1, roomid);
			query.executeUpdate();
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// --------------11通过CleanerId查找所负责的房间-----------
	public List<Room> GetCleanerChargeRoomByCleanerID(int cleanerid) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			Query query1;
			query1 = session
					.createSQLQuery(
							"select * from room, CleanerWorkArrange where CleanerWorkArrange.roomid = room.roomId and room.roomUsingState=2 and CleanerWorkArrange.Cleanerid="
									+ cleanerid).addEntity(Room.class);
			rooms = (List<Room>) query1.list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}

	// ------------- 12通过页数查房间----------------
	public LinkedMap GetRoomInfoByPage(int page) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "select r1.roomId,r1.roomType,r1.roomUnitPrice,r1.roomUsingState,r1.roomLockState,a1.addressProvince,a1.addressCity,a1.addressVillage from com.Entity.Room as r1,com.Entity.Address as a1 where r1.roomLockState!=-1 and r1.addressId=a1.addressId order by r1.roomId asc";
		Query query = session.createQuery(sql);
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List findResult = query.list();
		Iterator it = findResult.iterator();
		LinkedMap maps = new LinkedMap();
		int i = 0;
		while (it.hasNext()) {
			Object[] tuple = (Object[]) it.next();
			LinkedMap map = new LinkedMap();
			Room room = new Room((Integer) tuple[0], (Integer) tuple[2],
					(Integer) tuple[1], (Integer) tuple[3], (Integer) tuple[4]);
			Address address = new Address((String) tuple[5], (String) tuple[6],
					(String) tuple[7]);
			map.put("Room", room);
			map.put("Address", address);
			maps.put(i, map);
			i++;
		}
		session.getTransaction().commit();
		session.close();
		return maps;
	}

	// ------------13查看未删房间个数-----------------------------
	public int GetRoomNumberNoDel() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count = 0;
		try {
			count = ((Long) session.createQuery(
					"select count(RoomId) from Room where RoomLockState!=-1")
					.iterate().next()).intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) count;
	}

	//分页
	public List<Integer> queryRoomByAddressWithoutPage(int addressid,
			String RoomDetailAddress) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "select Room.roomId from Room ,Address  where Room.roomLockState!=-1 and Room.addressId=Address.addressId and Room.addressId = ? and Room.roomDetailAddress like '%"
				+ RoomDetailAddress + "%'";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, addressid);
		List<Integer> rooms = query.list();
		session.getTransaction().commit();
		session.close();
		return rooms;
	}

	// --------------14.通过地区和详细地址、page信息查询房间-----------
	public LinkedMap QueryRoomByAddress(int addressid,
			String RoomDetailAddress, int page) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "select r1.roomId,r1.roomType,r1.roomUnitPrice,r1.roomUsingState,r1.roomLockState,a1.addressProvince,a1.addressCity,a1.addressVillage from com.Entity.Room as r1,com.Entity.Address as a1 where r1.roomLockState!=-1 and r1.addressId=a1.addressId and r1.addressId = ? and r1.roomDetailAddress like '%"
				+ RoomDetailAddress + "%' order by r1.roomId asc";
		Query query = session.createQuery(sql);
		query.setParameter(0, addressid);
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List findResult = query.list();
		Iterator it = findResult.iterator();
		LinkedMap maps = new LinkedMap();
		int i = 0;
		while (it.hasNext()) {
			Object[] tuple = (Object[]) it.next();
			LinkedMap map = new LinkedMap();
			Room room = new Room((Integer) tuple[0], (Integer) tuple[2],
					(Integer) tuple[1], (Integer) tuple[3], (Integer) tuple[4]);
			Address address = new Address((String) tuple[5], (String) tuple[6],
					(String) tuple[7]);

			map.put("Room", room);
			map.put("Address", address);
			maps.put(i, map);
			i++;
		}
		session.getTransaction().commit();
		session.close();
		return maps;
	}

	// ---------------15.通过地区和详细地址信息查询房间数量------------
	public int GetRoomNumberByAddress(int AddressId, String RoomDetailAddress) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int count = 0;
		try {
			count = ((Long) session
					.createQuery(
							"select count(RoomId) from Room where AddressId=? and RoomDetailAddress like '%"
									+ RoomDetailAddress
									+ "%' and RoomLockState != -1 ")
					.setParameter(0, AddressId).iterate().next()).intValue();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) count;
	}

	// ---------------16.查询某地区剩余房间的信息------------
	// 根据参数village的值, 来查询这个地区的剩下的房间
	// 在Room 和 Address表中进行查询
	public List<Room> GetLeftRoomInfoByAddress(String village) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			String hql = "SELECT * from room where roomusingstate=1 and roomLockState=1 and addressId  = (select addressid from address where addressVillage like '%" + village +"%')";
			Query query = session.createSQLQuery(hql).addEntity(Room.class);
			rooms = query.list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;

	}

	// ----------查找所有房间-----------
	@SuppressWarnings("unchecked")
	public List<Room> QueryAllRoom() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		rooms = session.createQuery("from Room").list();
		session.getTransaction().commit();
		return rooms;
	}

	// 根据房间类型查找房间
	public List<Room> QueryRoomByRoomtype(int roomtype) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			Query query1;
			query1 = session.createSQLQuery(
					"select * from Room where RoomType=" + roomtype).addEntity(
					Room.class);
			rooms = (List<Room>) query1.list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rooms;
	}
	
	
	//2016-01-09 多条件查询房间
	public List<Room> QueryRoomselectcondition(String village,String indata,String outdata,int minprice,int maxprice){
		List<Room> room=new ArrayList<Room>();	
		
	    try {
	    	 Session session=HibernateUtil.getSession();
			 session.beginTransaction();
			 
			 //根据地区查询房间
			 String hql="select Room.* from Room where AddressId in (select AddressId from Address where AddressVillage like '%"+village+"%')";

			 //并上日期的条件查询房间
			 if(!"".equals(indata)&&!"".equals(outdata)){
				 hql=hql+" and roomid not IN(SELECT roomid from ordertable where ((OrderCheckinTime between '"+indata+"' and '"+outdata+"') and (OrderCheckoutTime between '"+indata+"' and '"+outdata+"')) OR (('"+indata+"' BETWEEN OrderCheckinTime and OrderCheckoutTime) AND ('"+outdata+"' BETWEEN OrderCheckinTime and OrderCheckoutTime)))";
			 }
			 
			 //再并上金额的条件差选房间
			 if((minprice>=0)&&(maxprice>=0)){
				 hql=hql+" and RoomUnitPrice between "+minprice+" and "+maxprice+"";
			 }
			 
		     System.out.println(hql);
			 Query query=session.createSQLQuery(hql).addEntity(Room.class);
			 room=query.list();
			 HibernateUtil.closeSession();
	    }catch (Exception e) {
	    	e.printStackTrace();
		}
	    
	    return room;
	}
	
	
}
