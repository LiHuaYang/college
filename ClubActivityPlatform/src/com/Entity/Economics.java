package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Economics {
	private int economicsId;// 资金ID
	private float economicsSum;// 资金总额
	private int economicsBelongType;// 资金所属类型
	private int economicsBelongId;// 资金所属ID
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
