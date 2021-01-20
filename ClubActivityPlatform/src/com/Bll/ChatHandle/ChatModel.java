package com.Bll.ChatHandle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.Tool.MyConstant.chatbelongType;

public class ChatModel {
	private List<Chat> oldchats=new ArrayList<Chat>();//������������Ϣ��Ⱥ����Ϣ
	private List<Chat> newchats=new ArrayList<Chat>();//������������Ϣ
	/**
	 * 
	 *���ߣ�movie
	 *ʱ�䣺2015-10-21����11:07:39
	 *��������QueryPeopleChats
	 *���ܣ���ѯ�û��������
	 *������@param CreateId
	 *������@param ReciverId
	 *������@return 
	 *����ֵ��List<Chat>
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
        //�����o1��o2����list���������������Ȼ��������������������������
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-21����11:11:58
	 *��������QueryManyPeopleChats
	 *���ܣ���ѯȺ��
	 *������@param ReciverId
	 *������@return 
	 *����ֵ��List<Chat>
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-21����02:45:55
	 *��������QueryPeopleNewChats
	 *���ܣ���ѯ��������������Ϣ������1,2,3,4�ķ�����Id
	 *������@param ReciverId
	 *������@return 
	 *����ֵ��String
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
	 *���ߣ�movie
	 *ʱ�䣺2015-10-21����02:52:16
	 *��������SendChat
	 *���ܣ�����������Ϣ
	 *������@param chat
	 *������@return 
	 *����ֵ��boolean
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
