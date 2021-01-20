package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipmentrecord {
	private int equipmentrecordId;// ���ļ�¼ID
	private int equipmentId;// ����ID
	private String equipmentRecordDescription;// �����������
	private String equipmentRecordTime;// ���ļ�¼ʱ��

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
