package com.Bll.ChatHandle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.Tool.MyConstant.chatbelongType;

public class ChatModel {
	private List<Chat> oldchats=new ArrayList<Chat>();//个人聊天老信息，群聊消息
	private List<Chat> newchats=new ArrayList<Chat>();//个人聊天新信息
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-21上午11:07:39
	 *函数名：QueryPeopleChats
	 *功能：查询用户间的聊天
	 *参数：@param CreateId
	 *参数：@param ReciverId
	 *参数：@return 
	 *返回值：List<Chat>
	 */

	public List<Chat> QueryPeopleChats(int CreateId,int ReciverId){
		List<Chat> recivechats=new ArrayList<Chat>();
		List<Chat> peoplechats1=new ArrayList<Chat>();
		for (int i = 0; i < newchats.size(); i++) {
			if (newchats.get(i).getChatbelongType()==chatbelongType.PEOPLE&&CreateId==newchats.get(i).getCreateId()&&ReciverId==newchats.get(i).getReciverId()) {
				recivechats.add(newchats.get(i));
				peoplechats1.add(newchats.get(i));
				
			}
			if (newchats.get(i).getChatbelongType()==chatbelongType.PEOPLE&&CreateId==newchats.get(i).getReciverId()&&ReciverId==newchats.get(i).getCreateId()) {
				peoplechats1.add(newchats.get(i));
			}
		}
		List<Chat> peoplechats2=new ArrayList<Chat>();
		for (int i = 0; i < oldchats.size(); i++) {
			if (oldchats.get(i).getChatbelongType()==chatbelongType.PEOPLE&&CreateId==oldchats.get(i).getCreateId()&&ReciverId==oldchats.get(i).getReciverId()) {
				peoplechats2.add(oldchats.get(i));
			}
			if (oldchats.get(i).getChatbelongType()==chatbelongType.PEOPLE&&ReciverId==oldchats.get(i).getCreateId()&&CreateId==oldchats.get(i).getReciverId()) {
				peoplechats2.add(oldchats.get(i));
			}
		}
		newchats.removeAll(recivechats);	
		oldchats.addAll(recivechats);
/*		System.out.println(newchats);
		System.out.println(oldchats);*/
		peoplechats2.addAll(peoplechats1);
		Collections.sort(peoplechats2, new MyComparator());
		return peoplechats2;
	}
    
    class MyComparator implements Comparator<Chat>
    {
        //这里的o1和o2就是list里任意的两个对象，然后按需求把这个方法填完整就行了
		public int compare(Chat o1, Chat o2) {
			
			  if ( o1.getChatTime()> o2.getChatTime()) {
					return 1;
				}else {
					return -1;
				}
		}
    }
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-21上午11:11:58
	 *函数名：QueryManyPeopleChats
	 *功能：查询群聊
	 *参数：@param ReciverId
	 *参数：@return 
	 *返回值：List<Chat>
	 */
	public List<Chat> QueryManyPeopleChats(int ReciverId){
		List<Chat> peoplechats=new ArrayList<Chat>();
		for (int i = 0; i < oldchats.size(); i++) {
			if (oldchats.get(i).getChatbelongType()==chatbelongType.MANYPEOPLE&&ReciverId==oldchats.get(i).getReciverId()){
				peoplechats.add(oldchats.get(i));
			}
		}
		return peoplechats;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-21下午02:45:55
	 *函数名：QueryPeopleNewChats
	 *功能：查询有无最新聊天消息，返回1,2,3,4的发送者Id
	 *参数：@param ReciverId
	 *参数：@return 
	 *返回值：String
	 */
	public String QueryPeopleNewChats(int ReciverId){
		String createrId="";
		for (int i = 0; i < newchats.size(); i++) {
			if (newchats.get(i).getChatbelongType()==chatbelongType.PEOPLE&&ReciverId==newchats.get(i).getReciverId()){
				createrId+=newchats.get(i).getCreateId()+",";
			}
		}
		if (createrId.length()!=0) {
			createrId=createrId.substring(0, createrId.length()-1);
		}
		
		return createrId;
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-21下午02:52:16
	 *函数名：SendChat
	 *功能：发送聊天消息
	 *参数：@param chat
	 *参数：@return 
	 *返回值：boolean
	 */
	public boolean SendChat(Chat chat){
		
		boolean result=false;
		if (chat.getChatbelongType()==chatbelongType.PEOPLE) {
			result=newchats.add(chat);
		}else {
			result=oldchats.add(chat);
		}
		
		return result;
	}
	
}
