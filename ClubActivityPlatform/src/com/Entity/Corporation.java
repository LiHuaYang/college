package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Corporation {
	private int corporationId;// 社团ID
	private String corporationName;// 社团名称
	private int corporationBelongId;// 所属组织
	private String corporationIntroduction;// 社团主题
	private String corporationPic;// 社团图片路径
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
