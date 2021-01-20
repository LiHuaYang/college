package com.Bll.FriendHandle;

import java.util.ArrayList;
import java.util.List;

import com.Dao.DaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.Friend;

public class FriendModle {
	private List<Friend> friends=new ArrayList<Friend>();
	private IDaoFrame daoFrame=new DaoFrame();
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-27下午04:13:45
	 *函数名：queryapplyfriend
	 *功能：查找用户的好友申请
	 *参数：@param userId
	 *参数：@return 
	 *返回值：List<Friend>
	 */
	public List<Friend> queryApplyFriend(int userId){
		List<Friend> newFriends=new ArrayList<Friend>();
		for (int i = 0; i <friends.size(); i++) {
			if (friends.get(i).getFriendId()==userId) {
				newFriends.add(friends.get(i));
				
			}
		}
		return newFriends;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-27下午04:16:07
	 *函数名：applyFriend
	 *功能：发起好友申请
	 *参数：@param friend
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean applyFriend(Friend friend){
		boolean result=true;
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getFriendId()==friend.getFriendId()&&friends.get(i).getUserId()==friend.getUserId()) {
				result=false;
				break;
			}
		}
		if (result) {
			friends.add(friend);
		}
		return result;
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-27下午04:41:27
	 *函数名：tobeFriend
	 *功能：成为好友
	 *参数：@param userId
	 *参数：@param friendId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean tobeFriend(int userId,int friendId){
		boolean result=false;
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getFriendId()==userId&&friends.get(i).getUserId()==friendId) {
				daoFrame.CreateFriend(friends.get(i));
				friends.remove(i);
				result=true;
				break;
			}
		}
		return result;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-12-27下午04:54:18
	 *函数名：refuseTobeFriend
	 *功能：拒绝 成为好友
	 *参数：@param userId
	 *参数：@param friendId
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean refuseTobeFriend(int userId,int friendId){
		boolean result=false;
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getFriendId()==userId&&friends.get(i).getUserId()==friendId) {
				friends.remove(i);
				result=true;
				break;
			}
		}
		return result;
	}
}
