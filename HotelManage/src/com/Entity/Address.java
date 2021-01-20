package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	private	String	AddressProvince	;//	省
	private	String	AddressCity	;//	市
	private	String	AddressVillage	;//	村
	private	int	RoomId	;//	房间号
	private int AddressId; //地区号
	private String AddressPicture;//地区图片
    public Address(){}
	
	public Address(String	AddressProvince,String	AddressCity,String	AddressVillage,int	RoomId,String AddressPicture){
		this.AddressProvince=AddressProvince;
		this.AddressCity=AddressCity;
		this.AddressVillage=AddressVillage;
		this.RoomId=RoomId;
		this.AddressPicture=AddressPicture;
	}

	public Address(String addressProvince, String addressCity,
			String addressVillage) {
		this.AddressProvince=addressProvince;
		this.AddressCity=addressCity;
		this.AddressVillage=addressVillage;
	}
	
//	public Address(String AddressProvince, String AddressCity,int RoomId,
//			String AddressVillage,int AddressId) {
//		this.
//		this.AddressId=AddressId;
//		this.AddressProvince=AddressProvince;
//		this.AddressCity=AddressCity;
//		this.AddressVillage=AddressVillage;
//	}

	public Address(String addressProvince, String addressCity,
		String addressVillage, int roomId, int addressId) {
	AddressProvince = addressProvince;
	AddressCity = addressCity;
	AddressVillage = addressVillage;
	RoomId = roomId;
	AddressId = addressId;
	}

	
	@Id
	@GeneratedValue
	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	

	public String getAddressPicture() {
		return AddressPicture;
	}


	public void setAddressPicture(String addressPicture) {
		AddressPicture = addressPicture;
	}
	public String getAddressCity() {
		return AddressCity;
	}

	public String getAddressProvince() {
		return AddressProvince;
	}

	public void setAddressProvince(String addressProvince) {
		AddressProvince = addressProvince;
	}

	public void setAddressCity(String addressCity) {
		AddressCity = addressCity;
	}

	public String getAddressVillage() {
		return AddressVillage;
	}

	public void setAddressVillage(String addressVillage) {
		AddressVillage = addressVillage;
	}

	public int getRoomId() {
		return RoomId;
	}

	public void setRoomId(int roomId) {
		RoomId = roomId;
	}


	@Override
	public String toString() {
		return "Address [AddressCity=" + AddressCity + ", AddressId="
				+ AddressId + ", AddressPicture=" + AddressPicture
				+ ", AddressProvince=" + AddressProvince + ", AddressVillage="
				+ AddressVillage + ", RoomId=" + RoomId + "]";
	}
	
}
