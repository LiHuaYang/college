package com.AndroidBll;

import java.util.HashMap;
import java.util.List;
import com.Entity.Cleaner;
import com.Entity.CleaningRecord;
import com.Entity.OrderTable;
import com.Entity.Room;
import com.Entity.RoomCommit;
import com.Entity.RoomEquipment;
import com.Entity.User;
import com.Entity.UserCommit;

public interface IFrame {
	
	// ͨ��roomid������Room����
	public Room GetRoomDetail(int room_id);
	
	// �����µķ���
	public boolean CreateOrder(OrderTable oo);
	
	// ͨ��OrderId������Order
	public List<HashMap<String, Object>> GetOrderAndRoomByOrderId(int id);
	
	// ����Ա��½
	public List<Cleaner> CleanerLoginByPhone(String phone, String pwd);
	
	// ͨ�������ʹ��״̬����ѯ���䣬���ط����б�(���ڱ���Ա��ʾ�б�)
	public List<Room> GetRoomByRoomUsingState(int state);
	
	// ͨ����ׯ�����ҷ���
	public List<Room> GetRoomByAddressViilage(String address);
	
	// �û�ȡ������
	public boolean CancelOrder(int orderid, int userid);
	
	// �û����㶩��
	public boolean FinishOrder(int orderid, int userid, int roomid);
	
	// �û���������
	public boolean RenewOrder(int orderid, int daycount, int roomprice);
	
	// ����Ա��ȡ�Լ�������ķ��䣨����ɨ��
	public List<Room> PCleanerGetRoom(int cleanerid);
	
	// ����Ա��������ɨ�ķ���
	public boolean CleanerCommitRoom(RoomCommit roomcc);
	
	// ����Ա��ʼ��ɨ����--��������ͬʱ����CleaningRecord����һ����¼��
	public boolean CleanerCleaningStart(CleaningRecord cr);
	
	// ����Ա�鿴�Լ��Ĵ�ɨ��ʷ
	public List<CleaningRecord> CleanerQueryCleaningHistroy(int cleanerid);
	
	// ͨ���豸iD�������豸�б�
	public RoomEquipment GetRoomEquipmentsList(int id);
	
	public OrderTable GetOrderByOrderId(int orderid);
	
	// ����Ա�����û�
	public boolean CleanerCommitUser(UserCommit uc);
	
	// �û��鿴��������
	public List<HashMap<String, Object>> GetRoomCommitDetail(int roomid);
	
	// �û��鿴�������䣨ʣ��ģ�
	public List<HashMap<String, Object>> GetRoomList(String village);
	
	// �û���ȡ���������ķ���
	public List<Room> GetEligibleRoom(int roomtype, String village);
	
	//�ͻ�����
	public boolean CreateRoomCommit(RoomCommit roomCommit);
	
	//�û�ע��
	public boolean CreateUser(User user);
}
