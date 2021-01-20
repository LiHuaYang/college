package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipment {
	private int equipmentId;// Æ÷²ÄID
	private String equipmentName;// Æ÷²ÄÃû³Æ
	private float equipmentPrice;// Æ÷²Ä¼Û¸ñ
	private String equipmentContent;// Æ÷²Ä½éÉÜ
	private int equipmentType;// Æ÷²Ä×´Ì¬
	private int equipmentBelongType;// Æ÷²ÄËùÊôÀàÐÍ
	private int equipmentBelongId;// Æ÷²ÄËùÊôID
	private String equipmentPic;// Æ÷²ÄÍ¼Æ¬Â·¾¶

	public Equipment(){};
	@Id
	@GeneratedValue
	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public float getEquipmentPrice() {
		return equipmentPrice;
	}

	public void setEquipmentPrice(float equipmentPrice) {
		this.equipmentPrice = equipmentPrice;
	}

	public String getEquipmentContent() {
		return equipmentContent;
	}

	public void setEquipmentContent(String equipmentContent) {
		this.equipmentContent = equipmentContent;
	}

	public int getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(int equipmentType) {
		this.equipmentType = equipmentType;
	}

	public int getEquipmentBelongType() {
		return equipmentBelongType;
	}

	public void setEquipmentBelongType(int equipmentBelongType) {
		this.equipmentBelongType = equipmentBelongType;
	}

	public int getEquipmentBelongId() {
		return equipmentBelongId;
	}

	public void setEquipmentBelongId(int equipmentBelongId) {
		this.equipmentBelongId = equipmentBelongId;
	}

	public String getEquipmentPic() {
		return equipmentPic;
	}

	public void setEquipmentPic(String equipmentPic) {
		this.equipmentPic = equipmentPic;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentBelongId=" + equipmentBelongId
				+ ", equipmentBelongType=" + equipmentBelongType
				+ ", equipmentContent=" + equipmentContent + ", equipmentId="
				+ equipmentId + ", equipmentName=" + equipmentName
				+ ", equipmentPic=" + equipmentPic + ", equipmentPrice="
				+ equipmentPrice + ", equipmentType=" + equipmentType + "]";
	}

}
