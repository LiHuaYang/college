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
	 *���ߣ�movie
	 *ʱ�䣺2015-12-27����04:13:45
	 *��������queryapplyfriend
	 *���ܣ������û��ĺ�������
	 *������@param userId
	 *������@return 
	 *����ֵ��List<Friend>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-12-27����04:16:07
	 *��������applyFriend
	 *���ܣ������������
	 *������@param friend
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-12-27����04:41:27
	 *��������tobeFriend
	 *���ܣ���Ϊ����
	 *������@param userId
	 *������@param friendId
	 *������@return 
	 *����ֵ��boolean
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
	 *���ߣ�movie
	 *ʱ�䣺2015-12-27����04:54:18
	 *��������refuseTobeFriend
	 *���ܣ��ܾ� ��Ϊ����
	 *������@param userId
	 *������@param friendId
	 *������@return 
	 *����ֵ��boolean
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
