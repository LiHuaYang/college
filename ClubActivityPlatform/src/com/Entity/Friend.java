package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Friend {
	private int userId;// 用户ID
	private int friendId;// 好友ID
	private int friendRelationId;// 好友关联Id
	
	public Friend(){}
	public Friend(int userId,int friendId){
		this.userId=userId;
		this.friendId=friendId;
	}
	public void setFriendRelationId(int friendRelationId) {
		this.friendRelationId = friendRelationId;
	}

	@Id
	@GeneratedValue
	public int getFriendRelationId() {
		return friendRelationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", userId=" + userId + "]";
	}

}
