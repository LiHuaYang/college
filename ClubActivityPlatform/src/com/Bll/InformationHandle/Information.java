package com.Bll.InformationHandle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Information {
	private int ReceiverId;
	private String InformationContent;
	private String SendDate;
	
	public Information( int ReceiverId,String InformationContent) {
		this.ReceiverId=ReceiverId;
		this.InformationContent=InformationContent;
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.SendDate = simpleDateFormat.format(date);
		
	}
	
	

	public int getReceiverId() {
		return ReceiverId;
	}



	public String getInformationContent() {
		return InformationContent;
	}



	public String getSendDate() {
		return SendDate;
	}



	@Override
	public String toString() {
		return "Information [InformationContent=" + InformationContent
				+ ", ReceiverId=" + ReceiverId + ", SendDate=" + SendDate + "]";
	}
	







	
}
