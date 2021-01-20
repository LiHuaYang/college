package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Economics {
	private int economicsId;// �ʽ�ID
	private float economicsSum;// �ʽ��ܶ�
	private int economicsBelongType;// �ʽ���������
	private int economicsBelongId;// �ʽ�����ID
	public Economics(){};
	@Id
	@GeneratedValue
	public int getEconomicsId() {
		return economicsId;
	}

	public void setEconomicsId(int economicsId) {
		this.economicsId = economicsId;
	}

	public float getEconomicsSum() {
		return economicsSum;
	}

	public void setEconomicsSum(float economicsSum) {
		this.economicsSum = economicsSum;
	}

	public int getEconomicsBelongType() {
		return economicsBelongType;
	}

	public void setEconomicsBelongType(int economicsBelongType) {
		this.economicsBelongType = economicsBelongType;
	}

	public int getEconomicsBelongId() {
		return economicsBelongId;
	}

	public void setEconomicsBelongId(int economicsBelongId) {
		this.economicsBelongId = economicsBelongId;
	}

	@Override
	public String toString() {
		return "Economics [economicsBelongId=" + economicsBelongId
				+ ", economicsBelongType=" + economicsBelongType
				+ ", economicsId=" + economicsId + ", economicsSum="
				+ economicsSum + "]";
	}

}
