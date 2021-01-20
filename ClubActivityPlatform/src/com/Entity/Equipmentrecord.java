package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipmentrecord {
	private int equipmentrecordId;// Æ÷²Ä¼ÇÂ¼ID
	private int equipmentId;// Æ÷²ÄID
	private String equipmentRecordDescription;// Æ÷²ÄÇé¿öÃèÊö
	private String equipmentRecordTime;// Æ÷²Ä¼ÇÂ¼Ê±¼ä

	public Equipmentrecord(){}
	@Id
	@GeneratedValue
	public int getEquipmentrecordId() {
		return equipmentrecordId;
	}

	public void setEquipmentrecordId(int equipmentrecordId) {
		this.equipmentrecordId = equipmentrecordId;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentRecordDescription() {
		return equipmentRecordDescription;
	}

	public void setEquipmentRecordDescription(String equipmentRecordDescription) {
		this.equipmentRecordDescription = equipmentRecordDescription;
	}

	public String getEquipmentRecordTime() {
		return equipmentRecordTime;
	}

	public void setEquipmentRecordTime(String equipmentRecordTime) {
		this.equipmentRecordTime = equipmentRecordTime;
	}

	@Override
	public String toString() {
		return "Equipmentrecord [equipmentId=" + equipmentId
				+ ", equipmentRecordDescription=" + equipmentRecordDescription
				+ ", equipmentRecordTime=" + equipmentRecordTime
				+ ", equipmentrecordId=" + equipmentrecordId + "]";
	}

}
