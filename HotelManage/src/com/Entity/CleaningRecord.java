package com.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CleaningRecord {
	private	int	CleaningId	;//	����¼��
	private	String	CleaningTime	;//	���ʱ��
	private	int	RoomId	;//	�����
	private	int	CleanerId	;//	���Ա��
	
	public CleaningRecord(){};
	public CleaningRecord( int CleanerId, int RoomId){
		this.CleanerId = CleanerId;
		// this.CleaningId = CleaningId;
		
		// this.CleaningTime = CleaningTime;
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.CleaningTime=s.format( new Date());
		
		this.RoomId = RoomId;
	}

	@Id
	@GeneratedValue
	public int getCleaningId() {
		return CleaningId;
	}
	public void setCleaningId(int cleaningId) {
		CleaningId = cleaningId;
	}
	public String getCleaningTime() {
		return CleaningTime;
	}
	public void setCleaningTime(String cleaningTime) {
		CleaningTime = cleaningTime;
	}
	public int getRoomId() {
		return RoomId;
	}
	public void setRoomId(int roomId) {
		RoomId = roomId;
	}
	
	public int getCleanerId() {
		return CleanerId;
	}
	public void setCleanerId(int cleanerId) {
		CleanerId = cleanerId;
	}
	@Override
	public String toString() {
		return "CleaningRecord [CleaningId=" + CleaningId + ", CleaningTime="
				+ CleaningTime + ", RoomId=" + RoomId + ", CleanerId=" + CleanerId
				+ "]";
	}

}
