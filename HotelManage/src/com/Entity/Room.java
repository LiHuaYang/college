package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {
	private	int	RoomId	;//	房间id号
	private int RoomNumber;//房间命名号
	private int RoomEquipmentId; // 房间设备Id
	private	int	RoomUnitPrice	;//	单间房间价格
	private	int	RoomType	;//	房间类型
	private	int	RoomUsingState	;//	房间使用状态
	private	int	RoomLockState	;//	房间锁状态
	private	String	RoomLongitude	;//	房间经度
	private	String	RoomLatitude	;//	房间纬度
	private	String	RoomMassage	;//	房间描述
	private	String	RoomPassword	;//	房间密码
	private int AddressId; 				//地区id
	private String RoomDetailAddress; // 房间的详细信息
	private String RoomPicture;// 房间图片

	public Room(){};
	

	public Room(int roomId, int roomUnitPrice, int roomType,
			int roomUsingState, int roomLockState) {
		RoomId = roomId;
		RoomUnitPrice = roomUnitPrice;
		RoomType = roomType;
		RoomUsingState = roomUsingState;
		RoomLockState = roomLockState;
	}


	public Room(int RoomNumber,int	RoomUnitPrice,int	RoomType,int	RoomUsingState,
			int	RoomLockState,String RoomLongitude,String	RoomLatitude,String
			RoomMassage,String	RoomPassword, int RoomEquipmentId, String  RoomPicture,int AddressId, String RoomDetailAddress){
		this.RoomNumber=RoomNumber;
		this.RoomUnitPrice=RoomUnitPrice;
		this.RoomType=2;
		this.RoomUsingState=0;
		this.RoomLockState=RoomLockState;
		this.RoomLongitude=RoomLongitude;
		this.RoomLatitude=RoomLatitude;
		this.RoomMassage=RoomMassage;
		this.RoomPassword=RoomPassword;
		this.RoomEquipmentId=RoomEquipmentId;
		this.RoomPicture="img/room-img/jiangdong (3).jpg";
		this.AddressId=AddressId;
		this.RoomDetailAddress=RoomDetailAddress;
	}
	
	public Room(int RoomNumber,int	RoomUnitPrice,int	RoomType,int	RoomUsingState,
			int	RoomLockState,String RoomLongitude,String	RoomLatitude,String
			RoomMassage,String	RoomPassword, int RoomEquipmentId, String  RoomPicture,int AddressId, String RoomDetailAddress,int RoomId){
		this.RoomNumber=RoomNumber;
		this.RoomUnitPrice=RoomUnitPrice;
		this.RoomType=2;
		this.RoomUsingState=0;
		this.RoomLockState=RoomLockState;
		this.RoomLongitude=RoomLongitude;
		this.RoomLatitude=RoomLatitude;
		this.RoomMassage=RoomMassage;
		this.RoomPassword=RoomPassword;
		this.RoomEquipmentId=RoomEquipmentId;
		this.RoomPicture="img/room-img/jiangdong (3).jpg";
		this.AddressId=AddressId;
		this.RoomDetailAddress=RoomDetailAddress;
		this.RoomId=RoomId;
	}


		
	
	@Id
	@GeneratedValue
	public int getRoomId() {
		return RoomId;
	}

	public void setRoomId(int roomId) {
		RoomId = roomId;
	}

	public int getRoomEquipmentId() {
		return RoomEquipmentId;
	}

	public void setRoomEquipmentId(int roomEquipmentId) {
		RoomEquipmentId = roomEquipmentId;
	}

	public String getRoomPicture() {
		return RoomPicture;
	}
	public void setRoomPicture(String roomPicture) {
		RoomPicture = roomPicture;
	}

	
	public int getRoomNumber() {
		return RoomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}


	public int getRoomUnitPrice() {
		return RoomUnitPrice;
	}
	public void setRoomUnitPrice(int roomUnitPrice) {
		RoomUnitPrice = roomUnitPrice;
	}
	public int getRoomType() {
		return RoomType;
	}
	public void setRoomType(int roomType) {
		RoomType = roomType;
	}
	public int getRoomUsingState() {
		return RoomUsingState;
	}
	public void setRoomUsingState(int roomUsingState) {
		RoomUsingState = roomUsingState;
	}
	public int getRoomLockState() {
		return RoomLockState;
	}
	public void setRoomLockState(int roomLockState) {
		RoomLockState = roomLockState;
	}
	public String getRoomLongitude() {
		return RoomLongitude;
	}
	public void setRoomLongitude(String roomLongitude) {
		RoomLongitude = roomLongitude;
	}
	public String getRoomLatitude() {
		return RoomLatitude;
	}
	public void setRoomLatitude(String roomLatitude) {
		RoomLatitude = roomLatitude;
	}




	public String getRoomMassage() {
		return RoomMassage;
	}




	public void setRoomMassage(String roomMassage) {
		RoomMassage = roomMassage;
	}




	public String getRoomPassword() {
		return RoomPassword;
	}




	public void setRoomPassword(String roomPassword) {
		RoomPassword = roomPassword;
	}

	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	
	public String getRoomDetailAddress() {
		return RoomDetailAddress;
	}

	public void setRoomDetailAddress(String roomDetailAddress) {
		RoomDetailAddress = roomDetailAddress;
	}

	
	@Override
	public String toString() {
		return "Room [AddressId=" + AddressId + ", RoomDetailAddress="
				+ RoomDetailAddress + ", RoomEquipmentId=" + RoomEquipmentId
				+ ", RoomId=" + RoomId + ", RoomLatitude=" + RoomLatitude
				+ ", RoomLockState=" + RoomLockState + ", RoomLongitude="
				+ RoomLongitude + ", RoomMassage=" + RoomMassage
				+ ", RoomNumber=" + RoomNumber + ", RoomPassword="
				+ RoomPassword + ", RoomPicture=" + RoomPicture + ", RoomType="
				+ RoomType + ", RoomUnitPrice=" + RoomUnitPrice
				+ ", RoomUsingState=" + RoomUsingState + "]";
	}

	
	
}
