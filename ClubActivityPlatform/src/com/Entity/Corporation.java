package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Corporation {
	private int corporationId;// ����ID
	private String corporationName;// ��������
	private int corporationBelongId;// ������֯
	private String corporationIntroduction;// ��������
	private String corporationPic;// ����ͼƬ·��
	public Corporation(){};
	@Id
	@GeneratedValue
	public int getCorporationId() {
		return corporationId;
	}

	public void setCorporationId(int corporationId) {
		this.corporationId = corporationId;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public int getCorporationBelongId() {
		return corporationBelongId;
	}

	public void setCorporationBelongId(int corporationBelongId) {
		this.corporationBelongId = corporationBelongId;
	}

	public String getCorporationIntroduction() {
		return corporationIntroduction;
	}

	public void setCorporationIntroduction(String corporationIntroduction) {
		this.corporationIntroduction = corporationIntroduction;
	}

	public String getCorporationPic() {
		return corporationPic;
	}

	public void setCorporationPic(String corporationPic) {
		this.corporationPic = corporationPic;
	}

	@Override
	public String toString() {
		return "Corporation [corporationBelongId=" + corporationBelongId
				+ ", corporationId=" + corporationId
				+ ", corporationIntroduction=" + corporationIntroduction
				+ ", corporationName=" + corporationName + ", corporationPic="
				+ corporationPic + "]";
	}

}
