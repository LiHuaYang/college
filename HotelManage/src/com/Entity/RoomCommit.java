package com.Entity;

import java.util.HashMap;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoomCommit {
	private	String	RoomCommitTime;//	评价时间
	private	String	RoomCommitContent;//	评价内容
	private	int	RoomCommitRank;//	评价星级
	private	int	UserId;//	客户号
	private	int	RoomId;//	房间号
	private	int	RoomcommitId;//	房间评价号
	
	
	public RoomCommit(){};
	public RoomCommit(int RoomId, int UserId, String RoomCommitContent, int RoomCommitRank){
		this.RoomId = RoomId;
		this.UserId = UserId;
		
		this.RoomCommitContent = RoomCommitContent;
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.RoomCommitTime=s.format( new Date());

		this.RoomCommitRank = RoomCommitRank;
	}
	
	public HashMap<String,Object> toHashMap(){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("RoomcommitId", this.RoomcommitId);
		map.put("UserId", this.UserId);
		map.put("RoomCommitContent", this.RoomCommitContent);
		map.put("RoomCommitTime", this.RoomCommitTime);
		map.put("RoomCommitRank", this.RoomCommitRank);
		map.put("UserId", this.UserId);
		return map;
	}


	public String getRoomCommitTime() {
		return RoomCommitTime;
	}

	public void setRoomCommitTime(String roomCommitTime) {
		RoomCommitTime = roomCommitTime;
	}

	public String getRoomCommitContent() {
		return RoomCommitContent;
	}

	public void setRoomCommitContent(String roomCommitContent) {
		RoomCommitContent = roomCommitContent;
	}

	public int getRoomCommitRank() {
		return RoomCommitRank;
	}

	public void setRoomCommitRank(int roomCommitRank) {
		RoomCommitRank = roomCommitRank;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getRoomId() {
		return RoomId;
	}

	public void setRoomId(int roomId) {
		RoomId = roomId;
	}
	@Id
	@GeneratedValue
	public int getRoomcommitId() {
		return RoomcommitId;
	}

	public void setRoomcommitId(int roomcommitId) {
		RoomcommitId = roomcommitId;
	}

	@Override
	public String toString() {
		return "RoomCommit [RoomCommitContent=" + RoomCommitContent
				+ ", RoomCommitRank=" + RoomCommitRank + ", RoomCommitTime="
				+ RoomCommitTime + ", RoomId=" + RoomId + ", RoomcommitId="
				+ RoomcommitId + ", UserId=" + UserId + "]";
	};
	
	
}
