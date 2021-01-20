package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Economicsrecord {
	private int economicsRecordId;// 资金记录ID
	private int economicsId;// 资金ID
	private int economicsRecordType;// 资金状态
	private float economicsRecordSize;// 资金额度
	private String economicsrecordTime;// 资金记录时间
	private String economicsrecordDescription;// 资金描述
	public Economicsrecord(){};
	
	@Id
	@GeneratedValue
	public int getEconomicsRecordId() {
		return economicsRecordId;
	}

	public void setEconomicsRecordId(int economicsRecordId) {
		this.economicsRecordId = economicsRecordId;
	}

	public int getEconomicsId() {
		return economicsId;
	}

	public void setEconomicsId(int economicsId) {
		this.economicsId = economicsId;
	}

	public int getEconomicsRecordType() {
		return economicsRecordType;
	}

	public void setEconomicsRecordType(int economicsRecordType) {
		this.economicsRecordType = economicsRecordType;
	}

	public float getEconomicsRecordSize() {
		return economicsRecordSize;
	}

	public void setEconomicsRecordSize(float economicsRecordSize) {
		this.economicsRecordSize = economicsRecordSize;
	}

	public String getEconomicsrecordTime() {
		return economicsrecordTime;
	}

	public void setEconomicsrecordTime(String economicsrecordTime) {
		this.economicsrecordTime = economicsrecordTime;
	}

	public String getEconomicsrecordDescription() {
		return economicsrecordDescription;
	}

	public void setEconomicsrecordDescription(String economicsrecordDescription) {
		this.economicsrecordDescription = economicsrecordDescription;
	}

	@Override
	public String toString() {
		return "Economicsrecord [economicsId=" + economicsId
				+ ", economicsRecordId=" + economicsRecordId
				+ ", economicsRecordSize=" + economicsRecordSize
				+ ", economicsRecordType=" + economicsRecordType
				+ ", economicsrecordDescription=" + economicsrecordDescription
				+ ", economicsrecordTime=" + economicsrecordTime + "]";
	}

}
