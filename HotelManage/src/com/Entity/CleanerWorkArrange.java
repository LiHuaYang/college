package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CleanerWorkArrange {
	private	int	CleanerWorkId	;//	工作安排号
	private	int	CleanerWorkState	;//	工作是否完成0：未完成、1：已完成
	private	int	RoomId	;//	房间号
	private	int	CleanerId;//	清洁员号
	
	public CleanerWorkArrange(){};
	
	public CleanerWorkArrange(int CleanerWorkId, int 	CleanerWorkState,int	RoomId,int	UserId, int CleanerId){
		this.CleanerWorkId=CleanerWorkId;
	}
	public CleanerWorkArrange(int CleanerWorkState,int RoomId,int CleanerId){
		this.CleanerWorkState=0;
		this.RoomId=RoomId;
		this.CleanerId=CleanerId;
	};
	public CleanerWorkArrange(int	CleanerWorkState,int	RoomId,int	UserId, int CleanerId){
		this.CleanerWorkId=CleanerWorkId;
		this.CleanerWorkState=0;
		this.RoomId=RoomId;
		this.CleanerId=CleanerId;
	};
	@Id
	@GeneratedValue
	public int getCleanerWorkId() {
		return CleanerWorkId;
	}
	public void setCleanerWorkId(int cleanerWorkId) {
		CleanerWorkId = cleanerWorkId;
	}
	public int getCleanerWorkState() {
		return CleanerWorkState;
	}
	public void setCleanerWorkState(int cleanerWorkState) {
		CleanerWorkState = cleanerWorkState;
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
		return "CleanerWorkArrange [CleanerWorkId=" + CleanerWorkId
				+ ", CleanerWorkState=" + CleanerWorkState + ", RoomId="
				+ RoomId + ", CleanerId=" + CleanerId + "]";
	}

}
